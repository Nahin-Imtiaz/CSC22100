import javafx.scene.canvas.GraphicsContext;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *Class MyOval inherits class MyShape. The MyOval object is defined by an ellipse inscribed in a rectangle of height h and
 *width w, centered at a point (x, y)
 **/
public class MyOval extends MyShape {
	double height;
	double width;
	/**
	 * this constructor is used to create a MyOval Object with parameters
	 * @param height
	 * this is the height of the oval
	 * @param width
	 * this is the width of the oval
	 * @param color
	 * this is the color of the oval
	 */
	MyOval(double height, double width, MyColor color) {
		super(color);
		this.height=height;
		this.width=width;
	}
	/**
	 * this method returns the perimeter of the oval
	 * @return
	 */
	public double getPerimeter() {
		return 2*Math.PI*(Math.sqrt((Math.pow(height/2, 2)+Math.pow(width/2, 2))/2));
	}
	/**
	 * this method returns the area of the oval
	 * @return
	 */
	public double getArea() {
		return height*width*Math.PI;
	}
	/**
	 * This method returns a string representation of the MyOval object: height,width,perimeter and area
	 */
	@Override
	public String toString() {
		return String.format(this.width+""+this.height+""+getPerimeter()+""+getArea());
	}
	/**
	 * this method  draws a MyOval object whose starting points are point[0] and point[1] and has height and width
	 */
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(this.color.getColor());
		gc.fillOval(MyPoint.point[0], MyPoint.point[1], width, height);
		
	}
	/**
	 * this method returns bounding box MyRectangle of this MyOval object
	 */
	@Override
	public MyRectangle getMyBoundingBox() {
		MyRectangle boundingBox = new MyRectangle(height,width,this.color);
		return boundingBox;
	}
}
