package com.example.tic_toc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int imageClick=-1;
    int player = 1; //player1 is cross :) :( ;) :<(  :>)
    int [][]winningStates = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{0,4,8},{2,5,8},{1,4,7},{2,4,6}};
    int []gameStates = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void load(View view) {
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        imageClick = gameStates[tag];
        if (isWinner == false && imageClick == -1){
            if (player == 1) {
                v.setImageResource(R.drawable.img_1);
                gameStates[tag] = player;
                //Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.img_2);
                gameStates[tag] = player;
                //Toast.makeText(this, tag + " " + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }

            for (int i = 0; i < winningStates.length; i++) {
                if (gameStates[winningStates[i][0]] == gameStates[winningStates[i][1]] && gameStates[winningStates[i][1]] == gameStates[winningStates[i][2]] && gameStates[winningStates[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }
        public void reset (View view)
        {
            GridLayout gridLayout = findViewById(R.id.reset);
            int total_images = gridLayout.getChildCount();
            for (int i = 0; i < total_images; i++){
                ImageView v = (ImageView) gridLayout.getChildAt(i);
                v.setImageDrawable(null);
            }
            isWinner = false;
            imageClick = -1;
            player = 1;
            for (int i = 0; i < gameStates.length; i++){
                gameStates[i] = -1;
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}