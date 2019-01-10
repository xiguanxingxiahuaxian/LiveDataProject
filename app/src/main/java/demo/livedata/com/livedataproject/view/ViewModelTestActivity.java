package demo.livedata.com.livedataproject.view;

import android.app.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.security.Provider;

import demo.livedata.com.livedataproject.R;
import demo.livedata.com.livedataproject.viewmodel.LoginViewModel;

/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 9:51
 * 修改备注
 */
public class ViewModelTestActivity extends AppCompatActivity{

    private LoginViewModel model;
    private TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        initView();
    }

    private void initView() {
        content=(TextView)findViewById(R.id.content);


        //点击之后 更改数值
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getMutableLiveData().setValue("sayhello");
            }
        });
        model=ViewModelProviders.of(this).get(LoginViewModel.class);
        Observer<String> ob = new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {
                content.setText(s);
            }
        };
        model.getMutableLiveData().observe(this,ob);


    }
}
