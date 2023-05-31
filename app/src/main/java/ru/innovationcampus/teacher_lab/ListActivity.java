package ru.innovationcampus.teacher_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {
    RecyclerView studentsRV;
    private StudentsAdapter studentsAdapter;
    private ArrayList<String> students = DataLoader.students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        studentsRV = findViewById(R.id.studentsRV);
        studentsAdapter = new StudentsAdapter(getBaseContext(), students);
        studentsRV.setLayoutManager(new LinearLayoutManager(this));
        studentsRV.setAdapter(studentsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        students = DataLoader.getStudents();
        studentsAdapter.notifyDataSetChanged();
    }
}