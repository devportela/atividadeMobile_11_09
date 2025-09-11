package android.gustavoportela.calculodamedia;

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


    private EditText nota1, nota2, nota3, nota4, numeroFaltas;
    private Button btnCalcular;
    private TextView resultado;

    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initComponentes();

        btnCalcular.setOnClickListener(view->{
            validaCampos();
            calculaMedia():
        });






        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initComponentes();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    private void calculaMedia() {
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());
        double n3 = Double.parseDouble(nota3.getText().toString());
        double n4 = Double.parseDouble(nota4.getText().toString());
        double media = (n1 + n2 + n3 + n4) / 4;
        double faltas = Double.parseDouble(numeroFaltas.getText().toString());

        if (media > 7){
            if (faltas < 20){
                resultado.setTextColor(Color.parseColor("#437845"));
            }else{
                resultado.setTextColor(Color.parseColor("#F44336"));

            }else
        }


    }

    private void validaCampos() {
        if (TextUtils.isEmpty(nota1.getText())){
            nota1.setError("este campo nao pode estar vazio...");
        } else if (TextUtils.isEmpty(nota2.getText())) {
            nota1.setError("este campo nao pode estar vazio...");
        } else if (TextUtils.isEmpty(nota3.getText())) {
            nota1.setError("este campo nao pode estar vazio...");
        } else if (TextUtils.isEmpty(nota4.getText())) {
            nota1.setError("este campo nao pode estar vazio...");
        }
    }

    private void initComponentes() {
        nota1 = findViewById(R.id.nota1_et);
        nota1 = findViewById(R.id.nota2_et);
        nota1 = findViewById(R.id.nota3_et);
        nota1 = findViewById(R.id.nota4_et);
        numeroFaltas = findViewById(R.id.faltas_et);
        btnCalcular = findViewById(R.id.calcular_btn);
        resultado = findViewById(R.id.resultado_tv);


    }
}