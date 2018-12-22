package com.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button nxt;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    int pos;
    int q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz1);
        q = 0;
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() && !cb2.isChecked() && cb3.isChecked())
                    goToNext(true);
                else
                    goToNext(false);
            }
        });
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if (checkedId == R.id.radio1) {
                    goToNext(false);
                }
                else if (checkedId == R.id.radio2){
                    goToNext(false);
                }
                else if (checkedId == R.id.radio3) {
                    goToNext(true);
                }
                else{
                    goToNext(false);
                }
            }
        });
    }

    private void setBox(){
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
    }

    private void goToNext(boolean correct){
        if(!correct)
            setContentView(R.layout.final2);
        else{
            q++;
            if(q == 1)
                setContentView(R.layout.quiz2);
            else if(q == 2){
                setContentView(R.layout.quiz3);
                setBox();
            }
            else if(q == 3){
                setContentView(R.layout.quiz4);
                setBox();
            }
            else if(q == 4)
                setContentView(R.layout.final1);

        }
    }
}



/*package com.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),FirstQuiz.class);//"com.quizapp.FirstQuiz");
                startActivity(i);
            }
        });
    }
}*/
