package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button  btn0, btn00, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btnclear, btnkurang, btnpersen,
            btnbagi, btnkali, btntambah, btnsamadengan, btnkoma;
    TextView TVInput, TVResult;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn0 = findViewById(R.id.btn0);
        btn00 = findViewById(R.id.btn00);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnclear = findViewById(R.id.btnclear);
        btnpersen = findViewById(R.id.btnpersen);
        btnbagi = findViewById(R.id.btnbagi);
        btnkali = findViewById(R.id.btnkali);
        btnkurang = findViewById(R.id.btnkurang);
        btntambah = findViewById(R.id.btntambah);
        btnsamadengan = findViewById(R.id.btnsamadengan);
        btnkoma = findViewById(R.id.btnkoma);

        TVInput = findViewById(R.id.TVInput);
        TVResult = findViewById(R.id.TVResult);


        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TVInput.setText("");
                TVResult.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "0");
            }
        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "00");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "9");
            }
        });

        btnpersen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "%");
            }
        });

        btnbagi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "÷");
            }
        });

        btnkali.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "×");
            }
        });

        btnkurang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "-");
            }
        });

        btntambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + "+");
            }
        });

        btnkoma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();
                TVInput.setText(process + ".");
            }
        });


        btnsamadengan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = TVInput.getText().toString();

                process = process.replaceAll( "×", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("÷", "/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try{
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString
                            (scriptable,process,"javascript", 1, null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                TVResult.setText(finalResult);
            }
        });
    }
}