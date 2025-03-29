package examen;

import java.util.Scanner;

/**
 * Esta clase permite calcular una aproximación del número Pi utilizando una
 * serie matemática. Se introducirá por consola el número de términos que tendrá
 * la serie, siendo más precisa la aproximación cuanto más alto sea este.
 */
public class Ejercicio2 {

	/**
	 * Método main que se ejecuta al iniciar el programa y pedirá por consola un
	 * número de términos
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Objeto Scanner para leer la entrada por consola
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el número de terminos: ");
		// Variable que almacena el número de filas introducido por el usuario
		int num = Integer.parseInt(sc.nextLine());

		/*
		 * Calcula la aproximación multiplicando por 4 el resultado obtenido en la
		 * llamada al método
		 */
		double resultado = 4 * piRecursivo(num);

		System.out.println(resultado);

	}

	/**
	 * Método que calcula la aproximación de Pi utilizando de manera recursiva una
	 * serie matemática.
	 * 
	 * @param num número de términos que el usuario desea que emplee la serie
	 * @return aproximación de Pi utilizando el número de términos indicado
	 */
	private static double piRecursivo(int num) {

		// Caso base que devuelve 1 cuando el número de términos llega a 0
		if (num == 0) {
			return 1.0;
		} else {
			/*
			 * Calcula el siguiente término de la serie y se llama a si mismo decrementando
			 * en 1 el número de términos restantes
			 */
			return Math.pow(-1, num) / (2 * num + 1) + piRecursivo(num - 1);
		}
	}

}
