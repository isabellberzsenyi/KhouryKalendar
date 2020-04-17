package Views;

import java.awt.*;

import javax.swing.*;

public class ViewMain extends JFrame {
  private final CardLayout cardLayout = new CardLayout();
  private final JPanel mainPanel = new JPanel();
  public final String LOGIN = "login";
  public final String SCHEDULE = "schedule";
  public final String WAITLIST = "waitlist";
  public final String CLASSES = "classes";
  public final String PROFILE = "profile";
  JPanel login;
  Waitlist waitlist;
  Schedule schedule;
  JPanel classes;
  Profile profile;

  public ViewMain() {

    this.setTitle("Khoury Kalendar");
    this.setMinimumSize(new Dimension(800, 800));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(350, 0);

    mainPanel.setPreferredSize(new Dimension(800,800));
    mainPanel.setLayout(cardLayout);

    login = new Login(this);
    waitlist = new Waitlist(this);
    schedule = new Schedule(this);
    classes = new Classes(this);
    profile = new Profile(this);

//    showScreen(SCHEDULE, LOGIN);


    mainPanel.add(SCHEDULE, schedule);
    mainPanel.add(LOGIN, login);
    mainPanel.add(WAITLIST, waitlist);
    mainPanel.add(CLASSES, classes);
    mainPanel.add(PROFILE, profile);

    showScreen(LOGIN, LOGIN);
    setLayout(new BorderLayout());
    add(mainPanel,BorderLayout.CENTER);
    pack();
    setVisible(true);

  }
  public void showScreen(String str, String prev) {
    if (str.equals(PROFILE)) {
      this.profile.setPrev(prev);
    } else if (str.equals(SCHEDULE)) {
      this.schedule.setTitleName(prev);
    } else if (str.equals(WAITLIST)) {
      this.waitlist.setTitleName(prev);
    }
    this.cardLayout.show(mainPanel, str);
    this.setTitle(str);
  }
}
