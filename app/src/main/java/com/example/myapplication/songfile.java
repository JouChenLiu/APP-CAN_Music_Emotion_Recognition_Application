package com.example.myapplication;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class songfile extends AppCompatActivity {


    static FirebaseAuth fAuth;
    static FirebaseFirestore fStore;
    public static String song[]=new String[5];
    public static DocumentReference documentReference;
    public static String songname[]= new String[5];
    public static String songurl[] = new String[5];
    public static String melody[] = new String[5];
    public static float joy[] = new float[5];
    public static float sad[] = new float[5];
    public static float hopeless[] = new float[5];
    public static float distaste[] = new float[5];
    public static float warmth[] = new float[5];
    public static float excited[] = new float[5];

    public static int r;
    public static int songfilenumber[];
    public static int flagsame = 1;

    public int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






    }

    public static void randomsadnegtive() {

        songfilenumber = new int[5];
        for (int i = 0; i < 5; i++) {
            flagsame = 0;
            do {
                flagsame = 0;
                r = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    if (songfilenumber[j] == r) {
                        flagsame = 1;
                        break;
                    }
                }
            } while (flagsame == 1);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

            songfilenumber[i] = r;
            documentReference = fStore.collection("推薦系統_資料庫 - Sad分析").document(String.valueOf(r));
            Log.e("get",""+documentReference);
            int finalI = i;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    DocumentSnapshot document = task.getResult();
                    songname[finalI] = document.getString("songname");
                    songurl[finalI] = document.getString("songurl");
                    melody[finalI] = document.getString("melody");
                    joy[finalI] = Float.valueOf(document.getString("joy_sig"));
                    sad[finalI] = Float.valueOf(document.getString("sadness_sig"));
                    hopeless[finalI] = Float.valueOf(document.getString("hopeless_sig"));
                    excited[finalI] = Float.valueOf(document.getString("excited_sig"));
                    distaste[finalI] = Float.valueOf( document.getString("distaste_sig"));
                    warmth[finalI] = Float.valueOf( document.getString("warmth_sig"));
                }
            });
        }
    }


    public static void randomsadpos() {

        songfilenumber = new int[5];
        for (int i = 0; i < 5; i++) {
            flagsame = 0;
            do {
                flagsame = 0;
                r = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    if (songfilenumber[j] == r) {
                        flagsame = 1;
                        break;
                    }
                }
            } while (flagsame == 1);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

            songfilenumber[i] = r;
            documentReference = fStore.collection("推薦系統_資料庫 - Sad正向").document(String.valueOf(r));
            Log.e("get",""+documentReference);
            int finalI = i;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    DocumentSnapshot document = task.getResult();
                    songname[finalI] = document.getString("songname");
                    songurl[finalI] = document.getString("songurl");
                    melody[finalI] = document.getString("melody");
                    joy[finalI] = Float.valueOf(document.getString("joy_sig"));
                    sad[finalI] = Float.valueOf(document.getString("sadness_sig"));
                    hopeless[finalI] = Float.valueOf(document.getString("hopeless_sig"));
                    excited[finalI] = Float.valueOf(document.getString("excited_sig"));
                    distaste[finalI] = Float.valueOf( document.getString("distaste_sig"));
                    warmth[finalI] = Float.valueOf( document.getString("warmth_sig"));
                }
            });
        }
    }


    public static void randomjoynegtive() {

        songfilenumber = new int[5];
        for (int i = 0; i < 5; i++) {
            flagsame = 0;
            do {
                flagsame = 0;
                r = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    if (songfilenumber[j] == r) {
                        flagsame = 1;
                        break;
                    }
                }
            } while (flagsame == 1);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

            songfilenumber[i] = r;
            documentReference = fStore.collection("推薦系統_資料庫 - Happy分析").document(String.valueOf(r));
            Log.e("get",""+documentReference);
            int finalI = i;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    DocumentSnapshot document = task.getResult();
                    songname[finalI] = document.getString("songname");
                    songurl[finalI] = document.getString("songurl");
                    melody[finalI] = document.getString("melody");
                    joy[finalI] = Float.valueOf(document.getString("joy_sig"));
                    sad[finalI] = Float.valueOf(document.getString("sadness_sig"));
                    hopeless[finalI] = Float.valueOf(document.getString("hopeless_sig"));
                    excited[finalI] = Float.valueOf(document.getString("excited_sig"));
                    distaste[finalI] = Float.valueOf( document.getString("distaste_sig"));
                    warmth[finalI] = Float.valueOf( document.getString("warmth_sig"));
                }
            });
        }
    }


    public static void randomjoypos() {

        songfilenumber = new int[5];
        for (int i = 0; i < 5; i++) {
            flagsame = 0;
            do {
                flagsame = 0;
                r = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    if (songfilenumber[j] == r) {
                        flagsame = 1;
                        break;
                    }
                }
            } while (flagsame == 1);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

            songfilenumber[i] = r;
            documentReference = fStore.collection("推薦系統_資料庫 - Happy正向").document(String.valueOf(r));
            Log.e("get",""+documentReference);
            int finalI = i;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    DocumentSnapshot document = task.getResult();
                    songname[finalI] = document.getString("songname");
                    songurl[finalI] = document.getString("songurl");
                    melody[finalI] = document.getString("melody");
                    joy[finalI] = Float.valueOf(document.getString("joy_sig"));
                    sad[finalI] = Float.valueOf(document.getString("sadness_sig"));
                    hopeless[finalI] = Float.valueOf(document.getString("hopeless_sig"));
                    excited[finalI] = Float.valueOf(document.getString("excited_sig"));
                    distaste[finalI] = Float.valueOf( document.getString("distaste_sig"));
                    warmth[finalI] = Float.valueOf( document.getString("warmth_sig"));
                }
            });
        }
    }


    public static void randomrelaxnegtive() {

        songfilenumber = new int[5];
        for (int i = 0; i < 5; i++) {
            flagsame = 0;
            do {
                flagsame = 0;
                r = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    if (songfilenumber[j] == r) {
                        flagsame = 1;
                        break;
                    }
                }
            } while (flagsame == 1);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

            songfilenumber[i] = r;
            documentReference = fStore.collection("推薦系統_資料庫 - Relax分析").document(String.valueOf(r));
            Log.e("get",""+documentReference);
            int finalI = i;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    DocumentSnapshot document = task.getResult();
                    songname[finalI] = document.getString("songname");
                    songurl[finalI] = document.getString("songurl");
                    melody[finalI] = document.getString("melody");
                    joy[finalI] = Float.valueOf(document.getString("joy_sig"));
                    sad[finalI] = Float.valueOf(document.getString("sadness_sig"));
                    hopeless[finalI] = Float.valueOf(document.getString("hopeless_sig"));
                    excited[finalI] = Float.valueOf(document.getString("excited_sig"));
                    distaste[finalI] = Float.valueOf( document.getString("distaste_sig"));
                    warmth[finalI] = Float.valueOf( document.getString("warmth_sig"));
                }
            });
        }
    }


    public static void randomrelaxpos() {

        songfilenumber = new int[5];
        for (int i = 0; i < 5; i++) {
            flagsame = 0;
            do {
                flagsame = 0;
                r = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    if (songfilenumber[j] == r) {
                        flagsame = 1;
                        break;
                    }
                }
            } while (flagsame == 1);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

            songfilenumber[i] = r;
            documentReference = fStore.collection("推薦系統_資料庫 - Relax正向").document(String.valueOf(r));
            Log.e("get",""+documentReference);
            int finalI = i;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    DocumentSnapshot document = task.getResult();
                    songname[finalI] = document.getString("songname");
                    songurl[finalI] = document.getString("songurl");
                    melody[finalI] = document.getString("melody");
                    joy[finalI] = Float.valueOf(document.getString("joy_sig"));
                    sad[finalI] = Float.valueOf(document.getString("sadness_sig"));
                    hopeless[finalI] = Float.valueOf(document.getString("hopeless_sig"));
                    excited[finalI] = Float.valueOf(document.getString("excited_sig"));
                    distaste[finalI] = Float.valueOf( document.getString("distaste_sig"));
                    warmth[finalI] = Float.valueOf( document.getString("warmth_sig"));
                }
            });
        }
    }


    public static void randomangry() {

        songfilenumber = new int[5];
        for (int i = 0; i < 5; i++) {
            flagsame = 0;
            do {
                flagsame = 0;
                r = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    if (songfilenumber[j] == r) {
                        flagsame = 1;
                        break;
                    }
                }
            } while (flagsame == 1);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

            songfilenumber[i] = r;
            documentReference = fStore.collection("推薦系統_資料庫 - Angry分析").document(String.valueOf(r));
            Log.e("get",""+documentReference);
            int finalI = i;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    DocumentSnapshot document = task.getResult();
                    songname[finalI] = document.getString("songname");
                    songurl[finalI] = document.getString("songurl");
                    melody[finalI] = document.getString("melody");
                    joy[finalI] = Float.valueOf(document.getString("joy_sig"));
                    sad[finalI] = Float.valueOf(document.getString("sadness_sig"));
                    hopeless[finalI] = Float.valueOf(document.getString("hopeless_sig"));
                    excited[finalI] = Float.valueOf(document.getString("excited_sig"));
                    distaste[finalI] = Float.valueOf( document.getString("distaste_sig"));
                    warmth[finalI] = Float.valueOf( document.getString("warmth_sig"));
                }
            });
        }
    }

}

