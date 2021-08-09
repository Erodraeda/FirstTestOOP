import java.time.LocalDate;
import java.util.ArrayList;

public class PlayList {

    private String titulo;
    private LocalDate criacao;
    private ArrayList<Musica> playlist = new ArrayList<>();
    private Intervalo duracaoPlaylist = new Intervalo(0, 0, 0);

    public PlayList(String titulo) {
        this.setTitulo(titulo);
        this.criacao = LocalDate.now();
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public LocalDate getDataCriacao() {
        return this.criacao;
    }

    public void addMusica(Musica m) {
        this.playlist.add(m);
        this.duracaoPlaylist.soma(m.getDuracao());
    }

    public void removeMusica(Musica m) {
        this.playlist.remove(m);
    }

    public void alterarPosicao(Musica m, int novaPosicao) {
        this.playlist.remove(m);
        this.playlist.add(novaPosicao, m);
    }

    public Musica getMusica(int pos) {
        return playlist.get(pos);
    }

    public ArrayList<Musica> getMusicas() {
        return playlist;
    }

    public int getTotalMusicas() {
        return playlist.size();
    }

    public Intervalo getDuracao() {
        return duracaoPlaylist;
    }

    public Musica reproduz() {
        int numDeMusicas = playlist.size();
        int randomSong = (int) Math.random() * (numDeMusicas);
        getMusica(randomSong).reproduz();
        return playlist.get(randomSong);
    }

}
