package services;

import entities.Pessoa;
import exception.PessoaJaExisteException;
import exception.PessoaListException;
import exception.PessoaNaoExisteException;
import repository.repositoryPessoa;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class PessoaServices implements repositoryPessoa {

    public static HashMap<String, Pessoa> listPessoaControl = new HashMap<>();

    public static List<Pessoa> pessoaList = new ArrayList<>();
    @Override
    public Pessoa findByName(String KeyNome) throws PessoaNaoExisteException {
        return listPessoaControl.get(KeyNome);
    }

    @Override
    public void create(String KeyNome, Pessoa EntityPessoa) throws PessoaJaExisteException {
        listPessoaControl.put(KeyNome, EntityPessoa);

        //salva na lista
        pessoaList.add(EntityPessoa);
    }

    @Override
    public void delete(String KeyNome) throws PessoaNaoExisteException {
        listPessoaControl.remove(KeyNome);
        Pessoa pessoaFind = findByName(KeyNome);
        pessoaList.remove(pessoaFind);
    }

    @Override
    public void saveAllDB(String path) {
        String Injectpath = path;
        try(BufferedWriter bw= new BufferedWriter(new FileWriter(Injectpath))) {
            for (Pessoa line: pessoaList){
                bw.write(line.getNome()+" ");
                bw.write(line.getCpf()+" ");
                bw.write(String.valueOf(line.getIdade())+" ");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recoverDB(String path){
        List<Pessoa> newReadList = new ArrayList<>();

        String Injectpath = path;
        try (BufferedReader br = new BufferedReader(new FileReader(Injectpath))) {
            String line = br.readLine();
            while (line != null) {
                String[] pessoaSplit = line.split(" ");


                String nome = pessoaSplit[0];
                String cpf = pessoaSplit[1];
                int idade = Integer.parseInt(pessoaSplit[2]);

                Pessoa buildPessoa = new Pessoa(nome,cpf,idade);

                newReadList.add(buildPessoa);
                pessoaList.add(buildPessoa);
                listPessoaControl.put(nome,buildPessoa);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Pessoa readAll : newReadList) {
            System.out.println();
            System.out.println("MSG: (System recoverDB-ok)");
            System.out.println();
        }
    }

    public HashMap<String, Pessoa> getHashMap(){
        return listPessoaControl;
    }

    @Override
    public String toString() {
        return "Sistema Pessoa" +
                  listPessoaControl
                +"\n";
    }
}
