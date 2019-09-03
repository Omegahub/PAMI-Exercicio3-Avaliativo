package br.com.exercicio_pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText txtChopp;
    EditText txtPizza;
    EditText txtRecheio;
    EditText txtPessoa;
    TextView lblresuConsumo;
    TextView lblresuTotal;
    TextView lblresuServico;
    TextView lblresuPessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtChopp = findViewById(R.id.txtChopp);
        txtPizza = findViewById(R.id.txtPizza);
        txtRecheio = findViewById(R.id.txtRecheio);
        txtPessoa = findViewById(R.id.txtPessoa);
        lblresuConsumo = findViewById(R.id.lblresuConsumo);
        lblresuTotal = findViewById(R.id.lblresuTotal);
        lblresuServico = findViewById(R.id.lblresuServico);
        lblresuPessoa = findViewById(R.id.lblresuPessoa);
    }

    public void onCalcular (View v)
    {

        if(txtChopp.getText().toString().isEmpty() || txtPizza.getText().toString().isEmpty() || txtRecheio.getText().toString().isEmpty() || txtPessoa.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Digite um valor",Toast.LENGTH_SHORT).show();
        }

        else
        {
            double chopp = Double.parseDouble(txtChopp.getText().toString());
            double pizza = Double.parseDouble(txtPizza.getText().toString());
            double recheio = Double.parseDouble(txtRecheio.getText().toString());
            double pessoa = Double.parseDouble(txtPessoa.getText().toString());
            double valorchopp = 7.3 * chopp;
            double valorpizza = 31.5 * pizza;
            double valorRecheio = 5.9 * recheio;
            double consumo = valorchopp + valorpizza + valorRecheio;
            double servico = consumo * 0.1;
            double total = servico + consumo;
            double porpessoa = total / pessoa;
            if(pessoa  > 0) {
                lblresuConsumo.setText(String.format("%.2f", consumo));
                lblresuServico.setText(String.format("%.2f", servico));
                lblresuTotal.setText(String.format("%.2f", total));
                lblresuPessoa.setText(String.format("%.2f", porpessoa));
            }
            else
            {
                Toast.makeText(this,"Digite a quantidade de pessoas",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
