package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Concerto extends Evento {

    private boolean instreaming;

    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Concerto() {

    }

    public Concerto(boolean inStreaming, Genere genere) {
        this.instreaming = inStreaming;
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return instreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.instreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "instreaming=" + instreaming +
                ", genere=" + genere +
                '}';
    }
}
