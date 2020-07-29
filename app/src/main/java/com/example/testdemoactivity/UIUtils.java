package com.example.testdemoactivity;

import android.content.Context;
import android.widget.Toast;

/**
 * Creadted by Ting on 2020-07-22 12:29
 *
 * 小米新版MIUI Toast会显示APP名字的问题解决
 *		只有MIUI新版本才有这个问题.....应该底层做了处理
 *
 * 使用该UIUtils类会出现一种情况，当连续点击一个按钮的时候或者紧接着去点击别的按钮时，不会弹出Toast。因此不使用这种类
 *
 * 因此，此处使用
 * 		Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
 * 		toast.setText("hello world");
 * 		toast.show();
 * 替代
 */
public class UIUtils {

	private static Toast toast;

	public static void showToast(Context context, String msg) {
		if (toast == null) {
			toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
			toast.setText(msg);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}
}
