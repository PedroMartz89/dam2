package com.example.calcularnumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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


        Button btnSumar = findViewById(R.id.btnSuma);
        Button btnRestar = findViewById(R.id.btnResta);
        Button btnMultiplicar = findViewById(R.id.btnMulti);
        Button btnDividir = findViewById(R.id.btnDiv);
        TextView tvResultado = findViewById(R.id.tvResultFinal);
        EditText operador1 = findViewById(R.id.etNum1);
        EditText operador2 = findViewById(R.id.etNum2);

        btnSumar.setOnClickListener(v -> {

            if (operador1.getText().toString().isEmpty() || operador2.getText().toString().isEmpty()) {

                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();

            } else {

                int resultadoFinal = Integer.parseInt(operador1.getText().toString()) + Integer.parseInt(operador2.getText().toString());
                tvResultado.setText(String.valueOf(resultadoFinal));

            }


        });

        btnRestar.setOnClickListener(v -> {
            if (operador1.getText().toString().isEmpty() || operador2.getText().toString().isEmpty()) {

                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();

            } else {

                int resultadoFinal = Integer.parseInt(operador1.getText().toString()) - Integer.parseInt(operador2.getText().toString());
                tvResultado.setText(String.valueOf(resultadoFinal));

            }

        });

        btnMultiplicar.setOnClickListener(v -> {

            if (operador1.getText().toString().isEmpty() || operador2.getText().toString().isEmpty()) {

                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();

            } else {

                int resultadoFinal = Integer.parseInt(operador1.getText().toString()) * Integer.parseInt(operador2.getText().toString());
                tvResultado.setText(String.valueOf(resultadoFinal));

            }
        });

        btnDividir.setOnClickListener(v -> {

            if (operador1.getText().toString().isEmpty() || operador2.getText().toString().isEmpty()) {

                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();

            } else {

                int resultadoFinal = Integer.parseInt(operador1.getText().toString()) / Integer.parseInt(operador2.getText().toString());
                tvResultado.setText(String.valueOf(resultadoFinal));

            }

        });
    }

}