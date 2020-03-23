package Views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

public class Profile extends JPanel {
  ViewMain vm;

  public Profile(ViewMain vm) {
    this.vm = vm;

    JPanel header = this.gridLayPanel(800, 675);
    header.setBackground(Color.WHITE);

    GridBagConstraints c1 = new GridBagConstraints();
    c1.fill = GridBagConstraints.HORIZONTAL;
    JButton back = new JButton("Back");
    back.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    back.setBorder(BorderFactory.createEmptyBorder(0,35,0,35));
    back.setPreferredSize(new Dimension(150, 20));
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.addActionListener(e -> {
      this.vm.showScreen("classes");
    });
    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    setConstraints(c1, 0, 0 ,new Insets(0, 0,0,50));
    header.add(back,c1);

    Icon logo = new ImageIcon(Profile.class.getResource("profile.png"));
    JLabel logoLabel = new JLabel();
    logoLabel.setIcon(logo);
    setConstraints(c1, 1, 0 ,new Insets(0, 0,0,10));
    header.add(logoLabel, c1);

    this.add(header, BorderLayout.PAGE_START);

    this.setMaximumSize(new Dimension(800, 800));
    this.setLayout(new GridBagLayout());
    this.setBackground(Color.WHITE);
    this.setBackground(Color.WHITE);

    //    Text Label
    JPanel textPanel = this.gridLayPanel(800, 200);
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.VERTICAL;

//    username label
    JLabel usernameLabel = new JLabel("USERNAME:");
    usernameLabel.setFont(new Font("TimesRoman", Font.PLAIN, 25));
    setConstraints(c1, 0, 1, new Insets(10,6,10,10));
    textPanel.add(usernameLabel, c1);

//    username text field
    JLabel username = new JLabel("smith.j");
    c1.weightx = 1;
    c1.fill = GridBagConstraints.HORIZONTAL;
    setConstraints(c1, 1, 1, new Insets(7,10,0,0));
    textPanel.add(username, c1);

//    password label
    JLabel passwordLabel = new JLabel("PASSWORD:");
    passwordLabel.setFont(new Font("TimesRoman", Font.PLAIN, 25));
    setConstraints(c1, 0, 2, new Insets(10,4,10,10));
    textPanel.add(passwordLabel, c1);

//    password text field
    JLabel password = new JLabel("*******");
    setConstraints(c1, 1, 2, new Insets(7,11,0,0));
    textPanel.add(password, c1);

    String change = "CHANGE PASSWORD";
    JLabel changeLabel = new JLabel(change);
    changeLabel.setForeground(Color.RED.darker());
    changeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    changeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          Desktop.getDesktop().browse(new URI("https://my.ccs.neu.edu/session/login"));
        } catch (IOException | URISyntaxException i) {
          i.printStackTrace();
        }
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        changeLabel.setForeground(Color.darkGray);
      }
      @Override
      public void mouseExited(MouseEvent e) {
        changeLabel.setForeground(Color.RED.darker());
      }
    });

    String home = "GO TO HOME SCREEN";
    JLabel homeLabel = new JLabel(home);
    homeLabel.setForeground(Color.RED.darker());
    homeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    homeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        vm.showScreen("classes");
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        homeLabel.setForeground(Color.darkGray);
      }
      @Override
      public void mouseExited(MouseEvent e) {
        homeLabel.setForeground(Color.RED.darker());
      }
    });

    GridBagConstraints c2 = new GridBagConstraints();
    c2.fill = GridBagConstraints.VERTICAL;

    setConstraints(c2, 0, 2, new Insets(20, 0, 0, 0));
    this.add(textPanel,c2);

    setConstraints(c2, 0, 3, null);
    this.add(changeLabel,c2);

    setConstraints(c2, 0, 5, null);
    this.add(homeLabel,c2);

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