package com.truongtd.orderfood.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.truongtd.orderfood.database.Database;
import com.truongtd.orderfood.dto.Employee;

/**
 * Created by Truong_it on 7/7/2017.
 */

public class EmployeeDAO {
    SQLiteDatabase sqLiteDatabase;
    public EmployeeDAO(Context context) {
        Database database = new Database(context);
        sqLiteDatabase = database.open();
    }
    public long addEmployee(Employee employee){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.TB_EMPLOYEE_ID_EMPLOYEE, employee.getIdEmployee());
        contentValues.put(Database.TB_EMPLOYEE_USERNAME, employee.getUserName());
        contentValues.put(Database.TB_EMPLOYEE_PASSWORD, employee.getPassWord());
        contentValues.put(Database.TB_EMPLOYEE_GENDER, employee.getGender());
        contentValues.put(Database.TB_EMPLOYEE_BIRTHDAY, employee.getBirthDay());
        contentValues.put(Database.TB_EMPLOYEE_ID_PASSPORT, employee.getIdPassport());

        long isChecked = sqLiteDatabase.insert(Database.TB_EMPLOYEE, null, contentValues);
        return isChecked;
    }
    public boolean isCheckEmployee(){

        String sqlEmpployeeExist= "SELECT * FROM " + Database.TB_EMPLOYEE;

        Cursor cursor = sqLiteDatabase.rawQuery(sqlEmpployeeExist, null);
        if(cursor.getCount() != 0){
            Log.d("value: ",""+cursor);
            return true;
        }else {
            return false;
        }
    }
    public boolean isCheckLogin(String userName, String password){

        String sqlLogin = "SELECT * FROM " + Database.TB_EMPLOYEE + " Where " + Database.TB_EMPLOYEE_USERNAME + " = '"+  userName
        + "' AND " + Database.TB_EMPLOYEE_PASSWORD + " = '" +password + "'";
        Cursor cursorLogin = sqLiteDatabase.rawQuery(sqlLogin, null);
        if(cursorLogin.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }
}
