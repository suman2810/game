package com.example.hp.tictactoegame;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txt1,txt2,txt3;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b11;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt1 = (TextView) findViewById(R.id.t1);
        txt2 = (TextView) findViewById(R.id.t2);
        txt3 = (TextView) findViewById(R.id.t3);
        ed1 = (EditText) findViewById(R.id.e1);
        ed2 = (EditText) findViewById(R.id.e2);

     /*   Bundle extras = getIntent().getExtras();
        String StringVariableName = extras.getString("StringVariableName");
        int IntVariableName=Integer.parseInt(StringVariableName);*/
        Intent intent = getIntent();
        int intValue = intent.getIntExtra("intVariableName", 0);

        if(intValue==1)
        {
            ed2.setText("10");
            ed1.setText("0");
            ed1.setEnabled(false);
            ed2.setEnabled(false);
        }
        else if(intValue==2)
        {
            ed2.setText("0");
            ed1.setText("10");
            ed1.setEnabled(false);
            ed2.setEnabled(false);
        }
        else
        {
            ed2.setText("0");
            ed1.setText("0");

            ed1.setEnabled(false);
            ed2.setEnabled(false);
        }

    }
}
