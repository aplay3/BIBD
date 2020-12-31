package TCP;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.swing.*;

public class CalendarView extends JFrame {

	private CalendarController C;
	
	String [] days = {"��","��","ȭ","��","��","��","��"};
    int year ,month,day,todays,memoday=0;
    
    Font f;
    
    Calendar today;
    
    JButton btnBefore2,btnAfter2; //befor2 �۳� // after2 ����
    JButton btnBefore,btnAfter;
    JButton btnAdd,btnDel;
    public JButton[] calBtn;
    
    JLabel time;
    
    JPanel southPanel;
    JPanel northPanel;
    JPanel centerPanel;
    JPanel titlePanel;
    
    JTextField txtWrite;
    JLabel lblYear,lblMonth,lblTitle;
    JTextArea ta;
    BorderLayout bLayout= new BorderLayout(); 
    
    Connection con = null;
    Statement stmt = null;
    
 
    
    
    public CalendarView() {
    	
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	today = Calendar.getInstance();
    	year = today.get(Calendar.YEAR);
    	month = today.get(Calendar.MONTH)+1;
    	titlePanel = new JPanel();
    	northPanel = new JPanel();
    	
    	btnBefore2 = new JButton("<<");
    	btnBefore = new JButton("<");
    	btnAfter = new JButton(">");
    	btnAfter2 = new JButton(">>");
    	
    	lblYear = new JLabel(year+" �� ");
    	lblMonth = new JLabel(month+" �� ");
    	
    	Font f = new Font("�޸�����ü",Font.BOLD,25);
    	calBtn = new JButton[49];
    	lblYear.setFont(f);
    	lblMonth.setFont(f);
    	lblTitle = new JLabel("��CALENDER��");
    	lblTitle.setFont(new Font("�޸�����ü",Font.BOLD,50));
    	lblTitle.setForeground(Color.PINK);
    	
    	titlePanel.add(lblTitle);
    	
    	northPanel.add(btnBefore2);
    	northPanel.add(btnBefore);
    	northPanel.add(lblYear);
    	northPanel.add(lblMonth);
    	northPanel.add(btnAfter);
    	northPanel.add(btnAfter2);
    	centerPanel = new JPanel( new GridLayout(7,7));
    	f = new Font("�������ü",Font.BOLD,12);
    	
    	
    	add(titlePanel,BorderLayout.NORTH);
    	northPanel.add(centerPanel);
    	
    	btnAdd = new JButton("�����߰�");
    	btnDel = new JButton("��������");
    	
    	add(northPanel,BorderLayout.CENTER);
    	
    	southPanel= new JPanel();
    	ta = new JTextArea(15,40);
    	
    	southPanel.add(ta);
    	add(southPanel,BorderLayout.SOUTH);
    	
    	
    	
    	setSize(600,700);
    	setVisible(true); 
    }
    
    public void addButtonActionListener(ActionListener listener) {
		btnBefore2.addActionListener(listener);
		btnBefore.addActionListener(listener);
		btnAfter.addActionListener(listener);
		btnAfter2.addActionListener(listener);
		for(int i=0;i<49;i++)
			calBtn[i].addActionListener(listener);
	}
    
    
   
    
}
