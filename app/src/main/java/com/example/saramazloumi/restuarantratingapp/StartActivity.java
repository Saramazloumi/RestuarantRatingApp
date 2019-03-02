package com.example.saramazloumi.restuarantratingapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import model.Meal;

public class StartActivity extends AppCompatActivity implements TextWatcher {
    EditText editTextClient;
    String text;
    ArrayList<Meal> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        editTextClient = findViewById(R.id.editTextClient);
        editTextClient.addTextChangedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
           list = (ArrayList<Meal>)data.getSerializableExtra("tag");

        }else{
            Toast.makeText(this,"no valid data", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

       try{
          text = editTextClient.getText().toString().toLowerCase();
          switch (text){
              case "client":
                  Intent intent = new Intent(this, SecondActivity.class);
                  startActivityForResult(intent, 0);
                  editTextClient.setText(null);
                  break;

              case "admin":
                  Intent result = new Intent(this, ResultActivity.class);
                  result.putExtra("tag", list);
                  startActivity(result);
                  editTextClient.setText(null);
                  break;
          }

       }catch (Exception e){
           Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
       }
    }


}

