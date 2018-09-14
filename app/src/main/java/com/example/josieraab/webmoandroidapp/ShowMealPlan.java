package com.example.josieraab.webmoandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import android.widget.TextView;
import android.widget.Toast;


public class ShowMealPlan extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView Monday;
    private TextView Tuesday;
    private TextView Wednesday;
    private TextView Thursday;
    private TextView Friday;

    private Button nextWeek;
    private Button lastWeek;
    private Button newWeek;
    private Button editWeek;
    private Button deleteWeek;


    private TextView ShowCurrentWeek;

    public final int requestCodeWeek = 789;

    int currentWeek = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_mealplan);

        mTextMessage = (TextView) findViewById(R.id.user_status);
        if (Login.isAdmin == true){mTextMessage.setText("Admin");}
        else {mTextMessage.setText("User");}


        ShowCurrentWeek = findViewById(R.id.show_week_number);
        Monday = findViewById(R.id.MealPlan_Monday_Meal);
        Tuesday = findViewById(R.id.MealPlan_Tuesday_Meal);
        Wednesday = findViewById(R.id.MealPlan_Wednesday_Meal);
        Thursday = findViewById(R.id.MealPlan_Thursday_Meal);
        Friday = findViewById(R.id.MealPlan_Friday_Meal);

        nextWeek = findViewById(R.id.next_week_button);
        lastWeek = findViewById(R.id.lastweek_button);
        newWeek = findViewById(R.id.new_week_button);
        editWeek = findViewById(R.id.edit_week_button);

        nextWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextWeek();
            }
        });

        lastWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastWeek();
            }
        });

        newWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newWeek();
            }
        });

        editWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editWeek();
            }
        });

        deleteWeek = findViewById(R.id.Delete_Button);
        deleteWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteWeek(currentWeek);
            }
        });

        populateWeek(0);


    }




    private void populateWeek(int weekNumber) {

        MealPlan week = WebMoApplication.getWeekManager().getMealPlan(weekNumber);

        Meal MonMeal = week.getListOfMeals().get(0);
        if (MonMeal == null) {Monday.setText("deleted");}
        else{
        Monday.setText(MonMeal.getName());}

        Meal TueMeal = week.getListOfMeals().get(1);
        if (TueMeal == null ){Tuesday.setText("deleted");}
        else{
        Tuesday.setText(TueMeal.getName());}

        Meal WedMeal = week.getListOfMeals().get(2);
        if (WedMeal == null ){Wednesday.setText("deleted");}
        else{
        Wednesday.setText(WedMeal.getName());}

        Meal ThuMeal = week.getListOfMeals().get(3);
        if (ThuMeal == null ){Thursday.setText("deleted");}
        else{
        Thursday.setText(ThuMeal.getName());}

        Meal FriMeal = week.getListOfMeals().get(4);
        if (FriMeal == null ){Friday.setText("deleted");}
        else{
        Friday.setText(FriMeal.getName());}

        ShowCurrentWeek.setText(String.valueOf(currentWeek));

    }

    public void editWeek() {

        MealPlan week = WebMoApplication.getWeekManager().getMealPlan(currentWeek);

        Meal MonMeal = week.getListOfMeals().get(0);
        String Mon = MonMeal.getName();

        Meal TueMeal = week.getListOfMeals().get(1);
       String Tue = TueMeal.getName();

        Meal WedMeal = week.getListOfMeals().get(2);
        String Wed = WedMeal.getName();

        Meal ThuMeal = week.getListOfMeals().get(3);
        String Thu = ThuMeal.getName();

        Meal FriMeal = week.getListOfMeals().get(4);
        String Fri =FriMeal.getName();

        Intent intent = new Intent(ShowMealPlan.this, EditWeek.class);
        intent.putExtra("Mon", Mon);
        intent.putExtra("Tue", Tue);
        intent.putExtra("Wed", Wed);
        intent.putExtra("Thu", Thu);
        intent.putExtra("Fri", Fri);
        startActivity(intent);
    }

    public void nextWeek() {

        currentWeek = currentWeek + 1;

        if (currentWeek > WebMoApplication.getWeekManager().getTotalNumberofWeeks()){
            currentWeek = currentWeek - 1;
            Toast toast = Toast.makeText(this, "No more weeks", Toast.LENGTH_SHORT);
                    toast.show();
        }
        populateWeek(currentWeek);
    }

    public void lastWeek() {

        currentWeek = currentWeek - 1;

        if (currentWeek < 0){
            currentWeek = 0;

            Toast toast = Toast.makeText(this, "No more weeks", Toast.LENGTH_SHORT);
            toast.show();
        }

        populateWeek(currentWeek);
    }

    public void newWeek(){

        Intent intent = new Intent(ShowMealPlan.this, EditWeek.class);
        startActivityForResult(intent, requestCodeWeek);

    }



    public void deleteWeek(int weeknumber){
        WebMoApplication.getWeekManager().removeWeek(weeknumber);

        currentWeek= weeknumber-1;
        if (currentWeek < 0) { currentWeek = 0;}
        populateWeek(currentWeek);

    }
}
