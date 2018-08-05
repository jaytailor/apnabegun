package jayt.com.begundarshan.mFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jayt.com.begundarshan.R;

public class Editorial extends Fragment{

    View view;

    public Editorial() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.editorial, container, false);
        return view;
    }
}
