package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://mer-ncu-default-rtdb.firebaseio.com/");

    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText mEmail=findViewById(R.id.email);
        final EditText password=findViewById(R.id.password);
        final Button loginBtn=findViewById(R.id.loginBtn);
        final TextView registerNowBtn=findViewById(R.id.registerNowBtn);

        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), profile.class));
            finish();

        }


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailTxt = mEmail.getText().toString().trim();
                //final String phoneTxt=phone.getText().toString();
                final String passwordTxt = password.getText().toString().trim();


                if (TextUtils.isEmpty((emailTxt))) {
                    mEmail.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(passwordTxt)) {
                    password.setError("Password is Required.");
                    return;
                }

                if (passwordTxt.length() < 6) {
                    password.setError(("Password Must be >= 6 Characters"));
                    return;
                }

                loginBtn.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(emailTxt,passwordTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Logged is Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), profile.class));
                        }else {
                            Toast.makeText(Login.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            loginBtn.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

//        registerNowBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchtoRegist();
            }
        });
    }
    private void switchtoRegist(){
        Intent intent=new Intent(this,register.class);
        startActivity(intent);
        finish();
    }
}