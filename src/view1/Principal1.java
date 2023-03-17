package view1;
import java.util.concurrent.Semaphore;
import controller1.ThreadCarros;

public class Principal1 {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		//Ativa Threads dos Carros
		Thread carro1 = new ThreadCarros("Norte", semaforo);
		Thread carro2 = new ThreadCarros("Sul", semaforo);
		Thread carro3 = new ThreadCarros("Leste", semaforo);
		Thread carro4 = new ThreadCarros("Oeste", semaforo);
		carro1.start();
		carro2.start();
		carro3.start();
		carro4.start();
		
		

	}

}
