package LabSchool.Service.Interface;

import LabSchool.Dominio.Aluno;
import LabSchool.Dominio.Status;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AlunoService implements Aluno_Interface {

    int id = 0;
    public Aluno cadastrar() {

        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
        aluno.setId(id++);
        System.out.print("Nome: ");
        aluno.setNome(scanner.nextLine().toUpperCase());
        System.out.print("Cpf: ");
        aluno.setCpf(scanner.nextLine());
        System.out.print("Telefone: ");
        aluno.setTelefone(scanner.nextLine());

        try {
            System.out.println("Data nascimento (dia/mês/ano)");
            aluno.setDataNascimento(LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }catch (DateTimeException e) {
            aluno.setDataNascimento(LocalDate.of(1111, 11, 11));
            System.out.println("Valor inserido inválido!!");
//
        }

        try {
            System.out.println("Status aluno [ ATIVO / IRREGULAR / ATENDIMENTO_PEDAGOGICO / INATIVO]");
            aluno.setAlunoEstado(Status.valueOf(scanner.next().toUpperCase()));
        }
        catch (Exception e){
            aluno.setAlunoEstado(Status.ERROR);
            System.out.println("Valor digita inválido!!");
        }

       try {
           System.out.print("Nota do processo seletivo: ");
           aluno.setNota(scanner.nextDouble());
       }
        catch (Exception e){
           aluno.setNota(0.0);
           System.out.println("Valor digita inválido!!");

        }

       aluno.setAtendimentosPedagogicos(0);
        return aluno;

    }

    public void listar(List<Aluno> alunos) {
        for (Aluno aluno: alunos) {
            System.out.println("Id = " + aluno.getId() + " / Nome = " + aluno.getNome() +
                    " / Cpf = " + aluno.getCpf() + " / Data de nascimento = " + aluno.getDataNascimento());
        }
    }
}
