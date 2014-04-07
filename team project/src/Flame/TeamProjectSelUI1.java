package Flame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class TeamProjectSelUI1 extends JFrame implements ActionListener {
	String tel;
	public TeamProjectSelUI1() {
	}
	/*public TeamProjectSelUI1() {
	}*/

	private JPanel contentPane;

	public void SelUI1(String tel) {
		this.tel = tel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon and, io;
		JButton android = new JButton("android");
		and = new ImageIcon(getClass().getResource("/Teamimg/안드로이드.png"));
		android.setIcon(and);
		android.setBounds(12, 10, 210, 260);
		contentPane.add(android);
		
		JButton ios = new JButton("IOS");
		io = new ImageIcon(getClass().getResource("/Teamimg/IOS.png"));
		ios.setIcon(io);
		ios.setBounds(262, 10, 210, 260);
		contentPane.add(ios);
		
		JLabel ostitle = new JLabel("운영체제를 선택하세요");
		ostitle.setHorizontalAlignment(SwingConstants.CENTER);
		ostitle.setFont(new Font("굴림", Font.BOLD, 30));
		ostitle.setBounds(12, 312, 460, 90);
		contentPane.add(ostitle);
		
		android.addActionListener(this);
		ios.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TeamProjectSelUI2 UI2 = new TeamProjectSelUI2();
		UI2.SelUI2(tel, e.getActionCommand());
		dispose();
	}
}
