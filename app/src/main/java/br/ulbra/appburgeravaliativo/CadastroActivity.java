package br.ulbra.appburgeravaliativo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {
    EditText edtNomecadastro, edtEmailcadastro, edtSenhacadastro, edtTelefonecadastro;
    Button btSalvarcadastro;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        db = new DBHelper(this);

        edtNomecadastro = (EditText) findViewById(R.id.edtNomecadastro);
        edtEmailcadastro = (EditText) findViewById(R.id.edtEmailcadastro);
        edtSenhacadastro = (EditText) findViewById(R.id.edtSenhacadastro);
        edtTelefonecadastro = (EditText) findViewById(R.id.edtTelefonecadastro);

        btSalvarcadastro = (Button) findViewById(R.id.btSalvarcadastro);

        btSalvarcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = edtNomecadastro.getText().toString();
                String Email = edtEmailcadastro.getText().toString();
                String Password = edtSenhacadastro.getText().toString();
                String Phone = edtTelefonecadastro.getText().toString();
                if (Name.equals("")) {
                    Toast.makeText(CadastroActivity.this, "Insira o Nome DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (Email.equals("")) {
                    Toast.makeText(CadastroActivity.this, "Insira o E-mail DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (Password.equals("")) {
                    Toast.makeText(CadastroActivity.this, "Insira a Senha DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (Phone.equals("")) {
                    Toast.makeText(CadastroActivity.this, "Insira o Telefone DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else {
                    long res = db.criarUtilizador(Name, Email, Password, Phone);
                    if (res > 0) {
                        //nesta parte você poderá chamar a tela principal do sistema autenticado
                        Toast.makeText(CadastroActivity.this, "Registro OK", Toast.LENGTH_SHORT).show();
                        Intent ab = new Intent(CadastroActivity.this,MainActivity.class);
                        startActivity(ab);
                    } else {
                        Toast.makeText(CadastroActivity.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}