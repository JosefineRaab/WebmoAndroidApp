package com.example.josieraab.webmoandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    final EditText InputUsername =(EditText)findViewById(R.id.usernametxt);

    final EditText InputPassword=(EditText)findViewById(R.id.passwordtxt);

    final Button login= findViewById(R.id.loginButton);


// TODO: Diese Funktion mit der ListUser verbinden
    private void validate ( EditText InputUsername, EditText InputPassword){
     if ((InputUsername.toString() =="Thomas") && (InputPassword.toString()=="Slotos")) {
         Intent intent = new Intent(Login.this,ShowMealPlan.class);
                 startActivity(intent);
     }
     else System.out.println("@String/ErrorLogin");
}}