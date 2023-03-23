import java.util.Date;

public class Time implements Runnable{
    private int ms ,ss, mm, hh;
    GUIChronometer gui ;

    Time(GUIChronometer gui){
        this.gui = gui;
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

    public void increment(){
        ms = gui.getMs();
        ss = gui.getSs();
        mm = gui.getMm();
        hh = gui.getHh();

        ms += 1;
        gui.setMs(ms);
    }

    public int getTime() {
        return ms;
    }

    public void setTime(int ms) {
        this.ms = ms;
    }

    @Override
    public void run(){
        while (true){
            Delay.delay(5);

            increment();//increment milliseconds

            if (gui.getHh() != 24) { //it doesn't go beyond 24h
                if (gui.getMs() == 60) {
                    ms = 0;
                    gui.setMs(ms);
                    ss += 1;
                    gui.setSs(ss);

                } else if (gui.getSs() == 60) {

                    ss = 0;
                    gui.setSs(ss);
                    mm += 1;
                    gui.setMm(mm);

                } else if (gui.getMm() == 60) {
                    mm = 0;
                    gui.setMm(mm);

                    hh += 1;
                    gui.setHh(hh);
                }
            } else if (gui.getHh() == 24 && gui.getMm() != 59) {//it doesn't go beyond 24h 59mm
                if (gui.getMs() == 60) {
                    ms = 0;
                    gui.setMs(ms);
                    ss += 1;
                    gui.setSs(ss);
                } else if (gui.getSs() == 60) {
                    ss = 0;
                    gui.setSs(ss);
                    mm += 1;
                    gui.setMm(mm);
                }
            } else if (gui.getHh() == 24 && gui.getMm() == 59 && gui.getSs() != 59) { //it doesn't go beyond 24h 59mm 59ss
                if (gui.getMs() == 60) {
                    ms = 0;
                    gui.setMs(ms);
                    ss += 1;
                    gui.setSs(ss);
                }
            } else if(gui.getHh() == 24 && gui.getMm() == 59 && gui.getSs() == 59){//auto-kill
                gui.getChronometer().stop();
            }

            gui.setLblChronometer(gui.getHh() + ":" + gui.getMm() + ":" + gui.getSs());
        }
    }

}
