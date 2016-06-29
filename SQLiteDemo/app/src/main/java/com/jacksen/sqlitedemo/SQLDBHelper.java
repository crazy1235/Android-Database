package jacksen.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jacksen on 2016/6/28.
 */

public class SQLDBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "";

    public static int DB_VERSION = 1;


    public SQLDBHelper(Context context, String name) {
        super(context, name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
