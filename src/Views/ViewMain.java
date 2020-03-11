package Views;

import java.awt.*;

import javax.swing.*;

public class ViewMain extends JFrame {
  private final CardLayout cardLayout = new CardLayout();
  private final JPanel mainPanel = new JPanel();
  public final String LOGIN = "login";
  public final String SCHEDULE = "schedule";
  public final String WAITLIST = "waitlist";


  public ViewMain() {

    this.setTitle("Khoury Kalendar");
    this.setMinimumSize(new Dimension(800, 800));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(350, 0);

    mainPanel.setPreferredSize(new Dimension(800,800));
    mainPanel.setLayout(cardLayout);

    JPanel login = new Login(this);
    JPanel schedule = new Schedule(this);
    JPanel waitlist = new Waitlist(this);

    mainPanel.add(SCHEDULE, schedule);
    mainPanel.add(LOGIN, login);
    mainPanel.add(WAITLIST, waitlist);
    showScreen(SCHEDULE);
    setLayout(new BorderLayout());
    add(mainPanel,BorderLayout.CENTER);
    pack();
    setVisible(true);

  }
  public void showScreen(String str) {
    this.cardLayout.show(mainPanel, str);
    this.setTitle(str);
  }
//  public void setUser(String str) {
//    this.user = str;
//  }
//  public String getUser() {
//    return this.user;
//  }
//  public Icon setProfile() {
//    if (this.getUser().equals("student")) {
//      return new ImageIcon(Schedule.class.getResource("STUDENT.JPG"));
//    } else if (this.getUser().equals("ta")) {
//      return new ImageIcon(Schedule.class.getResource("TA.JPG"));
//    } else {
//      return new ImageIcon(Schedule.class.getResource("logo.jpg"));
//    }
//  }
}
