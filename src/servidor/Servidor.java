package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		final int puerto=500;
		ServerSocket socket_servidor;
		Socket socket_conexion;
		DataOutputStream salida;
		
		
		try {
			socket_servidor=new ServerSocket(puerto);
			socket_conexion=new Socket();
			System.out.println("Esperando conexión...");
			socket_conexion=socket_servidor.accept();
			System.out.println("Conexión establecida");
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
