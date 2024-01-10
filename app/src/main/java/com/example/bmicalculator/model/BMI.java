package com.example.bmicalculator.model;

public class BMI {

    private double weight;
    private double height;
    private double bmi;
    private String interpretation;

    // constructeur de la classe

    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
        calcule();
    }


    // getters nécessaires


    public double getBmi() {
        return bmi;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getInterpretation() {
        return interpretation;
    }


    // Methode de calcule et interpretation du BMI
    public void calcule()
    {
        //bmi calculé selon la formule suivante : poids(kg)/taille(m)²
        bmi = weight/(height*height);
        if(bmi <18.5){
            interpretation="Insuffisance pondérale";
        }else if(bmi>=18.5){
            interpretation="Poids normal";
        } else if (bmi>=25 || bmi<30) {
            interpretation="Surpoids";
        }
        else {
            interpretation="Obésité";
        }
    }

}