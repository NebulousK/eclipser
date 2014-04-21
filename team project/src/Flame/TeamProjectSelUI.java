package Flame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class TeamProjectSelUI extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public void TeamProjectSelUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 600);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbsk = new JLabel();
		ImageIcon sk, kt, lg;
		sk = new ImageIcon(getClass().getResource("/Teamimg/skt.png"));
		lbsk.setHorizontalAlignment(SwingConstants.CENTER);
		lbsk.setIcon(sk);
		lbsk.setBounds(12, 20, 190, 400);
		lbsk.setName("skt");
		lbsk.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(lbsk);
		
		JLabel lbkt = new JLabel();
		kt = new ImageIcon(getClass().getResource("/Teamimg/olleg KT.png"));
		lbkt.setHorizontalAlignment(SwingConstants.CENTER);
		lbkt.setIcon(kt);
		lbkt.setBounds(222, 20, 190, 400);
		lbkt.setName("kt");
		lbkt.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(lbkt);
		
		JLabel lblg = new JLabel();
		lg = new ImageIcon(getClass().getResource("/Teamimg/lg u+.png"));
		lblg.setHorizontalAlignment(SwingConstants.CENTER);
		lblg.setIcon(lg);
		lblg.setBounds(432, 20, 190, 400);
		lblg.setName("lgt");
		lblg.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(lblg);
		
		JLabel teltitle = new JLabel("통신사를 선택하세요");
		teltitle.setFont(new Font("굴림", Font.BOLD, 30));
		teltitle.setHorizontalAlignment(SwingConstants.CENTER);
		teltitle.setBorder(BorderFactory.createLineBorder(Color.black));
		teltitle.setBounds(12, 452, 610, 90);
		contentPane.add(teltitle);
		
		lbsk.addMouseListener(this);
		lbkt.addMouseListener(this);
		lblg.addMouseListener(this);
		
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		TeamProjectSelUI1 ui1 = new TeamProjectSelUI1();
		ui1.SelUI1(e.getActionCommand());
		dispose();
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {
		TeamProjectSelUI1 ui1 = new TeamProjectSelUI1();
		JLabel l = (JLabel) e.getSource();
		
		if(l.getName().equals("skt")){
			ui1.SelUI1(l.getName());
			dispose();
		}
		else if(l.getName().equals("kt")){
			ui1.SelUI1(l.getName());
			dispose();
		}
		else if(l.getName().equals("lgt")){
			ui1.SelUI1(l.getName());
			dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
	@Override
	public void mousePressed(MouseEvent e){
		
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0){}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
