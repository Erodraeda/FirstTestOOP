
//package ava_poo1;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestApp {
	static double nota = 0;

	static void printaGrupoTeste(ArrayList<Boolean> testes, String titulo, double peso) {
		System.out.print("conjunto de testes - " + titulo + ": ");
		int acertos = 0;
		for (boolean teste : testes) {
			if (teste) {
				System.out.print("o");
				acertos++;
			} else {
				System.out.print("x");
			}
		}
		double notaGrupo = acertos * peso / testes.size();
		System.out.println(" - " + acertos + "/" + testes.size() + "(" + notaGrupo + ")");
		nota += notaGrupo;
	}

	public static void main(String[] args) {
		// testes artista
		Artista cbjr = new Artista("Charlie Brown Jr");
		Artista rappa = new Artista("O Rappa");
		var t1 = new ArrayList<Boolean>();
		t1.add(cbjr.getNome().equals("Charlie Brown Jr"));

		// testes intervalo
		var t2 = new ArrayList<Boolean>();
		Intervalo int1 = new Intervalo(4, 110); // 00:05:50
		Intervalo int2 = new Intervalo(0, 116, 20); // 01:56:20
		t2.add(int1.getMinutos() == 5);
		t2.add(int1.getSegundos() == 50);
		t2.add(int1.getHoras() == 0);
		t2.add(int2.getHoras() == 1);
		int2.soma(int1); // 02:02:10
		t2.add(int2.getHoras() == 2);
		t2.add(int2.getMinutos() == 2);
		t2.add(int2.getSegundos() == 10);

		// testes música
		var t3 = new ArrayList<Boolean>();
		Musica m_r1 = new Musica("Vapor Barato", rappa, new Intervalo(4, 25), 0);
		Musica m_r2 = new Musica("Minha Alma (A Paz Que Eu Não Quero)", rappa, int1, 0);
		Musica m_r3 = new Musica("Me deixa", rappa, new Intervalo(3, 49), 0);

		t3.add(m_r1.getReproducoes() == 0);
		t3.add(m_r2.getDuracao() == int1);
		t3.add(m_r3.getTitulo().contentEquals("Me deixa"));

		Musica m_cb1 = new Musica("Céu Azul", cbjr, new Intervalo(3, 19), 1);
		Musica m_cb2 = new Musica("Senhor do Tempo", cbjr, new Intervalo(3, 22), 0);
		Musica m_cb3 = new Musica("Lugar ao Sol", cbjr, new Intervalo(3, 40), 0);
		Musica m_cb4 = new Musica("Como Tudo Deve Ser", cbjr, new Intervalo(4, 33), 0);
		m_cb2.reproduz();
		m_cb2.reproduz();
		t3.add(m_cb2.getReproducoes() == 2);

		// testes playlist

		var t4 = new ArrayList<Boolean>();
		PlayList p1 = new PlayList("Rock Brasileiro");
		PlayList p2 = new PlayList("playlist");

		p1.addMusica(m_r1);
		p1.addMusica(m_r2);
		p1.addMusica(m_r3);
		p1.addMusica(m_cb1);
		p1.addMusica(m_cb2);
		p1.addMusica(m_cb3);
		p1.addMusica(m_cb4);
		Intervalo total = p1.getDuracao();
		p1.alterarPosicao(m_cb3, 0); // colocando na posicao inicial da lista

		t4.add(p1.getTitulo().contentEquals("Rock Brasileiro"));
		t4.add(p1.getTotalMusicas() == 7);
		t4.add(p1.getDataCriacao().equals(LocalDate.now()));
		t4.add(total.getMinutos() == 28);
		t4.add(p1.getMusicas().get(0) == m_cb3);
		t4.add(p1.getMusicas().get(1) == m_r1);

		p1.removeMusica(m_cb1);
		p2.setTitulo("Músicas azuis! :D");
		p2.addMusica(m_cb1);
		p2.reproduz();
		p2.reproduz();
		p2.reproduz();
		t4.add(p2.getMusicas().get(0).getReproducoes() == 4);
		t4.add(p1.getTotalMusicas() == 6);
		t4.add(p2.getTitulo().equals("Músicas azuis! :D"));

		printaGrupoTeste(t1, "artista", 0.25); // o --> acerto, x --> erro
		printaGrupoTeste(t2, "intervalo", 2.5); // o --> acerto, x --> erro
		printaGrupoTeste(t3, "música", 1.25); // o --> acerto, x --> erro
		printaGrupoTeste(t4, "playlist", 3); // o --> acerto, x --> erro
		System.out.println("Nota Parcial: " + nota + "/7");
	}

}
