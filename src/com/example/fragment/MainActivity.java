package com.example.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  {

	/*
	 * fragment有两种加载方式
	 * 1：动态加载，点击事件，执行fragment显示动作，不在布局文件里定义fragment标签内容
	 * 2、静态加载：在activity的布局文件里定义fragmen的存在，activity启动后，fragmnet随之出现，
	 */
	
	private Fragment myfr;
	private Button mainbtn,fragmentbtn;
	private TextView mytext;
	private RelativeLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(NavUtils.getParentActivityName(MainActivity.this) != null);
			getActionBar().setDisplayHomeAsUpEnabled(true);
		initView();
	    layout=(RelativeLayout)findViewById(R.id.activity_main);
		layout.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO 自动生成的方法存根
				int x=(int)event.getX()+1;
				int y=(int)event.getY();
				Toast.makeText(getApplicationContext(),"("+x+","+y+")",Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		mainbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				myfr=new MyFragment();
				FragmentManager frM=getFragmentManager();
				FragmentTransaction myTr=frM.beginTransaction();
				myTr.add(R.id.myfragment,myfr);
				myTr.addToBackStack(null);
				myTr.commit();							
			}
		});
  
		
	}
	private void initView() {
		// TODO 自动生成的方法存根
		
		mainbtn=(Button)findViewById(R.id.manibtn);
		fragmentbtn=(Button)findViewById(R.id.mubtn);
		mytext=(TextView)findViewById(R.id.mytext);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO 自动生成的方法存根
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.main, menu);		
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();;
		return true;
		
	}
//	@Override
//	public boolean onTouch(View v, MotionEvent event) {
//		// TODO 自动生成的方法存根
//		int x=(int)event.getX();
//		int y=(int)event.getY();
//		Toast.makeText(getApplicationContext(),"("+x+","+y+")",Toast.LENGTH_SHORT).show();
//		return true;
//	}
	
	

	
}
