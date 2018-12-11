import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.awt.Color;
/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}
	public void keepOnlyBlue(){
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}
	public void negate(){
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());
			}
		}
	}

	public void greyScale(){
		
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int total = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue());
				int average = total / 3;
				pixelObj.setRed(average);
				pixelObj.setGreen(average);
				pixelObj.setBlue(average);
			}
		}
	}

	public void fixUnderwater(){
	Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setGreen((pixelObj.getGreen())/3);
				pixelObj.setBlue((pixelObj.getBlue())/2);
				//pixelObj.setRed((pixelObj.getBlue())/2);	
			}
		}
	}
	public void mirrorVerticalRTL() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int colin = 0;
		int leng = pixels.length;
		int width = pixels[0].length;
		for (int row = 0; row < leng/2; row++) {
			for (int col = 0; col < width; col++) {
				topPixel = pixels [row] [col];
				bottomPixel = pixels [leng - 1 - row] [col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}
	public void mirrorHorizontalBTT() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int colin = 0;
		int leng = pixels.length;
		int width = pixels[0].length;
		for (int row = 0; row < leng/2; row++) {
			for (int col = 0; col < width; col++) {
				topPixel = pixels [row] [col];
				bottomPixel = pixels [leng - 1 - row] [col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}
	public void mirrorAngle() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = getWidth(); 
    	int height = getHeight();
		if (width > height){
	  width = height;
		}
		else if (height > width){
	  height = width;
		}
	int lastX = width - 1; 
    int maxX = lastX;
    int lastY = height - 1; 
	
	for (int y = 0; y < lastY; y++,maxX--)
    {
      // loop through the columns
      for (int x = 0; x < lastX; x++)
      {	
        leftPixel = getPixel(x,y);
        rightPixel = getPixel((lastX - y), (lastY - x));
		rightPixel.setColor(leftPixel.getColor());
	
      }
    }
}
public void mirrorSelect(){
  int mirrorPoint = 276;
  Pixel leftPixel = null;
  Pixel rightPixel = null;
  int count = 0;
  Pixel[][] pixels = this.getPixels2D();
  for (int row = 27; row < 97; row++){ 

	for (int col = 13; col < mirrorPoint; col++){
	  leftPixel = pixels[row][col];
	  rightPixel = pixels[row]
					   [mirrorPoint - col + mirrorPoint];
	  rightPixel.setColor(leftPixel.getColor()); 
	}
	count++;
  }
  System.out.println(count);
  
}
public void mirrorArms(){
	int mirrorPoint = 195;
	Pixel rightPixel = null;
	Pixel leftPixel = null;
	int count = 0;
	Pixel[][] pixels = this.getPixels2D();
	for (int row = 157; row < 235.; row++){ 
  
	  for (int col = 102; col < 293; col++){
		leftPixel = pixels[row][col];
	  rightPixel = pixels[mirrorPoint - row + mirrorPoint]
					   [col];
	  rightPixel.setColor(leftPixel.getColor()); 
	  }
	  count++;
	}
	System.out.println(count);
	
  }
  public void mirrorGull(){
	int mirrorPoint = 345;
	Pixel rightPixel = null;
	Pixel leftPixel = null;
	int count = 0;
	Pixel[][] pixels = this.getPixels2D();
	for (int row = 235; row < 325.; row++){ 
  
	  for (int col = 237; col < 345; col++){
		leftPixel = pixels[row][col];
	  rightPixel = pixels[ row ]
					   [mirrorPoint - col + mirrorPoint];
	  rightPixel.setColor(leftPixel.getColor()); 
	  }
	  count++;
	}
	System.out.println(count);
	
  }
  public void createCollage() {
    Picture flower1 = new Picture("flower1.jpg");
	Picture flower2 = new Picture("flower2.jpg");
	
    //this.copy(flower1,0,0);
	this.copySelect(flower2,20, 77, 20, 95);
	this.mirrorHorizontal();
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
	flowerNoBlue.zeroBlue();
	
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
	this.mirrorVertical();
	this.write("collage.jpg");
  } 
  public void myCollage(){
	  Picture snowman = new Picture("snowman.jpg");
	  Picture robot = new Picture("robot.jpg");
	  Picture flower = new Picture("flower1.jpg");
	  Picture snowNoBlue = new Picture(snowman);
	  robot.keepOnlyBlue();
	  this.copySelect(robot, 0, 72, 0,20); 
	  this.copySelect(flower, 20, 95, 20, 95);
	  this.mirrorVertical();
	  this.mirrorAngle();
	  
	  snowNoBlue.zeroBlue();
	  this.copy(snowNoBlue, 100, 100);

  }
  
  




	
	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}
	

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}
	public void copySelect(Picture fromPic, int startRow, int endRow, int startCol, int endCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < endRow
				&& toRow < endRow; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < endCol
					&& toCol < endCol; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		Color bottomColor = null;
		
		/*for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist){
					leftPixel.setColor(Color.BLACK);
				}else{
					leftPixel.setColor(Color.WHITE);
				}
			}

		}*/
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[row + 1][col];
				bottomColor = bottomPixel.getColor();
				if(topPixel.colorDistance(bottomColor) > edgeDist){
					topPixel.setColor(Color.BLACK);
				}else{
					topPixel.setColor(Color.WHITE);
				}
			}
		}
	}
	public void edgeDetection2(int edgeDist){
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color bottomColor = null;
		int topAverage = 0;
		int bottomAverage = 0;
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[row + 1][col];
				bottomColor = bottomPixel.getColor();
				topAverage = topPixel.getRed() + topPixel.getGreen() + topPixel.getBlue();
				bottomAverage = bottomPixel.getRed() + bottomPixel.getGreen() + bottomPixel.getBlue();
				if((topAverage  - bottomAverage) > edgeDist){
					topPixel.setColor(Color.WHITE);
				}else{
					topPixel.setColor(Color.BLACK);
				}
			}
		}
	}


	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.keepOnlyBlue();
		beach.explore();
		beach.negate();
	}

} // this } is the end of class Picture, put all new methods before this
