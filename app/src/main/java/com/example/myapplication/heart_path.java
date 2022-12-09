package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintSet;

import android.media.MediaPlayer;
import android.widget.Toast;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.secondmood.getgrade;
import com.example.myapplication.secondmood.getsong_name;
import com.example.myapplication.view.fallingoff3;
import com.example.myapplication.view.usermood_third;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class heart_path extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static RadarData data;
    public static int songnumber = 0;
    int spinnerposition = 0;
    int emotionposition = 1;
    ListView listView621;
    ListView listView701;
    String[] items;
    float emotionbar;
    SeekBar seekbar;
    ImageView emotionimage;
    TextView viewright;
    TextView date;

    getsong_name gsong_name=new getsong_name();
    getgrade g_grade=new getgrade();

    public int song[] = {R.raw.antonio_carlos_jobim_look_to_the_sky, R.raw.antonio_carlos_jobim_wave, R.raw.antonio_carlos_jobim_the_girl_from_ipanema, R.raw.syz_encounter, R.raw.ilha_de_coral_coral_island};
    //鎮定劑//上面圖片
    public String tranhappy[] = {"C大調_張韶涵","一想到你呀_張雨生","一點點_林宥嘉","十二樓_李宗盛","三個願望_梁文音"};
    public String tranrelax[] = {"大肚腩_阿牛","小手拉大手_梁靜茹","心願便利貼_元若藍","兄妹_陳奕","半情歌_元若藍"};
    public String tranangry[] = {"光_張哲瀚","彼得潘_萬敬騰","偏心_那英","做我自己_那英","偷故事的人_張惠妹"};
    public String transad[] = {"國境之南_范逸臣","崇拜_梁靜茹","博物館_蘇打綠","想自由_林宥嘉","像鳥兒一樣_周深"};
    //暗夜
    public String nighthappy[]={"一次一種寂寞_彭佳慧","人質_張惠妹","剪愛_張惠妹","唯一(三立/台視戲劇《戀愛是科》插曲)_告五人","心酸的浪漫_那英"};
    public String nightrelax[]={"忽然之間_莫文蔚","慢慢喜歡你_莫文蔚","懂你才懂愛_彭佳慧","我們來拍張照_棉花糖","我相信_張靚穎"};
    public String nightangry[]={"最好的禮物(《八角亭迷霧》連續劇主題曲)_周深","很好_孫燕姿","阿拉斯加灣_菲道爾","需要你_張靚穎","二分之一的幸福_張學友"};
    public String nightsad[]={"你在煩惱什麼_蘇打綠","勇氣_梁靜茹","咖啡_張學友","天黑黑_孫燕姿","害怕_林俊傑"};
    //快樂
    //public String joyhappy[] = {"有一種悲傷叫蠢蛋_八三夭,A-Lin", "100個太陽月亮_棉花糖", "100種生活_盧廣仲", "一起去跑步_宇宙人","一起等地球爆炸吧_棉花糖"};
    public String joyhappy[] =gsong_name.getTag_kl_h();
    public String joyrelax[] = {"10,000 Hours_Dan,Shay,Justin Bieber", "一萬小時_宇宙人","人生最大的意義_安妮朵拉","大志若魚_宇宙人","不再怕寂寞-電視劇 《幸福不二家》片頭曲_曾沛慈"};
    public String joyangry[] = {"方向感_1976","出口_徐佳瑩","再見勾勾_盧廣仲","好日子_棉花糖","用心盡在其中-2015台中銀行企業形象廣告曲_吳汶芳"};
    //public String joysad[] = {"向晚的迷途指南_棉花糖","好朋友應該做的芭樂事_旺福","我要你好好的_劉若英,周迅,桂綸鎂,湯唯","金色海洋_棉花糖","勇敢_五月天"};
    public String joysad[]=gsong_name.getTag_kl_s();
    //放鬆
    public String relaxhappy[] = {"Wave_Antonio Carlos Jobim", "Look To The Sky_Antonio Carlos Jobim", "Triste_Antonio Carlos Jobim", "The Girl From Ipanema_Antonio Carlos Jobim", "IIha De Coral (Coral Island_Luiz Bonfa"};
    public String relaxrelax[] = {"How Insensitive_Antonio Adolfo", "Adios, Mariquita Linda_Los Indios Tabajaras","One Note Samba_Stan Getz","top of the world_naomi & goro","One Note Samba_Stan Getz"};
    public String relaxangry[] = {"Samba Cantina_Paul Desmond","BK Bossa Nova_Glenn Zaleski, Yotam Silberstein","Remember_Antonio Carlos Jobim","A Gallant Gentleman_We Lost The Sea","Bogatyri_We Lost The Sea"};
    public String relaxsad[] = {"The Last Dive of David Shaw_We Lost The Sea","Challenger Part 1- Flight_We Lost The Sea" , "Challenger Part 2 - A Swan Song_We Lost The Sea","Heaven_Bazzi" , "HISTORY_Joel Corry, Becky Hill"};
    //咆哮
    public String angryhappy[] = {"selling_張懸","顛倒_楊丞琳","優先權_蔡健雅","製造浪漫_陳慧琳,鄭中基","瘋狂的陽光_張懸"};
    public String angryrelax[] = {"溫柔_五月天","愛是懷疑_陳奕迅","嫁禍進行式_張懸","畢竟(魚 in summer)_魚丁糸","浪漫派_Sodagreen"};
    public String angryangry[] = {"要你的_陳奕迅","改變_趙一豪","我愛你_盧廣仲","你在我心中_鄧麗君","王妃_蕭敬騰"};
    public String angrysad[] = {"天哀請閉眼_陳零九,邱鋒澤","天后_陳勢安","下一次愛情來的時候_蔡健雅","一天_黃宣","一切都是為了與你相遇_棉花糖"};
    //安慰
    public String comforthappy[] = {"You're Somebody Else_flora cash","TV_Billie Eilish","traitor_Olivia Rodrigo","The Night We Met_Lord Huron","THE LONELIEST_Måneskin"};
    public String comfortrelax[] = {"Space Song_Beach House","Matilda_Harry Styles","Lonely_justin bieber,benny blanco","It'll Be Okay_Shawn Mendes","I GUESS I'M IN LOVE_Clinton Kane"};
    public String comfortangry[] = {"Hurtless_Dean Lewis","go_Cat Burns","Glimpse Of Us_Joji","GHOST TOWN_Benson Boone","get you the moon_Kina,Snow"};
    public String comfortsad[] = {"Fingers Crossed_Lauren Spencer Smith","Elliot's Song_Dominic Fike, Zendaya, Labrinth","Easy On Me_Adele","drunk text me_Lexi Jayde","Before You Go_Lewis Capaldi"};
    //擁抱
    public String embracehappy[] = {"聽見下雨的聲音_魏如昀","當我們一起走過_Sodagreen","想你的夜_關喆","痛快的哀艷_Sodagreen","彭佳慧_大齡女子"};
    public String embracerelax[] = {"故事_Sodagreen","勇敢愛_張靚穎","我們不懂_Sodagreen","別在傷口灑鹽_張惠妹","你要的全拿走_胡彥斌"};
    public String embraceangry[] = {"如果這就是愛情_張靚穎","回車諾比的夢_Sodagreen","出賣_那英","分不開_彭佳慧","不曾後悔_胡彥斌"};
    public String embracesad[] = {"小情歌_Sodagreen","大齡女子_彭佳慧","下個街角_蕭煌奇","下一個天亮_郭靜","上弦月_許志安"};

    //public String songname[] = joysad;
    public String songname[] =joyhappy;

    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("user_mood");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heart_path);

        ///
        date=findViewById(R.id.date_on);
        System.out.println("aaa"+Arrays.toString(songname));
        System.out.println("bbb"+Arrays.toString(joysad));


        //下拉選單
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        if(emotionposition ==1){
//                            songname=gsong_name.getTag_kl_h();
                            date.setText(gsong_name.getDate_1());
                            songname = joyhappy;
                        }else if(emotionposition ==2){
                            songname=gsong_name.getTag_kl_r();
                            date.setText(gsong_name.getDate_1());
//                            songname = joyrelax;
                        }else if(emotionposition ==3){
                            songname=gsong_name.getTag_kl_a();
                            date.setText(gsong_name.getDate_1());
//                            songname = joyangry;
                        }else if(emotionposition ==4){
//                            songname=gsong_name.getTag_kl_s();
                            date.setText(gsong_name.getDate_1());
//                            System.out.println(Arrays.toString(songname));
                            songname = joysad;
                        }
                        spinnerposition = 1;
                        displaySong();
                        break;

                    case 1:
                        if(emotionposition ==1){
                            songname=gsong_name.getTag_fs_h();
                            date.setText(gsong_name.getDate_2());
//                            songname = relaxhappy;
                        }else if(emotionposition ==2){
                            songname=gsong_name.getTag_fs_r();
                            date.setText(gsong_name.getDate_2());
                            //songname = relaxrelax;
                        }else if(emotionposition ==3){
                            songname=gsong_name.getTag_fs_a();
                            date.setText(gsong_name.getDate_2());
                            //songname = relaxangry;
                        }else if(emotionposition ==4){
                            songname=gsong_name.getTag_fs_s();
                            date.setText(gsong_name.getDate_2());
                            //songname = relaxsad;
                        }
                        spinnerposition = 2;
                        displaySong();
                        break;



                    case 2:
                        if(emotionposition ==1){
                            songname=gsong_name.getTag_anye_h();
                            date.setText(gsong_name.getDate_3());
                            //songname = nighthappy;
                        }else if(emotionposition ==2){
                            songname=gsong_name.getTag_anye_r();
                            date.setText(gsong_name.getDate_3());
                            //songname = nightrelax;
                        }else if(emotionposition ==3){
                            songname=gsong_name.getTag_anye_a();
                            date.setText(gsong_name.getDate_3());
                            //songname = nightangry;
                        }else if(emotionposition ==4){
                            songname=gsong_name.getTag_anye_s();
                            date.setText(gsong_name.getDate_3());
                            //songname = nightsad;
                        }
                        spinnerposition = 3;
                        displaySong();
                        break;


                    case 3:
                        if(emotionposition ==1){
                            songname=gsong_name.getTag_px_h();
                            date.setText(gsong_name.getDate_4());
                            //songname = angryhappy;
                        }else if(emotionposition ==2){
                            songname=gsong_name.getTag_px_r();
                            date.setText(gsong_name.getDate_4());
                            //songname = angryrelax;
                        }else if(emotionposition ==3){
                            songname=gsong_name.getTag_px_a();
                            date.setText(gsong_name.getDate_4());
                            //songname = angryangry;
                        }else if(emotionposition ==4){
                            songname=gsong_name.getTag_px_s();
                            date.setText(gsong_name.getDate_4());
                            //songname = angrysad;
                        }
                        spinnerposition = 4;
                        displaySong();
                        break;

                    case 4:
                        if(emotionposition ==1){
                            songname=gsong_name.getTag_aw_h();
                            date.setText(gsong_name.getDate_5());
                            //songname = comforthappy;
                        }else if(emotionposition ==2){
                            songname=gsong_name.getTag_aw_r();
                            date.setText(gsong_name.getDate_5());
                            //songname = comfortrelax;
                        }else if(emotionposition ==3){
                            songname=gsong_name.getTag_aw_a();
                            date.setText(gsong_name.getDate_5());
                            //songname = comfortangry;
                        }else if(emotionposition ==4){
                            songname=gsong_name.getTag_aw_s();
                            date.setText(gsong_name.getDate_5());
                            //songname = comfortsad;
                        }
                        spinnerposition = 5;
                        displaySong();
                        break;

                    case 5:
                        if(emotionposition ==1){
                            songname=gsong_name.getTag_yb_h();
                            date.setText(gsong_name.getDate_6());
                            //songname = embracehappy;
                        }else if(emotionposition ==2){
                            songname=gsong_name.getTag_yb_r();
                            date.setText(gsong_name.getDate_6());
                            //songname = embracerelax;
                        }else if(emotionposition ==3){
                            songname=gsong_name.getTag_yb_a();
                            date.setText(gsong_name.getDate_6());
                            //songname = embraceangry;
                        }else if(emotionposition ==4){
                            songname=gsong_name.getTag_yb_s();
                            date.setText(gsong_name.getDate_6());
                            //songname = embracesad;
                        }
                        spinnerposition = 6;
                        displaySong();
                        break;

                    case 6:
                        if(emotionposition ==1){
                            songname=gsong_name.getTag_zdj_h();
                            date.setText(gsong_name.getDate_7());
//                            songname = gsong_name.getSongs_name();
                        }else if(emotionposition ==2){
                            songname=gsong_name.getTag_zdj_r();
                            date.setText(gsong_name.getDate_7());
                            //songname = tranrelax;
                        }else if(emotionposition ==3){
                            songname=gsong_name.getTag_zdj_a();
                            date.setText(gsong_name.getDate_7());
                            //songname = tranangry;
                        }else if(emotionposition ==4){
                            songname=gsong_name.getTag_zdj_s();
                            date.setText(gsong_name.getDate_7());
                            //songname = transad;
                        }
                        spinnerposition = 7;
                        displaySong();
                        break;

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        emotionimage = (ImageView) findViewById(R.id.emotionimage);


        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                emotionbar = new Float(progress);
//                String gg=Float. toString(emotionbar);
                //emotionbar->gg

                if ((emotionbar <= 33) ) { //&& (g_grade.getGrade1()<=33)
                    emotionposition = 1; //tag
                    emotionimage.setImageResource(R.drawable.sad_removebg);
                    if ((spinnerposition == 1)){
                        //songname=gsong_name.getTag_kl_s();
                        date.setText(gsong_name.getDate_1());
                        System.out.println(Arrays.toString(songname));
                        songname = joysad;   //快樂，傷心圖片
                    }else if(spinnerposition == 2){
                        songname=gsong_name.getTag_fs_s();
                        date.setText(gsong_name.getDate_2());
                        //songname = relaxsad;
                    }else if(spinnerposition == 3){
                        songname=gsong_name.getTag_anye_s();
                        date.setText(gsong_name.getDate_3());
                        //songname = nightsad;
                    }else if(spinnerposition == 4){
                        songname=gsong_name.getTag_px_s();
                        date.setText(gsong_name.getDate_4());
                        //songname = angrysad;
                    }else if(spinnerposition == 5){
                        songname=gsong_name.getTag_aw_s();
                        date.setText(gsong_name.getDate_5());
                        //songname = comfortsad;
                    }else if(spinnerposition == 6){
                        songname=gsong_name.getTag_yb_s();
                        date.setText(gsong_name.getDate_6());
                        //songname = embracesad;
                    }else if(spinnerposition == 7){
                        songname=gsong_name.getTag_zdj_s();
                        date.setText(gsong_name.getDate_7());
                        //songname = transad;
                    }
                    displaySong();

                } else if ((emotionbar > 33 && emotionbar <= 50) && ((g_grade.getGrade1() > 33) && (g_grade.getGrade1() <= 50))) {
                    emotionposition = 2;
                    emotionimage.setImageResource(R.drawable.angry_removebg);
                    if (spinnerposition == 1){
                        songname=gsong_name.getTag_kl_a();
                        date.setText(gsong_name.getDate_1());
                        //songname = joyangry;
                    }else if(spinnerposition == 2){
                        songname=gsong_name.getTag_fs_a();
                        date.setText(gsong_name.getDate_2());
                        //songname = relaxangry;
                    }else if(spinnerposition == 3){
                        songname=gsong_name.getTag_anye_a();
                        date.setText(gsong_name.getDate_3());
                        //songname = nightangry;
                    }else if(spinnerposition == 4){
                        songname=gsong_name.getTag_px_a();
                        date.setText(gsong_name.getDate_4());
                        //songname = angryangry;
                    }else if(spinnerposition == 5){
                        songname=gsong_name.getTag_aw_a();
                        date.setText(gsong_name.getDate_5());
                        //songname = comfortangry;
                    }else if(spinnerposition == 6){
                        songname=gsong_name.getTag_yb_a();
                        //songname = embraceangry;
                    }else if(spinnerposition == 7){
                        songname=gsong_name.getTag_zdj_a();
                        //songname = tranangry;
                    }
                    displaySong();

                }else if((emotionbar >50 && emotionbar <= 66)&& ((g_grade.getGrade1() > 50) && (g_grade.getGrade1() <= 66))){
                    emotionposition = 3;
                    emotionimage.setImageResource(R.drawable.relax_removebg);
                    if (spinnerposition == 1){
                        songname=gsong_name.getTag_kl_r();
                        date.setText(gsong_name.getDate_1());
                        //songname = joyrelax;
                    }else if(spinnerposition == 2){
                        songname=gsong_name.getTag_fs_r();
                        date.setText(gsong_name.getDate_2());
                        //songname = relaxrelax;
                    }else if(spinnerposition == 3){
                        songname=gsong_name.getTag_anye_r();
                        date.setText(gsong_name.getDate_3());
                        //songname = nightrelax;
                    }else if(spinnerposition == 4){
                        songname=gsong_name.getTag_px_r();
                        date.setText(gsong_name.getDate_4());
                        //songname = angryrelax;
                    }else if(spinnerposition == 5){
                        songname=gsong_name.getTag_aw_r();
                        date.setText(gsong_name.getDate_5());
                        //songname = comfortrelax;
                    }else if(spinnerposition == 6){
                        songname=gsong_name.getTag_yb_r();
                        date.setText(gsong_name.getDate_6());
                        //songname = embracerelax;
                    }else if(spinnerposition == 7){
                        songname=gsong_name.getTag_zdj_r();
                        date.setText(gsong_name.getDate_7());
                        //songname = tranrelax;
                    }
                    displaySong();

                }else if((emotionbar > 66)&& (g_grade.getGrade1()>66)){
                    emotionposition = 4;
                    emotionimage.setImageResource(R.drawable.joy_removebg);
                    if (spinnerposition == 1){
                        songname=gsong_name.getTag_kl_h();
                        date.setText(gsong_name.getDate_1());
                        //songname = joyhappy;
                    }else if(spinnerposition == 2){
                        songname=gsong_name.getTag_fs_h();
                        date.setText(gsong_name.getDate_2());
                        //songname = relaxhappy;
                    }else if(spinnerposition == 3){
                        songname=gsong_name.getTag_anye_h();
                        date.setText(gsong_name.getDate_3());
                        //songname = nighthappy;
                    }else if(spinnerposition == 4){
                        songname=gsong_name.getTag_px_h();
                        date.setText(gsong_name.getDate_4());
                        //songname = angryhappy;
                    }else if(spinnerposition == 5){
                        songname=gsong_name.getTag_aw_h();
                        date.setText(gsong_name.getDate_5());
                        //songname = comforthappy;
                    }else if(spinnerposition == 6){
                        songname=gsong_name.getTag_yb_h();
                        date.setText(gsong_name.getDate_6());
                        //songname = embracehappy;
                    }else if(spinnerposition == 7){
                        songname = gsong_name.getTag_zdj_h();
                        date.setText(gsong_name.getDate_7());
                    }
                    displaySong();

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //播放紀錄清單
        listView621 = (ListView) findViewById(R.id.listview621);
        listView701 = (ListView) findViewById(R.id.listview701);
        CardView name = (CardView) findViewById(R.id.name);

        displaySong();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void displaySong() {
        customAdpter CustomAdpter = new customAdpter();
        listView621.setAdapter(CustomAdpter);
        listView701.setAdapter(CustomAdpter);
    }

    class customAdpter extends BaseAdapter {

        @Override
        public int getCount() {
            return songname.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View converview, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.my_music, null);//
            TextView txtSong = view.findViewById(R.id.songname);//
            txtSong.setSelected(true);
            txtSong.setText(songname[position]);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("position", "" + position + "");


                    if (position == 0) {
                        songnumber = 0;

                    } else if (position == 1) {
                        songnumber = 1;


                    } else if (position == 2) {
                        songnumber = 2;


                    } else if (position == 3) {
                        songnumber = 3;


                    } else if (position == 4) {
                        songnumber = 4;


                    }
                    Intent intent = new Intent(heart_path.this,music_profile.class);
                    startActivity(intent);
                }
            });
            return view;
        }
    }
}