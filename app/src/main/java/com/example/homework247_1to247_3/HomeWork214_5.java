package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork214_5 extends AppCompatActivity {

    public static String HW214_5TITLE = "";
    public static String HW214_5SUBTITLE = "";
    TextView HW214_5Title, HW214_5SubTitle, resultTextView;
    EditText userInputtedNumber;
    Button calculateBillButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2145);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        HW214_5Title.setText(HW214_5TITLE);
        HW214_5SubTitle.setText(HW214_5SUBTITLE);

        calculateBillButton.setOnClickListener(v -> calculateBill());


    } //======================================= OnCreate Method Ends Here =======================================

    public void initialize() {

        HW214_5Title = findViewById(R.id.HW214_5Title);
        HW214_5SubTitle = findViewById(R.id.HW214_5SubTitle);
        resultTextView = findViewById(R.id.resultTextView);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        calculateBillButton = findViewById(R.id.calculateBillButton);

    }

    @SuppressLint("SetTextI18n")
    public void calculateBill() {

        String inputText = userInputtedNumber.getText().toString().trim();

        if (inputText.isEmpty()) {
            resultTextView.setVisibility(View.GONE);
            userInputtedNumber.setError("Enter Bill Unit/s");
            return;
        }

        double unit;

        try {
            unit = Double.parseDouble(inputText);
        } catch (NumberFormatException e) {
            resultTextView.setVisibility(View.GONE);
            userInputtedNumber.setError("Enter a valid number");
            return;
        }

        if (unit <= 0) {
            userInputtedNumber.setError("Enter a valid number greater than zero");
            return;
        }

        double withCharge = 0;
        if (unit <= 50) {
            withCharge = (unit * 0.50) * 1.20; // Including 20% charge
        } else if (unit <= 150) {
            withCharge = ((50 * 0.50) + ((unit - 50) * 0.75)) * 1.20;
        } else if (unit <= 250) {
            withCharge = ((50 * 0.50) + (100 * 0.75) + ((unit - 150) * 1.20)) * 1.20;
        } else {
            withCharge = ((50 * 0.50) + (100 * 0.75) + (100 * 1.20) + ((unit - 250) * 1.50)) * 1.20;
        }

        displayResult(unit, withCharge);
    }

    @SuppressLint("DefaultLocale")
    private void displayResult(double unit, double withCharge) {
        resultTextView.setVisibility(View.VISIBLE);
        resultTextView.setText(String.format("Your total Unit is: %.2f. Total Bill is: %.2f BDT.", unit, withCharge));
    }


}