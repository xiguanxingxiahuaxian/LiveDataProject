package demo.livedata.com.livedataproject.api;

import demo.livedata.com.livedataproject.bean.LoginBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 10:38
 * 修改备注
 */
public interface LoginService {

    @GET("https://cn.bing.com/HPImageArchive.aspx?format=js&idx=1&n=1")
    Observable<LoginBean> getNew();
}
