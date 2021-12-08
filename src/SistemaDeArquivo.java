import java.io.*;
import java.util.ArrayList;

public class SistemaDeArquivo {

  ArrayList<AtletaFutebol> vetor = new ArrayList<AtletaFutebol>();

  public void adicionarEscrita(AtletaFutebol atleta) {
    vetor.add(atleta);
  }

  public void escreverArquivo() {
    escreverArquivo2(vetor);
  }

  public void escreverArquivo2(ArrayList<AtletaFutebol> v) {
    try {

      File file = new File("arquivo.dat");
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));

      output.writeObject(v);

      output.close();
      System.out.println("Dados salvos com sucesso!");
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public void lerArquivo() {
    try {
      File file = new File("arquivo.dat");
      ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));

      vetor = (ArrayList<AtletaFutebol>) input.readObject();

      input.close();
      System.out.println("Dados carregados com sucesso!");
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

}
