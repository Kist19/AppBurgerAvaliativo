package br.ulbra.appburgeravaliativo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogobActivity extends AppCompatActivity {
    Button btVoltar2, btMais2, btPedido2;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catalogob);
        db = new DBHelper(this);

        btVoltar2 = findViewById(R.id.btVoltar2);
        btMais2 = findViewById(R.id.btMais2);
        btPedido2 = findViewById(R.id.btPedido2);

        btPedido2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "555192959885";
                String url = "https://wa.me/" + phoneNumber;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        btVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CatalogobActivity.this, CatalogoaActivity.class);
                startActivity(i);
            }
        });
        btMais2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent am = new Intent(CatalogobActivity.this, CatalogocActivity.class);
                startActivity(am);
            }
        });
    }
}
