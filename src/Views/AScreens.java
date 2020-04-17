package Views;

import java.awt.*;

import javax.swing.*;

public class AScreens extends JPanel  implements Screens{
  public ViewMain vm;

  public AScreens(ViewMain vm) {
    this.vm = vm;
  }


  @Override
  public void setConstraints(GridBagConstraints constraint, int x, int y, Insets insets) {
    constraint.gridx = x;
    constraint.gridy = y;
    if (insets != null) {
      constraint.insets = insets;
    }
  }

  @Override
  public JPanel gridLayPanel(int x, int y) {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setMaximumSize(new Dimension(x, y));
    panel.setBackground(Color.WHITE);
    return panel;
  }
}
