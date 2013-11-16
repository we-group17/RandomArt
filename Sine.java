public class Sine extends Expression {
  
  private Expression nextNode;
  
  public Sine (int height, double x, double y) {
    super(height, x, y);
    generateExpression();
  }
  
  public void generateExpression () {
    if (height != 1) {
      nextNode = randExpression();
    }
    else {
      generateOperand(x, y);
    }
  }
  
  public Expression randExpression () {
    int randNum = (int)(Math.random() * 4);
    if (randNum == 0) {
      return (new Multiply(this.height -1, x, y));
    }
    else if (randNum == 1) {
      return (new Average(this.height -1, x, y));
    }
    else if (randNum == 2) {
      return (new Sine(this.height -1, x, y));
    }
    else {
      return (new Cosine(this.height -1, x, y));
    }
  }
  
  public double getResult () {
    if (height != 1) {
      return Math.sin( Math.PI * nextNode.getResult() );
    }
    else {
      return getOperand();
    }
  }
  
  public String toString () {
    if(height == 1) {
      return operand;
    }
    else {
      return "sin(" +nextNode+ ")";
    }
  }
}