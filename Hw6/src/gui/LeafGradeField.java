package gui;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import grading.*;

/**
 * CS 345 LeafGradeField.
 * 
 * @author Joshua Steffen
 * @version 2/24/22
 */
public class LeafGradeField extends JTextField
{
  public static long serialVersionUID = 1L;
  private LeafGrade template;


  /**
   * Creates a new LeafGradeField.
   * 
   * @param template
   *          assigned to template
   */
  public LeafGradeField(final LeafGrade template)
  {
    super();
    this.template = template;
    super.setText(template.getValue().toString());
    TitledBorder border = new TitledBorder(LineBorder.createBlackLineBorder(), template.getKey());
    super.setBorder(border);
    super.setSelectedTextColor(Color.BLUE);
  }

  /**
   * Returns a LeafGrade with key from template and value from contents of LeafGradeField.
   * 
   * @return the LeafGrade
   */
  public Grade getGrade()
  {
    LeafGrade result;
    result = new LeafGrade(template.getKey(), Double.parseDouble(super.getText()));
    return result;
  }

  /**
   * Returns the templates key.
   * 
   * @return the key
   */
  public String getKey()
  {
    return template.getKey();
  }

  /**
   * Sets the text to an empty string "".
   */
  public void reset()
  {
    super.setText("");
  }
}
