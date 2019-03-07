package ecoChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EcoServer extends Thread {
	public  void run() {
		PrintWriter out;
		
		
		try {
			ServerSocket ss=new ServerSocket(5000);
			System.out.println("server started");
			while(true) {
				Socket sos=ss.accept();
				
				BufferedReader reader=new BufferedReader(new InputStreamReader(sos.getInputStream()));
				String message=reader.readLine();
				System.out.println(message);
				BufferedReader reader1=new BufferedReader(new InputStreamReader(System.in));
				System.err.println("enter the message");
				out=new PrintWriter(sos.getOutputStream(),true);

				out.println("server: "+reader1.readLine());
				//out.println("good morning bro..");
			}



		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EcoServer eco= new EcoServer();
		eco.start();
	}
}
