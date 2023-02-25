package repository;

import entities.Pessoa;
import exception.PessoaJaExisteException;
import exception.PessoaListException;
import exception.PessoaNaoExisteException;

public interface repositoryPessoa {
    Pessoa findByName(String nome) throws PessoaNaoExisteException;

    void create(String KeyNome, Pessoa EntityPessoa) throws PessoaJaExisteException;
    void delete(String KeyNome) throws PessoaNaoExisteException;

    default void saveAllDB(String path) throws PessoaListException{

    }

    default void recoverDB(String path) throws PessoaListException{

    }
}
