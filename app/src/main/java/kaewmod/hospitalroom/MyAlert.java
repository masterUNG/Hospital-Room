package kaewmod.hospitalroom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by IT on 3/9/2559.
 */
public class MyAlert {

 public  void myDialog(Context context,
                       String strTitle,
                       String strMessage){
     AlertDialog.Builder builder = new AlertDialog.Builder(context);
     builder.setCancelable(false);
     builder.setIcon(R.drawable.tokjai);
     builder.setTitle(strTitle);
     builder.setMessage(strMessage);
     builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i) {
             dialogInterface.dismiss();
         }
     });
     builder.show();


 }
} //Main Class

