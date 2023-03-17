package controller1;
import java.util.concurrent.Semaphore;
public class ThreadCarros extends Thread{
	
	private String movimento;
	private Semaphore semaforo;
	
	//Construtor
	public ThreadCarros(String movimento, Semaphore semaforo) {
		this.movimento = movimento;
		this.semaforo = semaforo;
	}
	static int tempo = (int)((Math.random()*2001)+1000);
	//Thread
	public void run() {
		Movimentacao();
		try {
			semaforo.acquire();
			Parou();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			Atravessou();
		}
		
	}
	//Movimenta o Carro
	public void Movimentacao() {
		int cruzamento = 50;
		int carroMoveu = 10;
		int somaMovimento = 0;
		
		while(somaMovimento < cruzamento) {
			System.out.println("Carro "+movimento+" andou "+somaMovimento+" metros");
			somaMovimento += carroMoveu;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(somaMovimento >= cruzamento) {
				System.out.println("Carro "+movimento+" chegou no cruzamento");
			}
		}
	}
	//Para o carro no cruzamento
	public void Parou() {
		System.out.println("Carro "+movimento+" parou no cruzamento");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Carro Atravessa o cruzamento
	public void Atravessou() {
			System.out.println("Carro "+movimento+" atravessou o cruzamento");
	}
}
