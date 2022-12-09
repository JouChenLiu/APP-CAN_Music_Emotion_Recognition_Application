package com.example.myapplication.secondmood;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplication.view.usermood_third;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class gradetodata {

    DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("user_mood");
    private String grades;
    HashMap<String, Object> map = new HashMap<>();

    public gradetodata(int a){

        Query q= FirebaseDatabase.getInstance().getReference("user_mood").orderByChild("grade").equalTo("null");

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1:snapshot.getChildren()) {
                    String ids = snapshot1.getKey();//讀到自動id
                    String value = snapshot1.child("grade").getValue(String.class);
                    System.out.println(a);

                    if (value=="null"){System.out.println("Grade Err"); }
                    else {
                        System.out.println("Grade ing");
                        map.put("grade", a);
                        ref.child(ids).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                //Toast.makeText(gradetodata.this, "快樂共鳴", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
