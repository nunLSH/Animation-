package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Observable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

public class DecoratingHomeActivity extends AppCompatActivity {
    Button        btn;
    ProgressBar   progressBar;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorating_home);

        btn = findViewById(R.id.finalHomeButton);

        // 버튼에 애니메이션 주기
        Animation anim_homeBTN = AnimationUtils.loadAnimation(this, R.anim.btn_fadein_slow);
        btn.startAnimation(anim_homeBTN);

        // 프로그레스바 객체 생성
        progressBar = findViewById(R.id.progressBar);
        // 쓰레드를 사용해서 프로그래스바 게이지 차도록 만들기
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (i=0; i <=100; i++) {
                    progressBar.setProgress(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start(); // 쓰레드 시작

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DecoratingHomeActivity.this, ShowFinalHouseActivity.class);
                startActivity(intent);
            }
        });
    }
}