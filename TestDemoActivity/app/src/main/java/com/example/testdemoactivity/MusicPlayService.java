package com.example.testdemoactivity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicPlayService extends Service {
	private MediaPlayer mMediaPlayer;
	//接口对象
	IBinder mMyBinder = new MyBinder();

	static int mIndex = 0;

	//定义IBinder接口实现
	class MyBinder extends Binder {
		public MusicPlayService getService(){
			return MusicPlayService.this;
		}
	}


	@Override
	public void onCreate() {
		super.onCreate();
		mMediaPlayer = MediaPlayer.create(this,R.raw.ball);
		Log.i("Ting log","Service Create"+(++mIndex));
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
//		stopSelf();
		//新建一个线程
		/*new Thread(new Runnable(){
				@Override
				public void run(){
					helloService();
				};
		}).start();*/

		int _command;
		if(intent != null){
			_command = intent.getExtras().getInt("mediacommand");
			switch(_command){
				case 1:
					mMediaPlayer.start();
					Toast toast = Toast.makeText(this,null,Toast.LENGTH_SHORT);
					toast.setText("player play");
					toast.show();
//					Toast.makeText(this,"player play",Toast.LENGTH_SHORT).show();
					break;
				case 2:
					mMediaPlayer.pause();
					Toast toast1 = Toast.makeText(this,null,Toast.LENGTH_SHORT);
					toast1.setText("player play");
					toast1.show();
//					Toast.makeText(this,"player pause",Toast.LENGTH_SHORT).show();
					break;
				case 3:
					mMediaPlayer.stop();
					mMediaPlayer.release();
					Toast toast2 = Toast.makeText(this,null,Toast.LENGTH_SHORT);
					toast2.setText("player play");
					toast2.show();
//					Toast.makeText(this,"player stop",Toast.LENGTH_SHORT).show();
					mMediaPlayer = null;
					break;
				default:
					break;
			}
		}
		return super.onStartCommand(intent, flags, startId);
	}


	@Override
	public IBinder onBind(Intent intent) {
		//暴露我们的IBinder的接口定义
		Log.i("Ting log","Service onBind");
		return mMyBinder;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("Ting log","Service Unbind");
		return super.onUnbind(intent);
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("Ting log","Service Destroy");
	}
}
