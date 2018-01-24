package com.example.masha.studytracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masha on 24.01.2018.
 */

         public static class CloneHWs {
            private static CloneHWs sCloneHW;
            private static List<HW_list> mHWList;

            public class HW_list {
                private String hw_number;
                private String hw_date;


                public HW_list() {
                }

                public HW_list(String number, String date) {
                    this.hw_number = hw_number;
                    this.hw_date = hw_date;
                }

                public String getNumber_hw() {
                    return hw_number;
                }

                public void setNumber_hw(String number) {
                    this.hw_number = hw_number;
                }

                public String getDate_hw() {
                    return hw_date;
                }

                public void setDate_hw(String date) {
                    this.hw_date = hw_date;
                }

                private CloneHWs() {
                    mHWList = new ArrayList<>(100);

                    for (int i = 0; i < 100; i++) {
                        if(i % 2 == 0){
                            mHWList.add(new HW_list("Seminar #"+i, "02.10.2017" ));
                        }else{
                            mHWList.add(new HW_list("Seminar #"+i, "08.10.2017"));
                        }
                    }
                }
                public List<HW_list> getCloneList_hw() {
                    if (sCloneHW == null){
                        sCloneHW = new CloneHWs();
                    }
                    return mHWList;
                }
            }
        }
    }
}
