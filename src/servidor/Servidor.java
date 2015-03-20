package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws InterruptedException {
		final int puerto=Integer.parseInt(args[0]);
		ServerSocket socket_servidor;
		Socket socket_conexion;

		
		
		try {
			socket_servidor=new ServerSocket(puerto);
			socket_conexion=new Socket();
			System.out.println("Esperando conexión...");
			socket_conexion=socket_servidor.accept();
			Hilo hilo=new Hilo(socket_conexion);
			hilo.start();
			socket_servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
