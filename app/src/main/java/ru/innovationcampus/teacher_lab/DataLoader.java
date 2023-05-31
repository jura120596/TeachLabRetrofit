package ru.innovationcampus.teacher_lab;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.innovationcampus.teacher_lab.mocks.Retrofit;

public class DataLoader {
    static ArrayList<String> students = new ArrayList<>();

    public static ArrayList<String> getStudents() {
        Retrofit retrofit  = Retrofit.build();
        StudentService service = retrofit.create(StudentService.class);
        Call<ArrayList<String>> call = service.getStudents();
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                ArrayList<String> body = response.body();
                if (body!=null) {
                    students.clear();
                    students.addAll(body);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return students;
    }
}
