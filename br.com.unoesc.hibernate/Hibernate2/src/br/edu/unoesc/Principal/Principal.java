package br.edu.unoesc.Principal;

import java.util.Date;

import br.edu.unoesc.DAO.AlunoDAO;
import br.edu.unoesc.DAO.CidadeDAO;
import br.edu.unoesc.exception.DAOException;
import br.edu.unoesc.modelo.Aluno;
import br.edu.unoesc.modelo.Cidade;

public class Principal {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		Cidade cidade = new Cidade();
		// aluno.setCodigo(4L);
		aluno.setNome("Agora Via");
		aluno.setData(new Date());
		aluno.setCidade(cidade);

		cidade.setNome("Vai Dar Certo");

		AlunoDAO<Aluno> alunoDao = new AlunoDAO<Aluno>();
		CidadeDAO<Cidade> cidadeDao = new CidadeDAO<Cidade>();
		try {
			cidadeDao.salvar(cidade);
			alunoDao.salvar(aluno);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try {
		// alunoDao.excluir(aluno);
		// } catch (DAOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// aluno = alunoDao.buscar(Aluno.class, 4L);
		// if (aluno != null) {
		// System.out.println(aluno.getNome());
		// } else {
		// System.out.println("aluno nao encontrado");
		// }

		// List<Aluno> turma = alunoDao.buscar(Aluno.class, "Antonio");
		// for (Aluno aluno3 : turma) {
		// System.out.println(aluno3.getNome());
		// }
	}

}