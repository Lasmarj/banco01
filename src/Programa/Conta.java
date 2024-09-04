package Programa;
import interfaceConta.*;
import utilitarios.Utils;

public class Conta implements IConta {

    private static int SEQUENCIAL = 10000;
    
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;
    
    public Conta(Pessoa pessoa) {
        this.numeroConta = SEQUENCIAL++;
        this.pessoa = pessoa;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nNumero da Conta: " + this.getNumeroConta() + 
               "\nNome: " + this.getPessoa().getNome() +
               "\nCPF: " + this.getPessoa().getCpf() +
               "\nE-mail: " + this.getPessoa().getEmail() + 
               "\nSaldo da Conta: " + Utils.doubleToString(this.getSaldo()) +
               "\n";
    }

    @Override
    public void depositar(Double valor) {
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!!!");
        }else{
            System.out.println("Deposito invalido!!!");
        }
    }

    @Override
    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso");
        }else{
            System.out.println("Saldo insuficiente!!!");
        }
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor){
            sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferencia realizado com sucesso!!!");
        }else{
            System.out.println("Transferencia não realizada!!!");
        }
    }

    

}
