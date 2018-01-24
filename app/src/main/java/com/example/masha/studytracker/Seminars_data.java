package com.example.masha.studytracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masha on 24.01.2018.
 */

    public class CloneSeminars {
        private static CloneSeminars sCloneSeminars;
        private static List<Seminar_list> mSeminarList;

        public class Seminar_list {
            private String s_number;
            private String s_date;


            public Seminar_list() {
            }

            public Seminar_list(String number, String date, ) {
                this.s_number = s_number;
                this.s_date = s_date;
            }

            public String getNumber_s() {
                return s_number;
            }

            public void setNumber_s(String number) {
                this.s_number = s_number;
            }

            public String getDate_s() {
                return s_date;
            }

            public void setDate_s(String date) {
                this.s_date = s_date;
            }

            private CloneSeminars() {
                mSeminarList = new ArrayList<>(100);

                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        mSeminarList.add(new Seminar_list("Seminar #"+i, "02.10.2017" ));
                    }else{
                        mSeminarList.add(new Seminar_list("Seminar #"+i, "08.10.2017"));
                    }
                }
            }
            public static List<Seminar_list> getCloneList_s() {
                if (sCloneSeminars == null){
                    sCloneSeminars = new CloneSeminars();
                }
                return mSeminarList;
            }
        }
    }
}
