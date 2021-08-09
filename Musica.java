public class Musica {

    private String titulo;
    private Artista artista;
    private Intervalo duracao;
    private int reproducoes;

    public Musica(String titulo, Artista artista, Intervalo duracao, int reproducoes) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.reproducoes = reproducoes;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getArtista() {
        return artista.getNome();
    }

    public Intervalo getDuracao() {
        return this.duracao;
    }

    public int getReproducoes() {
        return this.reproducoes;
    }

    public void reproduz() {
        this.reproducoes++;
    }
}
