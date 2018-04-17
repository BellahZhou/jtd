package com.jtd.controller;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Server extends WindowAdapter implements ActionListener,KeyListener{
		TextField str_send;
		Label Label;
		TextArea msg;
		Button send,exit;
		Panel p1;

		String hostname;//客户机名
		DatagramSocket receiveSocket,sendSocket;
		DatagramPacket receivePacket,sendPacket;

	public void display() {
		Frame f =new Frame("在线聊天---服务器");
		f.setSize(400,350);
		f.setLocation(400,400);
		f.setBackground(Color.red);
		
		p1=new Panel();
		f.add(p1,"South");
		
		msg=new TextArea();
		msg.setSize(100,250);
		msg.setBackground(Color.white);
		msg.setEditable(false);
		f.add(msg);
		
		Label=new Label("发送消息 ");
		p1.add(Label);
		str_send=new TextField(20);
		p1.add(str_send);
		str_send.addKeyListener(this);
		
		send= new Button("发送 ");
		p1.add(send);
		send.addActionListener(this);
		
		exit= new Button("退出 ");
		p1.add(exit);
		exit.addActionListener(this);
		
		f.addWindowListener(this);
		f.setVisible(true);
		try////设置服务器发送端口
		{
		sendSocket= new DatagramSocket(5000);
		}
		catch(Exception e) {
			msg.append(e+"\n");
		}
	}

	public void receiveMessage(){
		try{
			receiveSocket=new DatagramSocket(3333);
			while(true){
				byte[]buf=new byte[500];
				receivePacket=new DatagramPacket(buf,buf.length);
				//receivePacket=newDatagramPacket(buf,buf.length);
				receiveSocket.receive(receivePacket);
				if(receivePacket.getLength()==0) {
					System.out.println("消息为空!");
					continue;
				}
				ByteArrayInputStream bin=new ByteArrayInputStream(receivePacket.getData());
				////ByteArrayInputStream字节串(或叫字节数组)变成输入流的形式
				BufferedReader reader=new BufferedReader(new InputStreamReader(bin));
				msg.append("客户端："+reader.readLine());
				msg.append("\n");
				reader.close();
				bin.close();
			}
		} catch(Exception e){
			msg.append(e+"\n");
		}
	}


	/*
	public void receiveMessage()
	{
	try
	{
	receiveSocket= new DatagramSocket(3333);
	//寤虹珛绔彛鍙蜂负 3333鐨凞atagramSocket
	while(true)
	{
	byte[]buf = new byte[500];
	receivePacket= new DatagramPacket(buf,buf.length);
	//寤虹珛DatagramPacket瀵硅薄
	//receivePacket= new DatagramPacket(buf,buf.length);
	//寤虹珛DatagramPacket瀵硅薄
	receiveSocket.receive(receivePacket);
	//鎺ユ敹鏁版嵁鎶卞寘
	if(receivePacket.getLength()==0);
	{
	System.out.println("娑堟伅涓虹┖");
	continue;
	}

	ByteArrayInputStreambin = new ByteArrayInputStream(receivePacket.getData());

	BufferedReaderreader = new BufferedReader(new InputStreamReader(bin));
	msg.append("瀹㈡埛绔細 "+reader.readLine());
	msg.append("\n");
	reader.close();
	bin.close();
	}
	}
	catch(Exception e)
	{
	msg.append(e+"\n");
	}
	}*/

	public void sendMessage(){
		try {
			String s=str_send.getText();
			str_send.setText("");
			msg.append("服务器："+s+"\n");
			ByteArrayOutputStream out= new ByteArrayOutputStream();
			PrintStream pout = new PrintStream(out);
			pout.print(s);
			byte buf[]=out.toByteArray();
			//指定数据抱报道数据包长度、目的地址和端口号
			sendPacket=new DatagramPacket(buf,buf.length,
			InetAddress.getByName(hostname),3001);
			sendSocket.send(sendPacket);//
			buf=null;
		} catch(Exception err) {
			msg.append(err+"\n");
		}
	}
	//
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==send){
			sendMessage();
		}
		if(e.getSource()==exit) {
			System.out.println("聊天程序已关闭，再见！\n");
			System.exit(0);
		}
	}
	public void windowClosing(WindowEvent e){
		System.out.println("聊天程序已关闭，再见！\n");
		System.exit(0);
	}
	public void keyPressed(KeyEvent e){
		if(e.getSource()==str_send) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER) {
				sendMessage();//发送数据抱包
			}
		}
	}
	public static void main(String arg[]){
		Server app=new Server();
		app.display();
		app.receiveMessage();
	}
	
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
}