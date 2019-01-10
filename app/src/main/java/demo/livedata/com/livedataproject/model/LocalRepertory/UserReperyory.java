package demo.livedata.com.livedataproject.model.LocalRepertory;

import demo.livedata.com.livedataproject.model.LocalRepertory.roomapi.UserDAO;
import demo.livedata.com.livedataproject.model.LocalRepertory.roomdata.BaseRoom;


/**
 * 项目名称：LiveDataProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2019/1/9 10:34
 * 修改备注
 */
public class UserReperyory {


    private static UserReperyory loginrepertory;

    public UserReperyory() {

    }

    public static UserReperyory getInstance() {
        if(loginrepertory==null){
            loginrepertory=new UserReperyory();
        }
        return loginrepertory;
    }
    public UserDAO getUserDao(){
        UserDAO data = BaseRoom.getSingleton().userDAO();
        return  data;
    }
}
