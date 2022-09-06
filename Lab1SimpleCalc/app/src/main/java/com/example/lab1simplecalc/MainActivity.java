package com.example.lab1simplecalc;

import androidx.appcompat.app.AppCompatActivity;
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

        sumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = Float.parseFloat(op1.getText().toString());
                float y = Float.parseFloat(op2.getText().toString());
                float resultFloat = x + y;
                int resultInt = (int)(x + y);

                if(resultFloat == resultInt){
                    Toast.makeText(getApplicationContext(),
                            "Сумма двух введённых чисел: " + (resultInt),
                            Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Сумма двух введённых чисел: " + (resultFloat),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        deltaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = Float.parseFloat(op1.getText().toString());
                float y = Float.parseFloat(op2.getText().toString());
                float resultFloat = x - y;
                int resultInt = (int)(x - y);

                if(resultFloat == resultInt){
                    Toast.makeText(getApplicationContext(),
                            "Разность двух введённых чисел: " + (resultInt),
                            Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Разность двух введённых чисел: " + (resultFloat),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = Float.parseFloat(op1.getText().toString());
                float y = Float.parseFloat(op2.getText().toString());
                float resultFloat = x * y;
                int resultInt = (int)(x * y);

                if(resultFloat == resultInt){
                    Toast.makeText(getApplicationContext(),
                            "Произведение двух введённых чисел: " + (resultInt),
                            Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Произведение двух введённых чисел: " + (resultFloat),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        quotientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = Float.parseFloat(op1.getText().toString());
                float y = Float.parseFloat(op2.getText().toString());
                float resultFloat = x / y;
                int resultInt = (int)(x / y);

                if(resultFloat == resultInt){
                    Toast.makeText(getApplicationContext(),
                            "Частное двух введённых чисел: " + (resultInt),
                            Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Частно двух введённых чисел: " + (resultFloat),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}