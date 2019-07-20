package com.example.job;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Backjobdetails extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    ProgressDialog progressDialog;
    ProgressDialog loading;
    String email;
    Backjobdetails(Context ctx){
        context = ctx;
    }
    @Override

    protected void onPreExecute() {
        // loading = ProgressDialog.show(context,"Downloading images...","Please wait...",true,true);
        progressDialog=ProgressDialog.show(context,"uploading details...","Please wait...",true,true);
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String register_url = "http://ictchops.me.ke/job/insertjob.php";

    if(type.equals("upload")){
            try{
                String companyname = params[1];
                String jobname = params[2];
                String contact  = params[3];
                String location=params[4];
                String salary=params[5];
                String description =params[6];

                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("jobname","UTF-8")+"="+URLEncoder.encode(jobname,"UTF-8")+"&"
                        +URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&"+URLEncoder.encode("location","UTF-8")+"="+URLEncoder.encode(location,"UTF-8")
                        +"&"+URLEncoder.encode("salary","UTF-8")+"="+URLEncoder.encode(salary,"UTF-8")+"&"+URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8")+"&"+URLEncoder.encode("cname","UTF-8")+"="+URLEncoder.encode(companyname,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) result += line;
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        progressDialog.dismiss();
        if(result!=null && result.equals("successfully uploaded")){
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
            Intent i=new Intent(context,Link.class);
            context.startActivity(i);

        }else if(result!=null && result.equals("upload failed")){
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        }

        else if(result==null){
            Toast.makeText(context,"check your network connection",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }
}
