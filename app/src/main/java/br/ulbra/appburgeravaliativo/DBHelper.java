package br.ulbra.appburgeravaliativo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static String nome = "BancoDados.db";
    private static int versao=1;

    public DBHelper(Context context){
        super(context, nome,null,versao);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE utilizador(Name TEXT PRIMARY KEY, Email TEXT,  Password TEXT, Phone TEXT);";
        db.execSQL(str);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS utilizador;");
        onCreate(db);
    }
    public Long criarUtilizador(String Name, String Email, String Password, String Phone){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",Name);
        cv.put("Email",Email);
        cv.put("Password",Password);
        cv.put("Phone",Phone);
        long result = db.insert("utilizador", null,cv);

        return result;
    }
    public String validarLogin(String Email, String Password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from utilizador where Email=? and Password=?", new String[] {Email, Password});
        String resultado = (c.getCount() > 0) ? "OK" : "ERRO";
        c.close();
        return resultado;
    }
}