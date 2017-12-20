package com.bawei.guolei.guolei20171219.presenter;

import com.bawei.guolei.guolei20171219.ShopBean;
import com.bawei.guolei.guolei20171219.model.MainModel;
import com.bawei.guolei.guolei20171219.model.MainModelCallBack;
import com.bawei.guolei.guolei20171219.view.MainViewListener;

/**
 * Created by Lenovo on 2017/12/19.
 */

public class MainPresenter {
    private MainViewListener listener;
    private MainModel mainModel;

    public MainPresenter(MainViewListener listener) {
        this.listener = listener;
        this.mainModel = new MainModel();
    }


    public void getData() {


        mainModel.getData(new MainModelCallBack() {


            @Override
            public void success(ShopBean bean) {


                if (listener != null) {
                    listener.success(bean);
                }


            }


            @Override
            public void failure(Exception e) {


                if (listener != null) {
                    listener.failure(e);
                }
            }
        });
    }


    /**
     * 防止内存泄漏
     */
    public void detach() {
        listener = null;
    }
}
