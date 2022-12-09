package com.example.myapplication.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.heart_path;
import com.example.myapplication.secondmood.songs_url;
import com.example.myapplication.songfile;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
public class usermood_third extends AppCompatActivity {
    Button tapeButton1, tapeButton2, tapeButton3, tapeButton4 ,tapeButton5, tapeButton6, tapeButton7, tapeButton8;
    String su1,su2,su3,su4,su5;
    songs_url songsUrl=new songs_url();
    public String[] songurl = songfile.songurl;

    DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("user_mood");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermood_third);
        HashMap<String, Object> map = new HashMap<>();
        su1="1";
        su2="2";
        su3="3";
        su4="4";
        su5="5";
        songsUrl.setSu1(su1);
        songsUrl.setSu2(su2);
        songsUrl.setSu3(su3);
        songsUrl.setSu4(su4);
        songsUrl.setSu5(su5);
        Query q= FirebaseDatabase.getInstance().getReference("user_mood").orderByChild("tag").equalTo("null");
        FloatingActionButton back_bt = findViewById(R.id.back_bt);
        back_bt.setOnClickListener(new View.OnClickListener() { //點擊後執行返回上一頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, usermood_second.class);
                startActivity(intent);
            }
        });
        tapeButton1 = findViewById(R.id.tapeButton1);
        tapeButton1.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                songfile.randomjoypos();
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff1.class);
                startActivity(intent);

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
                            System.out.println(s);
                            String tag1 = "快樂共鳴";
                            if (m1=="null"){
                                System.out.println("Err");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag1);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "快樂共鳴", Toast.LENGTH_SHORT).show();
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
        });
        tapeButton2 = findViewById(R.id.tapeButton2);
        tapeButton2.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                songfile.randomrelaxpos();
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff3.class);
                startActivity(intent);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
//                            System.out.println(s);
//                            System.out.println(m1);
                            String tag2 = "放鬆";
                            if (m1=="null"){
                                System.out.println("Err");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag2);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "放鬆", Toast.LENGTH_SHORT).show();
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
        });
        tapeButton3 = findViewById(R.id.tapeButton3);
        tapeButton3.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                songfile.randomrelaxnegtive();
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff4.class);
                startActivity(intent);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
//                            System.out.println(s);
//                            System.out.println(m1);
                            String tag3 = "暗夜之旅";
                            if (m1=="null"){
                                System.out.println("Err");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag3);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "暗夜之旅", Toast.LENGTH_SHORT).show();
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
        });
        tapeButton4 = findViewById(R.id.tapeButton4);
        tapeButton4.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                songfile.randomangry();
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff1.class);
                startActivity(intent);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
//                            System.out.println(s);
//                            System.out.println(m1);
                            String tag4 = "咆哮";
                            if (m1=="null"){
                                System.out.println("ERROR");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag4);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "咆哮", Toast.LENGTH_SHORT).show();
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
        });
        tapeButton5 = findViewById(R.id.tapeButton5);
        tapeButton5.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                songfile.randomsadnegtive();;
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff2.class);
                startActivity(intent);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
//                            System.out.println(s);
//                            System.out.println(m1);
                            String tag5 = "安慰";
                            if (m1=="null"){
                                System.out.println("ERROR");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag5);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "安慰", Toast.LENGTH_SHORT).show();
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
        });
        tapeButton6 = findViewById(R.id.tapeButton6);
        tapeButton6.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                songfile.randomsadpos();
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff3.class);
                startActivity(intent);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
//                            System.out.println(s);
//                            System.out.println(m1);
                            String tag6 = "擁抱";
                            if (m1=="null"){
                                System.out.println("ERROR");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag6);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "擁抱", Toast.LENGTH_SHORT).show();
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
        });
        tapeButton7 = findViewById(R.id.tapeButton7);
        tapeButton7.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                songfile.randomjoynegtive();
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff2.class);
                startActivity(intent);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
//                            System.out.println(s);
//                            System.out.println(m1);
                            String tag7 = "鎮定劑";
                            if (m1=="null"){
                                System.out.println("ERROR");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag7);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "鎮定劑", Toast.LENGTH_SHORT).show();
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
        });
        tapeButton8 = findViewById(R.id.tapeButton8);
        tapeButton8.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(usermood_third.this, fallingoff5.class);
                startActivity(intent);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1:snapshot.getChildren()) {
                            String s = snapshot1.getKey();//讀到自動id
                            String m1 = snapshot1.child("tag").getValue(String.class);
//                            System.out.println(s);
//                            System.out.println(m1);
                            String tag8 = "思緒漫游";
                            if (m1=="null"){
                                System.out.println("ERROR");
                            }
                            else {
                                System.out.println("ing");
                                map.put("tag", tag8);
                                ref.child(s).updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(usermood_third.this, "思緒漫游", Toast.LENGTH_SHORT).show();
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
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}