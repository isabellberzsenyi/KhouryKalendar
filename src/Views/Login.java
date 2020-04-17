package Views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

public class Login extends AScreens {
  JTextField username;
  JTextField password;
  ViewMain vm;

  public Login(ViewMain vm) {
    super(vm);
    this.vm = vm;
    this.setMaximumSize(new Dimension(800, 800));
    this.setLayout(new GridBagLayout());
    this.setBackground(Color.WHITE);
    this.setBackground(Color.WHITE);
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.VERTICAL;

    //    Text Label
    JPanel textPanel = this.gridLayPanel(800, 350);
    GridBagConstraints c1 = new GridBagConstraints();
    c1.fill = GridBagConstraints.VERTICAL;

    //    username label
    JLabel usernameLabel = new JLabel("USERNAME:");
    usernameLabel.setFont(new Font("TimesRoman", Font.PLAIN, 25));
    setConstraints(c1, 0, 1, new Insets(10,6,10,10));
    textPanel.add(usernameLabel, c1);

    //    username text field
    username = new JTextField(30);
    username.setToolTipText("student");
    c1.weightx = 1;
    c1.fill = GridBagConstraints.HORIZONTAL;
    setConstraints(c1, 1, 1, new Insets(7,10,0,0));
    textPanel.add(username, c1);

    // forgot user
    JButton forgotUser = new JButton("Forgot Username?");
    forgotUser.setBackground(Color.RED.darker());
    forgotUser.setForeground(Color.WHITE);
    forgotUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    setConstraints(c1, 2, 1, null);
    forgotUser.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          Desktop.getDesktop().browse(new URI("https://my.ccs.neu.edu/forgot/username")); // https://my.ccs.neu.edu/forgot/password
        } catch (IOException | URISyntaxException i) {
          i.printStackTrace();
        }
      }
      @Override
      public void mouseEntered(MouseEvent e) {

        forgotUser.setBackground(Color.darkGray);
      }
      @Override
      public void mouseExited(MouseEvent e) {
        forgotUser.setBackground(Color.RED.darker());
      }
    });
    textPanel.add(forgotUser, c1);


    //    password label
    JLabel passwordLabel = new JLabel("PASSWORD:");
    passwordLabel.setFont(new Font("TimesRoman", Font.PLAIN, 25));
    setConstraints(c1, 0, 2, new Insets(10,4,10,10));
    textPanel.add(passwordLabel, c1);

    //    password text field
    password = new JPasswordField();
    password.setToolTipText("12345");
    setConstraints(c1, 1, 2, new Insets(7,11,0,0));
    textPanel.add(password, c1);

    // forgot password
    JButton forgotPass = new JButton("Forgot Password?");
    forgotPass.setBackground(Color.RED.darker());
    forgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    forgotPass.setForeground(Color.WHITE);
    setConstraints(c1, 2, 2, null);
    textPanel.add(forgotPass, c1);
    forgotPass.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          Desktop.getDesktop().browse(new URI("https://my.ccs.neu.edu/forgot/password"));
        } catch (IOException | URISyntaxException i) {
          i.printStackTrace();
        }
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        forgotPass.setBackground(Color.darkGray);
      }
      @Override
      public void mouseExited(MouseEvent e) {
        forgotPass.setBackground(Color.RED.darker());
      }
    });

    String create = "Create account here!";
    JLabel createLabel = new JLabel(create);
    createLabel.setFont(new Font("TimesRoman", Font.PLAIN, 14));
    createLabel.setForeground(Color.RED.darker());
    createLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    createLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          Desktop.getDesktop().browse(new URI("https://my.ccs.neu.edu/account/apply"));
        } catch (IOException | URISyntaxException i) {
          i.printStackTrace();
        }
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        createLabel.setForeground(Color.darkGray);
      }
      @Override
      public void mouseExited(MouseEvent e) {
        createLabel.setForeground(Color.RED.darker());
      }
    });

    JPanel buttonPanel = gridLayPanel(40,20);
    GridBagConstraints c2 = new GridBagConstraints();
    c2.fill = GridBagConstraints.HORIZONTAL;
    JButton loginButton = new JButton("LOGIN");
    loginButton.setFont(new Font("courrier new", Font.BOLD, 20));
    loginButton.addActionListener(e -> {
      if ((this.username.getText().equals("student") && this.password.getText().equals("12345"))) {
        this.vm.showScreen("classes", "login");
        this.password.setText("");
        this.username.setText("");
      } else {
    }
    });
    loginButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,
                "Username or password is incorrect");
      }
    });
    loginButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        loginButton.setBackground(Color.darkGray);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        loginButton.setBackground(Color.RED.darker());
      }
    });
    loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    loginButton.setBackground(Color.RED.darker());
    loginButton.setForeground(Color.WHITE);
    setConstraints(c2, 0, 1, null);
    buttonPanel.add(loginButton, c2);

    Icon logo = new ImageIcon(Schedule.class.getResource("logo.jpg"));
    JLabel logoLabel = new JLabel();
    logoLabel.setIcon(logo);
    setConstraints(c, 0, 1 ,new Insets(0, 10,0,0));
    this.add(logoLabel, c);


    setConstraints(c, 0, 2, new Insets(20, 50, 0, 75));
    this.add(textPanel,c);


    setConstraints(c, 0, 3, new Insets(10, 0, 0, 0));
    this.add(createLabel,c);

    setConstraints(c, 0, 4, new Insets(20, 0, 0, 0));
    this.add(buttonPanel,c);
  }
}
