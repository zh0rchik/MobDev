package com.example.lab1simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText op1;
    EditText op2;
    Button sumBtn;
    Button deltaBtn;
    Button multiplyBtn;
    Button quotientBtn;
    int numBtn;
    double x;
    double y;

    public void resultString(int numBtn){
        try{
            x = Double.parseDouble(op1.getText().toString());
            y = Double.parseDouble(op2.getText().toString());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_enter),
                    Toast.LENGTH_SHORT).show();
            return;
        }

        double resultdouble = 0;

        switch (numBtn){
            case 1:
                resultdouble = x + y;
                break;
            case 2:
                resultdouble = x - y;
                break;
            case 3:
                resultdouble = x * y;
                break;
            case 4:
                if(y == 0){
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_zero),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                resultdouble = x / y;
                break;
            default:
        }

        Intent i = new Intent(MainActivity.this, ResultActivity.class);
        i.putExtra("Result", resultdouble);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = (EditText) findViewById(R.id.op1);
        op2 = (EditText) findViewById(R.id.op2);
        sumBtn = findViewById(R.id.sumBtn);
        deltaBtn = findViewById(R.id.deltaBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        quotientBtn = findViewById(R.id.quotientBtn);
        numBtn = 0;

        sumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBtn = 1;
                resultString(numBtn);
            }
        });

        deltaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBtn = 2;
                resultString(numBtn);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBtn = 3;
                resultString(numBtn);
            }
        });

        quotientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBtn = 4;
                resultString(numBtn);
            }
        });

    }
}