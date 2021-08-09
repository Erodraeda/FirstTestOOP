public class Artista {

    private String nome;

    public Artista(String nome) {
        setNome(nome);
    }

    public Artista() {
        getNome();
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
