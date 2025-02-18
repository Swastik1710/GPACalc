package com.example.gpacalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class GPA_Activity extends AppCompatActivity {
    EditText percent;
    TextView gpa;
    Button calc,reset;
    float p,g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        gpa = findViewById(R.id.gpa);
        percent = findViewById(R.id.percentage);
        calc = (Button) findViewById(R.id.calc_gpa);
        reset = (Button) findViewById(R.id.reset_gpa);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=0;
                g=0;
                if(!percent.getText().toString().equals(""))
                    p = Float.parseFloat(percent.getText().toString());
                    if(p>0 && p<=92.5)
                        g = (float) ((p/10)+0.75);
                    if(p>92.5)
                        g = 10;
                gpa.setText(String.format(Locale.US,"%.2f",g));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent.setText("");
                gpa.setText("");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}