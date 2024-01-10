package com.example.bmicalculator.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator.R;
import com.example.bmicalculator.controller.Controller;
import com.example.bmicalculator.model.BMI;

public class MainActivity extends AppCompatActivity {

    // Les attributs de classe MainActivity
    Button btnCalculer;
    EditText etWeight;
    EditText etHeight;
    private Controller controller;
    static final int REQUEST_CODE =1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        controller = Controller.getInstance(MainActivity.this);

        etWeight.setText(String.valueOf(controller.getWeight()));
        etHeight.setText(String.valueOf(controller.getHeight()));

        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight =0, height = 0;

                boolean verifWeight = false , verifHeight = false;

                if (!etWeight.getText().toString().isEmpty())
                    weight = Double.valueOf(etWeight.getText().toString());
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre poids (en kg)", Toast.LENGTH_SHORT).show();

                if (weight <= 0)
                    Toast.makeText(MainActivity.this, "Le poids ne peut pas etre négatif", Toast.LENGTH_LONG).show();
                else
                    verifWeight = true;

                if (!etHeight.getText().toString().isEmpty())
                    height = Double.valueOf(etHeight.getText().toString());
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre taille (en m)", Toast.LENGTH_SHORT).show();

                if (height <= 0)
                    Toast.makeText(MainActivity.this, "La taille ne peut pas etre négatif", Toast.LENGTH_LONG).show();
                else
                    verifHeight = true;

                if (verifWeight && verifHeight) {

                    /* à comleter */
                    controller.createBMI(weight,height,MainActivity.this);
                    Intent intent =new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("bmi",String.valueOf(controller.getBmi()));
                    intent.putExtra("interpretation",controller.getInterpretation());
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "ERROR : RESULT_CANCELED", Toast.LENGTH_SHORT).show();
            }
    }

    private void init() {
        // à compléter
        etHeight =(EditText) findViewById(R.id.etHeight);
        etWeight =(EditText) findViewById(R.id.etWeight);
        btnCalculer =(Button) findViewById(R.id.btnCalculer);

    }
}

