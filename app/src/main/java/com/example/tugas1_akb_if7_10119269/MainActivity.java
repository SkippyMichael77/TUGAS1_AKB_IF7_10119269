package com.example.tugas1_akb_if7_10119269;

//22 April 2022, 10119269, Zuhair Rasyid Wafi, IF7

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView UNPass;
    private String username;
    private CardView btnprofile,btnlogout;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();

        btnprofile = findViewById(R.id.btn_profile);
        btnlogout = findViewById(R.id.btn_logout);

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aksi
                Intent pindahProfile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(pindahProfile);
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aksi
                Intent pindahLogout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(pindahLogout);
            }
        });
    }

    public void initView(){
        UNPass = findViewById(R.id.usernameMain);
    }

    public void setData(){
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        UNPass.setText(username);
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