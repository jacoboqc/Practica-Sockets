package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hilo extends Thread{

	Socket socket_conexion;
	DataOutputStream salida;
	boolean corriendo=true;

	public Hilo(Socket socket_conexion) {
		this.socket_conexion=socket_conexion;
	}

	public void run(){
		try {
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
		} catch (IOException e) {
			System.out.println("Conexión cerrada");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
