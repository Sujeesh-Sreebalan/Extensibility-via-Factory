package extensibilityViaFactory;

import java.util.ArrayList;
import java.util.List;

class Screen {
	private List<Shape> shapeList = new ArrayList<Shape>();
	
	/**
	 * 
	 * @param shape which is used to store the shape 
	 */
	public void addShape(Shape shape) {
		shapeList.add(shape);
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
	 * Delete all the shape from the list
	 */
	public void deleteAllShape() {
		shapeList.clear();
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
	 * 
	 * @return the shapeList array
	 */
	public List<Shape> getShapeList() {
		return shapeList;
	}
	
	/**
	 * Display the shape present in the list
	 */
	public void display() {
		for(int i=0; i<shapeList.size(); i++) {
			System.out.println(shapeList.get(i).getShape());
		}
	}
}
