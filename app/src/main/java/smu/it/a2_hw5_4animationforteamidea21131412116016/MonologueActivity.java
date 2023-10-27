package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonologueActivity extends AppCompatActivity {
    Button btn;
    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monologue);

        btn = findViewById(R.id.buttonMono);
        bgm = MediaPlayer.create(this, R.raw.mono_bgm);
        bgm.start();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonologueActivity.this, DecoratingHomeActivity.class);
                startActivity(intent);
                bgm.stop();
            }
        });
    }
}