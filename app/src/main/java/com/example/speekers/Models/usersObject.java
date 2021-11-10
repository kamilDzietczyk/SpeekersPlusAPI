package com.example.speekers.Models;

import java.util.List;

public class usersObject {

    int id;
    String user_name;
    String user_password;
    String user_role;
    List<Object> exercises;

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_role() {
        return user_role;
    }

    public List<Object> getExercises() {
        return exercises;
    }
}
