package com.zte.mte;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class EmbStateActivity extends Activity {
	private GridView gv_menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.emb_state);
		gv_menu = (GridView) findViewById(R.id.gridView1);
		init();
	}
	
	private void init() {

	}
}
