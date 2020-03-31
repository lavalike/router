package com.wangzhen.router.demo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.wangzhen.router.Router;

/**
 * Router示例
 * Created by wangzhen on 2020/3/31.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openScheme(View view) {
        Router.with(this).toPath("/scheme");
    }
}
