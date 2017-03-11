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

/**
 * Created by gonghailong on 2017/3/10.
 */

public class Question11 extends AppCompatActivity {

    String str;  //data  from last activity
    RadioGroup radioGroup;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //Connect this java file with the xml layout
        setContentView(R.layout.question11);
        TextView display = (TextView) findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "demo.ttf");
        display.setTypeface(typeface);

        ExitApplication.getInstance().addActivity(this);


        // Connect the button
        Button btnSend = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        answer = (TextView) findViewById(R.id.textView2);

        //get data from last activity
        final Bundle extras = getIntent().getExtras();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                String ans;
                RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                ans = radioButton.getText().toString();
                answer.setText("Your answer is: " + ans);
                if (extras != null) {
                    str = extras.getString("data_to_be_sent") + "\r\n" + answer.getText().toString() ;
                }
            }
        });

        // Set the onclick listener
        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Question12.class);
                intent.putExtra("data_to_be_sent",str);
                startActivity(intent);
            }
        });

    }
}
