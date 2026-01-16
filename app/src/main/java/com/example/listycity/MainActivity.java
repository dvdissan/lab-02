package com.example.listycity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    Button add;
    Button delete;
    Button confirm;
    EditText inp;







    int pos;

    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cityList = findViewById(R.id.city_list);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        confirm = findViewById(R.id.confirm_button);
        inp = findViewById(R.id.enter_city);

        pos=-1;



        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
        inp.setVisibility(View.GONE);
        confirm.setVisibility(View.GONE);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pos!=-1){
                    dataList.remove(pos);

                    cityAdapter.notifyDataSetChanged();
                    pos=-1;

                }

            }

        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inp.getVisibility()== View.GONE) {
                    inp.setVisibility(View.VISIBLE);
                    confirm.setVisibility(View.VISIBLE);
                }else{
                    inp.setVisibility(View.GONE);
                    confirm.setVisibility(View.GONE);


                }

            }

        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add(String.valueOf(inp.getText()));
                cityAdapter.notifyDataSetChanged();
                inp.setText("");
                inp.setVisibility(View.GONE);
                confirm.setVisibility(View.GONE);
            }

        });


        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;



            }
        });

    }
}