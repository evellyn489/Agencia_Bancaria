import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    private String numeroAgencia;
    private ArrayList<ContaBancaria> contas;

    public AgenciaBancaria(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.contas = new ArrayList<>();
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void adicionarConta(ContaBancaria novaConta) {
        contas.add(novaConta);
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public static void criarAgencia(ArrayList<AgenciaBancaria> agencias, Scanner entrada) {
        System.out.print("Número da agência: ");
        String numeroAgencia = entrada.nextLine();

        AgenciaBancaria agencia = new AgenciaBancaria(numeroAgencia);
        agencias.add(agencia);

        System.out.println("Agência criada com sucesso!\n");
    }
}
