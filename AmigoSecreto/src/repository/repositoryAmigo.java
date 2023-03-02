package repository;

import entities.Amigo;
import exception.AmigoJaExisteException;
import exception.AmigoNaoExisteException;
import exception.ListAmigoException;
public interface repositoryAmigo {
    Amigo findByName(String nome)throws AmigoNaoExisteException;

    void create(String KeyNome, Amigo EntityAmigo) throws AmigoJaExisteException;
    void delete(String KeyNome) throws AmigoNaoExisteException;

    default void saveAllBD(String path) throws ListAmigoException {}

    default void recoverBD(String path) throws ListAmigoException {}


    void saveAllDB(String path);

    void recoverDB(String path);
}
