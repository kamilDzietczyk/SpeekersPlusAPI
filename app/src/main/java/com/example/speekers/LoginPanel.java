package com.example.speekers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.speekers.Interface.usersObjectInterface;
import com.example.speekers.Models.usersObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginPanel extends AppCompatActivity implements View.OnClickListener {

    TextView t1;
    Button b1;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_panel);
        //Login
        b1 = findViewById(R.id.btnlogin);
        b1.setOnClickListener(this);
        //EditTxt
        e1 = findViewById(R.id.Log);
        e2 = findViewById(R.id.mypass);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            /*case R.id.createnew:
                Intent intent = new Intent(this,RegisterPanel.class);
                startActivity(intent);*/

            case R.id.btnlogin:
                if(e1.getText().toString().isEmpty() && e2.getText().toString().isEmpty()){
                    Toast.makeText(this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                Login();
        }
    }
    public void Login(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usersObjectInterface usersObjectInterface = retrofit.create(usersObjectInterface.class);
        Call<List<usersObject>> call = usersObjectInterface.listOfUsers();
        call.enqueue(new Callback<List<usersObject>>() {
            @Override
            public void onResponse(Call<List<usersObject>> call, Response<List<usersObject>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginPanel.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<usersObject> postObjects = response.body();
                int f=0;
                for(int i=0;i<=postObjects.size()-1;i++){
                    if(postObjects.get(i).getUser_name().equals(e1.getText().toString()) && postObjects.get(i).getUser_password().equals(e2.getText().toString())){
                        f++;
                    };
                }
                if(f>0){
                    Intent intent = new Intent(LoginPanel.this,menuSetting.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginPanel.this, "User not found", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<usersObject>> call, Throwable t) {
                Toast.makeText(LoginPanel.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

