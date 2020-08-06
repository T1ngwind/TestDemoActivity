package com.example.testdemoactivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creadted by Ting on 2020-07-28 18:12
 */
public class SQLiteActivity extends AppCompatActivity {

	EditText text_1;
	EditText text_2;
	ListView listView;
	Button   add;

	SQLiteDatabase sqLiteDatabase;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);
		sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/Ting.db3",null);

		text_1 = findViewById(R.id.text_1);
		text_2 = findViewById(R.id.text_2);
		add    = findViewById(R.id.add);
		listView = findViewById(R.id.show);

		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String et_text_1 = text_1.getText().toString().trim();
				String et_text_2 = text_2.getText().toString().trim();
				try{
					insertData(sqLiteDatabase,et_text_1,et_text_2);
					Cursor cursor = sqLiteDatabase.rawQuery("select * from news_inf",null);
					inflateList(cursor);
				}catch(SQLException se){
					//执行DDL创建数据表
					sqLiteDatabase.execSQL("create table news_inf(_id integer"
					+ " primary key autoincrement,"
					+ " news_input1 varchar(50),"
					+ " news_input2 varchar(255))");
					//执行insert语句插入数据
					insertData(sqLiteDatabase,et_text_1,et_text_2);
					//执行查询
					Cursor cursor = sqLiteDatabase.rawQuery("select * from news_inf",null);
					inflateList(cursor);
				}
			}
		});

	}

	private void insertData(SQLiteDatabase sqLiteDatabase,String input1,String input2){
		//执行插入语句
		sqLiteDatabase.execSQL("insert into news_inf values(null,?,?)",new String[]{input1,input2});
	}

	private void inflateList(Cursor cursor){

		//填充SimpleCursorAdapter
		SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(
				SQLiteActivity.this,
				R.layout.activity_line,cursor,
				new String[]{"news_input1","news_input2"},
				new int[]{R.id.my_title,R.id.my_content},
				CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		//显示数据
		listView.setAdapter(simpleCursorAdapter);


	}

	public void onDestory(){
		super.onDestroy();
		//退出程序时关闭SQLiteDatabase
		if(sqLiteDatabase!=null&&sqLiteDatabase.isOpen()){
			sqLiteDatabase.close();
		}
	}




}
