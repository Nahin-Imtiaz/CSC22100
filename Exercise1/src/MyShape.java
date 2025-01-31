/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *
 *Class MyShapeis the hierarchy�s superclass and inherits the Java class Object. An
 *implementation of the class defines a point (x, y) and the color of the shape. 
 */
import javafx.scene.canvas.GraphicsContext;
public abstract class MyShape {
	private double x;
	private double y;
	MyColor color;
	/**
	 * This constructor is used to create a MyShape object with parameters
	 * @param x
	 * this is the x coordinator
	 * @param y
	 * this is the y coordinator
	 */
	MyShape(int x,int y){
		this.x =x;
		this.y =y;
	}
	/**
	 * This constructor initializes the color value of shape 
	 * @param color
	 * this is the color of the shape
	 */
	MyShape(MyColor color){
		this.color= color;
	}
	/**
	 * this method returns the x coordinate
	 * @return double
	 */
	public double getX() {
		return x;
	}
	/**
	 * this method sets the value of x coordinate
	 * @param x
	 * this is the value of x coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * this method returns the y coordinate
	 * @return double
	 */
	public double getY() {
		return y;
	}
	/**
	 * this method sets the value of y coordinate
	 * @param y
	 * this is the value of y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * this method returns the color of the shape
	 * @return MyColor
	 */
	public MyColor getColor() {
		return color;
	}
	/**
	 * this method sets color of the shape
	 * @param color
	 * this is the value of color
	 */
	public void setColor(MyColor color) {
		this.color = color;
	}
	/**
	 * returns the object's description as a String
	 */
	public abstract String toString();
	/**
	 * this method draws a MyShape object
	 * @param gc
	 */
	public abstract void draw(GraphicsContext gc);
}
