package com.uaa.controlpersonalizado2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    private ControlLogin ctLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctLogin = (ControlLogin) findViewById(R.id.CtlLogin);

        ctLogin.setOnLoginListener(new OnLoginListener() {
            @Override
            public void onLogin(String usuario, String password) {
                //validamos el usuario y la contraseña
                if(usuario.equals("admin") && password.equals("admin")) {
                    ctLogin.setMensaje("Login correcto", Color.BLUE);
                }
                else{
                    ctLogin.setMensaje("Vuela a intentarlo", Color.RED);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
