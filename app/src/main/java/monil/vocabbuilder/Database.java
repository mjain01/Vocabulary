package monil.vocabbuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hello on 03-03-2017.
 */
public class Database  extends SQLiteOpenHelper{

        static int data_count;
        static SQLiteDatabase db;
        static Context context;

        public Database(Context context) {
            super(context, Data.DATABASE_NAME, null, 1);
            Database.context =context;
            db=this.getWritableDatabase();
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
             }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            }

    public static ArrayList<Database_Cell> loadContainer(int list_no,String color)
    {
        ArrayList<Database_Cell> container=new ArrayList<Database_Cell>();

       String sql="select * from level"+list_no+" where color='"+color+"'";//TAKE CARE OF LIST NO

        Cursor cr= db.rawQuery(sql,null);
        data_count=cr.getCount();
        while (cr.moveToNext())
        {
            /*Log.i("Database", "loadContainer: "+cr.getString(0)+//sr
                    cr.getString(1)+//word
                    cr.getString(2)+//word_id
                    cr.getString(3)+//group
                    cr.getString(4)+//group_id
                    cr.getString(5)+//checked
                    cr.getString(6)+//meaning
                    cr.getString(7)+//example
                    cr.getString(8)+//white_pointer
                    cr.getString(9)+//color
                    cr.getString(10)+//wrong
                    cr.getString(11)+//not_sure
                    cr.getString(12)//right
            );*/
            container.add(new Database_Cell(
                    cr.getString(0),//sr
                    cr.getString(1),//word
                    cr.getString(2),//word_id
                    cr.getString(3),//group
                    cr.getString(4),//group_id
                    cr.getString(5),//checked
                    cr.getString(6),//meaning
                    cr.getString(7),//example
                    cr.getString(8),//white_pointer
                    cr.getString(9),//color
                    cr.getString(10),//wrong
                    cr.getString(11),//not_sure
                    cr.getString(12)//right


            ));
        }
        return container;
    }
        public static void colorToWhite(int list_no)//TAKE CARE OF LIST NO Check this one
        {
            ContentValues cv=new ContentValues();

            cv.put("color", "0");
            Log.i("DATABASE", "colorToWhite: "+db.update("level"+list_no, cv, "color='4'", null));
        }
    public static void changeWordColor(int list_no,String word,String to)//TAKE CARE OF LIST NO
    {
        ContentValues cv=new ContentValues();
        cv.put("color", to );
       Log.i("Database", "changeWordColor: " + db.update("level" + list_no, cv, "word='" + word + "'", null));
    }
    public static ArrayList<Database_Cell> markedDataList(int list_no,String color)
    {
        ArrayList<Database_Cell> container=new ArrayList<Database_Cell>();

        String sql="select * from level"+list_no+" where color='"+color+"' and checked='"+1+"'";//TAKE CARE OF LIST NO

        Cursor cr= db.rawQuery(sql,null);
        data_count=cr.getCount();
        while (cr.moveToNext())
        {
            container.add(new Database_Cell(
                    cr.getString(0),//sr
                    cr.getString(1),//word
                    cr.getString(2),//word_id
                    cr.getString(3),//group
                    cr.getString(4),//group_id
                    cr.getString(5),//checked
                    cr.getString(6),//meaning
                    cr.getString(7),//example
                    cr.getString(8),//white_pointer
                    cr.getString(9),//color
                    cr.getString(10),//wrong
                    cr.getString(11),//not_sure
                    cr.getString(12)//right


            ));
        }
        return container;
    }
    public static  void changeMarked(String list_no,String word,String to)
    {
        ContentValues cv=new ContentValues();
        cv.put("checked", to );
        Log.i("Database", "changeWordColor: " + db.update("level" + list_no, cv, "word='" + word + "'", null));
    }
    }
