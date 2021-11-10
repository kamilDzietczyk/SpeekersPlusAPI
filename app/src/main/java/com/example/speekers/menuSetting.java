package com.example.speekers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Method;

public class menuSetting extends AppCompatActivity {

    public static int theme = R.style.AppTheme_NoActionBar_Yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_setting);
    }

    public void yellowTheme(View view) {
        theme = R.style.AppTheme_NoActionBar_Yellow;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void blackTheme(View view) {
        theme = R.style.AppTheme_NoActionBar_Black;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void whiteTheme(View view) {
        theme = R.style.AppTheme_NoActionBar_White;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}