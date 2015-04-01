import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hilo extends Thread{

	Socket socket_conexion;
	int num_conex;
	boolean corriendo=true;

	public Hilo(Socket socket_conexion, int i) {
		this.socket_conexion=socket_conexion;
		this.num_conex=i;
	}

	public void run(){
		try {
			DataOutputStream salida;
			System.out.println("Conexión " + num_conex +" establecida");
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
			System.out.println("Conexión " + num_conex + " cerrada");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
