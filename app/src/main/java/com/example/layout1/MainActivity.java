package com.example.layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private Spinner sp1,sp2;
    EditText num1,num2;
    Button add;
    private TextView Kq;
    private Spinner cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcutator_activity);
//        sp1=findViewById(R.id.sp2);
//        sp2=findViewById(R.id.sp);
//        String [] list = {"PTIT","HUST","NEU","NUCE","FTU"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item,list);
//        sp1.setAdapter(adapter);
//        String[] list1= getResources().getStringArray(R.array.country);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,R.layout.item,list1);
//        sp2.setAdapter(adapter1);
        cal =findViewById(R.id.Pheptinh);
        String[] list =getResources().getStringArray(R.array.pheptinh);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.calculator_color,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        cal.setAdapter(adapter);
//        reg=findViewById(R.id.register);
//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i= new Intent(MainActivity.this , RegisterActivity.class);
//                startActivity(i);
//            }
//        });
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        add =findViewById(R.id.Add);
        Kq=findViewById(R.id.kq);
        cal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String n1=num1.getText().toString();
                String n2=num2.getText().toString();
                try {
                    double so1=Double.parseDouble(n1);
                    double so2=Double.parseDouble(n2);
                    String sp= cal.getSelectedItem().toString();
                    String kk=tinhtoan(so1,so2,sp);
                    Kq.setText(kk);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Nhap 2 so",Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
//    public void ADD(View v)
//    {
//        String n1=num1.getText().toString();
//        String n2=num2.getText().toString();
//        try {
//            double so1=Double.parseDouble(n1);
//            double so2=Double.parseDouble(n2);
//            String kk=tinhtoan(so1,so2,"+");
//            Kq.setText(kk);
//        }catch (Exception e)
//        {
//            Toast.makeText(getApplicationContext(),"Nhap 2 so",Toast.LENGTH_SHORT).show();
//        }
//    }
    private String tinhtoan(double x,double y,String p)
    {
        String s="";
        switch (p)
        {
            case "+":
                s = "Tong"+(x+y);
                break;
            case "-":
                s = "Hieu"+(x-y);
                break;
            case "X":
                s = "Tich"+(x*y);
                break;
            case ":":
                if (y==0)
                {
                    s ="Khong chia het cho 0";
                }else
                s = "Thuong"+(x/y);
                break;
        }
        return  s;
    }
}