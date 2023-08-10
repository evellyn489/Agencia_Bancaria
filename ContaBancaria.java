import java.util.ArrayList;
import java.util.Scanner;

public class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldoConta;

    public ContaBancaria(String numeroConta, String nomeTitular, double saldoConta) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldoConta = saldoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void deposito(double valor) {
        saldoConta += valor;
    }

    public void saque(double valor) {
        if (valor > saldoConta) {
            System.out.println("Valor ultrapassa o saldo disponível na sua conta");
        } else {
            saldoConta -= valor;
        }
    }

    public void visualizarSaldo() {
        System.out.println("Saldo: " + saldoConta);
    }

    public static void criarConta(ArrayList<AgenciaBancaria> agencias, Scanner entrada) {
        if (agencias.size() == 0) {
            System.out.println("ERRO! Crie primeiro uma agência para depois criar a conta.");
        } else {
            System.out.print("Digite o número da sua agência: ");
            String numeroAgencia = entrada.nextLine();

            AgenciaBancaria agenciaEncontrada = null;
            for (AgenciaBancaria agencia : agencias) {
                if (agencia.getNumeroAgencia().equals(numeroAgencia)) {
                    agenciaEncontrada = agencia;
                    break;
                }
            }

            if (agenciaEncontrada != null) {
                System.out.print("Número da conta: ");
                String numeroConta = entrada.nextLine();

                System.out.print("Nome do titular: ");
                String nomeTitular = entrada.nextLine();

                System.out.print("Saldo inicial: ");
                double saldoInicial = entrada.nextDouble();
                entrada.nextLine(); 

                ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
                agenciaEncontrada.adicionarConta(novaConta);

                System.out.println("Conta criada com sucesso!\n");

            } else {
                System.out.println("Agência não encontrada.\n");
            }
        }
    }

    public void buscarConta(ArrayList<AgenciaBancaria> agencias, String numeroConta) {
        for (AgenciaBancaria agencia : agencias) {
            ContaBancaria contaEncontrada = agencia.buscarConta(numeroConta);
            if (contaEncontrada != null) {
                System.out.println("Número da Conta: " + contaEncontrada.getNumeroConta());
                System.out.println("Nome do Titular: " + contaEncontrada.getNomeTitular());
                System.out.println("Saldo: " + contaEncontrada.getSaldoConta());
                return;
            }
        }
        System.out.println("Conta não encontrada.\n");
    }
    
    
}
