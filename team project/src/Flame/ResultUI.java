package Flame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import db.handphone;
import db.view;


public class ResultUI extends JFrame {
	public ResultUI() {
	}

	private JPanel contentPane;
   
	public void FinalUI(String tel, String os, String broad, String color, String dis, double mem, double cpu, int camera, int bettery) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		setVisible(true);
		
		view g = new view();
		ArrayList<handphone> datas = g.view(tel, os, broad, color, dis, mem, cpu, camera, bettery);
		String as = null;
		for(handphone handphone:datas){
			as = handphone.getName();
			}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("해당하는 핸드폰 이미지");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 196, 392);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(as);
		textArea.setBounds(220, 10, 252, 392);
		contentPane.add(textArea);
	}
}
