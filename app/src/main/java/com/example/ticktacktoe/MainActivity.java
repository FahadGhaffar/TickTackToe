package com.example.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 = 0 player ,1=x player
    int playcounter = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        //counter.setTranslationY(-1000f);
        System.out.println(counter.getTag().toString());

        int teppedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[teppedCounter] == 2) {
            gameState[teppedCounter] = playcounter;
            if (playcounter == 0) {
                counter.setImageResource(R.drawable.o);
                playcounter = 1;
            } else {

                counter.setImageResource(R.drawable.x);
                playcounter = 0;
            }
            // counter.animate().translationY(1000f).setDuration(100);
            for (int[] winningPosition : winningState) {
                // System.out.println(gameState[winningPosition[0]]);
                    if(gameState[winningPosition[0]]==gameState[winningPosition[1]]&&
                        gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                      gameState[winningPosition[0]] !=2 ){

                        Toast.makeText(getApplicationContext(), String.valueOf(gameState[winningPosition[0]]), Toast.LENGTH_LONG).show();
                    }
//             Toast.makeText(getApplicationContext(), String.valueOf(gameState[winningPosition[0]])+","+String.valueOf(gameState[winningPosition[1]])+","+String.valueOf(gameState[winningPosition[2]]), Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), String.valueOf(winningPosition[0]), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}