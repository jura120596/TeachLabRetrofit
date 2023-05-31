package ru.innovationcampus.teacher_lab;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentService {
    @GET("api/v1/student")
    Call<ArrayList<String>> getStudents();
}
