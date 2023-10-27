package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startBTN;
    MediaPlayer bgm; // 음악 재생 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBTN = findViewById(R.id.startButton);
        Animation anim_start = AnimationUtils.loadAnimation(this, R.anim.btn_blink);

        // 음악 넣고 재생하기
        bgm = MediaPlayer.create(this, R.raw.start_bgm);
        bgm.start();

        startBTN.startAnimation(anim_start);

        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MovingTaxiActivity.class);
                startActivity(intent);
                bgm.stop();
            }
        });
    }
}