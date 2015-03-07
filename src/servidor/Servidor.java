package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {

	public static void main(String[] args) throws InterruptedException {
		final int puerto=500;
		ServerSocket socket_servidor;
		Socket socket_conexion;
		DataOutputStream salida;
		boolean corriendo=true;
		
		
		try {
			socket_servidor=new ServerSocket(puerto);
			socket_conexion=new Socket();
			System.out.println("Esperando conexión...");
			socket_conexion=socket_servidor.accept();
			System.out.println("Conexión establecida");
			salida = new DataOutputStream(socket_conexion.getOutputStream());
			while(corriendo){
				Date fecha = new Date();
				SimpleDateFormat formato_fecha = new SimpleDateFormat("HH:mm:ss");
				String hora=formato_fecha.format(fecha);
				salida.writeUTF(hora);
				Thread.sleep(1000);
			}
			socket_conexion.close();
			socket_servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
