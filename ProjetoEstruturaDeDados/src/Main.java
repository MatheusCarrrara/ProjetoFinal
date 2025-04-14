import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila_Simples fila = new Fila_Simples(5);

        int opcao;
        int tamanho = 5;

        do {
            System.out.println("\n================ MENU DA FILA ================ ");
            System.out.println("1. Inserir valor");
            System.out.println("2. Inserir valor em índice");
            System.out.println("3. Inserir sequência");
            System.out.println("4. Remover primeiro elemento");
            System.out.println("5. Remover por índice");
            System.out.println("6. Remover sequência");
            System.out.println("7. Remover todas as ocorrências de um elemento");
            System.out.println("8. Buscar elemento");
            System.out.println("9. Buscar por índice");
            System.out.println("10. Ordenar crescente");
            System.out.println("11. Ordenar decrescente");
            System.out.println("12. Editar elemento");
            System.out.println("13. Obter primeiro elemento");
            System.out.println("14. Obter último elemento");
            System.out.println("15. Exibir fila");
            System.out.println("16. Dobrar capacidade");
            System.out.println("17. Limpar fila");
            System.out.println("18. Verificar se está cheia");
            System.out.println("19. Verificar se está vazia");
            System.out.println("20. Quantidade de elementos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println("\n================ MENU DA FILA ================ ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < tamanho ; i++) {
                        System.out.println("================ ");
                        System.out.print("Digite o elemento a ser insirido: ");
                        String elem = scanner.nextLine();
                        fila.inserirElemento(elem);
                    } break;
                case 2:
                    for (int i = 0; i < tamanho ; i++) {
                        System.out.println("================ ");
                        System.out.print("Digite o elemento a ser insirido: ");
                        String elem2 = scanner.nextLine();
                        System.out.print("Digite o índice desse elemento: ");
                        int indice = scanner.nextInt();
                        scanner.nextLine();
                        fila.inserirElementoIndice(elem2, indice);
                    }

                    break;

                case 3:
                    System.out.println("================ ");
                    System.out.print("Digite quantos elementos deseja inserir: ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();
                    Object[] sequencia = new Object[qtd];
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Elemento [" + i + "]: ");
                        sequencia[i] = scanner.nextLine();
                    }
                    fila.inserirSequencia(sequencia);
                    break;

                case 4:
                    System.out.println("================ ");
                    if (fila.removerElemento()) {
                        System.out.println("Elemento removido com sucesso!!!");
                    } else {
                        System.out.println("A fila está vazia, impossível remover elementos.");
                    }
                    break;

                case 5:
                    System.out.println("================ ");
                    System.out.print("Digite o índice a ser removido: ");
                    int idxRemover = scanner.nextInt();
                    scanner.nextLine();
                    Object removido = fila.removerIndice(idxRemover);
                    System.out.println("Indice removido com sucesso!!!: ");
                    break;

                case 6:
                    System.out.println("================ ");
                    System.out.print("Digite a quantidade de elementos a serem removidos: ");
                    int qtdSeq = scanner.nextInt();
                    scanner.nextLine();
                    Object[] seqRemover = new Object[qtdSeq];
                    for (int i = 0; i < qtdSeq; i++) {
                        System.out.print("Elemento [" + i + "]: ");
                        seqRemover[i] = scanner.nextLine();
                    }
                    fila.removerSequencia(seqRemover);
                    break;

                case 7:
                    System.out.println("================ ");
                    System.out.print("Digite o elemento a ser removido: ");
                    String alvo = scanner.nextLine();
                    fila.removerTodasOcorrencias(alvo);
                    System.out.println("Tudo foi removido com sucesso!!!.");
                    break;

                case 8:
                    System.out.println("================ ");
                    System.out.print("Digite o elemento a buscar: ");
                    String buscar = scanner.nextLine();
                    boolean encontrado = fila.buscarElemento(buscar);
                    System.out.println(encontrado ? "Elemento encontrado com sucesso!!!" : "Elemento não encontrado na fila.");
                    break;

                case 9:
                    System.out.println("================ ");
                    System.out.print("Digite o índice que deseja buscar: ");
                    int idxBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Object resultado = fila.buscarElementoIndice(idxBuscar);
                    System.out.println("Elemento no índice " + idxBuscar + ": " + resultado);
                    break;

                case 10:
                    System.out.println("================ ");
                    fila.ordenarCrescente();
                    System.out.println("Fila ordenada em ordem crescente, utilize a opção exibir fila para conferir!!!.");
                    break;

                case 11:
                    System.out.println("================ ");
                    fila.ordenarDecrescente();
                    System.out.println("Fila ordenada em ordem decrescente, utilize a opção exibir fila para conferir!!!.");
                    break;

                case 12:
                    System.out.println("================ ");
                    System.out.print("Digite o elemento a ser trocado: ");
                    String antigo = scanner.nextLine();
                    System.out.print("Digite o novo elemento: ");
                    String novo = scanner.nextLine();
                    fila.editarElemento(antigo, novo);
                    break;

                case 13:
                    System.out.println("================ ");
                    System.out.println("Primeiro elemento da fila: " + fila.obterPrimeiroElemento());
                    break;

                case 14:
                    System.out.println("================ ");
                    System.out.println("Último elemento da fila: " + fila.obterUltimoElemento());
                    break;

                case 15:
                    System.out.println("================ ");
                    fila.exibir();
                    break;

                case 16:
                    System.out.println("================ ");
                    fila.dobrarCapacidade();
                    System.out.println("Capacidade dobrada com sucesso!!!.");
                    break;

                case 17:
                    System.out.println("================ ");
                    fila.limpar();
                    System.out.println("Fila limpa com sucesso!!!.");
                    break;

                case 18:
                    System.out.println("================ ");
                    System.out.println(fila.estaCheia() ? "Fila está cheia." : "Fila não está cheia.");
                    break;

                case 19:
                    System.out.println("================ ");
                    System.out.println(fila.estaVazia() ? "Fila está vazia." : "Fila não está vazia.");
                    break;

                case 20:
                    System.out.println("================ ");
                    System.out.println("Quantidade de elementos presentes na fila: " + fila.quantidadeElementos());
                    break;

                case 0:
                    System.out.println("================ ");
                    System.out.println("Encerrando programa, volte novamente!!!...");
                    break;

                default:System.out.println("================ ");

                    System.out.println("Opção inválida, por favor escolha uma das opções oferecidas!!!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}