package com.example.testdemoactivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Creadted by Ting on 2020-07-22 13:28
 */
public class RecyclerViewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recyclerview);
		RecyclerView recyclerView = findViewById(R.id.recyclerView);
		//public LinearLayoutManager(Context context)
		//public LinearLayoutManager(Context context, int orientation, boolean reverseLayout)

		/*//线性布局管理器
//		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
		//设置LayoutManager为LinearLayoutManager
		recyclerView.setLayoutManager(linearLayoutManager);*/

		/*//网格布局管理器3列
		GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
//		gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
		//设置LayoutManager为GridLayoutManager
		recyclerView.setLayoutManager(gridLayoutManager);*/

		//StaggeredGridLayoutManager(int spanCount, int orientation)，spanCount代表每行或每列的Item个数，orientation代表列表的方向，竖直或者水平。
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
		staggeredGridLayoutManager.setOrientation(StaggeredGridLayoutManager.HORIZONTAL);
		//设置LayoutManager为GridLayoutManager
		recyclerView.setLayoutManager(staggeredGridLayoutManager);
		//初始化数据
		final List<String> datas = new ArrayList<>();
		for(int i=0;i<20;i++){
//			datas.add(" item "+i);

			StringBuilder sb = new StringBuilder();
			for(int j = 0;j < i;j++){
				sb.append(" item ");
			}
			datas.add(" item "+sb.toString()+i);

//			datas.add(" item "+i/*+"item "+i+"item "+i+"item "+i+"item "+i+"item "+i+"item "+i+"item "+i*/);
		}
		MyAdapter myAdapter = new MyAdapter(this,datas);
		//设置Adapter
		recyclerView.setAdapter(myAdapter);

		//点击事件
		myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Toast toast = Toast.makeText(RecyclerViewActivity.this,null,Toast.LENGTH_SHORT);
				toast.setText(datas.get(position)+"被点击了");
				toast.show();
				/*Toast.makeText(RecyclerViewActivity.this,datas.get(position)+"被点击了",
						Toast.LENGTH_SHORT).show();*/
			}
		});
		//长按事件
		myAdapter.setOnItemLongClickListener(new MyAdapter.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(View view, int position) {
				Toast toast = Toast.makeText(RecyclerViewActivity.this,null,Toast.LENGTH_SHORT);
				toast.setText(datas.get(position)+"被长按了");
				toast.show();
				/*Toast.makeText(RecyclerViewActivity.this,datas.get(position)+"被长按了",
						Toast.LENGTH_SHORT).show();*/
				return true;
			}
		});

	}
}
