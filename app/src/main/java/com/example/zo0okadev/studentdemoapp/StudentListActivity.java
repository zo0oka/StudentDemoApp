package com.example.zo0okadev.studentdemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.zo0okadev.studentdemoapp.model.Student;
import com.example.zo0okadev.studentdemoapp.studentList.StudentAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {

    private static final String BARCODE_DATA = "barcode_data";
    private static final String LOG_TAG = StudentListActivity.class.getSimpleName();
    private static final String STUDENT_ID = "student_id";
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        //Get the barcode data from the Intent
        String barcode = getIntent().getStringExtra(BARCODE_DATA);

        //Populate the Students ArrayList
        try {
            JSONArray jsonArray = new JSONArray(barcode);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject studentObject = jsonArray.getJSONObject(i);
                int studentID = studentObject.getInt("id");
                String studentName = studentObject.getString("name");
                String studentImageUrl = studentObject.getString("img_url");
                Student student = new Student(studentID, studentName, studentImageUrl);
                students.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            StudentAdapter adapter = new StudentAdapter(getApplicationContext(), students);
            ListView listView = findViewById(R.id.list_view);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Student current_student = students.get(position);
                    String studentId = String.valueOf(current_student.getStudentId());
                    Intent profile = new Intent(getApplicationContext(), StudentProfileActivity.class);
                    profile.putExtra(STUDENT_ID, studentId);
                    startActivity(profile);
                }
            });

        }
    }

}
