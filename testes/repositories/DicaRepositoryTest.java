package repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entities.Usuario;
import entities.Dica;

public class DicaRepositoryTest {
	private DicaRepositoryArrayList dicaRepositoryArrayList;
	private DicaRepositoryLinkedList dicaRepositoryLinkedList;
	private DicaRepositoryDeque dicaRepositoryDeque;
	private DicaRepositoryHashMap dicaRepositoryHashMap;
	private DicaRepositoryLinkedHashMap dicaRepositoryLinkedHashMap;
	private DicaRepositoryTreeSet dicaRepositoryTreeSet;

	private Usuario u1;

	@BeforeEach
	void setUp() {
		this.dicaRepositoryArrayList = new DicaRepositoryArrayList();
		this.dicaRepositoryLinkedList = new DicaRepositoryLinkedList();
		this.dicaRepositoryDeque = new DicaRepositoryDeque();
		this.dicaRepositoryHashMap = new DicaRepositoryHashMap();
		this.dicaRepositoryLinkedHashMap = new DicaRepositoryLinkedHashMap();
		this.dicaRepositoryTreeSet = new DicaRepositoryTreeSet();

		this.u1 = new Usuario("Fulano", "123.456.789-00", "1234", "123456789");
	}

	@Test
	void testAdiconaDica() {
		Dica d1 = new Dica(u1, "PesquisaExtensao");
		Dica d2 = new Dica(u1, "Monitoria");
		Dica d3 = new Dica(u1, "Estagio");
		Dica d4 = new Dica(u1, "RepresentacaoEstudantil");

		assertEquals(1, this.dicaRepositoryArrayList.adicionaDica(d1));
		assertEquals(2, this.dicaRepositoryArrayList.adicionaDica(d2));
		assertEquals(3, this.dicaRepositoryArrayList.adicionaDica(d3));
		assertEquals(4, this.dicaRepositoryArrayList.adicionaDica(d4));

		assertEquals(1, this.dicaRepositoryLinkedList.adicionaDica(d1));
		assertEquals(2, this.dicaRepositoryLinkedList.adicionaDica(d2));
		assertEquals(3, this.dicaRepositoryLinkedList.adicionaDica(d3));
		assertEquals(4, this.dicaRepositoryLinkedList.adicionaDica(d4));

		assertEquals(1, this.dicaRepositoryDeque.adicionaDica(d1));
		assertEquals(2, this.dicaRepositoryDeque.adicionaDica(d2));
		assertEquals(3, this.dicaRepositoryDeque.adicionaDica(d3));
		assertEquals(4, this.dicaRepositoryDeque.adicionaDica(d4));

		assertEquals(1, this.dicaRepositoryHashMap.adicionaDica(d1));
		assertEquals(2, this.dicaRepositoryHashMap.adicionaDica(d2));
		assertEquals(3, this.dicaRepositoryHashMap.adicionaDica(d3));
		assertEquals(4, this.dicaRepositoryHashMap.adicionaDica(d4));

		assertEquals(1, this.dicaRepositoryLinkedHashMap.adicionaDica(d1));
		assertEquals(2, this.dicaRepositoryLinkedHashMap.adicionaDica(d2));
		assertEquals(3, this.dicaRepositoryLinkedHashMap.adicionaDica(d3));
		assertEquals(4, this.dicaRepositoryLinkedHashMap.adicionaDica(d4));

		assertEquals(1, this.dicaRepositoryTreeSet.adicionaDica(d1));
		assertEquals(2, this.dicaRepositoryTreeSet.adicionaDica(d2));
		assertEquals(3, this.dicaRepositoryTreeSet.adicionaDica(d3));
		assertEquals(4, this.dicaRepositoryTreeSet.adicionaDica(d4));
	}

	@Test
	void testAdicionaDicaNula() {
		String mensagem = assertThrows(NullPointerException.class, () -> {
			this.dicaRepositoryArrayList.adicionaDica(null);
		}).getMessage();
		assertEquals("A dica não pode ser nula", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.dicaRepositoryLinkedList.adicionaDica(null);
		}).getMessage();
		assertEquals("A dica não pode ser nula", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.dicaRepositoryDeque.adicionaDica(null);
		}).getMessage();
		assertEquals("A dica não pode ser nula", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.dicaRepositoryHashMap.adicionaDica(null);
		}).getMessage();
		assertEquals("A dica não pode ser nula", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.dicaRepositoryLinkedHashMap.adicionaDica(null);
		}).getMessage();
		assertEquals("A dica não pode ser nula", mensagem);

		mensagem = assertThrows(NullPointerException.class, () -> {
			this.dicaRepositoryTreeSet.adicionaDica(null);
		}).getMessage();
		assertEquals("A dica não pode ser nula", mensagem);
	}

	@Test
	void testListaDicasVazia() {
		String[] dicas = this.dicaRepositoryArrayList.listaDicas();
		assertEquals(0, dicas.length);

		dicas = this.dicaRepositoryLinkedList.listaDicas();
		assertEquals(0, dicas.length);

		dicas = this.dicaRepositoryDeque.listaDicas();
		assertEquals(0, dicas.length);

		dicas = this.dicaRepositoryHashMap.listaDicas();
		assertEquals(0, dicas.length);

		dicas = this.dicaRepositoryLinkedHashMap.listaDicas();
		assertEquals(0, dicas.length);

		dicas = this.dicaRepositoryTreeSet.listaDicas();
		assertEquals(0, dicas.length);
	}

	@Test
	void testListaDicas() {
		Dica d1 = new Dica(u1, "PesquisaExtensao");
		Dica d2 = new Dica(u1, "Monitoria");
		Dica d3 = new Dica(u1, "Estagio");
		Dica d4 = new Dica(u1, "RepresentacaoEstudantil");

		this.dicaRepositoryArrayList.adicionaDica(d1);
		this.dicaRepositoryArrayList.adicionaDica(d2);
		this.dicaRepositoryArrayList.adicionaDica(d3);
		this.dicaRepositoryArrayList.adicionaDica(d4);

		this.dicaRepositoryLinkedList.adicionaDica(d1);
		this.dicaRepositoryLinkedList.adicionaDica(d2);
		this.dicaRepositoryLinkedList.adicionaDica(d3);
		this.dicaRepositoryLinkedList.adicionaDica(d4);

		this.dicaRepositoryDeque.adicionaDica(d1);
		this.dicaRepositoryDeque.adicionaDica(d2);
		this.dicaRepositoryDeque.adicionaDica(d3);
		this.dicaRepositoryDeque.adicionaDica(d4);

		this.dicaRepositoryHashMap.adicionaDica(d1);
		this.dicaRepositoryHashMap.adicionaDica(d2);
		this.dicaRepositoryHashMap.adicionaDica(d3);
		this.dicaRepositoryHashMap.adicionaDica(d4);

		this.dicaRepositoryLinkedHashMap.adicionaDica(d1);
		this.dicaRepositoryLinkedHashMap.adicionaDica(d2);
		this.dicaRepositoryLinkedHashMap.adicionaDica(d3);
		this.dicaRepositoryLinkedHashMap.adicionaDica(d4);

		this.dicaRepositoryTreeSet.adicionaDica(d1);
		this.dicaRepositoryTreeSet.adicionaDica(d2);
		this.dicaRepositoryTreeSet.adicionaDica(d3);
		this.dicaRepositoryTreeSet.adicionaDica(d4);

		String[] dicas = this.dicaRepositoryArrayList.listaDicas();
		assertEquals(d1.toString(), dicas[0]);
		assertEquals(d2.toString(), dicas[1]);
		assertEquals(d3.toString(), dicas[2]);
		assertEquals(d4.toString(), dicas[3]);

		dicas = this.dicaRepositoryLinkedList.listaDicas();
		assertEquals(d1.toString(), dicas[0]);
		assertEquals(d2.toString(), dicas[1]);
		assertEquals(d3.toString(), dicas[2]);
		assertEquals(d4.toString(), dicas[3]);

		dicas = this.dicaRepositoryDeque.listaDicas();
		assertEquals(d1.toString(), dicas[0]);
		assertEquals(d2.toString(), dicas[1]);
		assertEquals(d3.toString(), dicas[2]);
		assertEquals(d4.toString(), dicas[3]);

		dicas = this.dicaRepositoryHashMap.listaDicas();
		assertEquals(d1.toString(), dicas[0]);
		assertEquals(d2.toString(), dicas[1]);
		assertEquals(d3.toString(), dicas[2]);
		assertEquals(d4.toString(), dicas[3]);

		dicas = this.dicaRepositoryLinkedHashMap.listaDicas();
		assertEquals(d1.toString(), dicas[0]);
		assertEquals(d2.toString(), dicas[1]);
		assertEquals(d3.toString(), dicas[2]);
		assertEquals(d4.toString(), dicas[3]);

		dicas = this.dicaRepositoryTreeSet.listaDicas();
		assertEquals(d1.toString(), dicas[0]);
		assertEquals(d2.toString(), dicas[1]);
		assertEquals(d3.toString(), dicas[2]);
		assertEquals(d4.toString(), dicas[3]);
	}

	@Test
	void testBuscaDica() {
		Dica d1 = new Dica(u1, "PesquisaExtensao");
		Dica d2 = new Dica(u1, "Monitoria");
		Dica d3 = new Dica(u1, "Estagio");
		Dica d4 = new Dica(u1, "RepresentacaoEstudantil");

		this.dicaRepositoryArrayList.adicionaDica(d1);
		this.dicaRepositoryArrayList.adicionaDica(d2);
		this.dicaRepositoryArrayList.adicionaDica(d3);
		this.dicaRepositoryArrayList.adicionaDica(d4);

		assertEquals(d1, this.dicaRepositoryArrayList.buscaDica(1));
		assertEquals(d2, this.dicaRepositoryArrayList.buscaDica(2));
		assertEquals(d3, this.dicaRepositoryArrayList.buscaDica(3));
		assertEquals(d4, this.dicaRepositoryArrayList.buscaDica(4));

		this.dicaRepositoryLinkedList.adicionaDica(d1);
		this.dicaRepositoryLinkedList.adicionaDica(d2);
		this.dicaRepositoryLinkedList.adicionaDica(d3);
		this.dicaRepositoryLinkedList.adicionaDica(d4);

		assertEquals(d1, this.dicaRepositoryLinkedList.buscaDica(1));
		assertEquals(d2, this.dicaRepositoryLinkedList.buscaDica(2));
		assertEquals(d3, this.dicaRepositoryLinkedList.buscaDica(3));
		assertEquals(d4, this.dicaRepositoryLinkedList.buscaDica(4));

		this.dicaRepositoryDeque.adicionaDica(d1);
		this.dicaRepositoryDeque.adicionaDica(d2);
		this.dicaRepositoryDeque.adicionaDica(d3);
		this.dicaRepositoryDeque.adicionaDica(d4);

		assertEquals(d1, this.dicaRepositoryDeque.buscaDica(1));
		assertEquals(d2, this.dicaRepositoryDeque.buscaDica(2));
		assertEquals(d3, this.dicaRepositoryDeque.buscaDica(3));
		assertEquals(d4, this.dicaRepositoryDeque.buscaDica(4));

		this.dicaRepositoryHashMap.adicionaDica(d1);
		this.dicaRepositoryHashMap.adicionaDica(d2);
		this.dicaRepositoryHashMap.adicionaDica(d3);
		this.dicaRepositoryHashMap.adicionaDica(d4);

		assertEquals(d1, this.dicaRepositoryHashMap.buscaDica(1));
		assertEquals(d2, this.dicaRepositoryHashMap.buscaDica(2));
		assertEquals(d3, this.dicaRepositoryHashMap.buscaDica(3));
		assertEquals(d4, this.dicaRepositoryHashMap.buscaDica(4));

		this.dicaRepositoryLinkedHashMap.adicionaDica(d1);
		this.dicaRepositoryLinkedHashMap.adicionaDica(d2);
		this.dicaRepositoryLinkedHashMap.adicionaDica(d3);
		this.dicaRepositoryLinkedHashMap.adicionaDica(d4);

		assertEquals(d1, this.dicaRepositoryLinkedHashMap.buscaDica(1));
		assertEquals(d2, this.dicaRepositoryLinkedHashMap.buscaDica(2));
		assertEquals(d3, this.dicaRepositoryLinkedHashMap.buscaDica(3));
		assertEquals(d4, this.dicaRepositoryLinkedHashMap.buscaDica(4));

		this.dicaRepositoryTreeSet.adicionaDica(d1);
		this.dicaRepositoryTreeSet.adicionaDica(d2);
		this.dicaRepositoryTreeSet.adicionaDica(d3);
		this.dicaRepositoryTreeSet.adicionaDica(d4);

		assertEquals(d1, this.dicaRepositoryTreeSet.buscaDica(1));
		assertEquals(d2, this.dicaRepositoryTreeSet.buscaDica(2));
		assertEquals(d3, this.dicaRepositoryTreeSet.buscaDica(3));
		assertEquals(d4, this.dicaRepositoryTreeSet.buscaDica(4));
	}

	@Test
	void testBuscaDicaPosicaoInvalida() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.dicaRepositoryArrayList.buscaDica(1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			this.dicaRepositoryLinkedList.buscaDica(1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			this.dicaRepositoryDeque.buscaDica(1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			this.dicaRepositoryHashMap.buscaDica(1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			this.dicaRepositoryLinkedHashMap.buscaDica(1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			this.dicaRepositoryTreeSet.buscaDica(1);
		});
	}

}
