package repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Usuario;

public class UsuarioRepositoryTest {

	private UsuarioRepositoryHashMap usuarioRepositoryHashMap;
	private UsuarioRepositoryTreeMap usuarioRepositoryTreeMap;
	private UsuarioRepositoryHashSet usuarioRepositoryHashSet;
	private UsuarioRepositoryArrayList usuarioRepositoryArrayList;
	private UsuarioRepositoryLinkedHashMap usuarioRepositoryLinkedHashMap;
	private UsuarioRepositoryTreeSet usuarioRepositoryTreeSet;

	@BeforeEach
	void setUp() {
		this.usuarioRepositoryHashMap = new UsuarioRepositoryHashMap();
		this.usuarioRepositoryTreeMap = new UsuarioRepositoryTreeMap();
		this.usuarioRepositoryHashSet = new UsuarioRepositoryHashSet();
		this.usuarioRepositoryArrayList = new UsuarioRepositoryArrayList();
		this.usuarioRepositoryLinkedHashMap = new UsuarioRepositoryLinkedHashMap();
		this.usuarioRepositoryTreeSet = new UsuarioRepositoryTreeSet();
	}

	@Test
	void testAdicionaEstudante() {
		Usuario u1 = new Usuario("Fulano", "123.456.789-00", "1234", "123456789");

		assertTrue(this.usuarioRepositoryHashMap.adicionaEstudante(u1));
		assertTrue(this.usuarioRepositoryTreeMap.adicionaEstudante(u1));
		assertTrue(this.usuarioRepositoryHashSet.adicionaEstudante(u1));
		assertTrue(this.usuarioRepositoryArrayList.adicionaEstudante(u1));
		assertTrue(this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u1));
		assertTrue(this.usuarioRepositoryTreeSet.adicionaEstudante(u1));
	}

	@Test
	void testAdicionaEstudanteNulo() {
		String mensagem = assertThrows(NullPointerException.class, () -> {
			this.usuarioRepositoryHashMap.adicionaEstudante(null);
		}).getMessage();
		assertEquals("O usuário não pode ser nulo", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.usuarioRepositoryTreeMap.adicionaEstudante(null);
		}).getMessage();
		assertEquals("O usuário não pode ser nulo", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.usuarioRepositoryHashSet.adicionaEstudante(null);
		}).getMessage();
		assertEquals("O usuário não pode ser nulo", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.usuarioRepositoryArrayList.adicionaEstudante(null);
		}).getMessage();
		assertEquals("O usuário não pode ser nulo", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.usuarioRepositoryLinkedHashMap.adicionaEstudante(null);
		}).getMessage();
		assertEquals("O usuário não pode ser nulo", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.usuarioRepositoryTreeSet.adicionaEstudante(null);
		}).getMessage();
		assertEquals("O usuário não pode ser nulo", mensagem);
	}

	@Test
	void testAdicionaEstudanteDuplicado() {
		Usuario u1 = new Usuario("Fulano", "123.456.789-00", "1234", "123456789");
		Usuario u2 = new Usuario("Fulano", "987.654.321-00", "1234", "123456789");

		this.usuarioRepositoryHashMap.adicionaEstudante(u1);
		this.usuarioRepositoryTreeMap.adicionaEstudante(u1);
		this.usuarioRepositoryHashSet.adicionaEstudante(u1);
		this.usuarioRepositoryArrayList.adicionaEstudante(u1);
		this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u1);
		this.usuarioRepositoryTreeSet.adicionaEstudante(u1);

		assertFalse(this.usuarioRepositoryHashMap.adicionaEstudante(u1));
		assertFalse(this.usuarioRepositoryTreeMap.adicionaEstudante(u1));
		assertFalse(this.usuarioRepositoryHashSet.adicionaEstudante(u1));
		assertFalse(this.usuarioRepositoryArrayList.adicionaEstudante(u1));
		assertFalse(this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u1));
		assertFalse(this.usuarioRepositoryTreeSet.adicionaEstudante(u1));

		// é permitido usuários de nomes iguais, se os CPFs forem diferentes
		assertTrue(this.usuarioRepositoryTreeSet.adicionaEstudante(u2));
	}

	@Test
	void testListaEstudantesOrdenadoPeloNome() {
		Usuario u1 = new Usuario("Fulano", "123.456.789-00", "1234", "123456789");
		Usuario u2 = new Usuario("Beltrano", "987.654.321-00", "4321", "987654321");

		this.usuarioRepositoryHashMap.adicionaEstudante(u1);
		this.usuarioRepositoryHashMap.adicionaEstudante(u2);

		this.usuarioRepositoryTreeMap.adicionaEstudante(u1);
		this.usuarioRepositoryTreeMap.adicionaEstudante(u2);

		this.usuarioRepositoryHashSet.adicionaEstudante(u1);
		this.usuarioRepositoryHashSet.adicionaEstudante(u2);

		this.usuarioRepositoryArrayList.adicionaEstudante(u1);
		this.usuarioRepositoryArrayList.adicionaEstudante(u2);

		this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u1);
		this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u2);

		this.usuarioRepositoryTreeSet.adicionaEstudante(u1);
		this.usuarioRepositoryTreeSet.adicionaEstudante(u2);

		String[] lista = this.usuarioRepositoryHashMap.listaEstudantes();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[1]);

		lista = this.usuarioRepositoryTreeMap.listaEstudantes();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[1]);

		lista = this.usuarioRepositoryHashSet.listaEstudantes();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[1]);

		lista = this.usuarioRepositoryArrayList.listaEstudantes();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[1]);

		lista = this.usuarioRepositoryLinkedHashMap.listaEstudantes();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[1]);

		lista = this.usuarioRepositoryTreeSet.listaEstudantes();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[1]);
	}

	@Test
	void testListaEstudantesVazio() {
		String[] lista = this.usuarioRepositoryHashMap.listaEstudantes();
		assertEquals(0, lista.length);

		lista = this.usuarioRepositoryTreeMap.listaEstudantes();
		assertEquals(0, lista.length);

		lista = this.usuarioRepositoryHashSet.listaEstudantes();
		assertEquals(0, lista.length);

		lista = this.usuarioRepositoryArrayList.listaEstudantes();
		assertEquals(0, lista.length);

		lista = this.usuarioRepositoryLinkedHashMap.listaEstudantes();
		assertEquals(0, lista.length);

		lista = this.usuarioRepositoryTreeSet.listaEstudantes();
		assertEquals(0, lista.length);
	}

	@Test
	void testListaEstudantesOrdenadoPeloRankingDicas() {
		Usuario u1 = new Usuario("Fulano", "123.456.789-00", "1234", "123456789");
		u1.recebeBonificacao(10);

		Usuario u2 = new Usuario("Beltrano", "987.654.321-00", "4321", "987654321");
		u2.recebeBonificacao(20);

		Usuario u3 = new Usuario("Ciclano", "123.456.789-01", "1234", "123456987");
		u3.recebeBonificacao(15);

		this.usuarioRepositoryHashMap.adicionaEstudante(u1);
		this.usuarioRepositoryHashMap.adicionaEstudante(u2);
		this.usuarioRepositoryHashMap.adicionaEstudante(u3);

		this.usuarioRepositoryTreeMap.adicionaEstudante(u1);
		this.usuarioRepositoryTreeMap.adicionaEstudante(u2);
		this.usuarioRepositoryTreeMap.adicionaEstudante(u3);

		this.usuarioRepositoryHashSet.adicionaEstudante(u1);
		this.usuarioRepositoryHashSet.adicionaEstudante(u2);
		this.usuarioRepositoryHashSet.adicionaEstudante(u3);

		this.usuarioRepositoryArrayList.adicionaEstudante(u1);
		this.usuarioRepositoryArrayList.adicionaEstudante(u2);
		this.usuarioRepositoryArrayList.adicionaEstudante(u3);

		this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u1);
		this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u2);
		this.usuarioRepositoryLinkedHashMap.adicionaEstudante(u3);

		this.usuarioRepositoryTreeSet.adicionaEstudante(u1);
		this.usuarioRepositoryTreeSet.adicionaEstudante(u2);
		this.usuarioRepositoryTreeSet.adicionaEstudante(u3);

		String[] lista = this.usuarioRepositoryHashMap.listaEstudantesRankingDicas();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Ciclano, matrícula 123456987", lista[1]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[2]);

		lista = this.usuarioRepositoryTreeMap.listaEstudantesRankingDicas();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Ciclano, matrícula 123456987", lista[1]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[2]);

		lista = this.usuarioRepositoryHashSet.listaEstudantesRankingDicas();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Ciclano, matrícula 123456987", lista[1]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[2]);

		lista = this.usuarioRepositoryArrayList.listaEstudantesRankingDicas();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Ciclano, matrícula 123456987", lista[1]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[2]);

		lista = this.usuarioRepositoryLinkedHashMap.listaEstudantesRankingDicas();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Ciclano, matrícula 123456987", lista[1]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[2]);

		lista = this.usuarioRepositoryTreeSet.listaEstudantesRankingDicas();
		assertEquals("Nome: Beltrano, matrícula 987654321", lista[0]);
		assertEquals("Nome: Ciclano, matrícula 123456987", lista[1]);
		assertEquals("Nome: Fulano, matrícula 123456789", lista[2]);
	}
}