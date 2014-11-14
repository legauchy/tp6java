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
    }
    
}
