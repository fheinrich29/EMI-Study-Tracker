package com.example.user.studytracker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LectureFragment extends Fragment {

    Button btnEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    // Inflates the layout for this fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_lecture, container, false);

        btnEdit = (Button) fragmentView.findViewById(R.id.button);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   goToEdit();
            }
        });
        return fragmentView;
    }

    public void goToEdit(){
        startActivity(new Intent(this.getActivity(), AddActivity.class));
    }
}

