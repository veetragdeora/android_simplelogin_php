package com.example.veetragdeora.e_business_project;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    EditText ET_user_name, ET_user_pass;
    String login_name, login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

      /**  NavigationDrawerFragment drawerFragment =(NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp((DrawerLayout)findViewById(R.id.drawer_layout),toolbar);
       */

        ET_user_name = (EditText)findViewById(R.id.editText);
        ET_user_pass =(EditText)findViewById(R.id.editText2);
    }
    public void userReg(View view){
        startActivity(new Intent(this, Register.class));

    }

    public void userLogin(View view){
        login_name = ET_user_name.getText().toString();
        login_pass = ET_user_pass.getText().toString();
        String st = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(st, login_name, login_pass);
        // startActivity(new Intent(this,Profile.class));
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
