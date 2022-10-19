package semaforo;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		semaforo Semaforo = new semaforo();

		for(int i=0;;i++) {

			if(Semaforo.finalizaContinua == 01) {
				System.out.println("Sistema Finalizando...");
				break;					
			}
			else{
				System.out.println(Semaforo.getCor());

				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				System.out.println("Digite:");
				System.out.println("01 - Finalizar");
				System.out.println("02 - Continuar");
				Semaforo.finalizaContinua = scanner.nextInt();
				Semaforo.esperarCorMudar();
			}
		}

		Semaforo.Desligar();

	}

}
