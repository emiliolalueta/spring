package expedientesx.util;

import java.util.Scanner;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class EncriptarPasswordConSalt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("dime el usuario (salt)?");
		// vamos a usar el username como salt...
		String salt = scanner.nextLine();
		System.out.println("dime la clave?");
		String clave = scanner.nextLine();
		Md5PasswordEncoder codificador = new Md5PasswordEncoder();
		String claveEncriptada = codificador.encodePassword(clave, salt);
		System.out.println(claveEncriptada);
	}
}
