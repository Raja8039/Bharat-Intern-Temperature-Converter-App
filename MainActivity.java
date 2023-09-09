package com.example.converttemp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private RadioButton celsiusToRadioButton;
    private RadioButton fahrenheitToRadioButton;
    private Button convertButton;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        celsiusToRadioButton = findViewById(R.id.celsiusToRadioButton);
        fahrenheitToRadioButton = findViewById(R.id.fahrenheitToRadioButton);
        convertButton = findViewById(R.id.convertButton);
        outputTextView = findViewById(R.id.outputTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    private void performConversion() {
        double inputValue = Double.parseDouble(inputEditText.getText().toString());
        double result;

        if (celsiusToRadioButton.isChecked()) {
            result = (inputValue * 9/5) + 32;
            outputTextView.setText(getString(R.string.converted_to_fahrenheit, result));
        } else if (fahrenheitToRadioButton.isChecked()) {
            result = (inputValue - 32) * 5/9;
            outputTextView.setText(getString(R.string.converted_to_celsius, result));
        } else {
            outputTextView.setText("Select a conversion direction.");
        }
    }
}
