package com.techdecode.evevoddgamedice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_roll,b_even,b_odd;
    TextView tv_cpu,tv_you,tv_status;
    ImageView iv_dice1,iv_dice2;
    int cpupoints=0,youpoints=0;
    String currentpicks="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       b_roll=findViewById(R.id.b_roll);
        b_even=findViewById(R.id.b_even);
        b_odd=findViewById(R.id.b_odd);
        tv_cpu=findViewById(R.id.tv_cpu);
        tv_you=findViewById(R.id.tv_you);
        tv_status=findViewById(R.id.tv_status);
        iv_dice1=findViewById(R.id.iv_dice1);
        iv_dice2=findViewById(R.id.iv_dice2);
        b_roll.setVisibility(View.INVISIBLE);
        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int firstdise=random.nextInt(6)+1;
                int seconddise=random.nextInt(6)+1;
                setImage(firstdise,seconddise);
                int sum=firstdise + seconddise;
                int left = sum % 2;
                //calc the current vinner
                if(currentpicks.equals("even")){
                    if(left==0){
                        youpoints++;
                    }
                    if(left!=0){
                        cpupoints++;
                    }
                }
                if(currentpicks.equals("odd")){
                    if(left==0){
                        cpupoints++;
                    }
                    if(left!=0){
                        youpoints++;
                    }
                }
                //disply points
                tv_cpu.setText("CPU:"+cpupoints);
                tv_you.setText("YOU:"+youpoints);
                b_roll.setVisibility(View.INVISIBLE);
                b_even.setVisibility(View.VISIBLE);
                b_odd.setVisibility(View.VISIBLE);
                //animation
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                iv_dice1.startAnimation(animation);
                iv_dice2.startAnimation(animation);






            }
        });
        b_even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentpicks="even";
                tv_status.setText(currentpicks);

                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);
            }
        });
        b_odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentpicks="odd";
                tv_status.setText(currentpicks);
                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void setImage(int dice1number,int dice2number){
        //set picture for dice 1
        switch (dice1number){
            case 1:
                iv_dice1.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_dice1.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_dice1.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_dice1.setImageResource(R.drawable.dice4);
                break;

            case 5:
                iv_dice1.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_dice1.setImageResource(R.drawable.dice6);
                break;
        }
        //set picture for dice 2
        switch (dice2number) {
            case 1:
                iv_dice2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_dice2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_dice2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_dice2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv_dice2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_dice2.setImageResource(R.drawable.dice6);
                break;

        }
    }
}