package Views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

public class Login extends JPanel {
  JTextField username;
  JTextField password;
  ViewMain vm;

  public Login(ViewMain vm) {
//    super(vm);
    this.vm = vm;
    this.setMaximumSize(new Dimension(800, 800));
    this.setLayout(new GridBagLayout());
    this.setBackground(Color.WHITE);
    this.setBackground(Color.WHITE);
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.VERTICAL;

    //    Text Label
    JPanel textPanel = this.gridLayPanel(800, 200);
    GridBagConstraints c1 = new GridBagConstraints();
    c1.fill = GridBagConstraints.VERTICAL;

    //    username label
    JLabel usernameLabel = new JLabel("USERNAME:");
    usernameLabel.setFont(new Font("TimesRoman", Font.PLAIN, 25));
    setConstraints(c1, 0, 1, new Insets(10,6,10,10));
    textPanel.add(usernameLabel, c1);

    //    username text field
    username = new JTextField(30);
//    username.setToolTipText("ta or student");
    username.setToolTipText("student");
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
    password = new JPasswordField();
//    password.setToolTipText("ta = 54321 or student = 12345");
    password.setToolTipText("12345");
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
    textButton.addActionListener(e -> {
      if ((this.username.getText().equals("student") && this.password.getText().equals("12345"))) {
//              || (this.username.getText().equals("ta") && this.password.getText().equals("54321"))) {
//        this.vm.showScreen("schedule");
        this.vm.showScreen("classes");
//        try {
//          this.saveData();
//        } catch (IOException i) {
//          System.out.println("save");
//          i.printStackTrace();
//        }
//        this.vm.setUser(this.username.getText());
//        System.out.println(this.vm.getUser());
        this.password.setText("");
        this.username.setText("");
      } else {
    }
    });
    textButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,
                "Username or password is incorrect");
      }
    });
    textButton.addMouseListener(new MouseAdapter() {
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
    setConstraints(c2, 0, 1, null);
    buttonPanel.add(textButton, c2);


    setConstraints(c, 0, 2, new Insets(20, 0, 0, 0));
    this.add(textPanel,c);


    setConstraints(c, 0, 3, null);
    this.add(forgetLabel,c);

    setConstraints(c, 0, 4, null);
    this.add(buttonPanel,c);
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
