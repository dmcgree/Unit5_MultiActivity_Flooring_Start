package edu.css.cis3334.unit5_multiactivity_flooring_start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessage extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        TextView results = (TextView) findViewById(R.id.results);

        Intent intent = getIntent();
        String flooring = intent.getStringExtra("Results");

        results.setText(flooring);
    }


}
