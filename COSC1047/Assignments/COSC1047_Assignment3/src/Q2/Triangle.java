/**
 * 
 */
package Q2;

/**
 * @author jtikiwala
 *
 */
public class Triangle extends GeometricObject {
	double s1,s2,s3,perimeter,p,pd,area;
	
	  Triangle()
	   {
	   setSide1(1.0);
	   setSide2(1.0);
	   setSide3(1.0);
	 
	   }
	    Triangle(double s1,double s2,double s3)
	   {
	   setSide1(s1);
	   setSide2(s2);
	   setSide3(s3);
	 
	   }
	 
	      double getArea()
	      {
	      p=getPerimeter()/2;
	      pd=p*(p-s1)*(p-s2)*(p-s3);
	      area=Math.sqrt(pd);
	         return (area);
	      }
	      double getPerimeter()
	      {
	      s1=getSide1();
	      s2=getSide2();
	      s3=getSide3();
	      perimeter=s1+s2+s3;
	      return (s1+s2+s3);
	      }

}
