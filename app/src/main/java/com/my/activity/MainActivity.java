package com.my.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.my.R;
import com.my.adapter.MyAdapter;
import com.my.bean.SimpleData;
import com.my.dialog.PhotoDialog;
import com.my.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String img1 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3933355596,669391437&fm=26&gp=0.jpg";
    private String img2 = "http://img4.imgtn.bdimg.com/it/u=1445674920,12445384&fm=26&gp=0.jpg";
    private String img3 = "http://img4.imgtn.bdimg.com/it/u=482593725,2192787331&fm=26&gp=0.jpg";
    private String img4 = "http://img5.imgtn.bdimg.com/it/u=2306608262,3534874273&fm=26&gp=0.jpg";
    private String img5 = "http://img3.imgtn.bdimg.com/it/u=1827863856,2661023953&fm=26&gp=0.jpg";
    private String img6 = "http://img0.imgtn.bdimg.com/it/u=2775335106,966369936&fm=26&gp=0.jpg";
    private String img7 = "http://img4.imgtn.bdimg.com/it/u=1881496596,2607061598&fm=26&gp=0.jpg";
    private String img8 = "http://img2.imgtn.bdimg.com/it/u=3129434724,2523766044&fm=26&gp=0.jpg";
    private String img9 = "http://img0.imgtn.bdimg.com/it/u=1199886885,3035315889&fm=26&gp=0.jpg";

    private String img10 = "http://img3.imgtn.bdimg.com/it/u=2911588266,3715444639&fm=26&gp=0.jpg";
    private String img11 = "http://img2.imgtn.bdimg.com/it/u=1823088812,4234717774&fm=26&gp=0.jpg";
    private String img12 = "http://img0.imgtn.bdimg.com/it/u=1196506210,3510975282&fm=26&gp=0.jpg";
    private String img13 = "http://fms.news.cn/swf/2019_qmtt/10_8_2019_qm_z/images/5.jpg";

    private ArrayList<String> imageData = new ArrayList<>();
    private List<SimpleData> datas = new ArrayList<>();
    private MyAdapter adapter;
    private ImageView ivMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        initListener();
    }

    private void initData() {
        SimpleData data = new SimpleData();
        data.setTitle("秒速5厘米");
        imageData.add(img1);
        imageData.add(img2);
        imageData.add(img3);
        imageData.add(img4);
        imageData.add(img5);
        imageData.add(img6);
        imageData.add(img7);
        imageData.add(img8);
        imageData.add(img9);
        data.setImgs(imageData);

        datas.add(0, data);

        SimpleData data2 = new SimpleData();
        data2.setTitle("EVA");
        ArrayList<String> childData = new ArrayList<>();
        childData.add(img10);
        childData.add(img11);
        childData.add(img12);
        childData.add(img13);
        data2.setImgs(childData);

        datas.add(1, data2);

    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(datas);
    }

    private void initListener() {
        adapter.setCallBack(new MyAdapter.OnMyAdapterCallBack() {
            @Override
            public void onItemClick(int position, ArrayList<String> itemImgs) {
                Bundle bundle = new Bundle();
                ArrayList<String> data = new ArrayList<>();
                data.addAll(itemImgs);
                bundle.putInt("currentPostion", position);
                bundle.putStringArrayList("imageData", itemImgs);

                PhotoDialog photoDialog = new PhotoDialog();
                photoDialog.setArguments(bundle);
                photoDialog.show(getSupportFragmentManager(), "");
            }
        });
    }
}
