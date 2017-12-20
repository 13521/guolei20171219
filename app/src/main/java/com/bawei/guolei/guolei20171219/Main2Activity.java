package com.bawei.guolei.guolei20171219;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guolei.guolei20171219.adapter.ShopAdapter;
import com.bawei.guolei.guolei20171219.presenter.MainPresenter;
import com.bawei.guolei.guolei20171219.view.MainViewListener;

import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity implements MainViewListener {



    private ShopAdapter adapter;
    private LinearLayoutManager manager;
    private MainPresenter presenter;
    private RecyclerView thirdRecyclerview;
    private CheckBox thirdAllselect;
    private TextView thirdTotalprice;
    private TextView thirdTotalnum;
    private TextView thirdSubmit;
    private LinearLayout thirdPayLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        thirdRecyclerview = findViewById(R.id.third_recyclerview);
        thirdAllselect = findViewById(R.id.third_allselect);
        thirdTotalprice = findViewById(R.id.third_totalprice);
        thirdTotalnum = findViewById(R.id.third_totalnum);
        thirdSubmit = findViewById(R.id.third_submit);
        thirdPayLinear = findViewById(R.id.third_pay_linear);

        presenter = new MainPresenter(this);
        presenter.getData();

        adapter = new ShopAdapter(this);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                thirdAllselect.setChecked(allCheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });
    }

    @Override
    public void success(ShopBean bean) {
        adapter.add(bean);

    }

    @Override
    public void failure(Exception e) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {
        adapter.selectAll(thirdAllselect.isChecked());
    }
}
