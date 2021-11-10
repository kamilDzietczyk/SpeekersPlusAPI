package com.example.speekers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class  MenuLetter extends AppCompatActivity implements View.OnClickListener {
    private Button Listening, Text, Back,Check;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(menuSetting.theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_letter);
        Listening = findViewById(R.id.Listening);
        Listening.setOnClickListener(this);
        Text = findViewById(R.id.Text);
        Text.setOnClickListener(this);
        Check = findViewById(R.id.Check);
        Check.setOnClickListener(this);
        Back = findViewById(R.id.Back);
        Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.Listening:{
                Intent intent = new Intent(this, Letter.class);
                startActivity(intent);
                break;
            }
            case R.id.Text:{
                Intent intent = new Intent(this, TextLetter.class);
                startActivity(intent);
                break;
            }
            case R.id.Check:{
                Intent intent = new Intent(this, ThirdExam.class);
                startActivity(intent);
                break;
            }
            case R.id.Back:{
               Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}