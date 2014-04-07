package Flame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class LoadingUI extends JFrame {
	public LoadingUI() {
	}

	private JPanel contentPane;
	Thread th = new Thread();
	
	public void WifiUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel wifi = new JLabel("");
		wifi.setHorizontalAlignment(SwingConstants.CENTER);
		wifi.setIcon(new ImageIcon(getClass().getResource("/Teamimg/wifi.gif"))); //
		wifi.setBounds(12, 10, 460, 392);
		contentPane.add(wifi);
		
	}		
}

