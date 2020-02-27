package Views;

import java.awt.*;

import javax.swing.*;
import Views.Login;

public class ViewMain {
  private JFrame frame;
  private JPanel main;
//  private JPanel loginPanel;

  public ViewMain() {
    frame = new JFrame("Khoury Kalendar");
    frame.setMinimumSize(new Dimension(800, 800));
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(0, 0);
//    main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
//    main.setMaximumSize(new Dimension(400, 800));
//    main.setBackground(Color.BLACK);


//    frame.setContentPane(new Login());

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);
    frame.pack();
    frame.setVisible(true);
  }

//  public void setPanel(JPanel panel) {
////    this.loginPanel = panel;
//    this.main.add(panel);
////    this.render();
//    frame.invalidate();
//    frame.validate();
//    frame.repaint();
////    SwingUtilities.updateComponentTreeUI(frame);
//  }
  public void render() {
    frame.setVisible(true);
  }
}
