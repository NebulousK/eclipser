package Flame;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class TeamProjectSelUI extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TeamProjectSelUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnsk = new JButton("skt");
		ImageIcon sk, kt, lg;
		sk = new ImageIcon(getClass().getResource("/Teamimg/skt.png"));
		btnsk.setIcon(sk);
		btnsk.setText("skt");
		btnsk.setBounds(12, 10, 140, 280);
		contentPane.add(btnsk);
		
		JButton btnkt = new JButton("kt");
		kt = new ImageIcon(getClass().getResource("/Teamimg/olleg KT.png"));
		btnkt.setIcon(kt);
		btnkt.setBounds(172, 10, 140, 280);
		contentPane.add(btnkt);
		
		JButton btnlg = new JButton("lg");
		lg = new ImageIcon(getClass().getResource("/Teamimg/lg u+.png"));
		btnlg.setIcon(lg);
		btnlg.setBounds(329, 10, 140, 280);
		contentPane.add(btnlg);
		
		JLabel teltitle = new JLabel("통신사를 선택하세요");
		teltitle.setFont(new Font("굴림", Font.BOLD, 30));
		teltitle.setHorizontalAlignment(SwingConstants.CENTER);
		teltitle.setBounds(12, 312, 460, 90);
		contentPane.add(teltitle);
		
		btnsk.addActionListener(this);
		btnkt.addActionListener(this);
		btnlg.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			TeamProjectSelUI1 UI1 = new TeamProjectSelUI1();
			UI1.SelUI1(e.getActionCommand());
			dispose();
	}
}
