package ru.innovationcampus.teacher_lab.mocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.innovationcampus.teacher_lab.StudentService;
//Этот класс ретрофита, который имитирует загрузку с сервера, чтобы не привязываться к URL
public class Retrofit
//        extends Retrofit
{
    public <T> StudentService create(Class<T> service) {
        return new StudentService() {
            @Override
            public Call<ArrayList<String>> getStudents() {
                return new FakeCall();
            }
        };
    }
    public static Retrofit build() {
        return new Retrofit();
    }
}
