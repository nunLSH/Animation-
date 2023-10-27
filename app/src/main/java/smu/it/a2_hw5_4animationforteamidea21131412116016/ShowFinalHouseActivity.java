package smu.it.a2_hw5_4animationforteamidea21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowFinalHouseActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_final_house);

        btn = findViewById(R.id.buttonNext);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowFinalHouseActivity.this, EndingActivity.class);
                startActivity(intent);
            }
        });
    }
}