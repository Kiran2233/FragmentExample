package com.example.fragmentexample;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TitlesFragment extends Fragment {

    public static final String EXTRA_TEXT ="text";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details,container,false);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle= getArguments();
        if (bundle != null) {
            String text = bundle.getString(EXTRA_TEXT);
            setText(text);
        }
    }
    public void setText(String text) {
        TextView view = getView().findViewById(R.id.detailsText);
        view.setText(text);
    }
}
