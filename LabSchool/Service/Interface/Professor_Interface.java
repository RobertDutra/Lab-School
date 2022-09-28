package LabSchool.Service.Interface;

import LabSchool.Dominio.Professor;

import java.util.List;

public interface Professor_Interface {

    public Professor cadastrar();
    public void listar(List<Professor> professores);

}
