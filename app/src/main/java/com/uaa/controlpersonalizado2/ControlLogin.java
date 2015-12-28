package com.uaa.controlpersonalizado2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Robert on 29/09/2015.
 * El layout utilizado en control_login tiene como elemento padre LinearLayout por lo que extenderemos
 * de este objeto
 */
public class ControlLogin extends LinearLayout {
    private EditText txtUsuario;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView lblMensaje;
    private OnLoginListener listener;

    public ControlLogin(Context context) {
        super(context);
        this.inicializar();
    }

    public ControlLogin(Context context, AttributeSet attrs) {
        super(context);
        this.inicializar();
    }

    private void inicializar(){
        //utilizamos el layout 'control_login.xml' como interfaz del control
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.control_login, this, true);

        //obtenemos las referencias a los distintos views dentro de este layout
        txtUsuario = (EditText) findViewById(R.id.TxtUsuario);
        txtPassword = (EditText) findViewById(R.id.TxtPassword);
        btnLogin = (Button) findViewById(R.id.BtnAceptar);
        lblMensaje = (TextView) findViewById(R.id.LblMensaje);

        //registramos los eventos necesarios dentro de nuestro control
        this.asignarEventos();
    }

    private void asignarEventos(){
        //cada vez que el usuario de click al boton de login. se disparará nuestro evento personalizado
        // 'onLogin'
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //al dar click en el boton se dispara nuestro evento OnLogin, utilizando de parámetros
                //el usuario y contraseña que escribió el usuarioos
                listener.onLogin(txtUsuario.getText().toString(), txtPassword.getText().toString());
            }
        });
    }

    /***
     * Metodo utilizado para mostrar un mensaje al usuario dentro de nuestro control
     * @param msg - String
     * @param color - int
     */
    public void setMensaje(String msg, int color){
        lblMensaje.setText(msg);
        lblMensaje.setTextColor(color);
    }

    /***
     * Metodo utilizado para registrar un evento 'onLogin' dentro del control
     * @param l - OnLoginListener
     */
    public void setOnLoginListener(OnLoginListener l){
        listener = l;
    }
}
