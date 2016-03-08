package br.edu.unoesc.Principal;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.edu.unoesc.modelo.Aluno;

public class Principal {

	private static String teclado;

	public static void main(String[] args) {
		// Aluno aluno = new Aluno();
		// aluno.setNome("Joao");
		// aluno.setData(new Date());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidade");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			et.begin();
			Aluno aluno = new Aluno();
			Scanner entrada = new Scanner(System.in);

			System.out.println("digite um para cadastrar ou dois para alterar");
			teclado = entrada.nextLine();
			if (teclado.equals("um")) {
				System.out.println("Digite o nome do novo aluno");
				aluno.setNome(entrada.nextLine());
				aluno.setData(new Date());
				em.persist(aluno);
			} else {
				System.out.println("Digite novo nome");
				aluno = em.find(Aluno.class, 2L);
				aluno.setNome(entrada.nextLine());
				aluno.setData(new Date());

			}

			// // Grava no banco o aluno populado como Joao
			// em.persist(aluno);
			//
			// // faz um update do nome do aluno
			// // Aluno aluno = em.find(Aluno.class, 1L);
			// // aluno.setNome("Ana");
			//
			// // comita no banco
			et.commit();
			System.out.println("Salvo com sucesso");
			entrada.close();

		} catch (Exception ex) {
			et.rollback();
			System.out.println("Eroo" + ex);
		} finally {
			em.close();
			emf.close();
		}

	}

}