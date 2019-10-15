//package com.example.myapplicationasdd;
//
//import android.provider.BaseColumns;
//
//public class NotesContract {
//    public static final class NotesEntry implements BaseColumns{
//        public static final String TABLE_NAME="note";
//        public static final String COLUMN_TITLE="title";
//        public static final String COLUMN_DESCREPTION="descreption";
//        public static final String COLUMN_DAY_OF_WEEK="day_of_wek";
//        public static final String COLUMN_PRIORITY="priorety";
//
//
//
//        public static final String TYPE_TEXT="TEXT";
//        public static final String TYPE_INTEGER="INTEGER";
//        public static final String CREATE_COMMAND="CREATE TABLE IF NOT EXISTS "
//                +TABLE_NAME+"("+_ID+" "+TYPE_INTEGER+" PRIMARY KEY AUTOINCREMENT, "+COLUMN_TITLE+" "+TYPE_TEXT+" "
//                +", "+COLUMN_DESCREPTION+" "+TYPE_TEXT+", "+COLUMN_DAY_OF_WEEK+" "+TYPE_INTEGER+", "+COLUMN_PRIORITY+" "+TYPE_INTEGER+")";
//
//        public static final String DROP_COMMAND="DROP TABLE IF EXIST "+ TABLE_NAME+TABLE_NAME;
//
//
//
//
//
//    }
//}
