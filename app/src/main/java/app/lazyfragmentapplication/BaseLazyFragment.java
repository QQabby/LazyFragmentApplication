package app.lazyfragmentapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xuqianqian on 2018/2/28.
 */
public  abstract class BaseLazyFragment extends Fragment {

    protected View mRootView;
    public Context mContext;
    protected boolean isVisible;
    private boolean isPrepared;
    private boolean isLoad = false;

    //最先执行
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {//当前显示
            isVisible = true;
            if(!isLoad){
                lazyLoad();
            }
        } else {
            isVisible = false;
            //onInvisible();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = getLayout();
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isPrepared = true;
        //如果已经加载过了，就无需再重新加载
        if(!isLoad){
            lazyLoad();
        }
    }

    /**
     * 懒加载
     */
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        isLoad = true;
        initData();
    }

//    protected void onInvisible() {
//
//    }
    //初始化布局View
    public abstract View getLayout();

    public abstract void initData();
}
