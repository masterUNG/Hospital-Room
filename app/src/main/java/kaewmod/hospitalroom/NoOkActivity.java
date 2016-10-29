package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NoOkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_ok);
    }

    public void clickNoOkGosick (View view) {
        startActivity(new Intent(NoOkActivity.this,SickActivity.class));

    }
}