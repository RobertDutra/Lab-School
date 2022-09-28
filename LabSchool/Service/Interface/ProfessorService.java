package LabSchool.Service.Interface;

import LabSchool.Dominio.EstadoProfessor;
import LabSchool.Dominio.Experiencia;
import LabSchool.Dominio.Formacao;
import LabSchool.Dominio.Professor;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ProfessorService implements Professor_Interface{

    int id = 0;
    public Professor cadastrar(){
        Professor professor = new Professor();
        Scanner scanner = new Scanner(System.in);
        professor.setId(id++);
        System.out.print("Nome: ");
        professor.setNome(scanner.nextLine().toUpperCase());
        System.out.print("Cpf: ");
        professor.setCpf(scanner.nextLine());
        System.out.print("Telefone: ");
        professor.setTelefone(scanner.nextLine());

        try {
            System.out.println("Data nascimento (dia/mês/ano)");
            professor.setDataNascimento(LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }catch (DateTimeException e){
            professor.setDataNascimento(LocalDate.of(1111,11,11));
            System.out.println("Valor inserido inválido!!");
        }

        try {
            System.out.println("Formação acadêmica: [GRADUACAO_INCOMPLETA / GRADUACAO_COMPLETA / MESTRADO / DOUTORADO]");
            professor.setFormacaoAcademica(Formacao.valueOf(scanner.next().toUpperCase()));
        }
        catch (Exception e){
            professor.setFormacaoAcademica(Formacao.ERROR);
            System.out.println("Valor digita inválido!!");
        }
        try {
            System.out.println("Experiência em desenvolvimento: [FRONT_END / BACK_END / FULL_STACK");
            professor.setExperienciaEmDesenvolvimento(Experiencia.valueOf(scanner.next().toUpperCase()));
        }catch (Exception e){
            professor.setExperienciaEmDesenvolvimento(Experiencia.ERROR);
            System.out.println("Valor digita inválido!!");
        }

        try {
            System.out.println("Estado do professor: [ATIVO/INATIVO]");
            professor.setEstado(EstadoProfessor.valueOf(scanner.next().toUpperCase()));
        }catch (Exception e) {
            professor.setEstado(EstadoProfessor.ERROR);
            System.out.println("Valor digita inválido!!");

        }


        return professor;

    }

    public void listar(List<Professor> professores) {
        for (Professor professor: professores) {
            System.out.println("Id = " + professor.getId() + " / Nome = " + professor.getNome() +
                    " / Cpf = " + professor.getCpf());
        }
    }
}
