package Views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

public class Login {
  JFrame frame;
  JPanel mainPanel;
  JTextField username;
  JTextField password;

  public Login() {
    Font f = new Font("TimesRoman", Font.PLAIN, 25);


    frame = new JFrame("Login");
    frame.setMinimumSize(new Dimension(800, 800));
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(350, 0);

    mainPanel = this.gridLayPanel(800,800);
    mainPanel.setBackground(Color.WHITE);
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.VERTICAL;

    //    Text Label
    JPanel textPanel = this.gridLayPanel(800, 200);
    GridBagConstraints c1 = new GridBagConstraints();
    c1.fill = GridBagConstraints.VERTICAL;

//    username label
    JLabel usernameLabel = new JLabel("USERNAME:");
    usernameLabel.setFont(f);
//    c1.gridx = 0;
//    c1.gridy = 1;
//    c1.insets = new Insets(10,6,10,10);
    setConstraints(c1, 0, 1, new Insets(10,6,10,10));
    textPanel.add(usernameLabel, c1);

//    username text field
    username = new JTextField(30);
    c1.weightx = 1;
    c1.fill = GridBagConstraints.HORIZONTAL;
//    c1.gridx = 1;
//    c1.gridy = 1;
//    c1.insets = new Insets(7,10,0,0);
    setConstraints(c1, 1, 1, new Insets(7,10,0,0));
    textPanel.add(username, c1);

//    password label
    JLabel passwordLabel = new JLabel("PASSWORD:");
    passwordLabel.setFont(f);
//    c1.gridx = 0;
//    c1.gridy = 2;
//    c1.insets = new Insets(10,4,10,10);
    setConstraints(c1, 0, 2, new Insets(10,4,10,10));
    textPanel.add(passwordLabel, c1);

//    password text field
    password = new JPasswordField();
//    c1.gridx = 1;
//    c1.gridy = 2;
//    c1.insets = new Insets(7,11,0,0);
    setConstraints(c1, 1, 2, new Insets(7,11,0,0));
    textPanel.add(password, c1);

    String forget = "Forget password or username? Please make account here.";
    JLabel forgetLabel = new JLabel(forget);
    forgetLabel.setForeground(Color.RED.darker());
    forgetLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    forgetLabel.addMouseListener(new MouseAdapter() {
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
        forgetLabel.setForeground(Color.darkGray);
      }
      @Override
      public void mouseExited(MouseEvent e) {
        forgetLabel.setForeground(Color.RED.darker());
      }
    });

    JPanel buttonPanel = gridLayPanel(40,20);
    GridBagConstraints c2 = new GridBagConstraints();
    c2.fill = GridBagConstraints.HORIZONTAL;
    JButton textButton = new JButton("LOGIN");
    textButton.setFont(new Font("courrier new", Font.BOLD, 20));
    textButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,
                "You clicked the text button");
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        textButton.setBackground(Color.darkGray);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        textButton.setBackground(Color.RED.darker());

      }
    });
    textButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    textButton.setBackground(Color.RED.darker());
    textButton.setForeground(Color.WHITE);
//    c2.gridx = 0;
//    c2.gridy = 1;
    setConstraints(c2, 0, 1, null);
    buttonPanel.add(textButton, c2);

//    c.gridx = 0;
//    c.gridy = 2;
//    c.insets = new Insets(20, 0, 0, 0);
    setConstraints(c, 0, 2, new Insets(20, 0, 0, 0));
    mainPanel.add(textPanel,c);

//    c.gridy = 3;
    setConstraints(c, 0, 3, null);
    mainPanel.add(forgetLabel,c);
//    c.gridy = 4;
    setConstraints(c, 0, 4, null);
    mainPanel.add(buttonPanel,c);
    frame.add(mainPanel);
  }

  JPanel gridLayPanel(int x, int y) {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setMaximumSize(new Dimension(x, y));
    panel.setBackground(Color.WHITE);
    return panel;
  }
  public void render(){
    frame.setVisible(true);
  }
  void setConstraints(GridBagConstraints constraint, int x, int y, Insets insets) {
    constraint.gridx = x;
    constraint.gridy = y;
    if (insets != null) {
      constraint.insets = insets;
    }
  }
}
