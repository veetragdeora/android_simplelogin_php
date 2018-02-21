package com.example.veetragdeora.e_business_project;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contact extends AppCompatActivity {
    TextView contact_1 , contact_2, phone_1, phone_2, email_id_1, email_id_2;
    Button call_1, call_2, email_1, email_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contact_1 =(TextView)findViewById(R.id.contact_name_vinay);
        contact_2 =(TextView)findViewById(R.id.contact_name_veetrag);
        phone_1 =(TextView)findViewById(R.id.phone_vinay);
        phone_2 =(TextView)findViewById(R.id.phone_veetrag);
        email_id_1 =(TextView)findViewById(R.id.email_vinay);
        email_id_2 =(TextView)findViewById(R.id.email_veetrag);
        call_1 = (Button)findViewById(R.id.button_call_vinay);
        call_2 = (Button)findViewById(R.id.button_call_veetrag);
        email_1 = (Button)findViewById(R.id.button_email_vinay);
        email_2 = (Button)findViewById(R.id.button_email_veetrag);



        call_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+ phone_1.getText()));
                if (checkCallPermissions()){
                startActivity(callIntent);
                }
            }
        });
        call_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone_2.getText()));
                if (checkCallPermissions()){
                    startActivity(callIntent);
                }
            }
        });

        email_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                String[] to = {"krvinay.iitkgp@gmail.com"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Write your feedback here!!");
                emailIntent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(emailIntent, "Send Email");
                startActivity(chooser);
            }
        });
        email_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                String[] to = {"veetragdeora11@gmail.com"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Write your feedback here!!");
                emailIntent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(emailIntent, "Send Email");
                startActivity(chooser);
            }
        });
    }
    public boolean checkCallPermissions(){
        String  premission = "android.permission.CALL_PHONE";
        int res = getApplicationContext().checkCallingOrSelfPermission(premission);
        return (res == PackageManager.PERMISSION_GRANTED);
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
