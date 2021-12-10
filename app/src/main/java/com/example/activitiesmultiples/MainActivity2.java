package com.example.activitiesmultiples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView imc, resultat, taula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        resultat = (TextView) findViewById(R.id.tv_resultat);
        imc = (TextView) findViewById(R.id.valor_Imc);
        taula = (TextView) findViewById(R.id.tv_taula);

        Intent i = getIntent();
        String resultado = i.getExtras().getString("resultado");
        resultat.setText(resultado);
        double pes = i.getDoubleExtra("pes", 0);
        double metres = i.getDoubleExtra("alçada",0);
        double imc = (pes/Math.pow(metres,2));
        this.imc.setText(String.valueOf(imc));


        if(imc<18.5){
            taula.setText("Pes insuficient.");
        }else if(18.5<imc && imc<24.9){
            taula.setText("Pes normal");
        }else if(25<imc && imc<26.9){
            taula.setText("Sobrepès grau I");
        }else if(27<imc && imc<29.9){
            taula.setText("Sobrepès grau II (preobesitat)");
        }else if(30<imc && imc<34.9){
            taula.setText("Obesitat de tipus I");
        }else if(35<imc && imc<39.9){
            taula.setText("Obesitat de tipus II");
        }else if(40<imc && imc<49.9){
            taula.setText("Obesitat de tipus III (mòrbida)");
        }else if(imc>50){
            taula.setText("Obesitat de tipus IV (extrema)");
        }

    }

    public void volverOnClick(View v){
        super.onBackPressed();
    }

}