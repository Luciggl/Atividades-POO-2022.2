package entities;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nome, String email){
        this.nome = nome;
        this.email=email;
        this.emailAmigoSorteado=emailAmigoSorteado;
    }

    public String getNome() {
        return nome;
    }

    public Amigo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Amigo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public Amigo setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
        return this;
    }
}
