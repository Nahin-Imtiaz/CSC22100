import javafx.scene.canvas.GraphicsContext;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *Class MyRectangle inherits class MyShape. The MyRectangle object is defined by its height and width centered at (x, y), and may be filled with a color
 */
public class MyRectangle extends MyShape {
	double height;
	double width;
	double area;
	static double perimeter;
	/**
	 * this constructor is used to create a MyRectangle Object with parameters
	 * @param height
	 * this is the height of the rectangle
	 * @param width
	 * this is the width of the rectangle
	 * @param color
	 * this is the color of the rectangle
	 */
	MyRectangle(double height, double width, MyColor color) {
		super(color);
		this.height=height;
		this.width=width;
	}
	/**
	 * this method returns the height of the rectangle
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * this method sets the height of the rectangle
	 * @param height
	 * this is the height of the rectangle
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**this method returns the width of the rectangle
	 * @return
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * this method returns the width of the rectangle
	 * @param width
	 * this is the width of the rectangle
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * this method returns the perimeter of the rectangle
	 * @return
	 */
	public static double getPerimeter() {
		return perimeter;
	}
	/**
	 * this method returns the area of the rectangle
	 * @return
	 */
	public double getArea() {
		return this.area;
	}
	/**
	 * this method sets the perimeter of the rectangle
	 */
	public void setPerimeter() {
		this.perimeter= 2*(height+width);
	}
	/**
	 * this method sets the area of the rectangle
	 */
	public void setArea() {
		this.area= height*width;
	}
	/**
	 * This method returns a string representation of the MyRectangle object: height ,width , perimeter and area 
	 */
	@Override
	public String toString() {
		return String.format(this.width+""+this.height+""+getPerimeter()+""+getArea());
	}
	/**
	 * this method  draws a MyRectangle object whose center points are point[0] and point[1] and has height and width
	 */
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(this.color.getColor());
		gc.fillRect(MyPoint.point[0], MyPoint.point[1], this.width, this.height);
	}
	/**
	 * this method returns bounding box MyRectangle of this MyRectangle object
	 */
	@Override
	public MyRectangle getMyBoundingBox() {
		
		return this;
	}

}
