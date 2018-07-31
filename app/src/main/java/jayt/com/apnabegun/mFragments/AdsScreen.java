package jayt.com.apnabegun.mFragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import jayt.com.apnabegun.R;
import jayt.com.apnabegun.adapter.AdsAdapter;
import jayt.com.apnabegun.common.Function;
import jayt.com.apnabegun.model.AdsList;

public class AdsScreen extends Fragment {
    View view;
    ArrayList<AdsList> dataList = new ArrayList<AdsList>();;
    ListView listAds;

    // Progress Dialog
    private ProgressDialog pDialog;


    public AdsScreen() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_screen, container, false);
        listAds = (ListView) view.findViewById(R.id.adsListView);
        new DownloadAds().execute();
        return view;
    }


    class DownloadAds extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Loading Ads ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();

        }
        protected String doInBackground(String... args) {
            String xml = "";

            String urlParameters = "";
            xml = Function.excuteGet("http://34.233.126.33:5000/getresponse/aisehiads", urlParameters);

            if(xml.length()>10){ // Just checking if not empty

                try {
                    JSONObject jsonResponse = new JSONObject(xml);
                    JSONArray jsonArray = jsonResponse.optJSONArray("campaigns");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        AdsList adsitems = new AdsList();

                        adsitems.setImageurl(jsonObject.getString("imageurl"));

                        dataList.add(i, adsitems);
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
                    AdsAdapter adapter = new AdsAdapter(getActivity(), dataList);
                    listAds.setAdapter(adapter);

                }
            });
        }
    }

}
