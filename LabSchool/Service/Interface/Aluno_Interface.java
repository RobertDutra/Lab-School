package LabSchool.Service.Interface;

import LabSchool.Dominio.Aluno;

import java.util.List;

public interface Aluno_Interface {
    public Aluno cadastrar();
    public void listar(List<Aluno> alunos);
}
