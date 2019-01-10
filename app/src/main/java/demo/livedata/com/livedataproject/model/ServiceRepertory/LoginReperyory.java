package demo.livedata.com.livedataproject.model.ServiceRepertory;

import com.google.gson.Gson;

import demo.livedata.com.livedataproject.api.LoginService;
import demo.livedata.com.livedataproject.bean.LoginBean;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 10:34
 * 修改备注
 */
public class LoginReperyory {

    private static LoginReperyory loginrepertory;
    private final Retrofit retrofit;

    public LoginReperyory() {
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                /*使用全地址随便加入更地址 没有关系*/
                .baseUrl("http://www.baidu.com")
                .build();
    }

    public static LoginReperyory getInstance() {
        if(loginrepertory==null){
            loginrepertory=new LoginReperyory();
        }
        return loginrepertory;
    }


    /**
     *  LoadLoginData
     * @return
     */
    public Observable<LoginBean> LoadLoginData(){
        Observable<LoginBean> api = retrofit.create(LoginService.class).getNew();
        return api;
    }


}
