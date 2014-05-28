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
		//��XML�е�ListView����ΪItem������
		ListView list = (ListView) findViewById(R.id.ConfigListView);
		//���ɶ�̬����
		ArrayList<HashMap<String, Object>> listImageItem = new 
				ArrayList<HashMap<String, Object>>();
		for(int i = 0; i < 10; i++)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.ic_launcher);
			map.put("ItemTitle", "XXX��������");
			map.put("ItemText", "�������ϸ���ò�����ÿ������ľ��������һ��");
			listImageItem.add(map);
		}
		//����������
		SimpleAdapter adpImageItems = new SimpleAdapter(this, 
					listImageItem,
					R.layout.config_list_item,
					new String[] {"ItemImage", "ItemTitle", "ItemText"},
					new int[] {R.id.ItemImage, R.id.ItemTitle, R.id.ItemText});
		//��Ӳ���ʾ
		list.setAdapter(adpImageItems);
	}
	
}
