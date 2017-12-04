package com.example.user.studytracker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by User on 29/11/2017.
 */

public class fragment1 extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedinstanceState){
        View result=inflater.inflate(R.layout.fragment1,container,false);
        return (result);
    }
    public  void onClick(View v){

    }
}
