import javax.swing.*;
import java.awt.*;

public class GUIChronometer extends JFrame{

    private int ms ,ss ,mm , hh;
    private  boolean countClick;
    private Time timeOBJ;
    private Thread chronometer;
    private JFrame frame;
    private JLabel lblChronometer;
    private JButton btnPlay, btnStop, btnReset;
    private JPanel pnlPlayStopReset;

    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public Time getTimeOBJ() {
        return timeOBJ;
    }

    public void setTimeOBJ(Time timeOBJ) {
        this.timeOBJ = timeOBJ;
    }

    public void setChronometer(Thread chronometer) {
        this.chronometer = chronometer;
    }

    public Thread getChronometer() {
        return chronometer;
    }

    public boolean getCountClick() {
        return countClick;
    }

    public void setCountClick(boolean countClick) {
        this.countClick = countClick;
    }


    public JLabel getLblChronometer() {
        return lblChronometer;
    }

    public void setLblChronometer(String time) {
        lblChronometer.setText(time);
    }

    public JButton getBtnPlay() {
        return btnPlay;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    private void createInterface(){
        pnlPlayStopReset = new JPanel();
        pnlPlayStopReset.setLayout(new GridLayout(1,3));

        lblChronometer = new JLabel("00:00:00", SwingConstants.CENTER);

        btnPlay = new JButton("Play");
        btnStop = new JButton("Stop");
        btnReset = new JButton("Reset");

        btnPlay.addActionListener(new ActionBtn(this));
        btnStop.addActionListener(new ActionBtn(this));
        btnReset.addActionListener(new ActionBtn(this));

        pnlPlayStopReset.add(btnPlay);
        pnlPlayStopReset.add(btnStop);
        pnlPlayStopReset.add(btnReset);

        frame.add(lblChronometer);
        frame.add(pnlPlayStopReset);

    }

    GUIChronometer(){
        frame = new JFrame("Chronometer");
        frame.setLayout(new GridLayout(2,1));

        countClick = false;

        timeOBJ = new Time(this);
        timeOBJ.setTime(0);

        chronometer = new Thread(timeOBJ);

        createInterface();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setVisible(true);
    }
}
