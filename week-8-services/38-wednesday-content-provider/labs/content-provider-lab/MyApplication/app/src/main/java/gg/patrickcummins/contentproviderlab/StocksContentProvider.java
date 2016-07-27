package gg.patrickcummins.contentproviderlab;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by patrickcummins on 7/27/16.
 */

public class StocksContentProvider extends ContentProvider {
    private  DBHandler myDb;

    private static String AUTHORITY = "gg.patrickcummins.contentproviderlab.StocksContentProvider";
    private static String STOCK_TABLE = "stocks";
    private static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + STOCK_TABLE);

    public static final int STOCKS = 1;
    public static final int STOCKS_ID = 2;


    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    static {
        sURIMatcher.addURI(AUTHORITY,STOCK_TABLE,STOCKS);
        sURIMatcher.addURI(AUTHORITY, STOCK_TABLE + "/#", STOCKS_ID);
    }

    @Override
    public boolean onCreate() {
        myDb = new DBHandler(getContext(), null, null, 1);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        int uriType = sURIMatcher.match(uri);
        Cursor cursor = null;

        switch (uriType){
            case STOCKS_ID:
                break;
            case STOCKS:
                cursor = myDb.getStocks(s);
                break;
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        myDb.addStock(contentValues);
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
