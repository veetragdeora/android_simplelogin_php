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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Shoppingccessory extends AppCompatActivity {
    private Toolbar toolbar;

    private static ListView list_view;
    private static String[] list_product = {"Topwear", "Bottomwear", "Footwear", "Sportswear", "Watches & Wearable Store", "Inner & Sleepwear"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingccessory);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        List_View1();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void List_View1(){
        list_view = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.shoppingccessory_list,list_product);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value1 = (String) list_view.getItemAtPosition(position);
                if (position == 0){
                  Intent topware = new Intent(Shoppingccessory.this,Topware.class);
                startActivity(topware);}
             /**  switch (position) {
                    case '0':

                        Toast.makeText(Shoppingccessory.this, "Position: " + position + "Value :" + value1, Toast.LENGTH_SHORT).show();
                        break;
                    case '1':
                        Toast.makeText(Shoppingccessory.this, "Position: " + position + "Value :" + value1, Toast.LENGTH_SHORT).show();
                        break;
                    case '2':
                        Toast.makeText(Shoppingccessory.this, "Position: " + position + "Value :" + value1, Toast.LENGTH_SHORT).show();
                        break;
                    case '3':
                        Toast.makeText(Shoppingccessory.this, "Position: " + position + "Value :" + value1, Toast.LENGTH_SHORT).show();
                        break;
                    case '4':
                        Toast.makeText(Shoppingccessory.this, "Position: " + position + "Value :" + value1, Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(Shoppingccessory.this, "Position: " + position + "Value :" + value1, Toast.LENGTH_LONG).show();
                }
              */
            }
        });
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
