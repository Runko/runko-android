package runko.runkoandroidapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;


public class RunkoActivity extends android.support.v7.app.ActionBarActivity{

    private WebView myWebView;
    // NOTE: the content of this path will be deleted
    //       when the application is uninstalled (Android 2.2 and higher)
    protected File extStorageAppBasePath;

    protected File extStorageAppCachePath;

    /**
     * When application starts and every time configuration changes web frame and  toolbar are rendered
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myWebView = (WebView) findViewById(R.id.web_frame);
        myWebView.setPadding(0, 0, 0, 0);
        myWebView.setInitialScale(1);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        /* only portrait view */
        myWebView.getSettings().setUseWideViewPort(true);
        /* prevent opening browser */
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        
        myWebView.getSettings().setJavaScriptEnabled(true);


        myWebView.loadUrl(getString(R.string.link_runko));
    }

    /**
     * Returns activity bar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_action, menu);
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * Returns view on selected activity bar's menu items
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_main_window:
                myWebView.loadUrl(getString(R.string.link_runko)+getString(R.string.link_frontpage));
                return true;
            case R.id.action_RUNKO_sisalto:
                myWebView.loadUrl(getString(R.string.link_runko));
                return true;
            case R.id.action_kirjanmerkit:
                myWebView.loadUrl(getString(R.string.link_runko)+getString(R.string.link_bookmark));
                return true;
            case R.id.action_luo_sisalto:
                myWebView.loadUrl(getString(R.string.link_runko)+getString(R.string.link_contentform));
                return true;
            case R.id.action_luo_alue:
                myWebView.loadUrl(getString(R.string.link_runko)+getString(R.string.link_areaform));
                return true;
            case R.id.action_sisallon_hallinta:
                myWebView.loadUrl(getString(R.string.link_runko)+getString(R.string.link_content_manager));
                return true;
            case R.id.action_sign_in:
                myWebView.loadUrl(getString(R.string.link_runko)+getString(R.string.link_login));
                return true;
            case R.id.action_profile:
                myWebView.loadUrl(getString(R.string.link_runko)+getString(R.string.link_profile));
                return true;
           /* case R.id.action_offline_files:
                return true;
            case R.id.action_save:
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

