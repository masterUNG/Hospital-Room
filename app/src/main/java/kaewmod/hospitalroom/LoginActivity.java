package kaewmod.hospitalroom;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText,passwordEditText;
    private String userString,passwordString, truePasswordString;
    private String[]strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bind Widget
        userEditText = (EditText)findViewById(R.id.editText4);
        passwordEditText = (EditText)findViewById(R.id.editText19);



    }//Main Methop



    public void  clickMyLoginmenu (View view) {

        userString = userEditText.getText().toString().trim();
        passwordString= passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Have Space",
            "please fill All Every Blank");
        } else {
            //Authentication User/Password
            AuthenUser authenUser = new AuthenUser(this);
            authenUser.execute();


        }



    } //clickMyLogin

    private class AuthenUser extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private static final String urlSON = "http://swiftcodingthai.com/mod/php_get_data.php";
        private boolean aBoolean = true;

        public AuthenUser(Context context) {


            this.context = context;
        } //Constructor

        @Override
        protected String doInBackground(Void... voids) {

            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                Log.d("1octV1", "e doInback ==> " + e.toString());
                return null;
            }


        } //doInBalk

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("1octV1", "JSON ==>" + s);

            strings = new String[5];


            try {

                JSONArray jsonArray = new JSONArray(s);

                for (int i=0; i<jsonArray.length(); i+=1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    if (userString.equals(jsonObject.getString("User"))) {

                        aBoolean = false;
                        strings[0]= jsonObject.getString("id");
                        strings[1]= jsonObject.getString("User");
                        strings[2]= jsonObject.getString("Password");
                        strings[3]= jsonObject.getString("Type");
                        strings[4]= jsonObject.getString("Sex");



                    }//if

                }//for

                //chack User & password
                if (aBoolean) {
                    //User false
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context, "User False",
                            "No " + userString + " in my Database");

                } else if (!passwordString.equals(strings[2])) {
                    //Password False
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context, "Password False",
                            "Please Try Again Password False");
                } else {
                    //Password True
                    switch (Integer.parseInt(strings[3])) {

                        case 0: //For primary
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            intent.putExtra("Login", strings);
                            startActivity(intent);
                            finish();
                            break;
                        case 1: //For Share
                            break;

                    }//switch



                } //if

            }catch (Exception e){
                e.printStackTrace();
            }

        }// onPost

    }//Authen Class


    public  void clickCancal (View view) {
        finish();
    }

    public void clickAddNewUser(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }


} //main Class
