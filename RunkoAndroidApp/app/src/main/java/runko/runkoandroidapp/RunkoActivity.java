package runko.runkoandroidapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;

public class RunkoActivity extends android.support.v7.app.ActionBarActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myWebView = (WebView) findViewById(R.id.web_frame);
       // myWebView.getSettings().setJavaScriptEnabled(true);
        //myWebView.getSettings().setLoadWithOverviewMode(true);
        //myWebView.getSettings().setUseWideViewPort(true);
        myWebView.loadUrl("runko.herokuapp.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

            switch (item.getItemId()) {
                case R.id.action_main_window:
                    ActionBarActivity.gotoMain();
                    return true;
                case R.id.action_content:
                    ActionBarActivity.openContent();
                    return true;
                case R.id.action_manager:
                    ActionBarActivity.openManager();
                    return true;
                case R.id.action_user:
                    ActionBarActivity.openUserSettings();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
    }
}

