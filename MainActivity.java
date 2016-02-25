package edu.css.cis3334.unit5_multiactivity_flooring_start;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    TextView txt1, txt2;
    EditText edt1, edt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendResults(View view) {

        // This will find the input area and get its contents as a string
        EditText width = (EditText) findViewById(R.id.etWidth);
        String inputWidth = width.getText().toString();
        EditText length = (EditText) findViewById(R.id.etLength);
        String inputLength = length.getText().toString();
        Button button = (Button) findViewById(R.id.btnShowResults);


        // This will display an error message that bill amount is empty and return
        if (inputWidth.matches("")) {
            Toast.makeText(this, "You did not enter a width", Toast.LENGTH_SHORT).show();
            return;
        }
        if (inputLength.matches("")) {
            Toast.makeText(this, "You did not enter a length", Toast.LENGTH_SHORT).show();
            return;
        }

        // the input is not empty, so we cast the strings to a floats
        float w = Float.valueOf(inputWidth);
        float l = Float.valueOf(inputLength);

        // calculate flooring needed
        float flooringNeeded = w * l;

        // create string results message
        String resultString = "Width is " + w + " and length is " + l + ". The flooring needed is "
                + flooringNeeded + ".";

        Intent intent = new Intent(MainActivity.this, DisplayMessage.class);


        intent.putExtra("Results", resultString);

        //startActivity(intent1);

        startActivity(intent);
    }
}





