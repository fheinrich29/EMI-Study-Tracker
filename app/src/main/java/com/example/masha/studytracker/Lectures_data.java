package com.example.masha.studytracker; /**
 * Created by Masha on 24.01.2018.
 */

    import java.util.ArrayList;
    import java.util.List;

    public class CloneLectures {
    private static CloneLectures sCloneLectures;
    private static List<Lecture_list> mLectureList;

         public class Lecture_list {
             private String l_number;
             private String l_date;


             public Lecture_list() {
                              }

             public Lecture_list(String number, String date) {
                 this.l_number = l_number;
                 this.l_date = l_date;
             }

             public String getNumber() {
                 return l_number;
             }

             public void setNumber(String number) {
                 this.l_number = l_number;
             }

             public String getDate() {
                 return l_date;
             }

             public void setDate(String date) {
                 this.l_date = l_date;
             }

             private CloneLectures() {
                 mLectureList = new ArrayList<>(100);

                 for (int i = 0; i < 100; i++) {
                     if(i % 2 == 0){
                         mLectureList.add(new Lecture_list("Lecture #"+i, "01.10.2017" ));
                     }else{
                         mLectureList.add(new Lecture_list("Lecture #"+i, "07.10.2017"));
                     }
                 }
             }
             public static List<Lecture_list> getCloneList() {
                 if (sCloneLectures == null){
                     sCloneLectures = new CloneLectures();
                 }
                 return mLectureList;
             }
    }
}
