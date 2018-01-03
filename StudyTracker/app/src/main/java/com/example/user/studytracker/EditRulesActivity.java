package com.example.user.studytracker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static java.util.Calendar.HOUR;

public class EditRulesActivity extends AppCompatActivity{

    private EditText fromDateEdit;
    private EditText toDateEdit;
    private EditText dayOfWeekEdit;
    private EditText startTimeEdtit;
    private EditText endTimeEdit;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat timeFormatter;
    private TimePickerDialog startTimeDialog;
    private TimePickerDialog endTimeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rules);

        Toolbar myToolbar = findViewById(R.id.toolbar_editRules);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        dateFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
        timeFormatter = new SimpleDateFormat("hh:mm", Locale.GERMANY);

        fromDateEdit = (EditText) findViewById(R.id.fromDate);
        fromDateEdit.setInputType(InputType.TYPE_NULL);
        fromDateEdit.requestFocus();

        dayOfWeekEdit = findViewById(R.id.edit_dayOfWeek);
        dayOfWeekEdit.setInputType(InputType.TYPE_NULL);

        startTimeEdtit = findViewById(R.id.edit_startTime);
        startTimeEdtit.setInputType(InputType.TYPE_NULL);

        endTimeEdit = findViewById(R.id.edit_endTime);
        endTimeEdit.setInputType(InputType.TYPE_NULL);

        toDateEdit = (EditText) findViewById(R.id.toDate);
        toDateEdit.setInputType(InputType.TYPE_NULL);

        setEdittextData();
    }


    private void setEdittextData() {
        fromDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromDatePickerDialog.show();
            }
        });
        toDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDatePickerDialog.show();
            }
        });

        dayOfWeekEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dayOfWeekDialog();
            }
        });

        startTimeEdtit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimeDialog.show();
            }
        });

        endTimeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endTimeDialog.show();
            }
        });

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEdit.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEdit.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        startTimeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar newTime = Calendar.getInstance();
                newTime.set(HOUR, hourOfDay);
                newTime.set(Calendar.MINUTE, minute);
                startTimeEdtit.setText(timeFormatter.format(newTime.getTime()));
            }

        },newCalendar.get(HOUR), newCalendar.get(Calendar.MINUTE), true);

        endTimeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar newTime = Calendar.getInstance();
                newTime.set(HOUR, hourOfDay);
                newTime.set(Calendar.MINUTE, minute);
                endTimeEdit.setText(timeFormatter.format(newTime.getTime()));
            }

        },newCalendar.get(HOUR), newCalendar.get(Calendar.MINUTE), true);


    }

    private void dayOfWeekDialog(){
        final Dialog d = new Dialog(this);
        d.setTitle("Choose day of week");
        d.setContentView(R.layout.dialog_numberpicker);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(7);
        np.setMinValue(1);
        final String[] weekDays = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        np.setDisplayedValues(weekDays);
        np.setWrapSelectorWheel(false);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                dayOfWeekEdit.setText(weekDays[np.getValue()-1]);
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();

    }
}
