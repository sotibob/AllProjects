package com.example.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = (RadioButton) findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLb = (RadioButton) findViewById(R.id.radKiloToLb);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView) findViewById(R.id.txtResult);
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.##");
                if(lbToKilo.isChecked()) {
                    if(weightEntered == 0)
                    {
                        Toast.makeText(MainActivity.this, "Please input a number greater than 0", Toast.LENGTH_LONG).show();
                    }
                    else if(weightEntered <= 500) {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Kilograms");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 225", Toast.LENGTH_LONG).show();
                    }
                }
                else if(kiloToLb.isChecked()) {
                    if(weightEntered == 0)
                    {
                        Toast.makeText(MainActivity.this, "Please input a number greater than 0", Toast.LENGTH_LONG).show();
                    }
                    else if(weightEntered <= 225) {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Pounds");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Kilos must be less than 225", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please choose a scale", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}