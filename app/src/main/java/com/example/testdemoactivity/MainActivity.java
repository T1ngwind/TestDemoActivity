package com.example.testdemoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//玉皇大帝、元始天尊、灵宝天尊(玉宸道君)、太上老君(道德天尊)、齐天大圣、木公老祖(东华帝君)、王母娘娘(瑶池金母)、骊山老母、真武大帝、王灵官、千里眼、顺风耳。 九天应元雷声普化天尊、雷公、电母、风婆婆、云神、五炁真君、太白金星、赤脚大仙、游奕灵官、太阳星君、太阴星君
	String[] strName = new String[]{"唐僧","孙悟空","猪八戒","沙悟净","玉皇大帝","元始天尊","太上老君","王母娘娘","骊山老母","真武大帝","千里眼","顺风耳","太白金星","赤脚大仙","土地公"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView ListView = findViewById(R.id.ListView);
		TextView RecyclerView = findViewById(R.id.RecyclerView);
		TextView SharedPreferences = findViewById(R.id.SharedPreferences);
		TextView FileIO = findViewById(R.id.FileIO);
		TextView SQLite = findViewById(R.id.SQLite);
		TextView ContentProvider = findViewById(R.id.ContentProvider);
		TextView Service = findViewById(R.id.Service);




		//跳转到ListViewActivity.class
		ListView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
				startActivity(intent);
			}
		});
		//跳转到RecyclerViewActivity.class
		RecyclerView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent1 = new Intent(MainActivity.this,RecyclerViewActivity.class);
				startActivity(intent1);

			}
		});

		SharedPreferences.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent2 = new Intent(MainActivity.this,SharedPreferencesActivity.class);
				startActivity(intent2);
			}
		});

		FileIO.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent3 = new Intent(MainActivity.this,FileIOActivity.class);
				startActivity(intent3);
			}
		});

		SQLite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent4 = new Intent(MainActivity.this,SQLiteActivity.class);
				startActivity(intent4);
			}
		});
		ContentProvider.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				Intent intent5 = new Intent(MainActivity.this,ContentProviderActivity.class);
				Intent intent5 = new Intent(MainActivity.this, ContentActivity.class);
				startActivity(intent5);
			}
		});

		Service.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent6 = new Intent(MainActivity.this,ServiceActivity.class);
				startActivity(intent6);
			}
		});


	}


}
