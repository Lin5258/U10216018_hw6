

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallControl extends JApplet {
  private Ball ball = new Ball();
  private JButton jbtSuspend = new JButton("Suspend");
  private JButton jbtResume = new JButton("Resume");
  private JScrollBar jsbDelay = new JScrollBar();
	/** Create a frame and then add a applet to it.
	*/
   public static void main(String[] args) {
    BallControl applet = new BallControl();		//create a applet
    JFrame frame = new JFrame();				//create a frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("BallControl");
    frame.add(applet, BorderLayout.CENTER);
    frame.setSize(400, 320);
    frame.setVisible(true);
  }

  public BallControl() {
    // Group buttons in a panel
	
	
    JPanel panel = new JPanel();
    panel.add(jbtSuspend);
    panel.add(jbtResume);

    // Add ball and buttons to the panel
    ball.setBorder(new javax.swing.border.LineBorder(Color.red));
    jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
    ball.setDelay(jsbDelay.getMaximum());
    setLayout(new BorderLayout());
    add(jsbDelay, BorderLayout.NORTH);
    add(ball, BorderLayout.CENTER);
    add(panel, BorderLayout.SOUTH);

    // Register listeners
    jbtSuspend.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ball.suspend();
      }
    });
    jbtResume.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ball.resume();
      }
    });
    jsbDelay.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        ball.setDelay(jsbDelay.getMaximum() - e.getValue());
      }
    });
  }
}
