package kaewmod.hospitalroom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IT on 1/10/2559.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    //Explicit
    public static final String database_name = "hospital.db";
    private static final int database_version = 1;

    private static final String create_Medicine_table = "create table medicineTABLE(" +
            "_id integer primary key, " +
            "Medicine text," +
            "Day text, " +
            "StartDay text," +
            "Morning text," +
            "Lunch text," +
            "Dinner text," +
            "Sleep text," +
            "BeforeFood text," +
            "Amont text);";


    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);

    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_Medicine_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
} //Main Class

