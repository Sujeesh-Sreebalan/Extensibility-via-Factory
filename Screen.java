package extensibilityViaFactory;

import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.List;

import extensibilityViaFactory.Shape.ShapeType;

class Screen {
	private List<Shape> shapeList = new ArrayList<Shape>();
//	private Map<Shape, Date> map = new HashMap<>();
	
	/**
	 * 
	 * @param shape which is used to store the shape 
	 */
	public void addShape(Shape shape) {
		shapeList.add(shape);
//		map.put(shape, new Date());
	}
	
	/**
	 * Function to delete particular shape from the list
	 * 
	 * @param shape the shape which is used to delete 
	 */
	public void deleteShape(Shape shape) {
		for(int i=0; i<shapeList.size(); i++) {
			if(shapeList.get(i) == shape) {
				shapeList.remove(i);
				break;
			}
		}
	}
	
	/**
	 * delete all shapes of same type
	 * 
	 * @param shapeType type of shape to be deleted
	 */
	public void deleteSameTypeShapes(ShapeType shapeType) {

		for (int i = 0; i < shapeList.size(); i++) {
			if (shapeList.get(i).getShape() == shapeType) {
				shapeList.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Function to store all the shape based on the area
	 * 
	 * @return the sorted list based on the area
	 */
	public List<Shape> sortByArea(){
		List<Shape> area = new ArrayList<>();
		area = shapeList;
		
		for(int i=0; i<area.size(); i++) {
			for(int j=0; j<area.size() - i -1; j++) {
				if(area.get(j).getArea() > area.get(j+1).getArea()) {
					Shape temp = area.get(j);
					area.set(j, area.get(j+1));
					area.set(j+1, temp);
				}
			}
		}
		return area;
	}
	
	/**
	 * Function to store all the shape based on the perimeter
	 * 
	 * @return the sorted list based on the perimeter
	 */
	public List<Shape> sortByPerimeter(){
		List<Shape> perimeter = new ArrayList<>();
		perimeter = shapeList; 
		
		for(int i=0; i<perimeter.size(); i++) {
			for(int j=0; j<perimeter.size() - i -1; j++) {
				if(perimeter.get(j).getPerimeter() > perimeter.get(j+1).getPerimeter()) {
					Shape temp = perimeter.get(j);
					perimeter.set(j, perimeter.get(j+1));
					perimeter.set(j+1, temp);
				}
			}
		}
		return perimeter;
	}
	
	/**
	 * Function to store all the shape based on the distance from the origin
	 * 
	 * @return the sorted list based on the origin	
	 */
	public List<Shape> sortByOrigin(){
		List<Shape> origin = new ArrayList<>();
		origin = shapeList;
		
		for(int i=0; i<origin.size(); i++) {
			for(int j=0; j<origin.size()-i-1; j++) {
				double base1 = origin.get(j).getOrigin().getX();
				double height1 = origin.get(j).getOrigin().getY();
				double base2 = origin.get(j+1).getOrigin().getX();
				double height2 = origin.get(j+1).getOrigin().getY();
				
				double hypo1 = Math.sqrt(Math.pow(base1, 2) + Math.pow(height1, 2));
				double hypo2 = Math.sqrt(Math.pow(base2, 2) + Math.pow(height2, 2));
				if(hypo1 > hypo2) {
					Shape temp = origin.get(j);
					origin.set(j, origin.get(j+1));
					origin.set(j+1, temp);
				}
			}
		}
		return origin;
	}
	
	/**
	 * 
	 * @return the shapeList array
	 */
	public List<Shape> getShapeList() {
		return shapeList;
	}
	
	/**
	 * Display the shape present in the list and the time when it is created
	 */
	public void display() {
		for(int i =0; i<shapeList.size(); i++) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(shapeList.get(i).getShape()+" "+formatter.format(shapeList.get(i).getDate()));
		}
	}
}
