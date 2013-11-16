public abstract class Expression {
  
  protected String operand;
  protected int height;
  protected double x;
  protected double y;
  protected double value;
  
  public Expression (int height, double x, double y) {
    this.height = height;
    this.x = x;
    this.y = y;
  }
  
  public void generateOperand (double x, double y) {
    int randOperand = (int)(Math.random() * 2);
    if (randOperand == 0) {
      this.operand = "x";
      value = x;
    }
    else {
      this.operand = "y";
      value = y;
    }
  }
  
  public double getOperand () {
    return value;
  }
  
  public abstract double getResult ();
}