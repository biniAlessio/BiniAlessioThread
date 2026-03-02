/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binialessiothread;

/**
 *
 * @author bini.alessio
 */
public class Atleta {

    private String nome;
    private String cognome;

    public Atleta(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    public void corsa(javax.swing.JProgressBar barra, javax.swing.JTextArea areaImprevisti, GraficaCorsa frame) {
    new Thread(() -> {
        double progresso = 0; 
        Imprevisti imp = new Imprevisti();

        while (progresso < 100) {
            
            double incremento = 0.3 + (Math.random() * 0.4); 
            
            
            if ((int) (Math.random() * 100) < 5) { 
                int evento = imp.calcolaEvento();
                if (evento == 2) {
                    incremento *= 3; 
                    javax.swing.SwingUtilities.invokeLater(() -> areaImprevisti.append(this.nome + ": boost\n"));
                } else if (evento == 1) {
                    incremento /= 2; 
                    javax.swing.SwingUtilities.invokeLater(() -> areaImprevisti.append(this.nome + ": inciampato\n"));
                }
            }

            progresso += incremento;
            if (progresso > 100) progresso = 100;

            
            final int p = (int) progresso;
            javax.swing.SwingUtilities.invokeLater(() -> barra.setValue(p));

            try { 
                
                Thread.sleep(40); 
            } catch (Exception e) { break; }
        }

        frame.atletaArrivato(this.nome + " " + this.cognome);
    }).start();
    }
}