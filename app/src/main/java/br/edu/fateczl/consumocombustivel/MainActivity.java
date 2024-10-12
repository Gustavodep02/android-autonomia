package br.edu.fateczl.consumocombustivel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {

    private Button btnCalc;
    private EditText etAutonomia, etRestante;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());

    }
    private void calc(){
        etAutonomia = findViewById(R.id.etAutonomia);
        etRestante = findViewById(R.id.etRestante);

        double autonomia = Double.parseDouble(etAutonomia.getText().toString());
        double restante = Double.parseDouble(etRestante.getText().toString());

        double consumo = (autonomia * restante) *1000;

        String resultado = getString(R.string.resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setText(resultado + consumo+" m ");
    }
}