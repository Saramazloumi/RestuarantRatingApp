package com.example.saramazloumi.restuarantratingapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.Meal;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinnerRestaurant;
    ImageView imageViewFood;
    RatingBar ratingBarRestaurant;
    Button btnSave, btnFinish;
    ArrayAdapter adapter;
    String mealName;
    ArrayList<Meal> mealList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
    }

    private void initialize() {
        spinnerRestaurant = findViewById(R.id.spinnerRestaurant);
        imageViewFood = findViewById(R.id.imageViewFood);
        ratingBarRestaurant = findViewById(R.id.ratingBarRestaurant);
        btnSave = findViewById(R.id.btnSave);
        btnFinish = findViewById(R.id.btnFinish);
        adapter = ArrayAdapter.createFromResource(this,R.array.food, android.R.layout.simple_dropdown_item_1line);
        spinnerRestaurant.setAdapter(adapter);
        spinnerRestaurant.setOnItemSelectedListener(this);
        btnSave.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        mealName = (String)spinnerRestaurant.getSelectedItem();
        float mealRate = ratingBarRestaurant.getRating();

        switch (v.getId()) {

            case R.id.btnSave:
                Meal meal = new Meal(mealName, mealRate);
                mealList.add(meal);
                ratingBarRestaurant.setRating(1);
                break;

            case R.id.btnFinish:
                Intent intent = new Intent();
                intent.putExtra("tag", mealList);
                setResult(RESULT_OK,intent);
                finish();
                break;
         }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView foodName = (TextView) view;


        switch (foodName.getText().toString()){

            case "Ghormeh Sabzi":
                imageViewFood.setImageResource(R.drawable.ghorme);
                break;

            case "Gheymeh":
                imageViewFood.setImageResource(R.drawable.gheymeh);
                break;

            case "Fesenjan":
                imageViewFood.setImageResource(R.drawable.fesenjoon);
                break;

            case "Tahchin":
                imageViewFood.setImageResource(R.drawable.tahchin);
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
