package Flame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class TeamProjectSelUI1 extends JFrame implements ActionListener, MouseListener {
	String tel;
	public TeamProjectSelUI1() {
	}
	/*public TeamProjectSelUI1() {
	}*/

	private JPanel contentPane;
	private JButton b1;

	public void SelUI1(String tel) {
		this.tel = tel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 600);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon and, io;
		JLabel android = new JLabel();
		and = new ImageIcon(getClass().getResource("/Teamimg/안드로이드.png"));
		android.setHorizontalAlignment(SwingConstants.CENTER);
		android.setIcon(and);
		android.setBounds(12, 10, 270, 380);
		android.setName("android");
		android.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(android);
		
		JLabel ios = new JLabel();
		io = new ImageIcon(getClass().getResource("/Teamimg/IOS.png"));
		ios.setHorizontalAlignment(SwingConstants.CENTER);
		ios.setIcon(io);
		ios.setBounds(350, 10, 270, 380);
		ios.setName("ios");
		ios.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(ios);
		
		JLabel ostitle = new JLabel("운영체제를 선택하세요");
		ostitle.setHorizontalAlignment(SwingConstants.CENTER);
		ostitle.setFont(new Font("굴림", Font.BOLD, 30));
		ostitle.setBounds(12, 412, 610, 90);
		ostitle.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(ostitle);
		
		b1 = new JButton("이전");
		b1.setBounds(12,510,610,45);
		contentPane.add(b1);
		
		android.addMouseListener(this);
		ios.addMouseListener(this);
		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TeamProjectSelUI sui = new TeamProjectSelUI();
		sui.TeamProjectSelUI();
		dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TeamProjectSelUI2 ui2 = new TeamProjectSelUI2();
		JLabel l = (JLabel) e.getSource();
		if(l.getName().equals("android")){
			ui2.SelUI2(tel, l.getName());
			dispose();
		}
		else if(l.getName().equals("ios")){
			ui2.SelUI2(tel, l.getName());
			dispose();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}

}
