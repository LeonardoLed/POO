import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class HelloGoodbye extends JFrame
{
  private static final String HELLO = "Hello!";
  private static final String GOODBYE = "Goodbye!";

  private String message = HELLO;

  private JPanel aPanel;
  private JButton aButton;
  private JLabel aLabel;

  public HelloGoodbye()
  {
    super("HelloGoodbye");

    aPanel = new JPanel();
    aButton = new JButton("Click Me");
    aLabel = new JLabel(message, SwingConstants.CENTER);

    aPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
    aPanel.setLayout(new BorderLayout());
    aPanel.add(aLabel, BorderLayout.CENTER);
    aPanel.add(aButton, BorderLayout.SOUTH);

    aButton.addActionListener(event ->
      {
        message = message.equals(HELLO) ? GOODBYE : HELLO;
        aLabel.setText(message);
      }
    );

    add(aPanel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }

  public static void main(final String[] args)
  {
    SwingUtilities.invokeLater(HelloGoodbye::new);
  }
}
