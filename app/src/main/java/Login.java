import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.josieraab.webmoandroidapp.MealPlan;
import com.example.josieraab.webmoandroidapp.R;

public class Login extends Activity {

    private EditText username;
    private EditText password;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
    }

    username =(EditText)findViewById(R.id.usernametxt);

    password=(EditText)findViewById(R.id.passwordtxt);

    login=(EditText)

    findViewById(R.id.loginbutton);

}

    private void gültigkeit ( String userName, String userPassword){
     if ((userName =="Thomas") && (userPassword=="Slotos")) {
         Intent intent = new Intent(Intent.makeMainActivity(MealPlan))
                 startActivity(intent);
     }

}