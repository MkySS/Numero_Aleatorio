package com.example.numero_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random random = new Random();
    private int numerorandom = random.nextInt(10) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int numero_tentativas;
    public void TentarNumero (View view) {
        EditText editTextNumero = (EditText) findViewById(R.id.editTextNumero);
        TextView TextViewResultado = (TextView) findViewById(R.id.textViewResultado);
        TextView TextViewTentativas = (TextView) findViewById(R.id.textViewTentativas);

        String strTentativa = editTextNumero.getText().toString();

        int tentativa;
        try {
            tentativa = Integer.parseInt(strTentativa);
        } catch (NumberFormatException e) {
            editTextNumero.setError(getString(R.string.Campo_Obrigatorio));
            editTextNumero.requestFocus();
            return;
        }
        if (tentativa > 10 || tentativa < 1) {
            editTextNumero.setError(getString(R.string.Campo_Obrigatorio));
            editTextNumero.requestFocus();
            return;
        }
        if (numerorandom == tentativa) {
            TextViewResultado.setText(R.string.Resposta_Certa);
            numero_tentativas++;
            TextViewTentativas.setText(String.valueOf(numero_tentativas));
        } else {
            TextViewResultado.setText(R.string.Resposta_Errada);
            numero_tentativas++;
            TextViewTentativas.setText(String.valueOf(numero_tentativas));
        }
    }
}
