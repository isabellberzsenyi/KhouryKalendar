package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class Profile extends JPanel {
  private ViewMain vm;

  private void initPage(ViewMain vm) {
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
    setConstraints(c1, 0, 0, new Insets(0, 0, 0, 100));
    header.add(logoLabel, c1);

    Icon profile = new ImageIcon(Schedule.class.getResource("profile.png"));
    JButton profileButton = new JButton();
    profileButton.setIcon(profile);
    profileButton.setOpaque(false);
    profileButton.setContentAreaFilled(false);
    profileButton.setBorder(null);
    profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    setConstraints(c1, 5, 0, new Insets(0, 250, 0, 100));
    profileButton.addActionListener(e -> {
      this.vm.showScreen("profile");
    });
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
      this.vm.showScreen("classes");
    });
    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    JLabel title = new JLabel("               Profile");
    titlePanel.add(title);
    title.setFont(f);
    content.add(titlePanel, BorderLayout.PAGE_START);

    JScrollBar scroll = new JScrollBar();
    scroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    this.add(header, BorderLayout.PAGE_START);
    this.add(content, BorderLayout.CENTER);
  }

  public Profile(ViewMain vm) {
    this.initPage(vm);
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
  

}