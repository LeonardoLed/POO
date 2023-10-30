import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListFrame extends JFrame
{
  private JPanel backPanel;
  private JPanel inputPanel;
  private JTextField inputField;
  private JPanel buttonPanel;
  private JButton removeButton;
  private JButton addButton;
  private JScrollPane scroller;
  private JList<String> list;
  private DefaultListModel<String> model;

  public ListFrame()
  {
    super("List Frame");
    createGUI();
    setModel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void setModel()
  {
    model = new DefaultListModel<String>();
    list.setModel(model);
  }

  private void createGUI()
  {
    createScrollerPanel();
    createButtonPanel();
    createInputPanel();
    createBackPanel();
    add(backPanel, BorderLayout.CENTER);
  }

  private void createScrollerPanel()
  {
    list = new JList<String>();
    list.addMouseListener(
      new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          listClicked();
        }
      });
    scroller = new JScrollPane(list);
  }

  private void createButtonPanel()
  {
    addButton = new JButton("Add");
    addButton.addActionListener((ActionEvent e) -> addButtonClicked());
    removeButton = new JButton("Remove");
    removeButton.setEnabled(false);
    removeButton.addActionListener((ActionEvent e) -> removeButtonClicked());
    buttonPanel = new JPanel();
    buttonPanel.add(addButton);
    buttonPanel.add(removeButton);
  }

  private void createInputPanel()
  {
    inputPanel = new JPanel(new BorderLayout());
    inputPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    inputField = new JTextField();
    inputPanel.add(inputField, BorderLayout.NORTH);
    inputPanel.add(buttonPanel, BorderLayout.CENTER);
  }

  private void createBackPanel()
  {
    backPanel = new JPanel(new BorderLayout());
    backPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    backPanel.add(scroller, BorderLayout.CENTER);
    backPanel.add(inputPanel, BorderLayout.SOUTH);
  }

  private void addButtonClicked()
  {
    String s = inputField.getText();
    if (s.length() > 0)
    {
      model.addElement(s);
    }
    inputField.setText("");
  }

  private void removeButtonClicked()
  {
    int i = list.getSelectedIndex();
    if (!(i < 0) || (i > model.size()))
    {
      model.remove(i) ;
    }
    removeButton.setEnabled(false);
  }

  private void listClicked()
  {
    int n = list.getSelectedIndex();
    if (!(n < 0) || (n > model.size()))
    {
      removeButton.setEnabled(true);
    }
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(ListFrame::new);
  }
}