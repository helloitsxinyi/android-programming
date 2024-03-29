package iss.workshop.workshop7fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    public DetailFragment() {
        // Required empty public constructor
    }

    private int itemId;
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    // dont need onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutRoot = inflater.inflate(R.layout.fragment_detail, container, false);
        return layoutRoot;
    }

    private IDetailFragment iDetailFragment;
    public interface IDetailFragment {
        void itemClicked(String content);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iDetailFragment = (IDetailFragment) context;
    }

    public void sendDataToActivity(String content) {
        iDetailFragment.itemClicked(content);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            itemId = bundle.getInt("itemId");
        }

        View view = getView();

        if (view != null) {
            DataItem item = DataService.getItem(itemId);
            TextView title = view.findViewById(R.id.textTitle);
            title.setText(item.getName());

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    iDetailFragment.itemClicked(textView.getText().toString());
                }
            });

            TextView desc = view.findViewById(R.id.textDescription);
            desc.setText(item.getDescription());
            desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    iDetailFragment.itemClicked(textView.getText().toString());
                }
            });
        }
    }






}