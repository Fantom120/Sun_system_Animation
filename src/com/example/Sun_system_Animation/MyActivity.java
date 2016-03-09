package com.example.Sun_system_Animation;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.ImageView;

public class MyActivity extends Activity {

    ImageView imageSun;
    ImageView imageEarth;
    ImageView imageVenus;
    ImageView imageMars;
    ImageView imageMerc;
    ImageView imageComet;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        imageSun  = (ImageView) findViewById(R.id.imageSun);
        imageEarth  = (ImageView) findViewById(R.id.imageEarth);
        imageVenus  = (ImageView) findViewById(R.id.imageVenera);
        imageMars  = (ImageView) findViewById(R.id.imageMars);
        imageMerc  = (ImageView) findViewById(R.id.imageMerc);
        imageComet = (ImageView) findViewById(R.id.imageComet);


        if(hasFocus) {

            moveIn.run();
            venus.run();
            sun.run();

        }

    }


    Runnable moveIn = new Runnable() {

        public void run() {



       imageEarth.animate().setDuration(3000).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(500).translationY(300).scaleX(2).scaleY(2).rotationBy(720.f).withEndAction(move);
       imageMars.animate().setDuration(5000).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(800).translationY(300).scaleX(3).scaleY(3).rotationBy(500.f).withEndAction(move);

            }
    };
    Runnable move = new Runnable() {

        public void run() {


            imageEarth.animate().setDuration(2000).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(-200).translationY(500).scaleX(0).scaleY(0).rotationBy(720.f).withEndAction(running);
            imageMars.animate().setDuration(3000).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(-200).translationY(400).scaleY(5).scaleX(5).rotationBy(500.f).withEndAction(running);

        }
    };
    Runnable running = new Runnable() {

        public void run() {
            imageEarth.animate().setDuration(5).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(100).translationY(100).scaleX(0).scaleY(0).rotationBy(720.f).withEndAction(moveIn);
            imageMars.animate().setDuration(5).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(0).translationY(0).scaleX(0).scaleY(0).rotationBy(720.f).withEndAction(moveIn);


        }

    };
    Runnable venus = new Runnable() {

        public void run() {
            imageVenus.animate().setDuration(1500).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(200).translationY(300).scaleY(1.5f).scaleX(1.5f).rotationBy(1000.f).withEndAction(getVenus);
            imageMerc.animate().setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).translationY(100).translationX(200).scaleY(1).scaleX(1).rotationBy(1500.f).withEndAction(getVenus);
        }
    };
    Runnable getVenus = new Runnable() {

        public void run() {
            imageVenus.animate().setDuration(1500).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(150).translationY(300).scaleY(0).scaleX(0).rotationBy(1000.f).withEndAction(venusRun);
            imageMerc.animate().setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).scaleX(0).scaleY(0).rotationBy(1000.f).withEndAction(venusRun);
        }
    };
    Runnable venusRun = new Runnable() {

        public void run() {
        imageVenus.animate().setDuration(5).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(0).translationY(100).scaleX(0).scaleY(0).withEndAction(venus);
            imageMerc.animate().setDuration(5).setInterpolator(new AccelerateDecelerateInterpolator()).translationX(0).translationY(100).withEndAction(venus);

        }
    };

    Runnable sun = new Runnable() {

        public void run() {
            imageComet.animate().setDuration(3000).setInterpolator(new AccelerateInterpolator()).translationX(600).translationY(600).scaleX(2).scaleY(2).alpha(0);
            TransitionDrawable transition = (TransitionDrawable) getResources().getDrawable(R.drawable.shape_transiton);
            transition.setCrossFadeEnabled(true);
            ((ImageView) findViewById(R.id.imageSun)).setImageDrawable(transition);
             imageSun.animate().setDuration(20000).rotationBy(150);
            transition.startTransition(20000);


        }
    };






}





