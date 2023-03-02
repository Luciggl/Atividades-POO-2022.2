package service;

import entities.Amigo;
import entities.Mensagem;
import exception.AmigoJaExisteException;
import exception.AmigoNaoExisteException;
import repository.repositoryAmigo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SistemaAmigo implements repositoryAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;
    private static HashMap<String, Amigo> listAmigoControl = new HashMap<>();
    private static List<Amigo> amigoList = new ArrayList<>();

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    @Override
    public Amigo findByName(String KeyNome) throws AmigoNaoExisteException {
        return listAmigoControl.get(KeyNome);
    }

    @Override
    public void create(String KeyNome, Amigo EntityPessoa) throws AmigoJaExisteException {
        listAmigoControl.put(KeyNome, EntityPessoa);

        //salva na lista
        amigoList.add(EntityPessoa);
    }

    @Override
    public void delete(String KeyNome) throws AmigoNaoExisteException {
        listAmigoControl.remove(KeyNome);
        Amigo pessoaFind = findByName(KeyNome);
        amigoList.remove(pessoaFind);
    }

    @Override
    public void saveAllDB(String path) {
        String Injectpath = path;
        try(BufferedWriter bw= new BufferedWriter(new FileWriter(Injectpath))) {
            for (Amigo line: amigos){
                bw.write(line.getNome()+" ");
                bw.write(line.getEmail()+" ");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recoverDB(String path){
        List<Amigo> newReadList = new ArrayList<>();

        String Injectpath = path;
        try (BufferedReader br = new BufferedReader(new FileReader(Injectpath))) {
            String line = br.readLine();
            while (line != null) {
                String[] pessoaSplit = line.split(" ");


                String nome = pessoaSplit[0];
                String email = pessoaSplit[1];

                Amigo buildPessoa = new Amigo(nome,email);

                newReadList.add(buildPessoa);
                amigoList.add(buildPessoa);
                listAmigoControl.put(nome,buildPessoa);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Amigo readAll : newReadList) {
            System.out.println();
            System.out.println("MSG: (System recoverDB-ok)");
            System.out.println();
        }
    }

    public HashMap<String, Amigo> getHashMap(){
        return listAmigoControl;
    }

    @Override
    public String toString() {
        return "Sistema Pessoa" +
                listAmigoControl
                +"\n";
    }
}
