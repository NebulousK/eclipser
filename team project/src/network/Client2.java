package network;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client2 extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField textField;
	JButton btnLogin = new JButton("login");// 로긴 버튼
	JButton Send_button = new JButton("send");// send 버튼 
	private static Socket socket;
	private static String ip="192.168.10.112";//127.0.0.1 ip  고정 
	private String id=null;
	private static  int port=12345;
	private static InputStream is;
	private static OutputStream os;
	private static DataInputStream dis;
	private static DataOutputStream dos;
	
	boolean blimit;
	private static String msg="";
	JTextArea textArea = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client2 frame = new Client2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Client2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(34, 366, 428, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		Send_button.setBounds(479, 365, 125, 29);
		contentPane.add(Send_button);
		scrollPane.setBounds(34, 28, 428, 322);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		textArea.setColumns(10);
		btnLogin.setBounds(479, 110, 125, 29);
		contentPane.add(btnLogin);
		this.setVisible(true);
		btnLogin.addActionListener(this);
		Send_button.addActionListener(this);	
	}
	private static void send_message(String str){
		try {
			System.out.println(socket);
			InetAddress a = socket.getLocalAddress();
			String b = InetAddress.getLocalHost().toString();
			if(str.charAt(0) == 'C' || str.charAt(0) == 'c'){dos.writeUTF(str);}
			else{dos.writeUTF(b.substring(6)+" : "+str );}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void network(){
		try {
			socket=new Socket(ip,port);
			if(socket!=null){
				connection();
				send_message("접속했습니다\n");
			}
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}//
	}
	private void connection(){// 
		try {
			is =socket.getInputStream();
			dis=new DataInputStream(is);
			
			os=socket.getOutputStream();
			dos=new DataOutputStream(os);
			
			inmessage1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 커넥션 끝 
	public void inmessage1(){
		
		Thread th= new Thread(new Runnable() {		
			@Override
			public void run() {	
					try { 				
					String str="";
					while(true){
						if(blimit = !blimit){
						str=dis.readUTF();
						 textArea.append(str);
						}
						}			
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//			
			}
		}); th.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogin){
			System.out.println("로그인버튼 ");
			network();
		}
		else if (e.getSource()==Send_button){	
			msg=textField.getText().trim();		 
			send_message(msg);
			System.out.println("보내졌다 ");
		}
	}
	public static void pic(String pi, int cnt) throws UnknownHostException, IOException{
		    socket=new Socket(ip,987);
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			msg=pi;		
			send_message(msg);
            InputStreamReader inputStreamReader = null;
	        FileOutputStream fileOutputStream = null;
	        try {
	            InputStream inputStream = socket.getInputStream();
	            fileOutputStream = new FileOutputStream("./download"+cnt+".jpg");
	            byte[] dataBuff = new byte[10000];
	            int length = inputStream.read(dataBuff);
	            System.out.print("다운중 ");
	            while (length != -1) {
	                System.out.print(".");
	                fileOutputStream.write(dataBuff, 0, length);
	                length = inputStream.read(dataBuff);
	            }
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            if (fileOutputStream != null) {
	                try {
	                    fileOutputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (inputStreamReader != null) {
	                try {
	                    inputStreamReader.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }if (socket != null) {
	                try {
	                	socket.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}