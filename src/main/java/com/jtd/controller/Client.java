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
	Frame f =new Frame("��������---�ͻ���");
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
	
	Label=new Label("������Ϣ ");
	p1.add(Label);
	str_send=new TextField(20);
	p1.add(str_send);
	str_send.addKeyListener(this);
	
	send= new Button("���� ");
	p1.add(send);
	send.addActionListener(this);
	
	exit= new Button("�˳� ");
	p1.add(exit);
	exit.addActionListener(this);
	f.addWindowListener(this);
	f.setVisible(true);
	try////���ÿͻ��˷��Ͷ˿�
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
		//�����˿ں�Ϊ 3001��DatagramSocket
		while(true){
			byte[] buf = new byte[500];
			receivePacket = new DatagramPacket(buf,buf.length);
			//����DatagramPacket����
			receiveSocket.receive(receivePacket);
			//�������ݱ���
			ByteArrayInputStream bin =
			new ByteArrayInputStream(receivePacket.getData());
			BufferedReader reader =new BufferedReader(
			new InputStreamReader(bin));
			msg.append("��������" +reader.readLine());
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
		msg.append("�ͻ��ˣ� "+str_send.getText()+"\n" );
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
		System.out.println("��������ѹرգ��ټ���\n");
		System.exit(0);
	}
}
public void windowClosing(WindowEvent e){
	System.out.println("��������ѹرգ��ټ���\n");
	System.exit(0);
}
public void keyPressed(KeyEvent e){
	if(e.getSource()==str_send){
		if(e.getKeyChar()==KeyEvent.VK_ENTER){
		sendMessage();//�������ݱ���
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
