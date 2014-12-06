package com.jenuine.lollipopprogressbar;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
	private Typeface tf;
	private ProgressBarLollipopCircular myPogressbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tf = Typeface.createFromAsset(getAssets(),
	            "manteka.ttf");
		tv=(TextView)findViewById(R.id.textView1);
		myPogressbar=(com.jenuine.lollipopprogressbar.ProgressBarLollipopCircular)findViewById(R.id.myPogressbar);
		Thread thread = new Thread() {

			@Override
			public void run() {

				// Block this thread for 5 seconds.
				
				
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
				}
				myPogressbar.setBackgroundColor(Color.parseColor("#f89c2b"));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				myPogressbar.setBackgroundColor(Color.parseColor("#3da3ba"));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				myPogressbar.setBackgroundColor(Color.parseColor("#b53124"));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				myPogressbar.setBackgroundColor(Color.parseColor("#942c8f"));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				// After sleep finished blocking, create a Runnable to run on
				// the UI Thread.
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						findViewById(R.id.myPogressbar)
								.setVisibility(View.INVISIBLE);
						findViewById(R.id.textView1)
						.setVisibility(View.VISIBLE);
						tv.setTypeface(tf);
					}
				});

			}

		};
		thread.start();
	}
}
