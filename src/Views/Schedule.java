package Views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class Schedule extends JPanel {
  ViewMain vm;

  public Schedule(ViewMain vm) {
    this.vm = vm;
    Font f = new Font("TimesRoman", Font.BOLD, 40);

    this.setLayout(new BorderLayout());
    this.setPreferredSize(new Dimension(800,800));

    JPanel header = this.gridLayPanel(800, 675);
    header.setBackground(Color.WHITE);

    GridBagConstraints c1 = new GridBagConstraints();
    c1.fill = GridBagConstraints.HORIZONTAL;
    Icon logo = new ImageIcon(Schedule.class.getResource("logo.jpg"));
    JLabel logoLabel = new JLabel();
    logoLabel.setIcon(logo);
    setConstraints(c1, 0, 0 ,new Insets(0, 0,0,100));
    header.add(logoLabel, c1);

//    try {
//      this.renderData();
//      System.out.println(this.vm.getUser());
//    } catch (IOException i) {
//      System.out.println("render");
//      i.printStackTrace();
//    }

    Icon profile = new ImageIcon(Schedule.class.getResource("student.png"));

    JButton profileButton = new JButton();
    profileButton.setIcon(profile);
    profileButton.setOpaque(false);
    profileButton.setContentAreaFilled(false);
    profileButton.setBorder(null);
    profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    profileButton.addActionListener(e -> {
      this.vm.showScreen("profile");
    });
    setConstraints(c1, 5, 0 ,new Insets(0, 250,0,100));
    header.add(profileButton, c1);
    profileButton.addActionListener(e -> {
      this.vm.showScreen("profile");
    });

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
    back.addActionListener(e -> {
      this.vm.showScreen("classes");
            });
    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    JLabel title = new JLabel("OBJECT-ORIENTED DESIGN");
    titlePanel.add(title);
    title.setFont(f);
    content.add(titlePanel, BorderLayout.PAGE_START);

    JPanel schedule = new JPanel();
    schedule.setLayout(new BoxLayout(schedule, BoxLayout.PAGE_AXIS));

//    MONDAY
    JButton[] mondayButtons = {makeTimeButton("1pm - 3pm", "Kariotis 011", "QUEUE: 24", true, this.vm),
            makeTimeButton("4pm - 7pm", "Hastings 024", "", false, this.vm)};
    JPanel monday = makeTimePanel("Monday Jan 6", mondayButtons);
    schedule.add(monday);
//    TUESDAY
    JButton[] tuesButtons = {makeTimeButton("1pm - 3pm", "Kariotis 011", "", false, this.vm),
            makeTimeButton("4pm - 7pm", "Hastings 024", "", false, this.vm)};
    JPanel tuesday = makeTimePanel("Tuesday Jan 7", tuesButtons);
    schedule.add(tuesday);
//    WEDNESDAY
    JButton[] wedButtons = {makeTimeButton("1pm - 3pm", "Kariotis 011", "", false, this.vm),
            makeTimeButton("4pm - 7pm", "Hastings 024", "", false, this.vm)};
    JPanel wednesday = makeTimePanel("Wednesday Jan 8", wedButtons);
    schedule.add(wednesday);
//    THURSDAY
    JButton[] thursButtons = {makeTimeButton("1pm - 3pm", "Kariotis 011", "", false, this.vm),
            makeTimeButton("4pm - 7pm", "Hastings 024", "", false, this.vm)};
    JPanel thurs = makeTimePanel("Thursday Jan 9", thursButtons);
    schedule.add(thurs);
//    FRIDAY
    JButton[] friButtons = {makeTimeButton("1pm - 3pm", "Kariotis 011", "", false, this.vm),
            makeTimeButton("4pm - 7pm", "Hastings 024", "", false, this.vm)};
    JPanel fri = makeTimePanel("Friday Jan 10", friButtons);
    schedule.add(fri);

    JScrollPane scheduleScroll = new JScrollPane(schedule);
    JScrollBar scroll = new JScrollBar();
    scroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    scheduleScroll.setVerticalScrollBar(scroll);

    content.add(scheduleScroll, BorderLayout.CENTER);


    this.add(header, BorderLayout.PAGE_START);
    this.add(content, BorderLayout.CENTER);
  }

  JPanel makeTimePanel(String date, JButton[] buttonList) {
    Font f = new Font("TimesRoman", Font.BOLD, 24);
    JPanel panel = new JPanel();
    GridBagConstraints c = new GridBagConstraints();

    panel.setLayout(new BorderLayout());
    JLabel label = new JLabel(date);
    label.setFont(f);
    label.setBorder(BorderFactory.createLineBorder(Color.darkGray));
    panel.add(label, BorderLayout.PAGE_START);
    //    times
    JPanel timePanel = this.gridLayPanel(800, 200);
    for (int i = 0; i < buttonList.length; i++) {
      setConstraints(c, (2 * i), 0, new Insets(10, (25 * i), 10, 50));
      timePanel.add(buttonList[i], c);
    }

    panel.add(timePanel, BorderLayout.CENTER);
    return panel;

  }

  JButton makeTimeButton(String top, String middle, String  bottom, boolean active, ViewMain vm) {
    Font f = new Font("TimesRoman", Font.BOLD, 20);
    JButton button = new JButton();
    button.setBorder(BorderFactory.createEmptyBorder(10,0,5,0));
    button.setLayout(new BoxLayout(button, BoxLayout.PAGE_AXIS));
    JLabel time = new JLabel(top);
    time.setFont(f);
    time.setAlignmentX(Component.CENTER_ALIGNMENT);
    button.add(time);

    JLabel room = new JLabel(middle);
    room.setFont(f);
    room.setAlignmentX(Component.CENTER_ALIGNMENT);
    button.add(room);

    button.setPreferredSize(new Dimension(200,100));

    if (active) {
      JLabel queue = new JLabel(bottom);
      queue.setFont(new Font("TimesRoman", Font.PLAIN, 18));
      queue.setAlignmentX(Component.CENTER_ALIGNMENT);
      button.add(queue);
      button.setBackground(Color.RED.darker());
      time.setForeground(Color.WHITE);
      room.setForeground(Color.WHITE);
      queue.setForeground(Color.WHITE);

      button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            vm.showScreen("waitlist");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
          button.setBackground(Color.darkGray);
        }
        @Override
        public void mouseExited(MouseEvent e) {
          button.setBackground(Color.RED.darker());
        }
      });
    } else {
      button.setBackground(Color.lightGray);
      button.setEnabled(false);
    }
    return button;
  }

  public JPanel gridLayPanel(int x, int y) {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setMaximumSize(new Dimension(x, y));
    panel.setBackground(Color.WHITE);
    return panel;
  }

  public void setConstraints(GridBagConstraints constraint, int x, int y, Insets insets) {
    constraint.gridx = x;
    constraint.gridy = y;
    if (insets != null) {
      constraint.insets = insets;
    }
  }
}
