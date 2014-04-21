package Flame;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import network.Client1;
import network.Client2;
import db.detail;
import db.handphone;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deview extends JFrame {
	public deview() {
	}

	private JPanel contentPane;
	private JTextField pName;
	private JLabel finalImg;
	String[] pic = new String[4];
	int cnt=0;
	String name, view;
	public void view(String phone) throws UnknownHostException, IOException {
		handphone  a = detail.getdb(phone);
		name = a.getName();
		view = a.getView();
		pic = detail.pic(phone);
		Client1.pic(pic[0],0);
		if(pic[1] != null){
			Client1.pic(pic[1],1);
		}
		if(pic[2] != null){
			Client1.pic(pic[2],2);
		}
		if(pic[3] != null){
			Client1.pic(pic[3],3);
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pName = new JTextField();
		pName.setBounds(374, 10, 298, 21);
		contentPane.add(pName);
		pName.setColumns(10);
		pName.setText(name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(374, 41, 298, 611);
		contentPane.add(scrollPane);
		
		JTextArea pInfo = new JTextArea();
		pInfo.setText(view);
		scrollPane.setViewportView(pInfo);		
		
		finalImg = new JLabel();
		finalImg.setIcon(new ImageIcon("./download0.jpg"));
		finalImg.setHorizontalAlignment(SwingConstants.CENTER);
		finalImg.setBounds(12, 10, 350, 560);
		contentPane.add(finalImg);
		
		ImageIcon b1, b2, b3, b4;
		
		JButton bcol1 = new JButton();
		b1 = new ImageIcon(getClass().getResource("/Teamimg/1.png"));
		bcol1.setHorizontalAlignment(SwingConstants.CENTER);
		bcol1.setIcon(b1);
		bcol1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				finalImg.setIcon(new ImageIcon("./download0.jpg"));
			}
		});
		bcol1.setBounds(40, 580, 35, 35);
		contentPane.add(bcol1);
		
		if(pic[1] !=null){
		JButton bcol2 = new JButton();
		b2 = new ImageIcon(getClass().getResource("/Teamimg/2.png"));
		bcol2.setHorizontalAlignment(SwingConstants.CENTER);
		bcol2.setIcon(b2);
		bcol2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalImg.setIcon(new ImageIcon("./download1.jpg"));
			}
		});
		bcol2.setBounds(120, 580, 35, 35);
		contentPane.add(bcol2);
		}
		
		if(pic[2] != null){
		JButton bcol3 = new JButton();
		b3 = new ImageIcon(getClass().getResource("/Teamimg/3.png"));
		bcol3.setHorizontalAlignment(SwingConstants.CENTER);
		bcol3.setIcon(b3);
		bcol3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalImg.setIcon(new ImageIcon("./download2.jpg"));
				}
		});
		bcol3.setBounds(200, 580, 35, 35);
		contentPane.add(bcol3);
		}

		if(pic[3] != null){
		JButton bcol4 = new JButton();
		b4 = new ImageIcon(getClass().getResource("/Teamimg/4.png"));
		bcol4.setHorizontalAlignment(SwingConstants.CENTER);
		bcol4.setIcon(b4);
		bcol4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalImg.setIcon(new ImageIcon("./download3.jpg"));
			}
		});
		bcol4.setBounds(280, 580, 35, 35);
		contentPane.add(bcol4);
		}
	}
}
