package com.example.hp.tictactoegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.Toast;

import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    Button a1, a2, a3, a4, a5, a6, a7, a8, a9,a10,a11,a12;
    Button[] barray;
    boolean turn = true;
    int turn_count = 0;
     int c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1 = (Button) findViewById(R.id.b1);
        a2 = (Button) findViewById(R.id.b2);

        a3 = (Button) findViewById(R.id.b3);
        a4 = (Button) findViewById(R.id.b4);
        a5 = (Button) findViewById(R.id.b5);
        a6 = (Button) findViewById(R.id.b6);

        a7 = (Button) findViewById(R.id.b7);
        a8 = (Button) findViewById(R.id.b8);
        a9 = (Button) findViewById(R.id.b9);
        a10 = (Button) findViewById(R.id.b10);
        a11 = (Button) findViewById(R.id.b11);
        a12 = (Button) findViewById(R.id.b12);
        a11.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                Bundle extras = new Bundle();
                extras.putString("StringVariableName", c1.toString());
                intent.putExtras(extras);
                startActivity(intent);
*/
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                myIntent.putExtra("intVariableName", c1);
                startActivity(myIntent);


            }
        });


        barray = new Button[]{a1, a2, a3, a4, a5, a6, a7, a8, a9};
        for (Button b : barray) {
            b.setOnClickListener(this);
        }


        a10.setOnClickListener(new OnClickListener()
        {
            @Override

            public void onClick(View v )
            {


                turn=true;
                turn_count=0;
                a1.setText("");
                a2.setText("");
                a3.setText("");
                a4.setText("");
                a5.setText("");
                a6.setText("");

                a7.setText("");
                a8.setText("");
                a9.setText("");

                a1.setEnabled(true);
                a2.setEnabled(true);
                a3.setEnabled(true);
                a4.setEnabled(true);
                a5.setEnabled(true);
                a6.setEnabled(true);
                a7.setEnabled(true);
                a8.setEnabled(true);
                a9.setEnabled(true);
            }
        });

    }



    @Override
    public void onClick(View v)

    {
        Button b = (Button) v;
        buttonClicked(b);
    }

    public void buttonClicked(Button b) {
        if (turn) {
            b.setText("x");
        } else {
            b.setText("o");
        }
        turn_count++;
        b.setClickable(false);
        turn = !turn;
        check();

    }

    private void check() {
        boolean iswinner = false;
        if (a1.getText() == a2.getText() && a2.getText() == a3.getText() && !a1.isClickable())
            iswinner = true;
        else if (a4.getText() == a5.getText() && a5.getText() == a6.getText() && !a5.isClickable())
            iswinner = true;
        else if (a7.getText() == a8.getText() && a8.getText() == a9.getText() && !a9.isClickable())
            iswinner = true;


        else if (a1.getText() == a4.getText() && a4.getText() == a7.getText() && !a1.isClickable())
            iswinner = true;
        else if (a2.getText() == a5.getText() && a5.getText() == a8.getText() && !a2.isClickable())
            iswinner = true;
        else if (a3.getText() == a6.getText() && a6.getText() == a9.getText() && !a3.isClickable())
            iswinner = true;

        else if (a1.getText() == a5.getText() && a5.getText() == a9.getText() && !a1.isClickable())
            iswinner = true;
        else if (a3.getText() == a5.getText() && a5.getText() == a7.getText() && !a5.isClickable())
            iswinner = true;
        //else if(a7.getText()==a8.getText()&&a8.getText()==a9.getText()&&!a7.isClickable())
        //  iswinner=true;

        if (iswinner) {
            if (turn) {
                toast("o won");
                c1=1;
            } else {
                toast("x won");
                c1=2;
            }
            turn_count=0;
            a1.setText("");
            a2.setText("");
            a3.setText("");
            a4.setText("");
            a5.setText("");
            a6.setText("");

            a7.setText("");
            a8.setText("");
            a9.setText("");

            a1.setEnabled(false);
            a2.setEnabled(false);
            a3.setEnabled(false);
            a4.setEnabled(false);
            a5.setEnabled(false);
            a6.setEnabled(false);
            a7.setEnabled(false);
            a8.setEnabled(false);
            a9.setEnabled(false);
            for (Button b : barray) {
                b.setOnClickListener(this);
            }

            //       enabledisableAllButtons(false);

        } else if (turn_count == 9) {
            toast(" draw");
            turn_count=0;
            a1.setText("");
            a2.setText("");
            a3.setText("");
            a4.setText("");
            a5.setText("");
            a6.setText("");

            a7.setText("");
            a8.setText("");
            a9.setText("");

            a1.setEnabled(false);
            a2.setEnabled(false);
            a3.setEnabled(false);
            a4.setEnabled(false);
            a5.setEnabled(false);
            a6.setEnabled(false);
            a7.setEnabled(false);
            a8.setEnabled(false);
            a9.setEnabled(false);
            for (Button b : barray) {
                b.setOnClickListener(this);
            }

        }
    }
    private void toast(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
    /*
   private  void enabledisableAllButtons(boolean s)
    {
        for(Button b:barray)
        {
            b.setClickable(enable);


    }
}
*/
}

