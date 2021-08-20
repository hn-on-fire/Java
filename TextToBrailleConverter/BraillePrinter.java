/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brailleprinter;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.util.ArrayList;

/**
 *
 * @author Harsh
 */
public class BraillePrinter {

    VoiceManager vm;
    Voice v;

    public static void main(String[] args) {
        AccessFile af = new AccessFile();

        String hn = "";
        hn = af.getLine();
       // System.out.println(hn);
        ArrayList<Object> help = BrailleCellSequence.getBrailleCellSequence(hn);
        System.out.println(help.get(1));
        af.read();
    }

}
