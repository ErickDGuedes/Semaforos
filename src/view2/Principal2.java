package view2;

import java.util.concurrent.Semaphore;

import controller2.ThreadCorredor;

public class Principal2 {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		ThreadCorredor pessoa1 = new ThreadCorredor(semaforo,1);
		ThreadCorredor pessoa2 = new ThreadCorredor(semaforo,2);
		ThreadCorredor pessoa3 = new ThreadCorredor(semaforo,3);
		ThreadCorredor pessoa4 = new ThreadCorredor(semaforo,4);
		pessoa1.start();
		pessoa2.start();
		pessoa3.start();
		pessoa4.start();
		
		
		

	}

}
