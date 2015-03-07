package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		final String host = "localhost";
		final int puerto = 500;
		boolean corriendo = true;
		boolean cerrar = false;
		Socket socket;
		DataInputStream entrada;
		BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));

		try {
			socket = new Socket(host, puerto);
			System.out.println("Conexión establecida correctamente");
			entrada = new DataInputStream(socket.getInputStream());
			while (corriendo && !cerrar) {
				System.out.println(entrada.readUTF());
				if(teclado.readLine().equalsIgnoreCase("C")){
					cerrar=true;
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
