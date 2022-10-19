package semaforo;

public class semaforo implements Runnable{
	private Cor cor;
	private boolean parar;
	private boolean corMudou;
	public String finaliza;
	public int finalizaContinua = 02;
	
	public semaforo() {
		this.cor = Cor.vermelho;
		this.parar = false;
		this.corMudou = false;
		new Thread(this).start();
	}

	@Override
	public void run() {

		while(!parar) {
			try {
				Thread.sleep(this.cor.getTempoEspera());
				this.mudarCor();
			}
			catch(InterruptedException e ) {
				e.printStackTrace();
			}	
		}

	}


	private synchronized void mudarCor(){
		switch(this.cor) {
		case vermelho:
			this.cor = Cor.verde;
			break;
		case amarelo:
			this.cor = Cor.vermelho;
			break;
		case verde:
			this.cor = Cor.amarelo;
			break;
		default:
			break;
		}
		this.corMudou = true;
		notify();
	}

	public synchronized void esperarCorMudar(){
		while(!this.corMudou) {
			try {
				wait();	
			}
			catch(InterruptedException e ) {
				e.printStackTrace();
			}
		}
		this.corMudou = false;
	}

	public synchronized void Desligar(){
		this.parar = true;
	}

	public Cor getCor() {
		return cor;
	}

}

