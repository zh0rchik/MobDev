package com.example.lab1simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        double res = getIntent().getDoubleExtra("Result", 0);
        res = Math.round(res*10000);
        res /= 10000;
        TextView resultText = findViewById(R.id.resultText);

        String str;

        if((int)res == res){
            str = String.valueOf((int)res);
        } else{
            str = String.valueOf(res);
        }

        resultText.setText(String.format(getResources().getString(R.string.result), str));

        Button exitBtn = findViewById(R.id.exit);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}