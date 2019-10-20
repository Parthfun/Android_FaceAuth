package com.example.faceauth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetPassword extends AppCompatActivity {

    EditText NewPassword, ReEnterPassword;
    Button Confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        ConstraintLayout constraintLayout = findViewById(R.id.SetPasswordLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        NewPassword = findViewById(R.id.editText);
        ReEnterPassword = findViewById(R.id.editText2);
        Confirm = findViewById(R.id.button);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = NewPassword.getText().toString();
                String verification = ReEnterPassword.getText().toString();

                if (password.equals("") || verification.equals("")) {
                    Toast.makeText(SetPassword.this, "No Password Entered!", Toast.LENGTH_LONG).show();
                } else {
                    if (password.equals(verification)) {
                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", password);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), ImportantData.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SetPassword.this, "Password Doesn't Match!", Toast.LENGTH_LONG).show();

                    }

                }

            }
        }

        );
    }
}
