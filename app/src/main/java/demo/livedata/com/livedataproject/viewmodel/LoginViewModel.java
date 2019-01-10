package demo.livedata.com.livedataproject.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import org.reactivestreams.Subscription;

import java.util.List;

import demo.livedata.com.livedataproject.bean.LoginBean;
import demo.livedata.com.livedataproject.model.LocalRepertory.UserReperyory;
import demo.livedata.com.livedataproject.model.LocalRepertory.roomentity.User;
import demo.livedata.com.livedataproject.model.ServiceRepertory.LoginReperyory;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 9:33
 * 修改备注
 */
public class LoginViewModel extends ViewModel{
    private final LoginReperyory repert;
    private final UserReperyory userpert;
    MutableLiveData<String>mutableLiveData;
    MutableLiveData<LoginBean>mutableLoginLiveData;
    MutableLiveData<User> mutableUserLiveData;

    public LoginViewModel() {
        //初始化api
        repert=new LoginReperyory();
        //初始化Room
        userpert=UserReperyory.getInstance();

        // md第一个列子使用
        mutableLiveData=new MutableLiveData<>();
        //初始化liveData
        mutableLoginLiveData=new MutableLiveData<LoginBean>();
        //初始化room
        mutableUserLiveData=new MutableLiveData<User>();

    }

    /**
     * 建立方法 getMutableLiveData
     * 提供数据
     * @return
     */

    public MutableLiveData<String> getMutableLiveData() {
        return mutableLiveData;
    }

    /**
     *  网络请求
     * @return
     */
    public MutableLiveData<LoginBean> getMutableLoginLiveData() {
        return mutableLoginLiveData;
    }

    /**
     *  网络请求
     * @return
     */
    public MutableLiveData<User> getMutableUserLiveData() {
        return mutableUserLiveData;
    }

    public void LoadData(){
        userpert.getUserDao().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<List<User>>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        mutableUserLiveData.setValue(users.get(0));
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void setUser(User user){
        userpert.getUserDao().setUser(user);
    }

    /**
     * 数据库插入操作
     */
    public void insert(final User user){
        new Thread(new Runnable() {
            @Override
            public void run() {
                setUser(user);
                LoadData();
            }
        }).start();
    }

    public void  loadData(){
        repert.LoadLoginData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        mutableLoginLiveData.setValue(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
