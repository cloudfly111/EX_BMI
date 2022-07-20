package com.example.ex_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.SuperscriptSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.math.MathUtils;

import java.math.MathContext;

public class BMIActivity extends AppCompatActivity {

    private TextView TextViewInfo,TextViewReport;
    private ImageView ImageViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        setTitle(userName);

        TextViewInfo = (TextView) findViewById(R.id.textView_info);
        TextViewReport = (TextView) findViewById(R.id.textView_report);
        ImageViewReport = (ImageView) findViewById(R.id.imageView_report);
        String userAge=intent.getStringExtra("age");
        double userHeight = intent.getDoubleExtra("height",160);
        double userWeight = intent.getDoubleExtra("weight",50);
        double userBMI = ((userWeight)/((userHeight/100)*(userHeight/100)));

        TextViewInfo.setText(getResources().getString(R.string.textage)+" "+userAge+" 歲\n");
        TextViewInfo.append(getResources().getString(R.string.textheight)+" "+userHeight+" cm\n");
        TextViewInfo.append(getResources().getString(R.string.textweight)+" "+userWeight+" kg");

        TextViewReport.setText("您的BMI計算結果 : \n"+ (Math.round(userBMI*100.0)/100.0)+" ");
        String str="kg/m2";
        SpannableString s = new SpannableString(str);
        s.setSpan(new SuperscriptSpan(),4,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextViewReport.append(s);


        String bmiMsg="";
        if(userBMI>=25){//        between 25 and 29.9 – you're in the overweight range
            bmiMsg="過重";
            ImageViewReport.setImageResource(R.drawable.fat);
        }else if(userBMI>=18.5 ){//        between 18.5 and 24.9 – you're in the healthy weight range
            bmiMsg="正常";
            ImageViewReport.setImageResource(R.drawable.health);
        }else{
            bmiMsg="過輕";//        below 18.5 – you're in the underweight range
            ImageViewReport.setImageResource(R.drawable.underweight);
        }
        TextViewReport.append(" "+bmiMsg);




    }
}