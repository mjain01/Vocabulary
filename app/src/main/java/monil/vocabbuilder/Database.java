package monil.vocabbuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by hello on 03-03-2017.
 */
public class Database  extends SQLiteOpenHelper{

        static int data_count;
        static SQLiteDatabase db;
        static Context context;
        private static String TAG = "Database1"; // Tag just for  LogCat window
        //destination path (location) of our database on device
        private static String DB_PATH = "";
        private static String DB_NAME ="test.db";// Database name
        private SQLiteDatabase mDataBase;
        private final Context mContext;



    public Database(Context context)
    {
            super(context, Data.DATABASE_NAME, null, 1);

            Database.context =context;
            this.mContext = context;


                if (android.os.Build.VERSION.SDK_INT >= 17)
                    DB_PATH = context.getApplicationInfo().dataDir + "/databases/";

                else
                    DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";


        try {
            createDataBase();
        } catch (IOException e) {
            try {
                createDataBase();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


        db = this.getWritableDatabase();

    }



    public static ArrayList<Database_Cell> loadContainer(int list_no,String color)
    {
        ArrayList<Database_Cell> container=new ArrayList<Database_Cell>();

    String sql = "select * from level" + list_no + " where color='" + color + "'";//TAKE CARE OF LIST NO

    Cursor cr = db.rawQuery(sql, null);
    data_count = cr.getCount();

    while (cr.moveToNext()) {

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



    public void createDataBase() throws IOException
    {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        Log.i(TAG,""+mDataBaseExist);
        if(!mDataBaseExist)
        {
          //  this.getReadableDatabase();
          //  this.close();
            try
            {
                //Copy the database from assests
                copyDataBase();

                Log.e(TAG, "createDatabase database created");
            }
            catch (IOException mIOException)
            {
                Log.e(TAG, mIOException.toString()+"");
                throw mIOException;
            }
        }

    }




    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase()
    {

        File dbFile = new File(DB_PATH + DB_NAME);
        Log.i(TAG, "" + dbFile.exists());
        if(dbFile.exists()) {
            if (dbFile.length() < 310000) {
                Log.i(TAG, dbFile.delete() + "");
                return false;
            }
            else
            {
                return true;
            }
        }
        return dbFile.exists();
    }



    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;


        OutputStream  mOutput = new FileOutputStream(outFileName);




            Log.i(TAG,DB_PATH);

        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }

        mOutput.flush();
        mOutput.close();
        mInput.close();
    }



    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }



    @Override
    public synchronized void close()
    {
        if(mDataBase != null)
            mDataBase.close();
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
