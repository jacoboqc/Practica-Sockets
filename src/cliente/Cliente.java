package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		final String host="localhost";
		final int puerto=500;
		Socket socket;
		DataInputStream entrada;
		
		try {
			socket=new Socket(host, puerto);
			System.out.println("Conexión establecida correctamente");
			entrada=new DataInputStream(socket.getInputStream());
			System.out.println(entrada.readUTF());
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
