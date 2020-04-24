package com.example.smsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UProperty;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s);

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedIntent = getIntent();

        processCommand(passedIntent);
    }

    private void processCommand(Intent intent){
        if(intent != null){
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");

            editText1.setText(sender);
            editText2.setText(contents);
            editText3.setText(receivedDate);
        }
    }
}
