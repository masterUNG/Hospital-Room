package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NurseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);
    }
    public void clickNurseHead (View view) {
        startActivity(new Intent(NurseActivity.this,DiseaseheaderActivity.class));

    }
    public void clickNurseBody (View view) {
        startActivity(new Intent(NurseActivity.this,DiseasebodyActivity.class));

    }
    public void clickNurseLeg (View view) {
        startActivity(new Intent(NurseActivity.this,DiseaselegActivity.class));

    }
    public void clickNurseHomemenu (View view) {
        startActivity(new Intent(NurseActivity.this,MenuActivity.class));

    }
}
