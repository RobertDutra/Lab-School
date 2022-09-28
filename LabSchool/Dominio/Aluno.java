package LabSchool.Dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno extends Pessoa {

    private Status alunoEstado;
    private Double nota;
    private int atendimentosPedagogicos;
    public Aluno() {
    }

    public Aluno(Integer id, String nome, String telefone, LocalDate dataNascimento, String cpf, Status alunoEstado, Double nota, Integer atendimentosPedagogicos) {
        super(id, nome, telefone, dataNascimento, cpf);
        this.alunoEstado = alunoEstado;
        this.nota = nota;
        this.atendimentosPedagogicos  = atendimentosPedagogicos;
    }

    public Status getAlunoEstado() {
        return alunoEstado;
    }

    public void setAlunoEstado(Status alunoEstado) {
        this.alunoEstado = alunoEstado;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getAtendimentosPedagogicos() {
        return atendimentosPedagogicos;
    }

    public void setAtendimentosPedagogicos(int atendimentosPedagogicos) {
        this.atendimentosPedagogicos = atendimentosPedagogicos;
    }


}
