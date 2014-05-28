package com.zte.mte;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ConfigActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config_list);
		//绑定XML中的ListView，作为Item的容器
		ListView list = (ListView) findViewById(R.id.ConfigListView);
		//生成动态数据
		ArrayList<HashMap<String, Object>> listImageItem = new 
				ArrayList<HashMap<String, Object>>();
		for(int i = 0; i < 10; i++)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.ic_launcher);
			map.put("ItemTitle", "XXX单板配置");
			map.put("ItemText", "单板的详细配置参数，每个单板的具体参数不一致");
			listImageItem.add(map);
		}
		//生成适配器
		SimpleAdapter adpImageItems = new SimpleAdapter(this, 
					listImageItem,
					R.layout.config_list_item,
					new String[] {"ItemImage", "ItemTitle", "ItemText"},
					new int[] {R.id.ItemImage, R.id.ItemTitle, R.id.ItemText});
		//添加并显示
		list.setAdapter(adpImageItems);
	}
	
}
