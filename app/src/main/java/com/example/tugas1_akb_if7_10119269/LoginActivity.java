package com.example.tugas1_akb_if7_10119269;

//21 April 2022, 10119269, Zuhair Rasyid Wafi, IF7

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnlogin;
    private Button btnregister;
    private EditText username_Data;
    private String username;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setData();

        btnregister = findViewById(R.id.btn_register);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aksi
                Intent pindahRegister = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(pindahRegister);
            }
        });
    }

    public void initView(){
        btnlogin = findViewById(R.id.btn_login);
        username_Data = findViewById(R.id.usernameData);
    }

    public void setData(){
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = username_Data.getText().toString();
                //Aksi
                Intent pindahHome = new Intent(LoginActivity.this, MainActivity.class);
                pindahHome.putExtra("username",username);
                startActivity(pindahHome);
            }
        });
    }

    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}