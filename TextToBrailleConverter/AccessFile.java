/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brailleprinter;

/**
 *
 * @author Harsh
 */
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccessFile {

    BufferedReader bw;
    String retty = "";

    public String getLine() {
        try {
            bw = new BufferedReader(new FileReader("/home/pi/Desktop/print.txt"));
            String temp;
            while ((temp = bw.readLine()) != null) {
                retty += temp;
            }
            bw.close();
            return retty;

        } catch (IOException ex) {
            //ex.printStackTrace();
            return "A System File was Deleted.Please Reinstall the Software.";
        }
    }

    void read() {
        new readFile().start();
    }

    private class readFile {

        void start() {
            System.setProperty("mbrola.base", "mbrola");
            VoiceManager vm = VoiceManager.getInstance();

            Voice v = vm.getVoice("mbrola_us2");

            v.allocate();

            try {
                v.speak(new BufferedInputStream(new FileInputStream("/home/pi/Desktop/print.txt")));
            } catch (FileNotFoundException ex) {
                v.speak("A System File was Deleted.Please Reinstall the Software.");
                System.err.println("A System File was Deleted.Please Reinstall the Software.");
            }
        }

    }
}
