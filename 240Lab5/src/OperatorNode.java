
/**
 * Operator nodes are the internal nodes of a binary expression tree.
 * 
 * @author ???
 * @version ???
 */
public class OperatorNode extends ExpressionNode {

  private Operator op;

  public OperatorNode(Operator op) {
    super();
    this.op = op;
  }

  public OperatorNode(Operator op, ExpressionNode left, ExpressionNode right) {
    super(left, right);
    this.op = op;
  }

  /**
   * Evaluate the expression rooted at this node and return the result.
   */
  @Override
  public double evaluate() {
    switch (op) {
      case ADD:
        return this.left().evaluate() + this.right().evaluate();
      case SUBTRACT:
        return this.left().evaluate() - this.right().evaluate();
      case MULTIPLY:
        return this.left().evaluate() * this.right().evaluate();
      case DIVIDE:
        return this.left().evaluate() / this.right().evaluate();
    }
    return this.evaluate();

  }

  @Override
  public String postfixString() {
    return this.left().postfixString() + " " + this.right().postfixString() + " "+ op.opString();
  }

  @Override
  public String prefixString() {
    return op.opString() + " " + this.left().prefixString() + " " + this.right().prefixString();
  }

  @Override
  public String infixString() {
    return "(" + this.left().infixString() + " " + op.opString() + " " + this.right().infixString() + ")";
  }


}
