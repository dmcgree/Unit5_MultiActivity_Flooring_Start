package edu.css.cis3334.unit5_multiactivity_flooring_start;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "edu.css.cis3334.unit5_multiactivity_flooring_start.MESSAGE";

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

    public void sendResults(View view) {
        // This will find the input area and get its contents as a string
        EditText width =  (EditText) findViewById(R.id.etWidth);
        String inputWidth = width.getText().toString();
        EditText length =  (EditText) findViewById(R.id.etLength);
        String inputLength = length.getText().toString();

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

        Intent intent = new Intent(this, DisplayMessage.class);
        intent.putExtra(EXTRA_MESSAGE, resultString);
        startActivity(intent);

    }
}
