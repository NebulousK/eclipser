package Flame;


import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTable;

import db.delete;
import db.handphone;
import db.insert;
import db.view;

import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import network.filepost;

public class admin extends JFrame implements ItemListener {
	public static JPanel contentPane;
	int cnt2 = 0;
	private JTextField textField_15;
	FileDialog fopen;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	String telecom;
	String telecom2;
	String telecom3;
	Checkbox c1,c2,c3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String name;
	String img,img2,img3,img4;
	JTextArea textArea = new JTextArea();
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	Checkbox checkbox = new Checkbox("skt", false);
	Checkbox checkbox_1 = new Checkbox("kt", false);
	Checkbox checkbox_2 = new Checkbox("lgt", false);
	JTextArea textArea_1 = new JTextArea();
	int cnt = 0;
	private JTable table;
	Object[] columnNames = {"", "Name","os","broad","dis","camera","bettery","price"};
    Object[][] data;
    String a[] = {null,"","","","","","","","","","",};
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public admin() {
		fopen = new FileDialog(this, "열고", FileDialog.LOAD);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 33, 572, 490);
		tabbedPane.setPreferredSize(new Dimension(400,100));
		contentPane.add(tabbedPane);
		
		JPanel pan1 = new JPanel();  
	    pan1.setBackground(Color.white); // ��ũ���� ���̰� �ϱ����� �� ����� �ø� 
	    pan1.setPreferredSize(new Dimension(400, 100)); // ��ũ�� ���� 
	    JScrollPane scroll1 = new JScrollPane(pan1); 
	    pan1.setLayout(null);
	    
	    JLabel label = new JLabel("이미지");
	    label.setBounds(12, 141, 57, 15);
	    pan1.add(label);
	    
	    textField_15 = new JTextField();
	    textField_15.setEditable(false);
	    textField_15.setBounds(81, 141, 116, 21);
	    textField_15.setDisabledTextColor(Color.blue);
	    pan1.add(textField_15);
	    textField_15.setColumns(10);
	    
	    
	    JButton btnNewButton_1 = new JButton("파일선택");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		fopen.setVisible(true);
	    		name = fopen.getFile();
				if(name.endsWith("jpg") || name.endsWith("png") || name.endsWith("gif") || name.endsWith("bmp")){
    			textField_15.setText(fopen.getFile());
    			img = fopen.getDirectory() + fopen.getFile();
				}
				else{
					JOptionPane.showMessageDialog(contentPane,"그림파일만 가능 합니다.");
				}
	    	}
	    });
	    btnNewButton_1.setBounds(209, 140, 97, 23);
	    pan1.add(btnNewButton_1);
	    
	    JLabel lblNewLabel = new JLabel("핸드폰 이름");
	    lblNewLabel.setBounds(12, 10, 74, 15);
	    pan1.add(lblNewLabel);
	    
	    textField = new JTextField();  //name
	    textField.setBounds(81, 10, 116, 21);
	    pan1.add(textField);
	    textField.setColumns(10);
	    
	    JLabel label_1 = new JLabel("통신사");
	    label_1.setBounds(12, 35, 57, 15);
	    pan1.add(label_1);
	    
	    JLabel lblD = new JLabel("운영체제");
	    lblD.setBounds(12, 60, 57, 15);
	    pan1.add(lblD);
	    
	    textField_4 = new JTextField(); //운영체제
	    textField_4.setBounds(81, 60, 116, 21);
	    pan1.add(textField_4);
	    textField_4.setColumns(10);
	    
	    JLabel label_2 = new JLabel("통신망");
	    label_2.setBounds(239, 60, 57, 15);
	    pan1.add(label_2);
	    
	    textField_5 = new JTextField(); //통신망
	    textField_5.setBounds(325, 57, 116, 21);
	    pan1.add(textField_5);
	    textField_5.setColumns(10);
	    
	    JLabel lblNewLabel_1 = new JLabel("화면크기");
	    lblNewLabel_1.setBounds(12, 88, 57, 15);
	    pan1.add(lblNewLabel_1);
	    
	    textField_6 = new JTextField(); //화면크기
	    textField_6.setBounds(81, 88, 116, 21);
	    pan1.add(textField_6);
	    textField_6.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_6.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    			textField_6.requestFocus();
	    		}
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    textField_6.setColumns(10);
	    
	    JLabel label_3 = new JLabel("카메라 화소");
	    label_3.setBounds(239, 88, 74, 15);
	    pan1.add(label_3);
	    
	    textField_7 = new JTextField(); //화소
	    textField_7.setBounds(325, 85, 116, 21);
	    pan1.add(textField_7);
	    textField_7.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_7.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    			textField_7.requestFocus();
	    		}
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    textField_7.setColumns(10);
	    
	    JLabel label_4 = new JLabel("베터리용량");
	    label_4.setBounds(12, 116, 74, 15);
	    pan1.add(label_4);
	    
	    textField_8 = new JTextField(); //베터리 용량
	    textField_8.setBounds(81, 116, 116, 21);
	    pan1.add(textField_8);
	    textField_8.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_8.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    			textField_8.requestFocus();
	    		}
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    textField_8.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("가격");
	    lblNewLabel_2.setBounds(253, 116, 57, 15);
	    pan1.add(lblNewLabel_2);
	    
	    textField_9 = new JTextField(); //가격
	    textField_9.setBounds(325, 116, 116, 21);
	    pan1.add(textField_9);
	    textField_9.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_9.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    			textField_9.requestFocus();
	    		}
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    textField_9.setColumns(10);
	    
	    
	    c1 = new Checkbox("skt",false);
	    c1.setBounds(99, 31, 115, 23);
	    pan1.add(c1);
	    
	    c2 = new Checkbox("kt",false);
	    c2.setBounds(229, 31, 115, 23);
	    pan1.add(c2);

		c3 = new Checkbox("lgt",false);
	    c3.setBounds(360, 31, 115, 23);
	    pan1.add(c3);
	    
	    textField_1 = new JTextField();
	    textField_1.setEditable(false);
	    textField_1.setBounds(325, 141, 116, 21);
	    textField_1.setDisabledTextColor(Color.blue);
	    pan1.add(textField_1);
	    textField_1.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setEditable(false);
	    textField_2.setBounds(81, 172, 116, 21);
	    textField_2.setDisabledTextColor(Color.blue);
	    pan1.add(textField_2);
	    textField_2.setColumns(10);
	    
	    textField_3 = new JTextField();
	    textField_3.setEditable(false);
	    textField_3.setBounds(325, 172, 116, 21);
	    textField_3.setDisabledTextColor(Color.blue);
	    pan1.add(textField_3);
	    textField_3.setColumns(10);
	    
	    JButton btnNewButton_2 = new JButton("파일선택");
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		fopen.setVisible(true);
	    		name = fopen.getFile();
				if(name.endsWith("jpg") || name.endsWith("png") || name.endsWith("gif") || name.endsWith("bmp")){
    			textField_1.setText(fopen.getFile());
    			img2 = fopen.getDirectory() + fopen.getFile();
				}
				else{
					JOptionPane.showMessageDialog(contentPane,"그림파일만 가능 합니다.");
				}
	    	}
	    });
	    btnNewButton_2.setBounds(450, 140, 97, 23);
	    pan1.add(btnNewButton_2);
	    
	    JButton btnNewButton_3 = new JButton("파일선택");
	    btnNewButton_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		fopen.setVisible(true);
	    		if(name.endsWith("jpg") || name.endsWith("png") || name.endsWith("gif") || name.endsWith("bmp")){
	    			textField_2.setText(fopen.getFile());
	    			img3 = fopen.getDirectory() + fopen.getFile();
					}
					else{
						JOptionPane.showMessageDialog(contentPane,"그림파일만 가능 합니다.");
					}
	    	}
	    });
	    btnNewButton_3.setBounds(209, 173, 97, 23);
	    pan1.add(btnNewButton_3);
	    
	    JButton btnNewButton_4 = new JButton("파일선택");
	    btnNewButton_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		fopen.setVisible(true);
	    		if(name.endsWith("jpg") || name.endsWith("png") || name.endsWith("gif") || name.endsWith("bmp")){
	    			textField_3.setText(fopen.getFile());
	    			img4 = fopen.getDirectory() + fopen.getFile();
					}
					else{
						JOptionPane.showMessageDialog(contentPane,"그림파일만 가능 합니다.");
					}
	    	}
	    });
	    btnNewButton_4.setBounds(450, 171, 97, 23);
	    pan1.add(btnNewButton_4);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(30, 221, 503, 173);
	    pan1.add(scrollPane);
	    
	   
	    scrollPane.setViewportView(textArea);
	   
	    JLabel label_5 = new JLabel("상세설명");
	    label_5.setBounds(12, 198, 57, 15);
	    pan1.add(label_5);
	    tabbedPane.addTab("등록", scroll1); 
	   
	    JPanel pan2 = new JPanel(); 
	    pan2.setBackground(Color.white); // ��ũ���� ���̰� �ϱ����� �� ����� �ø� 
	    pan2.setPreferredSize(new Dimension(400,100)); // ��ũ�� ���� 
	    JScrollPane scroll2 = new JScrollPane(pan2); 
	    pan2.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    panel.setPreferredSize(new Dimension(400, 100));
	    panel.setBackground(Color.WHITE);
	    panel.setBounds(0, 0, 565, 459);
	    pan2.add(panel);
	    
	    JLabel label_6 = new JLabel("이미지");
	    label_6.setBounds(12, 141, 57, 15);
	    panel.add(label_6);
	    
	    textField_10 = new JTextField();
	    textField_10.setEditable(false);
	    textField_10.setColumns(10);
	    textField_10.setBounds(81, 141, 116, 21);
	    textField_10.setDisabledTextColor(Color.blue);
	    panel.add(textField_10);
	    
	    JButton button = new JButton("파일선택");
	    button.setBounds(209, 140, 97, 23);
	    panel.add(button);
	    
	    JLabel label_7 = new JLabel("핸드폰 이름");
	    label_7.setBounds(12, 10, 74, 15);
	    panel.add(label_7);
	    
	    textField_11 = new JTextField();
	    textField_11.setColumns(10);
	    textField_11.setBounds(81, 10, 216, 21);
	    panel.add(textField_11);
	    
	    JLabel label_8 = new JLabel("통신사");
	    label_8.setBounds(12, 35, 57, 15);
	    panel.add(label_8);
	    
	    JLabel label_9 = new JLabel("운영체제");
	    label_9.setBounds(12, 60, 57, 15);
	    panel.add(label_9);
	    
	    textField_12 = new JTextField();
	    textField_12.setColumns(10);
	    textField_12.setBounds(81, 60, 116, 21);
	    panel.add(textField_12);
	    
	    JLabel label_10 = new JLabel("통신망");
	    label_10.setBounds(239, 60, 57, 15);
	    panel.add(label_10);
	    
	    textField_13 = new JTextField();
	    textField_13.setColumns(10);
	    textField_13.setBounds(325, 57, 116, 21);
	    panel.add(textField_13);
	    
	    JLabel label_11 = new JLabel("화면크기");
	    label_11.setBounds(12, 88, 57, 15);
	    panel.add(label_11);
	    
	    textField_14 = new JTextField();
	    textField_14.setColumns(10);
	    textField_14.setBounds(81, 88, 116, 21);
	    textField_14.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_14.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    		}
				textField_14.requestFocus();
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    panel.add(textField_14);
	    
	    JLabel label_12 = new JLabel("카메라 화소");
	    label_12.setBounds(239, 88, 74, 15);
	    panel.add(label_12);
	    
	    textField_16 = new JTextField();
	    textField_16.setColumns(10);
	    textField_16.setBounds(325, 85, 116, 21);
	    textField_16.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_16.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    		}
				textField_16.requestFocus();
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    panel.add(textField_16);
	    
	    JLabel label_13 = new JLabel("베터리용량");
	    label_13.setBounds(12, 116, 74, 15);
	    panel.add(label_13);
	    
	    textField_17 = new JTextField();
	    textField_17.setColumns(10);
	    textField_17.setBounds(81, 116, 116, 21);
	    textField_17.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_17.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    		}
				textField_17.requestFocus();
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    panel.add(textField_17);
	    
	    JLabel label_14 = new JLabel("가격");
	    label_14.setBounds(253, 116, 57, 15);
	    panel.add(label_14);
	    
	    textField_18 = new JTextField();
	    textField_18.setColumns(10);
	    textField_18.setBounds(325, 116, 116, 21);
	    textField_18.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!isNumeric(textField_18.getText())){
	    			JOptionPane.showMessageDialog(contentPane,"숫자만 입력 가능합니다.");
	    		}
				textField_18.requestFocus();
			}
			@Override
			public void focusGained(FocusEvent e) {}
		}); 
	    panel.add(textField_18);
	    
	    
	    checkbox.setBounds(99, 31, 115, 23);
	    panel.add(checkbox);
	   
	    checkbox_1.setBounds(229, 31, 115, 23);
	    panel.add(checkbox_1);
	    
	    
	    checkbox_2.setBounds(360, 31, 115, 23);
	    panel.add(checkbox_2);
	    
	    textField_19 = new JTextField();
	    textField_19.setEditable(false);
	    textField_19.setColumns(10);
	    textField_19.setBounds(325, 141, 116, 21);
	    textField_19.setDisabledTextColor(Color.blue);
	    panel.add(textField_19);

	    textField_20 = new JTextField();
	    textField_20.setEditable(false);
	    textField_20.setColumns(10);
	    textField_20.setBounds(81, 172, 116, 21);
	    textField_20.setDisabledTextColor(Color.blue);
	    panel.add(textField_20);
	    
	    textField_21 = new JTextField();
	    textField_21.setEditable(false);
	    textField_21.setColumns(10);
	    textField_21.setBounds(325, 172, 116, 21);
	    textField_21.setDisabledTextColor(Color.blue);
	    panel.add(textField_21);
	    
	    JButton button_1 = new JButton("파일선택");
	    button_1.setBounds(450, 140, 97, 23);
	    panel.add(button_1);
	    
	    JButton button_2 = new JButton("파일선택");
	    button_2.setBounds(209, 173, 97, 23);
	    panel.add(button_2);
	    
	    JButton button_3 = new JButton("파일선택");
	    button_3.setBounds(450, 171, 97, 23);
	    panel.add(button_3);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(30, 221, 503, 173);
	    panel.add(scrollPane_1);
	    
	     
	    scrollPane_1.setViewportView(textArea_1);
	    
	    JLabel label_15 = new JLabel("상세설명");
	    label_15.setBounds(12, 198, 57, 15);
	    panel.add(label_15);
	    
	    JButton button_4 = new JButton("수정");
	    button_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {	
	    		
	    		/*
	    		if(textField_11.getText().equals("") || textField_12.getText().equals("") || textField_13.getText().equals("") || 
	    				textField_14.getText().equals("") || textField_16.getText().equals("") || textField_17.getText().equals("") || 
	    				textField_18.getText().equals("") || textArea_1.equals(""))	{
	    			JOptionPane.showMessageDialog(contentPane,"입력을 확실히 해주세요.");
	    		}
	    		else{*/
	    		db.update g = new db.update(textField_11.getText(), checkbox.getName(), checkbox_1.getName(), checkbox_2.getName()
	    				, textField_12.getText(), textField_13.getText(), Integer.parseInt(textField_14.getText()), Integer.parseInt(textField_16.getText()),
	    				Integer.parseInt(textField_17.getText()),Integer.parseInt(textField_18.getText()),textArea_1.getText(),textField_10.getText(),
	    				textField_19.getText(),textField_20.getText(),textField_21.getText());	
	    		//}
	    		JOptionPane.showMessageDialog(contentPane,"수정완료.");
	    	}
	    });
	    button_4.setBounds(450, 412, 97, 23);
	    panel.add(button_4);
	    
	    JButton btnNewButton_5 = new JButton("조회");
	    btnNewButton_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	if(textField_11.getText().equals("")){
	    		JOptionPane.showMessageDialog(contentPane,"검색하실 핸드폰 이름을 정확히 적으세요");
	    	}
	    	else{
	    		System.out.println(textField.getText());
	    		handphone  a = db.update.getdb(textField_11.getText());
	    		textField_12.setText(a.getOs());
	    		textField_13.setText(a.getBroad());
	    		textField_14.setText(Integer.toString(a.getDisplay()));
	    		textField_16.setText(Integer.toString(a.getCamera()));
	    		textField_17.setText(Integer.toString(a.getBettery()));
	    		textField_18.setText(Integer.toString(a.getPrice()));
	    		textArea_1.setText(a.getView());
	    		if(a.getTelecom()!= null){
	    			checkbox.setState(true);
	    		}
	    		if(a.getTelecom2()!= null){
	    			checkbox_1.setState(true);
	    		}
	    		if(a.getTelecom3()!= null){
	    			checkbox_2.setState(true);
	    		}
	    		textField_10.setText(a.getImage());
	    		textField_19.setText(a.getImage2());
	    		textField_20.setText(a.getImage3());
	    		textField_21.setText(a.getImage4());
	    	}
	    }
	    });
	    btnNewButton_5.setBounds(308, 6, 97, 23);
	    panel.add(btnNewButton_5);
	    
	    JButton btnNewButton_6 = new JButton("삭제");
	    btnNewButton_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new delete(textField_11.getText());
	    	}
	    });
	    btnNewButton_6.setBounds(336, 412, 97, 23);
	    panel.add(btnNewButton_6);
	    tabbedPane.addTab("수정/삭제", scroll2); 
	    
	    JPanel pan3 = new JPanel(); 
	    pan3.setBackground(Color.white); // ��ũ���� ���̰� �ϱ����� �� ����� �ø� 
	    pan3.setPreferredSize(new Dimension(400,100)); // ��ũ�� ���� 
	    JScrollPane scroll3 = new JScrollPane(pan3); 
	    pan3.setLayout(null);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    scrollPane_2.setBounds(12, 10, 541, 407);
	    pan3.add(scrollPane_2);
	    
	    table = new JTable(model){
	    	private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    	return Boolean.class;
                    default:
                        return String.class;     
                }
            }
	    };
	    scrollPane_2.setViewportView(table);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
        table.getColumnModel().getColumn(7).setPreferredWidth(70);
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table = (JTable) e.getComponent(); // 객체 얻기
				table.setValueAt(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()), table.getSelectedRow(), table.getSelectedColumn());
			}
		});
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
        dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
        TableColumnModel tcm = table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴
        tcm.getColumn(1).setCellRenderer(dtcr);     
	
	    JButton btnNewButton_7 = new JButton("조회");
	    btnNewButton_7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		ArrayList<handphone> datas = view.get();
	    		if(cnt2 != 0){
	    		model.removeRow(0);
	    		model.removeRow(0);
	    		model.removeRow(0);
	    		model.removeRow(0);
	    		model.removeRow(0);
	    		model.removeRow(0);
	    		model.removeRow(0);
	    		model.removeRow(0);
	    		
	    		for(handphone handphone : datas){
		    		a[1] = handphone.getName();
		    	//	a[2] = handphone.getTelecom();
		    	//	a[3] = handphone.getTelecom2();
		    	//	a[4] = handphone.getTelecom3();
		    		a[2] = handphone.getOs();
		    		a[3] = handphone.getBroad();
		    		a[4] = Integer.toString(handphone.getDisplay());
		    		a[5] = Integer.toString(handphone.getCamera());
		    		a[6] = Integer.toString(handphone.getBettery());
		    		a[7] = Integer.toString(handphone.getPrice());
		    		model.insertRow(0,a);
		    		cnt2++;
	    		}
	    		}
	    		
	    		if(cnt == 0){
	    		for(handphone handphone : datas){
	    		a[1] = handphone.getName();
	    	//	a[2] = handphone.getTelecom();
	    	//	a[3] = handphone.getTelecom2();
	    	//	a[4] = handphone.getTelecom3();
	    		a[2] = handphone.getOs();
	    		a[3] = handphone.getBroad();
	    		a[4] = Integer.toString(handphone.getDisplay());
	    		a[5] = Integer.toString(handphone.getCamera());
	    		a[6] = Integer.toString(handphone.getBettery());
	    		a[7] = Integer.toString(handphone.getPrice());
	    		model.insertRow(0,a);
	    		cnt2++;
	    	}
	     }
	    	else {
	    	
	    	}
	    		cnt++;
	    	}
	    });
	    btnNewButton_7.setBounds(456, 427, 97, 23);
	    pan3.add(btnNewButton_7);
	    
	    JButton btnNewButton_8 = new JButton("삭제");
	    btnNewButton_8.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//System.out.println(model.getValueAt(0,1));
	    		for (int i = 0; i < model.getRowCount(); i++) {
					if(model.getValueAt(i,0) != null){
						boolean Test = (boolean) model.getValueAt(i, 0);
						if(Test){
						String de = (String) model.getValueAt(i,1);
						//System.out.println(de);
						new delete(de);	
						model.removeRow(i);
						}
					}
				}
	    	}
	    });
	    btnNewButton_8.setBounds(347, 427, 97, 23);
	    pan3.add(btnNewButton_8);
	    tabbedPane.addTab("일괄삭제", scroll3); 
	    
	    JButton btnNewButton = new JButton("저장");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		if(textField.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("") || 
	    				textField_6.getText().equals("") || textField_7.getText().equals("") || textField_8.getText().equals("") || 
	    				textField_9.getText().equals("") || textArea.equals(""))	{
	    			JOptionPane.showMessageDialog(contentPane,"입력을 확실히 해주세요.");
	    		}
	    		else{	
	    		insert.handphon(textField.getText(),telecom,telecom2,telecom3,textField_4.getText(),textField_5.getText(),Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_7.getText()),
	    				Integer.parseInt(textField_8.getText()),Integer.parseInt(textField_9.getText()));
	    		System.out.println("111");
	    		insert.image(textField.getText(), img,img2,img3,img4);
	    		System.out.println("222");
	    		insert.detail(textField.getText(), textArea.getText());
	    		/*
	    		Socket socket;
				try {
					socket = new Socket("192.168.10.112", 7777);
					filepost z = new filepost(socket);
		    		if(!img.equals("")){
					z.post(img);
		    		}
		    		if(!img2.equals("")){
		    		z.post(img2);
		    		}
		    		if(!img3.equals("")){
		    		z.post(img3);
		    		}
		    		if(!img4.equals("")){
		    		z.post(img4);
		    		}
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}*/
				JOptionPane.showMessageDialog(contentPane,"등록되었습니.");
	    	}
	     }});
	    btnNewButton.setBounds(450, 412, 97, 23);
	    pan1.add(btnNewButton);
	    
	    c1.addItemListener(this);
	    c2.addItemListener(this);
	    c3.addItemListener(this);
	    checkbox.addItemListener(this);
	    checkbox_1.addItemListener(this);
	    checkbox_2.addItemListener(this);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			if(e.getItem() == "skt"){
				telecom = "skt";
				System.out.println(telecom);
			}	
			if(e.getItem() == "kt"){
				telecom2 = "kt";
				System.out.println(telecom2);
			}	
			if(e.getItem() == "lgt"){
				telecom3 = "lgt";
				System.out.println(telecom3);
			}	
		}
		else if(e.getStateChange() == ItemEvent.DESELECTED){
			if(e.getItem() == "skt"){
				telecom = null;
				System.out.println(telecom);
			}	
			if(e.getItem() == "kt"){
				telecom2 = null;
				System.out.println(telecom2);
			}	
			if(e.getItem() == "lgt"){
				telecom3 = null;
				System.out.println(telecom3);
			}	
	}
 }
	
	public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[+-]?\\d+");
        return pattern.matcher(str).matches();
    }
}
