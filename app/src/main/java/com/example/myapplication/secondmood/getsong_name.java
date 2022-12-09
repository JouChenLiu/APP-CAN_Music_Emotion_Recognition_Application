package com.example.myapplication.secondmood;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.Arrays;

public class getsong_name {

    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("user_mood");
    String sn1,sn2,sn3,sn4,sn5;
    public String tag_kl_h[]=new String[5];
    public String tag_kl_s[]=new String[5];
    public String tag_kl_a[]=new String[5];
    public String tag_kl_r[]=new String[5];
    public String tag_fs_h[]=new String[5];
    public String tag_fs_s[]=new String[5];
    public String tag_fs_a[]=new String[5];
    public String tag_fs_r[]=new String[5];
    public String tag_anye_h[]=new String[5];
    public String tag_anye_s[]=new String[5];
    public String tag_anye_a[]=new String[5];
    public String tag_anye_r[]=new String[5];
    public String tag_px_h[]=new String[5];
    public String tag_px_s[]=new String[5];
    public String tag_px_a[]=new String[5];
    public String tag_px_r[]=new String[5];
    public String tag_aw_h[]=new String[5];
    public String tag_aw_s[]=new String[5];
    public String tag_aw_a[]=new String[5];
    public String tag_aw_r[]=new String[5];
    public String tag_yb_h[]=new String[5];
    public String tag_yb_s[]=new String[5];
    public String tag_yb_a[]=new String[5];
    public String tag_yb_r[]=new String[5];
    public String tag_zdj_h[]=new String[5];
    public String tag_zdj_s[]=new String[5];
    public String tag_zdj_a[]=new String[5];
    public String tag_zdj_r[]=new String[5];
    private String date_1,date_2,date_3,date_4,date_5,date_6,date_7;
    public int g;
    getgrade g_g=new getgrade();


    public getsong_name(){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String date1=snapshot1.child("date").getValue().toString();

                    String tags=snapshot1.child("tag").getValue().toString();
                    sn1=snapshot1.child("song_url/su1").getValue().toString();
                    sn2=snapshot1.child("song_url/su2").getValue().toString();
                    sn3=snapshot1.child("song_url/su3").getValue().toString();
                    sn4=snapshot1.child("song_url/su4").getValue().toString();
                    sn5=snapshot1.child("song_url/su5").getValue().toString();



                    boolean t=tags.contains("快");
                    if (t && (g_g.getGrade1()>66)){
                        tag_kl_h[0] = sn1;
                        tag_kl_h[1] = sn2;
                        tag_kl_h[2] = sn3;
                        tag_kl_h[3] = sn4;
                        tag_kl_h[4] = sn5;
                        System.out.println(date1);

                        date_1=date1;
                        System.out.println(g_g.getGrade1());
                        System.out.println(Arrays.toString(tag_kl_h));
                    }
                    else if (t && (g_g.getGrade1()<=33)){

                        tag_kl_s[0] = sn1;
                        tag_kl_s[1] = sn2;
                        tag_kl_s[2] = sn3;
                        tag_kl_s[3] = sn4;
                        tag_kl_s[4] = sn5;
                        System.out.println(date1);

                        date_1=date1;
                        System.out.println(date_1);
                        System.out.println(Arrays.toString(tag_kl_s));
                    }
                    else if (t && ((g_g.getGrade1() > 33) && (g_g.getGrade1() <= 50))){

                        tag_kl_a[0] = sn1;
                        tag_kl_a[1] = sn2;
                        tag_kl_a[2] = sn3;
                        tag_kl_a[3] = sn4;
                        tag_kl_a[4] = sn5;
                        System.out.println(date1);

                        date_1=date1;
                        System.out.println(date_1);
                        System.out.println(Arrays.toString(tag_kl_a));
                    }
                    else if (t && ((g_g.getGrade1() > 50) && (g_g.getGrade1() <= 66))){

                        tag_kl_r[0] = sn1;
                        tag_kl_r[1] = sn2;
                        tag_kl_r[2] = sn3;
                        tag_kl_r[3] = sn4;
                        tag_kl_r[4] = sn5;
                        System.out.println(date1);

                        date_1=date1;
                        System.out.println(date_1);
                        System.out.println(Arrays.toString(tag_kl_r));
                    }
//////////////////////////////////////////
                    boolean t1=tags.contains("放");
                    if (t1 && (g_g.getGrade1()>66)){
                        tag_fs_h[0] = sn1;
                        tag_fs_h[1] = sn2;
                        tag_fs_h[2] = sn3;
                        tag_fs_h[3] = sn4;
                        tag_fs_h[4] = sn5;
                        date_2=date1;
                        System.out.println(Arrays.toString(tag_fs_h));
                    }
                    else if (t1 && (g_g.getGrade1()<=33)){

                        tag_fs_s[0] = sn1;
                        tag_fs_s[1] = sn2;
                        tag_fs_s[2] = sn3;
                        tag_fs_s[3] = sn4;
                        tag_fs_s[4] = sn5;
                        System.out.println(date1);

                        date_2=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_fs_s));
                    }
                    else if (t1 && ((g_g.getGrade1() > 33) && (g_g.getGrade1() <= 50))){

                        tag_fs_a[0] = sn1;
                        tag_fs_a[1] = sn2;
                        tag_fs_a[2] = sn3;
                        tag_fs_a[3] = sn4;
                        tag_fs_a[4] = sn5;
                        System.out.println(date1);

                        date_2=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_a));
                    }
                    else if (t1 && ((g_g.getGrade1() > 50) && (g_g.getGrade1() <= 66))){

                        tag_fs_r[0] = sn1;
                        tag_fs_r[1] = sn2;
                        tag_fs_r[2] = sn3;
                        tag_fs_r[3] = sn4;
                        tag_fs_r[4] = sn5;
                        System.out.println(date1);

                        date_2=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_r));
                    }
///////////////////////////
                    boolean t2=tags.contains("暗");
                    if (t2 && (g_g.getGrade1()>66)){
                        tag_anye_h[0] = sn1;
                        tag_anye_h[1] = sn2;
                        tag_anye_h[2] = sn3;
                        tag_anye_h[3] = sn4;
                        tag_anye_h[4] = sn5;
                        date_3=date1;
                        //System.out.println(Arrays.toString(tag_anye));
                    }
                    else if (t2 && (g_g.getGrade1()<=33)){

                        tag_anye_s[0] = sn1;
                        tag_anye_s[1] = sn2;
                        tag_anye_s[2] = sn3;
                        tag_anye_s[3] = sn4;
                        tag_anye_s[4] = sn5;
                        System.out.println(date1);

                        date_3=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_fs_s));
                    }
                    else if (t2 && ((g_g.getGrade1() > 33) && (g_g.getGrade1() <= 50))){

                        tag_anye_a[0] = sn1;
                        tag_anye_a[1] = sn2;
                        tag_anye_a[2] = sn3;
                        tag_anye_a[3] = sn4;
                        tag_anye_a[4] = sn5;
                        System.out.println(date1);

                        date_3=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_a));
                    }
                    else if (t2 && ((g_g.getGrade1() > 50) && (g_g.getGrade1() <= 66))){

                        tag_anye_r[0] = sn1;
                        tag_anye_r[1] = sn2;
                        tag_anye_r[2] = sn3;
                        tag_anye_r[3] = sn4;
                        tag_anye_r[4] = sn5;
                        System.out.println(date1);

                        date_3=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_r));
                    }
////////////////////////////////////

                    boolean t3=tags.contains("咆");
                    if (t3 && (g_g.getGrade1()>66)){
                        tag_px_h[0] = sn1;
                        tag_px_h[1] = sn2;
                        tag_px_h[2] = sn3;
                        tag_px_h[3] = sn4;
                        tag_px_h[4] = sn5;
                        date_4=date1;
                        //System.out.println(Arrays.toString(tag_px));
                    }
                    else if (t3 && (g_g.getGrade1()<=33)){

                        tag_px_s[0] = sn1;
                        tag_px_s[1] = sn2;
                        tag_px_s[2] = sn3;
                        tag_px_s[3] = sn4;
                        tag_px_s[4] = sn5;
                        System.out.println(date1);

                        date_4=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_fs_s));
                    }
                    else if (t3 && ((g_g.getGrade1() > 33) && (g_g.getGrade1() <= 50))){

                        tag_px_a[0] = sn1;
                        tag_px_a[1] = sn2;
                        tag_px_a[2] = sn3;
                        tag_px_a[3] = sn4;
                        tag_px_a[4] = sn5;
                        System.out.println(date1);

                        date_4=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_a));
                    }
                    else if (t3 && ((g_g.getGrade1() > 50) && (g_g.getGrade1() <= 66))){

                        tag_px_r[0] = sn1;
                        tag_px_r[1] = sn2;
                        tag_px_r[2] = sn3;
                        tag_px_r[3] = sn4;
                        tag_px_r[4] = sn5;
                        System.out.println(date1);

                        date_4=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_r));
                    }
///////////////////////////////////////////
                    boolean t4=tags.contains("安");
                    if (t4 && (g_g.getGrade1()>66)){
                        tag_aw_h[0] = sn1;
                        tag_aw_h[1] = sn2;
                        tag_aw_h[2] = sn3;
                        tag_aw_h[3] = sn4;
                        tag_aw_h[4] = sn5;
                        date_5=date1;
                        //System.out.println(Arrays.toString(tag_aw));
                    }
                    else if (t4 && (g_g.getGrade1()<=33)){

                        tag_aw_s[0] = sn1;
                        tag_aw_s[1] = sn2;
                        tag_aw_s[2] = sn3;
                        tag_aw_s[3] = sn4;
                        tag_aw_s[4] = sn5;
                        System.out.println(date1);

                        date_5=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_fs_s));
                    }
                    else if (t4 && ((g_g.getGrade1() > 33) && (g_g.getGrade1() <= 50))){

                        tag_aw_a[0] = sn1;
                        tag_aw_a[1] = sn2;
                        tag_aw_a[2] = sn3;
                        tag_aw_a[3] = sn4;
                        tag_aw_a[4] = sn5;
                        System.out.println(date1);

                        date_5=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_a));
                    }
                    else if (t4 && ((g_g.getGrade1() > 50) && (g_g.getGrade1() <= 66))){

                        tag_aw_r[0] = sn1;
                        tag_aw_r[1] = sn2;
                        tag_aw_r[2] = sn3;
                        tag_aw_r[3] = sn4;
                        tag_aw_r[4] = sn5;
                        System.out.println(date1);

                        date_5=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_r));
                    }
/////////////////////////////////////////
                    boolean t5=tags.contains("抱");
                    if (t5 && (g_g.getGrade1()>66)){
                        tag_yb_h[0] = sn1;
                        tag_yb_h[1] = sn2;
                        tag_yb_h[2] = sn3;
                        tag_yb_h[3] = sn4;
                        tag_yb_h[4] = sn5;
                        date_6=date1;
                        //System.out.println(Arrays.toString(tag_yb));
                    }
                    else if (t5 && (g_g.getGrade1()<=33)){

                        tag_yb_s[0] = sn1;
                        tag_yb_s[1] = sn2;
                        tag_yb_s[2] = sn3;
                        tag_yb_s[3] = sn4;
                        tag_yb_s[4] = sn5;
                        System.out.println(date1);

                        date_6=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_fs_s));
                    }
                    else if (t5 && ((g_g.getGrade1() > 33) && (g_g.getGrade1() <= 50))){

                        tag_yb_a[0] = sn1;
                        tag_yb_a[1] = sn2;
                        tag_yb_a[2] = sn3;
                        tag_yb_a[3] = sn4;
                        tag_yb_a[4] = sn5;
                        System.out.println(date1);

                        date_6=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_a));
                    }
                    else if (t5 && ((g_g.getGrade1() > 50) && (g_g.getGrade1() <= 66))){

                        tag_yb_r[0] = sn1;
                        tag_yb_r[1] = sn2;
                        tag_yb_r[2] = sn3;
                        tag_yb_r[3] = sn4;
                        tag_yb_r[4] = sn5;
                        System.out.println(date1);

                        date_6=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_r));
                    }
////////////////////////////////////////
                    boolean t6=tags.contains("定");
                    if (t6 && (g_g.getGrade1()>66)){
                        tag_zdj_h[0] = sn1;
                        tag_zdj_h[1] = sn2;
                        tag_zdj_h[2] = sn3;
                        tag_zdj_h[3] = sn4;
                        tag_zdj_h[4] = sn5;
                        date_7=date1;
                        //System.out.println(Arrays.toString(tag_zdj));
                    }
                    else if (t6 && (g_g.getGrade1()<=33)){

                        tag_zdj_s[0] = sn1;
                        tag_zdj_s[1] = sn2;
                        tag_zdj_s[2] = sn3;
                        tag_zdj_s[3] = sn4;
                        tag_zdj_s[4] = sn5;
                        System.out.println(date1);

                        date_7=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_fs_s));
                    }
                    else if (t6 && ((g_g.getGrade1() > 33) && (g_g.getGrade1() <= 50))){

                        tag_zdj_a[0] = sn1;
                        tag_zdj_a[1] = sn2;
                        tag_zdj_a[2] = sn3;
                        tag_zdj_a[3] = sn4;
                        tag_zdj_a[4] = sn5;
                        System.out.println(date1);

                        date_7=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_a));
                    }
                    else if (t6 && ((g_g.getGrade1() > 50) && (g_g.getGrade1() <= 66))){

                        tag_zdj_r[0] = sn1;
                        tag_zdj_r[1] = sn2;
                        tag_zdj_r[2] = sn3;
                        tag_zdj_r[3] = sn4;
                        tag_zdj_r[4] = sn5;
                        System.out.println(date1);

                        date_7=date1;
                        System.out.println(date_1);
                        //System.out.println(Arrays.toString(tag_kl_r));
                    }
 //////////////////////////////
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public DatabaseReference getRef() {
        return ref;
    }

    public String getSn1() {
        return sn1;
    }

    public void setSn1(String sn1) {
        this.sn1 = sn1;
    }

    public String getSn2() {
        return sn2;
    }

    public void setSn2(String sn2) {
        this.sn2 = sn2;
    }

    public String getSn3() {
        return sn3;
    }

    public void setSn3(String sn3) {
        this.sn3 = sn3;
    }

    public String getSn4() {
        return sn4;
    }

    public void setSn4(String sn4) {
        this.sn4 = sn4;
    }

    public String getSn5() {
        return sn5;
    }

    public void setSn5(String sn5) {
        this.sn5 = sn5;
    }

    public String[] getTag_kl_h() {
        return tag_kl_h;
    }

    public void setTag_kl_h(String[] tag_kl_h) {
        this.tag_kl_h = tag_kl_h;
    }

    public String[] getTag_kl_s() {
        return tag_kl_s;
    }

    public void setTag_kl_s(String[] tag_kl_s) {
        this.tag_kl_s = tag_kl_s;
    }

    public String[] getTag_kl_a() {
        return tag_kl_a;
    }

    public void setTag_kl_a(String[] tag_kl_a) {
        this.tag_kl_a = tag_kl_a;
    }

    public String[] getTag_kl_r() {
        return tag_kl_r;
    }

    public void setTag_kl_r(String[] tag_kl_r) {
        this.tag_kl_r = tag_kl_r;
    }

    public String[] getTag_fs_h() {
        return tag_fs_h;
    }

    public void setTag_fs_h(String[] tag_fs_h) {
        this.tag_fs_h = tag_fs_h;
    }

    public String[] getTag_fs_s() {
        return tag_fs_s;
    }

    public void setTag_fs_s(String[] tag_fs_s) {
        this.tag_fs_s = tag_fs_s;
    }

    public String[] getTag_fs_a() {
        return tag_fs_a;
    }

    public void setTag_fs_a(String[] tag_fs_a) {
        this.tag_fs_a = tag_fs_a;
    }

    public String[] getTag_fs_r() {
        return tag_fs_r;
    }

    public void setTag_fs_r(String[] tag_fs_r) {
        this.tag_fs_r = tag_fs_r;
    }

    public String[] getTag_anye_h() {
        return tag_anye_h;
    }

    public void setTag_anye_h(String[] tag_anye_h) {
        this.tag_anye_h = tag_anye_h;
    }

    public String[] getTag_anye_s() {
        return tag_anye_s;
    }

    public void setTag_anye_s(String[] tag_anye_s) {
        this.tag_anye_s = tag_anye_s;
    }

    public String[] getTag_anye_a() {
        return tag_anye_a;
    }

    public void setTag_anye_a(String[] tag_anye_a) {
        this.tag_anye_a = tag_anye_a;
    }

    public String[] getTag_anye_r() {
        return tag_anye_r;
    }

    public void setTag_anye_r(String[] tag_anye_r) {
        this.tag_anye_r = tag_anye_r;
    }

    public String[] getTag_px_h() {
        return tag_px_h;
    }

    public void setTag_px_h(String[] tag_px_h) {
        this.tag_px_h = tag_px_h;
    }

    public String[] getTag_px_s() {
        return tag_px_s;
    }

    public void setTag_px_s(String[] tag_px_s) {
        this.tag_px_s = tag_px_s;
    }

    public String[] getTag_px_a() {
        return tag_px_a;
    }

    public void setTag_px_a(String[] tag_px_a) {
        this.tag_px_a = tag_px_a;
    }

    public String[] getTag_px_r() {
        return tag_px_r;
    }

    public void setTag_px_r(String[] tag_px_r) {
        this.tag_px_r = tag_px_r;
    }

    public String[] getTag_aw_h() {
        return tag_aw_h;
    }

    public void setTag_aw_h(String[] tag_aw_h) {
        this.tag_aw_h = tag_aw_h;
    }

    public String[] getTag_aw_s() {
        return tag_aw_s;
    }

    public void setTag_aw_s(String[] tag_aw_s) {
        this.tag_aw_s = tag_aw_s;
    }

    public String[] getTag_aw_a() {
        return tag_aw_a;
    }

    public void setTag_aw_a(String[] tag_aw_a) {
        this.tag_aw_a = tag_aw_a;
    }

    public String[] getTag_aw_r() {
        return tag_aw_r;
    }

    public void setTag_aw_r(String[] tag_aw_r) {
        this.tag_aw_r = tag_aw_r;
    }

    public String[] getTag_yb_h() {
        return tag_yb_h;
    }

    public void setTag_yb_h(String[] tag_yb_h) {
        this.tag_yb_h = tag_yb_h;
    }

    public String[] getTag_yb_s() {
        return tag_yb_s;
    }

    public void setTag_yb_s(String[] tag_yb_s) {
        this.tag_yb_s = tag_yb_s;
    }

    public String[] getTag_yb_a() {
        return tag_yb_a;
    }

    public void setTag_yb_a(String[] tag_yb_a) {
        this.tag_yb_a = tag_yb_a;
    }

    public String[] getTag_yb_r() {
        return tag_yb_r;
    }

    public void setTag_yb_r(String[] tag_yb_r) {
        this.tag_yb_r = tag_yb_r;
    }

    public String[] getTag_zdj_h() {
        return tag_zdj_h;
    }

    public void setTag_zdj_h(String[] tag_zdj_h) {
        this.tag_zdj_h = tag_zdj_h;
    }

    public String[] getTag_zdj_s() {
        return tag_zdj_s;
    }

    public void setTag_zdj_s(String[] tag_zdj_s) {
        this.tag_zdj_s = tag_zdj_s;
    }

    public String[] getTag_zdj_a() {
        return tag_zdj_a;
    }

    public void setTag_zdj_a(String[] tag_zdj_a) {
        this.tag_zdj_a = tag_zdj_a;
    }

    public String[] getTag_zdj_r() {
        return tag_zdj_r;
    }

    public void setTag_zdj_r(String[] tag_zdj_r) {
        this.tag_zdj_r = tag_zdj_r;
    }

    public String getDate_1() {
        return date_1;
    }

    public void setDate_1(String date_1) {
        this.date_1 = date_1;
    }

    public String getDate_2() {
        return date_2;
    }

    public void setDate_2(String date_2) {
        this.date_2 = date_2;
    }

    public String getDate_3() {
        return date_3;
    }

    public void setDate_3(String date_3) {
        this.date_3 = date_3;
    }

    public String getDate_4() {
        return date_4;
    }

    public void setDate_4(String date_4) {
        this.date_4 = date_4;
    }

    public String getDate_5() {
        return date_5;
    }

    public void setDate_5(String date_5) {
        this.date_5 = date_5;
    }

    public String getDate_6() {
        return date_6;
    }

    public void setDate_6(String date_6) {
        this.date_6 = date_6;
    }

    public String getDate_7() {
        return date_7;
    }

    public void setDate_7(String date_7) {
        this.date_7 = date_7;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public getgrade getG_g() {
        return g_g;
    }

    public void setG_g(getgrade g_g) {
        this.g_g = g_g;
    }
}
