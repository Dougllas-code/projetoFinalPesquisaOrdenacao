import java.util.ArrayList;

public class BuscaSequencial {

  ArrayList<AtletaFutebol> vetor = new ArrayList<AtletaFutebol>();

  public void adicionaBuscaSequencial(AtletaFutebol atleta) {
    vetor.add(atleta);
  }

  public void imprimeBuscaSequencial(int cod) {
    int[] v = new int[vetor.size()];
    for (int i = 0; i < v.length; i++) {
      v[i] = vetor.get(i).codigo;
    }

    int indice = sequencial(v, cod);

    System.out.println("\nAtleta encontrado");
    System.out.println("\nNome: " + vetor.get(indice).nome);
    System.out.println("Código: " + vetor.get(indice).codigo);
    System.out.println("Idade: " + vetor.get(indice).idade);
    System.out.println("Peso: " + vetor.get(indice).peso);
    System.out.println("Altura: " + vetor.get(indice).altura);
    System.out.println("Gols: " + vetor.get(indice).gols);
  }

  private int sequencial(int[] v, int cod) {
    for (int j = 0; j < v.length; j++) {
      if (v[j] == cod) {
        return j;
      }
    }
    return -1;
  }
}