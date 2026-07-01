package gui;

import java.util.ArrayList;
import java.util.List;
import grading.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * CS 345 GradientWindow.
 * 
 * @author Joshua Steffen
 * @version 2/24/22
 */
public class GradientWindow extends JFrame implements ActionListener
{
  public static long serialVersionUID = 1L;
  private List<CategoryField> categoryFields;
  private CompositeGrade template;

  /**
   * Creates a new GradientWindow.
   * 
   * @param template
   *          the desired grades
   * @throws SizeException
   *           thrown bye CompositeGrade
   */
  public GradientWindow(final CompositeGrade template) throws SizeException
  {
    super();
    categoryFields = new ArrayList<CategoryField>();
    for (int i = 0; i < template.getComponents().size(); i++)
    {
      categoryFields.add(new CategoryField((CompositeGrade) template.getComponents().get(i)));
    }
    setupLayout();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
  }

  /**
   * Performs the action sent.
   * 
   * @param e
   *          the event
   */
  @Override
  public void actionPerformed(final ActionEvent e)
  {

  }

  /**
   * Setup and layout this GradientWindow.
   */
  private void setupLayout()
  {
    Container contentPane;

    setSize(300, 500);
    setTitle("ATM");

    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(createMenu(), BorderLayout.NORTH);
    for (int i = 0; i < categoryFields.size(); i++)
    {
      contentPane.add(categoryFields.get(i), BorderLayout.CENTER);
    }
  }

  private JMenuBar createMenu()
  {
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    menuBar.add(file);
    menuBar.add(edit);
    JMenuItem exit = new JMenuItem("Exit");
    file.add(exit);
    JMenuItem calculate = new JMenuItem("Calculate");
    JMenuItem reset = new JMenuItem("Reset");
    edit.add(calculate);
    edit.add(reset);
    return menuBar;
  }
}
