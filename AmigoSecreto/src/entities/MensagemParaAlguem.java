package entities;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;
    public MensagemParaAlguem(String texto, String emailRemetente, boolean anonimo){
        super(texto,emailRemetente,anonimo);
        this.emailDestinatario=emailDestinatario;
    }

    public String getEmailDestinatario() {
        if (super.ehAnonima()) {
            return "mensagem de :"+super.getEmailRemetente() + "para:"+this.getEmailDestinatario() + "Texto: "+super.getTexto();
        } else {
            return "mensagem para: "+this.getEmailDestinatario() + "Texto: "+super.getTexto();
        }
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        return null;
    }

}