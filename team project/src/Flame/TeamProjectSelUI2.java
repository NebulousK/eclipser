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


public class TeamProjectSelUI2 extends JFrame implements ActionListener {
	String tel;
	String os;
	public TeamProjectSelUI2() {
	}

	private JPanel contentPane;

	public void SelUI2(String tel, String os) {
		this.tel=tel;
		this.os=os;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon two, three, four;
		JButton twog = new JButton("2g");
		two = new ImageIcon(getClass().getResource("/Teamimg/폴더폰.png"));
		twog.setIcon(two);
		twog.setBounds(12, 10, 134, 258);
		contentPane.add(twog);
		
		JButton threeg = new JButton("3g");
		three = new ImageIcon(getClass().getResource("/Teamimg/3g.png"));
		threeg.setIcon(three);
		threeg.setBounds(174, 10, 134, 258);
		contentPane.add(threeg);
		
		JButton fourg = new JButton("4g");
		four = new ImageIcon(getClass().getResource("/Teamimg/4g.png"));
		fourg.setIcon(four);
		fourg.setBounds(338, 10, 134, 258);
		contentPane.add(fourg);
		
		JLabel label1 = new JLabel("선택하세요");
		label1.setFont(new Font("굴림", Font.BOLD, 30));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(12, 312, 460, 90);
		contentPane.add(label1);
		
		twog.addActionListener(this);
		threeg.addActionListener(this);
		fourg.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UIList UL = new UIList();
		UL.ListUI(tel, os, e.getActionCommand());
		dispose();
	}
}
