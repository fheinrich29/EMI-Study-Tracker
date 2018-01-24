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

public class homework extends AppCompatActivity {

        private RecyclerView hwRecyclerView;
        private RecyclerView.Adapter MyAdapterhw;
        private RecyclerView.LayoutManager hwLayoutManager;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_homework);
            hwRecyclerView = (RecyclerView) findViewById(R.id.hw_rv);


            hwRecyclerView.setHasFixedSize(true);

            hwLayoutManager = new LinearLayoutManager(this);
            hwRecyclerView.setLayoutManager(hwLayoutManager);

            //Add information to HW_data
            List<HW_data.CloneHWs> hw_lists = HW_data.CloneHWs.getCloneList_hw();//Why??
            MyAdapterhw adapter_hw = new MyAdapterhw(hw_lists);

            hwRecyclerView.setAdapter(adapter_hw);
        }

        CardView hw_cv;
        private TextView mHWNumberTextView;
        private TextView mHWDateTextView;
        private Seminars_data.CloneSeminars.Seminar_list mHW;

        public HWHolder(View itemView) {
            super(itemView);
            hw_cv = (CardView)itemView.findViewById(R.id.hw_cv);
            mHWNumberTextView = (TextView) itemView.findViewById(R.id.hw_number);
            mHWDateTextView = (TextView) itemView.findViewById(R.id.hw_date);
        }
        public void bindCrime(CloneHWs.HW_list HW) {
            mHW = HW;
            mHWNumberTextView.setText(mHW.getNumber_hw());
            mHWDateTextView.setText(mHW.getDate_hw());
        }
    }
    public class MyAdapterHW extends RecyclerView.Adapter<MyAdapterHW.HWHolder> {

        private class HWHolder extends RecyclerView.ViewHolder{

            private List<Seminars_data.CloneSeminars.Seminar_list> mHWs;
            public MyAdapterHW(List<Seminars_data.CloneSeminars.Seminar_list> HWs) {
                mHWs = HWs;

            public HWHolder onCreateViewHolder_hw(ViewGroup parent, int viewType) {
                LayoutInflater li_hw = getLayoutInflater();
                View view = li_hw.inflate(R.layout.item_lectures, parent, false);
                return new HWHolder(view);
            }


            public void onBindViewHolder_s(CloneLectures.Lecture_list holder, int position) {
                CloneLectures.Lecture_list lecture = mHW.get(position);
                holder.bindCrime(lecture);
            }

            public int getItemCount() {
                return mHWs.size();
            }
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_seminars);
            }
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
    }
}
