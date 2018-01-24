package com.example.masha.studytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Lectures extends AppCompatActivity {

    private RecyclerView lRecyclerView;
    private RecyclerView.Adapter MyAdapterL;
    private RecyclerView.LayoutManager lLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);
        lRecyclerView = (RecyclerView) findViewById(R.id.l_rv);


        lRecyclerView.setHasFixedSize(true);

        lLayoutManager = new LinearLayoutManager(this);
        lRecyclerView.setLayoutManager(lLayoutManager);

        List<CloneLectures.Lecture_list> lectureList = CloneLectures.getCloneList();
        MyAdapterL adapter = new MyAdapterL(lectureList);

        lRecyclerView.setAdapter(adapter);
    }

        CardView l_cv;
        private TextView mLecturesNumberTextView;
        private TextView mLecturesDateTextView;
        private CloneLectures.Lecture_list mLecture;

        public LectureHolder(View itemView) {
            super(itemView);
            l_cv = (CardView)itemView.findViewById(R.id.l_cv);
            mLecturesNumberTextView = (TextView) itemView.findViewById(R.id.l_number);
            mLecturesDateTextView = (TextView) itemView.findViewById(R.id.l_date);
        }
        public void bindCrime(CloneLectures.Lecture_list lecture) {
            mLecture = lecture;
            mLecturesNumberTextView.setText(mLecture.getNumber());
            mLecturesDateTextView.setText(mLecture.getDate());
        }
    }
    public class MyAdapterL extends RecyclerView.Adapter<MyAdapterL.LectureHolder> {

    private class LectureHolder extends RecyclerView.ViewHolder{


        private List<CloneLectures.Lecture_list> mLectures;
        public MyAdapterL(List<CloneLectures.Lecture_list> lectures) {
            mLectures = lectures;

        public LectureHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = getLayoutInflater();
            View view = li.inflate(R.layout.item_lectures, parent, false);
            return new LectureHolder(view);
        }


        public void onBindViewHolder(CloneLectures.Lecture_list holder, int position) {
            CloneLectures.Lecture_list lecture = mLectures.get(position);
            holder.bindCrime(lecture);
        }

        public int getItemCount() {
            return mLectures.size();
        }
    }
    }
    }
