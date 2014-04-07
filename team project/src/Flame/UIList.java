package Flame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class UIList extends JFrame implements ActionListener{
	String tel;
	String os;
	String broad;
	String color;
	String dis;
	double mem;
	double cpu;
	int camera;
	int bettery;
	JComboBox com4 = new JComboBox();
	JComboBox com1 = new JComboBox();
	JComboBox comboBox = new JComboBox();
	JComboBox com2 = new JComboBox();
	JButton ok = new JButton("확인");
	JComboBox com3 = new JComboBox();
	JComboBox com5 = new JComboBox();
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
		setBounds(100, 100, 664, 411);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		comboBox.setBounds(47, 186, 106, 21);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"선탯","white", "red", "black", "silver","gray"}));
		
		
		ok.setBounds(182, 320, 97, 23);
		contentPane.add(ok);
		
		JButton can = new JButton("취소");
		can.setBounds(317, 320, 97, 23);
		contentPane.add(can);
		
		JLabel label = new JLabel("\uC0C9\uC0C1");
		label.setBounds(47, 161, 57, 15);
		contentPane.add(label);
		
		JLabel lab1 = new JLabel("CPU");
		lab1.setBounds(439, 161, 57, 15);
		contentPane.add(lab1);
		
		
		com1.setBounds(439, 186, 106, 21);
		contentPane.add(com1);
		com1.setModel(new DefaultComboBoxModel(new String[] {"선택","1", "2", "3"}));
		
		JLabel lblNewLabel = new JLabel();
		ImageIcon sk, kt, lg;
		if(tel == "sk"){
		sk = new ImageIcon(getClass().getResource("/Teamimg/skt.png"));
		lblNewLabel.setIcon(sk);
		}
		else if(tel == "kt"){
		kt = new ImageIcon(getClass().getResource("/Teamimg/olleg KT.png"));
		lblNewLabel.setIcon(kt);
		}
		else if(tel == "lg"){
		lg = new ImageIcon(getClass().getResource("/Teamimg/lg u+.png"));
		lblNewLabel.setIcon(lg);
		}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 288, 119);
		contentPane.add(lblNewLabel);
		
		JLabel lab2 = new JLabel("\uB514\uC2A4\uD50C\uB808\uC774");
		lab2.setBounds(173, 161, 81, 15);
		contentPane.add(lab2);
		
	
		com2.setBounds(173, 186, 106, 21);
		contentPane.add(com2);
		com2.setModel(new DefaultComboBoxModel(new String[] {"선택","TFT", "Super AMOLED","HD IPS","Retina"}));
		
		JLabel lab3 = new JLabel("메모리");
		lab3.setBounds(308, 161, 57, 15);
		contentPane.add(lab3);
		
		
		com3.setBounds(308, 186, 106, 21);
		contentPane.add(com3);
		com3.setModel(new DefaultComboBoxModel(new String[] {"선택","16", "32"}));
		
		JLabel lab4 = new JLabel("카메라화소");
		lab4.setBounds(47, 222, 73, 15);
		contentPane.add(lab4);
		
	
		com4.setBounds(47, 247, 106, 21);
		contentPane.add(com4);
		com4.setModel(new DefaultComboBoxModel(new String[] {"선택","200", "300","400","500"}));
		
		JLabel lab5 = new JLabel("배터리 용량");
		lab5.setBounds(173, 222, 73, 15);
		contentPane.add(lab5);
		
		
		com5.setBounds(173, 247, 106, 21);
		contentPane.add(com5);
		com5.setModel(new DefaultComboBoxModel(new String[] {"선택","800", "1200"}));
		
		ok.addActionListener(this);
	}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			this.color = (String) comboBox.getSelectedItem();
			this.dis = (String) com2.getSelectedItem();
			this.mem = (double) Integer.parseInt((String) com3.getSelectedItem());
			this.cpu = (double) Integer.parseInt((String) com1.getSelectedItem());
			this.camera =  Integer.parseInt((String) com4.getSelectedItem());
			this.bettery =  Integer.parseInt((String) com5.getSelectedItem());
			//System.out.println(color +" "+ dis +" "+ mem +" "+ cpu +" "+ camera +" "+ bettery);
			
			ResultUI LUI = new ResultUI();
			final LoadingUI g = new LoadingUI();
			new Thread() {   				
	               public void run() {   
	                   for (int i = 0; i < 3; i++) {   
	                       try {   
	                           Thread.sleep(8000);   
	                       } catch (InterruptedException e) {   
	                       }   
	                   	g.dispose();
	                   }   
	               }   
	           }.start();
	          LUI.FinalUI(tel, os, broad, color, dis, mem, cpu, camera, bettery);
	          g.WifiUI();
	}
}
