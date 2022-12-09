package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.secondmood.gradetodata;
import com.example.myapplication.view.MainActivity;
public class grade_music extends AppCompatActivity {

    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);

        Button sign = (Button) findViewById(R.id.sign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grade_music.this.finish();

                gradetodata gd=new gradetodata(s);
                Toast.makeText(grade_music.this, "已簽收", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView emotionimage = (ImageView) findViewById(R.id.signemotionimage);

        SeekBar signbar = (SeekBar) findViewById(R.id.signBar);



        signbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Float emotionbar = new Float(progress);
                if (emotionbar <= 33) {
                    emotionimage.setImageResource(R.drawable.sad_removebg);
                    s=emotionbar.intValue();
                    /////
//                    gradetodata gd=new gradetodata(s);
//                    Toast.makeText(grade_music.this, "已簽收", Toast.LENGTH_SHORT).show();

                } else if (emotionbar > 33 && emotionbar <= 50) {
                    emotionimage.setImageResource(R.drawable.angry_removebg);
                    s=emotionbar.intValue();
                    /////
//                    gradetodata gd=new gradetodata(s);
//                    Toast.makeText(grade_music.this, "已簽收", Toast.LENGTH_SHORT).show();

                } else if (emotionbar > 50 && emotionbar <= 66) {
                    emotionimage.setImageResource(R.drawable.relax_removebg);
                    s=emotionbar.intValue();
                    /////
//                    gradetodata gd=new gradetodata(s);
//                    Toast.makeText(grade_music.this, "已簽收", Toast.LENGTH_SHORT).show();

                } else if (emotionbar > 66) {
                    emotionimage.setImageResource(R.drawable.joy_removebg);
                    s=emotionbar.intValue();
                    /////
//                    gradetodata gd=new gradetodata(s);
//                    Toast.makeText(grade_music.this, "已簽收", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

