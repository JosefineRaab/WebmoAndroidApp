package com.example.josieraab.webmoandroidapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.josieraab.webmoandroidapp.R.*;


public class Login extends AppCompatActivity {

    private EditText usernamelogin;
    private EditText PasswordLogin;
    private Button action_login;
    public static Boolean isAdmin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.login);

        usernamelogin = (EditText)findViewById(id.usernametxt);
        PasswordLogin = (EditText)findViewById(id.passwordtxt);
        action_login = (Button)findViewById(id.loginButton);


        action_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(usernamelogin.getText().toString(), PasswordLogin.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("User")) && (userPassword.equals("1234"))){
            isAdmin = false;
            Intent intent = new Intent(Login.this, Navigate.class);
            startActivity(intent);

        } if ((userName.equals("Admin"))&& (userPassword.equals("1234567") ))
        {
            isAdmin= true;
            Intent intent = new Intent(Login.this, Navigate.class);
            startActivity(intent); }

            else {Context context = getApplicationContext();
            CharSequence text = "Wrong Password!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();}


        }
        }



