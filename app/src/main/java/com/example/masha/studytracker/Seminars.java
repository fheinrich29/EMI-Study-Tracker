package com.example.masha.studytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Seminars extends AppCompatActivity {

        private RecyclerView sRecyclerView;
        private RecyclerView.Adapter MyAdapterS;
        private RecyclerView.LayoutManager sLayoutManager;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lectures);
            sRecyclerView = (RecyclerView) findViewById(R.id.s_rv);


            sRecyclerView.setHasFixedSize(true);

            sLayoutManager = new LinearLayoutManager(this);
            sRecyclerView.setLayoutManager(sLayoutManager);

            //Add information to Seminars_data
            List<CloneSeminars.Seminars_list> lectureList = CloneLectures.getCloneList();//Warum??
            MyAdapterL adapter = new MyAdapterL(lectureList);

            sRecyclerView.setAdapter(adapter);
        }

        CardView s_cv;
        private TextView mSeminarsNumberTextView;
        private TextView mSeminarsDateTextView;
        private CloneSeminars.Seminars_list mSeminar;

        public LectureHolder(View itemView) {
            super(itemView);
            s_cv = (CardView)itemView.findViewById(R.id.s_cv);
            mSeminarsNumberTextView = (TextView) itemView.findViewById(R.id.s_number);
            mSeminarsDateTextView = (TextView) itemView.findViewById(R.id.s_date);
        }
        public void bindCrime(CloneSeminars.Seminars_list seminar) {
            mSeminar = seminar;
            mSeminarsNumberTextView.setText(mSeminar.getNumber());
            mSeminarsDateTextView.setText(mSeminar.getDate());
        }
    }
    public class MyAdapterL extends RecyclerView.Adapter<MyAdapterL.LectureHolder> {

        private class LectureHolder extends RecyclerView.ViewHolder{

            private List<CloneLectures.Lecture_list> mLectures;
            public MyAdapterS(List<CloneSeminars.Seminars_list> seminars) {
                mSeminars = seminars;

            public LectureHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater li_s = getLayoutInflater();
                View view = li_s.inflate(R.layout.item_lectures, parent, false);
                return new LectureHolder(view);
            }


            public void onBindViewHolder(CloneLectures.Lecture_list holder, int position) {
                CloneLectures.Lecture_list lecture = mLectures.get(position);
                holder.bindCrime(lecture);
            }

            public int getItemCount() {
                return mLectures.size();
            }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminars);
    }
}
