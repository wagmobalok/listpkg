package com.list.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListpkgActivity extends Activity {
	/** Called when the activity is first created. */
	ListView lv1;
	ListView lv2;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		  lv1 = (ListView)findViewById(R.id.listview1);
		  lv2 = (ListView)findViewById(R.id.listview2);
		List<PackageInfo> apps = getPackageManager().getInstalledPackages(0);

		ArrayList<AppInfo> res = new ArrayList<AppInfo>();
		for (int i = 0; i < apps.size(); i++) {
			PackageInfo p = apps.get(i);

			AppInfo newInfo = new AppInfo();
			newInfo.appname = p.applicationInfo.loadLabel(getPackageManager())
					.toString();
			newInfo.pname = p.packageName;
			newInfo.versionName = p.versionName;
			newInfo.versionCode = p.versionCode;
			newInfo.icon = p.applicationInfo.loadIcon(getPackageManager());
			res.add(newInfo);
			
		}
		Toast.makeText(this.getApplicationContext(), Integer.toString(res.size()), 1).show();
		String[] items = new String[res.size()];
		for(int i=0;i<res.size();i++){
			items[i] = res.get(i).appname;
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,items);
		lv1.setAdapter(adapter);
		
		String[] items1 = new String[res.size()]; // changes on 4 june
		for(int i=0;i<res.size();i++){
			items1[i] = res.get(i).pname;
		}
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,items1);
		lv2.setAdapter(adapter1);
	}

	class AppInfo {
		String appname = "";
		String pname = "";
		String versionName = "";
		int versionCode = 0;
		Drawable icon;

	}
}
