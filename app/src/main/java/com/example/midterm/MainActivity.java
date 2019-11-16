package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String User = "A", Pass = "S";

    EditText etUsername,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        findView();
        Login();

    }

    private void findView(){
        etUsername = findViewById(R.id.et_UserName);
        etPassword = findViewById(R.id.et_Password);
        btnLogin = findViewById(R.id.btn_Login);
    }

    private void Login(){

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputU = etUsername.getText().toString();
                String inputP = etPassword.getText().toString();

                if (inputU.equals(User) && inputP.equals(Pass)){
                    Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"NO",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
