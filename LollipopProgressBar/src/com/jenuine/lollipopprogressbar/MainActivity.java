package com.jenuine.lollipopprogressbar;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
	private Typeface tf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tf = Typeface.createFromAsset(getAssets(),
	            "manteka.ttf");
		tv=(TextView)findViewById(R.id.textView1);
		Thread thread = new Thread() {

			@Override
			public void run() {

				// Block this thread for 5 seconds.
				try {
					Thread.sleep(10000);
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
