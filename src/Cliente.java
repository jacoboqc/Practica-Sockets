import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		final String host = args[0];
		final int puerto = Integer.parseInt(args[1]);
		boolean corriendo = true;
		Socket socket;
		DataInputStream entrada;

		try {
			socket = new Socket(host, puerto);
			System.out.println("Conexión establecida correctamente");
			entrada = new DataInputStream(socket.getInputStream());
			while (corriendo) {
				System.out.println(entrada.readUTF());
			}
			socket.close();
		} catch (IOException e) {
			System.out.println("Se ha perdido la conexión con el servidor");
		}

	}
}
