package nttdata.javat1.game;

import java.util.Scanner;

import java.util.*;
import java.util.Map.Entry;

/**
 * Desarrollo del juego.
 * 
 * @author santiagomr
 *
 */

public class Game {
	static Scanner scan = new Scanner(System.in);

	/**
	 * Éste método se encarga de inicializar el juego.
	 * 
	 */
	public static void launchAndStart() {

		/* Introducir el numero de jugadores que van a participar en el juego */

		System.out.print("Introduzca el numero de jugadores: ");
		int numberPlayers = scan.nextInt();

		/* Creación del mapa para agrupar el nombre de los jugadores y su puntuacion */

		Map<String, Integer> dicc = new HashMap<>();

		/* Hashtable<Integer, String> my_dict = new Hashtable<Integer, String>(); */

		/* Bucle for en el que se recorre el numero de jugadores */

		for (int i = 0; i < numberPlayers; i++) {

			String playerName = "";
			int token = 0;
			int tries = 0;
			int overallScore = 0;

			System.out.print("Introduce tu nombre: ");
			playerName = scan.next();

			/* Bucle while para especificar el numero de tokens que queremos introducir */
			while (token < 1 || token > 5) {
				System.out.print("Introduzca el número de tokens (1, 3 o 5) : ");
				token = scan.nextInt();
			}

			/*
			 * Estructura switch para asociar los tokens al numero de intentos que se van a
			 * establecer en nuestro juego.
			 */

			switch (token) {
			case 1:
				tries = 3;
				break;
			case 3:
				tries = 5;
				break;
			case 5:
				tries = 7;
				break;
			default:
				System.out.println("Parametro incorrecto -Fin del juego-");
				break;
			}

			/* Bucle for para decrementar los intentos. */

			System.out.print("Comienzo del Juego");
			String movement = scan.nextLine();
			System.out.println();

			for (int j = tries; j > 0; j--) {
				launchBall();
				System.out.println("Numero de intentos: " + j);

				// * Estructura do while para determinar que mientras se introduzca una tecla
				// valida a o d/, teclas muy usadas en videojuegos, nuestra puntuacion se
				// incremente con un valor aleatorio. */

				do {
					System.out.println("Introduce el botón correcto (Tecla a o d): ");
					movement = scan.nextLine();

					if (movement.charAt(0) == 'a') {
						Ball.Score += (int) (Math.random() * 101);
					}

					else if (movement.charAt(0) == 'd') {
						Ball.Score += (int) (Math.random() * 201);
					}

					else {
						System.out.println("Tecla incorrecta, por favor pulsa el boton correcto.");
						break;
					}

				} while (movement.equals("a") || movement.equals("d"));

				overallScore += Ball.Score;
			}

			dicc.put(playerName, overallScore);

			System.out.print("La puntuacion total es de: " + overallScore);
			System.out.println();

		}

		/* Se introducen los datos en el diccionario */

		List<Entry<String, Integer>> listaOrdenada = new ArrayList<>(dicc.entrySet());

		listaOrdenada.sort(Entry.comparingByValue(Comparator.reverseOrder()));

		System.out.println(listaOrdenada);

	}

	/**
	 * Éste método se encarga de lanzar la bola.
	 * 
	 */
	public static void launchBall() {
		Ball.Score = 0;

	}

}
