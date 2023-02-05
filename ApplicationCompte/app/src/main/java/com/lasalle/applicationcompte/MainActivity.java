package com.lasalle.applicationcompte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Compte compte = null;
    double montant = 100.;
    TextView txtSolde;
    EditText edtMontant;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compte = new Compte("Moi");

        // accès aux éléments de l'IHM
        txtSolde = (TextView) this.findViewById(R.id.txtSolde);
        txtSolde.setText(String.valueOf(compte.getSolde()));
        edtMontant = (EditText) this.findViewById(R.id.edtMontant);
        edtMontant.setText(String.valueOf(montant), TextView.BufferType.EDITABLE);
    }

    public void crediter(View view)
    {
        montant = Double.valueOf(edtMontant.getText().toString());
        compte.crediter(montant);
        txtSolde.setText(String.valueOf(compte.getSolde()));
    }

    public void debiter(View view)
    {
        montant = Double.valueOf(edtMontant.getText().toString());
        compte.debiter(montant);
        txtSolde.setText(String.valueOf(compte.getSolde()));
    }
}