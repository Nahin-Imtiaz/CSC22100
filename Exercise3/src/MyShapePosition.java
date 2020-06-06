/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *Interface MyShapePosition describe the functions and behaviors of the specific object types of
 *the class hierarchy and extends interface MyPoint
 */
public interface MyShapePosition extends MyPoint{
	/**
	 * this abstract method gives the bounding rectangle of the class object 
	 * @return
	 */
	public MyRectangle getMyBoundingBox();
	/**
	 * this method returns true if two objects in the class hierarchy do overlap; false
	 * otherwise.
	 * @param shape1
	 * this is the primary shape
	 * @param shape2
	 * this is the shape to compare with 
	 * @return
	 */
	public static boolean doOverlap(MyShape shape1, MyShape shape2) {
		// storing the heigh and width of each shape
		double heightOfShape1=shape1.getMyBoundingBox().getHeight();
		double widthOfShape1=shape1.getMyBoundingBox().getWidth();
		double heightOfShape2=shape2.getMyBoundingBox().getHeight();
		double widthOfShape2=shape2.getMyBoundingBox().getWidth();
		
		double[] points = MyPoint.getPoint();
		//creating 4 corner points for each shape 
		int[] shape1corner1, shape1corner2, shape1corner3, shape1corner4, shape2corner1, shape2corner2, shape2corner3, shape2corner4;
		
		shape1corner1= new int[2];
		shape1corner2= new int[2];
		shape1corner3= new int[2];
		shape1corner4= new int[2];
		shape2corner1= new int[2];
		shape2corner2= new int[2];
		shape2corner3= new int[2];
		shape2corner4= new int[2];
		// initializing the corner points of shape 1
		shape1corner1[0]= (int)points[0];
		shape1corner1[1]= (int)points[0];
		shape1corner2[0]= (int)(points[0]+widthOfShape2);
		shape1corner2[1]= (int)(points[0]);
		
		shape1corner3[0]= (int)(points[0]+widthOfShape2);
		shape1corner3[1]= (int)(points[0]+heightOfShape2);
		shape1corner4[0]= (int)(points[0]);
		shape1corner4[1]= (int)(points[0]+widthOfShape2);
		//initializing the corner points of shape 2
		shape2corner1[0]= (int)(points[0]);
		shape2corner1[1]= (int)(points[0]);
		shape2corner2[0]= (int)(points[0]+widthOfShape2);
		shape2corner2[1]= (int)(points[0]);
		
		shape2corner3[0]= (int)(points[0]+widthOfShape2);
		shape2corner3[1]= (int)(points[0]+heightOfShape2);
		shape2corner4[0]= (int)(points[0]);
		shape2corner4[1]= (int)(points[0]+widthOfShape2);
		// flag set to false so that overlap is not happening
		boolean flag = false;
		//Checking each points of Side A of the shape 2 with every side of shape 2
		for(int i=shape2corner1[0];i<=shape2corner2[0];i++) {
			if(onSegment(shape1corner1[0],shape1corner1[1],i,shape2corner1[1],shape1corner2[0],shape1corner2[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner2[0],shape1corner2[1],i,shape2corner1[1],shape1corner3[0],shape1corner3[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner3[0],shape1corner3[1],i,shape2corner1[1],shape1corner4[0],shape1corner4[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner4[0],shape1corner4[1],i,shape2corner1[1],shape1corner1[0],shape1corner1[1])) {
				flag= true;;
			}
		}	
		//Checking each points of Side B of the shape 2 with every side of shape 2
		for(int i=shape2corner2[1];i<=shape2corner3[1];i++) {
			if(onSegment(shape1corner1[0],shape1corner1[1],shape2corner2[0],i,shape1corner2[0],shape1corner2[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner2[0],shape1corner2[1],shape2corner2[0],i,shape1corner3[0],shape1corner3[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner3[0],shape1corner3[1],shape2corner2[0],i,shape1corner4[0],shape1corner4[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner4[0],shape1corner4[1],shape2corner2[0],i,shape1corner1[0],shape1corner1[1])) {
				flag= true;
			}
		}
		//Checking each points of Side C of the shape 2 with every side of shape 2
		for(int i=shape2corner3[0];i<=shape2corner4[0];i++) {
			if(onSegment(shape1corner1[0],shape1corner1[1],i,shape2corner3[1],shape1corner2[0],shape1corner2[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner2[0],shape1corner2[1],i,shape2corner3[1],shape1corner3[0],shape1corner3[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner3[0],shape1corner3[1],i,shape2corner3[1],shape1corner4[0],shape1corner4[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner4[0],shape1corner4[1],i,shape2corner3[1],shape1corner1[0],shape1corner1[1])) {
				flag= true;
			}
		}
		//Checking each points of Side D of the shape 2 with every side of shape 2
		for(int i=shape2corner4[1];i<=shape2corner1[1];i++) {
			if(onSegment(shape1corner1[0],shape1corner1[1],shape2corner4[0],i,shape1corner2[0],shape1corner2[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner2[0],shape1corner2[1],shape2corner4[0],i,shape1corner3[0],shape1corner3[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner3[0],shape1corner3[1],shape2corner4[0],i,shape1corner4[0],shape1corner4[1])) {
				flag= true;
			}
			else if(onSegment(shape1corner4[0],shape1corner4[1],shape2corner4[0],i,shape1corner1[0],shape1corner1[1])) {
				flag= true;
			}
		}
		return flag;
	}
	/**
	 * this method returns true if point Q(q1,q2) is in the range of points P(p1,p2) and R(r1,r2)
	 * @param p1
	 * this is the x of point p
	 * @param p2
	 * this is the y of point p
	 * @param q1
	 * this is the x of point q
	 * @param q2
	 * this is the y of point q
	 * @param r1
	 * this is the x of point r
	 * @param r2
	 * this is the y of point r
	 * @return
	 */
	static boolean onSegment(int p1,int p2,int q1,int q2,int r1 , int r2) 
	{ 
	    if (q1 <= Math.max(p1, r1) && q1 >= Math.min(p1, r1) && 
	        q2 <= Math.max(p2, r2) && q2 >= Math.min(p2, r2)) return true; 
	  
	    return false; 
	}
}
