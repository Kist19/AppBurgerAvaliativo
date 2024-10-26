package br.ulbra.appburgeravaliativo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogocActivity extends AppCompatActivity {
    Button btVoltar3, btPedido3;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catalogoc);
        db = new DBHelper(this);

        btVoltar3 = findViewById(R.id.btVoltar3);
        btPedido3 = findViewById(R.id.btPedido3);

        btPedido3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "555192959885";
                String url = "https://wa.me/" + phoneNumber;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        btVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CatalogocActivity.this, CatalogobActivity.class);
                startActivity(i);
            }
        });
    }
}
