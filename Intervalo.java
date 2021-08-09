public class Intervalo {

    private int tempo;

    public Intervalo(int horas, int minutos, int segundos) {
        this.tempo += horas * 3600;
        this.tempo += minutos * 60;
        this.tempo += segundos;
    }

    public Intervalo(int minutos, int segundos) {
        this.tempo += minutos * 60;
        this.tempo += segundos;
    }

    public int getHoras() {
        return this.tempo / 3600;
    }

    public int getMinutos() {
        return (this.tempo % 3600) / 60; // Remover horas, mantendo apenas minutos
    }

    public int getSegundos() {
        return this.tempo % 60; // Remover minutos, mantendo apenas segundos
    }

    public int soma(Intervalo i) {
        this.tempo += i.tempo;
        return this.tempo;
    }

}
