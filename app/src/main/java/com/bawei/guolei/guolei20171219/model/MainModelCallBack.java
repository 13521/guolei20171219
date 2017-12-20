package com.bawei.guolei.guolei20171219.model;

import com.bawei.guolei.guolei20171219.ShopBean;

/**
 * Created by Lenovo on 2017/12/19.
 */

public interface MainModelCallBack {
    public void success(ShopBean bean);
    public void failure(Exception e);
}
