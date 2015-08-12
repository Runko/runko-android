package runko.runkoandroidapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.view.Display;
import android.view.WindowManager;
import android.content.Context;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;

public class RunkoActivity extends android.support.v7.app.ActionBarActivity{

    private WebView myWebView;


    /**
     * When application starts and every time cofiguration changes webframe and  toolbar are rendered
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
        myWebView.getSettings().setUseWideViewPort(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                return false;
            }
        });

        myWebView.loadUrl("http://runko.herokuapp.com");
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
                myWebView.loadUrl("http://runko.herokuapp.com");
                return true;
            case R.id.action_suosikit:
                //puuttuu...
                return true;
            case R.id.action_tilaukset:
                //puuttuu...
                return true;
            case R.id.action_haku:
                //puuttuu...
                return true;
            case R.id.action_tallennukset:
                //puuttuu
                return true;
            case R.id.action_ilmoitukset:
                myWebView.loadUrl("https://runko.herokuapp.com/content/fancyform");
                return true;
            case R.id.action_luo_sisalto:
                myWebView.loadUrl("https://runko.herokuapp.com/content/simpleform");
                return true;
            case R.id.action_luo_alue:
                myWebView.loadUrl("https://runko.herokuapp.com/area/areaform");
                return true;
            case R.id.action_omat_sisallot:
                //puuttuu...
                return true;
            case R.id.action_sign_in:
                myWebView.loadUrl("https://runko.herokuapp.com/login");
                return true;
            case R.id.action_profile:
                myWebView.loadUrl("http://runko.herokuapp.com/persons/profile");
                return true;
            case R.id.action_settings:
                //puuttuu...
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

