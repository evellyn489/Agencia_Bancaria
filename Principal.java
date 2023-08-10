import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<AgenciaBancaria> agencias = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("O que você deseja fazer?");
            System.out.println("1- Criar uma agência");
            System.out.println("2- Criar uma conta");
            System.out.println("3- Fazer depósito");
            System.out.println("4- Realizar saque");
            System.out.println("5- Visualizar saldo");
            System.out.println("6- Sair");

            int resposta = entrada.nextInt();
            entrada.nextLine(); 

            switch (resposta) {
                case 1:
                    System.out.println("Vamos criar uma agência\n");
                    AgenciaBancaria.criarAgencia(agencias, entrada);
                    break;

                case 2:
                    System.out.println("Vamos criar uma conta\n");
                    ContaBancaria.criarConta(agencias, entrada);
                    break;

                case 3:
                    System.out.println("Vamos fazer o depósito\n");
                    System.out.print("Digite o número da conta: ");
                    String numeroContaDeposito = entrada.nextLine();
                    ContaBancaria contaDeposito = buscarConta(agencias, numeroContaDeposito);

                    if (contaDeposito != null) {
                        System.out.print("Digite o valor a ser depositado: ");
                        double valorDeposito = entrada.nextDouble();
                        contaDeposito.deposito(valorDeposito);
                        System.out.println("Depósito realizado com sucesso. Novo saldo: \n" + contaDeposito.getSaldoConta());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    entrada.nextLine(); 
                    break;

                case 4:
                    System.out.println("Vamos realizar um saque\n");
                    System.out.print("Digite o número da conta: ");
                    String numeroContaSaque = entrada.nextLine();
                    ContaBancaria contaSaque = buscarConta(agencias, numeroContaSaque);

                    if (contaSaque != null) {
                        System.out.print("Digite o valor a ser sacado: ");
                        double valorSaque = entrada.nextDouble();
                        entrada.nextLine(); 

                        contaSaque.saque(valorSaque);
                        System.out.println("Saque realizado com sucesso. Novo saldo: " + contaSaque.getSaldoConta());

                    } else {
                        System.out.println("Conta não encontrada.\n");
                    }
                    break;

                case 5:
                    System.out.println("Vamos visualizar o saldo");
                    System.out.print("Digite o número da conta: ");
                    String numeroContaSaldo = entrada.nextLine();
                    ContaBancaria contaSaldo = buscarConta(agencias, numeroContaSaldo);
                
                    if (contaSaldo != null) {
                        System.out.println("Saldo da conta: " + contaSaldo.getSaldoConta());
                    } else {
                        System.out.println("Conta não encontrada.\n");
                    }
                    break;

                case 6:
                    System.out.println("Programa encerrado");
                    entrada.close();
                    System.exit(0);

                default:
                    System.out.println("Inválido! Digite um número entre 1 e 5!\n");
                    break;
            }
        }
    }

    public static ContaBancaria buscarConta(ArrayList<AgenciaBancaria> agencias, String numeroConta) {
        for (AgenciaBancaria agencia : agencias) {
            ContaBancaria contaEncontrada = agencia.buscarConta(numeroConta);
            if (contaEncontrada != null) {
                return contaEncontrada;
            }
        }
        return null;
    }
}
