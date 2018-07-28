package jayt.com.apnabegun;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;


import jayt.com.apnabegun.adapter.ViewPagerAdapter;
import jayt.com.apnabegun.common.Function;
import jayt.com.apnabegun.mFragments.AdsScreen;
import jayt.com.apnabegun.mFragments.BuySell;
import jayt.com.apnabegun.mFragments.Editorial;
import jayt.com.apnabegun.mFragments.News;
import jayt.com.apnabegun.mFragments.Videos;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TABLAYOUT
        tabLayout= (TabLayout) findViewById(R.id.tablayoutid);

        //VIEWPAGER
        vp= (ViewPager) findViewById(R.id.viewpager_id);
        this.addPages();

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
    }

    private void addPages()
    {
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new News(), "समाचार");
        pagerAdapter.addFragment(new Editorial(), "संपादकीय");
        pagerAdapter.addFragment(new BuySell(), "ख़रीदे बेचे");
        pagerAdapter.addFragment(new AdsScreen(), "विज्ञापन");
        pagerAdapter.addFragment(new AdsScreen(), "राशिफ़ल");
        pagerAdapter.addFragment(new Videos(), "वीडियो");

        //SET ADAPTER TO VP
        vp.setAdapter(pagerAdapter);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }

    public void initAdView() {
        ImageView adViewContainer = (ImageView) findViewById(R.id.ad_container);
        adViewContainer.setImageResource(R.drawable.lotushands);
    }
//    private TabLayout tabLayout;
//    private AppBarLayout appBarLayout;
//    private ViewPager viewPager;
//    public static AppCompatActivity act;
//    ProgressBar loader;
//    public static ListView listNews;
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
//    }


}
