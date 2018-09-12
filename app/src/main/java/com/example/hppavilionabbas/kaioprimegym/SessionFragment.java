package com.example.hppavilionabbas.kaioprimegym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.hppavilionabbas.kaioprimegym.entidades.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SessionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SessionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SessionFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{


    RequestQueue rq;
    JsonObjectRequest jrq;

    EditText cajaCorreo,cajaPassword;
    Button btnIniciarSesion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.activity_login, container, false);
        View vista =inflater.inflate(R.layout.activity_login,container,false);
        cajaCorreo=(EditText) vista.findViewById(R.id.textC);
        cajaPassword=(EditText) vista.findViewById(R.id.textPwd);
        btnIniciarSesion=(Button) vista.findViewById(R.id.btnLog);
        rq = Volley.newRequestQueue(getContext());

        btnIniciarSesion.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                iniciarSesion();
            }
        });
        return vista;
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"No se encontró el usuario " + error.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Usuario usuario = new Usuario();
        Toast.makeText(getContext(),"Se ha encontrado el usuario " + cajaCorreo.getText().toString(), Toast.LENGTH_SHORT).show();


        JSONArray jsonarray = response.optJSONArray("datos");
        JSONObject jsonObjectson= null;

        try
        {
            jsonObjectson = jsonarray.getJSONObject(0);

            usuario.setCorreo(jsonObjectson.optString("correo"));
            usuario.setContrasena(jsonObjectson.optString("clave"));
            usuario.setNombre(jsonObjectson.optString("nombre"));
            usuario.setApellidos(jsonObjectson.optString("apellido"));

        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        Intent intencion = new Intent (getContext(), MenuInicio.class);
        intencion.putExtra(MenuInicio.nombres, usuario.getNombre());
        startActivity(intencion);



    }
    public void iniciarSesion()
    {
        String url ="https://kaioprimegym.000webhostapp.com/sesion.php?correo="+cajaCorreo.getText().toString()+"&clave="+cajaPassword.getText().toString();
        jrq= new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);
    }
}

