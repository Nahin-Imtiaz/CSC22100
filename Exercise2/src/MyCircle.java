import javafx.scene.canvas.GraphicsContext;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *Class MyCircle inherits class MyShape. The MyCircle object is defined by its radius, r, and center (x, y), and may be filled with a color
 */
public class MyCircle extends MyShape{
	double radius;
	/**
	 * this constructor is used to create an object of MyCircle with parameters
	 * @param radius
	 * this is the radius of the circle
	 * @param color
	 * this is the color of the circle
	 */
	MyCircle(double radius, MyColor color ){
		super(color);
		this.radius=radius;	
	}
	/**
	 * this method returns the area of the MyCircle object
	 * @return double
	 */
	public double getArea() {
		return Math.PI*(Math.pow(radius, 2));
	}
	/**
	 * this method returns the perimeter of the MyCircle object
	 * @return double
	 */
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	/**
	 * this method returns the radius of the MyCircle object
	 * @return double
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * this method returns a string representation of the MyCircle object: radius, perimeter, and area
	 */
	@Override
	public String toString() {
		return String.format(getRadius()+""+getPerimeter()+""+getArea());
	}
	/**
	 * this method draws a MyCircle object of radius r. The center point (x, y) of the circle is inherited from class MyPoint where x=point[0] and y=point[1]
	 */
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(this.getColor().myColor);
		gc.fillOval(MyPoint.point[0],MyPoint.point[1], 2*getRadius(), 2*getRadius());
	}
	/**
	 * this method returns bounding box MyRectangle of this MyCircle object
	 */
	@Override
	public MyRectangle getMyBoundingBox() {
		MyRectangle boundingBox = new MyRectangle(2*getRadius(),2*getRadius(),this.color);
		return boundingBox;
	}

}

