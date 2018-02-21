package com.example.veetragdeora.e_business_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AskQuestion extends AppCompatActivity {
    EditText question, email;
    Button send;
    String question_asked,email_entered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        question = (EditText)findViewById(R.id.question);
        email = (EditText)findViewById(R.id.email_add_que);
        send  = (Button)findViewById(R.id.send_question);

    }

    public void askQuestion(View view){
        question_asked = question.getText().toString();
        email_entered = email.getText().toString();
        String method = "ask_question";

        BackgroundTask bt = new BackgroundTask(this);
        bt.execute(method, question_asked, email_entered);
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
        return super.onOptionsItemSelected(item);
    }



}
