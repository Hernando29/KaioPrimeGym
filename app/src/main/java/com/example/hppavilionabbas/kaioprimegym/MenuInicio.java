package com.example.hppavilionabbas.kaioprimegym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuInicio extends AppCompatActivity {

    private Button btnMedidas;
    private Button btnAlimentacion;
    private Button btnAjustes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio);

        btnMedidas = (Button) findViewById(R.id.btnMedidas);
        btnAjustes = (Button) findViewById(R.id.btnAjustes);
        btnAlimentacion = (Button) findViewById(R.id.btnAlm);


        btnMedidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(  MenuInicio.this, Medidas.class );
                startActivity(intent);
            }
        });
    }
}
