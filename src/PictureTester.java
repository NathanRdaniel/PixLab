/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testNegate(){
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
    }
  public static void testGrayscale(){
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.greyScale();
    beach.explore();
  }
  public static void testFixUnderwater(){
    Picture water = new Picture("water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }
  public static void testMirrorVerticalRTL(){
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRTL();
    caterpillar.explore();
  }

  public static void testMirrorHoizontal(){
    Picture bike = new Picture("redMotorcycle.jpg");
    bike.explore();
    bike.mirrorHorizontal();
    bike.explore();
  }
  public static void testMirrorHoizontalBTT(){
    Picture bike = new Picture("redMotorcycle.jpg");
    bike.explore();
    bike.mirrorHorizontalBTT();
    bike.explore();
  }
public static void testMirrorAngle(){
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorAngle();
    beach.explore();
  }
  public static void testMirrorSelect(){
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorSelect();
    temple.explore();
  }
  public static void testMirrorArms(){
    Picture snow = new Picture("snowman.jpg");
    snow.explore();
    snow.mirrorArms();
    snow.explore();
  }
  public static void testMirrorGull(){
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }
  public static void testMyCollage(){
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("beach.jpg");
    swan.edgeDetection(15);
    swan.explore();
  }
  public static void main(String[] args)
  {
   
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    // testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRTL();
    //testMirrorHoizontal();
    //testMirrorHoizontalBTT();
    //testMirrorAngle();
    //testMirrorSelect();
    //testMirrorTemple();
   // testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testMyCollage();
    //testCopy();
    //testEdgeDetection();
    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}