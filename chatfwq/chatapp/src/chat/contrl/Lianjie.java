package chat.contrl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import caht.model.User;

public class Lianjie {
	
	Socket s;
//	�����ͷ�����������
	public Lianjie(){
		try {
			s=new Socket("127.0.0.1",3456);//��������
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
//	���ܵ�¼�˵���Ϣ
	public void loginValidate(User user){
		ObjectOutputStream oos;
		
		try {
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}