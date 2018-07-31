package jayt.com.apnabegun.mFragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
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

    // Progress Dialog
    private ProgressDialog pDialog;

    public News() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater myinflater = getLayoutInflater();
        View rootView = inflater.inflate(R.layout.news, container, false);



        listNews = (ListView) rootView.findViewById(R.id.newsListView);
//        ViewGroup myHeader = (ViewGroup)myinflater.inflate(R.layout.news, listNews, false);
//        listNews.addHeaderView(myHeader, null, false);
        new DownloadNews().execute();

        return rootView;
    }

    class DownloadNews extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Loading News ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();

        }
        protected String doInBackground(String... args) {
            String xml = "";

            String urlParameters = "";
            xml = Function.excuteGet("http://34.233.126.33:5000/getresponse/aisehi", urlParameters);

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
            }else{
                System.out.println("loading....");
            }

            return  xml;
        }

        @Override
        protected void onPostExecute(String xml) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();

            // updating UI from Background Thread
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    ImageView image = (ImageView) getActivity().findViewById(R.id.ad_container);
                    image.setImageResource(R.drawable.lotushands);

                    CustomAdapter adapter = new CustomAdapter(getActivity(), dataList);
                    listNews.setAdapter(adapter);

                }
            });
        }
    }

    @Override
    public String toString() {
        String title = "news";
        return title;
    }

}
