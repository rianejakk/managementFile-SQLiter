package com.rianezza.implementasi_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    TextView txt1, txt2, txt3, txt4, txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        dbHelper = new DataHelper(this);
        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt4 = findViewById(R.id.textView4);
        txt5 = findViewById(R.id.textView5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" + getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            txt1.setText(cursor.getString(0));
            txt2.setText(cursor.getString(1));
            txt3.setText(cursor.getString(2));
            txt4.setText(cursor.getString(3));
            txt5.setText(cursor.getString(4));
        }
        ton2.findViewById(R.id.button1);
        ton2.setOnClickListener(view -> finish());
    }
}