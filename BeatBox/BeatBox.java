package beatbox;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;

/**
 *
 * @author Harsh
 */
public class BeatBox {

    private static JPanel mainPanel;
    private static ArrayList<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private static JFrame theFrame;
    private static final String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-Mid Tom", "High Agogo", "Open Hi Conga"};
    private static final int instrumentKeys[] = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String args[]) {
        new BeatBox().buildGui();
    }

    private void buildGui() {
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

    private void customButton(JButton button, String color) {
        button.setBorderPainted(true);
        button.setBackground(Color.decode(color));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException | InvalidMidiDataException ex) {
        }
    }

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
        }
    }

    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException ex) {
        }
        return event;
    }

}
