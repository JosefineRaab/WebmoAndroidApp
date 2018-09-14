package com.example.josieraab.webmoandroidapp;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class MealDataStorage {

    private String fileName = "MealsOnDiscV3";


    public void saveToDisc(Context context, List<Meal> objectsToSave) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(objectsToSave);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Meal> readFromDisc(Context context) {
        List<Meal> objectsToReturn = null;

        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objectsToReturn = (List<Meal>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return objectsToReturn;
    }


}
