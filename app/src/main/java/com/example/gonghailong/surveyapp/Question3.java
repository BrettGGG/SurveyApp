package com.example.gonghailong.surveyapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


/**
 * Created by gonghailQuestion2ong on 2017/3/10.
 */

public class Question3 extends AppCompatActivity {

    String str;  //data  from last activity
    TextView answer;

    private CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //Connect this java file with the xml layout
        setContentView(R.layout.question3);
        TextView display = (TextView) findViewById(R.id.textView);
        findView();            //获取页面中的控件
        setListener();        //设置控件的监听器

        Typeface typeface = Typeface.createFromAsset(getAssets(), "demo.ttf");
        display.setTypeface(typeface);


        ExitApplication.getInstance().addActivity(this);


        // Connect the button
        Button btnSend = (Button) findViewById(R.id.button);

        // Set the onclick listener
        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //get data from last activity
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    str = extras.getString("data_to_be_sent") + "\r\n" + answer.getText().toString() ;
                }
                Intent intent = new Intent(getBaseContext(), Question4.class);
                intent.putExtra("data_to_be_sent",str);
                startActivity(intent);
            }
        });
    }

    private void setListener() {
        // TODO Auto-generated method stub
        //设置所有CheckBox的状态改变监听器
        cb1.setOnCheckedChangeListener(myCheckChangelistener);
        cb2.setOnCheckedChangeListener(myCheckChangelistener);
        cb3.setOnCheckedChangeListener(myCheckChangelistener);
        cb4.setOnCheckedChangeListener(myCheckChangelistener);
        cb5.setOnCheckedChangeListener(myCheckChangelistener);
        cb6.setOnCheckedChangeListener(myCheckChangelistener);
        cb7.setOnCheckedChangeListener(myCheckChangelistener);
        cb8.setOnCheckedChangeListener(myCheckChangelistener);
    }

    CompoundButton.OnCheckedChangeListener myCheckChangelistener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // TODO Auto-generated method stub
            //设置TextView的内容显示CheckBox的选择结果
            setText();

        }
    };

    private void findView() {
        // TODO Auto-generated method stub
        //通过findViewById得到对应的控件对象
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        cb4 = (CheckBox)findViewById(R.id.cb4);
        cb5 = (CheckBox)findViewById(R.id.cb5);
        cb6 = (CheckBox)findViewById(R.id.cb6);
        cb7 = (CheckBox)findViewById(R.id.cb7);
        cb8 = (CheckBox)findViewById(R.id.cb8);
        answer = (TextView) findViewById(R.id.textView2);
    }

    private void setText(){
        answer.setText("Your answer is: ");    //清空TextView的内容
        //如果cb1被选中，则加入answer内容显示
        if (cb1.isChecked()) {
            str = answer.getText().toString()+cb1.getText().toString()+",";
            answer.setText(str);
        }

        if (cb2.isChecked()) {
            str = answer.getText().toString()+cb2.getText().toString()+",";
            answer.setText(str);
        }

        if (cb3.isChecked()) {
            str = answer.getText().toString()+cb3.getText().toString()+",";
            answer.setText(str);
        }
        if (cb4.isChecked()) {
            str = answer.getText().toString()+cb4.getText().toString()+",";
            answer.setText(str);
        }
        if (cb5.isChecked()) {
            str = answer.getText().toString()+cb5.getText().toString()+",";
            answer.setText(str);
        }
        if (cb6.isChecked()) {
            str = answer.getText().toString()+cb6.getText().toString()+",";
            answer.setText(str);
        }
        if (cb7.isChecked()) {
            str = answer.getText().toString()+cb7.getText().toString()+",";
            answer.setText(str);
        }
        if (cb8.isChecked()) {
            str = answer.getText().toString()+cb8.getText().toString()+",";
            answer.setText(str);
        }

    }

}
