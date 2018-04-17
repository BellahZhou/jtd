package com.jtd.controller;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends WindowAdapter implements ActionListener,KeyListener{
	TextField str_send;
	Label Label;
	TextArea msg;
	Button send,exit;
	Panel p1;
	DatagramSocket receiveSocket,sendSocket;
	DatagramPacket receivePacket,sendPacket;
public void display(){
	Frame f =new Frame("在线聊天---客户端");
	f.setSize(400,350);
	f.setLocation(100,100);
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
	try////设置客户端发送端口
	{
	sendSocket = new DatagramSocket(3000);
	}
	catch(IOException e)
	{
	msg.append(e+ "\n");
	}
}
public void receiveMessage(){
	try{
		receiveSocket = new DatagramSocket(3001);
		//建立端口号为 3001的DatagramSocket
		while(true){
			byte[] buf = new byte[500];
			receivePacket = new DatagramPacket(buf,buf.length);
			//建立DatagramPacket对象
			receiveSocket.receive(receivePacket);
			//接收数据抱包
			ByteArrayInputStream bin =
			new ByteArrayInputStream(receivePacket.getData());
			BufferedReader reader =new BufferedReader(
			new InputStreamReader(bin));
			msg.append("服务器：" +reader.readLine());
			msg.append("\n");
		}
	}catch(Exception e){
		msg.append(e+"\n");
	}
}
public void sendMessage(){
	try{
		ByteArrayOutputStream bout= new ByteArrayOutputStream();
		PrintStream pout = new PrintStream(bout);
		pout.print(str_send.getText());
		byte buf[]=bout.toByteArray();
		sendPacket=new DatagramPacket(buf,buf.length,
		InetAddress.getByName("localhost"),3333);
		sendSocket.send(sendPacket);//
		msg.append("客户端： "+str_send.getText()+"\n" );
		str_send.setText("");
	}catch(IOException err){
		msg.append(err+"\n");
	}
}
//
public void actionPerformed(ActionEvent e){
	if(e.getSource()==send){
		sendMessage();
	}
	if(e.getSource()==exit){
		System.out.println("聊天程序已关闭，再见！\n");
		System.exit(0);
	}
}
public void windowClosing(WindowEvent e){
	System.out.println("聊天程序已关闭，再见！\n");
	System.exit(0);
}
public void keyPressed(KeyEvent e){
	if(e.getSource()==str_send){
		if(e.getKeyChar()==KeyEvent.VK_ENTER){
		sendMessage();//发送数据抱包
		}
	}
}
public static void main(String arg[]){
	Client client= new Client();
	client.display();
	client.receiveMessage();
}
public void keyTyped(KeyEvent e) {}
public void keyReleased(KeyEvent e) {}
}
