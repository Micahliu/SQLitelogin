package cn.csdn.test;

import android.test.AndroidTestCase;
import android.util.Log;
import cn.csdn.domain.User;
import cn.csdn.service.DatabaseHelper;
import cn.csdn.service.UserService;

public class UserTest extends AndroidTestCase {
	public void datatest() throws Throwable{
		DatabaseHelper dbhepler=new DatabaseHelper(this.getContext());
		dbhepler.getReadableDatabase();
	}
	//ע��
	public void registerTest() throws Throwable{	
		UserService uService=new UserService(this.getContext());
		User user=new User();
		user.setUsername("renhaili");
		user.setPassword("123");
		user.setAge(20);
		user.setSex("female");
		uService.register(user);
	}
	public void loginTest() throws Throwable{
		UserService uService=new UserService(this.getContext());
		String username="renhaili";
		String password="123";
		boolean flag=uService.login(username, password);
		if(flag){
			Log.i("TAG","login sucess");
		}else{
			Log.i("TAG","login failure");
		}
	}
	
}
