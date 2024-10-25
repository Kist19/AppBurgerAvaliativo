package br.ulbra.appburgeravaliativo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtEmailentrar, edtSenhaentrar;
    Button btEntrar, btCriarConta;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        edtEmailentrar = findViewById(R.id.edtEmailentrar);
        edtSenhaentrar = findViewById(R.id.edtSenhaentrar);
        btEntrar = findViewById(R.id.btEntrar);
        btCriarConta = findViewById(R.id.btCriarConta);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = edtEmailentrar.getText().toString();
                String Password = edtSenhaentrar.getText().toString();
                if (Email.equals("")) {
                    Toast.makeText(MainActivity.this, "Usuario não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                } else if (Password.equals("")) {
                    Toast.makeText(MainActivity.this, "Senha não inserida, tente novamente", Toast.LENGTH_SHORT).show();
                } else {
                    String res = db.validarLogin(Email, Password);
                    if (res.equals("OK")) {
                        Toast.makeText(MainActivity.this, "Login OK!!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, CatalogoaActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "Login ou Senha errado(s)!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(i);
            }
        });
    }
}