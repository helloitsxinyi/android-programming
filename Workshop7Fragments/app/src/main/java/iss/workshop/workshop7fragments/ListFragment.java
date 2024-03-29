package iss.workshop.workshop7fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    Button mDetailBtn1;
    Button mDetailBtn2;
    Button mDetailBtn3;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mDetailBtn1 = view.findViewById(R.id.detail1Btn);
        mDetailBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sends in to interface method viewDetail
                viewDetail(1);
            }
        });

        mDetailBtn2 = view.findViewById(R.id.detail2Btn);
        mDetailBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetail(2);
            }
        });

        mDetailBtn3 = view.findViewById(R.id.detail3Btn);
        mDetailBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetail(3);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iListFragment = (IListFragment) context;
    }

    // implement interface method
    void viewDetail(int itemId) {
        iListFragment.viewDetail(itemId);
    }

    private IListFragment iListFragment;
    public interface IListFragment {
        void viewDetail(int itemId);
    }

}