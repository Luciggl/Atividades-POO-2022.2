import entities.Pessoa;
import exception.PessoaJaExisteException;
import exception.PessoaNaoExisteException;
import services.PessoaServices;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws PessoaNaoExisteException {
        Scanner sc = new Scanner(System.in);
        PessoaServices crud = new PessoaServices();
        //caminho de salvar os dados
        String path = "dbPessoa/dbPessoa.txt/";

        boolean continuar = true;
        while (continuar) {

            System.out.print("==============================  Bem vindo ao SPAP!!  ===================================\n");
            System.out.println(
                    """
                            Digite uma opção:\s
                            1.Cadastrar Pessoa
                            2.Pesquisar Pessoa por Nome
                            3.deletar
                            4.Listar
                            5.Atualizar
                            6.Recuperar dados\s
                            7.Salvar na lista\s
                            8.sair""");
            System.out.print("========================================================================================\n");
            String opcao = sc.nextLine();

            System.out.println();
            switch (opcao) {
                case "1" -> {
                    //Cadastrar
                    System.out.println("Digite o nome do Pessoa");
                    String nome = sc.nextLine();
                    System.out.println("Digite a CPF do Pessoa");
                    String cpf = sc.nextLine();
                    System.out.println("Digite a idade do Pessoa");
                    int idade = sc.nextInt();
                    sc.nextLine();


                    Pessoa entityPessoa1 = new Pessoa(nome, cpf, idade);


                    try {
                        String newNameKey = entityPessoa1.getNome();

                        crud.create(newNameKey, entityPessoa1);
                        System.out.println("Pessoa cadastrado com successo");
                    } catch (PessoaJaExisteException e) {
                        throw new RuntimeException(e);
                    }


                    System.out.println();
                }
                case "2" -> {
                    System.out.println("Qual o nome do Pessoa a pesquisar?");
                    String nomePesq = sc.nextLine();
                    try {
                        Pessoa PessoaAchado = crud.findByName(nomePesq);
                        System.out.println("O Pessoa achado foi " + PessoaAchado.toString());

                    } catch (PessoaNaoExisteException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e) {
                        System.out.println("Pessoa não encontrado");
                    }
                    System.out.println();
                }
                case "3" -> {
                    try {
                        System.out.println("Nome do Pessoa para deletar");
                        String nome = sc.nextLine();
                        crud.delete(nome);
                        System.out.println("Pessoa deletado com sucesso");
                    } catch (Exception e) {
                        System.out.println("Problema ao deletar os dados dos animais. Detalhe do erro:" + e.getMessage());
                    }
                    System.out.println();
                }
                case "4" -> {
                    //Lista
                    System.out.println("Lista completa de pessoas");
                    System.out.println(List.of(crud));
                    System.out.println();
                    System.out.println("Dados listados com sucesso");
                }
                case "5" -> {
                    //atualizar
                    crud.recoverDB(path);
                    System.out.println("Digite o nome do Pessoa que quer atualizar");
                    String nome = sc.nextLine();

                    Pessoa findedPessoa = crud.findByName(nome);
                    while (findedPessoa == null) {
                        crud.recoverDB(path);
                        System.out.println("Pessoa não encontrado digite novamente! Digite novamente!");
                        nome = sc.nextLine();
                        findedPessoa = crud.findByName(nome);
                    }


                    System.out.println("\nDigite uma opção:\n1.idade \n2.tipo\n");
                    String updateMenu = sc.nextLine();

                    if (updateMenu.equals("1")) {
                        System.out.println("Digite a IDADE quer alterar");
                        Integer novaIdade = sc.nextInt();
                        sc.nextLine();

                        findedPessoa.setIdade(Integer.parseInt(String.valueOf(novaIdade)));
                        System.out.println("Idade alterado com sucesso");
                    } else if (updateMenu.equals("2")) {
                        System.out.println("Digite o Nome que quer alterar");
                        String novoNome = sc.nextLine();


                        findedPessoa.setNome(novoNome);
                        System.out.println("Nome alterado com sucesso");
                    } else {
                        System.out.println("opt invalida");
                    }

                    System.out.println("Operação feita com sucesso!");
                }
                case "6" -> {
                    crud.recoverDB(path);
                    System.out.println("dados recuperados!");
                }
                case "7" -> {
                    crud.saveAllDB(path);
                    System.out.println("Dados pesistidos");
                }
                case "8" -> continuar = false;
                default -> System.out.println("Opção inválida. Tente novamente");
            }
        }
        System.out.println("Até mais");


        sc.close();

    }
}
