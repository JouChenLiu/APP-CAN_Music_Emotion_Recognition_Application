package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    //create object of DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://mer-ncu-default-rtdb.firebaseio.com/");

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullname = findViewById(R.id.fullname);
        final EditText memail = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText mpassword = findViewById(R.id.password);
        //final EditText comPassword=findViewById(R.id.compassword);

        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        final Button registerBtn = findViewById(R.id.registerBtn);
        final TextView loginNowBtn = findViewById(R.id.loginNow);

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), profile.class));
            finish();

        }

        registerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //get data from EditText into String variable
                final String fullnameTxt=fullname.getText().toString();
                final String emailTxt = memail.getText().toString().trim();
                final String phoneTxt=phone.getText().toString();
                final String passwordTxt = mpassword.getText().toString().trim();
                //final String comPasswordTxt=comPassword.getText().toString();
                //check if user fill all the fields before sending data to firebase
//                if (fullnameTxt.isEmpty()|| emailTxt.isEmpty()|| phoneTxt.isEmpty()|| passwordTxt.isEmpty()){
//                    Toast.makeText(register.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
//                }
//
//                //check if passwords are matching with each other
//                //if not matching with each other then sow a toast message
//                else if (!passwordTxt.equals(comPasswordTxt)){
//                    Toast.makeText(register.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
//                }

                if (TextUtils.isEmpty((emailTxt))) {
                    memail.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(passwordTxt)) {
                    mpassword.setError("Password is Required.");
                    return;
                }

                if (passwordTxt.length() < 6) {
                    mpassword.setError(("Password Must be >= 6 Characters"));
                    return;
                }

                registerBtn.setVisibility(View.VISIBLE);
                //register the user in firebase

                fAuth.createUserWithEmailAndPassword(emailTxt, passwordTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "USer Created", Toast.LENGTH_SHORT).show();
                            userID=fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=fstore.collection("users").document(userID);
                            Map<String,Object> user=new HashMap<>();
                            user.put("fName",fullnameTxt);
                            user.put("email",emailTxt);
                            user.put("phone",phoneTxt);
                            user.put("birth date","0520");
                            user.put("gender","boy");
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d("TAG", "onSuccess: user Profile is created for"+userID);
                                }
                            });

                            documentReference.set(user).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("TAG", "onFailure: "+e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), profile.class));
                        } else {
                            Toast.makeText(register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            registerBtn.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

//        loginNowBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchtoLogin();
            }
        });

    }
    private void switchtoLogin(){
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }
}




