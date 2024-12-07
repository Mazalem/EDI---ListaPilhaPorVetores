import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        while (true) {
            Scanner teclado = new Scanner(System.in);
            int tamanho;

            System.out.print("\nQual será o tamanho da pilha? ");
            tamanho = digitaInteiro(teclado);
            if (tamanho == 0)
                break;
            while (true) {
                boolean parada = false;
                PilhaVagoes pilhaVagoes = new PilhaVagoes(tamanho);
                PilhaVagoes pilhaEstacao = new PilhaVagoes(tamanho);
                PilhaVagoes pilhaOrdenada = new PilhaVagoes(tamanho);
                pilhaVagoes.preenchePilha();
                int[] pilhaTeste = new int[tamanho];

                System.out.println("\nInsira a sequência que deseja testar.");
                System.out.println("(Lembre-se que o primeiro que inserir é o primeiro da sequencia)");
                System.out.println("Exemplo: Primeiro Inserido -> 5 4 3 2 1 <- Último Inserido");
                System.out.println("                              ^       ^");
                System.out.println("    Primeiro que sai da estação       Último que sai da estação\n");
                for (int i = 0; i < tamanho; i++) {
                    System.out.print("Digite o valor " + (i + 1) + ": ");
                    try {
                        pilhaTeste[i] = digitaInteiro(teclado, tamanho);
                        if (pilhaTeste[i] == 0) {
                            parada = true;
                            break;
                        }
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                if (parada) {
                    break;
                }

                int j = 0;
                while(true) {
                    if (pilhaEstacao.isVazia() && !pilhaVagoes.isVazia()) {
                        try {
                            pilhaEstacao.push(pilhaVagoes.pop());
                        } catch (Exception ex) {
                            System.err.println(ex.getMessage());
                        }
                    }

                    if (pilhaTeste[j] == pilhaEstacao.pilha[pilhaEstacao.topo]) {
                        try {
                            while (!pilhaEstacao.isVazia() && pilhaTeste[j] == pilhaEstacao.pilha[pilhaEstacao.topo]) {
                                pilhaOrdenada.push(pilhaEstacao.pop());
                                j++;
                            }
                            if (j > pilhaTeste.length - 1) {
                                System.out.print("\n\nPossível | ");
                                break;
                            }
                            else if (pilhaVagoes.isVazia()) {
                                System.out.print("\n\nImpossível | ");
                                break;
                            }
                        } catch (Exception ex) {
                            System.err.println(ex.getMessage());
                        }
                    } else if (pilhaVagoes.isVazia()) {
                        System.out.print("\n\nImpossível | ");
                        break;
                    } else {
                        try {
                            pilhaEstacao.push(pilhaVagoes.pop());
                        } catch (Exception ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                }
                System.out.print("Proximo teste: ");
            }
        }
    }

    public static int digitaInteiro(Scanner teclado) {
        int numero;
        while (true) {
            try {
                numero = teclado.nextInt();
                if (numero >= 0) {
                    teclado.nextLine();
                    break;
                }
                System.err.print("O valor deve ser positivo. Tente novamente: ");
            } catch (InputMismatchException ex) {
                System.err.print("Somente inteiros são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return numero;
    }

    public static int digitaInteiro(Scanner teclado, int tamanho) {
        int numero;
        while (true) {
            try {
                numero = teclado.nextInt();
                if (numero >= 0 && numero <= tamanho) {
                    teclado.nextLine();
                    break;
                }
                System.err.print("O valor deve ser entre 1 e " + tamanho + ". Tente novamente: ");
            } catch (InputMismatchException ex) {
                System.err.print("Somente inteiros são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return numero;
    }
}
