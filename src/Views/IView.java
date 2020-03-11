package Views;

import java.awt.*;

import javax.swing.*;

public interface IView {
  JPanel gridLayPanel(int x, int y);
  void setConstraints(GridBagConstraints constraint, int x, int y, Insets insets);
//  void saveData() throws IOException;
//  void renderData() throws IOException;
}
