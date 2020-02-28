package Views;

import java.awt.*;

import javax.swing.*;

public class ViewMain extends JFrame {
  private final CardLayout cardLayout = new CardLayout();
  private final JPanel mainPanel = new JPanel();
  public final String LOGIN = "login";
  public final String SCHEDULE = "schedule";

  public ViewMain() {
    this.setTitle("Khoury Kalendar");
    this.setMinimumSize(new Dimension(800, 800));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(350, 0);

    mainPanel.setPreferredSize(new Dimension(800,800));
    mainPanel.setLayout(cardLayout);

    JPanel schedule = new Schedule(this);
    JPanel login = new Login(this);

    mainPanel.add(SCHEDULE, schedule);
    mainPanel.add(LOGIN, login);
    showScreen(LOGIN);
    setLayout(new BorderLayout());
    add(mainPanel,BorderLayout.CENTER);
    pack();
    setVisible(true);

  }
  public void showScreen(String str) {
    this.cardLayout.show(mainPanel, str);
    this.setTitle(str);
  }
}
