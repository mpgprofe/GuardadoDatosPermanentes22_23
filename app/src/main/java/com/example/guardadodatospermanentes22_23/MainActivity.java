package com.example.guardadodatospermanentes22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements DialogoHora.CuandoEsteSeleccionadaLaHora{

    private static final String EDAD = "EDAD";
    EditText nombre, edad;
    Button bCargar, bBorrar, bGuardar,bHora;
    TextView textViewHora;
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
        bHora = findViewById(R.id.buttonHora);
        textViewHora = findViewById(R.id.textViewHora);

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

        bHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(getSupportFragmentManager(),"Mi ventana para la hora");
            }
        });


    }

    @Override
    public void enSeleccion(GregorianCalendar laHora) {
        textViewHora.setText(laHora.get(GregorianCalendar.HOUR_OF_DAY)+":"+laHora.get(GregorianCalendar.MINUTE));
    }
}