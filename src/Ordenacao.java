import java.util.ArrayList;
import java.util.Arrays;

public class Ordenacao {

  ArrayList<AtletaFutebol> vetor = new ArrayList<AtletaFutebol>();

  public void adicionaordenacao(AtletaFutebol atleta) {
    vetor.add(atleta);
  }

  public void imprimeMergeSort() {
    int[] v = new int[vetor.size()];
    int[] vAux = new int[v.length];
    for (int i = 0; i < v.length; i++) {
      v[i] = vetor.get(i).codigo;
    }
    int indice = 0;

    mergeSort(v, vAux, 0, v.length - 1);

    System.out.println("\n MERGE SORT");

    for (int j = 0; j < v.length; j++) {
      indice = buscaIndice(v[j]);
      System.out.println("\nNome: " + vetor.get(indice).nome);
      System.out.println("Código: " + vetor.get(indice).codigo);
      System.out.println("Idade: " + vetor.get(indice).idade);
      System.out.println("Peso: " + vetor.get(indice).peso);
      System.out.println("Altura: " + vetor.get(indice).altura);
      System.out.println("Gols: " + vetor.get(indice).gols);
      System.out.println("\n");
    }
    System.out.println(Arrays.toString(v));
  }

  public void imprimeSelectionSort() {
    int[] v = new int[vetor.size()];
    for (int i = 0; i < v.length; i++) {
      v[i] = vetor.get(i).codigo;
    }
    int indice = 0;

    selectionSort(v);

    System.out.println("\n SELECTION SORT");

    for (int j = 0; j < v.length; j++) {
      indice = buscaIndice(v[j]);
      System.out.println("Nome: " + vetor.get(indice).nome);
      System.out.println("Código: " + vetor.get(indice).codigo);
      System.out.println("Idade: " + vetor.get(indice).idade);
      System.out.println("Peso: " + vetor.get(indice).peso);
      System.out.println("Altura: " + vetor.get(indice).altura);
      System.out.println("Gols: " + vetor.get(indice).gols);
      System.out.println("\n");
    }
    System.out.println(Arrays.toString(v));
  }

  public void imprimeInsertionSort() {
    int[] v = new int[vetor.size()];
    for (int i = 0; i < v.length; i++) {
      v[i] = vetor.get(i).codigo;
    }

    int indice = 0;

    insertionSort(v);

    System.out.println("\n INSERTION SORT");

    for (int j = 0; j < v.length; j++) {
      indice = buscaIndice(v[j]);
      System.out.println("Nome: " + vetor.get(indice).nome);
      System.out.println("Código: " + vetor.get(indice).codigo);
      System.out.println("Idade: " + vetor.get(indice).idade);
      System.out.println("Peso: " + vetor.get(indice).peso);
      System.out.println("Altura: " + vetor.get(indice).altura);
      System.out.println("Gols: " + vetor.get(indice).gols);
      System.out.println("\n");
    }
    System.out.println(Arrays.toString(v));
  }

  public void imprimeBubbleSort() {
    int[] v = new int[vetor.size()];
    for (int i = 0; i < v.length; i++) {
      v[i] = vetor.get(i).codigo;
    }
    int indice = 0;

    bubbleSort(v);

    System.out.println("\n BUBBLE SORT");

    for (int j = 0; j < v.length; j++) {
      indice = buscaIndice(v[j]);
      System.out.println("Nome: " + vetor.get(indice).nome);
      System.out.println("Código: " + vetor.get(indice).codigo);
      System.out.println("Idade: " + vetor.get(indice).idade);
      System.out.println("Peso: " + vetor.get(indice).peso);
      System.out.println("Altura: " + vetor.get(indice).altura);
      System.out.println("Gols: " + vetor.get(indice).gols);
      System.out.println("\n");
    }
    System.out.println(Arrays.toString(v));
  }

  private static void mergeSort(int[] v, int[] vAux, int inicio, int fim) {
    if (inicio < fim) {
      int meio = (inicio + fim) / 2;
      mergeSort(v, vAux, inicio, meio);
      mergeSort(v, vAux, meio + 1, fim);
      intercalar(v, vAux, inicio, meio, fim);
    }
  }

  private static void intercalar(int[] v, int[] vAux, int inicio, int meio, int fim) {
    for (int k = inicio; k <= fim; k++)
      vAux[k] = v[k];

    int i = inicio;
    int j = meio + 1;

    for (int k = inicio; k <= fim; k++) {
      if (i > meio) {
        v[k] = vAux[j++];
      } else if (j > fim) {
        v[k] = vAux[i++];
      } else if (vAux[i] < vAux[j]) {
        v[k] = vAux[i++];
      } else {
        v[k] = vAux[j++];
      }
    }
  }

  private static void insertionSort(int[] v) {
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

  private static void selectionSort(int[] v) {
    for (int i = 0; i < v.length; i++) {
      int menor = i;
      for (int j = i + 1; j < v.length; j++) {
        if (v[j] < v[menor])
          menor = j;
      }
      if (menor != i) {
        int aux = v[i];
        v[i] = v[menor];
        v[menor] = aux;
      }
    }

  }

  private static void bubbleSort(int[] v) {
    int n = v.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (v[j] > v[j + 1]) {
          int aux = v[j];
          v[j] = v[j + 1];
          v[j + 1] = aux;
        }
      }
    }
  }

  private int buscaIndice(int i) {
    for (int k = 0; k < vetor.size(); k++) {
      if (i == vetor.get(k).codigo) {
        return k;
      }
    }
    return -1;
  }

}