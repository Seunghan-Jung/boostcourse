package com.example.myparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mainButton = (Button)findViewById(R.id.main_button);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent){
        if(intent != null){
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");

            if(names != null){
                Toast.makeText(getApplicationContext(), "전달 받은 이름의 개수 : " + names.size(), Toast.LENGTH_SHORT).show();
            }

            SimpleData data = (SimpleData)intent.getParcelableExtra("data");

            if(data != null){
                Toast.makeText(getApplicationContext(), "전달 받은 data : " + data.message, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
