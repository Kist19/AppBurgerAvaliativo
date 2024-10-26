package br.ulbra.appburgeravaliativo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogoaActivity extends AppCompatActivity {
    Button btVoltar1, btMais1, btPedido1;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catalogoa);
        db = new DBHelper(this);

        btPedido1 = findViewById(R.id.btPedido1);
        btVoltar1 = findViewById(R.id.btVoltar1);
        btMais1 = findViewById(R.id.btMais1);

        btPedido1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "555192959885";
                String url = "https://wa.me/" + phoneNumber;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        btVoltar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CatalogoaActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btMais1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ma = new Intent(CatalogoaActivity.this, CatalogobActivity.class);
                startActivity(ma);
            }
        });
    }
}
