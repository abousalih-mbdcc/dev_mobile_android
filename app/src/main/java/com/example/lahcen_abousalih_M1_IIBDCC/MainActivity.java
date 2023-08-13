package com.example.lahcen_abousalih_M1_IIBDCC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.examen.R;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPwd;
    Button login;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername =findViewById(R.id.usrname);
        editTextPwd =findViewById(R.id.pswd);
        login=findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences("loginPref",
                MODE_PRIVATE);
        login.setOnClickListener(view -> {
            if(sharedPreferences==null) sharedPreferences=getSharedPreferences("loginPref",MODE_PRIVATE);
            String username = editTextUsername.getText().toString();
            String pwd = editTextPwd.getText().toString();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("usernameKey", username);
            editor.putString("pwdKey", pwd);
            editor.commit();
            editTextUsername.setText("");
            editTextPwd.setText("");
            Intent i=new Intent(MainActivity.this,IpFinderActivity.class);
            startActivity(i);

        });
    }
}