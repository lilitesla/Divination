package lili.tesla.divinations.data.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lili.tesla.divinations.data.AuditItem;
import lili.tesla.divinations.data.Prediction;

/**
 * Created by Лилия on 24.10.2017.
 */

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    public DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    private void open() {
        this.database = openHelper.getWritableDatabase();
    }

    private void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public Prediction getPrediction(String[] predIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT * FROM china_divination_table WHERE index_id=?", predIndex);
        cursor.moveToFirst();
        Prediction result = new Prediction(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5));
        cursor.close();
        close();
        return result;
    }

    public List<AuditItem> getAuditItems() {
        open();
        String[] text = {};

        Cursor cursor = database.rawQuery("SELECT a.*, cd.china_caption, cd.caption FROM audit a, china_divination_table cd WHERE cd.index_id=a.numeric_id ORDER BY a.id DESC", text);
        List<AuditItem> auditItems = new ArrayList<>();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            AuditItem auditItem = new AuditItem(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3) + ". " + cursor.getString(4));
            auditItems.add(auditItem);

            while (cursor.moveToNext()) {
                auditItem = new AuditItem(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3) + ". " + cursor.getString(4));
                auditItems.add(auditItem);
            }
        }
        cursor.close();
        close();
        return auditItems;
    }

    public void addAuditItem(String predictionIndex) {
        open();

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        database.execSQL("INSERT INTO audit (date, numeric_id) VALUES (\"" + formatForDateNow.format(dateNow) + "\", \"" + predictionIndex + "\"); COMMIT;");
    }

}
