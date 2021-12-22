package beatbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Harsh
 */
public class BeatBox {

    private static JPanel mainPanel;
    private JList incomingList;
    private JTextField userMessage;
    private int nextNum;
    private static String USER_NAME;
    private static ArrayList<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private static JFrame theFrame;
    private static final String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-Mid Tom", "High Agogo", "Open Hi Conga"};
    private static final int instrumentKeys[] = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
    //test comment
    public static void main(String args[]) {
        new BeatBox().buildGui();
    }
/**
 * Method to build GUI
 */
    private void buildGui() {
        userName();
        theFrame = new JFrame("BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBackground(Color.decode("#730000"));
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        checkBoxList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        GridLayout buttonGrid = new GridLayout(4, 1);
        buttonGrid.setVgap(25);
        buttonGrid.setHgap(15);
        JPanel buttons = new JPanel(buttonGrid);
        buttons.setBackground(Color.decode("#730000"));
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 15, 10, 5));
        JButton start = new JButton("Start");
        customButton(start, "#A7E99C");
        start.addActionListener((ActionEvent a) -> {
            buildTrackAndStart();
        });
        buttons.add(start);
        JButton stop = new JButton("Stop");
        customButton(stop, "#E99B99A");
        stop.addActionListener((ActionEvent a) -> {
            sequencer.stop();
        });
        buttons.add(stop);
        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener((ActionEvent a) -> {
            sequencer.setTempoFactor((float) (sequencer.getTempoFactor() * 1.03));
        });
        buttons.add(upTempo);
        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener((ActionEvent a) -> {
            sequencer.setTempoFactor((float) (sequencer.getTempoFactor() * 0.97));
        });
        buttons.add(downTempo);
        buttonBox.add(buttons);
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String name : instrumentNames) {
            Label labelName = new Label(name);
            labelName.setBackground(Color.decode("#FED0BB"));
            labelName.setFocusable(false);
            nameBox.add(labelName);
        }
        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);
        theFrame.getContentPane().add(background);
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        mainPanel.setBackground(Color.decode("#730000"));
        background.add(BorderLayout.CENTER, mainPanel);
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setBackground(Color.decode("#730000"));
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }
        setUpMidi();
        theFrame.setResizable(false);
        theFrame.setVisible(true);
        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();

    }
    /**
     * Customize the design of the Button
     * @param button Button to be customized
     * @param color color of the button
     */
    private void customButton(JButton button, String color) {
        button.setBorderPainted(true);
        button.setBackground(Color.decode(color));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }
    /**
     * MIDI set up
     */
    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException | InvalidMidiDataException ex) {
            errorPopUp();
        }
    }
    /**
     * Building a Track and adding MIDI sequences to it
     */
    private void buildTrackAndStart() {
        int[] trackList;
        sequence.deleteTrack(track);
        track = sequence.createTrack();
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int instrumentKey = instrumentKeys[i];
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) checkBoxList.get(j + (16 * i));
                trackList[j] = (jc.isSelected()) ? instrumentKey : 0;
            }
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }
        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (InvalidMidiDataException ex) {
            errorPopUp();
        }
    }
/**
 * make MIDI Track
 * @param list list of selected checkBoxs' instrument keys
 */
    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }
/**
 * 
 * @param comd command 
 * @param chan channel
 * @param one data one
 * @param two data two
 * @param tick tick time before midi event is executed
 * @return MidiEvent for given input
 */
    private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException ex) {
            errorPopUp();
        }
        return event;
    }
    /**
     * Method for error screen
     */
    private static void errorPopUp() {
        JFrame errorFrame = new JFrame("Uh-Oh");
        JPanel errorPanel1 = new JPanel();
        errorPanel1.setLayout(new BoxLayout(errorPanel1, BoxLayout.Y_AXIS));
        JPanel errorPanel2 = new JPanel();
        errorPanel2.setLayout(new BoxLayout(errorPanel2, BoxLayout.X_AXIS));
        Label errorLine1 = new Label("Looks like you've run into an error.");
        Label errorLine2 = new Label("Please restart the app or contact the developer at:");
        Label errorLine3 = new Label("hn.on.fire@gmail.com");
        JButton close = new JButton("OK");
        close.setBounds(0, 0, 20, 15);
        errorPanel1.add(errorLine1);
        errorPanel1.add(errorLine2);
        errorPanel1.add(errorLine3);
        errorPanel2.add(close);
        errorPanel1.add(errorPanel2);
        errorFrame.add(errorPanel1);
        close.addActionListener((ActionEvent a) -> {
            System.exit(0);
        });
        errorFrame.setAlwaysOnTop(true);
        errorFrame.setVisible(true);
        errorFrame.setBounds(100, 100, 100, 130);
        errorFrame.setResizable(false);
        errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static void userName() {
        JFrame userNameFrame = new JFrame("Set User Name");
        JPanel userNamePanel = new JPanel();
        JPanel innerPanel1 = new JPanel();
        innerPanel1.setLayout(new BoxLayout(innerPanel1, BoxLayout.X_AXIS));
        JPanel innerPanel2 = new JPanel();
        innerPanel2.setLayout(new BoxLayout(innerPanel2, BoxLayout.X_AXIS));
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.Y_AXIS));
        Label line1 = new Label("Select your username:");
        Label line2 = new Label("");
        line2.setForeground(Color.red);
        JTextField  userName = new JTextField();
        JButton close = new JButton("OK");
        close.setBounds(0, 0, 20, 15);
        userName.setMaximumSize(new Dimension(100,15));
        userName.setBounds(0,0, 150, 15);
        userNamePanel.add(line1);
        innerPanel1.add(userName);
        userNamePanel.add(innerPanel1);
        userNamePanel.add(line2);
        innerPanel2.add(close);
        userNamePanel.add(innerPanel2);
        userNameFrame.add(userNamePanel);
        userName.grabFocus();
        close.addActionListener((ActionEvent a) -> {
            if(userName.getText().trim().equalsIgnoreCase("")){
                line2.setText("Username required");
                line2.setVisible(true);
                userName.grabFocus();
            }
            else if(userName.getText().contains(" ")){
                line2.setText("Username cannot contain spaces");
                line2.setVisible(true);
            }
            else{
                userNameFrame.dispose();
                USER_NAME = userName.getText();
            }
        });
        userNameFrame.setAlwaysOnTop(true);
        userNameFrame.setVisible(true);
        userNameFrame.setBounds(100, 100, 100, 130);
        userNameFrame.setResizable(false);
        userNameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
