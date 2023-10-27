package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WelcomingActivity extends AppCompatActivity {
    ImageButton iBT;
    int count = 0; // 버튼 클릭 횟수에 해당하는 변수
    MediaPlayer bgm, mp1, mp2, mp3, mp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcoming);

        // 객체 생성
        iBT = findViewById(R.id.imageButtonWelcome);
        // 배경음악과 음성 넣기
        bgm = MediaPlayer.create(this, R.raw.welcome_bgm);
        mp1 = MediaPlayer.create(this, R.raw.welcome_voice1);
        mp2 = MediaPlayer.create(this, R.raw.welcome_voice2);
        mp3 = MediaPlayer.create(this, R.raw.welcome_voice3);
        mp4 = MediaPlayer.create(this, R.raw.welcome_voice4);
        bgm.start();
        mp1.start();

        // imageView 클릭시 말풍선 변경을 위한 이벤트 리스너
        // 클릭 횟수를 변수로 설정하여 switch문으로 작성
        iBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count) {
                    case 0:
                        iBT.setImageResource(R.drawable.welcome2);
                        mp1.stop();
                        mp2.start();
                        count++;
                        break;
                    case 1:
                        iBT.setImageResource(R.drawable.welcome3);
                        mp2.stop();
                        mp3.start();
                        count++;
                        break;
                    case 2:
                        iBT.setImageResource(R.drawable.welcome4);
                        mp3.stop();
                        mp4.start();
                        count++;
                        break;
                    case 3:
                        Intent intent = new Intent(WelcomingActivity.this, LoadingHomeActivity.class);
                        startActivity(intent);
                        mp4.stop();
                        bgm.stop();
                        break;
                }
            }
        });
    }
}