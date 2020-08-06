package com.example.testdemoactivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creadted by Ting on 2020-08-04 21:32
 */
public class MyOwnContentProviderActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myowncontentprovider);

		Button query = findViewById(R.id.query);
		Button insert = findViewById(R.id.insert);

		query.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ContentResolver contentResolver = getContentResolver();
				Cursor cursor = contentResolver.query(Uri.parse("content://com.example.testdemoactivity.provider"),null,null,null,null);

			}
		});
	}
}
