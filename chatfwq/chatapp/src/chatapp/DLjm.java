package chatapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import caht.model.User;
import chat.contrl.Lianjie;

public class DLjm extends JFrame implements ActionListener{
//	�������
	JLabel jl1;
//	�в����
	JTabbedPane jt1;
	JPanel jp1,jp2,jp3;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	JTextField te1;
	JPasswordField pa1;
	JCheckBox jc1,jc2;
//	�ϲ����
	JButton jb1,jb2,jb3;
	JPanel jp4;
//	���췽��
	
	public DLjm(){
//		��������
		jl1=new JLabel(new ImageIcon("images/tou.gif"));
		this.add(jl1,"North");
//		�����в�
		l1=new JLabel("YY����",JLabel.CENTER);te1=new JTextField();
		b2=new JButton(new ImageIcon("images/clear.gif"));
		l2=new JLabel("YY����",JLabel.CENTER);pa1=new JPasswordField();
		l3=new JLabel("��������",JLabel.CENTER);
		l3.setForeground(Color.BLUE);
		jp1=new JPanel(new GridLayout(3,3));
		jc1=new JCheckBox("������¼");jc2=new JCheckBox("��ס����");
		l4=new JLabel("�������뱣��",JLabel.CENTER);
//		�����в����
		jp1.add(l1);jp1.add(te1);jp1.add(b2);
		jp1.add(l2);jp1.add(pa1);jp1.add(l3);
		jp1.add(jc1);jp1.add(jc2);jp1.add(l4);
		jp2=new JPanel();jp3=new JPanel();
		jt1=new JTabbedPane();
		jt1.add(jp1,"YY����");jt1.add(jp2,"�ֻ�����");jt1.add(jp3,"��������");
		this.add(jt1);
//      �����ϲ�
		jb1=new JButton(new ImageIcon("images/denglu.gif"));
		jb1.addActionListener(this);//���Ӽ�����
		jb2=new JButton(new ImageIcon("images/zhuce.gif"));
		jb3=new JButton(new ImageIcon("images/quxiao.gif"));
		jp4=new JPanel();
		jp4.add(jb1);jp4.add(jb2);jp4.add(jb3);
		this.add(jp4,"South");
//		�༭������ʾ����
		this.setSize(350,240);
		this.setTitle("CHAT��¼");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		DLjm DLjm=new DLjm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			String userName=te1.getText();
			String password=new String(pa1.getPassword());
			User user=new User();
			user.setUserName(userName);
			user.setPassword(password);
			
//			������֤
			new Lianjie().loginValidate(user);//Ҫ��������˺Ŵ��͵����Ӷ˵�loginValidate
			
			new FLjm(userName);
			this.dispose();
		}
	}


}