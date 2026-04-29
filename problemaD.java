import java.util.Scanner;

public class problemaD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digite o tamanho do vetor (1 a 100000): ");
		int length = Integer.parseInt(sc.nextLine());

		int[] vetor = new int[length];

		if (length > 0 && length < 100001) {

			System.out.println("elemeto do vetor separados por virgula");
			String entrada = sc.nextLine();

			String[] dados = entrada.split(",");

			int[] dadoi = new int[dados.length];

			for (int i = 0; i < dados.length; i++) {
				dadoi[i] = Integer.parseInt(dados[i].trim());
			}

			int maiorSaida = 0;
			int pulo = 1;
			// calculo

			for (int j = 0; j < dadoi.length / 2; j++) {

				for (int inicio = 0; inicio < pulo; inicio++) {

					int buffer = 0;
					for (int i = inicio; i < dadoi.length; i += pulo) {
						 buffer += dadoi[i];
						if (buffer > maiorSaida) {
							maiorSaida = buffer;
						}

					}
					
				}
				pulo++;
				
			}
			System.out.println(maiorSaida);
		} else {
			System.out.println("Valor invalido");
		}

	}
}
