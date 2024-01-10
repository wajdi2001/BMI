package com.example.bmicalculator.controller;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.bmicalculator.model.BMI;

public class Controller {

    // Les attributs du classes Controller
        private static BMI bmi;
        private static Controller instance;

    // Instanciation du Contrôleur suivant le pattern Singleton
    public  static  Controller getInstance(Context context)
    {
        if(instance ==null)
        {
            instance =new Controller();
        }
        loadData(context);
        return instance;
    }
    private Controller(){
        super();
    }


    public void createBMI(double weight, double height,Context context){
        // à compléter
        bmi=new BMI(weight,height);
        saveData(weight,height,context);
    }

    // Les getters nécessaires
    public String getInterpretation()
    {
        return bmi.getInterpretation();
    }
    public double getBmi()
    {
        return bmi.getBmi();
    }

    public void saveData(double weight, double height, Context context){
        SharedPreferences sp = context.getSharedPreferences("Exam",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("weight", String.valueOf(weight));
        editor.putString("height", String.valueOf(height));
        editor.apply();
    }
    public static void loadData(Context context){
        SharedPreferences sp = context.getSharedPreferences("Exam",Context.MODE_PRIVATE);
        double w = Double.parseDouble(sp.getString("weight","0"));
        double h = Double.parseDouble(sp.getString("height","0"));
        bmi=new BMI(w,h);
    }

    public double getWeight(){
        return bmi.getWeight();
    }public double getHeight(){
        return bmi.getHeight();
    }

}
