package br.ulbra.appburgeravaliativo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogocActivity extends AppCompatActivity {
    Button btVoltar3;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catalogoc);
        db = new DBHelper(this);

        btVoltar3 = findViewById(R.id.btVoltar3);

        btVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CatalogocActivity.this, CatalogobActivity.class);
                startActivity(i);
            }
        });
    }
}
