package Serverwod.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import caht.model.Massage;
import caht.model.Massageserver;
import caht.model.User;

public class Server implements Massageserver{
	
	ServerSocket ss;
	Socket s;
	HashMap hashmap=new HashMap<String,Socket>();
	String userName;
	
	public Server(){
		
	try {
		
		ss=new ServerSocket(3456);
		System.out.println("�����������������ڼ���3456�˿�......");
		while(true){//������ѭ�����������������������֤
		s=ss.accept();//�ȴ�����
		System.out.println(s);
		
		ObjectInputStream ois;
		
		ois=new ObjectInputStream(s.getInputStream());
		User user=(User)ois.readObject();
		this.userName=user.getUserName();
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		Massage massage=new Massage();
		massage.setSender("server");
		massage.setReceiver(user.getUserName());
//		��������֤���벢��������֤���
		if(user.getPassword().equals("123456")){
			massage.setMassageTap(massage_success);
			
//			��¼�ɹ�֮�󱣴�s
			hashmap.put(userName,s);
//		         ��ν��տͻ��˵�������Ϣ������һ���߳�������
			
		}else{
			massage.setMassageTap(massage_failure);
		}
//		����֤��������ͻ���
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(massage);
		new ServerThread(s).start();

		
		
		}
		
	}catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	}
	public static void main(String[] args) {
		
	}

}