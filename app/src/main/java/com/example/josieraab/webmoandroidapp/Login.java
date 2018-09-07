package com.example.josieraab.webmoandroidapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class Login extends Activity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Toolbar toolbar = findViewById(R.id.toolbar);

      //  setSupportActionBar(toolbar);

        final EditText InputUsername =(EditText)findViewById(R.id.usernametxt);

        final EditText InputPassword=(EditText)findViewById(R.id.passwordtxt);

        final Button login= findViewById(R.id.loginButton);


        }


// TODO: Diese Funktion mit der ListUser verbinden
        private void validate ( EditText InputUsername, EditText InputPassword){
            if ((InputUsername.toString().equals("Thomas")) && (InputPassword.toString().equals("Slotos"))) {
                Intent intent = new Intent(Login.this,ShowMealPlan.class);
                startActivity(intent);
            }
            else System.out.println("@String/ErrorLogin");
    }





}