package view3;

import java.util.concurrent.Semaphore;

import controller3.ThreadFormula1;

public class Principal3 {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
			ThreadFormula1 esc1car1 = new ThreadFormula1(semaforo, 1, 1);
			ThreadFormula1 esc1car2 = new ThreadFormula1(semaforo, 1, 2);
			ThreadFormula1 esc2car1 = new ThreadFormula1(semaforo, 2, 1);
			ThreadFormula1 esc2car2 = new ThreadFormula1(semaforo, 2, 2);
			ThreadFormula1 esc3car1 = new ThreadFormula1(semaforo, 3, 1);
			ThreadFormula1 esc3car2 = new ThreadFormula1(semaforo, 3, 2);
			ThreadFormula1 esc4car1 = new ThreadFormula1(semaforo, 4, 1);
			ThreadFormula1 esc4car2 = new ThreadFormula1(semaforo, 4, 2);
			ThreadFormula1 esc5car1 = new ThreadFormula1(semaforo, 5, 1);
			ThreadFormula1 esc5car2 = new ThreadFormula1(semaforo, 5, 2);
			ThreadFormula1 esc6car1 = new ThreadFormula1(semaforo, 6, 1);
			ThreadFormula1 esc6car2 = new ThreadFormula1(semaforo, 6, 2);
			ThreadFormula1 esc7car1 = new ThreadFormula1(semaforo, 7, 1);
			ThreadFormula1 esc7car2 = new ThreadFormula1(semaforo, 7, 2);
			esc1car1.start();
			esc1car2.start();
			esc2car1.start();
			esc2car2.start();
			esc3car1.start();
			esc3car2.start();
			esc4car1.start();
			esc4car2.start();
			esc5car1.start();
			esc5car2.start();
			esc6car1.start();
			esc6car2.start();
			esc7car1.start();
			esc7car2.start();
			
			
		
		

	}

}
