package com.example.guardadodatospermanentes22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String EDAD = "EDAD";
    EditText nombre, edad;
    Button bCargar, bBorrar, bGuardar;
    static final String NOMBRE_FICHERO = "DATOS";
    static final String NOMBRE = "NOMBRE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.editTextNombre);
        edad = findViewById(R.id.editTextNumber);
        bBorrar = findViewById(R.id.buttonBorrar);
        bGuardar = findViewById(R.id.buttonGuardar);
        bCargar = findViewById(R.id.buttonCargar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misDatos = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                SharedPreferences.Editor editor = misDatos.edit();

                editor.putString(NOMBRE, nombre.getText().toString());
                editor.putInt(EDAD, Integer.parseInt(edad.getText().toString()));
                editor.apply();
            }
        });

        bCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misDatos = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                nombre.setText(misDatos.getString(NOMBRE, "--No tengo nombre--"));
                edad.setText(String.valueOf(misDatos.getInt(EDAD, -1)));
            }
        });

        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misDatos = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                misDatos.edit().clear().apply();
            }
        });

    }
}