package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ID;
    private EditText Pass;
    private Button Login;

    public void login(View view)
    {
        validate(ID.getText().toString(),Pass.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ID = (EditText)findViewById(R.id.ID);
        Pass = (EditText)findViewById(R.id.pass);
        Login = (Button)findViewById(R.id.button);





    }

    private void validate(String userName, String userPassword){
        if((userName.equals("admin"))&& (userPassword.equals("123"))){
            Intent intent = new Intent(MainActivity.this, Homepage.class);
            startActivity(intent);
        }else
        {
            Toast.makeText(MainActivity.this,"Wrong ID or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
