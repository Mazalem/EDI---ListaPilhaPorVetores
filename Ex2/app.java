import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int testes = -1;

        System.out.print("Quantos casos de teste? ");
        testes = digitaInteiro(teclado);

        for (int i = 1; i <= testes; i++) {
            System.out.print("Digite o teste " + i + ": ");
            String teste = digitaString(teclado);

            Pilha pilhaTeste = new Pilha();
            Pilha pilhaDiamantes = new Pilha();
            for (int j = 0; j < teste.length(); j++) {
                try {
                    pilhaTeste.push(teste.charAt(j));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            int contadorDiamantes = 0;
            while (pilhaTeste.topo != -1) {
                if (pilhaTeste.pilha[pilhaTeste.topo] == '.') {
                    try {
                        pilhaTeste.pop();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (pilhaTeste.pilha[pilhaTeste.topo] == '<' || pilhaTeste.pilha[pilhaTeste.topo] == '>') {
                    try {
                        pilhaDiamantes.push(pilhaTeste.pop());
                        if (pilhaDiamantes.pilha[pilhaDiamantes.topo] == '<') {
                            if (pilhaDiamantes.topo != 0 && pilhaDiamantes.pilha[pilhaDiamantes.topo - 1] == '>') {
                                pilhaDiamantes.pop();
                                pilhaDiamantes.pop();
                                contadorDiamantes++;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println(contadorDiamantes);
        }
    }

    public static String digitaString(Scanner teclado) {
        String texto;
        while (true) {
            try {
                texto = teclado.next();
                return texto;
            } catch (InputMismatchException ex) {
                System.err.print("Somente textos são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
    }

    public static int digitaInteiro(Scanner teclado) {
        int numero;
        while (true) {
            try {
                numero = teclado.nextInt();
                if (numero > 0) {
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
}
