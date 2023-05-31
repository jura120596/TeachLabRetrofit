package ru.innovationcampus.teacher_lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {
    private ArrayList<String> items = null;
    Context context;

    public StudentsAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.items = list;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item, parent, false);

        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bindView(position);
    }


    protected class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
        }

        public void bindView(int position) {
            String student = items.get(position);
            nameTV.setText(student);
        }
    }

}
