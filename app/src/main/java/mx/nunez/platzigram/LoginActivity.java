package mx.nunez.platzigram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mx.nunez.platzigram.view.ContainerActivity;
import mx.nunez.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void goInitSession(View view){
        TextView tv1 = (TextView) findViewById(R.id.username);
        String usuario = tv1.getText().toString();

        TextView tv2 = (TextView) findViewById(R.id.password);
        String password = tv2.getText().toString();

        if(usuario.equals("Felix") && password.equals("12345")){
            Intent intent = new Intent(this, ContainerActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Usuario no válido", Toast.LENGTH_SHORT).show();
        }


    }
    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
}
