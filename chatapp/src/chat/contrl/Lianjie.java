package chat.contrl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import caht.model.Massage;
import caht.model.User;

public class Lianjie {
	
	public static Socket s;
//	建立和服务器的连接
	public Lianjie(){
		try {
			s=new Socket("127.0.0.1",3456);//建立连接
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	接受登录端的信息
	public Massage loginValidate(User user) {
		ObjectOutputStream oos;
		Massage massage=null;
		try {
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
			
//			获取服务器验证结果
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				massage=(Massage)ois.readObject();
			}
		    catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		    }
//		返回验证结果给客户端
		return massage;
		}
	
	}


