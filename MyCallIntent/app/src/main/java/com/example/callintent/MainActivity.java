package com.example.callintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button callButton;

    EditText callNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callButton = (Button)findViewById(R.id.call_button);
        callNumberInput = (EditText)findViewById(R.id.call_number_input);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callNumber = callNumberInput.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + callNumber));

                startActivity(intent);


                Intent intent2 = new Intent();
                ComponentName name = new ComponentName("com.example.callintent", "com.example.callintent.MenuActivity");
                intent2.setComponent(name);
                startActivity(intent2);
            }
        });
    }
}
