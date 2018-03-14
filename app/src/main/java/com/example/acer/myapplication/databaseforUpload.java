package com.example.acer.myapplication;



import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import android.widget.Toast;

/**
 * Created by m on 21/02/18.
 */

public class databaseforUpload {

    public class json extends AsyncTask<String,Void,String> {
        Context ctx;
        json (Context ctx){
            this.ctx=ctx;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String url_lo="http://databases.000webhost.com/tbl_row_action.php";
            String url1="http://databases.000webhost.com/tbl_row_action.php";

            String method= params[0];
            if (method.equals("register")){
                String name =params[1];
                String id =params[2];
                String email =params[3];
                String phone =params[4];
                String code =params[5];
                String dateOfbirth =params[6];


                try {
                    URL url =new URL(url_lo);
                    HttpURLConnection   httpURLConnection=(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoInput(true);
                    OutputStream os= httpURLConnection.getOutputStream();
                    BufferedWriter  bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                    String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                            URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8") +"&"+
                            URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8") +"&"+
                            URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8") +"&"+
                            URLEncoder.encode("code","UTF-8")+"="+URLEncoder.encode(code,"UTF-8") +"&"+
                            URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(dateOfbirth,"UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                    InputStream IS =httpURLConnection.getInputStream();
                    IS.close();
                    return "personal information ....";
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                catch (ProtocolException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }


            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }
    }
}

