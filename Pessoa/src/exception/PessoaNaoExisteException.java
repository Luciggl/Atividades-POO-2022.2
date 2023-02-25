package exception;

public class PessoaNaoExisteException extends Exception{
    public PessoaNaoExisteException(String msg){
        super(msg);
    }
}
