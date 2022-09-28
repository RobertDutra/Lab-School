package LabSchool.Service.Interface;

import LabSchool.Dominio.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PedagogoService implements Pedagogo_Interface{

    int id = 0;
    boolean valorPedagogo;
    boolean valorAluno;

    Integer saidaPedagogo = 0 ;
    public Pedagogo cadastrar() {

        Pedagogo pedagogo = new Pedagogo();
        Scanner scanner = new Scanner(System.in);
        pedagogo.setId(id++);

        System.out.print("Nome: ");
        pedagogo.setNome(scanner.nextLine().toUpperCase());
        System.out.print("Cpf: ");
        pedagogo.setCpf(scanner.nextLine());
        System.out.print("Telefone: ");
        pedagogo.setTelefone(scanner.nextLine());

        try {
            System.out.println("Data nascimento (dia/mês/ano)");
            pedagogo.setDataNascimento(LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }catch (DateTimeException e){
            pedagogo.setDataNascimento(LocalDate.of(1111,11,11));
            System.out.println("Valor inserido inválido!!");
        }

        pedagogo.setNumerosAtendimentos(0);
        return pedagogo;

    }

    public void listar(List<Pedagogo> pedagogos) {

        for (Pedagogo pedagogo: pedagogos) {
            System.out.println("Id = " + pedagogo.getId() + " / Nome = " + pedagogo.getNome()
                    + " / Cpf = " + pedagogo.getCpf());
        }
    }

    public void ConsultaPedagogo(List<Pedagogo> pedagogos, List<Aluno> alunos){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n**-**-**-**-**-**-**-**-**-**-**-**-**-**");
        System.out.println("          Relátorio de Consulta");
        System.out.println("**-**-**-**-**-**-**-**-**-**-**-**-**-**");
        this.valorPedagogo = false;
        this.valorAluno = false;

        do {
            System.out.println("\nPegagogos cadastrados");
            for (Pedagogo pedagogo: pedagogos) {
                System.out.println("Id: " + pedagogo.getId() + " / Nome: " + pedagogo.getNome() + " / Número de atendimentos pedagogos: " + pedagogo.getNumerosAtendimentos());

            }
            try {
                System.out.println("\nEscolhar qual pegadogo fez a consulta, escreva seu id: \n");
                Integer idPedagogo = scanner.nextInt();
                for (Pedagogo pedagogo : pedagogos) {
                    if (pedagogo.getId().equals(idPedagogo)) {
                        pedagogo.setNumerosAtendimentos(pedagogo.getNumerosAtendimentos() + 1);
                        System.out.println("Pegago " + pedagogo.getNome() + ", realizou uma consulta.");
                        Thread.sleep(1000);
                        this.valorPedagogo = true;
                    }
                }
                if (!this.valorPedagogo){
                    System.out.println("Id pedagogo não encontrado!");

                }

            }catch (InputMismatchException | NumberFormatException e){
                System.out.println("Valor inválido!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(!this.valorPedagogo);

        do {
            System.out.println("\nAlunos Cadastrados");
            for (Aluno aluno: alunos) {
                System.out.println("Id: " + aluno.getId() + " / Nome: " + aluno.getNome() + " / Número de atendimentos pedagogos: " + aluno.getAtendimentosPedagogicos());
            }

            try {
                System.out.println("\nEscolhar qual aluno fez a consulta, escreva seu id: \n");
                Integer idAluno = scanner.nextInt();
                for (Aluno aluno : alunos) {
                    if (aluno.getId().equals(idAluno)) {
                        aluno.setAtendimentosPedagogicos(aluno.getAtendimentosPedagogicos()+1);
                        System.out.println("Aluno " + aluno.getNome() + ", realizou uma consulta.");
                        Thread.sleep(1000);
                        this.valorAluno = true;
                    }
                }

                if (!this.valorAluno){
                    System.out.println("Id aluno não encontrado!");
                }
            }
            catch (Exception e){
                System.out.println("Valor digitado inválido!");
            }
        }while(!this.valorAluno);

    }

}
