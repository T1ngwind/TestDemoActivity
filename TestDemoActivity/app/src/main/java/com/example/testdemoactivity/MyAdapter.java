package com.example.testdemoactivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * Creadted by Ting on 2020-07-22 17:11
 *
 * https://www.jianshu.com/p/5ad99a1170ab
 * RecyclerView使用总结-------上
 *		item的点击事件
 * 			① 在Adapter里面直接对控件做点击事件
 * 			② 写接口，在Activity或Fragment上实现接口中定义的方法
 *
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
	//当前上下文对象
	Context context;
	//RecyclerView填充Item数据的List对象
	List<String> datas;

	public MyAdapter(Context context,List<String> datas){
		this.context = context;
		this.datas = datas;
	}

	@Override
	public int getItemViewType(int position) {
		if(position%2==0) {
			return 0;
		}else{
			return 2;
		}
	}

	/**
	 * 设置回调接口
	 */
	public interface OnItemClickListener {
		void onItemClick(View view, int position);
	}
	/**
	 * 设置长按回调接口
	 */
	public interface OnItemLongClickListener {
		boolean onItemLongClick(View view, int position);
	}

	/**
	 * 事件回调监听
	 */
	private OnItemClickListener onItemClickListener;
	private OnItemLongClickListener onItemLongClickListener;
	/**
	 * 设置回调监听
	 *
	 * @param listener
	 */
	public void setOnItemClickListener(OnItemClickListener listener) {
		this.onItemClickListener = listener;
	}

	public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
		this.onItemLongClickListener = onItemLongClickListener;
	}



	//创建ViewHolder
	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		//View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dome, parent, false);
		//view.setOnClickListener(this);
		//return new MyViewHolder(view);
		View v;
		if(viewType == 0){
			v = View.inflate(context,R.layout.item_dome,null);
		}else{
			v = View.inflate(context,R.layout.item_dome2,null);
		}

		final MyViewHolder viewHolder = new MyViewHolder(v);

		return viewHolder;

		/*//实例化得到Item布局文件的View对象
		View v = View.inflate(context, R.layout.item_dome,null);

		final MyViewHolder viewHolder = new MyViewHolder(v);

//		v.setOnClickListener(this);
//		Log.i("Ting收到RecyclerView的消息","onCreateViewHolder");
		//返回MyViewHolder的对象
		return viewHolder;*/


	}

	//绑定数据
	@Override
	public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
		holder.textView.setText(datas.get(position));
		//将position保存在itemView的Tag中，以便点击时进行获取
		holder.itemView.setTag(position);

		/*//1.在Adapter里面直接对控件做点击事件
		holder.textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast toast = Toast.makeText(context,null,Toast.LENGTH_SHORT);
				toast.setText(holder.textView.getText()+"被点击了");
				toast.show();

			}
		});*/

		//2.写接口，在Activity或Fragment上实现接口中定义的方法
		holder.textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(onItemClickListener != null){
					onItemClickListener.onItemClick(view,position);
				}

			}
		});
		//通过接口回调响应长按事件
		holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				if(onItemLongClickListener != null){
					return onItemLongClickListener.onItemLongClick(view,position);
				}
				return false;
			}
		});



	}



	//返回Item的数量
	@Override
	public int getItemCount() {
		return datas.size();
	}

	//继承RecyclerView.ViewHolder抽象类的自定义ViewHolder
	class MyViewHolder extends RecyclerView.ViewHolder{
		TextView textView;

		public MyViewHolder(View itemView) {
			super(itemView);
			textView = itemView.findViewById(R.id.text_view);
		}
	}
}