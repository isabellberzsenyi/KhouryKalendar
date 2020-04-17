package Views;

import java.awt.*;

import javax.swing.*;

public interface Screens {
  void setConstraints(GridBagConstraints constraint, int x, int y, Insets insets);
  JPanel gridLayPanel(int x, int y);
}
