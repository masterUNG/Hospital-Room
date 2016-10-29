package kaewmod.hospitalroom;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class YogaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),
                R.raw.intro_start_horse);
        mediaPlayer.start();

        ImageView img = (ImageView) findViewById(R.id.kumlag);
        img.setBackgroundResource(R.drawable.logo_kumlag);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();

    }//Main Methon

    public void clickYoga(View view) {
        startActivity(new Intent(YogaActivity.this, HomeyogaActivity.class));
        finish();

    }

    public void clickYogaHome(View view) {
        finish();
    }
}