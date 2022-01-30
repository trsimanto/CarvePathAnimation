package com.towhid.carvepathanimation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Slide;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.towhid.carvepathanimation.lib.ArcAnimator;
import com.towhid.carvepathanimation.lib.ArcDebugView;
import com.towhid.carvepathanimation.lib.Side;

public class MainActivity extends AppCompatActivity {

    ImageButton mElement;
    ArcDebugView mArcDebugView;
    RelativeLayout main;
    boolean up = true;
    float sX, sY, pX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mElement = (ImageButton) findViewById(R.id.circle_element);
        mArcDebugView = (ArcDebugView) findViewById(R.id.arc_debug);
        main = (RelativeLayout) findViewById(R.id.main);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                sX = mElement.getX() + (float) (mElement.getWidth() / 2);
                sY = mElement.getY() + (float) (mElement.getHeight() / 2);
                pX = main.getX() + (float) (main.getWidth() / 2);
                Log.d("ok", " sx , sy ,  px: " + sX + "  " + sY + "  " + pX);
            }
        }, 100);


        mElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if (up) {

                    ArcAnimator arcAnimator = ArcAnimator.createArcAnimator(mElement, pX, 100, Float.parseFloat("90"), Side.LEFT)
                            .setDuration(500);
                    arcAnimator.start();
                    mArcDebugView.drawArcAnimator(arcAnimator);
                    up = false;
                } else {

                    ArcAnimator arcAnimator = ArcAnimator.createArcAnimator(mElement, sX, sY, Float.parseFloat("90"), Side.LEFT)
                            .setDuration(500);
                    arcAnimator.start();
                    mArcDebugView.drawArcAnimator(arcAnimator);
                    up = true;
                }

            /*    if (up) {

                    ArcAnimator arcAnimator = ArcAnimator.createArcAnimator(mElement, sX, sY, pX, 100, Float.parseFloat("90"), Side.LEFT)
                            .setDuration(Integer.parseInt("3000"));
                    arcAnimator.start();
                    mArcDebugView.drawArcAnimator(arcAnimator);
                    up = false;
                } else {
                    ArcAnimator arcAnimator = ArcAnimator.createArcAnimator(mElement, pX, 100, sX, sY, Float.parseFloat("90"), Side.LEFT)
                            .setDuration(Integer.parseInt("3000"));
                    arcAnimator.start();
                    mArcDebugView.drawArcAnimator(arcAnimator);
                    up = true;
                }*/


            }
        });


    }

}
