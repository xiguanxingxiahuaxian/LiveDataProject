package demo.livedata.com.livedataproject.application;

import android.app.Application;

import demo.livedata.com.livedataproject.model.LocalRepertory.roomdata.BaseRoom;

/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 14:03
 * 修改备注
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 注册ROOM
        BaseRoom.getInstace(this);
    }
}
