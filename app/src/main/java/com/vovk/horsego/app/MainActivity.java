package com.vovk.horsego.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Dima on 20.11.2015.
 */
public class MainActivity extends Activity {

    private EditText userName;
    private LinearLayout layoutMain;
   // private LinearLayout layoutUser;
    private TextView textView;
    private Button button;
    private ProgressBar bar;
    private Button btnResult;

    private int count = 0;
    ArrayList<ProgressBar> listBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        userName = (EditText) findViewById(R.id.txtUserName);
        layoutMain = (LinearLayout) findViewById(R.id.container);
       // layoutUser = (LinearLayout) findViewById(R.id.conteinerUser);
        btnResult = (Button) findViewById(R.id.btnRes);
        listBar = new ArrayList<ProgressBar>();

    }


    public void addUser(View view) {
        if (userName.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Введите имя игрока", Toast.LENGTH_SHORT).show();
        } else {
            if (count < 5) {
                count++;


                // LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // final View addview = layoutInflater.inflate(R.layout.user_layout, null);

                final View view1 = getLayoutInflater().inflate(R.layout.user_layout, null);
                textView = (TextView) view1.findViewById(R.id.txtNameActivity);
                textView.setText(userName.getText());

                textView.setId(count);
                //  textView.setText(String.valueOf(count));
                bar = (ProgressBar) view1.findViewById(R.id.prBar);
                bar.setId(count + 10);
                listBar.add(bar);
              //  textView.setText(String.valueOf(count));
                button = (Button) view1.findViewById(R.id.btnDelete);
             //   button.setId(count + 10);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) view1.getParent()).removeView(view1);
                        count--;
                        listBar.remove(bar);
                    }
                });
                //  textView = (TextView) findViewById(R.id.txtNameActivity);
//            textView.setText(userName.getText());

                layoutMain.addView(view1);
                //  textView.setText(userName.getText());


                //  final LinearLayout linear = new LinearLayout(getApplicationContext());
                //  linear.setOrientation(LinearLayout.HORIZONTAL);


//            Button button = new Button(getApplicationContext());
//            button.setText("Удалить");
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    linearLayout.removeView(linear);
//                }
//            });
//
//            TextView textView = new TextView(getApplicationContext(), null, R.style.AppTheme);
//            textView.setText(userName.getText());
//            textView.setTextColor(Color.BLACK);
//          //  textView.setId(Integer.parseInt("1"));
//
//            ProgressBar bar = new ProgressBar(this, null,
//                    android.R.attr.progressBarStyleHorizontal);
//            bar.setMax(100);
//            bar.setLayoutParams(new LinearLayout.LayoutParams(330,90));
//          //  bar.setProgress(50);
//            bar.setProgressDrawable(getResources().getDrawable(R.drawable.horizontalprogressbar));

                //  linear.addView(textView);
                //  linear.addView(bar);
                //  linear.addView(button);


                userName.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Превышено максимальное количество игроков", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void startGame(View view) {
        if (count < 2) {
            Toast.makeText(getApplicationContext(), "Добавте еще одного игрока", Toast.LENGTH_SHORT).show();
        } else {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        for (int j = 0; j < listBar.size(); j++) {
                            //   bar = (ProgressBar) findViewById(3 + 10);
                            //  bar.setProgress(i);
                            int ran = new Random().nextInt(9);
                            listBar.get(j).setProgress(listBar.get(j).getProgress() + ran);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
//            if (thread.isAlive()){
//            }
//            else btnResult.setVisibility(View.VISIBLE);
        }
    }

//    public void result (View view){
//        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
//        startActivity(intent);
//    }
}