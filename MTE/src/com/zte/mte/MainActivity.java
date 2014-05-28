package com.zte.mte;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements OnCheckedChangeListener {
	private RadioGroup mainTab;
	private TabHost mTabHost;
	
	//内容Intent
	private Intent embStateIntent;
	private Intent cmdLineIntent;
	private Intent configIntent;
	private Intent moreIntent;
	
	private final static String TAB_TAG_EMBSTATE = "tab_tag_embstate";
	private final static String TAB_TAG_CMDLINE  = "tab_tag_cmdline";
	private final static String TAB_TAG_CONFIG   = "tab_tag_config";
	private final static String TAB_TAG_MORE     = "tab_tag_more";	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/* 设置Activity的背景图片  */
		//getWindow().setBackgroundDrawableResource(R.drawable.background);
        setContentView(R.layout.activity_main);
        mainTab=(RadioGroup)findViewById(R.id.main_tab);
        //mainTab.setOnCheckedChangeListener((android.widget.RadioGroup.OnCheckedChangeListener) this);
        mainTab.setOnCheckedChangeListener(new mRadioGroupListner());
        prepareIntent();
        setupIntent();
	}
	
	
	/**
     * 准备tab的内容Intent
     */
	private void prepareIntent() {
		embStateIntent = new Intent(this, EmbStateActivity.class);
		cmdLineIntent  = new Intent(this, CmdLineActivity.class);
		configIntent   = new Intent(this, ConfigActivity.class);
		moreIntent     = new Intent(this, MoreActivity.class);
	}
	
	private void setupIntent() {
		this.mTabHost=getTabHost();
		TabHost localTabHost=this.mTabHost;
		localTabHost.addTab(buildTabSpec(TAB_TAG_EMBSTATE, R.string.main_embstate, R.drawable.icon_1_n, embStateIntent));
		localTabHost.addTab(buildTabSpec(TAB_TAG_CMDLINE, R.string.main_cmdline, R.drawable.icon_1_n, cmdLineIntent));
		localTabHost.addTab(buildTabSpec(TAB_TAG_CONFIG, R.string.main_config, R.drawable.icon_1_n, configIntent));
		localTabHost.addTab(buildTabSpec(TAB_TAG_MORE, R.string.main_more, R.drawable.icon_5_n, moreIntent));
	}
	/**
	 * 构建TabHost的Tab页
	 * @param tag 标记
	 * @param resLabel 标签
	 * @param resIcon 图标
	 * @param content 该tab展示的内容
	 * @return 一个tab
	 */
	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,final Intent content) {
		return this.mTabHost.newTabSpec(tag).setIndicator(getString(resLabel),
				getResources().getDrawable(resIcon)).setContent(content);
	} 
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.radio_button0:
			this.mTabHost.setCurrentTabByTag(TAB_TAG_EMBSTATE);
			break;
		case R.id.radio_button1:
			this.mTabHost.setCurrentTabByTag(TAB_TAG_CMDLINE);
			break;
		case R.id.radio_button2:
			this.mTabHost.setCurrentTabByTag(TAB_TAG_CONFIG);
			break;
		case R.id.radio_button3:
			this.mTabHost.setCurrentTabByTag(TAB_TAG_MORE);
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public class mRadioGroupListner implements android.widget.RadioGroup.OnCheckedChangeListener{
		@Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
              switch (mainTab.getCheckedRadioButtonId())
            {
               case R.id.radio_button0:
            	  mTabHost.setCurrentTabByTag(TAB_TAG_EMBSTATE);
                  break;
               case R.id.radio_button1:
                  mTabHost.setCurrentTabByTag(TAB_TAG_CMDLINE);
                  break;
               case R.id.radio_button2:
                  mTabHost.setCurrentTabByTag(TAB_TAG_CONFIG);
                  break;
               case R.id.radio_button3:
            	   mTabHost.setCurrentTabByTag(TAB_TAG_MORE);
            	   break;
               default:
                  break;
            }
        }
	}

}
