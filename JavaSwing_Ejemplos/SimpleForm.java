
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class SimpleForm extends JFrame
{
  private JPanel backPanel;
  private JPanel inputPanel;
  private JPanel buttonPanel;
  private JTextField op1 = new JTextField();
  private JTextField op2 = new JTextField();
  private JLabel op1label;
  private JLabel op2label;
  private JLabel sumLabel;
  private JLabel resultLabel;
  private JButton addButton;
  private JButton clearButton;

  public SimpleForm()
  {
    super("SimpleForm");
    createForm();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void createLabels()
  {
    op1label = new JLabel("The value:");
    op2label = new JLabel("added to:");
    sumLabel = new JLabel("gives:");
    resultLabel = new JLabel("");
  }

  private void createButtons()
  {
    addButton = new JButton("Add");
    addButton.addActionListener((ActionEvent e) -> addButtonClicked());
    clearButton = new JButton("Clear");
    clearButton.addActionListener((ActionEvent e) -> clearButtonClicked());
  }

  private void createButtonPanel()
  {
    createButtons();
    buttonPanel = new JPanel();
    buttonPanel.add(addButton);
    buttonPanel.add(clearButton);
  }

  private void createInputPanel()
  {
    createLabels();
    GridLayout panelLayout = new GridLayout(3, 2, 8, 8);
    inputPanel = new JPanel(panelLayout);
    inputPanel.add(op1label);
    inputPanel.add(op1);
    inputPanel.add(op2label);
    inputPanel.add(op2);
    inputPanel.add(sumLabel);
    inputPanel.add(resultLabel);
  }

  private void createBackPanel()
  {
    backPanel = new JPanel(new BorderLayout());
    backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    backPanel.add(inputPanel, BorderLayout.CENTER);
    backPanel.add(buttonPanel, BorderLayout.SOUTH);
  }

  private void createForm()
  {
    createButtonPanel();
    createInputPanel();
    createBackPanel();
    add(backPanel, BorderLayout.CENTER);
  }

  private void addButtonClicked()
  {
    String resultMessage;
    try
    {
      double x = Double.parseDouble(op1.getText());
      double y = Double.parseDouble(op2.getText());
      resultMessage = "" + (x + y);
    }
    catch (NumberFormatException ex)
    {
      resultMessage = "Invalid input";
    }
    resultLabel.setText(resultMessage);
  }

  private void clearButtonClicked()
  {
    op1.setText("");
    op2.setText("");
    resultLabel.setText("");
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(SimpleForm::new);
  }
}
