package llapps.com.viewpagecarddemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import llapps.com.viewpagecarddemo.base.BaseVPAdapter;
import llapps.com.viewpagecarddemo.base.VpTranform;
import llapps.com.viewpagecarddemo.util.Constance;

public class MainActivity extends AppCompatActivity {

    int[] iconIds = {R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06, R.drawable.img07, R.drawable.img08};
    @BindView(R.id.viewpage) ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //initView();
        showTilePage();
    }

    //图片的显示
    public void initView(){
        List<Integer> dataList = new ArrayList<>();
        for (int i = 0; i<100; i++){
            dataList.add(iconIds[i%iconIds.length]);
        }
        BaseVPAdapter<Integer> baseVPAdapter = new BaseVPAdapter<Integer>(this, R.layout.item_image, dataList) {
            @Override
            public void bindView(View view, Integer data) {
                ImageView imageView = view.findViewById(R.id.image);
                imageView.setImageResource(data);
            }
        };
        viewPager.setOffscreenPageLimit(4);
        viewPager.setPageTransformer(false, new VpTranform());
        viewPager.setAdapter(baseVPAdapter);

    }

    //带有标题和问题
    public void showTilePage(){
        List<Integer> dataList = new ArrayList<>();
        for (int i = 0; i<100; i++){
            dataList.add(iconIds[i%iconIds.length]);
        }
        BaseVPAdapter<Integer> baseVPAdapter = new BaseVPAdapter<Integer>(this, R.layout.item_page, dataList) {
            @Override
            public void bindView(View view, Integer data) {
                ImageView imageView = view.findViewById(R.id.image);
                imageView.setImageResource(data);
                TextView textView = view.findViewById(R.id.btn_in);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Constance.showToast(MainActivity.this, "哈哈哈，你被骗了 O(∩_∩)O哈哈~");
                    }
                });
            }
        };
        viewPager.setOffscreenPageLimit(4);
        viewPager.setPageTransformer(false, new VpTranform());
        viewPager.setAdapter(baseVPAdapter);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_image:
                initView();
                break;
            case R.id.btn_title:
                showTilePage();
                break;
        }
    }
}
