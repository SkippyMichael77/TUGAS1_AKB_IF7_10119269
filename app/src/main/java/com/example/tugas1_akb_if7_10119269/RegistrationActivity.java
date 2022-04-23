package com.example.tugas1_akb_if7_10119269;

//21 April 2022, 10119269, Zuhair Rasyid Wafi, IF7

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private Button btnregister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnregister2 = findViewById(R.id.btn_register2);

        btnregister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aksi
                Intent pindahRegister2 = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(pindahRegister2);
            }
        });
    }
}