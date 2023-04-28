package com.misharuk05.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class addActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonAdd = findViewById(R.id.buttonAddWord);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToMain();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWord();
            }
        });

        dbHelper = new DBHelper(this);
    }

    private void switchToMain(){
        finish();
    }

    private void addWord(){
        EditText editTextWord = findViewById(R.id.editTextWord);
        EditText editTextTranslation = findViewById(R.id.editTextTranslation);
        String word = editTextWord.getText().toString().toLowerCase(Locale.ROOT);
        String translation = editTextTranslation.getText().toString().toLowerCase(Locale.ROOT);

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.COLUMN_WORD, word);
        contentValues.put(DBHelper.COLUMN_TRANSLATION, translation);

        database.insert(DBHelper.TABLE_NAME, null, contentValues);

        Toast toast = Toast.makeText(this, "Success!", Toast.LENGTH_SHORT);
        toast.show();
    }
}