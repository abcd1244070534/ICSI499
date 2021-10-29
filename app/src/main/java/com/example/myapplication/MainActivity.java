package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        TextView editText = findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, encrypt(message));
        startActivity(intent);
    }

    public String encrypt(String message) {
        String encrypted = "";
        try {
            encrypted = AESUtils.encrypt(message);
            Log.d("TEST", "encrypted:" + encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    public String decrypt(String encrypted) {
        String decrypted = "";
        try {
            decrypted = AESUtils.decrypt(encrypted);
            Log.d("TEST", "decrypted:" + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypted;
    }
}