package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.chibde.visualizer.CircleBarVisualizer;
import com.chibde.visualizer.SquareBarVisualizer;
import com.example.myapplication.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;
public class blindbox extends AppCompatActivity{

    public MediaPlayer player;
    public Button playpause;
    public ImageButton playbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blindbox);



        playpause = (Button) findViewById(R.id.buttonplay);

        player = MediaPlayer.create(this, R.raw.rewritethestars);
        player.setLooping(true);
        player.start();


        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.isPlaying()) {
                    player.pause();
                    playpause.setBackground(getResources().getDrawable(R.drawable.can_close));

                } else {
                    player.start();
                    playpause.setBackground(getResources().getDrawable(R.drawable.can_open));

                }
            }
        });

        reqestPermission();
    }

    private void reqestPermission(){

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.RECORD_AUDIO
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()){

                    starAudioVisulizer();

                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }


        }).onSameThread().check();
    }

    private void starAudioVisulizer() {
        SquareBarVisualizer squareBarVisualizer = findViewById(R.id.visualizer);

// set custom color to the line.
        squareBarVisualizer.setColor(ContextCompat.getColor(this, R.color.sky));

// define custom number of bars you want in the visualizer between (10 - 256).
        squareBarVisualizer.setDensity(65);

// Set Spacing
        squareBarVisualizer.setGap(2);

// Set your media player to the visualizer.
        squareBarVisualizer.setPlayer(player.getAudioSessionId());
    }


    private void startcircle(){
        CircleBarVisualizer circleBarVisualizer = findViewById(R.id.visualizer);
        player = MediaPlayer.create(this, R.raw.rewritethestars);

// set custom color to the line.
        circleBarVisualizer.setColor(ContextCompat.getColor(this, R.color.white));

// Set you media player to the visualizer.
        circleBarVisualizer.setPlayer(player.getAudioSessionId());
    }

    public void onDestroy() {
        super.onDestroy();
        if(player.isPlaying()){
            player.stop();
        }
    }
}
