package entities;

public abstract class Mensagem {
        protected boolean anonimo;
        private String texto;
        private String emailRemetente;

        private boolean anonima;

        public Mensagem(){
            this("","",true);
        }

        public Mensagem(String texto, String emailRemetente, boolean anonima){
            this.texto = texto;
            this.emailRemetente = emailRemetente;
            this.anonima = anonima;
        }

        public String getTexto(){
            return texto;
        }

        public void setTexto(){
            this.texto=texto;
        }

        public abstract String getTextoCompletoAExibir();
        public String getEmailRemetente(){
            return getEmailRemetente();
        }

        public void setEmailRemetente(String emailRemetente) {
            this.emailRemetente = emailRemetente;
        }

        public boolean ehAnonima() {
            return anonima;
        }

}

