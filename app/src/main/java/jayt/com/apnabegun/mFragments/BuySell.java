package jayt.com.apnabegun.mFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jayt.com.apnabegun.R;

public class BuySell extends Fragment {

    View view;

    public BuySell() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_buy_sell, container, false);
        return view;
    }
}
