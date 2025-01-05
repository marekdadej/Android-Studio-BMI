package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText weightEditText, heightEditText, ageEditText;
    RadioButton maleRadioButton, femaleRadioButton;
    RadioGroup genderRadioGroup;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        ageEditText = findViewById(R.id.ageEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty() || ageStr.isEmpty() || genderRadioGroup.getCheckedRadioButtonId() == -1) {
            resultTextView.setText("Please enter all fields and select gender");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // converting cm to meters
        float bmi = weight / (height * height);

        String gender = (maleRadioButton.isChecked()) ? "Male" : "Female";
        int age = Integer.parseInt(ageStr);

        // Logging values
        System.out.println("Gender: " + gender + " BMI: " + bmi + " Age: " + age);

        String classification = classifyBMI(bmi, age, gender);
        resultTextView.setText("BMI: " + String.format("%.1f", bmi) + "\n" + classification);
    }

    private String classifyBMI(float bmi, int age, String gender) {
        if (age < 18) {
            return "BMI classification for children is different";
        }

        // Classification for Males
        if (gender.equals("Male")) {
            if (age >= 18 && age <= 24) {
                if (bmi < 20) return "Underweight";
                else if (bmi < 25) return "Normal weight";
                else if (bmi < 30) return "Overweight";
                else if (bmi <= 40) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 25 && age <= 34) {
                if (bmi < 21) return "Underweight";
                else if (bmi < 26) return "Normal weight";
                else if (bmi < 31) return "Overweight";
                else if (bmi <= 41) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 35 && age <= 44) {
                if (bmi < 22) return "Underweight";
                else if (bmi < 27) return "Normal weight";
                else if (bmi < 32) return "Overweight";
                else if (bmi <= 42) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 45 && age <= 54) {
                if (bmi < 23) return "Underweight";
                else if (bmi < 28) return "Normal weight";
                else if (bmi < 33) return "Overweight";
                else if (bmi <= 43) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 55 && age <= 64) {
                if (bmi < 24) return "Underweight";
                else if (bmi < 29) return "Normal weight";
                else if (bmi < 34) return "Overweight";
                else if (bmi <= 44) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 65) {
                if (bmi < 25) return "Underweight";
                else if (bmi < 30) return "Normal weight";
                else if (bmi < 35) return "Overweight";
                else if (bmi <= 45) return "Adiposity";
                else return "Severe adiposity";
            }
        }

        // Classification for Females
        else if (gender.equals("Female")) {
            if (age >= 18 && age <= 24) {
                if (bmi < 19) return "Underweight";
                else if (bmi < 24) return "Normal weight";
                else if (bmi < 29) return "Overweight";
                else if (bmi <= 39) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 25 && age <= 34) {
                if (bmi < 20) return "Underweight";
                else if (bmi < 25) return "Normal weight";
                else if (bmi < 30) return "Overweight";
                else if (bmi <= 40) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 35 && age <= 44) {
                if (bmi < 21) return "Underweight";
                else if (bmi < 26) return "Normal weight";
                else if (bmi < 31) return "Overweight";
                else if (bmi <= 41) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 45 && age <= 54) {
                if (bmi < 22) return "Underweight";
                else if (bmi < 27) return "Normal weight";
                else if (bmi < 32) return "Overweight";
                else if (bmi <= 42) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 55 && age <= 64) {
                if (bmi < 23) return "Underweight";
                else if (bmi < 28) return "Normal weight";
                else if (bmi < 33) return "Overweight";
                else if (bmi <= 43) return "Adiposity";
                else return "Severe adiposity";
            } else if (age >= 65) {
                if (bmi < 24) return "Underweight";
                else if (bmi < 29) return "Normal weight";
                else if (bmi < 34) return "Overweight";
                else if (bmi <= 44) return "Adiposity";
                else return "Severe adiposity";
            }
        }

        return "Classification not available";
    }
}