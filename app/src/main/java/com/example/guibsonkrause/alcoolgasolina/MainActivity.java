package com.example.guibsonkrause.alcoolgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                String precoAlcool = editPrecoAlcool.getText().toString();
                String precoGasolina = editPrecoGasolina.getText().toString();

                Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

                if (camposValidados)
                {
                    calcularMelhorPreco(precoAlcool, precoGasolina);

                }else {
                    textResultado.setText("Preencha os preços primeiro!");
                }
            }
        });
    }

    public Boolean validarCampos(String pAlcool, String pGasolina)
    {
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals(""))
            camposValidados = false;
        else if (pGasolina == null || pGasolina.equals(""))
            camposValidados = false;

        return camposValidados;
    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina)
    {
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoAlcool / precoGasolina;
        if (resultado >= 0.7)
            textResultado.setText("Melhor utilizar Gasolina!");
        else
            textResultado.setText("Melhor utilizar Álcool!");
    }
}
