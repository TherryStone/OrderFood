package com.truongtd.orderfood.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.truongtd.orderfood.utils.Utils;

/**
 * Created by Truongtd_it on 6/28/2017.
 */

public class Database extends SQLiteOpenHelper {

    public static final  String TB_EMPLOYEE = "EMPLOYEE";
    public static final  String TB_DISH = "DISH";
    public static final  String TB_TYPE_DISH= "TYPE_DISH";
    public static final  String TB_DINNING_TABLE = "DINNING_TABLE";
    public static final  String TB_ORDER = "ORDER_FOOD";
    public static final  String TB_ORDER_DETAILS = "ORDER_DETAILS";

    //create property TB_EMPLOYEE
    public static final String TB_EMPLOYEE_ID_EMPLOYEE = "ID_EMPLOYEE";
    public static final String TB_EMPLOYEE_USERNAME = "USER_NAME";
    public static final String TB_EMPLOYEE_PASSWORD = "PASS_WORD";
    public static final String TB_EMPLOYEE_GENDER = "GENDER";
    public static final String TB_EMPLOYEE_BIRTHDAY = "BIRTH_DAY";
    public static final String TB_EMPLOYEE_ID_PASSPORT = "ID_PASSPORT";

    //create property TB_DISH
    public static final String TB_DISH_ID_DISH = "ID_DISH";
    public static final String TB_DISH_FOOD_NAME = "FOOD_NAME";
    public static final String TB_DISH_PRICE = "PRICE";
    public static final String TB_DISH_TYPE_CODE = "TYPE_CODE";

    //create property TB_TYPE_DISH
    public static final String TB_TYPE_DISH_TYPE_CODE = "TYPE_CODE";
    public static final String TB_TYPE_DISH_TYPE_NAME = "TYPE_NAME";

    //create property TB_DINNING_TABLE
    public static final String TB_DINNING_TABLE_ID_TABLE = "ID_DINNING_TABLE";
    public static final String TB_DINNING_TABLE_NAME = "DINNING_TABLE_NAME";
    public static final String TB_DINNING_TABLE_STATUS = "TABLE_STATUS";

    //create property TB_ORDER
    public static final String TB_ORDER_ID = "ID_ORDER";
    public static final String TB_ORDER_ID_EMPLOYEE = "ID_EMPLOYEE";
    public static final String TB_ORDER_DATE = "ORDER_DATE";
    public static final String TB_ORDER_PAYMENT_STATUS = "PAYMENT_STATUS";
    public static final String TB_ORDER_ID_DINNING_TABLE = "ID_DINNING_TABLE";

    //create property TB_ORDER_DETAILS
    public static final String TB_ORDER_DETAILS_ID = "ID_ORDER_DETAILS";
    public static final String TB_ORDER_DETAILS_ID_DISH = "ID_DISH";
    public static final String TB_ORDER_DETAILS_QUANTITY = "QUANTITY";


    public Database(Context context) {
        super(context, Utils.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String employee = "CREATE TABLE " + TB_EMPLOYEE + " ( " + TB_EMPLOYEE_ID_EMPLOYEE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_EMPLOYEE_USERNAME + " TEXT," + TB_EMPLOYEE_PASSWORD + " TEXT, " + TB_EMPLOYEE_GENDER + " TEXT, "
                + TB_EMPLOYEE_BIRTHDAY + " TEXT, " + TB_EMPLOYEE_ID_PASSPORT + " INTEGER )";

        String dinningTable = "CREATE TABLE " + TB_DINNING_TABLE + " ( " + TB_DINNING_TABLE_ID_TABLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_DINNING_TABLE_NAME + " TEXT, " + TB_DINNING_TABLE_STATUS + " TEXT )";

        String dish = "CREATE TABLE " + TB_DISH + " ( " + TB_DISH_ID_DISH + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TB_DISH_FOOD_NAME + " TEXT, "
                + TB_DISH_PRICE + " TEXT," + TB_DISH_TYPE_CODE + " TEXT )";

        String typeDish = "CREATE TABLE " + TB_TYPE_DISH + " ( " + TB_TYPE_DISH_TYPE_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TB_TYPE_DISH_TYPE_NAME + " TEXT )";

//        String order = "CREATE TABLE " +TB_ORDER+ " (" + TB_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + TB_ORDER_ID_EMPLOYEE + " INTEGER, " + TB_ORDER_DATE + " TEXT, " + TB_ORDER_PAYMENT_STATUS + " TEXT, "
//                + TB_ORDER_ID_DINNING_TABLE + " INTEGER)";

        String order = "CREATE TABLE " + TB_ORDER + " ( " + TB_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_ORDER_ID_EMPLOYEE + " INTEGER, " + TB_ORDER_DATE + " TEXT, " + TB_ORDER_PAYMENT_STATUS + " TEXT, "
                + TB_ORDER_ID_DINNING_TABLE + " INTEGER )" ;
        Log.d("TAG", order);

        String orderDetails = "CREATE TABLE " + TB_ORDER_DETAILS + " ( " + TB_ORDER_DETAILS_ID + " INTEGER , "
                + TB_ORDER_DETAILS_ID_DISH + " INTEGER, " + TB_ORDER_DETAILS_QUANTITY + " INTEGER, " +
                " PRIMARY KEY  ( " + TB_ORDER_DETAILS_ID +  " , " + TB_ORDER_DETAILS_ID_DISH + "))";

        db.execSQL(employee);
        db.execSQL(dinningTable);
        db.execSQL(dish);
        db.execSQL(typeDish);
        db.execSQL(order);
        db.execSQL(orderDetails);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public SQLiteDatabase open(){

        return this.getWritableDatabase();
    }
}
