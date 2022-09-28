package LabSchool.Service.Interface;

import LabSchool.Dominio.Aluno;
import LabSchool.Dominio.Pedagogo;

import java.util.List;

public interface Pedagogo_Interface {

    public Pedagogo cadastrar();
    public void listar(List<Pedagogo> pedagogos);
    public void ConsultaPedagogo(List<Pedagogo> pedagogos, List<Aluno> alunos);
}
