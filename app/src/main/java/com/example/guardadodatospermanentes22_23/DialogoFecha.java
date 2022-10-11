package com.example.guardadodatospermanentes22_23;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DialogoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    CuandoLaFechaCambie miFecha;

    @Override
    public void onDateSet(DatePicker datePicker, int año, int mes, int día) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(año, mes, día);
        miFecha.fechaSeleccionada(gregorianCalendar);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int año = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int día = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, año, mes,día);
    }

    public interface CuandoLaFechaCambie {
        public void fechaSeleccionada(GregorianCalendar fecha);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        miFecha = (CuandoLaFechaCambie) context;
        super.onAttach(context);
    }
}
