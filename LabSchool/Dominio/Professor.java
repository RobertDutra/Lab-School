package LabSchool.Dominio;

import LabSchool.Dominio.Pessoa;

import java.time.LocalDate;

public class Professor extends Pessoa {

    private Formacao formacaoAcademica;
    private Experiencia experienciaEmDesenvolvimento;

    private EstadoProfessor estado;

    public Professor() {
    }

    public Professor(Integer id, String nome, String telefone, LocalDate dataNascimento, String cpf, Formacao formacaoAcademica, Experiencia experienciaEmDesenvolvimento, EstadoProfessor estado) {
        super(id, nome, telefone, dataNascimento, cpf);
        this.formacaoAcademica = formacaoAcademica;
        this.experienciaEmDesenvolvimento = experienciaEmDesenvolvimento;
    }

    public Formacao getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(Formacao formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public Experiencia getExperienciaEmDesenvolvimento() {
        return experienciaEmDesenvolvimento;
    }

    public void setExperienciaEmDesenvolvimento(Experiencia experienciaEmDesenvolvimento) {
        this.experienciaEmDesenvolvimento = experienciaEmDesenvolvimento;
    }

    public EstadoProfessor getEstado() {
        return estado;
    }

    public void setEstado(EstadoProfessor estado) {
        this.estado = estado;
    }
}
