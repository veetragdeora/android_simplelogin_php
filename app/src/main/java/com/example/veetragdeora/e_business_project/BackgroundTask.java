package com.example.veetragdeora.e_business_project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
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


public class BackgroundTask extends AsyncTask<String , Void , String> {

    public String name_of_user = "Veetrag Deora" ;
    Context ctx;
    AlertDialog.Builder alert_dilogue;
    BackgroundTask(Context ctx){
        this.ctx = ctx;
    }
    @Override
    protected void onPreExecute() {
        //  alertDialog = new AlertDialog.Builder(ctx).create();
        //   alertDialog.setTitle("Login information!!");
        alert_dilogue = new AlertDialog.Builder(ctx);


    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.0.2.2/webapp/register.php";
        String login_url = "http://10.0.2.2/webapp/login.php";
        String ask_que_url = "http://10.0.2.2/webapp/question.php";
        String order_url = "http://10.0.2.2/webapp/order.php";
        String method = params[0];

        if (method.equals("order")){
            String name = params[1];
            String email =params[2];
            String address = params[3];
            String detail = params[4];
            String price = params[5];
            try {
                URL url = new URL(order_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") +"="+URLEncoder.encode(name, "UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8") +"="+URLEncoder.encode(email, "UTF-8")+"&"+
                        URLEncoder.encode("address","UTF-8") +"="+URLEncoder.encode(address, "UTF-8")+"&"+
                        URLEncoder.encode("detail","UTF-8") +"="+URLEncoder.encode(detail, "UTF-8")+"&"+
                        URLEncoder.encode("price","UTF-8") +"="+URLEncoder.encode(price, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Order Successful";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (method.equals("register")){

            String name = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data = URLEncoder.encode("user", "UTF-8") +"="+URLEncoder.encode(name, "UTF-8")+"&"+
                        URLEncoder.encode("user_name","UTF-8") +"="+URLEncoder.encode(user_name, "UTF-8")+"&"+
                        URLEncoder.encode("user_pass","UTF-8") +"="+URLEncoder.encode(user_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration success";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         if (method.equals("login")){
            String user_name = params[1];
            String user_pass = params[2];

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login1_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                        URLEncoder.encode("login2_pass","UTF-8")+"="+URLEncoder.encode(user_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String line="";
                String response ="";
                while ((line = bufferedReader.readLine())!= null){
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return  response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("ask_question")){
            String que = params[1];
            String email = params[2];
            try {
                URL url = new URL(ask_que_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data = URLEncoder.encode("question", "UTF-8") +"="+URLEncoder.encode(que, "UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8") +"="+URLEncoder.encode(email, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Your query sent";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
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


        if(result.equals("Registration success")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        if (result.equals("Your query sent")){
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        /**  else if (result.equals("")){
         alertDialog.setMessage("Info incorect");
         alertDialog.show();

         }

         else  {
         alertDialog.setMessage(result);
         alertDialog.setCancelable(false);

         alertDialog.show();
         name_of_user = result;
         }
         */
        if (result.equals("Order Successful")){
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
           alert_dilogue.setTitle(result);
            alert_dilogue.setMessage("Ordered item will be delivered in 2-3 days." ).setCancelable(false)
                    .setNegativeButton("Shop More....", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(ctx, Shoppingccessory.class);
                            ctx.startActivity(intent);
                        }
                    });
             AlertDialog asd = alert_dilogue.create();
            asd.show();
        }
        else if(result.equals("")){
            alert_dilogue.setMessage("Incorrect Info").setCancelable(false).setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog asd = alert_dilogue.create();
            asd.show();
        }
        else {
            alert_dilogue.setTitle("login info");
            alert_dilogue.setMessage("Welcome!!  " +result).setCancelable(false).setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(ctx, Profile.class);
                    ctx.startActivity(intent);
                }
            });
            AlertDialog asd = alert_dilogue.create();
            asd.show();

        }

    }

}
