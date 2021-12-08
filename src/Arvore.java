public class Arvore {

  private No raiz;

  public No getRaiz() {
    return raiz;
  }

  public void adicionarNovo(AtletaFutebol atleta) {
    raiz = adicionar(raiz, atleta);
  }

  public int altura() {
    return raiz == null ? -1 : raiz.altura;
  }

  public int altura(No n) {
    return n == null ? -1 : n.altura;
  }

  private void atualizarAltura(No n) {
    n.altura = 1 + Math.max(altura(n.esquerda), altura(n.direita));
  }

  private int balanceamento(No n) {
    return n == null ? 0 : altura(n.direita) - altura(n.esquerda);
  }

  private No adicionar(No node, AtletaFutebol atleta) {
    if (node == null) {
      return new No(atleta);
    } else if (node.atleta.codigo > atleta.codigo) {
      node.esquerda = adicionar(node.esquerda, atleta);
    } else if (node.atleta.codigo < atleta.codigo) {
      node.direita = adicionar(node.direita, atleta);
    } else {
      throw new RuntimeException("Chave já existe");
    }
    // verificar esse retorno
    return reequilibrar(node);
  }

  private No reequilibrar(No node) {
    atualizarAltura(node);
    int fatorBalanceamento = balanceamento(node);
    if (fatorBalanceamento > 1) {
      if (altura(node.direita.direita) > altura(node.direita.esquerda)) {
        node = rotacionarEsquerda(node);
      } else {
        node.direita = rotacionarDireita(node.direita);
        node = rotacionarEsquerda(node);
      }
    } else if (fatorBalanceamento < -1) {
      if (altura(node.esquerda.esquerda) > altura(node.esquerda.direita)) {
        node = rotacionarDireita(node);
      } else {
        node.esquerda = rotacionarEsquerda(node.esquerda);
        node = rotacionarDireita(node);
      }
    }
    return node;
  }

  private No rotacionarDireita(No node) {
    No auxE = node.esquerda;
    No auxD = auxE.direita;
    auxE.direita = node;
    node.esquerda = auxD;
    atualizarAltura(node);
    atualizarAltura(auxE);
    return auxE;
  }

  private No rotacionarEsquerda(No node) {
    No auxD = node.direita;
    No auxE = auxD.esquerda;
    auxD.esquerda = node;
    node.direita = auxE;
    atualizarAltura(node);
    atualizarAltura(auxD);
    return auxD;
  }

  public void emOrdem(No folha) {
    if (folha != null) {
      emOrdem(folha.getEsquerda());
      int valor = folha.atleta.codigo;
      retornaVetor(valor);
      emOrdem(folha.getDireita());
    }
  }

  public int[] retornaVetor(int valor) {
    int[] v = new int[1000];
    for (int i = 0; i < v.length; i++) {
      v[i] = valor;
    }
    return v;
  }

  public void preOrdem(No folha) {
    if (folha != null) {
      System.out.print(folha.getatleta() + "  ");
      emOrdem(folha.getEsquerda());
      emOrdem(folha.getDireita());
    }
  }

  public void posOrdem(No folha) {
    if (folha != null) {
      emOrdem(folha.getEsquerda());
      emOrdem(folha.getDireita());
      System.out.print(folha.getatleta() + "  ");
    }
  }

  public void encontrar(int codigo) {
    encontrar(raiz, codigo);
  }

  public void encontrar(No node, int codigo) {
    if (node.atleta.codigo == codigo) {
      System.out.println("\nAtleta encontrado: ");
      System.out.println("\nNome: " + node.atleta.nome);
      System.out.println("Código: " + node.atleta.codigo);
      System.out.println("Idade: " + node.atleta.idade);
      System.out.println("Peso: " + node.atleta.peso);
      System.out.println("Altura: " + node.atleta.altura);
      System.out.println("Quantidade de gols: " + node.atleta.gols);
    } else if (node.atleta.codigo > codigo) {
      encontrar(node.esquerda, codigo);
    } else if (node.atleta.codigo < codigo) {
      encontrar(node.direita, codigo);
    } else {
      System.out.println("\nAtleta não existe");
    }
  }

}