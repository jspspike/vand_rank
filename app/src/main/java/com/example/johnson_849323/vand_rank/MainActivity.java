package com.example.johnson_849323.vand_rank;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tabGPA");
        tabHost.addTab(tabHost.newTabSpec("tabGPA").setIndicator("GPA").setContent(R.id.tabGPA));

        tabSpec = tabHost.newTabSpec("tabRank");
        tabHost.addTab(tabHost.newTabSpec("tabRank").setIndicator("Rank").setContent(R.id.tabRank));
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

    public void calc2Pressed(View v) {
        double cGPA, eGPA, semCGPA, semEGPA;
        int desRank = -1;

        EditText curGPA = (EditText) findViewById(R.id.cGPA);
        EditText exGPA = (EditText) findViewById(R.id.eGPA);
        EditText semcurGPA = (EditText) findViewById(R.id.semCGPA);
        EditText semexGPA = (EditText) findViewById(R.id.semEGPA);

        AlertDialog msg = new AlertDialog.Builder(MainActivity.this).create();

        try {
            cGPA = (Double.parseDouble(exGPA.getText().toString()) * Integer.parseInt(semexGPA.getText().toString())) + (Double.parseDouble(curGPA.getText().toString()) + Integer.parseInt(semcurGPA.getText().toString()));
            Log.v("Test", "" + cGPA);

            if (cGPA >= 5.442) {
                desRank = (int) ((-400.0 / 3.0) * cGPA + (3703.0 / 5));
            }

            if (cGPA >= 5.339 && cGPA < 5.442) {
                desRank = (int) ((-14000.0 / 103) * cGPA + (77733.0 / 103));
            }

            if (cGPA >= 5.275 && cGPA < 5.339) {
                desRank = (int) ((-875.0 / 4) * cGPA + (38301.0 / 32));
            }

            if (cGPA >= 5.2 && cGPA < 5.275) {
                desRank = (int) ((-280.0) * cGPA + (1520.0));
            }

            if (cGPA >= 5.181 && cGPA < 5.2) {
                desRank = (int) ((-5000.0 / 19) * cGPA + (27216.0 / 16));
            }

            if (cGPA >= 5.174 && cGPA < 5.181) {
                desRank = (int) ((-2000.0 / 7) * cGPA + (10845.0 / 7));
            }

            if (cGPA >= 5.028 && cGPA < 5.174) {
                desRank = (int) ((-17000.0 / 73) * cGPA + (93141.0 / 73));
                Log.v("swags", desRank + ":" + cGPA);
            }

            if (cGPA >= 5.0109 && cGPA < 5.028) {
                desRank = (int) ((-40000.0 / 171) * cGPA + (73025.0 / 57));
            }

            Log.v("swag", desRank + ":" + cGPA);

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


        Log.v("swag", desRank + ":" + cGPA);
        msg.setTitle("Necessary GPA");
        if (cGPA < 5.0109) {
            msg.setMessage("Sorry but the Rank model only goes from rank 1-109. If you would like to share your rank anonymously to help make a better model please email a screenshot of your rank and GPA from naviance to jspspike@gmail.com");
        }

        else {
            msg.setMessage("Your predicted rank is " + desRank + " with a " + cGPA + " GPA.");
        }

        msg.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        msg.show();
    }

    public void calc1Pressed(View v) {
        double fGPA,desGPA, sLef, sDon, cGPA;

        desGPA = -1;

        EditText curGPA = (EditText) findViewById(R.id.curGpa);
        EditText desRank = (EditText) findViewById(R.id.desRank);
        EditText semDone = (EditText) findViewById(R.id.semComplete);
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
