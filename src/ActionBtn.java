import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBtn implements ActionListener {
    GUIChronometer get;

    public ActionBtn(GUIChronometer get){
        this.get = get;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(get.getBtnPlay()) && !get.getCountClick()){

            get.setChronometer(new Thread(new Time(get)));
            get.getChronometer().start();

            get.setCountClick(true);

        } else if (source.equals(get.getBtnStop())) {

            get.getChronometer().stop();
            get.setCountClick(false);

        } else if (source.equals(get.getBtnReset())) {
            get.setMs(0);
            get.setSs(0);
            get.setMm(0);
            get.setHh(0);
            get.setLblChronometer("0:0:0");
        }
    }
}
