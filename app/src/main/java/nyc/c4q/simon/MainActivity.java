package nyc.c4q.simon;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Chronometer time;
    private Button quit;
    private Button playAgain;
    private FrameLayout options;
    private Animation buttonAnimation;
    public String userinput = "";
    public Button opp;
    public Button one;
    public Button two;
    public Button three;
    public Button four;
    Random rand = new Random();
    final Animation animation = new AlphaAnimation(0.0f, 10f);
    final Animation animation2 = new AlphaAnimation(0.0f, 10f);
    final Handler handler = new Handler();
    String keepingtrack = "";
    String holduser = "";
    int level = 1;
    char lvlnotice = '1';

    private final String TAG = getClass().getSimpleName();

    // /randomColor.brighter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chronometer time = findViewById(R.id.time);
        create();

        start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                action();
            }
        }, 10000);

        winOrLoose();





        options = (FrameLayout) findViewById(R.id.options);
        playAgain = (Button) findViewById(R.id.playAganing);
        quit = (Button) findViewById(R.id.quit);


//        options.setVisibility(View.VISIBLE);


        opp = (Button) findViewById(R.id.op);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        opp.setBackgroundColor(Color.GRAY);

        opp.setText(opp.getText().toString().replace('6', lvlnotice));

    }

    public String create() {

        String creep = "";

        for (int i = 0; i < level; i++) {
            creep += (rand.nextInt(4) + 1);
        }


        keepingtrack = creep;

        return keepingtrack;
    }


    public void action() {

//        opp.setText(opp.getText().toString().replace('6', '7'));


//        String test = "43211234";
        Log.e(TAG, "KeepingTreack is :" + keepingtrack);

        int count = 1;

        for (int i = 0; i < keepingtrack.length(); i++) {


            switch (keepingtrack.charAt(i)) {

                case '1':
                    button1(count);
                    count++;
                    break;
                case '2':
                    button2(count);
                    count++;
                    break;
                case '3':
                    button3(count);
                    count++;
                    break;
                case '4':
                    button4(count);
                    count++;
                    break;
                default:
                    break;
            }
        }
    }


    public void button1(int a) {

        animation2.setDuration(200);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                one.startAnimation(animation2);
            }
        }, 1000 * a);


    }

    public void button2(int a) {
        animation2.setDuration(200);
//        two.setBackgroundColor(Color.GRAY);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                two.startAnimation(animation2);
            }
        }, 1000 * a);
    }

    public void button3(int a) {
        animation2.setDuration(1000);
//        three.setBackgroundColor(Color.GRAY);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                three.startAnimation(animation2);
            }
        }, 1000 * a);
    }

    public void button4(int a) {
        animation2.setDuration(200);
//        four.setBackgroundColor(Color.GRAY);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                four.startAnimation(animation2);
            }
        }, 1000 * a);
    }


    public void capture(View v) {
        Animation animation1 = new AlphaAnimation(0.0f, 10f);
        animation1.setDuration(200);

        int tracking = 0;


        switch (v.getTag().toString()) {

            case "1":
                one.startAnimation(animation1);
                holduser += "1";

                break;
            case "2":
                two.startAnimation(animation1);
                holduser += "2";
                break;
            case "3":
                three.startAnimation(animation1);
                holduser += "3";
                break;
            case "4":
                four.startAnimation(animation1);
                holduser += "4";
                break;
        }

        if (tracking == keepingtrack.length()) {
               if (holduser.equals(keepingtrack)) {
                level += 1;
                Log.e(TAG, "The player has won :" + holduser + " " + keepingtrack);
                }
            {
                Log.e(TAG, "The player has Lost:" + holduser + " " + keepingtrack);
            }
        }

    }

    public void start() {


        animation.setDuration(999);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                one.startAnimation(animation);
            }
        }, 1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                two.startAnimation(animation);

            }
        }, 2500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                three.startAnimation(animation);

            }
        }, 4000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                four.startAnimation(animation);
            }
        }, 5500);

        Toast.makeText(getApplicationContext(), "Do what Simon Says:", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "Follow the Pattern of lights and sounds for as long as you can…..if you can!", Toast.LENGTH_LONG).show();
    }


    public void winOrLoose() {
        if (holduser.equals(keepingtrack)) {
            level += 1;
            Log.e(TAG, "The player has won :" + holduser + " " + keepingtrack);
        }
        {
            Log.e(TAG, "The player has Lost:" + holduser + " " + keepingtrack);
        }


    }


}


//        color.put(1,Color.RED);
//        color.put(2,Color.BLUE);
//        color.put(3,Color.YELLOW);
//        color.put(4,Color.GREEN);
//
//        int level =1;
//
//        for(int i=0;i<level;i++){
//            key.add(rand.nextInt(4) + 1);
//        }
//
//
//        Collections.shuffle(key);
//
//
//        one.setBackgroundColor(Color.RED);
//        two.setBackgroundColor(Color.BLUE);
//        three.setBackgroundColor(Color.YELLOW);
//        four.setBackgroundColor(Color.GREEN);
//
//
//        animation.setDuration(2000);
//
//        Collections.shuffle(key);
//
//
//
//        int level =10;
//        for(int i=0;i<level;i++){
//            key.add(rand.nextInt(4) + 1);
//        }

//        Animation animation = new AlphaAnimation(0.2f, 1f);
//        animation.setDuration(2000);
//        one.startAnimation(animation);
//
//        int n = 0;
//        while (n < 7) {
//            int random = color.get(rand.nextInt(4) + 1);
//            one.setBackgroundColor(random);
//            two.setBackgroundColor(color.get(rand.nextInt(4) + 1));
//            three.setBackgroundColor(color.get(rand.nextInt(4) + 1));
//            four.setBackgroundColor(color.get(rand.nextInt(4) + 1));
//
//            Log.d(TAG, "onCreate: " + random);
//
//
//    private void createButtonAnimation() {
//
////        Animation animation = new AlphaAnimation(0.2f, 1f);
////        animation.setDuration(1000);
//
////        buttonAnimation = new AlphaAnimation(0.2f, 1f);
////        buttonAnimation.setDuration(500);
//    }


