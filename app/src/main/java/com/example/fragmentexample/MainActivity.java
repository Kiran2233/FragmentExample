package com.example.fragmentexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


public class MainActivity extends FragmentActivity implements MyListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getResources().getBoolean(R.bool.twoPaneMode)) {
            return;
        }
        if(savedInstanceState!=null){
            getSupportFragmentManager().executePendingTransactions();
            Fragment fragbyid = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if(fragbyid!=null){
                getSupportFragmentManager().beginTransaction().remove(fragbyid).commit();
            }

        }
        MyListFragment frg3 = new MyListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,frg3).commit();
    }

    @Override
    public void onRssItemSelected(String text) {
        if (getResources().getBoolean(R.bool.twoPaneMode)) {
            TitlesFragment fragment = (TitlesFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            fragment.setText(text);
        }
        else{
            TitlesFragment frag2 = new TitlesFragment();
            Bundle args = new Bundle();
            args.putString(TitlesFragment.EXTRA_TEXT,text);
            frag2.setArguments(args);
            FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,frag2);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
