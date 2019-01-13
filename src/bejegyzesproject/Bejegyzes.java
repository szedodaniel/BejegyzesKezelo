
package bejegyzesproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;

public class Bejegyzes implements Comparable{
    
    private String szerzo;
    private String tartalom;
    private int likeok;
    private Date letrejott;
    private Date szerkesztve;
    private List<Bejegyzes> bejegyzesek = new ArrayList<>();;
 


    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = new Date();
        this.szerkesztve = new Date();
        
        
    }
    public Bejegyzes(String fajlNev){
       
        try {
            Scanner sc = new Scanner(new File(fajlNev));
            
            while (sc.hasNextLine()){
                String sor = sc.nextLine();
                String[] adatok = sor.split(";");
                this.bejegyzesek.add(new Bejegyzes(adatok[0],adatok[1]));
            }
            
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Hiba: " + ex);
        }
        
       
    }
    public Bejegyzes(){
        
    }
    
    
    public String legnepszerubbBejegyzes(){
        int max = 0;
        int ind = 0;
        String s = "";
        for (int i = 0; i < this.bejegyzesek.size(); i++) {
            if(this.bejegyzesek.get(i).getLikeok() > max){
                max = this.bejegyzesek.get(i).getLikeok();
                ind = i;
            }
            
        }
        s+= this.bejegyzesek.get(ind).toString()+" "+this.bejegyzesek.get(ind).getLikeok();
        
        return s;
    }
    public boolean tobbMintXLikeosE(int szam){
        boolean van = false;
        
        for (int i = 0; i < this.bejegyzesek.size(); i++) {
            if(this.bejegyzesek.get(i).getLikeok() > szam){
                van = true;
            }
        }
        return van;
    }
    
    public int kisebbMintXMegszamol(int szam){
       
        int db = 0;
        for (int i = 0; i < this.bejegyzesek.size(); i++) {
            if(this.bejegyzesek.get(i).getLikeok() < szam){
                db++;
            }
        }
        
        return db;
    }

    public List<Bejegyzes> getBejegyzesek() {
        return bejegyzesek;
    }
    
    public void randomLike(){
        Random rnd = new Random();
        int n = this.bejegyzesek.size()*20;
        while(n != 0)
        {
            int randomSzam = rnd.nextInt(20)+1;
            Bejegyzes randomBejegyzes = this.bejegyzesek.get(rnd.nextInt(this.bejegyzesek.size()));
            //System.out.println(randomBejegyzes);
            if(randomSzam %2 == 0){
                randomBejegyzes.like();
                n--;
            }
            
        }
        
       
        
    }
    public void hozzaAd(Bejegyzes b){
        this.bejegyzesek.add(b);
    }
    
   
   
    
    public void osszkiir(){
        for (int i = 0; i < this.bejegyzesek.size(); i++) {
            System.out.println(this.bejegyzesek.get(i));
        }
        
        
    }
    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.setSzerkesztve(new Date());
        
    }

    public void setBejegyzesek(List<Bejegyzes> bejegyzesek) {
        this.bejegyzesek = bejegyzesek;
    }
    

    public void setSzerkesztve(Date szerkesztve) {
        this.szerkesztve = szerkesztve;
    }

    public void setLikeok(int likeok) {
        this.likeok = likeok;
    }
    
    

    public int getLikeok() {
        return likeok;
    }

    public Date getLetrejott() {
        return letrejott;
    }

    public Date getSzerkesztve() {
        return szerkesztve;
    }
    
    public void like(){
        this.likeok++;
    }
     public void rendezes(){
         Collections.sort(this.bejegyzesek);
    }
     
     public void fajlIras(String fajlNev){
         try{
             FileWriter fw = new FileWriter(fajlNev);
             PrintWriter pw = new PrintWriter(fw);
             
             for (int i = 0; i < this.bejegyzesek.size(); i++) {
                 pw.println(this.bejegyzesek.get(i).toString());
             }
             
             pw.close();
             fw.close();
             
         }catch(Exception e){
             System.out.println("Hiba: "+e);
         }
     }
    

    @Override
    public String toString() {
        return String.format("\n%s\t%s\nLike:%d-Szerkeztve:%s",this.szerzo,this.tartalom,this.likeok,this.letrejott);
    }

    @Override
    public int compareTo(Object t) {
       int compare=((Bejegyzes)t).getLikeok();
       return compare-this.getLikeok();
    }
    
    
}
