package com.example.testdemoactivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creadted by Ting on 2020-07-31 14:35
 */
public class ServiceActivity extends AppCompatActivity {
	private MediaPlayer mMediaPlayer;
	Button Play;
	Button Pause;
	Button Stop;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		mMediaPlayer = MediaPlayer.create(this,R.raw.ball);

		Play = findViewById(R.id.play);
		Pause = findViewById(R.id.pause);
		Stop = findViewById(R.id.stop);


		Play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent1 = new Intent(ServiceActivity.this,MusicPlayService.class);
				intent1.putExtra("mediacommand",1);
				startService(intent1);
			}
		});


		Pause.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent2 = new Intent(ServiceActivity.this,MusicPlayService.class);
				intent2.putExtra("mediacommand",2);
				startService(intent2);
			}
		});

		Stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent3 = new Intent(ServiceActivity.this,MusicPlayService.class);
				intent3.putExtra("mediacommand",3);
				startService(intent3);
			}
		});

	}
}
