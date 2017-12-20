package com.bawei.guolei.guolei20171219.model;

import com.bawei.guolei.guolei20171219.ShopBean;
import com.bawei.guolei.guolei20171219.okHttp.AbstractUiCallBack;
import com.bawei.guolei.guolei20171219.okHttp.OkhttpUtils;

/**
 * Created by Lenovo on 2017/12/19.
 */

public class MainModel {
    public void getData(final MainModelCallBack callBack){




        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean bean) {


                callBack.success(bean);
            }


            @Override
            public void failure(Exception e) {


                callBack.failure(e);
            }
        });


    }

}
