package ru.innovationcampus.teacher_lab.mocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FakeCall implements Call<ArrayList<String>> {
    @Override
    public Response<ArrayList<String>> execute() throws IOException {
        return null;
    }

    @Override
    public void enqueue(Callback<ArrayList<String>> callback) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("after sleep");
                ArrayList<String> list = new ArrayList<>();
                list.addAll(Arrays.asList(new String[]{
                        "Петров Влад", "Хумышев Евгений", "Иванов Дементий"
                }));
                callback.onResponse(this, Response.success(200, list));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Call<ArrayList<String>> clone() {
        return null;
    }

    @Override
    public Request request() {
        return null;
    }

    @Override
    public Timeout timeout() {
        return null;
    }
}