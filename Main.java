import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) throws IOException {
		final float scale = 10;
		final int circleSize = 20;
		JFrame frame  = new JFrame("DeminerSim");
		frame.setSize(500,500);
		JButton bAdd = new JButton("Add Data");
		final JTextField tx1 = new JTextField(4);
		final JTextField ty1 = new JTextField(4);
		final JTextField tx2 = new JTextField(4);
		final JTextField ty2 = new JTextField(4);
		final JLabel lx1 = new JLabel("x1:");
		final JLabel ly1 = new JLabel("y1:");
		final JLabel lx2 = new JLabel("x2:");
		final JLabel ly2 = new JLabel("y2:");
		final JPanel panel = new JPanel();
		panel.add(bAdd);
		panel.add(lx1);
		panel.add(tx1);
		panel.add(ly1);
		panel.add(ty1);
		panel.add(lx2);
		panel.add(tx2);
		panel.add(ly2);
		panel.add(ty2);
		frame.add(panel);
		frame.setVisible(true);
		final Modelling modelling = new Modelling();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				float x1, x2, y1, y2;
				x1 = Float.parseFloat(tx1.getText());
				x2 = Float.parseFloat(tx2.getText());
				y1 = Float.parseFloat(ty1.getText());
				y2 = Float.parseFloat(ty2.getText());
				Graphics g = panel.getGraphics();
				g.clearRect(0, 30, 500, 500);
				g.setColor(Color.RED);

				modelling.addNode(x1, y1, x2, y2);
				for(int i = 0 ; i < Modelling.number ; i++) {
					g.drawLine( (int) (modelling.data[i].getX1() * scale), (int) (modelling.data[i].getY1() * scale),  (int) (modelling.data[i].getX2() * scale), (int) (modelling.data[i].getY2() * scale));
					g.drawOval((int) (modelling.data[i].getX1() * scale) - circleSize / 2, (int) (modelling.data[i].getY1() * scale) - circleSize / 2, circleSize, circleSize);
				}

				modelling.processNodes();
				g.setColor(Color.BLUE);
				for(int i = 0 ; i < Modelling.number ; i++) {
					for (int j = 0 ; j < Modelling.number ; j++) {
						if (modelling.nodes[i][j] == true) {
							g.drawLine( (int) (modelling.data[i].getX2() * scale), (int) (modelling.data[i].getY2() * scale),  (int) (modelling.data[j].getX2() * scale), (int) (modelling.data[j].getY2() * scale));
							System.out.printf("(%d,%d): <%f %f %f %f>  ",i,j,modelling.data[i].getX2(),modelling.data[i].getY2(),modelling.data[j].getX2(),modelling.data[j].getY2());
						}
					}
				}
			}
		});
	}

}



