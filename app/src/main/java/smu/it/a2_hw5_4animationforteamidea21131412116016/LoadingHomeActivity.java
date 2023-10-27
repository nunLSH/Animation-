package smu.it.a2_hw5_4animationforteamidea21131412116016;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingHomeActivity extends AppCompatActivity {
    ImageView           iv_cocoaSide, iv_yeoulSide, iv_appleSide;
    Button              homeBTN;
    AnimationDrawable   animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_home);

        iv_cocoaSide = findViewById(R.id.imageViewCocoaSide);
        iv_appleSide = findViewById(R.id.imageViewAppleSide);
        iv_yeoulSide = findViewById(R.id.imageViewYeoulSide);
        homeBTN = findViewById(R.id.finalHomeButton);

        Animation anim_cocoa = AnimationUtils.loadAnimation(this, R.anim.moving);
        Animation anim_apple = AnimationUtils.loadAnimation(this, R.anim.moving);
        Animation anim_yeoul = AnimationUtils.loadAnimation(this, R.anim.moving);
        Animation anim_homeBTN = AnimationUtils.loadAnimation(this, R.anim.btn_fadein);

        iv_appleSide.startAnimation(anim_apple);
        iv_cocoaSide.startAnimation(anim_cocoa);
        iv_yeoulSide.startAnimation(anim_yeoul);
        homeBTN.startAnimation(anim_homeBTN);

        animationDrawable = (AnimationDrawable)iv_appleSide.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();

        animationDrawable = (AnimationDrawable)iv_yeoulSide.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();

        animationDrawable = (AnimationDrawable)iv_cocoaSide.getBackground();
        animationDrawable.setVisible(true, true);
        animationDrawable.start();

        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoadingHomeActivity.this, MonologueActivity.class);
                startActivity(intent);
            }
        });
    }
}