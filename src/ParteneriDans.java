import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Pereche {
    String numePartener1;
    String prenumePartener1;
    String numePartener2;
    String prenumePartener2;

    public Pereche(String nume1, String prenume1, String nume2, String prenume2) {
        this.numePartener1 = nume1;
        this.prenumePartener1 = prenume1;
        this.numePartener2 = nume2;
        this.prenumePartener2 = prenume2;
    }

    public String toString() {
        return numePartener1 + " " + prenumePartener1 + " și " +
               numePartener2 + " " + prenumePartener2;
    }
}

public class ParteneriDans {
    public static void main(String[] args) {
        ArrayList<Pereche> perechi = new ArrayList<>();

        perechi.add(new Pereche("Popescu", "Andrei", "Ionescu", "Maria"));
        perechi.add(new Pereche("Georgescu", "Alex", "Dumitru", "Ana"));
        perechi.add(new Pereche("Popescu", "Andrei", "Dobre", "Ioana"));
        perechi.add(new Pereche("Constantinescu", "Radu", "Ionescu", "Diana"));

        System.out.println("Lista inițială de perechi:");
        afiseazaLista(perechi);

        perechi.add(new Pereche("Marin", "Vlad", "Voicu", "Elena"));
        System.out.println("\nDupă adăugarea unei noi perechi:");
        afiseazaLista(perechi);

        perechi.removeIf(p -> p.numePartener1.equals("Popescu") && p.prenumePartener1.equals("Andrei"));
        System.out.println("\nDupă ștergerea perechii cu partenerul 'Popescu Andrei':");
        afiseazaLista(perechi);

        Collections.sort(perechi, new Comparator<Pereche>() {
            public int compare(Pereche p1, Pereche p2) {
                int cmpNume1 = p1.numePartener1.compareTo(p2.numePartener1);
                if (cmpNume1 != 0) return cmpNume1;
                return p1.numePartener2.compareTo(p2.numePartener2);
            }
        });

        System.out.println("\nLista sortată:");
        afiseazaLista(perechi);
    }

    public static void afiseazaLista(ArrayList<Pereche> perechi) {
        for (Pereche p : perechi) {
            System.out.println(p);
        }
    }
}

