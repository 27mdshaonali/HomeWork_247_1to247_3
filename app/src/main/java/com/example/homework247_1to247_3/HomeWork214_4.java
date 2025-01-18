package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork214_4 extends AppCompatActivity {

    public static String HW214_4TITLE = "";
    public static String HW214_4SUBTITLE = "";

    TextView HW214_4Title, HW214_4SubTitle, resultTextView;
    EditText macroInputNumber, microInputNumber, mathInputNumber, statInputNumber, socialInputNumber, historyInputNumber;
    Button calculateGPAButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2144);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        HW214_4Title.setText(HW214_4TITLE);
        HW214_4SubTitle.setText(HW214_4SUBTITLE);

        calculateGPAButton.setOnClickListener(view -> calculateGPA());


    } //=================================== OnCreate Method End ===================================

    public void initialize() {

        HW214_4Title = findViewById(R.id.HW214_4Title);
        HW214_4SubTitle = findViewById(R.id.HW214_4SubTitle);
        macroInputNumber = findViewById(R.id.macroInputNumber);
        microInputNumber = findViewById(R.id.microInputNumber);
        mathInputNumber = findViewById(R.id.mathInputNumber);
        statInputNumber = findViewById(R.id.statInputNumber);
        socialInputNumber = findViewById(R.id.socialInputNumber);
        historyInputNumber = findViewById(R.id.historyInputNumber);
        calculateGPAButton = findViewById(R.id.calculateGPAButton);
        resultTextView = findViewById(R.id.resultTextView);

    }

    @SuppressLint("SetTextI18n")
    public void calculateGPA() {

        try {

            double macro = Double.parseDouble(macroInputNumber.getText().toString());
            double micro = Double.parseDouble(microInputNumber.getText().toString());
            double math = Double.parseDouble(mathInputNumber.getText().toString());
            double stat = Double.parseDouble(statInputNumber.getText().toString());
            double social = Double.parseDouble(socialInputNumber.getText().toString());
            double history = Double.parseDouble(historyInputNumber.getText().toString());

            double totalMarks = macro + micro + math + stat + social + history;
            double gpa = totalMarks / 6;

            if (macroInputNumber.length() == 0 || microInputNumber.length() == 0 || mathInputNumber.length() == 0 || statInputNumber.length() == 0 || socialInputNumber.length() == 0 || historyInputNumber.length() == 0) {
                Toast.makeText(this, "Enter all the fields", Toast.LENGTH_SHORT).show();
            } else {

                if (macro < 0 || macro > 100 || micro < 0 || micro > 100 || math < 0 || math > 100 || stat < 0 || stat > 100 || social < 0 || social > 100 || history < 0 || history > 100) {

                    Toast.makeText(this, "Enter valid number/s", Toast.LENGTH_SHORT).show();

                } else {

                    if (gpa >= 80) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is A+.\n\nCongratulations*");
                    } else if (gpa >= 75) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is A.\n\nCongratulations");
                    } else if (gpa >= 70) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is A-.\n\nCongratulations");
                    } else if (gpa >= 65) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is B+.\n\nCongratulation");
                    } else if (gpa >= 60) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is B.");
                    } else if (gpa >= 55) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is B-.");
                    } else if (gpa >= 50) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is C+.");
                    } else if (gpa >= 45) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is C-.\n\nKeep it up");
                    } else if (gpa >= 40) {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is D.");
                    } else {
                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your total marks is " + totalMarks + ". Your marks percentage is " + gpa + ".\nYour grade is F. \n\nBetter Luck Next Time");
                    }

                }

            }


        } catch (Exception e) {
            resultTextView.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
            resultTextView.setText("Invalid Input");
        }


    }

}