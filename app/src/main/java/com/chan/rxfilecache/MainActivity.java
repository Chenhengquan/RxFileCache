package com.chan.rxfilecache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.chan.rxcache.ACache;
import com.chan.rxcache.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : ChenHengQuan
 * Time : 2017/4/28.
 * Email : nullpointerchan@163.com
 * Desc :
 * version : v1.0
 */
public class MainActivity extends AppCompatActivity {

    private ACache aCache;
    private String cacheStr = "cacheStr";
    private static String CACHE_KEY = "CACHE_KEY";
    private static String USER_CACHE_KEY = "USER_CACHE_KEY";
    private static String LIST_CACHE_KEY = "LIST_CACHE_KEY";
    private TextView tvCache;
    private TextView tvUserCache;
    private TextView tvListCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aCache = ACache.get(this);
        tvCache = (TextView) findViewById(R.id.tv_cache);
        tvUserCache = (TextView) findViewById(R.id.tv_user_cache);
        tvListCache = (TextView) findViewById(R.id.tv_list_cache);

        // 同步获取数据
        String cache = aCache.getAsString(CACHE_KEY);
        if (!StringUtil.isEmpty(cache)) {
            tvCache.setText(cache);
        }
        // 异步获取数据
//        aCache.getAsString(CACHE_KEY, new ACache.SPResultListener<String>() {
//            @Override
//            public void onResult(String cache) {
//                tvCache.setText(cache);
//            }
//        });
        // 同步获取数据
        UserBean bean = aCache.getAsJSONBean(USER_CACHE_KEY, UserBean.class);
        if (bean != null) {
            tvUserCache.setText(bean.toString());
        }
        // 异步获取数据
//        aCache.getAsJSONBean(USER_CACHE_KEY, UserBean.class, new ACache.SPResultListener<UserBean>() {
//            @Override
//            public void onResult(UserBean userBean) {
//                tvCache.setText(userBean.toString());
//            }
//        });


        // 同步获取数据
        //   List<String> listBean = aCache.getAsListBean(LIST_CACHE_KEY, String[].class);
        // 异步获取数据
        aCache.getAsListBean(LIST_CACHE_KEY, String[].class, new ACache.SPResultListener<List<String>>() {
            @Override
            public void onResult(List<String> list) {
                tvListCache.setText(list.toString());

            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_cache:
                aCache.put(CACHE_KEY, cacheStr);
                break;
            case R.id.btn_add_user_cache:
                aCache.put(USER_CACHE_KEY, new UserBean("RxChan", 25));
                break;
            case R.id.btn_add_list_cache:
                aCache.put(LIST_CACHE_KEY, getList());
                break;
            case R.id.btn_remove_cache:
                aCache.remove(CACHE_KEY);
                break;
            case R.id.btn_remove_user_cache:
                aCache.remove(USER_CACHE_KEY);
                break;
            case R.id.btn_remove_list_cache:
                aCache.remove(LIST_CACHE_KEY);
                break;
        }
    }

    public List<String> getList() {
        ArrayList<String> cacheList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            cacheList.add(cacheStr + i);
        }

        return cacheList;
    }
}
