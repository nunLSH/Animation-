package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MovingTaxiActivity extends AppCompatActivity {
    ImageView iv_taxi;
    Button    townBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_taxi);

        iv_taxi = findViewById(R.id.imageViewTaxi);
        townBTN = findViewById(R.id.townButton);

        Animation anim_taxi = AnimationUtils.loadAnimation(this, R.anim.moving);
        Animation anim_townBTN = AnimationUtils.loadAnimation(this, R.anim.btn_fadein);

        iv_taxi.startAnimation(anim_taxi);
        townBTN.startAnimation(anim_townBTN);

        townBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovingTaxiActivity.this, TaxiActivity.class);
                startActivity(intent);
            }
        });
    }
}
