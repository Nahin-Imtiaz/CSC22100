/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *
 *Class MyShapeis the hierarchy’s superclass and MyShape implements interface
 *MyShapePosition which extends interface MyPoint. An
 *implementation of the class defines a point (x, y) and the color of the shape. 
 */
import javafx.scene.canvas.GraphicsContext;
public abstract class MyShape implements MyShapePosition{

	MyColor color;
	/**
	 * This constructor initializes the color value of shape 
	 * @param color
	 * this is the color of the shape
	 */
	MyShape(MyColor color){
		this.color= color;
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

