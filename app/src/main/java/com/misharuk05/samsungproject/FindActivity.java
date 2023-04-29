package com.misharuk05.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FindActivity extends AppCompatActivity {
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonFind = findViewById(R.id.buttonFind);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToMain();
            }
        });
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findWord();
            }
        });
    }

    private void switchToMain(){
        finish();
    }

    private void findWord(){
        EditText editTextWord = findViewById(R.id.editTextFindWord);
        EditText editTextTranslation = findViewById(R.id.editTextFindTranslation);
        String word = editTextWord.getText().toString();
        String translation = editTextTranslation.getText().toString();

        if(word.isEmpty() && translation.isEmpty()){
            Toast toast = Toast.makeText(this, "Please enter word and try again", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(!word.isEmpty()){
            Toast toast = Toast.makeText(this, "Finding " + word, Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(this, "Finding " + translation, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void searchInDB(boolean isFindingInWords, String word){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        String[] projection = {
//                db.COLUMN_ID,
//                GuestEntry.COLUMN_NAME,
//                GuestEntry.COLUMN_CITY,
//                GuestEntry.COLUMN_GENDER,
//                GuestEntry.COLUMN_AGE };
//        if(isFindingInWords){
//
//        }
    }
}