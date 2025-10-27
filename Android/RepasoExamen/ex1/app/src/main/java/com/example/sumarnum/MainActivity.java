package com.example.sumarnum;

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

    private TextView resultado;

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

        resultado = findViewById(R.id.tvResult);
        EditText num1 = findViewById(R.id.etNum1);
        EditText num2 = findViewById(R.id.etNum2);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(v -> {

            String texto1 = num1.getText().toString();
            String texto2 = num2.getText().toString();
            if (texto1.isEmpty() || texto2.isEmpty()) {

                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            int operador1 = Integer.parseInt(texto1);
            int operador2 = Integer.parseInt(texto2);
            calcularSuma(operador1, operador2);
        });

    }

    public void calcularSuma(int num1, int num2) {
        int total = num1 + num2;
        resultado.setText(String.valueOf(total));
    }

}