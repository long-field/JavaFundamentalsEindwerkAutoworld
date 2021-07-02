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


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws  VolumeException  { //main programma mag niet throwen dit moet in een try catch opgevangen worden per object dat je hier aanmaakt.

        var wagen1 = new Personenwagen("opel",500,4);
        var wagen2 = new Personenwagen("opel",501,5);
        var wagen3 = new Pickup("mercedes",1000,2,new Volume(5,5,5, Maat.METER));
        var wagen4 = new Pickup("mercedes",1001,2,new Volume(5,5,5, Maat.METER));
        var wagen5 = new Vrachtwagen("scania",1500, new Volume(10,10,10, Maat.METER),1000,2);
        var wagen6 = new Vrachtwagen("scania",1501, new Volume(10,10,10, Maat.METER),1000,2);

        var wagenpark = new TreeSet<Voertuig>();
        wagenpark.add(wagen1);
        wagenpark.add(wagen2);
        wagenpark.add(wagen3);
        wagenpark.add(wagen4);
        wagenpark.add(wagen5);
        wagenpark.add(wagen6);

        System.out.println("\nAlle wagens in het wagenpark: ");
        for(var wagen:wagenpark){
            System.out.println(wagen);
        }
        System.out.println("\nAlle vrachtwagens in het wagenpark: ");
        var vrachtStream = wagenpark.stream().filter(Vrachtwagen.class::isInstance).collect(Collectors.toList());
        for(var vracht:vrachtStream){
            System.out.println(vracht);
        }
        try (var stream = new ObjectOutputStream( Files.newOutputStream((Path.of("/Users/dietervanlangenaker/Desktop/data/wagenpark.dat"))))) {
            stream.writeObject(wagenpark);
        }
        catch (IOException ex) {
           System.err.println(ex);
        }
        System.out.println("\nAlle wagens in wagenpark.dat: ");
        try (FileInputStream fi = new FileInputStream("/Users/dietervanlangenaker/Desktop/data/wagenpark.dat")) {
            ObjectInputStream oi = new ObjectInputStream(fi);
            TreeSet sortedSetWagenpark = (TreeSet) oi.readObject();
            sortedSetWagenpark.forEach(item->System.out.println(item));
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        var boekentassen = new Boekentas[2];
        boekentassen[0]= new Boekentas("kaki",new Volume(20,10,10,Maat.CENTIMETER));
        boekentassen[1] = new Boekentas("rood",new Volume(25,10,10,Maat.CENTIMETER));

        System.out.println("\nAlle boekentassen: ");
        for (var boekentas:boekentassen) {
            System.out.println(boekentas);
        }
        var totlaadvolume= 0L;
        var laadbaarobjecten = new Laadbaar[6];
        laadbaarobjecten[0]=wagen3;
        laadbaarobjecten[1]=wagen4;
        laadbaarobjecten[2]=wagen5;
        laadbaarobjecten[3]=wagen6;
        laadbaarobjecten[4]= boekentassen[0];
        laadbaarobjecten[5]= boekentassen[1];

        System.out.println("\nAlle laadbaar objecten: ");
        for(var lader:laadbaarobjecten){
            System.out.println(lader);
            totlaadvolume += lader.getLaadvolume().getVolume();
        }
        System.out.println("\nHet totale laadvolume van de laadbaar objecten: "+totlaadvolume +  " CM3");

    }
}


