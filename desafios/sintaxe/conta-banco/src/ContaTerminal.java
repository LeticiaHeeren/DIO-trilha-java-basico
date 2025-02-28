import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validação do NÚMERO DA CONTA (de 4 dígitos)
        int numero = 0;
        do {
            System.out.println("Por favor, digite o número da conta:");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (String.valueOf(numero).length() != 4) {
                    System.out.println("Erro: O número da conta deve ter 4 dígitos!");
                    numero = 0; 
                }
            } else {
                System.out.println("Erro: Digite apenas números!");
                scanner.next(); 
            }
            scanner.nextLine(); 
        } while (numero == 0);

        // Validação da AGÊNCIA (formato XXX-X)
        String agencia = "";
        do {
            System.out.println("Por favor, digite a agência:");
            agencia = scanner.nextLine().trim();
            if (!agencia.matches("\\d{3}-\\d")) {
                System.out.println("Erro: Formato inválido! Exemplo: 067-8");
            }
        } while (!agencia.matches("\\d{3}-\\d"));

        // Validação do NOME (sem números ou caracteres especiais)
        String nomeCliente = "";
        do {
            System.out.println("Por favor, digite o nome do cliente:");
            nomeCliente = scanner.nextLine().trim();
            if (nomeCliente.isEmpty() || nomeCliente.matches(".*\\d.*")) {
                System.out.println("Erro: Nome inválido! Por favor, insira um nome sem número ou caracteres especiais.");
                nomeCliente = "";
            }
        } while (nomeCliente.isEmpty());

        // Validação do SALDO (deve ser um decimal positivo)
        double saldo = -1;
        do {
            System.out.println("Por favor, digite o saldo:");
            if (scanner.hasNextDouble()) {
                saldo = scanner.nextDouble();
                if (saldo < 0) {
                    System.out.println("Erro: Saldo não pode ser negativo!");
                    saldo = -1;
                }
            } else {
                System.out.println("Erro: Digite um valor válido (ex: 237.48)!");
                scanner.next(); 
            }
            scanner.nextLine(); 
        } while (saldo == -1);

        scanner.close();

        // Exibir a Mensagem final
        String mensagem = "Olá " + nomeCliente 
            + ", obrigado por criar uma conta em nosso banco, sua agência é " 
            + agencia + ", conta " + numero + " e seu saldo " + String.format("%.2f", saldo) 
            + " já está disponível para saque.";
        System.out.println(mensagem);
    }
}