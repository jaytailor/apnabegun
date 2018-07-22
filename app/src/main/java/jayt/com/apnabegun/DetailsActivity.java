package jayt.com.apnabegun;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    Context ctx;
    ProgressBar loader;
    String image = "", title = "", content = "", writer="", published_at="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        image = intent.getStringExtra("image");
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        writer = intent.getStringExtra("writer");
        published_at = intent.getStringExtra("published_at");

        TextView title1 = (TextView) findViewById(R.id.title);
        TextView content1 = (TextView) findViewById(R.id.content);
        ImageView image1 = (ImageView) findViewById(R.id.image);
        TextView writer1 = (TextView) findViewById(R.id.detailWriter);
        TextView publishedat1 = (TextView) findViewById(R.id.detailPublishedAt);

        try{
            title1.setText(title);
            content1.setText(content);
            writer1.setText(writer);
            publishedat1.setText(published_at);

            if(image.length() < 5)
            {
                image1.setVisibility(View.GONE);
            }else{
                Picasso.with(this)
                        .load(image)
                        .resize(300, 200)
                        .into(image1);
            }
        }catch(Exception e) {}

    }
}

