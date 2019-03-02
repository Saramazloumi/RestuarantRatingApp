package com.example.saramazloumi.restuarantratingapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.Meal;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewResult;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewResult = findViewById(R.id.textViewResult);
        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
        ArrayList<Meal> list = (ArrayList<Meal>) getIntent().getExtras().getSerializable("tag");
        for (int i = 0; i < list.size(); i++) {
            textViewResult.setText(list.toString());
        }
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
