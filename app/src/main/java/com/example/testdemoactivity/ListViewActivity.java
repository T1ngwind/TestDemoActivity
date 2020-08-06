package com.example.testdemoactivity;

/**
 * Creadted by Ting on 2020-07-22 15:09
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
	//玉皇大帝、元始天尊、灵宝天尊(玉宸道君)、太上老君(道德天尊)、齐天大圣、木公老祖(东华帝君)、王母娘娘(瑶池金母)、骊山老母、真武大帝、王灵官、千里眼、顺风耳。 九天应元雷声普化天尊、雷公、电母、风婆婆、云神、五炁真君、太白金星、赤脚大仙、游奕灵官、太阳星君、太阴星君
	String[] strName = new String[]{"唐僧","孙悟空","猪八戒","沙悟净","玉皇大帝","元始天尊","太上老君","王母娘娘","骊山老母","真武大帝","千里眼","顺风耳","太白金星","赤脚大仙","土地公"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		final ListView listView = findViewById(R.id.listView);
		ArrayAdapter aa = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,strName);
		//为listView设置适配器Adapter
		listView.setAdapter(aa);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Toast toast = Toast.makeText(ListViewActivity.this, null, Toast.LENGTH_SHORT);
				switch(i){

					case 1:
//						UIUtils.showToast(MainActivity.this,"你选择了"+listView.getItemAtPosition(i));
//						Toast.makeText(ListViewActivity.this,"你选择了"+listView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
						toast.setText("你选择了"+listView.getItemAtPosition(i));
						toast.show();
						break;
					case 2:
//						UIUtils.showToast(MainActivity.this,"你选择了"+listView.getItemAtPosition(i));
//						Toast.makeText(MainActivity.this,"你选择了"+listView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
						toast.setText("你选择了"+listView.getItemAtPosition(i));
						toast.show();
						break;
					case 3:
//						UIUtils.showToast(MainActivity.this,"你选择了"+listView.getItemAtPosition(i));
//						Toast.makeText(MainActivity.this,"你选择了"+listView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
						toast.setText("你选择了"+listView.getItemAtPosition(i));
						toast.show();
						break;
					case 4:
//						UIUtils.showToast(MainActivity.this,"你选择了"+listView.getItemAtPosition(i));
//						Toast.makeText(MainActivity.this,"你选择了"+listView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
						toast.setText("你选择了"+listView.getItemAtPosition(i));
						toast.show();
						break;
					case 5:
//						UIUtils.showToast(MainActivity.this,"你选择了"+listView.getItemAtPosition(i));
//						Toast.makeText(MainActivity.this,"你选择了"+listView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
						toast.setText("你选择了"+listView.getItemAtPosition(i));
						toast.show();
						break;
					default:
//						UIUtils.showToast(MainActivity.this,"你选择了"+listView.getItemAtPosition(i));
//						Toast.makeText(MainActivity.this,"你选择了"+listView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
						toast.setText("你选择了"+listView.getItemAtPosition(i));
						toast.show();
						break;


				}
			}
		});

	}
}

