package com.aurelhubert.ahbottomnavigation.demo;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DemoActivity extends AppCompatActivity {

	private DemoFragment currentFragment;
	private DemoViewPagerAdapter adapter;
	private AHBottomNavigationAdapter navigationAdapter;
	private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
	private boolean useMenuResource = true;
	private int[] tabColors;
	private Handler handler = new Handler();

	// UI
	private AHBottomNavigationViewPager viewPager;
	private AHBottomNavigation bottomNavigation;
	private FloatingActionButton floatingActionButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		boolean enabledTranslucentNavigation = getSharedPreferences("shared", Context.MODE_PRIVATE)
				.getBoolean("translucentNavigation", false);
		setTheme(R.style.AppTheme_TranslucentNavigation );
		setContentView(R.layout.activity_home);
		AHBottomNavigation navigation = findViewById(R.id.bottom_navigation);
		navigation.setTranslucentNavigationEnabled(true);
		navigation.setColored(true);
		navigation.setDefaultBackgroundColor(Color.GREEN);
		AHBottomNavigationItem item1 = new AHBottomNavigationItem("home",getDrawable(R.drawable.ic_maps_local_bar),Color.GREEN);
		AHBottomNavigationItem item2 = new AHBottomNavigationItem("home2",getDrawable(R.drawable.ic_content_add),Color.RED);
		AHBottomNavigationItem item3 = new AHBottomNavigationItem("home3",getDrawable(R.drawable.ic_maps_place),Color.BLUE);
		navigation.addItems(Arrays.asList(item1,item2,item3));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacksAndMessages(null);
	}
	
	/**
	 * Init UI
	 */

}
