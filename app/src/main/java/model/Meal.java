package model;

import java.io.Serializable;

public class Meal implements Serializable {
    private String mealName;
    private float mealRate;

    public Meal(String mealName, float mealRate) {
        this.mealName = mealName;
        this.mealRate = mealRate;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public float getMealRate() {
        return mealRate;
    }

    public void setMealRate(float mealRate) {
        this.mealRate = mealRate;
    }

    @Override
    public String toString() {
        return "Meal: " + mealName + ", Rate : " +  mealRate + "\n";
    }
}
