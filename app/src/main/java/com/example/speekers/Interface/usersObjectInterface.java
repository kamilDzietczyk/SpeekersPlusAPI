package com.example.speekers.Interface;

import com.example.speekers.Models.PostModel;
import com.example.speekers.Models.usersObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface usersObjectInterface {

    @GET("users/usersList")
    Call<List<usersObject>> listOfUsers();

}
