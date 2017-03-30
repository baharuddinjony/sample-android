package com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 2/14/2017.
 */

public class AllWeekTipsActivity extends AppCompatActivity {
  @BindView(R.id.webview) WebView mWebView;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_all_week_tips);
    ButterKnife.bind(this);
    mWebView.loadUrl("file:///android_res/raw/allweektips.htm");
  }
}
