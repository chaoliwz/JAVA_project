package chatapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

import javax.swing.*;

import caht.model.Massage;
import chat.contrl.Lianjie;

public class Chatjm extends JFrame implements ActionListener{
	JPanel chatjp;
	JButton fs;
	JTextArea jm;
	JTextField sr;
	JScrollPane js;
	String sender;
	String receiver;
	
	public Chatjm(String sender,String receiver/*定义发送者和接收者的两个参数*/){
		this.sender=sender;
		this.receiver=receiver;
		
		chatjp=new JPanel();
		fs=new JButton("发送");
		fs.addActionListener(this);
		jm=new JTextArea();
		jm.setEditable(false);
		jm.setForeground(Color.red);
		sr=new JTextField(15);
		js=new JScrollPane(jm);
		this.add(js,"Center");
		chatjp.add(sr);
		chatjp.add(fs);
		
		this.add(chatjp,"South");
		this.setTitle(sender+"正在和"+receiver+"聊天");
		this.setSize(550,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
//		Chatjm Chatjm=new Chatjm();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fs){
			String information=sr.getText();
			jm.append(information+"\r\n");
			ObjectOutputStream oos;
			Massage massage;
			massage=new Massage();
			massage.setSender(this.sender);
			massage.setReceiver(this.receiver);
			massage.setCenter(information);
			try {
				oos=new ObjectOutputStream(Lianjie.s.getOutputStream());
				oos.writeObject(massage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
			
		
	}


	

}
