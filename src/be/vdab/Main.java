package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {


    public static void main(String[] args) throws VolumeException {

        Set<Voertuig> lijstWagenpark = new TreeSet<>();
        Personenwagen p1 = new Personenwagen("Tesla", 150000, 5);
        Personenwagen p2 = new Personenwagen("Volga", 10000, 4);
        Pickup pu1 = new Pickup("Mercedes", 25500, 5, new Volume(194, 40, 250, Maat.CENTIMETER));
        Pickup pu2 = new Pickup("Volkswagen", 45000, 2, new Volume(204, 45, 350, Maat.CENTIMETER));
        Vrachtwagen v1 = new Vrachtwagen("Volvo", 175000, new Volume(249, 350, 1100, Maat.CENTIMETER), 50000, 6);
        Vrachtwagen v2 = new Vrachtwagen("DAF", 210000, new Volume(250, 320, 750, Maat.CENTIMETER), 35000, 4);


        lijstWagenpark.add(p1);
        lijstWagenpark.add(p2);
        lijstWagenpark.add(pu1);
        lijstWagenpark.add(pu2);
        lijstWagenpark.add(v1);
        lijstWagenpark.add(v2);

        System.out.println("\n*** Treeset van voertuigen ***");
        lijstWagenpark.stream().forEach(voertuig -> System.out.println(voertuig));

        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("/data/wagenpark.dat")))) {
            stream.writeObject(lijstWagenpark);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("\n*** Lezen van het wagenpark bestand ***");
        try (InputStream inputStream = Files.newInputStream(Paths.get("/data/wagenpark.dat"));
             ObjectInputStream stream = new ObjectInputStream(inputStream)) {
            Set<Voertuig> lijstwagenpark2 = (TreeSet) stream.readObject();

            System.out.println(lijstwagenpark2);

        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("\n*** List van boekentas objecten ***");
        List<Boekentas> lijstBoekentassen = new ArrayList<>();
        Boekentas b1 = new Boekentas("rood", new Volume(20, 30,15, Maat.CENTIMETER ));
        Boekentas b2 = new Boekentas("groen", new Volume(45, 30, 20, Maat.CENTIMETER ));
        Boekentas b3 = new Boekentas("geel", new Volume(50, 40, 25, Maat.CENTIMETER));

        lijstBoekentassen.add(b1);
        lijstBoekentassen.add(b2);
        lijstBoekentassen.add(b3);

        lijstBoekentassen.stream().forEach(boekentas-> System.out.println(boekentas));

        System.out.println("\n*** Array van laadbare objecten ***");
        Laadbaar[] laadbaarObjecten = new Laadbaar[5];
        laadbaarObjecten[0] = pu1;
        laadbaarObjecten[1] = v1;
        laadbaarObjecten[2] = v2;
        laadbaarObjecten[3] = b1;
        laadbaarObjecten[4] = b2;

        Arrays.stream(laadbaarObjecten).forEach(System.out::println);

        System.out.println("\n*** Totale laadvolume van de laadbaar objecten ***");
        Arrays.stream(laadbaarObjecten).map(Laadbaar::getLaadVolume).map(Volume::getVolume).reduce(Long::sum).ifPresent(System.out::println);






    }
}
