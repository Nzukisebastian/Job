package com.example.job;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;


public class Jobdetails extends AppCompatActivity implements View.OnClickListener{
    EditText jobnames,contacts,locations,salarys,descriptions,companynamex;
    private Button buttonSubmit;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobdetails);
        companynamex= (EditText)findViewById(R.id.companyname);
        jobnames= (EditText) findViewById(R.id.job);
        contacts = (EditText) findViewById(R.id.contact);
        locations = (EditText) findViewById(R.id.location);
        descriptions = (EditText) findViewById(R.id.description);
        salarys = (EditText) findViewById(R.id.salary);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);
    }

    private void submitForm() {
            String companyname=companynamex.getText().toString().trim().toLowerCase();
            String jobname=jobnames.getText().toString().trim().toLowerCase();
            String cont=contacts.getText().toString().trim().toLowerCase();
            String loca=locations.getText().toString().trim().toLowerCase();
            String des=descriptions.getText().toString().trim().toLowerCase();
            String sal=salarys.getText().toString().trim().toLowerCase();
        Toast.makeText(Jobdetails.this,"clicked",Toast.LENGTH_LONG).show();
            String type="upload";
            Backjobdetails backjobdetails=new Backjobdetails(this);
            backjobdetails.execute(type,companyname,jobname,cont,loca,des,sal);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonSubmit) {
            submitForm();
        }
    }
}
