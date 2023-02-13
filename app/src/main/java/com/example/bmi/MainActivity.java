package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText weight, height_inch, height_feet;
    ImageView imageview;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.weight);
        height_feet = findViewById(R.id.height_feet);
        height_inch = findViewById(R.id.height_inch);
        result = findViewById(R.id.result);
        imageview = findViewById(R.id.imageview);


        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int feet = Integer.parseInt(height_feet.getText().toString());
                int inch = Integer.parseInt(height_inch.getText().toString());
                int w = Integer.parseInt(weight.getText().toString());

                int totalinc = feet * 12 + inch;

                double totalcm = totalinc * 2.53;
                double totalm = totalcm / 100;

                double bmi = w /(totalm * totalm);


                if (bmi > 25) {
                    result.setText("You are OverWeight");
                   result.setBackgroundColor(getResources().getColor(R.color.Oweight));
                } else if (bmi < 18) {
                    result.setText("You are UnderWeight");
                   result.setBackgroundColor(getResources().getColor(R.color.Uweight));
                } else {
                    result.setText("You are Healthy");
                   result.setBackgroundColor(getResources().getColor(R.color.Healthy));
                }


            }
        });
    }
}