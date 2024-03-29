package chatapp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FLjm extends JFrame implements ActionListener,MouseListener{//创建接口
	
//	初始卡片
	JPanel jp01,jp02;
	JButton jb01,jb02,jb03;
//	第一张卡片
	JPanel myfriendjp;
//	北部
	JButton myfriendjb;
//	中部组件
	JPanel myfriendlistjp;
	JScrollPane myfriendlistjs;
	public static final int MYFRIENDNUM=51;
	JLabel[] myfriendnumber=new JLabel[MYFRIENDNUM];
//	南部组件
	JPanel myfriendotherjp;
	JButton mystringjb,myblackjb;
//	第二张卡片
	JPanel myfriendjp2;
//	北部组件
	JPanel myfriendlistjp2;
	JButton myfriendjb1,myfriendjb2;
//	中部组件
	JPanel mystringlistjp;
	JScrollPane mystringjs;
	public static final int MYSTRING=51;
	JLabel[] mystringnumber=new JLabel[MYSTRING];
//	南部组件
	JPanel myblackjp;
	JButton myblackjb1;
//	第三张卡片
	JPanel jp1;
//	北部
	JPanel jp2;
	JButton jb1,jb2,jb3;
//	中部
	JScrollPane fjs;
	JPanel jp3;
	public static final int MYBLACKNUMBER=31;
	JLabel[] jl=new JLabel[MYBLACKNUMBER];
//  创建一个卡片变量
	CardLayout cardlayout;
//	创建方法
	String userName;
	public FLjm(String userName){
		this.userName=userName;
//		初始卡片创建
		jp01=new JPanel(new BorderLayout());
		jp02=new JPanel(new GridLayout(3,1));
		jb01=new JButton("我的好友");
		jb01.addActionListener(this);
		jb02=new JButton("我的陌生人");
		jb02.addActionListener(this);
		jb03=new JButton("黑名单");
		jb03.addActionListener(this);
		jp02.add(jb01);jp02.add(jb02);jp02.add(jb03);
		jp01.add(jp02,"North");
//		第一张卡片创建
		myfriendjp=new JPanel(new BorderLayout());
//      北部创建
		myfriendjb=new JButton("我的好友");
		myfriendjb.addActionListener(this);
		myfriendjp.add(myfriendjb,"North");
//		中部创建
		myfriendlistjp=new JPanel(new GridLayout(50,1));
		for(int i=1;i<MYFRIENDNUM;i++){
			myfriendnumber[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);
			myfriendnumber[i].addMouseListener(this);
			myfriendlistjp.add(myfriendnumber[i]);
		}
		
		/*myfriendlistjs.add(myfriendlistjp);(JScrollPane没有这种创建方法)*/
		
		myfriendlistjs=new JScrollPane(myfriendlistjp);//直接用构造方法创建
		myfriendjp.add(myfriendlistjs);
//		南部创建
		myfriendotherjp=new JPanel(new GridLayout(2,1));
		mystringjb=new JButton("我的陌生人");
		mystringjb.addActionListener(this);//添加监听器
		myblackjb=new JButton("黑名单");
		myblackjb.addActionListener(this);
		myfriendotherjp.add(mystringjb);myfriendotherjp.add(myblackjb);
		myfriendjp.add(myfriendotherjp,"South");
		
//		第二张卡片创建
		myfriendjp2=new JPanel(new BorderLayout());
//		北部创建
		myfriendlistjp2=new JPanel(new GridLayout(2,1));
		myfriendjb1=new JButton("我的好友");
		myfriendjb1.addActionListener(this);//添加监听器
		myfriendjb2=new JButton("我的陌生人");
		myfriendjb2.addActionListener(this);
		myfriendlistjp2.add(myfriendjb1);myfriendlistjp2.add(myfriendjb2);
		myfriendjp2.add(myfriendlistjp2,"North");
//		中部创建
		mystringlistjp=new JPanel(new GridLayout(50,1));
		for(int i=1;i<MYSTRING;i++){
			mystringnumber[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
			mystringnumber[i].addMouseListener(this);
			mystringlistjp.add(mystringnumber[i]);
		}
		mystringjs=new JScrollPane(mystringlistjp);
		myfriendjp2.add(mystringjs);
//		南部创建
		myblackjp=new JPanel(new GridLayout(1,1));
		myblackjb1=new JButton("黑名单");
		myblackjb1.addActionListener(this);
		myblackjp.add(myblackjb1);
		myfriendjp2.add(myblackjp,"South");
//		创建第三个卡片
		jp1=new JPanel(new BorderLayout());
//		创建北部
		jp2=new JPanel(new GridLayout(3,1));
		jb1=new JButton("我的好友");
		jb1.addActionListener(this);
		jb2=new JButton("我的陌生人");
		jb2.addActionListener(this);
		jb3=new JButton("黑名单");
		jb3.addActionListener(this);
		jp2.add(jb1);jp2.add(jb2);jp2.add(jb3);
		jp1.add(jp2,"North");
//	        创建南部
		jp3=new JPanel(new GridLayout(30,1));
		for(int i=1;i<MYBLACKNUMBER;i++){
			jl[i]=new JLabel(i+"",new ImageIcon("images/yy4.gif"),JLabel.LEFT);
			jl[i].addMouseListener(this);
			jp3.add(jl[i]);
		}
		fjs=new JScrollPane(jp3);
		jp1.add(fjs);
		
//		添加四张卡片
		cardlayout=new CardLayout();
		this.setLayout(cardlayout);
		this.add(jp01,"0");
		this.add(myfriendjp,"1");
		this.add(myfriendjp2,"2");
		this.add(jp1,"3");
		this.setSize(235,660);
		this.setIconImage(new ImageIcon("images/yy3.gif").getImage());
		this.setTitle(userName+"的好友列表");
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
			String receiver=jlb1.getText();//提取鼠标接收到的文本
			new Chatjm(this.userName/*发送者*/,receiver/*接收者*/);
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
		jla1.setForeground(Color.red);
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jla1=(JLabel)e.getSource();
		jla1.setForeground(Color.black);
	}
}
