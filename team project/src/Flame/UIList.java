package Flame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class UIList extends JFrame implements ActionListener{
	String tel;
	String os;
	String broad;
	String dis;
	String price;
	String camera;
	String bettery;
	JComboBox com1 = new JComboBox();
	JComboBox com2 = new JComboBox();
	JComboBox com3 = new JComboBox();
	JComboBox com4 = new JComboBox();
	JButton ok;
	JButton can;
	
	public UIList() {
	}

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamProjectSelUI frame = new TeamProjectSelUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ListUI(String tel, String os, String broad)  {
		this.tel = tel;
		this.os = os;
		this.broad = broad;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 600);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 버튼 생성
		ok = new JButton("확인");
		ok.setBounds(12, 510, 280, 45);
		contentPane.add(ok);
		
		can = new JButton("취소");
		can.setBounds(340, 510, 280, 45);
		contentPane.add(can);
		// 버튼 끝
	
		// 이미지 레이블
		JLabel labimg = new JLabel();

		ImageIcon sk, kt, lg;
		
		if(tel == "skt"){
		sk = new ImageIcon(getClass().getResource("/Teamimg/skt.png"));
		labimg.setIcon(sk);
		}
		else if(tel == "kt"){
		kt = new ImageIcon(getClass().getResource("/Teamimg/olleg KT.png"));
		labimg.setIcon(kt);
		}
		else if(tel == "lgt"){
		lg = new ImageIcon(getClass().getResource("/Teamimg/lg u+.png"));
		labimg.setIcon(lg);
		}
		
		labimg.setHorizontalAlignment(SwingConstants.CENTER);
		labimg.setBounds(12, 10, 317, 414);
		labimg.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(labimg);
		// 이미지 레이블 끝
		
		//디스플레이
		JLabel lab1 = new JLabel("디스플레이");
		lab1.setBounds(350, 120, 81, 15);
		contentPane.add(lab1);
	
		com1.setBounds(350, 160, 106, 21);
		contentPane.add(com1);
		com1.setModel(new DefaultComboBoxModel(new String[] {"선택","105미만", "150~130","130~150","150~170"}));
		//디스플레이 끝
		
		//가격
		JLabel lab2 = new JLabel("가격");
		lab2.setBounds(500, 120, 57, 15);
		contentPane.add(lab2);
		
		com2.setBounds(500, 160, 106, 21);
		contentPane.add(com2);
		com2.setModel(new DefaultComboBoxModel(new String[] {"선택","400,000 이하" , "500,000 이하", "600,000 이하", "700,000 이하", "800,000 이하" , "900,000 이하" ,"1,000,000 이하" }));
		//가격끝
		
		//카메라 화소
		JLabel lab3 = new JLabel("카메라화소");
		lab3.setBounds(350, 190, 73, 15);
		contentPane.add(lab3);
	
		com3.setBounds(350, 230, 106, 21);
		contentPane.add(com3);
		com3.setModel(new DefaultComboBoxModel(new String[] {"선택","200 이상", "200 ~ 300","300 ~ 400","500 이상"}));
		//카메라 화소 끝
		
		//배터리 용량
		JLabel lab4 = new JLabel("배터리 용량");
		lab4.setBounds(500, 190, 73, 15);
		contentPane.add(lab4);
		
		com4.setBounds(500, 230, 106, 21);
		contentPane.add(com4);
		com4.setModel(new DefaultComboBoxModel(new String[] {"선택","500 ~ 1000", "1000 ~ 1500", "1500이상"}));
		//배터리 용량 끝
		
		ok.addActionListener(this);
		can.addActionListener(this);
	}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("확인")){
				if( com1.getSelectedItem().equals("선택") || com2.getSelectedItem().equals("선택") || com3.getSelectedItem().equals("선택") || com4.getSelectedItem().equals("선택"))
				{ JOptionPane.showMessageDialog(this, "다시입력하세요"); }
				else{
					this.dis = (String) com1.getSelectedItem();
					this.price =  (String) com2.getSelectedItem();
					this.camera =  (String) com3.getSelectedItem();
					this.bettery =  (String) com4.getSelectedItem();
				//System.out.println(color +" "+ dis +" "+ mem +" "+ cpu +" "+ camera +" "+ bettery);	
				final ResultUI lui = new ResultUI();
				final LoadingUI g = new LoadingUI();
				new Thread() {   				
		               public void run() {   
		                   for (int i = 0; i < 3; i++) {   
		                       try {   
		                           Thread.sleep(10000);   
		                       } catch (InterruptedException e) {   
		                       }   
		                   	g.dispose();
		                   }
		                   
		               }   
		        }.start();
		        lui.FinalUI(this.tel, this.os, this.broad, dis, camera, bettery, price);
		        dispose();
		        g.WifiUI();
				}
			}
			else if(e.getActionCommand().equals("취소")){
				TeamProjectSelUI sui = new TeamProjectSelUI();
				sui.TeamProjectSelUI();
				dispose();
			}
			
	}
}
