package com.example.myapplication.secondmood;


import androidx.annotation.NonNull;

import com.example.myapplication.songfile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class inputurl {

    public String[] songurl = songfile.songurl;
    public static String songname[] = songfile.songname;
    songs_url songsUrl=new songs_url();

    DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("user_mood");

    String su1,su2,su3,su4,su5;

    public inputurl(){
        su1=songname[0];
        su2=songname[1];
        su3=songname[2];
        su4=songname[3];
        su5=songname[4];
        //從外面拿歌進來

        songsUrl.setSu1(su1);
        songsUrl.setSu2(su2);
        songsUrl.setSu3(su3);
        songsUrl.setSu4(su4);
        songsUrl.setSu5(su5);
        //把歌名放進去

//      System.out.println(songurl[0]);

        Query q1=ref.orderByChild("song_url/su1").equalTo(null);
        q1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()) {
                    String ids = snapshot1.getKey();//讀到自動id,print id
                    String out = snapshot1.child("song_url/su1").getValue(String.class);////su1的值
                    System.out.println(ids);
                    System.out.println(out);

                    ref.child(ids).child("song_url").setValue(songsUrl);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    ////
//    DatabaseReference c=ref.child("song_url");
//
//    Query q= FirebaseDatabase.getInstance().getReference("user_mood").child("song_url").orderByChild("su1").equalTo(1);
//
//
    /////
}
