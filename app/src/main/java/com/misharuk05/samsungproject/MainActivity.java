package com.misharuk05.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonFind = findViewById(R.id.buttonFind);
        Button buttonPlay = findViewById(R.id.buttonPlay);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToAdd();
            }
        });
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToFind();
            }
        });
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToGame();
            }
        });
    }

    private void switchToAdd(){
        Intent intent = new Intent(this, addActivity.class);
        startActivity(intent);
    }

    private void switchToFind(){
        Intent intent = new Intent(this, FindActivity.class);
        startActivity(intent);
    }

    private void switchToGame(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}