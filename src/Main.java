import javax.swing.*;

import Views.ViewMain;

public class Main {
  public static void main(String[] args) {
    try {
      //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (UnsupportedOperationException e) {
      e.printStackTrace();
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    ViewMain v = new ViewMain();
  }
}
