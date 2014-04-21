package Flame;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import network.Client2;

public class FirstUI extends JFrame implements MouseInputListener{
	
	private JPanel contentPane;

	public static void main(String[] args) {
		new Client2();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstUI frame = new FirstUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FirstUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon main;
		JLabel lab1 = new JLabel("");
		main = new ImageIcon(getClass().getResource("/Teamimg/main1.png"));
		lab1.setIcon(main);
		lab1.setHorizontalAlignment(SwingConstants.CENTER);
		lab1.setBounds(12, 10, 800, 750);
		contentPane.add(lab1);
		
		lab1.addMouseListener(this);
}
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getYOnScreen() != 0){
			TeamProjectSelUI su = new TeamProjectSelUI();
			su.TeamProjectSelUI();
			dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		ImageIcon main;
		JLabel lab = new JLabel();
		lab = (JLabel)e.getComponent();
		
		if(e.getButton() == 1){
			main = new ImageIcon(getClass().getResource("/Teamimg/main2.png"));
			lab.setIcon(main);
			lab.setHorizontalAlignment(SwingConstants.CENTER);
			lab.setBounds(12, 10, 750, 700);
		}
		
		else if(e.getButton() == 2){		
			main = new ImageIcon(getClass().getResource("/Teamimg/case1.gif"));
			lab.setIcon(main);
			lab.setHorizontalAlignment(SwingConstants.CENTER);
			lab.setBounds(12, 10, 760, 710);
		}
		else if(e.getButton() == 3){
			main = new ImageIcon(getClass().getResource("/Teamimg/case2.gif"));
			lab.setIcon(main);
			lab.setHorizontalAlignment(SwingConstants.CENTER);
			lab.setBounds(12, 10, 760, 710);
		}		
	}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
}