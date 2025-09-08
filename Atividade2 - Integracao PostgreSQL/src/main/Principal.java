package main;

import java.util.List;
import java.util.Scanner;  

import main.DAO;
import main.peopleDAO;

public class Principal {
    public static void main(String[] args) {
        Scanner receive = new Scanner(System.in);
        peopleDAO peopleDAO = new peopleDAO();

        while (true) {
            System.out.println("==MENU==");
            System.out.println("1 - Inserir");
            System.out.println("2 - Excluir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Obter todos os items de uma coluna");
            System.out.println("0 - Sair");
            
            int answer = receive.nextInt();
            receive.nextLine();
            
            switch (answer) {
                case 1:
                    System.out.println("Digite o código:");
                    int codigoInsert = receive.nextInt();
                    receive.nextLine();
                    
                    System.out.println("Digite o trabalho:");
                    String trabalhoInsert = receive.nextLine();
                    
                    System.out.println("Digite a idade:");
                    int idadeInsert = receive.nextInt();
                    receive.nextLine();
                    
                    System.out.println("Digite o nome:");
                    String nomeInsert = receive.nextLine();
                    
                    People peopleInsert = new People(codigoInsert, trabalhoInsert, idadeInsert, nomeInsert);
                    
                    if (peopleDAO.insert(peopleInsert)) {
                        System.out.println("Inserção com sucesso -> " + peopleInsert.toString());
                    }
                    break;
                
                case 2:
                    System.out.println("Digite o código:");
                    int codigoDelete = receive.nextInt();
                    receive.nextLine();
                    
                    if (peopleDAO.delete(codigoDelete)) {
                        System.out.println("Removido com sucesso -> " + codigoDelete);
                    }
                    break;
                
                case 3:
                    System.out.println("Digite o código:");
                    int codigoUpdate = receive.nextInt();
                    receive.nextLine();
                    
                    System.out.println("Digite o trabalho:");
                    String trabalhoUpdate = receive.nextLine();
                    
                    System.out.println("Digite a idade:");
                    int idadeUpdate = receive.nextInt();
                    receive.nextLine();
                    
                    System.out.println("Digite o nome:");
                    String nomeUpdate = receive.nextLine();
                    
                    People peopleUpdate = new People(codigoUpdate, trabalhoUpdate, idadeUpdate, nomeUpdate);
                    
                    if (peopleDAO.update(peopleUpdate)) {
                        System.out.println("Atualizado com sucesso -> " + peopleUpdate.toString());
                    }
                    break;
                
                case 4:
                    System.out.println("1 - Todos");
                    System.out.println("2 - Por código");
                    System.out.println("3 - Por trabalho");
                    System.out.println("4 - Por idade");
                    System.out.println("5 - Por nome");
                    System.out.println("0 - Sair");
                    
                    int choice = receive.nextInt();
                    receive.nextLine();
                    
                    switch (choice) {
                        case 1:
                            List<People> peoplesAll = peopleDAO.get();
                            for (People p : peoplesAll) {
                                System.out.println(p.toString());
                            }
                            break;
                        
                        case 2:
                            List<People> peoplesByCodigo = peopleDAO.getOrderByCodigo();
                            for (People p : peoplesByCodigo) {
                                System.out.println(p.toString());
                            }
                            break;
                        
                        case 3:
                            List<People> peoplesByTrabalho = peopleDAO.getOrderByTrabalho();
                            for (People p : peoplesByTrabalho) {
                                System.out.println(p.toString());
                            }
                            break;
                        
                        case 4:
                            List<People> peoplesByIdade = peopleDAO.getOrderByIdade();
                            for (People p : peoplesByIdade) {
                                System.out.println(p.toString());
                            }
                            break;
                        
                        case 5:
                            List<People> peoplesByNome = peopleDAO.getOrderByNome();
                            for (People p : peoplesByNome) {
                                System.out.println(p.toString());
                            }
                            break;
                        
                        case 0:
                            System.out.println("SAINDO");
                            return;  
                    }
                    break;
                
                case 0:
                    System.out.println("SAINDO");
                    return;  
            }
        }
    }
}
