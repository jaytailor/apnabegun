package jayt.com.apnabegun.mFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import jayt.com.apnabegun.MainActivity;
import jayt.com.apnabegun.R;
import jayt.com.apnabegun.adapter.CustomAdapter;
import jayt.com.apnabegun.adapter.ListNewsAdapter;
import jayt.com.apnabegun.model.NewsItems;

public class News extends Fragment {

    public News() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news, container, false);

        ListView lv = (ListView) rootView.findViewById(R.id.newsListView);

        CustomAdapter adapter = new CustomAdapter(this.getActivity(), getNews());
        lv.setAdapter(adapter);
        return rootView;
    }

    private ArrayList<NewsItems> getNews() {

        //COLECTION OF news
        ArrayList<NewsItems> news=new ArrayList<>();

        //SINGLE MOVIE
        NewsItems newnews=new NewsItems("1", "a", "b",
                    "c", "d", "false", "today" );

        //ADD ITR TO COLLECTION
        news.add(newnews);

        newnews=new NewsItems("2", "c", "ba",
                "wec", "dwewe", "false", "today" );

        //ADD ITR TO COLLECTION
        news.add(newnews);
        return news;
    }

    @Override
    public String toString() {
        String title = "news";
        return title;
    }


}
