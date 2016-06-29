package com.jacksen.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.jacksen.sqlitedemo.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button insertBtn;
    private Button queryBtn;
    private Button deleteBtn;
    private Button updateBtn;

    private ListView listView;

    private SQLiteDatabase database;
    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        insertBtn = (Button) findViewById(R.id.insert_btn);
        queryBtn = (Button) findViewById(R.id.query_btn);
        deleteBtn = (Button) findViewById(R.id.delete_btn);
        updateBtn = (Button) findViewById(R.id.update_btn);


        listView = (ListView) findViewById(R.id.listview);

        View headerView = View.inflate(this, R.layout.header_listview, null);

        listView.addHeaderView(headerView);

        database = new SQLDBHelper(this).getWritableDatabase();

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertSomeStudents();
            }
        });

        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStudents();

            }


        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void insertSomeStudents() {
        for (int i = 0; i < 5; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", "name" + i);
            contentValues.put("sex", i % 2);
            contentValues.put("class_id", i * 101);
            database.insert(SQLDBHelper.TABLE_STUDENTS, null, contentValues);
        }
    }

    private void showStudents() {
        queryStudents();

    }

    private void queryStudents() {
        list = new ArrayList<>();
        Cursor cursor = database.query(SQLDBHelper.TABLE_STUDENTS,
                new String[]{"id as _id", "name", "sex", "age", "class_id"}, "id>? and sex=?", new String[]{"3", "0"},
                null, null, "id desc");
        /*while (cursor.moveToNext()) {
            int stuId = cursor.getInt(0);
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int sex = cursor.getInt(cursor.getColumnIndex("sex"));
            int classId = cursor.getInt(cursor.getColumnIndex("class_id"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            list.add(new Student(stuId, name, sex, classId, age));
        }
        cursor.close();*/

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item_listview, cursor,
                new String[]{"_id", "name", "sex", "age", "class_id"},
                new int[]{R.id.student_id_tv, R.id.student_name_tv, R.id.student_sex_tv, R.id.student_age_tv, R.id.student_classid_tv},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);


        listView.setAdapter(adapter);

//        cursor.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
