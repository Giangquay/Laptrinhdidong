package com.example.layout1.MenuActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.layout1.R;

public class TechnologyActivity extends AppCompatActivity {
        TextView view;
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);
        view=findViewById(R.id.textView);
        registerForContextMenu(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_color,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.red:view.setTextColor(Color.RED);
            break;
            case R.id.blue:view.setTextColor(Color.BLUE);
            break;
            case R.id.yellow:view.setTextColor(Color.YELLOW);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mFile:
                Toast.makeText(getApplicationContext(), "Select File", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Exit:
                System.exit(0);
                break;
            case R.id.mMail:
                Toast.makeText(getApplicationContext(), "Select Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mPhone:
                Toast.makeText(getApplicationContext(), "Select Phone", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}