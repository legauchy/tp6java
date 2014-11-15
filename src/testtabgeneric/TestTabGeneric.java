/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtabgeneric;

/**
 *
 * @author goum
 */
public class TestTabGeneric {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("### Tableau Generique de Couple ###");
        TabGeneric<Couple> tabGen = new TabGeneric<Couple>();
        tabGen.add(new Couple(10, -5));
        tabGen.add(new Couple(-4, 2));
        tabGen.add(new Couple(0, 7));
        tabGen.add(new Couple(8, -1));
        tabGen.add(new Couple(-4, -1));
        tabGen.add(new Couple(-4, 3));
        tabGen.add(new Couple(-4, 8));
        
        tabGen.heapsort();
        System.out.println(tabGen);
        
        System.out.println("\n### Tableau Generique de CoupleGeneric où a est un entier et b un double ###");
        TabGeneric<CoupleGeneric<Integer, Double>> tabGen2 = new TabGeneric<CoupleGeneric<Integer, Double>>();
        tabGen2.add(new CoupleGeneric<Integer,Double>(10, -6.0));
        tabGen2.add(new CoupleGeneric<Integer,Double>(4, -8.0));
        tabGen2.add(new CoupleGeneric<Integer,Double>(-2, -5.0));
        tabGen2.add(new CoupleGeneric<Integer,Double>(4, 1.2));
        
        tabGen2.heapsort();
        System.out.println(tabGen2);
        
        
        System.out.println("\n### Tableau Generique de triplet d'entier ###");
        TabGeneric<CoupleGeneric<Integer, CoupleGeneric<Integer, Integer>>> tabGen3 = new TabGeneric<CoupleGeneric<Integer, CoupleGeneric<Integer, Integer>>>();
        tabGen3.add(new CoupleGeneric<Integer,CoupleGeneric<Integer, Integer>>(10,
                                                        new CoupleGeneric<Integer, Integer>(10, 5)));
        
        tabGen3.add(new CoupleGeneric<Integer,CoupleGeneric<Integer, Integer>>(10,
                                                        new CoupleGeneric<Integer, Integer>(4, 9)));
        
        tabGen3.add(new CoupleGeneric<Integer,CoupleGeneric<Integer, Integer>>(-7, 
                                                        new CoupleGeneric<Integer, Integer>(1, 0)));
        
        tabGen3.add(new CoupleGeneric<Integer,CoupleGeneric<Integer, Integer>>(34, 
                                                        new CoupleGeneric<Integer, Integer>(-7, -1)));
        
        tabGen3.heapsort();
        System.out.println(tabGen3);
    }
    
}
