import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ordenacao o = new Ordenacao();
        Arvore t = new Arvore();
        BuscaBinaria b = new BuscaBinaria();
        BuscaSequencial s = new BuscaSequencial();
        SistemaDeArquivo si = new SistemaDeArquivo();

        int parada = 0;
        while (parada == 0) {
            System.out.println("----- Menu -----");
            System.out.println("----- 1 - Adicionar Atleta -----");
            System.out.println("----- 2 - Busca Binária -----");
            System.out.println("----- 3 - Busca AVL -----");
            System.out.println("----- 4 - Busca Sequencial -----");
            System.out.println("----- 5 - Ordenação Merge Sort -----");
            System.out.println("----- 6 - Ordenação Selection Sort -----");
            System.out.println("----- 7 - Ordenação Insertion Sort -----");
            System.out.println("----- 8 - Ordenação Bubble Sort -----");
            System.out.println("----- 9 - Salvar dados -----");
            System.out.println("----- 10 - Carregar dados -----");
            System.out.println("----- 11 - Encerrar Programa -----");

            int chave = scanner.nextInt();

            switch (chave) {
                case 1:
                    AtletaFutebol a = new AtletaFutebol(null, 0, 0, 0, 0, 0);
                    System.out.println("\nDigite o primeiro nome do atleta: ");
                    String nomeAtleta = scanner.next();
                    a.setNome(nomeAtleta);

                    System.out.println("Digite código do atleta: ");
                    int codigoAtleta = scanner.nextInt();
                    a.setCodigo(codigoAtleta);

                    System.out.println("Digite a idade do atleta: ");
                    int idadeAtleta = scanner.nextInt();
                    a.setIdade(idadeAtleta);

                    System.out.println("Digite o peso do atleta: ");
                    float pesoAtleta = scanner.nextFloat();
                    a.setPeso(pesoAtleta);

                    System.out.println("Digite a altura do atleta: ");
                    float alturaAtleta = scanner.nextFloat();
                    a.setAltura(alturaAtleta);

                    System.out.println("Digite a quantidade de gols do atleta: ");
                    int golsAtleta = scanner.nextInt();
                    a.setGols(golsAtleta);

                    o.adicionaordenacao(a);
                    t.adicionarNovo(a);
                    b.adicionaBuscaBinaria(a);
                    s.adicionaBuscaSequencial(a);
                    si.adicionarEscrita(a);

                    break;
                case 2:
                    System.out.println("Digite o código do atleta");
                    int codigoAtleta2 = scanner.nextInt();

                    b.imprimeBuscaBinaria(codigoAtleta2);

                    break;
                case 3:
                    System.out.println("Digite o código do atleta");
                    int codigoAtleta3 = scanner.nextInt();

                    t.encontrar(codigoAtleta3);

                    break;
                case 4:
                    System.out.println("Digite o código do atleta");
                    int codigoAtleta4 = scanner.nextInt();

                    s.imprimeBuscaSequencial(codigoAtleta4);

                    break;
                case 5:
                    o.imprimeMergeSort();

                    break;
                case 6:
                    o.imprimeSelectionSort();

                    break;
                case 7:
                    o.imprimeInsertionSort();

                    break;
                case 8:
                    o.imprimeBubbleSort();
                case 9:
                    si.escreverArquivo();
                    ;
                    break;
                case 10:
                    si.lerArquivo();

                    for (int i = 0; i < si.vetor.size(); i++) {
                        AtletaFutebol atletaArq = new AtletaFutebol(null, 0, 0, 0, 0, 0);

                        atletaArq = si.vetor.get(i);

                        o.adicionaordenacao(atletaArq);
                        t.adicionarNovo(atletaArq);
                        b.adicionaBuscaBinaria(atletaArq);
                        s.adicionaBuscaSequencial(atletaArq);
                    }
                    break;
                case 11:
                    System.out.println("Fim programa");
                    parada = 1;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

        }
    }
}
