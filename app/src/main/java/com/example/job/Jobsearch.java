package com.example.job;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Jobsearch extends AppCompatActivity implements View.OnClickListener {
    Button search;
    public static TextView data;
    TextView locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsearch);
        data=(TextView)findViewById(R.id.fetchdata);
        locations=(TextView)findViewById(R.id.location);
        search=(Button)findViewById(R.id.searches);
        search.setOnClickListener(this);
    }

    private void request(){

        String loc=locations.getText().toString();
        Fetchdata fetch=new Fetchdata();
        //fetch.execute(loc);
    }

    @Override
    public void onClick(View v) {

        if(search==v){
           request();
        }
    }
}
