package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class Classes extends JPanel {
  ViewMain vm;
  private JPanel classPanel;
  private boolean ood;
  private boolean db;
  private boolean algo;
  private boolean discrete;
  private JButton oodButton;
  private JButton dbButton;
  private JButton algoButton;
  private JButton discreteButton;

  private void initPage() {

  }

  private Classes(Classes copy) {
    this.ood = copy.ood;
    this.db = copy.db;
    this.algo = copy.algo;
    this.discrete = copy.discrete;
  }

  public Classes(ViewMain vm) {

    this.ood = false;
    this.db = false;
    this.algo = false;
    this.discrete = false;

    this.vm = vm;
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
    setConstraints(c1, 0, 0, new Insets(0, 0, 0, 175));
    header.add(logoLabel, c1);

    Icon profile = new ImageIcon(Schedule.class.getResource("logo.jpg"));
    JButton profileButton = new JButton();
    profileButton.setIcon(profile);
    profileButton.setOpaque(false);
    profileButton.setContentAreaFilled(false);
    profileButton.setBorder(null);
    profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    setConstraints(c1, 2, 0, new Insets(0, 100, 0, 0));
    header.add(profileButton, c1);

    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());
    content.setBackground(Color.WHITE);

    JPanel titlePanel = new JPanel();
    titlePanel.setBackground(Color.WHITE);
    titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
    JButton back = new JButton("Back");
    titlePanel.add(back);
    back.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    back.setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 35));
    back.setPreferredSize(new Dimension(150, 20));
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.addActionListener(e -> {
      this.vm.showScreen("login");
    });
    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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

  JPanel gridLayPanel(int x, int y) {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setMaximumSize(new Dimension(x, y));
    panel.setBackground(Color.WHITE);
    return panel;
  }

  void setConstraints(GridBagConstraints constraint, int x, int y, Insets insets) {
    constraint.gridx = x;
    constraint.gridy = y;
    if (insets != null) {
      constraint.insets = insets;
    }
  }

  ImageIcon makeIcon(boolean added) {
    if (added) {
      return new ImageIcon(Classes.class.getResource("arrow.png"));
    } else {
      return new ImageIcon(Classes.class.getResource("plus.png"));
    }
  }

  void addClasses() {
    oodButton = new JButton("  Object-Oriented Design", makeIcon(ood));
    discreteButton = new JButton("  Discrete Structures",makeIcon(discrete));
    dbButton = new JButton("  Database Design", makeIcon(db));
    algoButton = new JButton("  Algorithms and Data", makeIcon(algo));

    oodButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    oodButton.setBorder(BorderFactory.createEmptyBorder(0,35,0,35));
    oodButton.setPreferredSize(new Dimension(150, 20));
    oodButton.setOpaque(false);
    oodButton.setContentAreaFilled(false);

    discreteButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    discreteButton.setBorder(BorderFactory.createEmptyBorder(0,35,0,35));
    discreteButton.setPreferredSize(new Dimension(150, 20));
    discreteButton.setOpaque(false);
    discreteButton.setContentAreaFilled(false);

    dbButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    dbButton.setBorder(BorderFactory.createEmptyBorder(0,35,0,35));
    dbButton.setPreferredSize(new Dimension(150, 20));
    dbButton.setOpaque(false);
    dbButton.setContentAreaFilled(false);

    algoButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    algoButton.setBorder(BorderFactory.createEmptyBorder(0,35,0,35));
    algoButton.setPreferredSize(new Dimension(150, 20));
    algoButton.setOpaque(false);
    algoButton.setContentAreaFilled(false);

    classPanel.add(oodButton);
    classPanel.add(discreteButton);
    classPanel.add(dbButton);
    classPanel.add(algoButton);
  }
}
