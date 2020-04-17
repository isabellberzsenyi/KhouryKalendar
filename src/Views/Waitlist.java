package Views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class Waitlist extends AScreens {
  private ViewMain vm;
  private boolean checkedIn = false;
  private JLabel titleLabel;
  public Waitlist(ViewMain vm) {
    super(vm);
    this.vm = vm;
    Font f = new Font("TimesRoman", Font.BOLD, 40);

    this.setLayout(new BorderLayout());
    this.setPreferredSize(new Dimension(800,800));
    this.setBackground(Color.WHITE);

    JPanel header = this.gridLayPanel(800, 675);
    header.setBackground(Color.WHITE);

    GridBagConstraints c1 = new GridBagConstraints();
    c1.fill = GridBagConstraints.HORIZONTAL;
    Icon logo = new ImageIcon(Schedule.class.getResource("logo.jpg"));
    JLabel logoLabel = new JLabel();
    logoLabel.setIcon(logo);
    setConstraints(c1, 0, 0 ,new Insets(0, 0,0,175));
    header.add(logoLabel, c1);
    Icon profile = new ImageIcon(Waitlist.class.getResource("student.png"));

    JButton profileButton = new JButton();
    profileButton.setIcon(profile);
    profileButton.setOpaque(false);
    profileButton.setContentAreaFilled(false);
    profileButton.setBorder(null);
    profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    profileButton.addActionListener(e -> {
      this.vm.showScreen("profile", "waitlist");
    });
    setConstraints(c1, 2, 0 ,new Insets(0, 100,0,0));
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

    back.setBorder(BorderFactory.createEmptyBorder(0,35,0,35));
    back.setPreferredSize(new Dimension(150, 20));
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.setForeground(Color.RED.darker());
    back.addActionListener(e -> {
      this.vm.showScreen("schedule", this.titleLabel.getText());
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

    this.titleLabel = new JLabel("OBJECT-ORIENTED DESIGN");
    titlePanel.add(titleLabel);
    titleLabel.setFont(f);
    content.add(titlePanel, BorderLayout.PAGE_START);

    JPanel contentSub = new JPanel();
    contentSub.setLayout(new BorderLayout());
    contentSub.setBackground(Color.WHITE);
    //info subheader under title
    JPanel subheader = this.gridLayPanel(800, 675);

    c1.fill = GridBagConstraints.HORIZONTAL;

    // office hour info box
    Font f2 = new Font("TimesRoman", Font.BOLD, 20);
    JButton info = new JButton();
    info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
    info.setBackground(Color.WHITE);
    info.setEnabled(false);
    info.setPreferredSize(new Dimension(200,100));
    info.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    JLabel date = new JLabel("Mon Jan 6");
    date.setFont(f2);
    date.setAlignmentX(Component.CENTER_ALIGNMENT);
    info.add(date);

    JLabel time = new JLabel("1pm - 3pm");
    time.setFont(f2);
    time.setAlignmentX(Component.CENTER_ALIGNMENT);
    info.add(time);

    JLabel room = new JLabel("Kariotis 011");
    room.setFont(f2);
    room.setAlignmentX(Component.CENTER_ALIGNMENT);
    info.add(room);
    setConstraints(c1, 0, 0, new Insets(25, 5, 0, 150));
    subheader.add(info, c1);

    //   ta tutor info
    JButton ta = new JButton();
    ta.setLayout(new BoxLayout(ta, BoxLayout.PAGE_AXIS));
    ta.setBackground(Color.WHITE);
    ta.setEnabled(false);
    ta.setMinimumSize(new Dimension(400,100));
    ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    JLabel taTitle = new JLabel("TAs and Tutors");
    taTitle.setFont(f2);
    taTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
    ta.add(taTitle);

    JLabel blank1 = new JLabel(" ");
    blank1.setFont(new Font("TimesRoman", Font.PLAIN, 10));
    ta.add(blank1);

    JLabel taNames = new JLabel("  John Smith, Julia Tan, Steve Joe  ");
    taNames.setFont(new Font("TimesRoman", Font.PLAIN, 16));
    taNames.setAlignmentX(Component.CENTER_ALIGNMENT);
    ta.add(taNames);

    JLabel blank2 = new JLabel(" ");
    blank2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
    ta.add(blank2);

    setConstraints(c1, 1, 0, new Insets(25, 100, 0, 0));
    subheader.add(ta, c1);

    contentSub.add(subheader, BorderLayout.PAGE_START);

    JPanel waitlist = new JPanel();
    waitlist.setBorder(BorderFactory.createEmptyBorder(20, 100, 50, 100));
    waitlist.setLayout(new BorderLayout());
    waitlist.setBackground(Color.WHITE);

    JLabel waitlistTitle = new JLabel("Wait List");
    waitlistTitle.setFont(new Font("TimesRoman", Font.BOLD, 32));
    waitlist.add(waitlistTitle, BorderLayout.PAGE_START);

    DefaultListModel listModel = new DefaultListModel();
    JList studentList = new JList(listModel);
    studentList.setFont(new Font("TimeRoman", Font.PLAIN, 20));
    studentList.setEnabled(false);
    listModel.addElement("      Jane Doe");
    listModel.addElement("      Mary Ellen");
    listModel.addElement("      Kathy Green");
    listModel.addElement("      Raina Parekh");

    JScrollPane waitlistList = new JScrollPane(studentList);
    JButton addButton = new JButton("CHECK IN");
    addButton.setBackground(Color.RED.darker());
    addButton.setForeground(Color.WHITE);
    addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    addButton.addActionListener(e -> {
      if (checkedIn) {
        listModel.removeElement("      John Smith");
        addButton.setBackground(Color.RED.darker());
        addButton.setText("CHECK IN");
        checkedIn = false;
      } else {
        listModel.addElement("      John Smith");
        addButton.setBackground(Color.darkGray);
        addButton.setText("REMOVE FROM WAITLIST");
        checkedIn = true;
      }
    });

    waitlist.add(waitlistList, BorderLayout.CENTER);
    waitlist.add(addButton, BorderLayout.PAGE_END);
    contentSub.add(waitlist, BorderLayout.CENTER);

    content.add(contentSub, BorderLayout.CENTER);
    this.add(header, BorderLayout.PAGE_START);
    this.add(content, BorderLayout.CENTER);
  }
  public void setTitleName(String name) {
    if (name.equals("Fundamentals of Computer Science II") ||
            name.equals("Fundamentals of Computer Science I") ||
            name.equals("Human Computer Interaction")) {
      this.titleLabel.setText(name.toUpperCase());
    } else {
      this.titleLabel.setText(name.toUpperCase());
    }
    titleLabel.setFont(new Font("TimesRoman", Font.BOLD, 30));
    this.titleLabel.revalidate();
    this.titleLabel.repaint();
  }
}

