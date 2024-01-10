package com.example.bmicalculator.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.bmicalculator.R;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ResultActivity extends AppCompatActivity {

    // attributs de classe ResultActivity
    private TextView tvBMI;
   private TextView tvInterpretation;
   private Button btnReturn;
   private Button btnReturnWithoutData;

    SharedPreferences sp = getSharedPreferences("Exam", Context.MODE_PRIVATE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();

        // affichage de la valeur de l'IMC et de l'interprétation obtenue
        Intent intent = getIntent();

        tvBMI.setText("IMC : "+intent.getStringExtra("bmi"));
        tvInterpretation.setText(intent.getStringExtra("interpretation"));


        btnReturn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent();
                // à completer
                if(!tvBMI.getText().toString().isEmpty() && !tvInterpretation.getText().toString().isEmpty()){
                    setResult(RESULT_OK,intent1);
                }
                else {
                    setResult(RESULT_CANCELED,intent1);
                }
                finish();
            }
        });
        btnReturnWithoutData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("Exam", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove("weight");
                editor.remove("height");
                editor.apply();


            }
        });



    }

    private void init()
    {
        /* à completer */
        tvBMI =(TextView) findViewById(R.id.tvBMI);
        tvInterpretation =(TextView) findViewById(R.id.tvInterpretation);
        btnReturn =(Button) findViewById(R.id.btnReturn);
        btnReturnWithoutData =(Button) findViewById(R.id.btnReturnWithoutData);

    }

}