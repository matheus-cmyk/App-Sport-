package com.example.appsport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtPassos;
    RadioGroup rgTamanhos;
    CheckBox chkCorrida;
    Button btnCalcular;
    TextView txtR1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtPassos = findViewById(R.id.edtPassos);
        rgTamanhos = findViewById(R.id.rgTamanhos);
        chkCorrida = findViewById(R.id.chkCorrida);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtR1 = findViewById(R.id.txtR1);
        DecimalFormat f = new DecimalFormat("0.00");

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passosStr = edtPassos.getText().toString();

                if (passosStr.isEmpty()){
                    Toast.makeText(MainActivity.this, "Por favor, insira a quantidade de passos", Toast.LENGTH_SHORT).show();
                    return;
                }
                int numPassos = Integer.parseInt(passosStr);
                double tamanhoPassos = 0;
                int selectRadioButtonId = rgTamanhos.getCheckedRadioButtonId();

                if (selectRadioButtonId == R.id.rbCurto){
                    tamanhoPassos = 0.5;
                } else if (selectRadioButtonId == R.id.rbLongo){
                    tamanhoPassos = 1;
                } else if (selectRadioButtonId == R.id.rbMedio){
                    tamanhoPassos = 0.7;
                }
                double distancia = numPassos * tamanhoPassos;

                if (chkCorrida.isChecked()){
                    distancia *= 1.1;
                }

                txtR1.setText("Distância Percorrida: " + f.format(distancia));
            }
        });
    }
}