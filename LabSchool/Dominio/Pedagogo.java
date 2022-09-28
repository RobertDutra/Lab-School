package LabSchool.Dominio;

import LabSchool.Dominio.Pessoa;

import java.time.LocalDate;

public class Pedagogo extends Pessoa {

    private int numerosAtendimentos;

    public Pedagogo() {
    }

    public Pedagogo(Integer id, String nome, String telefone, LocalDate dataNascimento, String cpf) {
        super(id, nome, telefone, dataNascimento, cpf);
    }

    public int getNumerosAtendimentos() {
        return numerosAtendimentos;
    }

    public void setNumerosAtendimentos(int numerosAtendimentos) {
        this.numerosAtendimentos = numerosAtendimentos;
    }
}
