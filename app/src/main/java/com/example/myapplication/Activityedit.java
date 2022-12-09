package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Activityedit extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    TextView p_fullName,p_email,p_birth,p_gender;
    public static final String TAG="TAG";

    DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityedit);

        p_fullName=findViewById(R.id.full_name);
        p_email=findViewById(R.id.email);
        p_birth=findViewById(R.id.birth_date);
        p_gender=findViewById(R.id.sex);
//        p_pass=findViewById(R.id.password);


        Button upB=findViewById(R.id.upE);

        fAuth= FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();

        userId=fAuth.getCurrentUser().getUid();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;


        DocumentReference documentReference=fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                p_fullName.setText(documentSnapshot.getString("fName"));

            }
        });

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                p_email.setText(documentSnapshot.getString("email"));
            }
        });
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                p_birth.setText(documentSnapshot.getString("birth date"));
            }
        });
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                p_gender.setText(documentSnapshot.getString("gender"));
            }
        });
        //顯示原本的



        Intent data=getIntent();
        String fullName=data.getStringExtra("fName");
        String email=data.getStringExtra("email");

        Log.d(TAG, "onCreate: "+fullName+" "+email+" ");

        p_email.setText(email);
        p_fullName.setText(fullName);

        upB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=p_fullName.getText().toString();
                String birthd=p_birth.getText().toString();
                String gende=p_gender.getText().toString();
                String emaill=p_email.getText().toString();
//                String passw=p_pass.getText().toString();
                p_fullName.setText("");
                p_birth.setText("");
                p_gender.setText("");
                p_email.setText("");
//                p_pass.setText("");
                Updatedata(fname,birthd,gende,emaill);

                startActivity(new Intent(getApplicationContext(), profile.class));
            }


        });

    }

    private void Updatedata (String fname,String birthd,String gende,String emaill){

        Map<String,Object> userDetail=new HashMap<>();
        userDetail.put("fName",fname);
        userDetail.put("birth date",birthd);
        userDetail.put("gender",gende);
        userDetail.put("email",emaill);
//        userDetail.put("password",pass);

        fStore.collection("users")
//                .whereEqualTo("fName",fname)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful() && !task.getResult().isEmpty()){
                    DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                    String documentID=documentSnapshot.getId();
                    fStore.collection("users")
                            .document(documentID)
                            .update(userDetail)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(Activityedit.this,"Successfuly Update",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Activityedit.this,"Some Error",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    Toast.makeText(Activityedit.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    private void UploadData(){
//        String fname=p_fullName.getText().toString();
//        String birthd=p_birth.getText().toString();
//        String gende=p_gender.getText().toString();
//        String emaill=p_email.getText().toString();
//        String passw=p_pass.getText().toString();
//    }

//    protected void onStart(){
//        super.onStart();
//
//        documentReference.get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//                        if(task.getResult().exists()){
//                            String name_r=task.getResult().getString("fName");
//                            String birth_r=task.getResult().getString("birth date");
//                            String gen_r=task.getResult().getString("gender");
//                            String email_r=task.getResult().getString("email");
//                            String passw_r=task.getResult().getString("password");
//
//                            p_fullName.setText(name_r);
//                            p_birth.setText(birth_r);
//                            p_gender.setText(gen_r);
//                            p_email.setText(email_r);
//                            p_pass.setText(passw_r);
//                        }else {
//                            Toast.makeText(Activityedit.this,"No Profile exist",Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                    }
//                });
//    }


}