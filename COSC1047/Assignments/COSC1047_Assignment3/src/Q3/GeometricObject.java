/**
 * 
 */
package Q3;

/**
 * @author jtikiwala
 *
 */
class GeometricObject
{
    public void area()
    {
        System.out.println("The formula for area of :");
    }
    public void perimeter()
    {
        System.out.println("The formula for perimeter of :");
    }
}

class Triangle extends GeometricObject
{
    public void area()
    {
        System.out.println("Triangle is ½ * base * height");
    }
    public void perimeter()
    {
        System.out.println("Triangle is sum of three sides");
    }
}

class Rectangle extends GeometricObject
{
    public void area()
    {
        System.out.println("Rectangle is length * breadth");
    }
    public void perimeter()
    {
        System.out.println("Rectangle is 2 *(length + breadth)");
    }
}

class Circle extends GeometricObject
{
    public void area()
    {
        System.out.println("Circle is 3.14 * radius * radius");
    }
    public void perimeter()
    {
        System.out.println("Circle is 2 * 3.14 * radius");
    }
}

