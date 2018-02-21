package com.example.veetragdeora.e_business_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Topware extends AppCompatActivity {
   TextView text_View1,text_View2,text_view11,text_view12, text_view13,text_view14, text_view15, text_view16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topware);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text_View1 = (TextView)findViewById(R.id.textView3);
        text_View2 = (TextView)findViewById(R.id.textView6);
        text_view11 = (TextView)findViewById(R.id.textView11);
        text_view12 = (TextView)findViewById(R.id.textView12);
        text_view13 = (TextView)findViewById(R.id.textView13);
        text_view14 = (TextView)findViewById(R.id.textView14);
        text_view15 = (TextView)findViewById(R.id.textView15);
        text_view16 = (TextView)findViewById(R.id.textView16);
    }
    public  void Buy_option_shirt1(View view){

        String text_detail = text_View1.getText().toString();
        String text_price = text_View2.getText().toString();
        Intent my_intent = new Intent(Topware.this,Buy.class);
        my_intent.putExtra("detail", text_detail);
        my_intent.putExtra("price", text_price);
        startActivity(my_intent);
    }
    public  void Buy_option_tshirt1(View view){

        String text_detail = text_view11.getText().toString();
        String text_price = text_view12.getText().toString();
        Intent my_intent = new Intent(Topware.this,Buy.class);
        my_intent.putExtra("detail", text_detail);
        my_intent.putExtra("price", text_price);
        startActivity(my_intent);
    }
    public  void Buy_option_shirt2(View view){

        String text_detail = text_view13.getText().toString();
        String text_price = text_view14.getText().toString();
        Intent my_intent = new Intent(Topware.this,Buy.class);
        my_intent.putExtra("detail", text_detail);
        my_intent.putExtra("price", text_price);
        startActivity(my_intent);
    }
    public  void Buy_option_tshirt2(View view){

        String text_detail = text_view15.getText().toString();
        String text_price = text_view16.getText().toString();
        Intent my_intent = new Intent(Topware.this,Buy.class);
        my_intent.putExtra("detail", text_detail);
        my_intent.putExtra("price", text_price);
        startActivity(my_intent);
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
