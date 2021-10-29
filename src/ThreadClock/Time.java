
package ThreadClock;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author DELL
 */
public class Time extends Thread{
    private JLabel lblTime;
    
    
    public Time(JLabel lblTime) {
        this.lblTime = lblTime;
    }

    public Time() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void run(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh: mm: ss aa");
        while(true){
            Date now = new Date();
            String st = sdf.format(now);
            lblTime.setText(st);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
