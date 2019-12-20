package br.ucsal.pratica.yllo;

import javax.sound.midi.*;
import javax.swing.*;
import java.io.File;

/*
 * Teste de midi kkk foi diverito testar este codigo nostalgia dos anos 90 aqui kkk 
 * Este código é quase em comparação com o código da pagina https://stackoverflow.com/tags/javasound/info
 * Eu apenas substitui a url quebrada por um arquivo midi que tinha por aqui 
 */

public class teste {
	    public static void main(String[] args) throws Exception {
	        File arquivo = new File("/home/ylloluis/Downloads/Curse of Monkey Island - Captain Rottingham.mid");

	        Sequence sequence = MidiSystem.getSequence(arquivo);
	        Sequencer sequencer = MidiSystem.getSequencer();

	        sequencer.open();
	        sequencer.setSequence(sequence);

	        sequencer.start();
	        SwingUtilities.invokeLater(() -> {
	            // A GUI element to prevent the Sequencer's daemon Thread
	            // from terminating at the end of the main()
	            JOptionPane.showMessageDialog(null, "Close to exit!");
	        });
	    }
}
