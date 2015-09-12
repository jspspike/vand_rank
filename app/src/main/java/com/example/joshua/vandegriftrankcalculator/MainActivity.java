package com.example.joshua.vandegriftrankcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onPress(View v) {
            double fGPA, desGPA, sLef, sDon, cGPA;

        desGPA = -1;

        EditText curGPA = (EditText) findViewById(R.id.curGPA);
        EditText desRank = (EditText) findViewById(R.id.desRank);
        EditText semDone = (EditText) findViewById(R.id.semDone);
        EditText semLeft = (EditText) findViewById(R.id.semLeft);

        if (Double.parseDouble(desRank.getText().toString()) <= 29) {
            desGPA = (double)-37/(double)5000 * Double.parseDouble(desRank.getText().toString()) + (double)3471/(double)625;
        }

        if (Double.parseDouble(desRank.getText().toString()) > 29 && Double.parseDouble(desRank.getText().toString()) <= 42) {
            desGPA = (double)-8/(double)1625 * Double.parseDouble(desRank.getText().toString()) + (double)71263/(double)13000;
        }

        if (Double.parseDouble(desRank.getText().toString()) > 42 && Double.parseDouble(desRank.getText().toString()) <= 64){
            desGPA = (double)-3/(double)880 * Double.parseDouble(desRank.getText().toString()) + (double)298/(double)55;
        }

        if (Double.parseDouble(desRank.getText().toString()) > 64 && Double.parseDouble(desRank.getText().toString()) <= 69) {
            desGPA = (double)-19/(double)5000 * Double.parseDouble(desRank.getText().toString()) + (double)3402/(double)625;
        }

        if (Double.parseDouble(desRank.getText().toString()) > 69 && Double.parseDouble(desRank.getText().toString()) <= 71) {
            desGPA = (double)-7/(double)2000 * Double.parseDouble(desRank.getText().toString()) + (double)2169/(double)400;
        }

        if (Double.parseDouble(desRank.getText().toString()) > 71 && Double.parseDouble(desRank.getText().toString()) <= 105) {
            desGPA = (double)-73/(double)17000 * Double.parseDouble(desRank.getText().toString()) + (double)93141/(double)17000;
        }

        if (Double.parseDouble(desRank.getText().toString()) > 105 && Double.parseDouble(desRank.getText().toString()) <= 109) {
            desGPA = (double)-31/(double)8000 * Double.parseDouble(desRank.getText().toString()) + (double)43479/(double)8000;
        }





        cGPA = Double.parseDouble(curGPA.getText().toString());
        sLef = Double.parseDouble(semLeft.getText().toString());
        sDon = Double.parseDouble(semDone.getText().toString());

        fGPA = ((desGPA * (sDon + sLef)) - (cGPA * sDon)) / sLef;


        AlertDialog msg = new AlertDialog.Builder(MainActivity.this).create();

        msg.setTitle("Necessary GPA");
        if (Double.parseDouble(desRank.getText().toString()) > 109) {
            msg.setMessage("Sorry but the Rank model only goes from rank 1-109. If you would like to share your rank anonymously to help make a better model please email a screenshot of your rank and GPA from naviance to jspspike@gmail.com");
        }

        else {
            msg.setMessage("In order to get " + desGPA + " you must get a " + fGPA + " over " + semLeft.getText().toString());
        }
        msg.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        msg.show();




    }
}
