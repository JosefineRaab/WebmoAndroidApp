package com.example.josieraab.webmoandroidapp;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;

public class MealTableDataAdapter extends TableDataAdapter<Meal> {


    private int paddingLeft = 20;
    private int paddingTop = 15;
    private int paddingRight = 20;
    private int paddingBottom = 15;
    private int textSize = 18;
    private int typeface = Typeface.NORMAL;
    private int textColor = 0x99000000;


    public MealTableDataAdapter(Context context, List<Meal> data) {
        super(context, data);
    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {

        Meal meal = getRowData(rowIndex);

        final TextView textView = new TextView(getContext());
        textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        textView.setTypeface(textView.getTypeface(), typeface);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);

        switch (columnIndex) {
            case 0: // Id
                textView.setText(Integer.toString(meal.getMealId()));
                break;
            case 1: // Name
                textView.setText(meal.getName());

                break;
            case 2: // Price
                textView.setText(String.format("%.2f", meal.getPrice()));

                break;
            case 3: // Type
                textView.setText(meal.getMealType().toString());
                break;
        }

        return textView;
    }

}