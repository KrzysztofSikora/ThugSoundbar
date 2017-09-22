package pl.krzysztofsikora.thugsoundbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static pl.krzysztofsikora.thugsoundbar.R.id.toolbar;


public class Tab3Back extends Fragment {

    View rootView;
    private Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab3online, container, false);
        mContext = container.getContext();




        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        //set toolbar appearance
//        toolbar.setBackground(R.color.);

        //for crate home button
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        return rootView;
    }





}
