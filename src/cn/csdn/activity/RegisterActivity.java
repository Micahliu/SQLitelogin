package cn.csdn.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import cn.csdn.domain.User;
import cn.csdn.service.UserService;

public class RegisterActivity extends Activity {
	EditText username;
	EditText password;
	EditText age;
	RadioGroup sex;	
	Button register;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		findViews();
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=username.getText().toString().trim();
				String pass=password.getText().toString().trim();
				String agestr=age.getText().toString().trim();
				String sexstr=((RadioButton)RegisterActivity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
				Log.i("TAG",name+"_"+pass+"_"+agestr+"_"+sexstr);
				UserService uService=new UserService(RegisterActivity.this);
				User user=new User();
				user.setUsername(name);
				user.setPassword(pass);
				user.setAge(Integer.parseInt(agestr));
				user.setSex(sexstr);
				uService.register(user);
				Toast.makeText(RegisterActivity.this, "×¢²á³É¹¦", Toast.LENGTH_LONG).show();
			}
		});
	}
	private void findViews() {
		username=(EditText) findViewById(R.id.usernameRegister);
		password=(EditText) findViewById(R.id.passwordRegister);
		age=(EditText) findViewById(R.id.ageRegister);
		sex=(RadioGroup) findViewById(R.id.sexRegister);
		register=(Button) findViewById(R.id.Register);
	}

}
