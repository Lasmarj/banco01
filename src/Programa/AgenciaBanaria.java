package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBanaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancaria;

    public static void main(String[] args) {
        contasBancaria = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes(){
        System.out.println("#############################################################################");
        System.out.println("######################### Bem vindo a nossa Agencia #########################");
        System.out.println("#############################################################################");
        System.out.println("----------------- Seleciona um operacao que deseja realizar -----------------");
        System.out.println("#############################################################################");
        System.out.println("|          Opcao 1 - Criar Conta          |");
        System.out.println("|          Opcao 2 - Depositar            |");
        System.out.println("|          Opcao 3 - Sacar                |");
        System.out.println("|          Opcao 4 - Transferir           |");
        System.out.println("|          Opcao 5 - Listar               |");
        System.out.println("|          Opcao 6 - Sair                 |");
        System.out.println("#############################################################################");

        int operacao = input.nextInt();
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Finalizando!!!");
                System.exit(0);
            default:
                System.out.println("Opcao Invalida!!!");
                operacoes();
                break;
        }
    }

    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nE-mail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);

        contasBancaria.add(conta);
        System.out.println("Conta Criada com Sucesso!!!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancaria.size() > 0){
            for(Conta contaC : contasBancaria ){
                if(contaC.getNumeroConta() == numeroConta){
                    conta = contaC;
                }
            }
        }
        return conta;
    }
    
    public static void depositar(){
        System.out.println("Entre com o número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            System.out.println("Qual valor deseja depositar?");
            Double valorDepositar = input.nextDouble();
            conta.depositar(valorDepositar);
            System.out.println("Valor Depositado com sucesso");
        }else{
            System.out.println("Conta não foi encontrada!!!");
        }
        operacoes();
    }

    public static void sacar(){
        System.out.println("Entre com o número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            System.out.println("Qual valor deseja sacar?");
            Double valorSaque = input.nextDouble();
            conta.depositar(valorSaque);
            //System.out.println("Saque realizado com sucesso");
        }else{
            System.out.println("Conta não foi encontrada!!!");
        }
        operacoes();
    }

    public static void transferir(){
        System.out.println("Entre com o número da conta do destinatario: ");
        int numeroContaRemetente = input.nextInt();
        
        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null){
            System.out.println("Numero da conta do Destinatario? ");
            int numeroContaDestinatario = input.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            
            if(contaDestinatario != null){
                System.out.println("Valor da transferencia? ");
                Double valorTransferencia = input.nextDouble();
                contaRemetente.transferir(contaDestinatario, valorTransferencia);
            }else{
                System.out.println("A conta para deposito nao foi encontrada!!!");
            }
        }else{
            System.out.println("Sua conta nao foi encontrada");
        }
        operacoes();
    }

    public static void listar(){
        if(contasBancaria.size() > 0){
            for(Conta contaC : contasBancaria){
                System.out.println(contaC);
            }
        }
        operacoes();
    }

}
