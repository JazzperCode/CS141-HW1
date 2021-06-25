class Shape 
{
	String name;
	Shape(String newName) { 
		name = newName;
	}
	double area() 
	{ 
		return 0.0;
	} 
	void draw() 
	{
		System.out.println("Shape.draw() You should never see this.");  
	}
}

class Triangle extends Shape
{
	int myHeight,myBase;
	Triangle(String name, int h, int b) 
	{ 
		super(name);
		myHeight = h;
		myBase = b; 
	} 
	double area() 
	{
		return (.5 * myBase * myHeight);
	} 
	void draw() 
	{
        String visual = ""; 
		for(int i = 0; i<5;i++) 
		{
			visual = visual + "*"; 
			System.out.println(visual);
		}
	}
 	public String toString() { 
		return (this.name + "(" + myHeight + ", " + myBase + ")");
	} 
} 

class Circle extends Shape 
{
	int myRadius; 
	Circle(String name, int r)
	{
		super(name);
		myRadius = r; 
	}
	double area() 
	{
		return (Math.PI * Math.pow(myRadius,2));
	}
	void draw() { 
		System.out.println("  * * * *  ");
		for(int i = 0; i<4; i++) 
		{
			System.out.println("* * * * * *");
		}
		System.out.println("  * * * *  ");
	} 
	public String toString() { 
		return (this.name + "(" + myRadius + ")");
	} 
}

class Square extends Shape 
{
	int myHeight; 
	Square(String name, int h)
	{
		super(name);
		myHeight = h;
	}
	double area() 
	{ 
		return Math.pow(myHeight,2); 
	}
	void draw() 
	{ 
		String side = "* * * * * *";
		for(int i = 0; i<5; i++) 
		{
			System.out.println(side);
		}
	}
	public String toString() { 
		return (this.name + "(" + myHeight + ")");
	} 
}

class Rectangle extends Square
{
	int myWidth; 
	Rectangle(String name, int h, int w) 
	{
		super(name,h);
		myWidth = w;
	}
	double area() 
	{
		return myHeight * myWidth;
	}
	void draw() {
		String side = "* * * * * *";
		for(int i = 0; i<3; i++)
		{
			System.out.println(side);
		}
	}
	public String toString() { 
		return (this.name + "(" + myHeight + ", " + myWidth + ")");
	} 
}

class Picture
{
	ListNode head; 
	class ListNode 
	{
		Shape sh;
		ListNode next; 
		ListNode(Shape newSh, ListNode newNext) 
		{
			sh = newSh; 
			next = newNext;
		}
	}
	void add(Shape sh)
	{
		head = new ListNode(sh,head);
	}
	void drawAll() 
	{
		ListNode current = head; 
		while(current!=null) 
		{
			current.sh.draw();
			System.out.println("---------------------------------");
			current = current.next;
		}
	}
	double totalArea()
	{
		double total = 0;
		ListNode current = head; 
		while(current!=null) 
		{
			total = total + current.sh.area();
			current = current.next;
		}
		return total;
	}
	void printShapes()
	{
		ListNode current = head; 
		while(current!=null) 
		{
			System.out.println(current.sh.toString() + ": " + current.sh.area());
			current=current.next;
		}
	}
}

public class mainClass
{
    static void println(double d)
    {
		System.out.println("Double d is " + d);
    }
    public static void main(String[] args)
    {
        Picture p = new Picture();
        p.add(new Triangle("FirstTriangle", 7, 3));
        p.add(new Triangle("SecondTriangle", 6, 2));
        p.add(new Circle("FirstCircle", 7));
       	p.add(new Circle("SecondCircle", 6));
       	p.add(new Square("FirstSquare", 7));
       	p.add(new Square("SecondSquare", 6));
       	p.add(new Rectangle("FirstRectangle", 7,3));
       	p.add(new Rectangle("SecondRectangle", 6,2));

        p.printShapes(); // this could print out the first output shown below, for your benefit
        System.out.println("Total : " + p.totalArea());
        println(p.totalArea());
        p.drawAll();
    }
}



