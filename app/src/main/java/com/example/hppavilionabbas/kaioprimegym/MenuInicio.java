package com.example.hppavilionabbas.kaioprimegym;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuInicio extends AppCompatActivity {
    public static final String nombres ="nombre";
    public TextView cajaBienvenido;


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

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.escenario, new SessionFragment()).commit();
         cajaBienvenido=(TextView)findViewById(R.id.textView);
         String usuario = getIntent().getStringExtra("nombre");
         cajaBienvenido.setText("Bienvenido" + usuario);

    }


}
