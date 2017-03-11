package com.example.gonghailong.surveyapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gonghailong on 2017/3/10.
 */

public class Thanks extends AppCompatActivity {

    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //Connect this java file with the xml layout
        setContentView(R.layout.thanks);
        TextView display = (TextView) findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "demo.ttf");
        display.setTypeface(typeface);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            str = "******* Answer List *******\r\n" + extras.getString("data_to_be_sent" );
        }


        ExitApplication.getInstance().addActivity(this);

        // Connect the button
        Button btnSubmit = (Button) findViewById(R.id.submitBtn);
        final Button btnOut =(Button) findViewById(R.id.outBtn);
        final EditText editText = (EditText)findViewById(R.id.editText);
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        final FileHelper fileHelper = new FileHelper(this);

        // Set the onclick listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(isEmail(editText.getText().toString()))
                {
                    fileHelper.saveToSDCard("test.txt", str);
                    Toast.makeText(getBaseContext(),"Submit Successfully ！",Toast.LENGTH_LONG).show();
                }

                else
                {Toast.makeText(getBaseContext(),"Please input the right Email Address!",Toast.LENGTH_LONG).show();}
            }
        });

        btnOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ExitApplication.getInstance().exit();
            }
        });

    }

    public boolean isEmail(String eml)
    {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(eml);

        return m.matches();
    }
}
