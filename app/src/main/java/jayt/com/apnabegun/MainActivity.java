package jayt.com.apnabegun;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import jayt.com.apnabegun.adapter.ViewPagerAdapter;
import jayt.com.apnabegun.adapter.ListNewsAdapter;
import jayt.com.apnabegun.common.Function;
import jayt.com.apnabegun.mFragments.AdsScreen;
import jayt.com.apnabegun.mFragments.BuySell;
import jayt.com.apnabegun.mFragments.News;
import jayt.com.apnabegun.mFragments.Videos;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    ViewPager vp;
    TabLayout tabLayout;

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //VIEWPAGER
        vp= (ViewPager) findViewById(R.id.viewpager_id);
        this.addPages();

        //TABLAYOUT
        tabLayout= (TabLayout) findViewById(R.id.tablayoutid);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.addOnTabSelectedListener(this);

    }

    private void addPages()
    {
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new News(), "News");
        pagerAdapter.addFragment(new BuySell(), "BuySell");
        pagerAdapter.addFragment(new AdsScreen(), "Ads");
        pagerAdapter.addFragment(new Videos(), "Videos");

        //SET ADAPTER TO VP
        vp.setAdapter(pagerAdapter);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


//    private TabLayout tabLayout;
//    private AppBarLayout appBarLayout;
//    private ViewPager viewPager;
//    public static AppCompatActivity act;
//    ProgressBar loader;
//    public static ListView listNews;
//
//    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
//    public static final String KEY_ID = "id";
//    public static final String KEY_WRITER = "writer";
//    public static final String KEY_TITLE = "title";
//    public static final String KEY_CONTENT = "content";
//    public static final String KEY_IMAGE = "image";
//    public static final String KEY_ISBREAKING= "is_breaking";
//    public static final String KEY_PUBLISHEDAT = "publishedAt";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        tabLayout = (TabLayout) findViewById(R.id.tablayoutid);
//        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
//        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
//        listNews = (ListView) findViewById(R.id.listNews);
//        loader = (ProgressBar) findViewById(R.id.loader);
//        listNews.setEmptyView(loader);
//
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//
//        // Adding the fragments
//        viewPagerAdapter.AddFragment(new News(), "Read News");
//        viewPagerAdapter.AddFragment(new BuySell(), "Buy or Sell");
//        viewPagerAdapter.AddFragment(new AdsScreen(), "See an Ad");
//        viewPagerAdapter.AddFragment(new Videos(), "Watch Videos");
//
//        // Adapter setup
//        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager, true);
//
//        if(Function.isNetworkAvailable(getApplicationContext()))
//        {
//            DownloadNews newsTask = new DownloadNews();
//            newsTask.execute();
//        }else{
//            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
//        }
//    }

    class DownloadNews extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String... args) {
            String xml = "";

            String urlParameters = "";
            xml = Function.excuteGet("http://34.233.126.33:5000/getresponse/appnexus", urlParameters);
            return  xml;
        }
        @Override
        protected void onPostExecute(String xml) {

            if(xml.length()>10){ // Just checking if not empty

                try {
                    JSONObject jsonResponse = new JSONObject(xml);
                    JSONArray jsonArray = jsonResponse.optJSONArray("newsitems");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        HashMap<String, String> map = new HashMap<String, String>();
//                        map.put(KEY_WRITER, jsonObject.optString(KEY_WRITER).toString());
//                        map.put(KEY_TITLE, jsonObject.optString(KEY_TITLE).toString());
//                        map.put(KEY_CONTENT, jsonObject.optString(KEY_CONTENT).toString());
//                        map.put(KEY_IMAGE, jsonObject.optString(KEY_IMAGE).toString());
//                        map.put(KEY_ISBREAKING, jsonObject.optString(KEY_ISBREAKING).toString());
//                        map.put(KEY_PUBLISHEDAT, jsonObject.optString(KEY_PUBLISHEDAT).toString());
//                        dataList.add(map);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Unexpected error", Toast.LENGTH_SHORT).show();
                }


//                ListNewsAdapter adapter = new ListNewsAdapter(MainActivity.this, dataList);
//                listNews.setAdapter(adapter);
//
//                listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    public void onItemClick(AdapterView<?> parent, View view,
//                                            int position, long id) {
//                        Intent i = new Intent(MainActivity.this, DetailsActivity.class);
//                        i.putExtra("image", dataList.get(+position).get(KEY_IMAGE));
//                        i.putExtra("title", dataList.get(+position).get(KEY_TITLE));
//                        i.putExtra("content", dataList.get(+position).get(KEY_CONTENT));
//                        startActivity(i);
//                    }
//                });

            }else{
                Toast.makeText(getApplicationContext(), "No news found", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
