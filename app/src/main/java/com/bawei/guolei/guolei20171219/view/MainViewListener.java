package com.bawei.guolei.guolei20171219.view;

import com.bawei.guolei.guolei20171219.ShopBean;

/**
 * Created by Lenovo on 2017/12/19.
 */

public interface MainViewListener {
    public void success(ShopBean bean);
    public void failure(Exception e);

}
