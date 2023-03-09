package order_set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ExemploOrdenacaoSet {

	public static void main(String[] args) {
		
		System.out.println("Exiba oderm aleatoria");
		Set<Serie> minhasSeries = new HashSet<>() {{
			add(new Serie("GOT", "Fantasia", 60));
			add(new Serie("PeakBlinders", "Ação", 50));
			add(new Serie("Vikings", "Fantasia", 55));
		}};
		for (Serie serie : minhasSeries) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}
		
		
		System.out.println("ordem de inserção");
		Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
			add(new Serie("GOT", "Fantasia", 60));
			add(new Serie("PeakBlinders", "Ação", 50));
			add(new Serie("Vikings", "Fantasia", 55));
		}};
		for (Serie serie : minhasSeries1) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}
		
		
		System.out.println("Ordem natural (tempo de episodio)");
		Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
		for (Serie serie : minhasSeries2) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}

		System.out.println("Ordem nome/genero/tempo");
		Set<Serie> minhaSerie4 = new TreeSet<>(new CompareToNomeGeneroTempo());
		minhaSerie4.addAll(minhasSeries);
		for (Serie serie : minhasSeries2) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}
	}

}

class Serie implements Comparable<Serie>{
	
	private String nome;
	private String genero;
	private int tempoEpisodio;
	
	public Serie(String nome, String genero, int tempoEpisodio) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.tempoEpisodio = tempoEpisodio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTempoEpisodio() {
		return tempoEpisodio;
	}

	public void setTempoEpisodio(int tempoEpisodio) {
		this.tempoEpisodio = tempoEpisodio;
	}

	@Override
	public String toString() {
		return "Serie [nome=" + nome + ", genero=" + genero + ", tempoEpisodio=" + tempoEpisodio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(genero, nome, tempoEpisodio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(nome, other.nome)
				&& tempoEpisodio == other.tempoEpisodio;
	}

	@Override
	public int compareTo(Serie serie) {
		int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
		if (tempoEpisodio != 0 ) return tempoEpisodio;
		
		return this.getGenero().compareTo(serie.getGenero());
		
	}
		
}


class CompareToNomeGeneroTempo implements Comparator<Serie> {

	@Override
	public int compare(Serie o1, Serie o2) {
		int nome = o1.getNome().compareTo(o2.getNome());
		if(nome != 0) return nome;
		
		int genero = o1.getGenero().compareTo(o2.getGenero());
		if(genero != 0) return genero;

		return Integer.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());
	}

	
}






