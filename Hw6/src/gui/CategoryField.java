package gui;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import grading.*;

/**
 * CS 345 CategoryField.
 * 
 * @author Joshua Steffen
 * @version 2/24/22
 */
public class CategoryField extends JPanel
{
  public static long serialVersionUID = 1L;
  private CompositeGrade template;
  private List<LeafGradeField> fields;
  

  /**
   * Creates a new CategoryField.
   * 
   * @param template
   *          the CompositeGrade to use for grades
   */
  public CategoryField(final CompositeGrade template)
  {
    super();
    this.template = template;
    fields = new ArrayList<LeafGradeField>();
    LeafGradeField next;
    for (int i = 0; i < template.getComponents().size(); i++)
    {
      if (template.getComponents().get(i) instanceof LeafGrade)
      {
        next = new LeafGradeField((LeafGrade) template.getComponents().get(i));
        fields.add(next);
      }
    }
    TitledBorder border = new TitledBorder(LineBorder.createBlackLineBorder(), template.getKey());
    super.setBorder(border);
    super.setLayout(new BoxLayout(new Container(), BoxLayout.X_AXIS));
    for (int i = 0; i < fields.size(); i++)
    {
      super.add(fields.get(i));
    }
  }

  /**
   * The composite grade belonging to this object.
   * 
   * @return the grade
   */
  public Grade getGrade()
  {
    CompositeGrade result;
    result = new CompositeGrade(template.getKey());
    for (int i = 0; i < fields.size(); i++)
    {
      result.add(fields.get(i).getGrade());
    }
    result.setFilter(template.getFilter());
    result.setStrategy(template.getStrategy());
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
   * Resets all the LeafGradeFields.
   */
  public void reset()
  {
    for (int i = 0; i < fields.size(); i++)
    {
      fields.get(i).reset();
    }
  }
}
