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


public class TeamProjectSelUI2 extends JFrame implements ActionListener, MouseListener {
	String tel;
	String os;
	public TeamProjectSelUI2() {
	}

	private JPanel contentPane;
	private JButton b1;
	
	public void SelUI2(String tel, String os) {
		this.tel=tel;
		this.os=os;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 600);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon two;
		JLabel twog = new JLabel();		
		twog.setName("2g");
		if(os.equals("android")){
			two = new ImageIcon(getClass().getResource("/Teamimg/폴더폰.png"));
			twog.setHorizontalAlignment(SwingConstants.CENTER);
			twog.setIcon(two);
			twog.setBounds(12, 20, 190, 380);
			twog.setBorder(BorderFactory.createLineBorder(Color.black));
			contentPane.add(twog);
			twog.addMouseListener(this);
		}
		if(os.equals("ios")){
			two = new ImageIcon(getClass().getResource("/Teamimg/IOS1.png"));
			twog.setHorizontalAlignment(SwingConstants.CENTER);
			twog.setIcon(two);
			twog.setBounds(12, 20, 190, 380);
			twog.setBorder(BorderFactory.createLineBorder(Color.black));
			contentPane.add(twog);
		}
		
		ImageIcon three, four;
		JLabel threeg = new JLabel();
		three = new ImageIcon(getClass().getResource("/Teamimg/3g.png"));
		threeg.setHorizontalAlignment(SwingConstants.CENTER);
		threeg.setIcon(three);
		threeg.setBounds(222, 20, 190, 380);
		threeg.setName("3g");
		threeg.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(threeg);
		
		JLabel fourg = new JLabel();
		four = new ImageIcon(getClass().getResource("/Teamimg/4g.png"));
		fourg.setHorizontalAlignment(SwingConstants.CENTER);
		fourg.setIcon(four);
		fourg.setBounds(432, 20, 190, 380);
		fourg.setName("4g");
		fourg.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(fourg);
		
		JLabel label1 = new JLabel("선택하세요");
		label1.setFont(new Font("굴림", Font.BOLD, 30));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(12, 412, 610, 90);
		label1.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(label1);
		
		b1 = new JButton("이전");
		b1.setBounds(12,510,610,45);
		contentPane.add(b1);
		
		threeg.addMouseListener(this);
		fourg.addMouseListener(this);
		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TeamProjectSelUI1 sui1 = new TeamProjectSelUI1();
		sui1.SelUI1(String.valueOf(e.getSource()));
		dispose();	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		UIList ul = new UIList();
		JLabel l = (JLabel) e.getSource();
		if(l.getName().equals("2g")){
			ul.ListUI(tel, os, l.getName());
			dispose();
		}
		else if(l.getName().equals("3g")){
			ul.ListUI(tel, os, l.getName());
			dispose();
		}
		else if(l.getName().equals("4g")){
			ul.ListUI(tel, os, l.getName());
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
