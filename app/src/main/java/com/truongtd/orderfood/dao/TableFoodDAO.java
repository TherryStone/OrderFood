package com.truongtd.orderfood.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.truongtd.orderfood.database.Database;
import com.truongtd.orderfood.dto.DinningTableFood;

import java.util.ArrayList;

/**
 * Created by Truong_it on 8/1/2017.
 */

public class TableFoodDAO {
    SQLiteDatabase sqLiteDatabase;

    public TableFoodDAO(Context context){

        Database database = new Database(context);
        sqLiteDatabase = database.open();
    }
    public boolean addTableFood(String nameTableFood){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.TB_DINNING_TABLE_NAME, nameTableFood);
        contentValues.put(Database.TB_DINNING_TABLE_STATUS, false);
        long isCheckeAddTableFood =  sqLiteDatabase.insert(Database.TB_DINNING_TABLE,null, contentValues);

        if(isCheckeAddTableFood != 0){
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<DinningTableFood> getAllDinningTable(){

        ArrayList<DinningTableFood> arrDinning = new ArrayList<>();
        String sqlDinningTable = "Select * from " + Database.TB_DINNING_TABLE;
        Cursor cursorDinningTable = sqLiteDatabase.rawQuery(sqlDinningTable, null);
        cursorDinningTable.moveToFirst();
        while (!cursorDinningTable.isAfterLast()){
            DinningTableFood dinningTable = new DinningTableFood();
            dinningTable.setIdDinningTable(cursorDinningTable.getInt(cursorDinningTable.getColumnIndex(Database.TB_DINNING_TABLE_ID_TABLE)));
            dinningTable.setNameDinningTable(cursorDinningTable.getString(cursorDinningTable.getColumnIndex(Database.TB_DINNING_TABLE_NAME)));
            dinningTable.setNameDinningTable(cursorDinningTable.getString(cursorDinningTable.getColumnIndex(Database.TB_DINNING_TABLE_STATUS)));
            cursorDinningTable.moveToNext();
        }

        return arrDinning;
    }
}
