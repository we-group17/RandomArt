public class Average extends Expression {
  
  private Expression left;
  private Expression right;
  
  public Average (int height, double x, double y) {
    super(height, x, y);
    generateExpression();
  }
  
  public void generateExpression () {
    if (height != 1) {
      left = randExpression();
      right = randExpression();
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
      return ( left.getResult() + right.getResult() ) / 2;
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
      return "avg(" +left.toString()+ "," +right.toString()+ ")";
    }
  }
}