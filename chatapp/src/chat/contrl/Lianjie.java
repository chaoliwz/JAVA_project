package chat.contrl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import caht.model.Massage;
import caht.model.User;

public class Lianjie {
	
	public static Socket s;
//	�����ͷ�����������
	public Lianjie(){
		try {
			s=new Socket("127.0.0.1",3456);//��������
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	���ܵ�¼�˵���Ϣ
	public Massage loginValidate(User user) {
		ObjectOutputStream oos;
		Massage massage=null;
		try {
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
			
//			��ȡ��������֤���
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				massage=(Massage)ois.readObject();
			}
		    catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		    }
//		������֤������ͻ���
		return massage;
		}
	
	}

