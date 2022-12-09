package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.view.MainActivity;
import com.example.myapplication.view.fallingoff1;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profile extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    private Button logout;

    TextView fullName,birthdate,sex,userAcc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        final TextView logoutBtn=findViewById(R.id.loginOut);
        fullName=findViewById(R.id.full_name);
        //userAcc=findViewById(R.id.useraccount);
        birthdate=findViewById(R.id.birthdate);
        sex=findViewById(R.id.sex);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        userId=fAuth.getCurrentUser().getUid();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;


        DocumentReference documentReference=fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                fullName.setText(documentSnapshot.getString("fName"));
                birthdate.setText(documentSnapshot.getString("birth date"));
                sex.setText(documentSnapshot.getString("gender"));

            }
        });


//        logout=(Button) findViewById(R.id.loginOut);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

    }

    private void logout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(profile.this,Login.class));
        finish();
    }


    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void edit(View view) {
        Intent intent = new Intent(this, Activityedit.class);
        startActivity(intent);
    }

    public void go(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void go2(View view) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void go3(View view) {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

    public void go4(View view) {
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
    }

    public void go5(View view) {
        Intent intent = new Intent(this, Activity6.class);
        startActivity(intent);
    }

    public void go6(View view) {
        Intent intent = new Intent(this, Activity7.class);
        startActivity(intent);
    }

    public void go7(View view) {
        Intent intent = new Intent(this, Activity8.class);
        startActivity(intent);
    }

    public void go8(View view) {
        Intent intent = new Intent(this, Activity9.class);
        startActivity(intent);
    }

    public void go9(View view) {
        Intent intent = new Intent(this, Activity10.class);
        startActivity(intent);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            //intent.addCategory(Intent.CATEGORY_HOME);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return false;
    }

}