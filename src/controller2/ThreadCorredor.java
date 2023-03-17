package controller2;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
	
	private Semaphore semaforo;
	private int numPessoa;
	
	public ThreadCorredor(Semaphore semaforo, int numPessoa) {
		this.semaforo = semaforo;
		this.numPessoa = numPessoa;
	}
	
	public void run() {
		AndarPessoa();
		try {
			semaforo.acquire();
			AtravessaPorta();
			semaforo.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public void AndarPessoa() {
		Random random = new Random();
		int tamanhoCorredor = 200;
		int andar = 0;
		int somaAndar = random.nextInt(4, 6);
		
		while(andar < tamanhoCorredor) {
			somaAndar = random.nextInt(4, 7);
			andar += somaAndar;
			try {
				Thread.sleep(1000);
				System.out.println("Pessoa "+numPessoa+" andou ==> "+andar+" metros");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Pessoa "+numPessoa+" chegou na Porta");
	}
	
	public void AtravessaPorta() {
		Random random = new Random();
		int abriuPorta = random.nextInt(1, 3);
		try {
			Thread.sleep(abriuPorta);
			System.out.println("Pessoa "+numPessoa+" abriu ==> atravessou ==> fechou a porta");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
