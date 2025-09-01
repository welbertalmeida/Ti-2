package app;

import java.util.List;
import java.util.Scanner;
import dao.DAO2;
import model.X;

public class Principal2 {

    public static void main(String[] args) {

        DAO2 dao = new DAO2();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n==== Menu CRUD X ====");
            System.out.println("1) Listar");
            System.out.println("2) Inserir");
            System.out.println("3) Excluir");
            System.out.println("4) Atualizar");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir enter

            switch (opcao) {
                case 1: // Listar
                    List<X> lista = dao.getAll();
                    for (X x : lista) {
                        System.out.println(x);
                    }
                    break;
                case 2: // Inserir
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    X x = new X(0, nome, valor);
                    dao.insert(x);
                    System.out.println("Inserido com sucesso!");
                    break;
                case 3: // Excluir
                    System.out.print("ID a excluir: ");
                    int idDel = sc.nextInt();
                    dao.delete(idDel);
                    System.out.println("Excluído com sucesso!");
                    break;
                case 4: // Atualizar
                    System.out.print("ID a atualizar: ");
                    int idUpd = sc.nextInt();
                    sc.nextLine();
                    X xAtual = dao.get(idUpd);
                    if (xAtual != null) {
                        System.out.print("Novo nome: ");
                        xAtual.setNome(sc.nextLine());
                        System.out.print("Novo valor: ");
                        xAtual.setValor(sc.nextDouble());
                        dao.update(xAtual);
                        System.out.println("Atualizado com sucesso!");
                    } else {
                        System.out.println("ID não encontrado!");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}

