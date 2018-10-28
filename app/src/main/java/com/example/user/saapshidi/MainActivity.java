package com.example.user.saapshidi;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout startPage;
    RelativeLayout gamePage;
    RelativeLayout endPage;

    int redPlace = 1;
    int greenPlace = 1;
    int yellowPlace = 1;
    int bluePlace = 1;
    int max;
    float firstMove = 0f;
    float secondMove = 0f;
    float thirdMove = 0f;


    int run;
    int place;
    int chance = 0;
    int firstWinner = 5;
    int secondWinner = 5;
    int thirdWinner = 5;
    int fourthWinner = 5;

    float movex;
    float movey;
    float moveH;
    float moveV;

    Boolean gameActive = true;

    ImageView redImage;
    ImageView greenImage;
    ImageView yellowImage;
    ImageView blueImage;
    ImageView dice;


    ImageView boardImg;
    
    ImageView img;
    ImageView chanceImg;

    TextView chanceText;
    TextView firstPlace;
    TextView secondPlace;
    TextView thirdPlace;
    TextView fourthPlace;

    public void changeUser()
    {

        switch (chance) {

            case 0: {
                redPlace = place;
                break;
            }
            case 1: {
                greenPlace = place;
                break;
            }
            case 2: {
                yellowPlace = place;
                break;
            }
            case 3: {
                bluePlace = place;
                break;
            }
        }

        if (place == 100)
        {
            if(firstWinner<5 && secondWinner<5)
            {
                gameActive = false;
                thirdWinner = chance;
                switch (thirdWinner)
                {
                    case 0: {
                        thirdPlace.setText("3) Red ");
                        thirdPlace.setTextColor(Color.parseColor("#FF4444"));
                        break;
                    }
                    case 1: {
                        thirdPlace.setText("3) Green ");
                        thirdPlace.setTextColor(Color.parseColor("#00FF00"));
                        break;
                    }
                    case 2: {
                        thirdPlace.setText("3) Yellow ");
                        thirdPlace.setTextColor(Color.parseColor("#FFFF00"));
                        break;
                    }
                    case 3: {
                        thirdPlace.setText("3) Blue ");
                        thirdPlace.setTextColor(Color.parseColor("#002AFF"));
                        break;
                    }
                }

                if(firstWinner==0)
                {
                    firstPlace.setText("1) Red ");
                    firstPlace.setTextColor(Color.parseColor("#FF4444"));
                    if(secondWinner==1)
                    {
                        secondPlace.setText("2) Green ");
                        secondPlace.setTextColor(Color.parseColor("#00FF00"));
                    }
                    else if(secondWinner==2)
                    {
                        secondPlace.setText("2) Yellow ");
                        secondPlace.setTextColor(Color.parseColor("#FFFF00"));
                    }
                    else if(secondWinner==3)
                    {
                        secondPlace.setText("2) Blue ");
                        secondPlace.setTextColor(Color.parseColor("#002AFF"));
                    }
                }
                else if(firstWinner==1)
                {
                    firstPlace.setText("1) Green ");
                    firstPlace.setTextColor(Color.parseColor("#00FF00"));
                    if(secondWinner==0)
                    {
                        secondPlace.setText("2) Red ");
                        secondPlace.setTextColor(Color.parseColor("#FF4444"));
                    }
                    else if(secondWinner==2)
                    {
                        secondPlace.setText("2) Yellow ");
                        secondPlace.setTextColor(Color.parseColor("#FFFF00"));
                    }
                    else if(secondWinner==3)
                    {
                        secondPlace.setText("2) Blue ");
                        secondPlace.setTextColor(Color.parseColor("#002AFF"));
                    }
                }
                else if(firstWinner==2)
                {
                    firstPlace.setText("1) Yellow ");
                    firstPlace.setTextColor(Color.parseColor("#FFFF00"));
                    if(secondWinner==0)
                    {
                        secondPlace.setText("2) Red ");
                        secondPlace.setTextColor(Color.parseColor("#FF4444"));
                    }
                    else if(secondWinner==1)
                    {
                        secondPlace.setText("2) Green ");
                        secondPlace.setTextColor(Color.parseColor("#00FF00"));
                    }
                    else if(secondWinner==3)
                    {
                        secondPlace.setText("2) Blue ");
                        secondPlace.setTextColor(Color.parseColor("#002AFF"));
                    }
                }
                else if(firstWinner==3)
                {
                    firstPlace.setText("1) Blue ");
                    firstPlace.setTextColor(Color.parseColor("#002AFF"));
                    if(secondWinner==0)
                    {
                        secondPlace.setText("2) Red ");
                        secondPlace.setTextColor(Color.parseColor("#FF4444"));
                    }
                    else if(secondWinner==1)
                    {
                        secondPlace.setText("2) Green ");
                        secondPlace.setTextColor(Color.parseColor("#00FF00"));
                    }
                    else if(secondWinner==2)
                    {
                        secondPlace.setText("2) Yellow ");
                        secondPlace.setTextColor(Color.parseColor("#FFFF00"));
                    }
                }
                if(max>2)
                {
                    thirdPlace.setText(" ");
                    if(max>3)
                        fourthPlace.setText(" ");
                }
                startPage.setVisibility(View.INVISIBLE);
                gamePage.setVisibility(View.INVISIBLE);
                endPage.setVisibility(View.VISIBLE);

                this.recreate();
            }
            else if(firstWinner<5)
                secondWinner = chance;
            else
                firstWinner = chance;
        }


        if(firstWinner==0)
        {
            if(secondWinner==1)
            {
                if (chance == 2) chance = 3;
                else if (chance == 3) chance = 2;
            }
            else if(secondWinner==2)
            {
                if (chance == 1) chance = 3;
                else if (chance == 3) chance = 1;
            }
            else if(secondWinner==3)
            {
                if (chance == 1) chance = 2;
                else if (chance == 2) chance = 1;
            }
            else
            {
                chance++;
                if (chance == max) chance = 1;
            }
        }
        else if(firstWinner==1)
        {
            if(secondWinner==0)
            {
                if (chance == 2) chance = 3;
                else if (chance == 3) chance = 2;
            }
            else if(secondWinner==2)
            {
                if (chance == 0) chance = 3;
                else if (chance == 3) chance = 0;
            }
            else if(secondWinner==3)
            {
                if (chance == 0) chance = 2;
                else if (chance == 2) chance = 0;
            }
            else
            {
                chance++;
                if (chance == 1) chance = 2;
                else if (chance == max) chance = 0;
            }
        }
        else if(firstWinner==2)
        {
            if(secondWinner==0)
            {
                if (chance == 1) chance = 3;
                else if (chance == 3) chance = 1;
            }
            else if(secondWinner==1)
            {
                if (chance == 0) chance = 3;
                else if (chance == 3) chance = 0;
            }
            else if(secondWinner==3)
            {
                if (chance == 1) chance = 0;
                else if (chance == 0) chance = 1;
            }
            else
            {
                chance++;
                if (chance == 2) chance = 3;
                else if (chance == max) chance = 0;
            }
        }
        else if(firstWinner==3)
        {
            if(secondWinner==0)
            {
                if (chance == 1) chance = 2;
                else if (chance == 2) chance = 1;
            }
            else if(secondWinner==1)
            {
                if (chance == 0) chance = 2;
                else if (chance == 2) chance = 0;
            }
            else if(secondWinner==2)
            {
                if (chance == 1) chance = 0;
                else if (chance == 0) chance = 1;
            }
            else
            {
                chance++;
                if (chance == 3) chance = 0;
            }
        }
        else {
            chance++;
            if (chance == max) chance = 0;
        }

        
        switch (chance)
        {
            case 0: {
                chanceText.setText("Red Play!");
                chanceText.setTextColor(Color.parseColor("#FF4444"));
                chanceImg.setImageResource(R.drawable.red);

                fourthPlace.setText("4) Red ");
                fourthPlace.setTextColor(Color.parseColor("#FF4444"));
                break;
            }
            case 1: {
                chanceText.setText("Green Play!");
                chanceText.setTextColor(Color.parseColor("#00FF00"));
                chanceImg.setImageResource(R.drawable.green);

                fourthPlace.setText("4) Green ");
                fourthPlace.setTextColor(Color.parseColor("#00FF00"));
                break;
            }
            case 2: {
                chanceText.setText("Yellow Play!");
                chanceText.setTextColor(Color.parseColor("#FFFF00"));
                chanceImg.setImageResource(R.drawable.yellow);

                fourthPlace.setText("4) Yellow");
                fourthPlace.setTextColor(Color.parseColor("#FFFF00"));
                break;
            }
            case 3: {
                chanceText.setText("Blue Play!");
                chanceText.setTextColor(Color.parseColor("#002AFF"));
                chanceImg.setImageResource(R.drawable.blue);

                fourthPlace.setText("4) Blue ");
                fourthPlace.setTextColor(Color.parseColor("#002AFF"));
                break;
            }
        }

        dice.setClickable(true);
        return;
    }

    public void checkSnake()
    {
        switch (place){
            case 17:
            {
                place = 7;
                img.animate().translationXBy(moveH).translationYBy(moveV).setDuration((long) Math.abs(300*moveH/128)).withEndAction
                        (
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        img.animate().translationXBy(2*moveH).setDuration((long) Math.abs(300*2*moveH/128));
                                    }
                                }
                        );
                break;
            }
            case 64:
            {
                place = 60;
                img.animate().translationXBy(-1*moveH).translationYBy(moveV).setDuration((long) Math.abs(300*moveH/128)).withEndAction
                        (
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        img.animate().translationXBy(-2*moveH).setDuration((long) Math.abs(300*2*moveH/128));
                                    }
                                }
                        );
                break;
            }
            case 89:
            {
                place = 26;
                img.animate().translationXBy(-1*moveH).translationYBy(moveV).setDuration((long) Math.abs(300*moveH/128)).withEndAction
                        (
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        img.animate().translationXBy(moveH).translationYBy(moveV).setDuration((long) Math.abs(300*moveV/128)).withEndAction(
                                                new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        img.animate().translationXBy(-2*moveH).translationYBy(moveV).setDuration((long) Math.abs(300*moveH/128)).withEndAction
                                                                (
                                                                        new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                img.animate().translationYBy(2*moveV).setDuration((long) Math.abs(300*2*moveV/128)).withEndAction(
                                                                                        new Runnable() {
                                                                                            @Override
                                                                                            public void run() {
                                                                                                img.animate().translationXBy(-1*moveH).translationYBy(moveV).setDuration((long) Math.abs(300*moveH/128));
                                                                                            }
                                                                                        }
                                                                                );
                                                                            }
                                                                        }
                                                                );
                                                    }
                                                }
                                        );
                                    }
                                }
                        );
                break;
            }
            case 95:
            {
                place = 73;
                img.animate().translationXBy(-1*moveH).setDuration((long) Math.abs(300*moveH/128)).withEndAction
                        (
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        img.animate().translationYBy(moveV).setDuration((long) Math.abs(300*moveV/128)).withEndAction(
                                                new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        img.animate().translationXBy(moveH).setDuration((long) Math.abs(300*moveH/128)).withEndAction
                                                                (
                                                                        new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                img.animate().translationYBy(moveV).setDuration((long) Math.abs(300*moveV/128));

                                                                            }
                                                                        }
                                                                );
                                                    }
                                                }
                                        );
                                    }
                                }
                        );
                break;
            }
            case 99:
            {
                place = 78;
                img.animate().translationXBy(moveH).setDuration((long) Math.abs(300*moveH/128)).withEndAction
                        (
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        img.animate().translationYBy(2*moveV).setDuration((long) Math.abs(300*2*moveV/128));
                                    }
                                }
                        );
                break;
            }
        }
        return;
    }

    public void checkLadder()
    {
        switch (place){
            case 4:
            {
                place = 14;
                img.animate().translationXBy(moveH*3).translationYBy(moveV*-1).setDuration((long) Math.abs(300*3*moveH/128));
                break;
            }
            case 9:
            {
                place = 31;
                img.animate().translationXBy(moveH*1).translationYBy(moveV*-3).setDuration((long) Math.abs(300*3*moveV/128));
                break;
            }
            case 20:
            {
                place = 38;
                img.animate().translationXBy(moveH*2).translationYBy(moveV*-2).setDuration((long) Math.abs(300*2*moveH/128));
                break;
            }
            case 28:
            {
                place = 84;
                img.animate().translationXBy(moveH*-4).translationYBy(moveV*-6).setDuration((long) Math.abs(300*6*moveV/128));
                break;
            }
            case 40:
            {
                place = 59;
                img.animate().translationXBy(moveH*1).translationYBy(moveV*-2).setDuration((long) Math.abs(300*2*moveV/128));
                break;
            }
            case 51:
            {
                place = 67;
                img.animate().translationXBy(moveH*-3).translationYBy(moveV*-1).setDuration((long) Math.abs(300*3*moveH/128));
                break;
            }
            case 63:
            {
                place = 81;
                img.animate().translationXBy(moveH*-2).translationYBy(moveV*-2).setDuration((long) Math.abs(300*2*moveH/128));
                break;
            }
        }
        return;
    }

    public void play(View view)
    {

        dice.setClickable(false);
        moveH = (float) ( boardImg.getWidth() * 79.5 / 900 );
        moveV = (float) ( boardImg.getHeight() * 72.25 / 900 );

        System.out.println("Board dim: "+boardImg.getWidth()+" , "+boardImg.getHeight());

        if(gameActive)
        {
            Random rand = new Random();
            run = rand.nextInt(6) + 1;
            System.out.println("Run: " + run);

            switch (run) {
                case 1: {
                    dice.setImageResource(R.drawable.dice1);
                    break;
                }
                case 2: {
                    dice.setImageResource(R.drawable.dice2);
                    break;
                }
                case 3: {
                    dice.setImageResource(R.drawable.dice3);
                    break;
                }
                case 4: {
                    dice.setImageResource(R.drawable.dice4);
                    break;
                }
                case 5: {
                    dice.setImageResource(R.drawable.dice5);
                    break;
                }
                case 6: {
                    dice.setImageResource(R.drawable.dice6);
                    break;
                }
            }


            switch (chance) {
                case 0: {
                    img = redImage;
                    place = redPlace;
                    break;
                }
                case 1: {
                    img = greenImage;
                    place = greenPlace;
                    break;
                }
                case 2: {
                    img = yellowImage;
                    place = yellowPlace;
                    break;
                }
                case 3: {
                    img = blueImage;
                    place = bluePlace;
                    break;
                }
            }

            firstMove = 0f;
            secondMove = 0f;
            thirdMove = 0f;

            if ((place + run) <= 100)
            {
                movex = 0;
                movey = 0;
                int start = place;

                if (start % 10 == 0) {
                    movey = movey - moveH;
                    place++;
                    run--;
                    firstMove = movey;
                }

                if (place < 10 || (place > 20 && place < 30) || (place > 40 && place < 50) || (place > 60 && place < 70) || (place > 80 && place < 90)) {
                    while (run > 0) {
                        movex = movex + moveH;
                        place++;
                        run--;

                        if (start % 10 == 0)
                            secondMove = movex;
                        else
                            firstMove = movex;

                        if (place == 10 || place == 30 || place == 50 || place == 70 || place == 90)
                            break;
                    }

                    if (run > 0) {
                        movey = movey - moveV;
                        place++;
                        run--;
                        secondMove = movey;
                    }

                    movex = 0;
                    while (run > 0) {
                        movex = movex - moveH;
                        place++;
                        run--;
                        thirdMove = movex;
                    }
                } else if ((place > 10 && place < 20) || (place > 30 && place < 40) || (place > 50 && place < 60) || (place > 70 && place < 80) || place > 90) {
                    while (run > 0) {
                        movex = movex - moveH;
                        place++;
                        run--;

                        if (start % 10 == 0)
                            secondMove = movex;
                        else
                            firstMove = movex;

                        if (place == 20 || place == 40 || place == 60 || place == 80 || place == 100)
                            break;

                    }
                    if (run > 0) {
                        movey = movey - moveV;
                        place++;
                        run--;
                        secondMove = movey;
                    }

                    movex = 0;
                    while (run > 0) {
                        movex = movex + moveH;
                        place++;
                        run--;
                        thirdMove = movex;
                    }


                }
                if (start % 10 == 0) {
                    img.animate().translationYBy(firstMove).setDuration((long) Math.abs(300 * firstMove / 128)).withEndAction(
                            new Runnable() {
                                @Override
                                public void run() {
                                    img.animate().translationXBy(secondMove).setDuration((long) Math.abs(300 * secondMove / 128)).withEndAction
                                            (
                                                    new Runnable() {
                                                        @Override
                                                        public void run() {

                                                            if ((place == 17) || (place == 64) || (place == 89) || (place == 95) || (place == 99))
                                                                checkSnake();
                                                            else if ((place == 4) || (place == 9) || (place == 20) || (place == 28) || (place == 40) || (place == 51) || (place == 63))
                                                                checkLadder();

                                                            changeUser();
                                                        }
                                                    }
                                            );
                                }
                            }
                    );
                } else {

                    img.animate().translationXBy(firstMove).setDuration((long) Math.abs(300 * firstMove / 128)).withEndAction
                            (
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            img.animate().translationYBy(secondMove).setDuration((long) Math.abs(300 * secondMove / 128)).withEndAction(
                                                    new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            img.animate().translationXBy(thirdMove).setDuration((long) Math.abs(300 * thirdMove / 128)).withEndAction
                                                                    (
                                                                            new Runnable() {
                                                                                @Override
                                                                                public void run() {

                                                                                    if ((place == 17) || (place == 64) || (place == 89) || (place == 95) || (place == 99))
                                                                                        checkSnake();
                                                                                    else if ((place == 4) || (place == 9) || (place == 20) || (place == 28) || (place == 40) || (place == 51) || (place == 63))
                                                                                        checkLadder();

                                                                                    changeUser();
                                                                                }
                                                                            }
                                                                    );
                                                        }
                                                    }
                                            );
                                        }
                                    }
                            );


                }
            } else {
                changeUser();
            }


        }

        }

    public void start(View view)
    {

        max = Integer.parseInt(view.getTag().toString());
        if (max == 2) {
            yellowImage.setVisibility(View.INVISIBLE);
            blueImage.setVisibility(View.INVISIBLE);
        } else if (max == 3) {
            blueImage.setVisibility(View.INVISIBLE);
        }
        startPage.setVisibility(View.INVISIBLE);
        gamePage.setVisibility(View.VISIBLE);

    }

    public void restart(View view)
    {
        startPage.setVisibility(View.VISIBLE);
        gamePage.setVisibility(View.INVISIBLE);
        endPage.setVisibility(View.INVISIBLE);
        this.recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPage = (RelativeLayout) findViewById(R.id.StartPage);
        gamePage = (RelativeLayout) findViewById(R.id.GamePage);
        endPage = (RelativeLayout) findViewById(R.id.EndPage);

        redImage = (ImageView) findViewById(R.id.red);
        greenImage = (ImageView) findViewById(R.id.green);
        yellowImage = (ImageView) findViewById(R.id.yellow);
        blueImage = (ImageView) findViewById(R.id.blue);

        dice = (ImageView) findViewById(R.id.dice);

        chanceText = (TextView) findViewById(R.id.chanceText);

        firstPlace = (TextView) findViewById(R.id.firstPlace);
        secondPlace = (TextView) findViewById(R.id.secondPlace);
        thirdPlace = (TextView) findViewById(R.id.thirdPlace);
        fourthPlace = (TextView) findViewById(R.id.fourthPlace);

        chanceImg = (ImageView) findViewById(R.id.chanceImg);

        boardImg = (ImageView) findViewById(R.id.board);
    }
}
