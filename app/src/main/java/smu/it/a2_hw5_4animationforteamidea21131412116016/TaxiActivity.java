package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TaxiActivity extends AppCompatActivity {
    ImageButton iBT1; // 객체 선언
    int count = 0; // 버튼 클릭 횟수에 해당하는 변수
    MediaPlayer bgm, mp1, mp2, mp3, mp4; // 배경음악, 목소리

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);

        // 객체 생성
        iBT1 = findViewById(R.id.imageButtonTaxi);
        // 배경음악과 택시 기사 목소리 넣기
        bgm = MediaPlayer.create(this, R.raw.taxi_bgm);
        mp1 = MediaPlayer.create(this, R.raw.taxi_voice1);
        mp2 = MediaPlayer.create(this, R.raw.taxi_voice2);
        mp3 = MediaPlayer.create(this, R.raw.taxi_voice3);
        mp4 = MediaPlayer.create(this, R.raw.taxi_voice4);

        bgm.start(); // 택시 장면 배경음악 재생
        mp1.start(); // 첫번째 음성 재생

        // imageView 클릭시 말풍선 변경 및 음성 변경을 위한 이벤트 리스너
        // 클릭 횟수를 변수로 설정하여 switch문으로 작성
        iBT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count) {
                    case 0:
                        iBT1.setImageResource(R.drawable.taxi2);
                        mp1.stop();
                        mp2.start();
                        count++;
                        break;
                    case 1:
                        iBT1.setImageResource(R.drawable.taxi3);
                        mp3.start();
                        count++;
                        break;
                    case 2:
                        iBT1.setImageResource(R.drawable.taxi4);
                        mp2.start();
                        count++;
                        break;
                    case 3:
                        iBT1.setImageResource(R.drawable.taxi5);
                        mp2.stop();
                        mp4.start();
                        count++;
                        break;
                    case 4:
                        iBT1.setImageResource(R.drawable.taxi6);
                        mp4.stop();
                        mp3.start();
                        count++;
                        break;
                    case 5:
                        Intent intent = new Intent(TaxiActivity.this, WelcomingActivity.class);
                        startActivity(intent);
                        mp3.stop();
                        bgm.stop();
                        break;
                }
            }
        });
    }
}