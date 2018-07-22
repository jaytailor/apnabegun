package jayt.com.apnabegun.mFragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import jayt.com.apnabegun.DetailsActivity;
import jayt.com.apnabegun.R;
import jayt.com.apnabegun.adapter.CustomAdapter;
import jayt.com.apnabegun.common.Function;
import jayt.com.apnabegun.model.NewsItems;

public class News extends Fragment {

    ArrayList<NewsItems> dataList = new ArrayList<NewsItems>();;
    ListView listNews;

    public static final String KEY_ID = "id";
    public static final String KEY_WRITER = "writer";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_ISBREAKING= "is_breaking";
    public static final String KEY_PUBLISHEDAT = "publishedAt";

    public News() {
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        dataList = new ArrayList<HashMap<String, String>>();
//
//        // Loading INBOX in Background Thread
//        new DownloadNews().execute();
//
//
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news, container, false);

        listNews = (ListView) rootView.findViewById(R.id.newsListView);
        new DownloadNews().execute();

        return rootView;
    }

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
                        NewsItems newsitems = new NewsItems();

                        newsitems.setTitle(jsonObject.getString("title"));
                        newsitems.setContent(jsonObject.getString("content"));
                        newsitems.setWriter(jsonObject.getString("writer"));
                        newsitems.setImage(jsonObject.getString("image"));
                        newsitems.setPublished_at(jsonObject.getString("published_at"));
                        dataList.add(i, newsitems);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                CustomAdapter adapter = new CustomAdapter(getActivity(), dataList);
                listNews.setAdapter(adapter);

                listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent i = new Intent(getActivity(), DetailsActivity.class);
                        i.putExtra("image", dataList.get(+position).getImage());
                        i.putExtra("writer", dataList.get(+position).getWriter());
                        i.putExtra("title", dataList.get(+position).getTitle());
                        i.putExtra("content", dataList.get(+position).getContent());
                        startActivity(i);
                    }
                });

            }else{
                System.out.println("aise hi....");
            }
        }
    }

    @Override
    public String toString() {
        String title = "news";
        return title;
    }

}
