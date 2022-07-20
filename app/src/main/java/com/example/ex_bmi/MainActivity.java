package com.example.ex_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName,editTextAge,editTextHeight,editTextWeight;
    private Button buttonBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editText_name);
        editTextAge = (EditText) findViewById(R.id.editText_age);
        editTextHeight = (EditText) findViewById(R.id.editText_height);
        editTextWeight = (EditText) findViewById(R.id.editText_weight);

        buttonBMI = (Button) findViewById(R.id.button_bmi);

        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> strflag = new ArrayList<String>();

                if(editTextName.getText().toString().isEmpty()){
                    strflag.add(getResources().getString(R.string.textName));
                }

                if(editTextAge.getText().toString().isEmpty()){
                    strflag.add(getResources().getString(R.string.textage));
                }

                if(editTextHeight.getText().toString().isEmpty()){
                    strflag.add(getResources().getString(R.string.textheight));
                }

                if(editTextWeight.getText().toString().isEmpty()){
                    strflag.add(getResources().getString(R.string.textweight));
                }
                if(strflag.size()>0) {
                    String toastMsg = "請輸入您的".concat(strflag.toString().replaceAll("[\\[\\]\\:]", ""));
                    Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();
                }else{
                    String name = editTextName.getText().toString();
                    String age = editTextAge.getText().toString();
                    double weight = Double.parseDouble(editTextWeight.getText().toString());
                    double height = Double.parseDouble(editTextHeight.getText().toString());
                    //double bmi = ((weight)/((height/100)*(height/100)));
                    Log.d("main","name="+name);
                    Log.d("main","age="+age);
                    Log.d("main","weight="+weight);
                    Log.d("main","height="+height);
                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("weight",weight);
                    intent.putExtra("height",height);
                    intent.putExtra("age",age);
                    //intent.putExtra("bmi",bmi);
                    startActivity(intent);
                }
            }
        });
    }
}