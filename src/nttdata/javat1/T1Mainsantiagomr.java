package nttdata.javat1;

import nttdata.javat1.game.Ball;
import nttdata.javat1.game.Game;

/**
 * 
 * Clase principal
 *
 * @author santiagomr
 *
 */

public class T1Mainsantiagomr {

	/**
	 * Éste método se encarga de inicializar el juego desde la clase main.
	 * 
	 */
	public static void main(String[] args) {

		Game gamePinball = new Game();
		gamePinball.launchAndStart();

	}

}
