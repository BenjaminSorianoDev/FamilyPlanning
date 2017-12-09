package com.ihm.familyplanning.Controllers.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihm.familyplanning.R;

public class CreateGroupActivity extends AppCompatActivity {

    private Button validButton;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        validButton = (Button) findViewById(R.id.validButton);
        backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent MainActivity = new Intent(CreateGroupActivity.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }
}
