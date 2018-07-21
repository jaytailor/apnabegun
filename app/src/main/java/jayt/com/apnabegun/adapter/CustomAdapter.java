package jayt.com.apnabegun.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import jayt.com.apnabegun.R;
import jayt.com.apnabegun.model.NewsItems;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<NewsItems> newsItems;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context c, ArrayList<NewsItems> newsItems) {
        this.c = c;
        this.newsItems = newsItems;
    }

    @Override
    public int getCount() {
        return newsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return newsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(layoutInflater == null)
        {
            layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.news_items, parent,false);
        }

        TextView newsTitle = (TextView) convertView.findViewById(R.id.newsTitle);
        ImageView newsImg = (ImageView) convertView.findViewById(R.id.newsImage);

        final String title = newsItems.get(position).getTitle();
        String image = newsItems.get(position).getImage();

        newsTitle.setText(title);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,title,Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
