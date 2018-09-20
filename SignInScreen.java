package com.example.alex_.pokercoach;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInScreen extends AppCompatActivity implements View.OnClickListener {

    private Button ButtonRegister;
    private Button ButtonSignIn;
    private TextView TextViewSignInMessage;
    private EditText EditTextEmail;
    private EditText EditTextPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Please sign in with your username and password.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ButtonRegister = (Button)  findViewById(R.id.ButtonRegister);
        ButtonSignIn = (Button) findViewById(R.id.ButtonSignIn);
        EditTextEmail = (EditText) findViewById(R.id.EditTextEmail);
        EditTextPassword = (EditText) findViewById(R.id.EditTextPassword);
        TextViewSignInMessage = (TextView) findViewById(R.id.TextViewSignInMessage);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        ButtonRegister.setOnClickListener(this);
        ButtonSignIn.setOnClickListener(this);
    }

    private void RegUser(){
        String email = EditTextEmail.getText().toString().trim();
        String password = EditTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //no pass entered
            Toast.makeText(this, "Enter a valid password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("User Registered");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    finish();
                    Toast.makeText(SignInScreen.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignInScreen.this, StartPageActivity.class));
                    final String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();//may cause NPE
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(userID);
                    myRef.child(userID).push().child("Hands Won").push().setValue(0);
                }
                else {
                    Toast.makeText(SignInScreen.this, "Registration unsuccessful", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });

    }

    private void userLogin() {
        String email = EditTextEmail.getText().toString().trim();
        String password = EditTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //no pass entered
            Toast.makeText(this, "Enter a valid password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("User Registered");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(SignInScreen.this, StartPageActivity.class));
                }
                else {
                    Toast.makeText(SignInScreen.this, "Login unsuccessful", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });

    }

    public void onClick (View view) {

        if(view == ButtonRegister) {
            RegUser();
        }
        if(view == ButtonSignIn) {
            userLogin();
        }

        if(view == TextViewSignInMessage) {

        }
    }

}
