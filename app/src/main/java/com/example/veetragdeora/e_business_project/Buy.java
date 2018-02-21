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
import android.widget.TextView;

public class Buy extends AppCompatActivity {
        Button button;
    EditText name,email,address;
    TextView text_view_detail, text_view_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text_view_detail = (TextView)findViewById(R.id.textView8);
        text_view_price = (TextView)findViewById(R.id.textView10);

        Intent intent = getIntent();
        String detail = getIntent().getStringExtra("detail");
        String price = getIntent().getStringExtra("price");
        text_view_detail.setText(detail);
        text_view_price.setText(price + " to be paid on delivery.");

        name = (EditText)findViewById(R.id.editText6);
        email = (EditText)findViewById(R.id.editText7);
        address = (EditText)findViewById(R.id.editText8);

    }
    public void orderNow(View view){
        String name_send = name.getText().toString();
        String email_send = email.getText().toString();
        String address_send = address.getText().toString();
        Intent intent = getIntent();
        String detail = getIntent().getStringExtra("detail");
        String price = getIntent().getStringExtra("price");
        String st = "order";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(st,name_send,email_send,address_send,detail,price);
        // startActivity(new Intent(this,Profile.class));
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
