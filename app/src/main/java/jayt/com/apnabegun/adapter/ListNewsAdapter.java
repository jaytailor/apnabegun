package jayt.com.apnabegun.adapter;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import jayt.com.apnabegun.MainActivity;
import jayt.com.apnabegun.R;

public class ListNewsAdapter extends BaseAdapter {
    private AppCompatActivity activity;
    private ArrayList<HashMap<String, String>> data;

    public ListNewsAdapter(AppCompatActivity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ListNewsViewHolder holder = null;

        if (convertView == null) {
            holder = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.list_row, parent, false);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            holder.author = (TextView) convertView.findViewById(R.id.author);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) convertView.getTag();
        }

        holder.galleryImage.setId(position);
        holder.author.setId(position);
        holder.title.setId(position);
        holder.content.setId(position);
        holder.time.setId(position);

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

//        try{
//            holder.author.setText(song.get(MainActivity.KEY_WRITER));
//            holder.title.setText(song.get(MainActivity.KEY_TITLE));
//            holder.time.setText(song.get(MainActivity.KEY_PUBLISHEDAT));
//            holder.content.setText(song.get(MainActivity.KEY_CONTENT));
//
//            if(song.get(MainActivity.KEY_IMAGE).toString().length() < 5)
//            {
//                holder.galleryImage.setVisibility(View.GONE);
//            }else{
//                Picasso.with(activity)
//                        .load(song.get(MainActivity.KEY_IMAGE).toString())
//                        .resize(300, 200)
//                        .into(holder.galleryImage);
//            }
//        }catch(Exception e) {}
        return convertView;
    }
}

class ListNewsViewHolder {
    ImageView galleryImage;
    TextView author, title, content, time;
}