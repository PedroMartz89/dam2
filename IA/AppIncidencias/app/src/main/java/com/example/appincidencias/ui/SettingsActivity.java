package com.example.appincidencias.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.example.appincidencias.R;
import com.example.appincidencias.utils.AppPreferences;
import com.example.appincidencias.worker.EmailWorker;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.TimeUnit;

public class SettingsActivity extends AppCompatActivity {

    private TextInputEditText etEmail;
    private MaterialSwitch swEnvio;
    private AppPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        etEmail = findViewById(R.id.etEmail);
        swEnvio = findViewById(R.id.swEnvio);

        prefs = new AppPreferences(this);
        etEmail.setText(prefs.getEmail());
        swEnvio.setChecked(prefs.isEnvioActivo());

        swEnvio.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.setEnvioActivo(isChecked);
            if (isChecked) {
                programarEnvioCorreo();
            } else {
                cancelarEnvioCorreo();
            }
        });

        etEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                prefs.setEmail(etEmail.getText().toString().trim());
            }
        });
    }

    private void programarEnvioCorreo() {
        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(
                EmailWorker.class, 1, TimeUnit.HOURS)
                .build();

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
                "envioCorreoWorker",
                ExistingPeriodicWorkPolicy.KEEP,
                request);
    }

    private void cancelarEnvioCorreo() {
        WorkManager.getInstance(this).cancelUniqueWork("envioCorreoWorker");
    }

    @Override
    protected void onPause() {
        super.onPause();
        prefs.setEmail(etEmail.getText().toString().trim());
    }
}