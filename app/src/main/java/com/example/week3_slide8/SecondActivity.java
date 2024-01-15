package com.example.week3_slide8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Intent dataSent = getIntent();
        String nameSent = dataSent.getStringExtra("name");
        int ageSent = dataSent.getIntExtra("age", 0);
        String typed = dataSent.getStringExtra("typed");

        Button previousButton = findViewById(R.id.previousPageButton);
        previousButton.setOnClickListener(click -> {
            setResult( 123, dataSent);
            finish();
        } );

        Button IntentButton = findViewById(R.id.prebuiltIntentButton);
        Intent prebuiltIntentPage = new Intent(this, PrebuiltIntentExamples.class);
     //   nextPage.putExtra("name", "Bert");
     //   nextPage.putExtra("age", 20);
     //   nextPage.putExtra("typed", editText.getText().toString());
        //Send the table to SecondActivity:
        IntentButton.setOnClickListener( click -> startActivity( prebuiltIntentPage ));

        //Get a format string:
        String toastMessage = getResources().getString(R.string.toastMessage1);
        //add in the added variables
        String formattedString = String.format(toastMessage, nameSent, ageSent, typed);
        //show the toast
        Toast.makeText(this, formattedString, Toast.LENGTH_LONG).show();
    }

}