package semaforo;

public enum Cor {
	verde(120000), amarelo(30000), vermelho(60000);
	private int tempoEspera;
	
	Cor(int tempoEspera){
		this.tempoEspera = tempoEspera;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}
	
}
