package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
public class Classes extends AScreens {
  private ViewMain vm;
  private JPanel classPanel;
  private boolean ood;
  private boolean db;
  private boolean algo;
  private boolean discrete;
  private boolean fundies1;
  private boolean fundies2;
  private boolean hci;
  private boolean lac;

  private void initPage() {
    Font f = new Font("TimesRoman", Font.BOLD, 40);

    this.setLayout(new BorderLayout());
    this.setPreferredSize(new Dimension(800, 800));

    JPanel header = this.gridLayPanel(800, 675);
    header.setBackground(Color.WHITE);

    GridBagConstraints c1 = new GridBagConstraints();
    c1.fill = GridBagConstraints.HORIZONTAL;
    Icon logo = new ImageIcon(Schedule.class.getResource("logo.jpg"));
    JLabel logoLabel = new JLabel();
    logoLabel.setIcon(logo);
    setConstraints(c1, 0, 0 ,new Insets(0, 0,0,175));
    header.add(logoLabel, c1);

    Icon profile = new ImageIcon(Schedule.class.getResource("student.png"));
    JButton profileButton = new JButton();
    profileButton.setIcon(profile);
    profileButton.setOpaque(false);
    profileButton.setContentAreaFilled(false);
    profileButton.setBorder(null);
    profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    setConstraints(c1, 2, 0 ,new Insets(0, 100,0,0));
    profileButton.addActionListener(e -> {
      this.vm.showScreen("profile", "classes");
    });
    header.add(profileButton, c1);

    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());
    content.setBackground(Color.WHITE);

    JPanel titlePanel = new JPanel();
    titlePanel.setBackground(Color.WHITE);
    titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
    JButton back = new JButton("Log Out");
    titlePanel.add(back);
    back.setFont(new Font("TimesRoman", Font.PLAIN, 16));
    back.setForeground(Color.RED.darker());

    back.setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 35));
    back.setPreferredSize(new Dimension(150, 20));
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.addActionListener(e -> {
      this.vm.showScreen("login", "classes");
    });
    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    back.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        back.setForeground(Color.darkGray);
      }
      @Override
      public void mouseExited(MouseEvent e) {
        back.setForeground(Color.RED.darker());
      }
    });

    JLabel title = new JLabel("               CLASSES");
    titlePanel.add(title);
    title.setFont(f);
    content.add(titlePanel, BorderLayout.PAGE_START);

    this.classPanel = new JPanel();
    classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.PAGE_AXIS));
    this.addClasses();

    JScrollPane classScroll = new JScrollPane(classPanel);
    JScrollBar scroll = new JScrollBar();
    scroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    classScroll.setVerticalScrollBar(scroll);

    content.add(classScroll, BorderLayout.CENTER);

    this.add(header, BorderLayout.PAGE_START);
    this.add(content, BorderLayout.CENTER);
  }

  public Classes(ViewMain vm) {
    super(vm);
    this.vm = vm;
    this.ood = false;
    this.db = false;
    this.algo = false;
    this.discrete = false;
    this.initPage();
  }


  ImageIcon makeIcon(boolean added) {
    if (added) {
      return new ImageIcon(Classes.class.getResource("arrow.png"));
    } else {
      return new ImageIcon(Classes.class.getResource("plus.png"));
    }
  }

  void addClasses() {
    String[] className = {"Object Oriented Design", "Discrete Structures", "Database Design",
            "Algorithms and Data", "Fundamentals of Computer Science I",
            "Fundamentals of Computer Science II", "Human Computer Interaction",
            "Logic and Computation"};
    boolean[] classBools = {this.ood, this.discrete, this.db, this.algo, this.fundies1,
            this.fundies2, this.hci, this.lac};

    for (int ii = 0; ii < 8; ii++) {
      boolean b = classBools[ii];
      String name = className[ii];
      JPanel butPan = new JPanel();
      butPan.setLayout(new BorderLayout());
      butPan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      JButton classButt = classButton(name);
      classButt.setHorizontalAlignment(SwingConstants.LEFT);
      JButton addButt = addButton(b);
      butPan.add(addButt, BorderLayout.LINE_START);
      butPan.add(classButt, BorderLayout.CENTER);
      butPan.setPreferredSize(new Dimension(150, 20));

      classButt.addActionListener(e -> {
        boolean bool;
        if (name.equals(className[0])) {
          bool = this.ood;
        } else if (name.equals(className[1])) {
          bool = this.discrete;
        } else if (name.equals(className[2])) {
          bool = this.db;
        }  else if (name.equals(className[3])) {
          bool = this.algo;
        }  else if (name.equals(className[4])) {
          bool = this.fundies1;
        } else if (name.equals(className[5])) {
          bool = this.fundies2;
        } else if (name.equals(className[6])){
          bool = this.hci;
        } else {
          bool = this.lac;
        }

        if (bool) {
          vm.showScreen("schedule", name);
        }
      });

      addButt.addActionListener(e -> {
        boolean bool;
        if (name.equals(className[0])) {
          bool = this.ood;
        } else if (name.equals(className[1])) {
          bool = this.discrete;
        } else if (name.equals(className[2])) {
          bool = this.db;
        }  else if (name.equals(className[3])) {
          bool = this.algo;
        }  else if (name.equals(className[4])) {
          bool = this.fundies1;
        } else if (name.equals(className[5])) {
          bool = this.fundies2;
        } else if (name.equals(className[6])){
          bool = this.hci;
        } else {
          bool = this.lac;
        }

        if (bool) {
          addButt.setIcon(makeIcon(false));
          butPan.revalidate();
          this.repaint();
        } else {
          addButt.setIcon(makeIcon(true));
          butPan.revalidate();
          this.repaint();
        }

        if (name.equals(className[0])) {
          this.ood = !this.ood;
        } else if (name.equals(className[1])) {
          this.discrete = !this.discrete;
        } else if (name.equals(className[2])) {
          this.db = !this.db;
        }  else if (name.equals(className[3])) {
          this.algo = !this.algo;
        }  else if (name.equals(className[4])) {
          this.fundies1 = !this.fundies1;
        } else if (name.equals(className[5])) {
          this.fundies2 = !this.fundies2;
        } else if (name.equals(className[6])){
          this.hci = !this.hci;
        } else {
          this.lac = !this.lac;
        }

      });
      classPanel.add(butPan);
    }
  }

  JButton classButton(String className) {
    JButton classButt = new JButton("  " + className);
    classButt.setFont(new Font("TimesRoman", Font.PLAIN, 30));
    classButt.setOpaque(false);
    classButt.setContentAreaFilled(false);
    classButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    return classButt;
  }

  JButton addButton(boolean added) {
    JButton addButt = new JButton(makeIcon(added));
    addButt.setOpaque(false);
    addButt.setContentAreaFilled(false);
    addButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    return addButt;
  }

}
