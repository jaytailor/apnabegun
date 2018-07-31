package jayt.com.apnabegun.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jayt.com.apnabegun.DetailsActivity;
import jayt.com.apnabegun.MainActivity;
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
        TextView content = (TextView) convertView.findViewById(R.id.newsContent);
        TextView published_at = (TextView) convertView.findViewById(R.id.newsPublishedAt);
        ImageView newsImg = (ImageView) convertView.findViewById(R.id.newsImage);

        // Get the values from the newitems model
        final String title = newsItems.get(position).getTitle();
        final String cont = newsItems.get(position).getContent();
        final String wrtr = newsItems.get(position).getWriter();
        final String image = newsItems.get(position).getImage();
        final String publishedat = newsItems.get(position).getPublished_at();

        newsTitle.setText(title);
        content.setText(cont);
        published_at.setText(wrtr);

        if(image.length() < 5)
        {
            newsImg.setVisibility(View.GONE);
        }else{
            Picasso.with(c)
                    .load(image)
                    .resize(300, 200)
                    .into(newsImg);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,title,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(c, DetailsActivity.class);
                i.putExtra("image", image);
                i.putExtra("published_at", publishedat);
                i.putExtra("title", title);
                i.putExtra("content", cont);
                i.putExtra("writer", wrtr);
                c.startActivity(i);
            }
        });

        return convertView;
    }
}
