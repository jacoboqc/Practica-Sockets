import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws InterruptedException {
		final int puerto=Integer.parseInt(args[0]);
		ServerSocket socket_servidor = null;
		Socket socket_conexion;
		boolean corriendo=true;
		
		System.out.println("Servidor iniciado\nEsperando conexión...");
		
		try {
			socket_servidor=new ServerSocket(puerto);
			int i=1;
			while(corriendo){
				socket_conexion=new Socket();
				socket_conexion=socket_servidor.accept();
				Hilo hilo=new Hilo(socket_conexion, i);
				i++;
				hilo.start();
			}
			socket_servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
