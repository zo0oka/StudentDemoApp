package com.example.zo0okadev.studentdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.zo0okadev.studentdemoapp.helper.SingletonVolley;
import com.example.zo0okadev.studentdemoapp.model.Student;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentProfileActivity extends AppCompatActivity {

    private static final String STUDENT_ID = "student_id";
    private static final String STUDENT_PROFILE_URL = "http://m4saad.fekrait.com/test-api/get_students_details.php";
    private String student_id;
    private Student currentStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        student_id = getIntent().getStringExtra(STUDENT_ID);

        loadStudentProfile(STUDENT_PROFILE_URL, student_id);
    }

    public void loadStudentProfile(String url, final String studentId) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        createCurrentStudent(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), R.string.error_message, Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("student_id", studentId);
                return params;
            }
        };
        SingletonVolley.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    //Sets the views for the Student profile with its data
    public void setStudentProfileData(Student student) {
        Picasso.get().load(student.getStudentImgUrl())
                .into((ImageView) findViewById(R.id.studentImage));
        ((TextView) findViewById(R.id.studentId))
                .setText(getResources().getString(R.string.id, String.valueOf(student.getStudentId())));
        ((TextView) findViewById(R.id.studentName))
                .setText(getResources().getString(R.string.name, student.getStudentName()));
        ((TextView) findViewById(R.id.studentEmail))
                .setText(getResources().getString(R.string.email, student.getStudentEmail()));
        ((TextView) findViewById(R.id.studentMobile))
                .setText(getResources().getString(R.string.mobile, student.getStudentMobile()));
        ((TextView) findViewById(R.id.studentGpa))
                .setText(getResources().getString(R.string.gpa, student.getStudentGpa()));
        ((TextView) findViewById(R.id.studentClass))
                .setText(getResources().getString(R.string.sClass, student.getStudentClass()));
        ((TextView) findViewById(R.id.studentGender))
                .setText(getResources().getString(R.string.gender, student.getStudentGender()));
    }

    //Creates Student profile
    public void createCurrentStudent(String studentJsonData) {
        try {
            JSONObject rootObject = new JSONObject(studentJsonData);
            JSONObject studentData = rootObject.getJSONObject("data");

            currentStudent = new Student(
                    studentData.getInt("id"),
                    studentData.getString("name"),
                    studentData.getString("img_url"),
                    studentData.getString("email"),
                    studentData.getString("mobile"),
                    studentData.getString("gpa"),
                    studentData.getString("class"),
                    studentData.getString("gender"));

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            setStudentProfileData(currentStudent);
        }
    }
}







