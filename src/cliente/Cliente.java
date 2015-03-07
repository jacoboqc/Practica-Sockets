package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		final String host="localhost";
		final int puerto=500;
		Socket sc;
		DataInputStream entrada;
		
		try {
			sc=new Socket(host, puerto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
