package udemy.java.calcularagrojetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText addvalor;
    private TextView textPercentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addvalor            = findViewById(R.id.editText_valorPago);
        textGorjeta         = findViewById(R.id.textView_valorGrojeta);
        textPercentagem     = findViewById(R.id.textView_percentagem);
        textTotal           = findViewById(R.id.textView_valorTotal);
        seekBarGorjeta      = findViewById(R.id.seekBar_selecionarPrecentagem);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPercentagem.setText( Math.round(porcentagem) + " %" );
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {

        String valorRecuperado = addvalor.getText().toString();
            if ( valorRecuperado == null || valorRecuperado.equals("") ) {
                Toast.makeText(getApplicationContext(),
                        "Digite um valor primeiro!",
                        Toast.LENGTH_SHORT
                ).show();

        } else {
                // Converter string para double
                double valorDigitado = Double.parseDouble( valorRecuperado );


                // calcula a grojeta total
                double gorjeta = valorDigitado * ( porcentagem/100 );
                double total = gorjeta + valorDigitado;
                // exibe a grojeta e total
                textGorjeta.setText("E€ " +gorjeta );
                textTotal.setText("E€ " + total );

        }
    }
}