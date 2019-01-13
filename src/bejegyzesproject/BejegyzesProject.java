
package bejegyzesproject;





public class BejegyzesProject {

    public static void main(String[] args) {
        
        Bejegyzes b = new Bejegyzes("Kolompár Nikolausz", "IF YOU LIKE THIS, YOU CAN WIN AN IPHONE XS MAX");
        
        //b.setLikeok(8999);
        b.like();
        Bejegyzes b2 = new Bejegyzes("Anya", "Hazafelé vegyél kenyeret!");
        //b2.setLikeok(18999);
        
       // b.osszkiir();
        
       // System.out.println(b);
        
        Bejegyzes sok = new Bejegyzes("bejegyzesek.txt");
        sok.hozzaAd(b);
        sok.hozzaAd(b2);
        
        
        sok.randomLike();
        sok.osszkiir();
        //System.out.println(sok.getBejegyzesek());

        
        
        System.out.println("\n\nA legnépszerübb bejegyzes: "+sok.legnepszerubbBejegyzes());
        System.out.println("Van-e 35-nél több likeot kapott bejegyzés?: "+sok.tobbMintXLikeosE(35));
        System.out.println("Van-e 15-nél kevesebb likeot kapott bejegyzés?: "+sok.kisebbMintXMegszamol(15));
        sok.rendezes();
        System.out.println("\nRendezett\n");
        sok.osszkiir();
        
        sok.fajlIras("bejegyzesek_rendezett.txt");
        
        
    }
    
}
