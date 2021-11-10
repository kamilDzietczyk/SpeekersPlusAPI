package com.example.speekers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView button1, button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(menuSetting.theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14= findViewById(R.id.button14);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View view) {
        intent = new Intent(this, MenuLetter.class);
        startActivity(intent);
        switch(view.getId()){
            case R.id.button1:
                Letter.letter = "ż";
                TextLetter.letter = "ż";
                break;
            case R.id.button2:
                Letter.letter = "c";
                TextLetter.letter = "c";
                break;
            case R.id.button3:
                Letter.letter = "cz";
                TextLetter.letter = "cz";
                break;
            case R.id.button4:
                Letter.letter = "ć";
                TextLetter.letter = "ć";
                break;
            case R.id.button5:
                Letter.letter = "dz";
                TextLetter.letter = "dz";
                break;
            case R.id.button6:
                Letter.letter = "dż";
                TextLetter.letter = "dż";
                break;
            case R.id.button7:
                Letter.letter = "g";
                TextLetter.letter = "g";
                break;
            case R.id.button8:
                Letter.letter = "k";
                TextLetter.letter = "k";
                break;
            case R.id.button9:
                Letter.letter = "l";
                TextLetter.letter = "l";
                break;
            case R.id.button10:
                Letter.letter = "r";
                TextLetter.letter = "r";
                break;
            case R.id.button11:
                Letter.letter = "s";
                TextLetter.letter = "s";
                break;
            case R.id.button12:
                Letter.letter = "sz";
                TextLetter.letter = "sz";
                break;
            case R.id.button13:
                Letter.letter = "ś";
                TextLetter.letter = "ś";
                break;
            case R.id.button14:
                Letter.letter = "z";
                TextLetter.letter = "z";
                break;
        }
    }

    public void setting(View view) {
        Intent intent = new Intent(this,menuSetting.class);
        startActivity(intent);
    }
}