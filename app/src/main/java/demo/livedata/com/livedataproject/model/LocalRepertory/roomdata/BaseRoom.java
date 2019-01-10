package demo.livedata.com.livedataproject.model.LocalRepertory.roomdata;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import demo.livedata.com.livedataproject.model.LocalRepertory.roomapi.UserDAO;
import demo.livedata.com.livedataproject.model.LocalRepertory.roomentity.User;


/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 13:31
 * 修改备注
 */
@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class BaseRoom extends RoomDatabase{
    private static volatile BaseRoom instace;
    private static final String DATANAME="userdata";

    //进行注册

    public synchronized static BaseRoom getInstace(Context context) {
        if(instace==null){
            instace= Room.databaseBuilder(context,BaseRoom.class,DATANAME)
                    .build();
        }
        return instace;
    }
    public  static BaseRoom getSingleton(){
        return instace;
    }
    public abstract UserDAO userDAO();

}
