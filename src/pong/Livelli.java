// Pong — Programmazione Orientata agli Oggetti e Laboratori, Udine, a.a. 2026-27
// Consegna 3: i livelli. Scadenza: domenica 8 novembre 2026.
package pong;

/**
 * Il gioco a livelli contro il giocatore automatico: a che livello si è e quante vite restano.
 * Si vince un livello vincendo una partita; perdendo una partita si perde una vita.
 * La Partita gli dice com'è finita ogni partita; il giocatore automatico e la velocità della palla
 * dipendono dal livello.
 *
 * IL PEZZO MANCANTE: i corpi dei metodi qui sotto (e i campi che vi servono).
 * Ogni metodo ha il suo contratto, nel commento sopra. I test ufficiali (ConsegnaTreTest) lo controllano.
 */
public class Livelli {
    private int vite;
    private final int viteIniziali;
    private final int numeroLivelli;
    private final Lato umano;
    private int current_level;
    private boolean completato;

    public Livelli(int numeroLivelli, int vite, Lato umano) {
        if ((numeroLivelli < 1) || (vite < 1) || (umano == null)) {
            throw new IllegalArgumentException("Parametri non validi");
        }
        this.numeroLivelli = numeroLivelli;
        this.viteIniziali = vite;
        this.vite = vite;
        this.umano = umano;
        this.current_level = 1;
        this.completato = false;
    }

    public int getLivello() {
        return current_level;
    }

    public int getNumeroLivelli() {
        return numeroLivelli;
    }

    public int getVite() {
        return vite;
    }

    public Lato getUmano() {
        return umano;
    }

    public boolean isCompletato() {
        return completato;
    }

    public boolean isPerso() {
        return vite == 0;
    }

    public boolean isFinito() {
        return isCompletato() || isPerso();
    }

    public void partitaFinita(Lato vincitore) {
        if (vincitore == null) {
            throw new IllegalArgumentException("Il vincitore non può essere null");
        }

        if (!isFinito()) {
            if (vincitore == umano) {
                if (current_level == numeroLivelli) {
                    completato = true; 
                } else {
                    current_level++; 
                }
            } else {
                vite--; 
            }
        }
    }

    public void ricomincia() {
        this.current_level = 1;
        this.vite = viteIniziali;
        this.completato = false;
    }
}
