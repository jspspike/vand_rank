package com.example.joshua.vandegriftrankcalculator;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import java.text.DecimalFormat;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
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
        if (id == R.id.action_help) {
            String subject = "Helping out Vandegrift Rank";
            String text = "My current GPA is: *ENTER YOUR GPA HERE" + "\n" + "My current rank is: *ENTER YOUR RANK HERE*";
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, text);
            intent.putExtra(Intent.EXTRA_EMAIL, "jspspike@gmail.com");
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Log.e(LOG_TAG, "Error", e);
            }


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

        AlertDialog msg = new AlertDialog.Builder(MainActivity.this).create();

        try {

            if (Double.parseDouble(desRank.getText().toString()) <= 15) {
                desGPA = (double) -3 / (double) 400 * Double.parseDouble(desRank.getText().toString()) + (double) 11109 / (double) 2000;
            }

            if (Double.parseDouble(desRank.getText().toString()) > 15 && Double.parseDouble(desRank.getText().toString()) <= 29) {
                desGPA = (double) -103 / (double) 14000 * Double.parseDouble(desRank.getText().toString()) + (double) 77733 / (double) 14000;
            }

            if (Double.parseDouble(desRank.getText().toString()) > 29 && Double.parseDouble(desRank.getText().toString()) <= 43) {
                desGPA = (double) -4 / (double) 875 * Double.parseDouble(desRank.getText().toString()) + (double) 38301 / (double) 7000;
            }

            if (Double.parseDouble(desRank.getText().toString()) > 43 && Double.parseDouble(desRank.getText().toString()) <= 64) {
                desGPA = (double) -1 / (double) 280 * Double.parseDouble(desRank.getText().toString()) + (double) 38 / (double) 7;
            }

            if (Double.parseDouble(desRank.getText().toString()) > 64 && Double.parseDouble(desRank.getText().toString()) <= 69) {
                desGPA = (double) -19 / (double) 5000 * Double.parseDouble(desRank.getText().toString()) + (double) 3402 / (double) 625;
            }

            if (Double.parseDouble(desRank.getText().toString()) > 69 && Double.parseDouble(desRank.getText().toString()) <= 71) {
                desGPA = (double) -7 / (double) 2000 * Double.parseDouble(desRank.getText().toString()) + (double) 2169 / (double) 400;
            }

            if (Double.parseDouble(desRank.getText().toString()) > 71 && Double.parseDouble(desRank.getText().toString()) <= 105) {
                desGPA = (double) -73 / (double) 17000 * Double.parseDouble(desRank.getText().toString()) + (double) 93141 / (double) 17000;
            }

            if (Double.parseDouble(desRank.getText().toString()) > 105 && Double.parseDouble(desRank.getText().toString()) <= 109) {
                desGPA = (double) -171 / (double) 40000 * Double.parseDouble(desRank.getText().toString()) + (double) 8763 / (double) 1600;
            }
        }

        catch (NumberFormatException e) {
            msg.setMessage("Invalid Input");

            msg.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            msg.show();
            return;
        }

        try {

            cGPA = Double.parseDouble(curGPA.getText().toString());
            sLef = Double.parseDouble(semLeft.getText().toString());
            sDon = Double.parseDouble(semDone.getText().toString());
        }

        catch (NumberFormatException e) {
            msg.setMessage("Invalid Input");

            msg.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            msg.show();
            return;
        }

        fGPA = (((desGPA * (sDon + sLef)) - (cGPA * sDon)) / sLef);




        DecimalFormat doubleFormat = new DecimalFormat("#.####");

        msg.setTitle("Necessary GPA");
        if (Double.parseDouble(desRank.getText().toString()) > 109) {
            msg.setMessage("Sorry but the Rank model only goes from rank 1-109. If you would like to share your rank anonymously to help make a better model please email a screenshot of your rank and GPA from naviance to jspspike@gmail.com");
        }

        else {
            msg.setMessage("In order to get " + desRank.getText().toString() + " you must get a " + doubleFormat.format(fGPA) + " over " + semLeft.getText().toString() + " semesters.");
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
