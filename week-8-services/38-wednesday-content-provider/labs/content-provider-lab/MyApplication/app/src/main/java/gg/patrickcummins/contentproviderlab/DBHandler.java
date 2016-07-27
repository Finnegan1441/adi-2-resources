package gg.patrickcummins.contentproviderlab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by patrickcummins on 7/27/16.
 */

public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "stocksDB";
    public static final String STOCK_TABLE = "stocks";



    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_STOCK_SYMBOL = "symbol";
    public static final String COLUMN_STOCKNAME = "stockname";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_EXCHANGE = "exchange";

    public static final String CREATE_STOCK_TABLE =
            "CREATE TABLE " + STOCK_TABLE
            + "("+ COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_STOCKNAME + " TEXT,"
            + COLUMN_EXCHANGE + " TEXT,"
            + COLUMN_STOCK_SYMBOL + " TEXT,"
            + COLUMN_QUANTITY + " INTEGER" + ")";

    public static final String DROP_STOCK_TABLE = "DROP TABLE IF EXISTS " +STOCK_TABLE;


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STOCK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_STOCK_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addStock(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(STOCK_TABLE, null, contentValues);
        db.close();
    }
    public Cursor getStocks(String selction){

        String[] projection = {COLUMN_ID,COLUMN_STOCK_SYMBOL,COLUMN_STOCKNAME,COLUMN_EXCHANGE,COLUMN_QUANTITY};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(STOCK_TABLE, projection, selction, null, null, null, null);
        db.close();
        return cursor;
    }

//    public void removeStock(String stockName){
//        SQLiteDatabase db = getWritableDatabase();
//        db.delete(STOCK_TABLE,"stockname = " + stockName, null);
//    }
}
