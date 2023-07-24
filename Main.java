package cz.itnetwork;


import java.util.List;
import java.util.Scanner;

public class Main {
    //příprava scanneru a evidence abych to mohl používat v celé main classe (proto static)
    private static Scanner scanner;
    private static Evidence evidence;

    //main metoda
    public static void main(String[] args) {
        //inicializace scanneru a evidence
        scanner = new Scanner(System.in);
        evidence = new Evidence();

        boolean konec = false;
        //loop který běží dokud uživatel nedá konec (4)
        while(!konec){
            System.out.println("---------------------");
            System.out.println("Evidence pojištěných");
            System.out.println("---------------------");
            System.out.println("1 - Přidat pojištěného");
            System.out.println("2 - Zobrazit seznam všech pojištěných");
            System.out.println("3 - Vyhledat pojištěného podle jména a příjmení");
            System.out.println("4 - Konec");

            int volba = scanner.nextInt();

            switch (volba){
                //metody které jsou níže
                case 1:
                    pridatPojisteneho();
                    break;
                case 2:
                    zobrazitSeznam();
                    break;
                case 3:
                    vyhledatPojisteneho();
                    break;
                case 4:
                    konec = true;
                    break;
                default:
                    System.out.println("Neplatná volba");
                    break;
            }
        }
    }
    //metoda pro přidání pojištěného. Tyto metody by mohly být v evidenci, hodil sem je sem pro přehlednost
    //všechny jsou "static" abych je mohl použít v main metodě
    private static void pridatPojisteneho(){
        //získání všech parametrů pro pojištěného
        System.out.println("Zadejte jméno:");
        String jmeno = scanner.next();

        System.out.println("Zadejte přijímení:");
        String prijimeni = scanner.next();

        System.out.println("Zadejte věk:");
        int vek = scanner.nextInt();

        System.out.println("Zadejte telefoní číslo:");
        String telefon = scanner.next();

        //vytvoření pojištěného a přidání do seznamu pojištěných
        Pojisteny pojisteny = new Pojisteny(jmeno , prijimeni, vek , telefon);

        // metoda kterou máme v classe "Evidence"
        evidence.pridatPojisteneho(pojisteny);

        System.out.println("Pojištěný byl přidán.");
    }
    private static void zobrazitSeznam(){
        // získání seznamu
        // metoda kterou máme v classe "Evidence"
        List<Pojisteny> seznam = evidence.getSeznamPojistenych();

        //když je seznam prázdný
        if(seznam.isEmpty()){
            System.out.println("V evidenci nejsou žádní pojištění");
        }
        // kdyý je někdo v seznamu
        else{
            System.out.println("Seznam všech pojištěných:");
            //výpis všech pojištěných
            for(Pojisteny p : seznam){
                System.out.println(p.toString());
            }
        }
    }
    private static void vyhledatPojisteneho(){
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = scanner.next();

        System.out.println("Zadejte pařijímení pojištěného:");
        String prijimeni = scanner.next();

        // metoda kterou máme v classe "Evidence"
        Pojisteny pojisteny = evidence.najdiPojisteneho(jmeno, prijimeni);

        if(pojisteny != null){
            System.out.println("Pojištěný byl nalezen:");
            System.out.println(pojisteny.toString());
        }else{
            System.out.println("Pojištěný s daným jménem a přijímením nebyl nalezen.");
        }
    }
}