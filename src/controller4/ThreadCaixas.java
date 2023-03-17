package controller4;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCaixas extends Thread {
	
	private Semaphore semaforo;
	private int numCaixa;
	private int saldoConta;
	
	public ThreadCaixas(Semaphore semaforo, int numCaixa, int saldoConta) {
		this.semaforo = semaforo;
		this.numCaixa =  numCaixa;
		this.saldoConta = saldoConta;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			SaqueDeposito();
			semaforo.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
	
	public void SaqueDeposito() {
		Random random = new Random();
		int saque = 10;
		int deposito = 10;
		int qtdSaque = random.nextInt(1,4);
		int qtdDeposito = random.nextInt(1,4);
		
		if(qtdSaque < 2) {
			saque = saque * qtdSaque;
			saldoConta -= saque;
			System.out.println("Caixa "+numCaixa+" Num. de saques ==> "+qtdSaque+"// Saldo atual da conta ==> "+saldoConta);
		}
		else if(qtdSaque > 2){
			System.out.println("Caixa "+numCaixa+" -- Ação Inválida -- (Qtd. de Saques "+qtdSaque+" -- Qtd. de Depósitos "+qtdDeposito+")");
		}
		else if(qtdDeposito < 2) {
			deposito = deposito * qtdDeposito;
			saldoConta += deposito;
			System.out.println("Caixa "+numCaixa+" Num. de depósitos ==> "+qtdDeposito+"// Saldo atual da conta ==> "+saldoConta);
		}
		else if(qtdSaque < 2 || qtdDeposito < 2) {
			saque = saque * qtdSaque;
			deposito = deposito * qtdDeposito;
			saldoConta -= saque;
			saldoConta += deposito;
			System.out.println("Caixa "+numCaixa+" Num. de saques ==> "+qtdSaque+"// Num. de Depósitos ==> "+qtdDeposito+"// Saldo atual da conta ==> "+saldoConta);
		}
	}

}
