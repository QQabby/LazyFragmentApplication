package app.lazyfragmentapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xuqianqian on 2018/2/28.
 */

public class GankFragment extends BaseLazyFragment {

    String type;
    public static GankFragment newInstance(String type) {
        GankFragment gankFragment = new GankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        gankFragment.setArguments(bundle);
        return gankFragment;
    }

    @Override
    public View getLayout() {

        type = getArguments().getString("type");
        TextView tv = new TextView(getActivity());
        tv.setText(type);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }

    @Override
    public void initData() {

        Toast.makeText(getActivity(),"开始加载数据了....."+type,Toast.LENGTH_SHORT).show();
    }

}
