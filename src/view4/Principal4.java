package view4;
import controller4.ThreadCaixas;
import java.util.concurrent.Semaphore;

public class Principal4 {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		int i = 1;
		while(i <= 20) {
		ThreadCaixas caixa = new ThreadCaixas(semaforo, i, 100);
		caixa.start();
		i++;
		}
	}

}
