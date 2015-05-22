
public class Modelling {
	
	public Data [] data = new Data[100];
	public boolean [][] nodes = new boolean[100][100];
	public static int number = 0;
	public Modelling(){
		for (int i = 0; i < 100 ; i++) {
			data[i] = new Data();
		}
	}
	public void addNode(float x1, float y1, float x2, float y2) {
		System.out.print("salam");
		data[number].setNumber(number);
		data[number].setX1(x1);
		data[number].setY1(y1);
		data[number].setX2(x2);
		data[number].setY2(y2);
		number++;
	}
	public void processNodes() {
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				nodes[i][j] = getConflict(data[i], data[j]);
				System.out.print(getConflict(data[i], data[j]));
			}
		}
	}
	public boolean getConflict(Data node1, Data node2){
		float m1, m2;
		m1 = (node1.getY1() - node1.getY2()) / (node1.getX1() - node1.getX2());
		m2 = (node2.getY1() - node2.getY2()) / (node2.getX1() - node2.getX2());
		if ( (((node1.getY1() - node2.getY1()) > m2 * (node1.getX1() - node2.getX1())) && ((node1.getY2() - node2.getY1()) < m2 * (node1.getX2() - node2.getX1())) ) || (((node1.getY2() - node2.getY1()) < m2 * (node1.getX2() - node2.getX1())) && ((node1.getY1() - node2.getY1()) > m2 * (node1.getX1() - node2.getX1())) ) ){
			if ( (((node2.getY1() - node1.getY1()) > m1 * (node2.getX1() - node1.getX1())) && ((node2.getY2() - node1.getY1()) < m1 * (node2.getX2() - node1.getX1())) ) || (((node2.getY2() - node1.getY1()) < m1 * (node2.getX2() - node1.getX1())) && ((node2.getY1() - node1.getY1()) > m1 * (node2.getX1() - node1.getX1())) ) ){
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return true;
		}
	}

}
