package com.jacksen.activeandroiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button insertBtn, updateBtn, deleteBtn, queryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertBtn = (Button) findViewById(R.id.insert_btn);
        updateBtn = (Button) findViewById(R.id.update_btn);
        deleteBtn = (Button) findViewById(R.id.delete_btn);
        queryBtn = (Button) findViewById(R.id.query_btn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStudent();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStudent();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryStudent();
            }
        });

    }


    // 主键自增怎么办？

    private void insertStudent() {

        ActiveAndroid.beginTransaction();

        try {
            for (int i = 0; i < 3; i++) {
                Grade grade = new Grade();
                grade.id = i + 1;
                grade.name = i + "年级";
                grade.save();
            }

            ActiveAndroid.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ActiveAndroid.endTransaction();
        }

        //

        ActiveAndroid.beginTransaction();

        try {
            for (int i = 0; i < 10; i++) {
                Student student = new Student();
                student.id = i + 1;
                student.name = "yansen" + i;
                student.age = 24 + new Random().nextInt(3);
                student.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ActiveAndroid.endTransaction();
        }

    }

    private void updateStudent() {
        new Update(Student.class).set("name=?", "sololo").where("sid=?", 1).execute();
    }


    private void deleteStudent() {
        new Delete().from(Student.class).where("sid=?", 1).execute();
    }


    private void queryStudent() {
        List<Student> list = new Select().from(Student.class).where("sid>?", 1).limit(10).execute();
        Toast.makeText(this, "list.size():" + list.size(), Toast.LENGTH_SHORT).show();
    }

}
