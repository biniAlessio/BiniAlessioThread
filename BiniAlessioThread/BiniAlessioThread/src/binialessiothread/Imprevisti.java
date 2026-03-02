/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binialessiothread;
/**
 *
 * @author bini.alessio
 */
public class Imprevisti {
    
    public int calcolaEvento() {
        double r = Math.random();
        if (r < 0.15) return 2;
        if (r > 0.85) return 1;
        return 0;
    }
}