package com.example.lab2list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Space;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Locale localeEn = new Locale("en");
    Locale localeRu = new Locale("ru");

    ArrayList<String> List;
    EditText fieldInput;
    Button btnAddElement;
    Button btnChoiceLast;
    Button btnReset;
    Button btnOutput;
    ListView listView;
    String element;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Configuration config = new Configuration();
            config.locale = localeRu;
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Configuration configuration = new Configuration();
            configuration.locale = localeEn;
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }

        setContentView(R.layout.activity_main);

        btnAddElement = findViewById(R.id.btn_add);
        btnChoiceLast = findViewById(R.id.btn_choice_last);
        btnReset = findViewById(R.id.btn_reset);
        btnOutput = findViewById(R.id.btn_output);
        fieldInput = findViewById(R.id.input_field);
        listView = findViewById(R.id.list_view);
        List = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_single_choice, SaveList.List);
        listView.setAdapter(adapter);

        btnAddElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                element = fieldInput.getText().toString();
                if(element.isEmpty()){
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.error),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                adapter.add(element);
            }
        });

         btnChoiceLast.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 listView.setItemChecked(adapter.getCount()-1, true);
             }
         });

         btnReset.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 listView.setItemChecked(listView.getCheckedItemPosition(), false);
             }
         });

         btnOutput.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(listView.getItemAtPosition(listView.getCheckedItemPosition()) == null){
                     Toast.makeText(getApplicationContext(), getResources().getString(R.string.message),
                             Toast.LENGTH_SHORT).show();
                     return;
                 }
                 Toast.makeText(getApplicationContext(),
                         String.valueOf(listView.getItemAtPosition(listView.getCheckedItemPosition())),
                         Toast.LENGTH_LONG).show();
             }
         });
    }
}