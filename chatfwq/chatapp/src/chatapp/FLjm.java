package chatapp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FLjm extends JFrame implements ActionListener,MouseListener{//�����ӿ�
	
//	��ʼ��Ƭ
	JPanel jp01,jp02;
	JButton jb01,jb02,jb03;
//	��һ�ſ�Ƭ
	JPanel myfriendjp;
//	����
	JButton myfriendjb;
//	�в����
	JPanel myfriendlistjp;
	JScrollPane myfriendlistjs;
	public static final int MYFRIENDNUM=51;
	JLabel[] myfriendnumber=new JLabel[MYFRIENDNUM];
//	�ϲ����
	JPanel myfriendotherjp;
	JButton mystringjb,myblackjb;
//	�ڶ��ſ�Ƭ
	JPanel myfriendjp2;
//	�������
	JPanel myfriendlistjp2;
	JButton myfriendjb1,myfriendjb2;
//	�в����
	JPanel mystringlistjp;
	JScrollPane mystringjs;
	public static final int MYSTRING=51;
	JLabel[] mystringnumber=new JLabel[MYSTRING];
//	�ϲ����
	JPanel myblackjp;
	JButton myblackjb1;
//	�����ſ�Ƭ
	JPanel jp1;
//	����
	JPanel jp2;
	JButton jb1,jb2,jb3;
//	�в�
	JScrollPane fjs;
	JPanel jp3;
	public static final int MYBLACKNUMBER=31;
	JLabel[] jl=new JLabel[MYBLACKNUMBER];
//  ����һ����Ƭ����
	CardLayout cardlayout;
//	��������
	String userName;
	public FLjm(String userName){
		this.userName=userName;
//		��ʼ��Ƭ����
		jp01=new JPanel(new BorderLayout());
		jp02=new JPanel(new GridLayout(3,1));
		jb01=new JButton("�ҵĺ���");
		jb01.addActionListener(this);
		jb02=new JButton("�ҵ�İ����");
		jb02.addActionListener(this);
		jb03=new JButton("������");
		jb03.addActionListener(this);
		jp02.add(jb01);jp02.add(jb02);jp02.add(jb03);
		jp01.add(jp02,"North");
//		��һ�ſ�Ƭ����
		myfriendjp=new JPanel(new BorderLayout());
//      ��������
		myfriendjb=new JButton("�ҵĺ���");
		myfriendjb.addActionListener(this);
		myfriendjp.add(myfriendjb,"North");
//		�в�����
		myfriendlistjp=new JPanel(new GridLayout(50,1));
		for(int i=1;i<MYFRIENDNUM;i++){
			myfriendnumber[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);
			myfriendnumber[i].addMouseListener(this);
			myfriendlistjp.add(myfriendnumber[i]);
		}
		
		/*myfriendlistjs.add(myfriendlistjp);(JScrollPaneû�����ִ�������)*/
		
		myfriendlistjs=new JScrollPane(myfriendlistjp);//ֱ���ù��췽������
		myfriendjp.add(myfriendlistjs);
//		�ϲ�����
		myfriendotherjp=new JPanel(new GridLayout(2,1));
		mystringjb=new JButton("�ҵ�İ����");
		mystringjb.addActionListener(this);//���Ӽ�����
		myblackjb=new JButton("������");
		myblackjb.addActionListener(this);
		myfriendotherjp.add(mystringjb);myfriendotherjp.add(myblackjb);
		myfriendjp.add(myfriendotherjp,"South");
		
//		�ڶ��ſ�Ƭ����
		myfriendjp2=new JPanel(new BorderLayout());
//		��������
		myfriendlistjp2=new JPanel(new GridLayout(2,1));
		myfriendjb1=new JButton("�ҵĺ���");
		myfriendjb1.addActionListener(this);//���Ӽ�����
		myfriendjb2=new JButton("�ҵ�İ����");
		myfriendjb2.addActionListener(this);
		myfriendlistjp2.add(myfriendjb1);myfriendlistjp2.add(myfriendjb2);
		myfriendjp2.add(myfriendlistjp2,"North");
//		�в�����
		mystringlistjp=new JPanel(new GridLayout(50,1));
		for(int i=1;i<MYSTRING;i++){
			mystringnumber[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
			mystringnumber[i].addMouseListener(this);
			mystringlistjp.add(mystringnumber[i]);
		}
		mystringjs=new JScrollPane(mystringlistjp);
		myfriendjp2.add(mystringjs);
//		�ϲ�����
		myblackjp=new JPanel(new GridLayout(1,1));
		myblackjb1=new JButton("������");
		myblackjb1.addActionListener(this);
		myblackjp.add(myblackjb1);
		myfriendjp2.add(myblackjp,"South");
//		������������Ƭ
		jp1=new JPanel(new BorderLayout());
//		��������
		jp2=new JPanel(new GridLayout(3,1));
		jb1=new JButton("�ҵĺ���");
		jb1.addActionListener(this);
		jb2=new JButton("�ҵ�İ����");
		jb2.addActionListener(this);
		jb3=new JButton("������");
		jb3.addActionListener(this);
		jp2.add(jb1);jp2.add(jb2);jp2.add(jb3);
		jp1.add(jp2,"North");
//	        �����ϲ�
		jp3=new JPanel(new GridLayout(30,1));
		for(int i=1;i<MYBLACKNUMBER;i++){
			jl[i]=new JLabel(i+"",new ImageIcon("images/yy4.gif"),JLabel.LEFT);
			jl[i].addMouseListener(this);
			jp3.add(jl[i]);
		}
		fjs=new JScrollPane(jp3);
		jp1.add(fjs);
		
//		�������ſ�Ƭ
		cardlayout=new CardLayout();
		this.setLayout(cardlayout);
		this.add(jp01,"0");
		this.add(myfriendjp,"1");
		this.add(myfriendjp2,"2");
		this.add(jp1,"3");
		this.setSize(235,660);
		this.setIconImage(new ImageIcon("images/yy3.gif").getImage());
		this.setTitle(userName+"�ĺ����б�");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
     	/*FLjm FLjm=new FLjm();*/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mystringjb) cardlayout.show(this.getContentPane(),"2");
		if(e.getSource()==myfriendjb1) cardlayout.show(this.getContentPane(), "1");
		if(e.getSource()==myblackjb) cardlayout.show(this.getContentPane(),"3");
		if(e.getSource()==myblackjb1) cardlayout.show(this.getContentPane(),"3");
		if(e.getSource()==jb1) cardlayout.show(this.getContentPane(),"1");
		if(e.getSource()==jb2) cardlayout.show(this.getContentPane(),"2");
		if(e.getSource()==jb01) cardlayout.show(this.getContentPane(),"1");
		if(e.getSource()==jb02) cardlayout.show(this.getContentPane(),"2");
		if(e.getSource()==jb03) cardlayout.show(this.getContentPane(),"3");
		if(e.getSource()==myfriendjb) cardlayout.show(this.getContentPane(),"0");
		if(e.getSource()==myfriendjb2) cardlayout.show(this.getContentPane(),"0");
		if(e.getSource()==jb3) cardlayout.show(this.getContentPane(),"0");
		     
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			JLabel jlb1=(JLabel)e.getSource();
			String receiver=jlb1.getText();//��ȡ�����յ����ı�
			new Chatjm(this.userName/*������*/,receiver/*������*/);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel jla1=(JLabel)e.getSource();
		jla1.setForeground(Color.blue);
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jla1=(JLabel)e.getSource();
		jla1.setForeground(Color.black);
	}
}