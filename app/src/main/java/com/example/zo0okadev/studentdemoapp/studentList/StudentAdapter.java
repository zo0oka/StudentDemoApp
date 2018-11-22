package com.example.zo0okadev.studentdemoapp.studentList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zo0okadev.studentdemoapp.R;
import com.example.zo0okadev.studentdemoapp.model.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.student_list_item, parent, false);
        }
        Student currentStudent = getItem(position);
        TextView studentName = listItemView.findViewById(R.id.student_name);
        if (currentStudent != null) {
            studentName.setText(currentStudent.getStudentName());
        }
        ImageView studentImage = listItemView.findViewById(R.id.student_image);
        if (currentStudent != null) {
            Picasso.get().load(currentStudent.getStudentImgUrl()).into(studentImage);
        }
        return listItemView;
    }
}
