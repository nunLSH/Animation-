package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class EndingActivity extends AppCompatActivity {
    ImageView iv_shasha, iv_neoguri, iv_dancingboy, iv_zzuni, iv_yeoul;
    AnimationDrawable animationDrawable;
    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        iv_shasha = findViewById(R.id.dancingShasha);
        iv_neoguri = findViewById(R.id.dancingNeoguri);
        iv_dancingboy = findViewById(R.id.dancingBoy);
        iv_zzuni = findViewById(R.id.dancingZzuni);
        iv_yeoul = findViewById(R.id.dancingYeoul);

        // 배경음악 넣기
        bgm = MediaPlayer.create(this, R.raw.ending_bgm);
        bgm.start();

        animationDrawable = (AnimationDrawable) iv_shasha.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();

        animationDrawable = (AnimationDrawable) iv_neoguri.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();

        animationDrawable = (AnimationDrawable) iv_dancingboy.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();

        animationDrawable = (AnimationDrawable) iv_zzuni.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();

        animationDrawable = (AnimationDrawable) iv_yeoul.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();
    }
    // 앱 종료시 음악도 종료하는 설정
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bgm != null) {
            bgm.pause();
            bgm.release();
        }
    }
}

