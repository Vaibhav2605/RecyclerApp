package com.example.vaibhav.recyclerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.N;

public class DetailsActivity extends AppCompatActivity {
    private TextView name,description;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        extras=getIntent().getExtras();

        name=(TextView)findViewById(R.id.dName);
        description=(TextView)findViewById(R.id.dDescription);
        if(extras!=null){
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));

        }

    }
}
