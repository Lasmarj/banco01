package Programa;

public class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    //private static int quantidadeConta = 1;
    
    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        //quantidadeConta++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.getNome() + 
               "\nCpf: " + this.getCpf() + 
               "\nE-mail: " + this.getEmail();
    }

}
