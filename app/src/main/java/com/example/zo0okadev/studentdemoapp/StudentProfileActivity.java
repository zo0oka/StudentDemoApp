package com.example.zo0okadev.studentdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.zo0okadev.studentdemoapp.helper.SingletonVolley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentProfileActivity extends AppCompatActivity {

    private static final String STUDENT_ID = "student_id";
    private static final String STUDENT_PROFILE_URL = "http://m4saad.fekrait.com/test-api/get_students_details.php";
    private String student_id;
    private String id, name, img_url, email, mobile, gpa, sClass, gender;

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
                        try {
                            JSONObject rootObject = new JSONObject(response);
                            JSONObject studentData = rootObject.getJSONObject("data");
                            id = studentData.getString("id");
                            name = studentData.getString("name");
                            img_url = studentData.getString("img_url");
                            email = studentData.getString("email");
                            mobile = studentData.getString("mobile");
                            gpa = studentData.getString("gpa");
                            sClass = studentData.getString("class");
                            gender = studentData.getString("gender");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } finally {
                            Picasso.get().load(img_url).into((ImageView) findViewById(R.id.studentImage));
                            ((TextView) findViewById(R.id.id_txt)).setText(id);
                            ((TextView) findViewById(R.id.name_txt)).setText(name);
                            ((TextView) findViewById(R.id.email_txt)).setText(email);
                            ((TextView) findViewById(R.id.mobile_txt)).setText(mobile);
                            ((TextView) findViewById(R.id.gpa_txt)).setText(gpa);
                            ((TextView) findViewById(R.id.class_txt)).setText(sClass);
                            ((TextView) findViewById(R.id.gender_txt)).setText(gender);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
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
}







