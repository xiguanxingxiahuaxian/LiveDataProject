package demo.livedata.com.livedataproject.model.LocalRepertory.roomapi;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import demo.livedata.com.livedataproject.model.LocalRepertory.roomentity.User;
import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 13:45
 * 修改备注
 */
@Dao
public interface UserDAO {

    @Query("SELECT * FROM  user")
    Flowable<List<User>> getData();

    @Insert
    void setUser(User user);

}
