package examen;

import java.util.Scanner;

/**
 * Esta clase permite introducir por consola un número entero y determinar si se
 * trata de un número ambicioso, que es aquel que si sumamos sus divisores
 * propios, y se repite el proceso sucesivamente se obtiene finalmente un número
 * perfecto (aquel que es igual a la suma de sus divisores propios excepto él
 * mismo). El programa se ejecutará hasta que se introduzca un número ambicioso.
 * Si se introduce un valor que no sea un número entero o un número superior a
 * 1000, se mostrará un mensaje de error.
 */
public class Ejercicio1 {

	/**
	 * Método main que se ejecuta al iniciar el programa y pedirá por consola un
	 * número hasta que el usuario introduzca un número ambicioso.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Objeto Scanner para leer la entrada por consola
		Scanner sc = new Scanner(System.in);
		// Variable booleana utilizada para salir del bucle
		boolean exit = false;

		do {
			try {

				System.out.println("Introduce un número: ");
				// Variable que almacena el número introducido por el usuario
				int num = Integer.parseInt(sc.nextLine());

				// Comprueba si el número es mayor que 1000
				MayorMil(num);

				// Comprueba si el número es ambicioso, y si lo es finaliza el programa
				if (esAmbicioso(num)) {
					System.out.println(num + " es un número ambicioso.");
					exit = true;
				} else {
					System.out.println(num + " NO es un número ambicioso. ");
				}

			} catch (NumberFormatException ex) {
				// Mensaje de error que se muestra al no introducir un número entero
				System.out.println("Error: Debes introducir un número entero.");
			} catch (Exception ex) {
				// Captura cualquier otra excepción, incluida la que hemos creado
				System.out.println(ex.getMessage());
			}

		} while (!exit);
		System.out.println("Programa finalizado.");
	}

	/**
	 * Método que lanza una excepción personalizada si el número introducido es
	 * mayor que 1000
	 * 
	 * @param num número introducido por el usuario
	 * @throws Exception excepción lanzada si el número es mayor que 1000
	 */
	private static void MayorMil(int num) throws Exception {
		if (num > 1000) {
			// Excepción personalizada si el número introducido es mayor que 1000
			throw new Exception("Error: El número no puede ser mayor que 1000.");
		}
	}

	/**
	 * Método que comprueba si el número que recibe como parámetro es ambicioso
	 * comprobando si la suma de sus divisores da como resultado un número perfecto
	 * 
	 * @param num número que comprueba si es ambicioso
	 * @return <code>true</code> si el número es ambicioso, <code>false</code> si no
	 *         lo es
	 */
	private static boolean esAmbicioso(int num) {

		// Variable booleana utilizada para salir del bucle
		boolean exit = false;

		do {
			// Se sobreescribe el valor de num con la suma de sus divisores
			num = sumarDivisores(num);
			// Si el valor de num es menor que 1, finaliza el bucle y devuelve false
			if (num <= 1) {
				exit = true;
			}
			// Se comprueba si num es perfecto, y de ser así, devuelve true
			if (esPerfecto(num)) {
				return true;
			}
		} while (!exit);
		return false;
	}

	/**
	 * Método que calcula la suma de los divisores del número recibido como
	 * parámetro
	 * 
	 * @param num número cuyos divisores se desea sumar
	 * @return suma de los divisores del número
	 */
	private static int sumarDivisores(int num) {
		// Variable que almacena la suma total de los divisores del número
		int suma = 0;

		// Bucle que recorre los números desde 1 hasta la mitad del número recibido
		for (int i = 1; i <= num / 2; i++) {
			// Si el número es divisor del número recibido, se suma a la variable suma
			if (num % i == 0) {
				suma += i;
			}
		}
		return suma;

	}

	/**
	 * Método que comprueba si el número que recibe como parámetro es perfecto
	 * comprobando si el número es igual a la suma de sus divisores
	 * 
	 * @param num número que comprueba si es perfecto
	 * @return <code>true</code> si el número es perfecto, <code>false</code> si no
	 *         lo es
	 */
	private static boolean esPerfecto(int num) {

		return num == sumarDivisores(num);
	}

}
