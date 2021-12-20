import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TheGUI extends JPanel implements Runnable{

	Thread t;

	public TheGUI(){
		JButton button = new JButton("Sample");
		ActionListener actionListener = new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				System.out.println("I was selected.");
			}
		};
		button.addActionListener(actionListener);
		this.add(button, BorderLayout.SOUTH);
		t = new Thread(this, "Demo Thread");
	}

	public void run(){
		JFrame frame = new JFrame("Button Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(300, 100);
		frame.setVisible(true);
	}
}

public class GUIThreadSample{
	public static void main(final String args[]){
		//use final when accessing the command prompt
		TheGUI gu = new TheGUI();
		EventQueue.invokeLater(gu);
	}
}