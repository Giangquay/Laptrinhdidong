package com.example.layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends Activity {
    private CheckBox ck1,ck2,ck3;
    private RadioButton trai,gai;
    private RatingBar danhgia;
    private TextView hienthi;
    private Button sub;
    private Spinner sp;
    protected void SpinnerCountry()
    {
        String [] list = getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,R.layout.item,list);
        sp.setAdapter(adapter1);
    }
    protected void getResourceID()
    {
        ck1=findViewById(R.id.android);
        ck2=findViewById(R.id.ios);
        ck3=findViewById(R.id.window);
        trai=findViewById(R.id.Nam);
        gai=findViewById(R.id.Nu);
        danhgia=findViewById(R.id.rate);
        hienthi=findViewById(R.id.Hienthi);
        sub=findViewById(R.id.sub);
        sp=findViewById(R.id.sp);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b1);
        getResourceID();
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpinnerCountry();
                String ss="";
                if(ck1.isChecked())
                {
                    ss+="Android";
                }
                if (ck2.isChecked())
                {
                    ss+="Ios";
                }
                if (ck3.isChecked())
                {
                    ss+="Window";
                }
                ss+="\n Gioi tinh";
                if(trai.isChecked())
                {
                    ss+="Nam";
                }
                if(gai.isChecked())
                {
                    ss+="Nu";
                }
                ss+=" \n Rating "+danhgia.getRating();
                ss+="\n Country "+sp.getSelectedItem().toString();
                hienthi.setText(ss);
            }
        });
    }
}