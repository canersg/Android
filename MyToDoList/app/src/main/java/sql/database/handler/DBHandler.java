package sql.database.handler;

/**
 * Created by Caner on 25.12.2016.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import todolist.csinc.business.TODO;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MyDatabase";
    // Contacts table name
    private static final String TABLE_TODOS = "todo_table";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IS_FINISHED = "isFinished";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TODOS + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
        + KEY_IS_FINISHED + " TEXT " +" )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOS);
// Creating tables again
        onCreate(db);
    }
    // Adding new shop
    public void addTODOItem(TODO item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName()); // Shop Name
        values.put(KEY_IS_FINISHED, item.getChecked()); // Shop Phone Number
// Inserting Row
        db.insert(TABLE_TODOS, null, values);
        db.close(); // Closing database connection
    }

    // Getting one shop
    public TODO getShop(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TODOS, new String[] { KEY_ID,
                        KEY_NAME, KEY_IS_FINISHED }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        TODO contact = new TODO(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getInt(2));
// return shop
        return contact;
    }
    // Getting All Shops
    public List<TODO> getAllTodos() {
        List<TODO> shopList = new ArrayList<TODO>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TODOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TODO shop = new TODO();
                shop.setId(Integer.parseInt(cursor.getString(0)));
                shop.setName(cursor.getString(1));
                shop.setChecked(cursor.getInt(2));
// Adding contact to list
                shopList.add(shop);
            } while (cursor.moveToNext());
        }
// return contact list
        return shopList;
    }
    // Getting shops Count
    public int getShopsCount() {
        String countQuery = "SELECT * FROM " + TABLE_TODOS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
// return count
        return cursor.getCount();
    }
    // Updating a shop
    public int updateTodo(TODO todoItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, todoItem.getName());
        values.put(KEY_IS_FINISHED, todoItem.getChecked());
// updating row
        return db.update(TABLE_TODOS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(todoItem.getId())});
    }
    // Deleting a shop
    public void deleteShop(TODO shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODOS, KEY_ID + " = ?",
                new String[] { String.valueOf(shop.getId()) });
        db.close();
    }
}
