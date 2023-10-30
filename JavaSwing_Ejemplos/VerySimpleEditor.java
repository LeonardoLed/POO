
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VerySimpleEditor extends JFrame
{
  private JPanel editorPanel;
  private JTextArea editor;
  private JScrollPane scroller;
  private JPanel topPanel;
  private JPanel buttonPanel;
  private JButton loadButton;
  private JButton saveButton;
  private JButton cutButton;
  private JButton copyButton;
  private JButton pasteButton;

  public VerySimpleEditor()
  {
    createGUI();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void createGUI()
  {
    setTitle("Very simple editor");
    createEditorPanel();
    createButtonPanel();
    createTopPanel();
  }

  private void createTopPanel()
  {
    topPanel = new JPanel(new BorderLayout());
    topPanel.add(buttonPanel, BorderLayout.WEST);
    topPanel.add(editorPanel, BorderLayout.CENTER);
    add(topPanel, BorderLayout.CENTER);
  }

  private void createEditorPanel()
  {
    editor = new JTextArea();
    editor.setColumns(40);
    editor.setText("Type here");
    scroller = new JScrollPane(editor);
    editorPanel = new JPanel(new BorderLayout());
    editorPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    editorPanel.add(scroller, BorderLayout.CENTER);
  }

  private void createButtonPanel()
  {
    buttonPanel = new JPanel(new GridLayout(5, 1, 10, 3));
    buttonPanel.setBorder(BorderFactory.createEtchedBorder());
    createLoadButton();
    createSaveButton();
    createCutButton();
    createCopyButton();
    createPasteButton();
    buttonPanel.add(loadButton);
    buttonPanel.add(saveButton);
    buttonPanel.add(cutButton);
    buttonPanel.add(copyButton);
    buttonPanel.add(pasteButton);
  }

  private void createLoadButton()
  {
    loadButton = new JButton("Load...");
    loadButton.addActionListener((ActionEvent e) -> loadFile());
  }

  private void createSaveButton()
  {
    saveButton = new JButton("Save...");
    saveButton.addActionListener((ActionEvent e) -> saveFile());
  }

  private void createCutButton()
  {
    cutButton = new JButton("Cut");
    cutButton.addActionListener((ActionEvent e) -> cut());
  }

  private void createCopyButton()
  {
    copyButton = new JButton("Copy");
    copyButton.addActionListener((ActionEvent e) -> copy());
  }

  private void createPasteButton()
  {
    pasteButton = new JButton("Paste");
    pasteButton.addActionListener((ActionEvent e) -> paste());
  }

  // Display a file chooser and load a file.
  private void loadFile()
  {
    JFileChooser fc = new JFileChooser(".");
    int returnVal = fc.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      File file = fc.getSelectedFile();
      try
      {
        editor.read(new FileReader(file), null);
      }
      catch (IOException exp)
      {
        JOptionPane.showMessageDialog(this, "Unable to load the file", "File Error",
          JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  //Display a file chooser and save a file.
  private void saveFile()
  {
    JFileChooser fc = new JFileChooser(".");
    int returnVal = fc.showSaveDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      File file = fc.getSelectedFile();
      try
      {
        editor.write(new FileWriter(file));
      }
      catch (IOException exp)
      {
        JOptionPane.showMessageDialog(this, "Unable to save the file", "File Error",
          JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  // Cut, copy and paste are implemented using methods provided
  // by a superclass of the JTextArea class, and work with
  // the system clipboard.
  // Very useful and makes it very easy to implement cut/copy/paste!!
  //
  // The requestFocus method is used to make the JTextArea the active
  // component after a button is clicked. The component with the focus
  // receives the input events. If focus is not returned to the JTextArea
  // it remains with the button, preventing text being entered into
  // the text area until it is clicked on to regain focus.
  // Try commenting out the calls to requestFocus() to see the
  // difference in behaviour.
  private void cut()
  {
    editor.cut();
    editor.requestFocus();
  }

  private void copy()
  {
    editor.copy();
    editor.requestFocus();
  }

  private void paste()
  {
    editor.paste();
    editor.requestFocus();
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(VerySimpleEditor::new);
  }
}
