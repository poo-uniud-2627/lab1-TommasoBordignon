package pong;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MieiTest {

    @Test
    public void testPerdendoPartitaSiPerdeUnaVitaEIlLivelloRestaUguale() {
        // Simuliamo una partita: 5 livelli, 3 vite iniziali, io sono a SINISTRA
        Livelli livelli = new Livelli(5, 3, Lato.SINISTRA);

        // Simulo la sconfitta a favore del Giocatore Automatico (DESTRA)
        livelli.partitaFinita(Lato.DESTRA);

        // Il livello non deve retrocedere, deve restare 1
        assertEquals(1, livelli.getLivello(), "Il livello non deve cambiare quando si perde una partita.");

        // Le vite devono diminuire da 3 a 2
        assertEquals(2, livelli.getVite(), "Dovrei aver perso esattamente una vita.");
    }
}