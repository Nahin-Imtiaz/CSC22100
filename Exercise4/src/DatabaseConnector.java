/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 */
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;

/** 
 * this class connects with a sql server, takes sql statements as strings and performs querys.This class creates tables and inserts data in those tables.This class also calculates the number of students getting each letter grade and displays a pie chart using MyPieChart class and MyColor class
 */
public class DatabaseConnector extends Application {
	
	public static double[] probabilityOfevents;

	public static void main(String[] args) {
		try {
			Connection conn = null;
			conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Student", "root", "124578369nN");
			//Creating Students Table with primary key as studentID 
			PreparedStatement myStat1 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS `Students` (\r\n" + 
					"  `studentID` int unsigned NOT NULL,\r\n" + 
					"  `firstName` varchar(45) NOT NULL,\r\n" + 
					"  `lastName` varchar(45) NOT NULL,\r\n" + 
					"  `email` varchar(45) NOT NULL,\r\n" + 
					"  `sex` varchar(45) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`studentID`)\r\n" + 
					") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
			
			myStat1.execute();
			//Creating Courses Table with primary key as courseID 
			PreparedStatement myStat2 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS `Courses` (\r\n" + 
					"  `courseID` varchar(45) NOT NULL,\r\n" + 
					"  `courseTitle` varchar(255) NOT NULL,\r\n" + 
					"  `department` varchar(255) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`courseID`)\r\n" + 
					") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
			
			myStat2.execute();
			//Creating Classes Table with primary key as courseID,studentID,section 
			PreparedStatement myStat3 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS `Classes` (\r\n" + 
					"  `courseID` varchar(45) NOT NULL,\r\n" + 
					"  `studentID` int unsigned NOT NULL,\r\n" + 
					"  `section` varchar(45) NOT NULL,\r\n" + 
					"  `year` varchar(45) NOT NULL,\r\n" + 
					"  `semester` varchar(45) NOT NULL,\r\n" + 
					"  `GPA` varchar(45) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`courseID`,`studentID`,`section`),\r\n" + 
					"  KEY `studentID_idx` (`section`),\r\n" + 
					"  KEY `studentID_idx1` (`studentID`),\r\n" + 
					"  CONSTRAINT `courseID` FOREIGN KEY (`courseID`) REFERENCES `Courses` (`courseID`),\r\n" + 
					"  CONSTRAINT `studentID` FOREIGN KEY (`studentID`) REFERENCES `Students` (`studentID`)\r\n" + 
					") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
			
			boolean myRs3 =myStat3.execute();
			//Inserting data into Students table. Total 30 students.
			String[] str = new String[30];
			str[0]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('01','Nahin','Imtiaz','daddb@gmail.com','M')";
			str[1]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('02','David','Beckham','db12@gmail.com','M')";
			str[2]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('03','Liam','Isaiah','db23@gmail.com','M')";
			str[3]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('04','Noah','Josiah','db211@gmail.com','M')";
			str[4]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('05','William','Hudson','d12b2@gmail.com','M')";
			str[5]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('06','James','Christian','d123b@gmail.com','M')";
			str[6]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('07','Oliver','Hunter','db123@gmail.com','M')";
			str[7]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('08','Benjamin','Connor','d32ewb@gmail.com','M')";
			str[8]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('09','Elijah','Eli','defwb@gmail.com','M')";
			str[9]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('10','Lucas','Ezra','dbdffd@gmail.com','M')";
			str[10]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('11','Mason','Aaron','dbhyj@gmail.com','M')";
			str[11]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('12','Logan','Landon','dbht@gmail.com','M')";
			str[12]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('13','Alexander','Adrian','dbf44@gmail.com','M')";
			str[13]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('14','Ethan','Jonathan','dbtfd@gmail.com','M')";
			str[14]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('15','Jacob','Nolan','dbvdvd@gmail.com','M')";
			str[15]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('16','Michael','Jeremiah','dbvdxc@gmail.com','M')";
			str[16]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('17','Daniel','Easton','dbbbhk@gmail.com','F')";
			str[17]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('18','Emma','Lucy','dbiutl@gmail.com','F')";
			str[18]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('19','Olivia','Paisley','dbhgd@gmail.com','F')";
			str[19]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('20','Ava','Anna','ddhjb@gmail.com','F')";
			str[20]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('21','Isabella','Caroline','dbdjghj@gmail.com','F')";
			str[21]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('22','Sophia','Nova','dcbb@gmail.com','F')";
			str[22]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('23','Charlotte','Genesis','db234@gmail.com','F')";
			str[23]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('24','Mia','Kennedy','db45@gmail.com','F')";
			str[24]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('25','Amelia','Maya','dbtr@gmail.com','F')";
			str[25]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('26','Harper','Willow','dbrg@gmail.com','F')";
			str[26]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('27','Evelyn','Kinsley','fghdb@gmail.com','F')";
			str[27]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('28','Abigail','Naomi','fhghdb@gmail.com','F')";
			str[28]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('29','Elizabeth','Beckham','dfghb@gmail.com','F')";
			str[29]="insert IGNORE into Students (studentID, firstName,lastName,email,sex) values ('30','Mila','Aaliyah','dbvnn@gmail.com','F')";
			//Executing all the statements
			for(int i=0;i<str.length;i++) {
				PreparedStatement myStat = conn.prepareStatement(str[i]);
				myStat.executeUpdate();
			}
			//Inserting data into Courses table. Total 10 courses.
			String[] str2 = new String[10];
			str2[0]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 10300','Introduction To Programming And Computer Science','Department of Computer Science')";
			str2[1]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 11300','Programming Language','Department of Computer Science')";
			str2[2]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 10400','Discrete Mathematical Structures','Department of Computer Science')";
			str2[3]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 21100','Fundamentals Of Computer Systems','Department of Computer Science')";
			str2[4]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 21200','Data Structures','Department of Computer Science')";
			str2[5]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 21700','Probability And Statistics For Computer Science','Department of Computer Science')";
			str2[6]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 22000','Algorithms','Department of Computer Science')";
			str2[7]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 22100','Software Design Laboratory','Department of Computer Science')";
			str2[8]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 30100','Numerical Issues In Scientific Programming','Department of Computer Science')";
			str2[9]="insert IGNORE into Courses (courseID, courseTitle,department) values ('CSC 30400','Introduction To Theoretical Computer Science','Department of Computer Science')";
			//Executing all the statements
			for(int i=0;i<str2.length;i++) {
				PreparedStatement myStat = conn.prepareStatement(str2[i]);
				myStat.executeUpdate();
			}
			//Inserting data into Classes table. Total 50 entries.30 data is for CSE 22100. 
			String[] str3 = new String[50];
			str3[0]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','01','A','Spring','2020','A')";
			str3[1]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','02','A','Spring','2020','A')";
			str3[2]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','03','A','Spring','2020','A')";
			str3[3]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','04','A','Spring','2020','A')";
			str3[4]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','05','A','Spring','2020','A')";
			str3[5]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','06','A','Spring','2020','A')";
			str3[6]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','07','A','Spring','2020','A')";
			str3[7]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','08','A','Spring','2020','B')";
			str3[8]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','09','A','Spring','2020','B')";
			str3[9]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','10','A','Spring','2020','B')";
			str3[10]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','11','B','Spring','2020','B')";
			str3[11]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','12','B','Spring','2020','B')";
			str3[12]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','13','B','Spring','2020','B')";
			str3[13]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','14','B','Spring','2020','B')";
			str3[14]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','15','B','Spring','2020','B')";
			str3[15]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','16','B','Spring','2020','B')";
			str3[16]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','17','B','Spring','2020','B')";
			str3[17]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','18','B','Spring','2020','B')";
			str3[18]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','19','B','Spring','2020','C')";
			str3[19]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','20','B','Spring','2020','C')";
			str3[20]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','21','C','Spring','2020','C')";
			str3[21]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','22','C','Spring','2020','C')";
			str3[22]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','23','C','Spring','2020','C')";
			str3[23]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','24','C','Spring','2020','C')";
			str3[24]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','25','C','Spring','2020','D')";
			str3[25]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','26','C','Spring','2020','D')";
			str3[26]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','27','C','Spring','2020','D')";
			str3[27]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','28','C','Spring','2020','F')";
			str3[28]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','29','C','Spring','2020','F')";
			str3[29]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','30','C','Spring','2020','W')";
			str3[30]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 11300','01','A','Fall','2019','A')";
			str3[31]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 10400','01','B','Fall','2019','A')";
			str3[32]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 11300','01','C','Fall','2019','A')";
			str3[33]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 21100','01','D','Fall','2019','A')";
			str3[34]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 21200','01','E','Spring','2020','A')";
			str3[35]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 21700','01','F','Spring','2020','A')";
			str3[36]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22000','01','G','Spring','2020','A')";
			str3[37]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 30100','01','H','Spring','2020','A')";
			str3[38]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 30400','01','I','Spring','2020','A')";
			str3[39]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','01','G','Fall','2019','A')";
			str3[40]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','02','G','Fall','2019','A')";
			str3[41]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','03','G','Fall','2019','B')";
			str3[42]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','04','G','Fall','2019','B')";
			str3[43]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','05','G','Fall','2019','B')";
			str3[44]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','06','H','Fall','2019','C')";
			str3[45]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','07','H','Fall','2019','C')";
			str3[46]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','08','H','Fall','2019','C')";
			str3[47]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','09','H','Fall','2019','D')";
			str3[48]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','10','H','Fall','2019','D')";
			str3[49]="insert IGNORE into Classes (courseID, studentID,section,semester,year,GPA) values ('CSC 22100','11','H','Fall','2019','F')";
			//Executing all the statements
			for(int i=0;i<str3.length;i++) {
				PreparedStatement myStat = conn.prepareStatement(str3[i]);
				myStat.executeUpdate();
			}
			//showValue() returning an array of integers containing the frequency of students getting different grades
			int[] frequency = DatabaseConnector.showValues(conn);
			
			conn.close();
			//Calculating cumulative frequecy of grades
			int cumulativeFrequency = 0;
			for(int i=0; i<6;i++) {
				cumulativeFrequency+=frequency[i];	
			}
			probabilityOfevents =new double[6];
			//Calculating the probability of each letter grade
			for(int j=0;j<6;j++) {
				Double ans= ((double)frequency[j]/cumulativeFrequency);
				probabilityOfevents[j]=Double.parseDouble(String.format("%.4f",ans));
			}
			launch(args);
			
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	/**
	 * this method takes connection as parameter,performs query taken as string and uses showResults method to get the frequency array
	 * @param conn
	 * takes a connection object as parameter
	 * @return
	 * returns an array of frequency
	 */
	public static int[] showValues(Connection conn) {
		try {
			String str ="SELECT * FROM Student.Classes where courseID= 'CSC 22100' and semester= 'Spring' and year = '2020'";
			PreparedStatement stmt = conn.prepareStatement(str);
			ResultSet rset = stmt.executeQuery(str);
			
			return DatabaseConnector.showResults("Student", rset);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	/**
	 * this method creates a table from the resultSet and counts the number of Gpa and returns an array  of frequency
	 * @param tableName
	 * @param rSet
	 * @return
	 */
	public static int[] showResults(String tableName, ResultSet rSet) {
		try	{
			ResultSetMetaData rsmd = rSet.getMetaData();
			int numColumns = rsmd.getColumnCount();
			int[] gpaCounter = new int[6];
			Character[] gpa= new Character[6];
			gpa[0]='A';gpa[1]='B';gpa[2]='C';gpa[3]='D';gpa[4]='F';gpa[5]='W';
			for(int i=0;i<6;i++) gpaCounter[i]=0;
			
			String resultString = null;
			if (numColumns > 0) {
				resultString = "\nTable: " + tableName + "\n" +
				"=======================================================\n";
				for (int colNum = 1; colNum <= numColumns; colNum++)
					resultString += rsmd.getColumnLabel(colNum) + " ";
			}
			System.out.println(resultString);
			System.out.println("=======================================================");
			while (rSet.next()) {
				resultString = "";
				for (int colNum = 1; colNum <= numColumns; colNum++) {
					String column = rSet.getString(colNum);
					if (column != null) resultString += column + "     ";
				}
				System.out.println(resultString + '\n' +
				"------------------------------------------------------------");
				//Counting the number of letter grades by matching
				if(rSet.getString("GPA").equalsIgnoreCase("A"))	gpaCounter[0]++;
				else if(rSet.getString("GPA").equalsIgnoreCase("B")) gpaCounter[1]++;
				else if(rSet.getString("GPA").equalsIgnoreCase("C")) gpaCounter[2]++;
				else if(rSet.getString("GPA").equalsIgnoreCase("D")) gpaCounter[3]++;
				else if(rSet.getString("GPA").equalsIgnoreCase("F")) gpaCounter[4]++;
				else if(rSet.getString("GPA").equalsIgnoreCase("W")) gpaCounter[5]++;	
			}
			//Creating a table showing letter grades and their corresponding number
			System.out.println("");
			System.out.println("Letter Grades      Number of Students");
			System.out.println("=======================================================");
			for(int i=0;i<6;i++) {
				System.out.println("     "+gpa[i]+"                 "+gpaCounter[i]);
			}
			return gpaCounter;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	 public void start(Stage primaryStage) throws Exception {	
		Canvas cv = addCanvas(800,400,6 );
		
		// creating  pane 
		Pane p = new Pane();
		//adding the canvas to the pane
		p.getChildren().add(cv);
		int w = (int)cv.getWidth();
		int h = (int)cv.getHeight();
		//Creating a scene and showing the display
		Scene sc =new Scene(p,w,h,MyColor.WHITE.getColor());
		primaryStage.setScene(sc);
		primaryStage.setTitle("MyPieChart of GPA");
		primaryStage.show();
	}
	
	public Canvas addCanvas(int w, int h, int event) {
		Canvas cv= new Canvas(w,h); 
		GraphicsContext gc = cv.getGraphicsContext2D();
		//creating an object of MyPieChart and drawing the PieChart
		MyPieChart pie = new MyPieChart(event,this.probabilityOfevents);
		pie.draw(gc, w, h);

		return cv;
	}
	
}
