import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame {

	public Gui() {
		JButton button = new JButton();
		button.setText("Hi");
		add(button);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);
		button.addMouseListener(new MouseAdapter() {

			Detector detector;
			Thread thrd;

			@Override
			public void mouseClicked(MouseEvent e) {

				detector = new Detector();
				
				
				thrd = new Thread(detector);

				thrd.run();

				try {
					thrd.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
	}

	public static void main(String[] args) {
		Gui gui = new Gui();

	}

}
