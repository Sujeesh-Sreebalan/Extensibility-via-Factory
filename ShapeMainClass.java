package extensibilityViaFactory;

import java.util.ArrayList;
import java.util.Scanner;
import extensibilityViaFactory.Shape.ShapeType;

public class ShapeMainClass {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the x point: ");
		int x = sc.nextInt();
		System.out.print("\nEnter the y point: ");
		int y = sc.nextInt();
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(x, y), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		Thread.sleep(1000);
		
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(x, y), new ArrayList<Double>() {
			{
				add(2.0);
				add(3.0);
			}
		});
		screen.addShape(shape2);
		Thread.sleep(1000);
		
		Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(x, y), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		screen.addShape(shape3);
		Thread.sleep(1000);
		
		Shape shape4 = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(x, y), new ArrayList<Double>() {
			{
				add(8.0);
				add(9.0);
			}
		});
		screen.addShape(shape4);
		
		System.out.println("Shapes are:");
		screen.display();
		sc.close();

	}

}
