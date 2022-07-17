package iss.workshop.files;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final int APP_SPEC_INT = 1;
    private static final int APP_SPEC_EXT = 2;
    private static final int PUB_EXT = 3;

    EditText mInputTxt;
    Button mSaveBtn;
    Button mReadBtn;

    File mTargetFile;

    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 1;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputTxt = findViewById(R.id.inputTxt);

        mSaveBtn = findViewById(R.id.btnSave);
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int writeExtStrgPer = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (writeExtStrgPer == PackageManager.PERMISSION_GRANTED) {
                    writeToFile();
                } else {
                    String[] permissions = new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
                }

            }
        });

        mReadBtn = findViewById(R.id.btnRead);
        mReadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromFile();
            }
        });

        String filePath = "SampleFolder";
        String fileName = "SampleFile.txt";
        File publicPath = Environment.getExternalStorageDirectory();
        mTargetFile = new File(publicPath, filePath + "/" + fileName);
    }

    protected void writeToFile() {
        try {
            // Make sure that the parent folder exists
            File parent = mTargetFile.getParentFile();

            if (!parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException("Couldn't create dir: " + parent);
            }

            // Write to file
            FileOutputStream fos = new FileOutputStream(mTargetFile);
            fos.write(mInputTxt.getText().toString().getBytes());
            fos.close();

            mInputTxt.setText("");
            Toast.makeText(this, "Write file ok!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState);
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals((extStorageState));
    }

    protected void readFromFile() {
        String data = "";
        try {
            FileInputStream fis = new FileInputStream(mTargetFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                data = data + strLine;
            }
            in.close();

            mInputTxt.setText(data);

            Toast.makeText(this, "Read file ok!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
