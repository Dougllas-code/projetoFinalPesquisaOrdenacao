import java.util.ArrayList;

public class BuscaBinaria {

  ArrayList<AtletaFutebol> vetor = new ArrayList<AtletaFutebol>();

  public void adicionaBuscaBinaria(AtletaFutebol atleta) {
    vetor.add(atleta);
  }

  public void imprimeBuscaBinaria(int cod) {

    int[] v = new int[vetor.size()];
    for (int i = 0; i < v.length; i++) {
      v[i] = vetor.get(i).codigo;
    }

    ordenaVetor(v);

    int indice = binario(v, cod);

    for (int j = 0; j < vetor.size(); j++) {
      if (v[indice] == vetor.get(j).codigo) {
        System.out.println("\nAtleta encontrado");
        System.out.println("\nNome: " + vetor.get(j).nome);
        System.out.println("Código: " + vetor.get(j).codigo);
        System.out.println("Idade: " + vetor.get(j).idade);
        System.out.println("Peso: " + vetor.get(j).peso);
        System.out.println("Altura: " + vetor.get(j).altura);
        System.out.println("Gols: " + vetor.get(j).gols);
      }
    }
  }

  public static int binario(int[] s, int x) {

    int meio;
    int inicio = 0;
    int fim = s.length - 1;

    while (inicio <= fim) {
      meio = (inicio + fim) / 2;
      if (s[meio] == x) {
        return meio;
      } else if (s[meio] < x) {
        inicio = meio + 1;
      } else {
        fim = meio - 1;
      }
    }

    return -1;
  }

  private static void ordenaVetor(int[] v) {
    int n = v.length;
    for (int i = 1; i < n; i++) {
      int x = v[i];
      int j = i - 1;
      while (j >= 0 && v[j] > x) {
        v[j + 1] = v[j];
        j = j - 1;
      }
      v[j + 1] = x;
    }
  }
}