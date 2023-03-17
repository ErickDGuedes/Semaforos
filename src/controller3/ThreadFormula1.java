package controller3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread{
	
	private Semaphore semaforo;
	private int numEscuderia;
	private int numCarro;
	
	public ThreadFormula1(Semaphore semaforo, int numEscuderia, int numCarro) {
		this.semaforo = semaforo;
		this.numEscuderia = numEscuderia;
		this.numCarro = numCarro;
		
	}
	public void run() {
		CarrosNaPista();
		
		
	}
	public void CarrosNaPista() {
		Random random = new Random();
		int voltaMetros = 3000;
		int velCarro = 0;
		int somaVelCarro = random.nextInt(100);
		double tempoInicial = System.nanoTime();
		
		try {
			semaforo.acquire();
			while(velCarro < voltaMetros) {
				somaVelCarro = random.nextInt(100);
				velCarro += somaVelCarro;
				//Thread.sleep(1000);
				//System.out.println("Escuderia #"+numEscuderia+" Carro =>"+numCarro+" correu ==> "+velCarro+" metros");
			}
			semaforo.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				semaforo.acquire();
				System.out.println("Escuderia #"+numEscuderia+"// Carro =>"+numCarro+" completou a pista");
				double tempoFinal = System.nanoTime();
				double tempoTotal = tempoFinal - tempoInicial;
				tempoTotal = tempoTotal / Math.pow(10,  9);
				Thread.sleep(1000);
				System.out.println("Tempo  Esc."+numEscuderia+" Carro "+numCarro+" ==> "+tempoTotal+"s.");
				semaforo.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {

			}
			
			

		}

	}
	
}
