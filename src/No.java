public class No {

  int altura;
  No esquerda;
  No direita;
  AtletaFutebol atleta;

  public No(AtletaFutebol atleta) {
    this.altura = 0;
    this.atleta = atleta;
    this.esquerda = null;
    this.direita = null;
  }

  public AtletaFutebol getatleta() {
    return atleta;
  }

  public void setatleta(AtletaFutebol atleta) {
    this.atleta = atleta;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public No getEsquerda() {
    return esquerda;
  }

  public void setEsquerda(No esquerda) {
    this.esquerda = esquerda;
  }

  public No getDireita() {
    return direita;
  }

  public void setDireita(No direita) {
    this.direita = direita;
  }

}