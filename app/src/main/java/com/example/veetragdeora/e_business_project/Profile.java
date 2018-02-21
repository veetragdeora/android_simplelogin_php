package com.example.veetragdeora.e_business_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private Toolbar toolbar;
    TextView textView , textView1;
    ImageView imageView;
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        textView1 = (TextView)findViewById(R.id.textView4);

        imageView =(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.default_profile);

        textView = (TextView)findViewById(R.id.textView5);
        BackgroundTask backgroundTask = new BackgroundTask(Profile.this);
        String name_veet = backgroundTask.name_of_user;
        textView.setText(name_veet);

        button = (Button)findViewById(R.id.button4);
    }
    public void shop_now_click(View view){
        startActivity(new Intent(Profile.this, Shoppingccessory.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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