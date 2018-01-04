 package com.example.user.studytracker;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

 public class AddActivity extends AppCompatActivity {

     List<EventRule> lectureRules = new ArrayList<EventRule>();
     List<EventRule> exerciseRules = new ArrayList<EventRule>();
     List<EventRule> homeworkRules = new ArrayList<EventRule>();

     EventRule tes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Calendar cal = Calendar.getInstance();
        //TODO: LÖSCHEN!!
        EventRule test = new EventRule(true, cal, cal, 1, 1, 5, 1, 1, 1, 1);
        tes2 = new EventRule(true, cal, cal, 1, 7, 5, 1, 1, 1, 1);
        lectureRules.add(test);
        lectureRules.add(tes2);

        setContentView(R.layout.activity_add);
        buildContentView();







    }
    // navigates back when you press the back button in the menu
     @Override
     public boolean onSupportNavigateUp() {
         onBackPressed();
         return true;
     }

     public void buildContentView(){

        //change layout of lectures
         LinearLayout linLecture = findViewById(R.id.linLayoutLecture);
         for (int i=0; i<lectureRules.size(); i++){
             LinearLayout childlinLec = new LinearLayout(this);
             childlinLec.setOrientation(LinearLayout.HORIZONTAL);
             LinearLayout.LayoutParams cllparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
             childlinLec.setLayoutParams(cllparam);
             linLecture.addView(childlinLec);
             final Button btnEdit = new Button(this);
             btnEdit.setText("edit"); //TODO: change to display rule properly
             btnEdit.setTag(i);
             btnEdit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent= new Intent(getApplicationContext(), EditRulesActivity.class);
                     intent.putExtra("rule", lectureRules.get(Integer.valueOf(String.valueOf( btnEdit.getTag()))));
                     startActivity(intent);
                 }
             });
             TextView text = new TextView(this);
             text.setText("this gets repeated every"+lectureRules.get(i).increment+" days."); //TODO: change to display rule properly
             childlinLec.addView(btnEdit);
             childlinLec.addView(text);
         }
         Button btnNewLecture = new Button(this);
         btnNewLecture.setText("add new Rule"); //TODO: change to display rule properly
         btnNewLecture.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), EditRulesActivity.class);
                 intent.putExtra("number", 1);
                 startActivity(intent);
             }
         });
         linLecture.addView(btnNewLecture, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

         //change layout of exercises
         LinearLayout linExercise = findViewById(R.id.linLayoutExercise);
         for (int i=0; i<exerciseRules.size(); i++){
             LinearLayout childInexer = new LinearLayout(this);
             childInexer.setOrientation(LinearLayout.HORIZONTAL);
             LinearLayout.LayoutParams cllparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
             childInexer.setLayoutParams(cllparam);
             linExercise.addView(childInexer);
             final Button btnEdit = new Button(this);
             btnEdit.setTag(i);
             btnEdit.setText("edit"); //TODO: change to display rule properly
             btnEdit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent= new Intent(getApplicationContext(), EditRulesActivity.class);
                     intent.putExtra("rule", lectureRules.get(Integer.valueOf(String.valueOf( btnEdit.getTag()))));
                     startActivity(intent);
                 }
             });
             TextView text = new TextView(this);
             text.setText("this gets repeated every"+lectureRules.get(i).increment+" days."); //TODO: change to display rule properly
             childInexer.addView(btnEdit);
             childInexer.addView(text);
         }
         Button btnNewExercise = new Button(this);
         btnNewExercise.setText("add new Rule"); //TODO: change to display rule properly
         btnNewExercise.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), EditRulesActivity.class);
                 intent.putExtra("number", 2);
                 startActivity(intent);
             }
         });
         linExercise.addView(btnNewExercise, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


         //change layout of homework
         LinearLayout linHomework = findViewById(R.id.linLayoutHomework);
         for (int i=0; i<homeworkRules.size(); i++){
             LinearLayout childLinHomework = new LinearLayout(this);
             childLinHomework.setOrientation(LinearLayout.HORIZONTAL);
             LinearLayout.LayoutParams cllparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
             childLinHomework.setLayoutParams(cllparam);
             linHomework.addView(childLinHomework);
             final Button btnEdit = new Button(this);
             btnEdit.setTag(i);
             btnEdit.setText("edit"); //TODO: change to display rule properly
             btnEdit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent= new Intent(getApplicationContext(), EditRulesActivity.class);
                     intent.putExtra("rule", lectureRules.get(Integer.valueOf(String.valueOf( btnEdit.getTag()))));
                     startActivity(intent);
                 }
             });
             TextView text = new TextView(this);
             text.setText("this gets repeated every"+lectureRules.get(i).increment+" days."); //TODO: change to display rule properly
             childLinHomework.addView(btnEdit);
             childLinHomework.addView(text);
         }
         Button btnNewHomework = new Button(this);
         btnNewHomework.setText("add new Rule"); //TODO: change to display rule properly
         btnNewHomework.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), EditRulesActivity.class);
                 startActivity(intent);
                 intent.putExtra("number", 3);
             }
         });
         linHomework.addView(btnNewHomework, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

     }
}
