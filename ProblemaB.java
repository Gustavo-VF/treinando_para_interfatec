import java.util.Scanner;

public class ProblemaB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("nome da sede 25 caracteries: ");
		String inputNome = sc.nextLine();

		char[] nomeSede = inputNome.toCharArray();

		while (nomeSede.length > 24) {
			System.out.println("nome da sede COM APENAS 25 caracteries: ");
			inputNome = sc.nextLine();

			nomeSede = inputNome.toCharArray();
		}

		System.out.println("numero de vagas totais de 2 ate 100. e o numero de vagas extras da sede");

		String[] entrada2 = sc.nextLine().split(" ");
		int vagasTotais = Integer.parseInt(entrada2[0]);
		int vagasExtras = Integer.parseInt(entrada2[1]);
		int vagasSede = vagasExtras + 1;

		int quantTimes = Integer.parseInt(sc.nextLine());

		String[] nomes = new String[quantTimes];
		String[] fatecs = new String[quantTimes];
		int[] problemas = new int[quantTimes];
		int[] tempos = new int[quantTimes];

		for (int i = 0; i < quantTimes; i++) {
			String[] partes = sc.nextLine().split("\\|");
			nomes[i] = partes[0].trim();
			fatecs[i] = partes[1].trim();
			problemas[i] = Integer.parseInt(partes[2].trim());
			tempos[i] = Integer.parseInt(partes[3].trim());
		}

		for (int i = 0; i < quantTimes - 1; i++) {
			for (int j = 0; j < quantTimes - i - 1; j++) {
				boolean troca = false;
                if (problemas[j] < problemas[j+1]) troca = true;
                if (problemas[j] == problemas[j+1] && tempos[j] > tempos[j+1]) troca = true;

                if (troca) {
                    String tmpS; int tmpI;
                    tmpS = nomes[j];     nomes[j]     = nomes[j+1];     nomes[j+1]     = tmpS;
                    tmpS = fatecs[j];    fatecs[j]    = fatecs[j+1];    fatecs[j+1]    = tmpS;
                    tmpI = problemas[j]; problemas[j] = problemas[j+1]; problemas[j+1] = tmpI;
                    tmpI = tempos[j];    tempos[j]    = tempos[j+1];    tempos[j+1]    = tmpI;
                }
				
				
			}

		}
		
		boolean[] classificado = new boolean[quantTimes];
        int vagasRestantes = vagasTotais;

        int vagasSedeUsadas = 0;
        for (int i = 0; i < quantTimes; i++) {
            if (vagasSedeUsadas >= vagasSede) break;
            if (fatecs[i].equals(inputNome) && problemas[i] > 0) {
                classificado[i] = true;
                vagasSedeUsadas++;
                vagasRestantes--;
            }
      } 
		
        boolean[] fatecJaVista = new boolean[vagasTotais];
        for (int i = 0; i < quantTimes; i++) {
            if (vagasRestantes <= 0) break;
            if (classificado[i] || problemas[i] == 0) continue;

         boolean jaVista = false; //79  
            for (int j = 0; j < i; j++) {
                if (fatecs[j].equals(fatecs[i])) { jaVista = true; break; }
            }
            if (!jaVista) {
                classificado[i] = true;
                vagasRestantes--;
            }
        }
		
        for (int i = 0; i < quantTimes; i++) {
            if (vagasRestantes <= 0) break;
            if (!classificado[i] && problemas[i] > 0) {
                classificado[i] = true;
                vagasRestantes--;
            }
        }
		
        int[] idxClass = new int[vagasTotais - vagasRestantes];
        int c = 0;
        for (int i = 0; i < quantTimes; i++) {
            if (classificado[i]) idxClass[c++] = i;
        }
        for (int i = 0; i < c - 1; i++) {
            for (int j = 0; j < c - i - 1; j++) {
                if (nomes[idxClass[j]].compareToIgnoreCase(nomes[idxClass[j+1]]) > 0) {
                    int tmp = idxClass[j]; idxClass[j] = idxClass[j+1]; idxClass[j+1] = tmp;
                }
            }
        }

        System.out.println("Classificados para a Final");
        for (int i = 0; i < c; i++) {
            int k = idxClass[i];
            System.out.println(nomes[k] + " \u2013 " + fatecs[k] + " (" + problemas[k] + "," + tempos[k] + ")");
        }

        System.out.println();
        System.out.println("Lista de Espera");
        for (int i = 0; i < quantTimes; i++) {
            if (!classificado[i] && problemas[i] > 0) {
                System.out.println(nomes[i] + " \u2013 " + fatecs[i] + " (" + problemas[i] + "," + tempos[i] + ")");
            }
        }

        System.out.println();
        System.out.println("Desclassificados");
        
        int[] idxDesc = new int[quantTimes];
        int d = 0;
        for (int i = 0; i < quantTimes; i++) {
            if (problemas[i] == 0) idxDesc[d++] = i;
        }
        for (int i = 0; i < d - 1; i++) {
            for (int j = 0; j < d - i - 1; j++) {
                if (nomes[idxDesc[j]].compareToIgnoreCase(nomes[idxDesc[j+1]]) > 0) {
                    int tmp = idxDesc[j]; idxDesc[j] = idxDesc[j+1]; idxDesc[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < d; i++) {
            int k = idxDesc[i];
            System.out.println(nomes[k] + " \u2013 " + fatecs[k] + " (" + problemas[k] + "," + tempos[k] + ")");
        }

        System.out.println();
        System.out.println("Apuracao concluida!");
		
		
		
		
		
		
		
		
		
		

	}

}
