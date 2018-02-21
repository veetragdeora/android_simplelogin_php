package com.example.veetragdeora.e_business_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    private Toolbar toolbar;
    EditText Et_name, Et_username, Et_userpassword;
    String name,username,userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
          Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
         setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Et_name = (EditText)findViewById(R.id.editText3);
        Et_username = (EditText)findViewById(R.id.editText5);
        Et_userpassword = (EditText)findViewById(R.id.editText4);
    }

    public void userReg(View view){
        name = Et_name.getText().toString();
        username=Et_username.getText().toString();
        userpass = Et_userpassword.getText().toString();

        String method  = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,username,userpass);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }

        int id = item.getItemId();


        if(id == R.id.action_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        if(id == R.id.action_faq){
            startActivity(new Intent(this,FAQs.class));

        }
        if(id == R.id.contact_us){
            startActivity(new Intent(this, Contact.class));
        }
        if(id == R.id.action_report){
            startActivity(new Intent(this,AskQuestion.class));
        }
        if (id  == R.id.about_us){
            startActivity(new Intent(this,AboutUs.class));
        }

        return super.onOptionsItemSelected(item);
    }


}