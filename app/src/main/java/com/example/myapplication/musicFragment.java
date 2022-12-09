package com.example.myapplication;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.secondmood.inputurl;
import com.example.myapplication.view.MainActivity;
import com.example.myapplication.view.usermood_second;
import com.example.myapplication.view.usermood_third;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class musicFragment extends Fragment {


    public static int resume;
    public radarFragment radarfragment;
    public String[] songurl = songfile.songurl;
    public static int songnumber = heart_path.songnumber;
    public static MediaPlayer player = music_profile.player;
    private Boolean isFront = true;
    public ViewPager viewPager = music_profile.viewPager;
    public RadarData data = heart_path.data;

    public static ImageView next;
    public static ImageView last;
    public static ImageView imagealbum;

    private StorageReference mStorageRef;
    int totaltime;
    private ImageView playpause;
    private SeekBar positionbar;
    private TextView elapsedTimeLabel, remainingTimeLabel;
    public int song[] = {R.raw.antonio_carlos_jobim_look_to_the_sky, R.raw.antonio_carlos_jobim_wave, R.raw.antonio_carlos_jobim_the_girl_from_ipanema, R.raw.syz_encounter, R.raw.ilha_de_coral_coral_island};
    public static String songname[] = songfile.songname;
    public TextView textsongname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music, container, false);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        resume=1;


        textsongname = (TextView) v.findViewById(R.id.textView);

        textsongname.setText(songname[songnumber]);

        textsongname.setSelected(true);
        last = (ImageView) v.findViewById(R.id.last);
        next = (ImageView) v.findViewById(R.id.next);
        imagealbum = (ImageView) v.findViewById(R.id.imagealbum);
        Animation am = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        am.setDuration(10000);
        am.setInterpolator(new LinearInterpolator());
        am.setRepeatCount(Animation.INFINITE);
        imagealbum.setAnimation(am);
        am.startNow();

        int scale = (int) getActivity().getApplicationContext().getResources().getDisplayMetrics().density;

        de.hdodenhof.circleimageview.CircleImageView front = (de.hdodenhof.circleimageview.CircleImageView) v.findViewById(R.id.imagealbum);

        de.hdodenhof.circleimageview.CircleImageView flip = (de.hdodenhof.circleimageview.CircleImageView) v.findViewById(R.id.albumbutton);
        front.setCameraDistance(8000 * scale);


        elapsedTimeLabel = (TextView) v.findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) v.findViewById((R.id.remainingTimeLabel));
        playpause = (ImageView) v.findViewById(R.id.playButton);
        player = new MediaPlayer();
        try {
            player.setDataSource(songurl[songnumber]);
            //
            inputurl u=new inputurl();
            //
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.setLooping(true);
        totaltime = player.getDuration();
        positionbar = (SeekBar) v.findViewById(R.id.position);
        positionbar.setMax(totaltime);

        positionbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    player.seekTo(progress);
                    positionbar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        if(songnumber == 0){
            last.setEnabled((false));
            last.setAlpha(120);

        }else if(songnumber == 4){
            next.setEnabled(false);
            next.setAlpha(120);

        }

        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.isPlaying()) {
                    player.pause();
                    playpause.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    player.start();
                    playpause.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();

                resume = 0;


                if (songnumber >= 0 && songnumber <= 3) {
                    songnumber++;
                    radarFragment.songnumber++;
                    player.reset();
                    try {
                        player.setDataSource(songurl[songnumber]);
                        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mediaPlayer.start();
                            }
                        });
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    textsongname.setText(songname[songnumber]);
                    playpause.setImageResource(android.R.drawable.ic_media_pause);
                    totaltime = player.getDuration();

                }

                if (songnumber == 4) {
                    next.setEnabled(false);
                    next.setAlpha(120);
                } else {
                    next.setEnabled(true);
                    next.setAlpha(255);
                }
                if (songnumber == 0) {
                    last.setEnabled((false));
                    last.setAlpha(120);
                } else {
                    last.setEnabled(true);
                    last.setAlpha(255);
                }


            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();
                resume = 0;

                if (songnumber >= 1 && songnumber <= 4) {
                    songnumber--;
                    radarFragment.songnumber--;
                    player.reset();
                    try {
                        player.setDataSource(songurl[songnumber]);
                        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mediaPlayer.start();
                            }
                        });
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    textsongname.setText(songname[songnumber]);
                    playpause.setImageResource(android.R.drawable.ic_media_pause);
                    totaltime = player.getDuration();
                }

                if (songnumber == 4) {
                    next.setEnabled(false);
                    next.setAlpha(120);
                } else {
                    next.setEnabled(true);
                    next.setAlpha(255);
                }
                if (songnumber == 0) {
                    last.setEnabled((false));
                    last.setAlpha(120);
                } else {
                    last.setEnabled(true);
                    last.setAlpha(255);
                }


            }
        });

        imagealbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), radaract.class);
                startActivity(intent);
            }
        });

        FloatingActionButton home_bt = v.findViewById(R.id.home_bt);
        home_bt.setOnClickListener(new View.OnClickListener() { //點擊後執行返回上一頁的指令
            @Override
            public void onClick(View view) {
                getActivity().finish();
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (player != null) {
                    try {
                        Message msg = new Message();
                        msg.what = player.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }).start();


        return v;
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            int currentPosition = msg.what;
            // Update positionBar.
            positionbar.setProgress(currentPosition);

            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = "- " + createTimeLabel(totaltime - currentPosition);
            remainingTimeLabel.setText(remainingTime);


            return true;
        }
    });

    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        getActivity().finish();
    }

}