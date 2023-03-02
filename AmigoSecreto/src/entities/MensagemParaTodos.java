package entities;

public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonimo){
        this.getTexto();
        this.getEmailRemetente();
        if (anonimo) this.anonimo = true;
        else this.anonimo = false;
    }

    @Override
    public String getTextoCompletoAExibir() {
        return getTextoCompletoAExibir();
    }
}

