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
        List<Seminars_data.CloneSeminars.Seminar_list> seminars_lists = Seminars_data.CloneSeminars.getCloneList_s();//Warum??
        MyAdapterS adapter_s = new MyAdapterS(seminars_lists);

        sRecyclerView.setAdapter(adapter_s);
    }

        CardView s_cv;
        private TextView mSeminarsNumberTextView;
        private TextView mSeminarsDateTextView;
        private Seminars_data.CloneSeminars.Seminar_list mSeminar;

        public SeminarHolder(View itemView) {
            super(itemView);
            s_cv = (CardView)itemView.findViewById(R.id.s_cv);
            mSeminarsNumberTextView = (TextView) itemView.findViewById(R.id.s_number);
            mSeminarsDateTextView = (TextView) itemView.findViewById(R.id.s_date);
        }
        public void bindCrime(Seminars_data.CloneSeminars.Seminar_list seminar) {
            mSeminar = seminar;
            mSeminarsNumberTextView.setText(mSeminar.getNumber_s());
            mSeminarsDateTextView.setText(mSeminar.getDate_s());
        }
    }
    public class MyAdapterS extends RecyclerView.Adapter<MyAdapterS.SeminarHolder> {

        private class SeminarHolder extends RecyclerView.ViewHolder{

            private List<Seminars_data.CloneSeminars.Seminar_list> mSeminars;
            public MyAdapterS(List<Seminars_data.CloneSeminars.Seminar_list> seminars) {
                mSeminars = seminars;

            public SeminarHolder onCreateViewHolder_s(ViewGroup parent, int viewType) {
                LayoutInflater li_s = getLayoutInflater();
                View view = li_s.inflate(R.layout.item_lectures, parent, false);
                return new SeminarHolder(view);
            }


            public void onBindViewHolder_s(Seminars_data.CloneSeminars holder, int position) {
                Seminars_data.CloneSeminars.Seminar_list seminar = mSeminars.get(position);
                holder.bindCrime(seminar);
            }

            public int getItemCount() {
                return mSeminars.size();
            }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminars);
    }
}
