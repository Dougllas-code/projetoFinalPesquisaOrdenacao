import java.io.Serializable;

public class AtletaFutebol implements Serializable {

  String nome;
  int codigo;
  int idade;
  float peso;
  float altura;
  int gols;

  public AtletaFutebol(String nome, int codigo, int idade, float peso, float altura, int gols) {
    this.nome = nome;
    this.codigo = codigo;
    this.idade = idade;
    this.peso = peso;
    this.altura = altura;
    this.gols = gols;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public float getPeso() {
    return peso;
  }

  public void setPeso(float peso) {
    this.peso = peso;
  }

  public float getAltura() {
    return altura;
  }

  public void setAltura(float altura) {
    this.altura = altura;
  }

  public int getGols() {
    return gols;
  }

  public void setGols(int gols) {
    this.gols = gols;
  }

}