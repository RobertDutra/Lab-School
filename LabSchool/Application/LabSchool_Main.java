package LabSchool.Application;

import LabSchool.Dominio.*;
import LabSchool.Service.Interface.AlunoService;
import LabSchool.Service.Interface.PedagogoService;
import LabSchool.Service.Interface.ProfessorService;

import java.time.LocalDate;
import java.util.*;


public class LabSchool_Main {
    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Pedagogo> pedagogos = new ArrayList<>();

        AlunoService alunoService = new AlunoService();
        ProfessorService professorService = new ProfessorService();
        PedagogoService pedagogoService = new PedagogoService();

        while (true){
            Scanner opcaoescolhida = new Scanner(System.in);
            menu();
            try {
                int opcao = opcaoescolhida.nextInt();
                switch (opcao){
                    case 1:
                        caso1();
                        Scanner opcaoCadastro = new Scanner(System.in);
                        System.out.print("Qual deseja cadastrar? \n");
                        int opcao1 = opcaoCadastro.nextInt();
                        switch (opcao1) {
                            case 1 -> alunos.add(alunoService.cadastrar());
                            case 2 -> professores.add(professorService.cadastrar());
                            case 3 -> pedagogos.add(pedagogoService.cadastrar());
                            default -> System.out.println("Valor inválido!");
                        }
                        break;

                    case 2:
                        caso2();
                        Scanner opcaoListar = new Scanner(System.in);
                        System.out.println("Qual você deseja listar?\n ");
                        int opcao2 = opcaoListar.nextInt();

                        switch (opcao2){
                            case 1:
                                if (alunos.isEmpty()) {
                                    System.out.println("\nNão à alunos cadastrados!\n");
                                }
                                else{
                                    alunoService.listar(alunos);
                                    Thread.sleep(2000);

                                }
                                break;

                            case 2:
                                if (professores.isEmpty()) {
                                    System.out.println("\nNão à professores cadastrados!\n");
                                }
                                else{
                                professorService.listar(professores);
                                    Thread.sleep(2000);

                                }
                                break;

                            case 3:
                                if (pedagogos.isEmpty()) {
                                    System.out.println("\nNão à pedagogos cadastrados!\n");
                                }
                                else{
                                    pedagogoService.listar(pedagogos);
                                    Thread.sleep(2000);

                                }
                                break;

                            case 4:
                                if (alunos.isEmpty() && professores.isEmpty() && pedagogos.isEmpty()) {
                                    System.out.println("\nNão à cadastros!");
                                }
                                else{
                                    if (alunos.isEmpty()){
                                        System.out.println("\nNão à alunos cadastrados!");
                                    }
                                    else {
                                        System.out.println("\nAlunos cadastrados:\n");
                                        alunoService.listar(alunos);
                                    }

                                    if (professores.isEmpty()){
                                        System.out.println("\nNão à professores cadastrados!");
                                    }
                                    else {
                                        System.out.println("\nProfessores cadastrados:\n");
                                        professorService.listar(professores);
                                    }

                                    if (pedagogos.isEmpty()){
                                        System.out.println("\nNão à pedagogos cadastrados!");
                                    }
                                    else {
                                        System.out.println("\nPedagogos cadastrados:\n");
                                        pedagogoService.listar(pedagogos);
                                    }
                                    Thread.sleep(1000);
                                }
                                break;

                            default:
                                System.out.println("Valor inválido!");
                        }
                        break;
                    case 3:
                        Scanner opcaoRelatorio = new Scanner(System.in);
                        caso03();
                        int opcao3 = opcaoRelatorio.nextInt();

                        switch (opcao3) {
                            case 1:
                                if (alunos.isEmpty()) {
                                    System.out.println("Não à alunos cadastrados!");
                                } else{
                                    for (Aluno aluno : alunos) {
                                        if (aluno.getAlunoEstado().equals(Status.ATIVO)) {
                                            System.out.println("Id = " + aluno.getId() + " / Nota de entrada = " + aluno.getNota() +
                                                    " / Atendimentos pedagógicos = " + aluno.getAtendimentosPedagogicos());
                                        }

                                    }
                                    Thread.sleep(1000);

                                }
                                break;

                            case 2 :
                                if (alunos.isEmpty()) {
                                    System.out.println("Não à alunos cadastrados!");
                                } else {
                                    for (Aluno aluno : alunos) {
                                        if (aluno.getAlunoEstado().equals(Status.IRREGULAR)) {
                                            System.out.println("Id = " + aluno.getId() + " / Nota de entrada = " + aluno.getNota() +
                                                    " / Atendimentos pedagógicos = " + aluno.getAtendimentosPedagogicos());
                                        }

                                    }
                                    Thread.sleep(1000);
                                }
                                break;

                            case 3:
                                if (alunos.isEmpty()) {
                                    System.out.println("Não à alunos cadastrados!");
                                } else {
                                    for (Aluno aluno : alunos) {
                                        if (aluno.getAlunoEstado().equals(Status.ATENDIMENTO_PEDAGOGICO)) {
                                            System.out.println("Id = " + aluno.getId() + " / Nota de entrada = " + aluno.getNota() +
                                                    " / Atendimentos pedagógicos = " + aluno.getAtendimentosPedagogicos());
                                        }
                                    }
                                    Thread.sleep(1000);

                                }
                                break;

                            case 4:
                                if (alunos.isEmpty()) {
                                    System.out.println("Não à alunos cadastrados!");
                                } else {
                                    for (Aluno aluno : alunos) {
                                        if (aluno.getAlunoEstado().equals(Status.INATIVO)) {
                                            System.out.println("Id = " + aluno.getId() + " / Nota de entrada = " + aluno.getNota() +
                                                    " / Atendimentos pedagógicos = " + aluno.getAtendimentosPedagogicos());
                                        }
                                    }
                                    Thread.sleep(1000);
                                }
                                break;

                            case 5:
                                if (alunos.isEmpty()) {
                                    System.out.println("Não à alunos cadastrados!");
                                } else {
                                    for (Aluno aluno : alunos) {
                                        System.out.println("Id = " + aluno.getId() + " / Nota de entrada = " + aluno.getNota() +
                                                " / Atendimentos pedagógicos = " + aluno.getAtendimentosPedagogicos() +
                                                " / Status = " + aluno.getAlunoEstado());

                                    }
                                    Thread.sleep(1000);

                                }
                                break;

                            default:
                                System.out.println("Valor digita inválido!");

                        }
                        break;
                    case 4:
                        Scanner opcaoRelatorioProfessor = new Scanner(System.in);
                        caso4();
                        int opcao4 = opcaoRelatorioProfessor.nextInt();

                        switch (opcao4){
                            case 1:
                                if (professores.isEmpty()) {
                                    System.out.println("Não à professores cadastrados!");
                                } else {
                                    System.out.println("Front-End\n");
                                    for (Professor professor : professores) {
                                        if (professor.getExperienciaEmDesenvolvimento().equals(Experiencia.FRONT_END)) {
                                            System.out.println("Id = " + professor.getId() + " / Nome = " + professor.getNome() +
                                                    " / Cpf = " + professor.getCpf() + " / Status = " + professor.getEstado());
                                        }
                                    }
                                    Thread.sleep(2000);

                                }
                                break;

                            case 2:
                                if (professores.isEmpty()) {
                                    System.out.println("Não à professores cadastrados!");
                                } else {
                                    System.out.println("Back-End\n");
                                    for (Professor professor : professores) {
                                        if (professor.getExperienciaEmDesenvolvimento().equals(Experiencia.BACK_END)) {
                                            System.out.println("Id = " + professor.getId() + " / Nome = " + professor.getNome() +
                                                   " / Cpf = " + professor.getCpf() + " / Status = " + professor.getEstado());
                                        }
                                    }
                                    Thread.sleep(2000);

                                }
                                break;

                            case 3:
                                if (professores.isEmpty()) {
                                    System.out.println("Não à professores cadastrados!");
                                } else {
                                    System.out.println("Full-Stack\n");
                                    for (Professor professor : professores) {
                                        if (professor.getExperienciaEmDesenvolvimento().equals(Experiencia.FULL_STACK)) {
                                            System.out.println("Id = " + professor.getId() + " / Nome = " + professor.getNome() +
                                                    " / Cpf = " + professor.getCpf() + " / Status = " + professor.getEstado());
                                        }
                                    }
                                    Thread.sleep(2000);
                                }
                                break;

                            case 4:
                                if (professores.isEmpty()) {
                                    System.out.println("Não à professores cadastrados!");
                                } else {
                                    for (Professor professor : professores) {
                                        System.out.println("Id = " + professor.getId() + " / Nome = " + professor.getNome() +
                                                " / Cpf = " + professor.getCpf() + " / Experiência em desenvolvimento = " +
                                                professor.getExperienciaEmDesenvolvimento() +
                                                " / Status = " + professor.getEstado());

                                    }
                                    Thread.sleep(2000);

                                }
                                break;

                            default:
                                System.out.println("Valor inválido!");

                        }
                        break;

                    case 5:
                        if (pedagogos.isEmpty() || alunos.isEmpty()){
                            System.out.println("Lista pedagogo ou aluno sem cadastro!");
                        }
                        else {
                            pedagogoService.ConsultaPedagogo(pedagogos,alunos);

                        }
                        break;

                    case 6:
                        if (alunos.isEmpty()) {
                            System.out.println("Não à alunos cadastrados!");
                        } else {
                            alunos.sort(Comparator.comparing(Aluno::getAtendimentosPedagogicos).reversed());
                            System.out.println("Alunos:");
                            for (Aluno aluno : alunos) {
                                System.out.println("Id = " + aluno.getId() + " / Nome = " + aluno.getNome() + " / Cpf = " + aluno.getCpf() + " / Tota de atendimentos pedagogos = " +
                                        aluno.getAtendimentosPedagogicos());
                            }
                            Thread.sleep(2000);
                        }


                        break;

                    case 7:
                        if (pedagogos.isEmpty()) {
                            System.out.println("Não à pedagogos cadastrados!");
                        } else {
                            pedagogos.sort(Comparator.comparing(Pedagogo::getNumerosAtendimentos).reversed());
                            System.out.println("Pedagogos:");
                            for (Pedagogo pedagogo : pedagogos) {
                                System.out.println("Id = " + pedagogo.getId() + " / Nome = " + pedagogo.getNome() + " / Cpf = " + pedagogo.getCpf() + " / Tota de atendimentos pedagogos = " +
                                        pedagogo.getNumerosAtendimentos());
                            }
                            Thread.sleep(2000);
                        }
                        break;



                    case 8:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Valor digita inválido!");
                }
            }
            catch (NumberFormatException | InputMismatchException e){
                System.out.println("Valor digitado não númerico!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public static void menu(){
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("           Lab School");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("1 - Cadastrar.");
        System.out.println("2 - Listar.");
        System.out.println("3 - Relatório dos Alunos.");
        System.out.println("4 - Relatório dos Professores.");
        System.out.println("5 - Consulta pedagógica.");
        System.out.println("6 - Alunos com mais atendimentos pedagógicos.");
        System.out.println("7 - Pedagogos com mais atendimentos pedagógicos.");
        System.out.println("8 - Sair do programa.\n");

    }
    public static void caso1(){
        System.out.println("\n1 - Cadastrar Aluno\n2 - Cadastrar Professor\n3 - Cadastrar Pedagogo");
    }

    public static void caso2(){
        System.out.println("\n1 - Listar Alunos\n2 - Listar Professores\n3 - Listar Funcionários\n4 - Todos");
    }

    public static void caso03(){
        System.out.println("\nRelatório dos Alunos:");
        System.out.println("1 - Ativos\n2 - Irregular\n3 - Atendimento pedagógico\n4 - Inativo\n5 - Todos");
    }

    public static void caso4(){
        System.out.println("\nRelatório dos professores:");
        System.out.println("1 - Front-End\n2 - Back-End \n3 - Full-Stack \n4 -Todos");
    }
}
