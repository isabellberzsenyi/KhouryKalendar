package Views;

import java.awt.*;

import javax.swing.*;

public class AView extends JPanel implements IView  {
  ViewMain vm;

  public AView(ViewMain vm) {
    this.vm = vm;
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
//  public void saveData() throws IOException {
//    BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
//    writer.write(this.vm.getUser());
//    writer.close();
//  }
//  public void renderData() throws IOException {
//    BufferedReader br = new BufferedReader(new FileReader("data.txt"));
//    this.vm.setUser(br.readLine());
//  }
}
