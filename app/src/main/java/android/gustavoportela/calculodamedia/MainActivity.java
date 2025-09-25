package android.gustavoportela.calculodamedia;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText nota1, nota2, nota3, nota4,nomeUsuario,numeroFaltas;
    private Button btnCalcular;
    private TextView resultado;

    private String nome;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initComponentes();

        btnCalcular.setOnClickListener(view -> {
            validaCampos();
            calculaMedia();
            receberNomeUser();
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });


        }


        private void receberNomeUser(){


        }

    private void calculaMedia() {
        String nomeUser = (nomeUsuario.getText().toString());
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());
        double n3 = Double.parseDouble(nota3.getText().toString());
        double n4 = Double.parseDouble(nota4.getText().toString());

        double media = (n1 + n2 + n3 + n4) / 4;
        double faltas = Double.parseDouble(numeroFaltas.getText().toString());
        if (media >= 7) {
            if (faltas < 20) {
                resultado.setTextColor(Color.parseColor("#437845"));
                resultado.setText("Olá " + nomeUser + " aprovado com média " + media);
            } else {
                resultado.setTextColor(Color.parseColor("#F44336"));
                resultado.setText("Olá " + nomeUser + " com excesso de faltas: " + faltas);
            }
        } else {
            resultado.setTextColor(Color.parseColor("#F44336"));
            resultado.setText("Olá " + nomeUser + " retido com média " + media);
        }



    }

    private boolean validaCampos() {
        return nota1.getText().toString().isEmpty()
                && nota2.getText().toString().isEmpty()
                && nota3.getText().toString().isEmpty()
                && nota4.getText().toString().isEmpty();
    }


    private void initComponentes() {
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        nomeUsuario = findViewById(R.id.nomeUser);
        numeroFaltas = findViewById(R.id.faltas);
        btnCalcular = findViewById(R.id.calcular_btn);
        resultado = findViewById(R.id.resultado);


    }
}