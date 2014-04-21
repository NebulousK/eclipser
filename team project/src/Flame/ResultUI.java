package Flame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.handphone;
import db.view;


public class ResultUI extends JFrame implements ActionListener{
	public ResultUI() {
	}

	private JPanel contentPane;
	private JScrollPane scroll;
	private JTable table;
	private JButton button;
	private int i;
	int c;
   
	@SuppressWarnings("deprecation")
	public void FinalUI(String tel, String os, String broad, String dis, String camera, String bettery, String price) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 600);
		setVisible(true);
		
		int i = 0;
		view g = new view();
		ArrayList<handphone> datas = g.view(tel, os, broad, dis, camera, bettery, price);
		String[][] cellData =new String[datas.size()][2];
		String as = null;
		for(handphone handphone:datas){
			cellData[i][0] = handphone.getName();
			cellData[i][1] = handphone.getOs();
			++i;
			}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		String[] columnName = {"핸드폰 이름", "제조사"};
	    table = new JTable();
		table.setModel(new DefaultTableModel(cellData, columnName));
		table.setBounds(309, 10, 313, 492);
		table.getTableHeader().setReorderingAllowed(false);
		table.isCellEditable(i, c);
		scroll = new JScrollPane(table);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		button = new JButton("확인");
		button.setBounds(12, 512, 610, 40);
		contentPane.add(button, BorderLayout.SOUTH);
		
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {			
		deview dd = new deview();
		String g = (String) table.getValueAt(table.getSelectedRow(), 0);
		System.out.println(g);
		try {
			dd.view(g);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//dispose();
	}
}
