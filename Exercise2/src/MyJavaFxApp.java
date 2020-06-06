import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *This class uses JavaFX graphics and the class hierarchy to draw a geometric configuration comprised of a sequence of alternating  concentric ovals and their inscribed
 *rectangles
 */
public class MyJavaFxApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Initializing a Canvas object from addCanvas() method with given width and height
		Canvas cv = addCanvas(800,400 );
		int w = (int)cv.getWidth();
		int h = (int)cv.getHeight();
		// Creating a Pane and setting the canvas in the center of the Pane
		Pane p = new Pane();
		p.getChildren().add(cv);
		// Creating Scene object and setting the Scene in Stage
		Scene sc =new Scene(p,w,h,MyColor.WHITE.getColor());
		primaryStage.setScene(sc);
		primaryStage.setTitle("Geometric Configuration ");
		primaryStage.show();
	}
	/**
	 * this method is used to create a canvas object with parameters and draw geometric configuration on GraphicsContxt object
	 * @param w
	 * this is the width of the canvas
	 * @param h
	 * this is the height of the canvas
	 * @return Canvas
	 */
	public Canvas addCanvas(int w, int h) {
		Canvas cv= new Canvas(w,h); 
		GraphicsContext gc = cv.getGraphicsContext2D();
		//Initializing the center point
		MyPoint.setPoint(w/4,h/4);
		//Creating and drawing the first rectangle proportionate to the canvas
		MyRectangle rectangle1 = new MyRectangle(h/2,w/2,MyColor.BLUE);
		rectangle1.draw(gc);
		//Creating and drawing the first oval inscribed in the rectangle
		MyOval oval1 = new MyOval(rectangle1.getHeight(),rectangle1.getWidth(),MyColor.YELLOW);
		oval1.draw(gc);
		
		// Calculating the new height and width and new points 
		double newHeight = (h/2)/Math.sqrt(2);
		double newWidth =  (w/2)/Math.sqrt(2);
		double newX = w/4 + (((w/2)-newWidth)/2);
		double newY = h/4 + (((h/2)-newHeight)/2);
		MyPoint.setPoint(newX,newY);
		//Creating and drawing the second rectangle proportionate to the first rectangle
		MyRectangle rectangle2 = new MyRectangle(newHeight,newWidth,MyColor.PINK);
		rectangle2.draw(gc);
		//Creating and drawing the second oval inscribed in the second rectangle
		MyOval oval2 = new MyOval(rectangle2.getHeight(),rectangle2.getWidth(),MyColor.GREEN);
		oval2.draw(gc);
		// Calculating the new height and width and new points 
		double newHeight2 = (newHeight)/Math.sqrt(2);
		double newWidth2 =  (newWidth)/Math.sqrt(2);
		double newX2 = w/4 + (((w/2)-newWidth2)/2);
		double newY2 = h/4 + (((h/2)-newHeight2)/2);
		MyPoint.setPoint(newX2,newY2);
		//Creating and drawing the third rectangle proportionate to the second rectangle
		MyRectangle rectangle3 = new MyRectangle(newHeight2,newWidth2,MyColor.RED);
		rectangle3.draw(gc);
		//Creating and drawing the third oval inscribed in the third rectangle
		MyOval oval3 = new MyOval(rectangle3.getHeight(),rectangle3.getWidth(),MyColor.ORANGE);
		oval3.draw(gc);
					
		//creating and drawing MyLine object (Diagonal)
		MyPoint.setPoint(w,h/2);
		MyLine line1 = new MyLine(0,0,w,h,MyColor.BLACK);
		line1.draw(gc);
		//creating and drawing MyLine object (Top Horizontal)
		MyLine line3 = new MyLine(0,0,w,0,MyColor.BLACK);
		line3.draw(gc);
		//creating and drawing MyLine object (Bottom Horizontal)
		MyLine line4 = new MyLine(0,h,w,h,MyColor.BLACK);
		line4.draw(gc);
		//creating and drawing MyLine object (Left Vertical)
		MyLine line5 = new MyLine(0,0,0,h,MyColor.BLACK);
		line5.draw(gc);
		//creating and drawing MyLine object (Right Vertical)
		MyLine line6 = new MyLine(w,0,w,h,MyColor.BLACK);
		line6.draw(gc);
	
		return cv;
	}

}
