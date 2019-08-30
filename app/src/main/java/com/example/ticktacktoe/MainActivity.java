package com.example.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean activeplayer=true;
    // 0 = 0 player ,1=x player
    int playcounter = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        //counter.setTranslationY(-1000f);
        System.out.println(counter.getTag().toString());
        //Toast.makeText(getApplicationContext(),String.valueOf(counter.getTag().toString()),Toast.LENGTH_LONG).show();
        int teppedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[teppedCounter] == 2 && activeplayer)  {
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
                        activeplayer=false;
                        TextView text=(TextView) findViewById(R.id.PlayAgaintextView);
                        text.setText(String.valueOf(gameState[winningPosition[0]]));
                       // Toast.makeText(getApplicationContext(), String.valueOf(gameState[winningPosition[0]]), Toast.LENGTH_LONG).show();
                        LinearLayout layout=(LinearLayout) findViewById(R.id.playAgainLayout);

                        layout.setVisibility(View.VISIBLE);

                    } else{
                        boolean gameover=true;
                        for (int counterover : gameState){
                            if (counterover==2) gameover=false;
                        }
                        if(gameover){

                            TextView text=(TextView) findViewById(R.id.PlayAgaintextView);
                            text.setText("Draw");
                            // Toast.makeText(getApplicationContext(), String.valueOf(gameState[winningPosition[0]]), Toast.LENGTH_LONG).show();
                            LinearLayout layout=(LinearLayout) findViewById(R.id.playAgainLayout);

                            layout.setVisibility(View.VISIBLE);

                        }


                    }
//             Toast.makeText(getApplicationContext(), String.valueOf(gameState[winningPosition[0]])+","+String.valueOf(gameState[winningPosition[1]])+","+String.valueOf(gameState[winningPosition[2]]), Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), String.valueOf(winningPosition[0]), Toast.LENGTH_LONG).show();
            }
        }
    }
    public void PlayAgain(View view){
        activeplayer =true;
 //  Toast.makeText(getApplicationContext(),"good",Toast.LENGTH_LONG).show();
       playcounter = 0;
        // gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
         for (int i=0; i<gameState.length ;i++){

            gameState[i]=2;
        }
        LinearLayout layouts=(LinearLayout) findViewById(R.id.playAgainLayout);

       layouts.setVisibility(View.INVISIBLE);
        androidx.gridlayout.widget.GridLayout grid = (androidx.gridlayout.widget.GridLayout)findViewById(R.id.GridLayoutId);
  //    GridLayout gridLayouts=(GridLayout) findViewById(R.id.GridLayoutId);
      Log.i("gridlayoutcheck", String.valueOf(grid.getChildCount()));
      for (int i=0 ;i<grid.getChildCount();i++){


        ((ImageView) grid.getChildAt(i)).setImageResource(0);
      }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}