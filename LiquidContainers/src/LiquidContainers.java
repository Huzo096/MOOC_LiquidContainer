/*
Zadatak: Napraviti program za upravljanje dvama spremnicima s tekućinom. Spremnici su nazvani "prvi" i "drugi".
Svaki od njih može istodobno sadržavati maksimalu količinu od 100 litara tekućine.

Program sadrži funkcionalnost dodavanja, premještanja i uklanjanja tekućine. Korištenjem naredbe "add",
 tekućina će se dodati u prvi spremnik, "move" će premjestiti tekućinu iz prvog spremnika u drugi spremnik,
 a "remove" će ukloniti tekućinu iz drugog spremnika.
 */



import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //inicijalizacija prvog i drugog spremnika te postavljanje početnih količina na 0
        int first = 0;
        int second = 0;


        while (true) {
            System.out.println("First: " + first + "/" + "100");
            System.out.println("Second: " + second + "/" + "100");

            String input = scanner.nextLine();

            //ukoliko unesemo riječ "quit" - program prestaje s radom
            if (input.equals("quit")) {
                break;
            }
            //na pritisak razmaka, unos se dijeli na dva dijela
            String[] parts = input.split(" ");
            //drugi dio unosa s indeksom 1 sadrži količinu
            int amount=Integer.valueOf(parts[1]);
            //prvi dio unosa s indeksom 0 sadrži naredbu
            if (parts[0].equals("add") && amount>0){
                first+=amount;
            }
            //ukoliko dodamo količinu veću od 100, količina prvog spremnika automatski se postavlja na vrijednost 100
            if (first>100){
                first=100;
            }
            //ukoliko premještamo iz prvog spremnika u drugi količinu koja je jednaka ili manja količini koja se nalazi
            //u prvom spremniku, tad se ta količina oduzima od količine prvog spremnika i dodaje količini drugog
            if (parts[0].equals("move") && amount>0 && second<=100){
                if (first-amount>=0){
                    second+=amount;
                    first-=amount;
                }
                /*
                ukoliko želimo premjestiti količinu veću od one koja je trenutno u prvom spremniku, tada se automatski
                sva količina iz prvog premješta u drugi te se količina prvog postavlja na vrijednost 0
                 */
                else if (amount>first){
                    second+=first;
                    first=0;
                }
                /*
                ako u prvom spremniku imamo maksimalnu količinu, a u drugi želimo preseliti količinu veću od 100, tada
                će automatski količina drugog spremnika biti postavljena na 100...ili će biti postavljena na onu
                količinu koja je manja od 100, a trenutno se nalazi u prvom spremniku
                 */
                if (second>100){
                    second=100;
                }

            }
            /*
            naredba za uklanjanje količine iz drugog spremnika...ukoliko uklanjamo količinu koja je veća od one
            koja se trenutno nalazi u drugom spremniku, tada se količina drugog spremnika automatski postavlja na 0
             */
            if (parts[0].equals("remove") && amount>0){
                second-=amount;
                if (second<0){
                    second=0;
                }
            }
        }
    }

}