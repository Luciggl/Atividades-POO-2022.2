package entities;

public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa(){
        this("","",0);
    }
    public Pessoa(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public Pessoa setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    @Override
    public String toString() {
        return ("entities.Pessoa:" + nome + "\n Cpf:" + cpf + "\n idade:" + idade);
    }
}
