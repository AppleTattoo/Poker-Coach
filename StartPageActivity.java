package com.example.alex_.pokercoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;

import java.lang.reflect.Method;
import java.util.Arrays;

public class StartPageActivity extends AppCompatActivity {

    private Button buttonGetStarted;

    public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(0);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        buttonGetStarted = (Button) findViewById(R.id.buttonGetStarted);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getStarted() {
        Toast.makeText(StartPageActivity.this, "Setting up your game", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(StartPageActivity.this, PlayScreen.class));
        buttonGetStarted = (Button) findViewById(R.id.buttonGetStarted);
    }

    public void onClick (View view) {

        if(view == buttonGetStarted) {
            getStarted();
        }
    }

}
