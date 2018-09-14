package com.example.josieraab.webmoandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditMeal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText Meal_Name_Input;
    private EditText Meal_Price_Input;
    private String Meal_Type_Input;
    private Button SaveButton;
    private Button DeleteButton;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_meal);
        Meal_Name_Input = (EditText) findViewById(R.id.Meal_Name_content);
        Meal_Price_Input = (EditText) findViewById(R.id.Meal_Price_content);
        SaveButton = findViewById(R.id.Save_Button);
        DeleteButton = findViewById(R.id.Delete_Button);

        Spinner spinner = (Spinner) findViewById(R.id.Meal_type_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.MealType, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Integer id = extras.getInt("id");
            String name = extras.getString("name");
            Float price = extras.getFloat("price");
            String type = extras.getString("type");

            this.id = id;
            Meal_Name_Input.setText(name);
            Meal_Price_Input.setText(price.toString());
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sSelected = parent.getItemAtPosition(position).toString();
        Meal_Type_Input = sSelected;
        // Toast.makeText(this, sSelected, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void save() {


        Intent intent = new Intent();
        intent.putExtra("id", id);
        intent.putExtra("name", Meal_Name_Input.getText().toString());
        intent.putExtra("price", Float.valueOf(Meal_Price_Input.getText().toString()));
        intent.putExtra("type", Meal_Type_Input);

        setResult(RESULT_OK, intent);
        finish();

    }

    public void delete() {

        Intent intent = new Intent();
        intent.putExtra("id", id);
        intent.putExtra("status", "deleted");


        setResult(RESULT_OK, intent);
        finish();

    }
}
