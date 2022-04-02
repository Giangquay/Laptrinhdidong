package com.example.layout1.DataPickTime;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.layout1.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DataTimeActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1,ed2;
    protected void getViewID()
    {
        ed1=findViewById(R.id.eTime);
        ed2=findViewById(R.id.eDate);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_time);
        getViewID();
        ed1.setOnClickListener(this);
        ed2.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        if(view==ed1)
        {
            //Cach2
            LocalDateTime ob = LocalDateTime.now();
            DateTimeFormatter tg = DateTimeFormatter.ofPattern("HH:mm:ss");
            int mmm=ob.getMinute();
            int hhh=ob.getHour();
            //Cach1
            Calendar  c =Calendar.getInstance();
            int hh=c.get(Calendar.HOUR_OF_DAY);
            int mm=c.get(Calendar.MINUTE);
           TimePickerDialog time = new TimePickerDialog(DataTimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
               @Override
               public void onTimeSet(TimePicker timePicker, int h, int m) {
                ed1.setText(h+":"+m);
               }
           },hhh,mmm,false);
           time.show();
        }
        if (view==ed2)
        {
            Calendar c =Calendar.getInstance();
            int y=c.get(Calendar.YEAR);
            int m=c.get(Calendar.MONTH);
            int d=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog time = new DatePickerDialog(DataTimeActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                    ed2.setText(dd+"\\"+(mm+1)+"\\"+yy);
                }
            },y,m,d);
            time.show();
        }
    }
}