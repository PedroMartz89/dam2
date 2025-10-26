package com.example.appcalculadoraconstraint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String numActual = "";
    private int numAnterior = 0;

    private int operador = 0; // 1 = suma, 2 = resta,  3 = mult, 4 = div, 5 = porce

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvDisplay = findViewById(R.id.tvResult);
        int[] botonesNumeros = {
                R.id.bttn0, R.id.bttn1, R.id.bttn2, R.id.bttn3,
                R.id.bttn4, R.id.bttn5, R.id.bttn6, R.id.bttn7,
                R.id.bttn8, R.id.bttn9
        };
        View.OnClickListener listenerNum = v -> {
            Button btn = (Button) v;
            numActual = btn.getText().toString();
            tvDisplay.setText(numActual);
        };

        for (int id : botonesNumeros) {

            findViewById(id).setOnClickListener(listenerNum);
        }

        Button btnSumar = findViewById(R.id.bttnSum);
        Button btnRestar = findViewById(R.id.bttnRest);
        Button btnMult = findViewById(R.id.bttnMult);
        Button btnIgual = findViewById(R.id.bttnIgual);
        Button btnDiv = findViewById(R.id.bttnDiv);
        Button btnPorc = findViewById(R.id.bttnPorc);
        Button btnE = findViewById(R.id.bttnE);
        Button btnAC = findViewById(R.id.bttnAC);

        btnSumar.setOnClickListener(v -> {

            setOperador(1);
            numAnterior = Integer.parseInt(numActual);
            numActual = "";
        });

        btnRestar.setOnClickListener(v -> {

            setOperador(2);
            numAnterior = Integer.parseInt(numActual);
            numActual = "";
        });

        btnMult.setOnClickListener(v -> {

            setOperador(3);
            numAnterior = Integer.parseInt(numActual);
            numActual = "";
        });

        btnDiv.setOnClickListener(v -> {

            setOperador(4);
            numAnterior = Integer.parseInt(numActual);
            numActual = "";
        });

        btnPorc.setOnClickListener(v -> {

            setOperador(5);
            numAnterior = Integer.parseInt(numActual);
            numActual = "";
        });

        btnIgual.setOnClickListener(v -> {

            if (operador == 1) {
                int resultado = numAnterior + Integer.parseInt(numActual);
                tvDisplay.setText(resultado);

            } else if (operador == 2) {

                int resultado = numAnterior - Integer.parseInt(numActual);
                tvDisplay.setText(resultado);

            } else if (operador == 3) {

                int resultado = numAnterior * Integer.parseInt(numActual);
                tvDisplay.setText(resultado);

            } else if (operador == 4) {

                int resultado = numAnterior / Integer.parseInt(numActual);
                tvDisplay.setText(resultado);

            } else if (operador == 5) {

                int resultado = numAnterior * Integer.parseInt(numActual) / 100;
                tvDisplay.setText(resultado);

            }


        });

        btnE.setOnClickListener(v -> {

            tvDisplay.setText("");
            numActual = "";
        });

        btnAC.setOnClickListener(v -> {

            tvDisplay.setText("");
            numActual = "";
            numAnterior = 0;
            operador = 0;

        });
    }


    public int getNumAnterior() {
        return numAnterior;
    }

    public void setNumAnterior(int numAnterior) {
        this.numAnterior = numAnterior;
    }

    public int getOperador() {
        return operador;
    }

    public void setOperador(int operador) {
        this.operador = operador;
    }
}