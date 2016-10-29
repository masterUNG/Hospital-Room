package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void clickMenuBody (View view) {
        startActivity(new Intent(MenuActivity.this,NurseActivity.class));

    }

    public void clickMenuSave (View view) {
        startActivity(new Intent(MenuActivity.this,NoOkActivity.class));

    }

    public void clickMenuMadchin (View view) {
        startActivity(new Intent(MenuActivity.this,DrugsaveActivity.class));

    }

    public void clickMenuYoga (View view) {
        startActivity(new Intent(MenuActivity.this,YogaActivity.class));

    }
}


