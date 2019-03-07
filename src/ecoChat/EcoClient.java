package ecoChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EcoClient extends Thread{
	public void run() {
		int i=1;
		String message=null;
		BufferedReader reader;
		try {
			System.out.println("client started");

			if(i==1) {
				Socket socket=new Socket("127.0.0.1",5000);
				System.out.println("connection establishedS");
				
				//to send msg
		        reader=new BufferedReader(new InputStreamReader(System.in));
				System.err.println("enter the message: ");
				message=reader.readLine();
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				out.println("client: "+message);

				//to receive msg
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				message=reader.readLine();
				System.out.println(message);
				i=2;
			}

			while(i>1) {
				Socket socket=new Socket("127.0.0.1",5000);
				reader=new BufferedReader(new InputStreamReader(System.in));
				System.err.println("enter the message: ");
				message=reader.readLine();
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				out.println("client: "+message);

				//to receive msg
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				message=reader.readLine();
				System.out.println(message);
				i=2;				
			}

		} catch (Exception e) {

			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		EcoClient client=new EcoClient();
		client.start();
	}
}

