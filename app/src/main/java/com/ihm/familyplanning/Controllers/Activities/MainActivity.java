package com.ihm.familyplanning.Controllers.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihm.familyplanning.Model.DataManager;
import com.ihm.familyplanning.R;

public class MainActivity extends AppCompatActivity {

    private Button joinGroupButton;
    private Button createGroupButton;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGroupButton = (Button) findViewById(R.id.create_group);
        joinGroupButton = (Button) findViewById(R.id.join_group);
        dataManager = new DataManager(this);

        createGroupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent CreateGroupActivity = new Intent(MainActivity.this, CreateGroupActivity.class);
                startActivity(CreateGroupActivity);
            }
        });

        joinGroupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent PrincipalActivity = new Intent(MainActivity.this, PrincipalActivity.class);
                startActivity(PrincipalActivity);
            }
        });

        dataManager.close();
    }
}
