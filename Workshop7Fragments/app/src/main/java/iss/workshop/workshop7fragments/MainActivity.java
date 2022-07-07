package iss.workshop.workshop7fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.IListFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // get data and set it here.
    @Override
    public void viewDetail(int itemId) {
        startDetailActivity(itemId);
    }

    public void startDetailActivity(int newItemId) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemId", newItemId);
        startActivity(intent);
    }
}