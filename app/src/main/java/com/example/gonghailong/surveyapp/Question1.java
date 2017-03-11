package com.example.gonghailong.surveyapp;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import static android.R.attr.typeface;

public class Question1 extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //Connect this java file with the xml layout
        setContentView(R.layout.question1);
        TextView display = (TextView) findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "demo.ttf");
        display.setTypeface(typeface);

        ExitApplication.getInstance().addActivity(this);

        // Connect the button
        Button btnSend = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        answer = (TextView) findViewById(R.id.textView2);

        // Set the onclick listener
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                String ans;
                RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                ans = radioButton.getText().toString();
                answer.setText("Your answer is: " + ans);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Question2.class);
                intent.putExtra("data_to_be_sent",answer.getText().toString());
                startActivity(intent);
            }
        });

    }

}
