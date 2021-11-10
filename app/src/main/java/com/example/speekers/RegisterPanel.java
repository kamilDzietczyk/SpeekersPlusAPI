package com.example.speekers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.speekers.Interface.usersObjectInterface;
import com.example.speekers.Models.PostModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterPanel extends AppCompatActivity implements View.OnClickListener {

    //Button b1,b2;
    //EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_panel);
        /*//Button1
        b1 = findViewById(R.id.back);
        b1.setOnClickListener(this);
        //button2
        b2 = findViewById(R.id.buttonSign);
        b2.setOnClickListener(this);
        //EdiText
        e1 = findViewById(R.id.editName);
        e2 = findViewById(R.id.editPass);*/
    }

    @Override
    public void onClick(View v) {
        /*switch(v.getId()){
            case R.id.back:
                Intent intent = new Intent(this,LoginPanel.class);
                startActivity(intent);
            case R.id.buttonSign:
                if(e1.getText().toString().isEmpty() && e2.getText().toString().isEmpty()){
                    Toast.makeText(this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Regiater();
                Intent intent1 = new Intent(this,LoginPanel.class);
                startActivity(intent1);
        }*/
    }

    /*public void Regiater(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usersObjectInterface objectInterface = retrofit.create(usersObjectInterface.class);

        PostModel modal = new PostModel();
        modal.setUser_login(e1.getText().toString());
        modal.setUser_password(e2.getText().toString());
        Call<PostModel> call = objectInterface.createPost(modal);

        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                e1.setText("");
                e2.setText("");
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(RegisterPanel.this, " "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}