import java.util.Scanner;

public class ProblemaC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digite a quantidade de leituras  (1 a 1000): ");
		int num_leitura = Integer.parseInt(sc.nextLine());

		if (num_leitura > 0 && num_leitura < 1001) {

			while (num_leitura > 0) {

				System.out.println(
						"temperatura em graus celcius,umidade do solo e Previsao de Chuva. separados por virgula: ");
				String entrada = sc.nextLine();

				String[] dados = entrada.split(",");

				double T = Double.parseDouble(dados[0].trim());
				double U = Double.parseDouble(dados[1].trim());

				int P = Integer.parseInt(dados[2].trim());

				if (P == 1) {
					System.out.println("NAO REGAR");

				} else {
					if ((T > 30.0) && (U < 50)) {
						System.out.println("REGAR");
					} else {
						System.out.println("NAO REGAR");
					}
				}
				num_leitura--;
			}

		}else {
			System.out.println("Valor invalido");
		}
	}

}
