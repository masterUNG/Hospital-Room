package kaewmod.hospitalroom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, password1EditText, password2EditText;
    private String nameString, password1String, password2String, mainString, sexString;
    private RadioGroup mainRadioGroup, sexRadioGroup;
    private RadioButton main1RadioButton, main2RadioButton,
            maleRadioButton, femaleRadioButton;
    private static final String urlPHP = "http://swiftcodingthai.com/mod/mmmm.php";
    private String[] typeStrings = new String[]{"primary","Share"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        password1EditText = (EditText) findViewById(R.id.editText2);
        password2EditText = (EditText) findViewById(R.id.editText3);
        mainRadioGroup = (RadioGroup) findViewById(R.id.ragmain);
        sexRadioGroup = (RadioGroup) findViewById(R.id.regSex);
        main1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        main2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        maleRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        femaleRadioButton = (RadioButton) findViewById(R.id.radioButton4);

        //Create Main Radio Controller
        mainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        mainString = "0";
                        break;
                    case R.id.radioButton2:
                        mainString = "1";
                        break;
                }
            }
        });

        //Create Sex Radio Controller
        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton3:
                        sexString = "male";
                        break;
                    case R.id.radioButton4:
                        sexString = "female";
                        break;
                }
            }
        });


    }   // Main Method

    public void clickSaveData(View view) {

        nameString = nameEditText.getText().toString().trim();
        password1String = password1EditText.getText().toString().trim();
        password2String = password2EditText.getText().toString().trim();

        //Check Space
        if (checkSpace()) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Have Space", "Please fill in all fields");
        } else if (!password1String.equals(password2String)) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Passwords do not match",
                    "Please enter the password synchronization");

        } else if (!(main1RadioButton.isChecked() || main2RadioButton.isChecked())) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Please select the category", "\n" +
                    "Please select the type of user");
        } else if (!(maleRadioButton.isChecked() || femaleRadioButton.isChecked())) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "\n" +
                    "Please select gender", "Please Choose User");
        } else {

            confirmData();

        }


    }   // clickSaveData

    private void confirmData() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.tokjai);
        builder.setTitle("Make sure the information is correct.");
        builder.setMessage("Name = " + nameString + "\n" +
                "Password = " + password1String + "\n" +
                "Type = " + typeStrings[Integer.parseInt(mainString)] + "\n" +
                "Sex = " + sexString);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                uploadToServer();
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }   //

    private void uploadToServer() {

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("User", nameString)
                .add("Password", password1String)
                .add("Type", mainString)
                .add("Sex", sexString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(urlPHP).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("4SepV1", "e ==> " + e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.d("4SepV1", "Result ==> " + response.body().string());
                finish();
            }
        });

    }   // uploadToServer

    private boolean checkSpace() {
        return nameString.equals("") ||
                password1String.equals("") ||
                password2String.equals("");
    }



}   // Main Class