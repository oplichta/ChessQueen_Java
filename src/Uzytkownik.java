import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
//cos zle z przekazywaniem z plansa do uzytkownik
public class Uzytkownik extends JFrame {
	
	static String imie="kot";
	String kwerenda;
	String url = "jdbc:postgresql://localhost/" ;
	JLabel t = new JLabel();
	JTextField t1 = new JTextField(20);
	JButton zapis= new JButton("Zapisz gre");
	JButton odczyt=new JButton("Wczytaj gre");
	int [][][] ruchy;
	int l=666,x,y;
	//  this.l=PlanszaS.l;
	
	  public Uzytkownik() {
		 int i=0,j=0;
		  Container cp = getContentPane();
		  cp.setLayout(new GridLayout(4,1));
		  cp.add(t);
		  cp.add(t1);
		  cp.add(zapis);
		  cp.add(odczyt);
		  
		  System.out.println("x : y : l "+x+" "+y+" "+l);
		 
		  
		  zapis.addActionListener( new ZAPIS());
		  odczyt.addActionListener( new ODCZYT());
		  t.setText("Podaj imie do zapisu");
		  ruchy=new int[100][i][j];
		  PlanszaS planszas= new PlanszaS();
		 this.ruchy= planszas.ruchy;
		 x=ruchy[i][0][0];
	  		y=ruchy[i][1][1];
		this.l=planszas.l;
		 System.out.println("x : y : l "+x+" "+y+" "+l);
		 }
	  
	  class ZAPIS implements ActionListener{
		  public void actionPerformed(ActionEvent e) { 
			  int i=0;
			  imie=t1.getText();	
			  kwerenda=imie;
			  t.setText(imie);			  	
					try {
					    Class.forName("org.postgresql.Driver");
					    Connection db = DriverManager.getConnection(url, "postgres", "postgres");
					    Statement st = db.createStatement();	 
					    
					   /* try {
					    	ResultSet rs= st.executeQuery("drop table "+ kwerenda+";");
					    	while (rs.next()) {
					    		System.out.println("Usunieto "+kwerenda);
					    	}
					    	rs.close();
					    
					    }catch (SQLException f){*/
					        //{
					        	/*	ResultSet r= st.executeQuery("create table "+ kwerenda+"(id serial primary key,x int,y int);");					    	
					        }
					        System.out.println("Utworzono tabele "+kwerenda);
					    	r.next();
					    	*/
					   // for(i=0;i<l;i++){	
					    		x=ruchy[i][0][0];
					    		y=ruchy[i][1][1];		
					    		ResultSet s= st.executeQuery("insert into "+ kwerenda+"(id ,x ,y) values ("+i+","+x+","+y+");");//<- wrzucilo 0,1,0	 do wpolu
					    		//s.updateInt(2,35);
					    	//	s.updateInt(3,45);
					    		//s.next();		
					    		s.close();
					   //	}				
						
					   // r.close();    					    						    	
					    st.close();
					       // }
		  			}catch (SQLException f) {
					    System.err.println("Wyjatek z zapytania SQL: " + f.getMessage());
					    f.printStackTrace(System.err);
					    System.out.println("x : y : l "+x+" "+y+" "+l);
					} catch (ClassNotFoundException g){
					    System.err.println("Wyjatek przy ladowaniu klas: " + g.getMessage());
					    g.printStackTrace(System.err);
					}				
			 
		  }
	  }
	  
	  class ODCZYT implements ActionListener{
		  int i;	  
		  public void actionPerformed(ActionEvent e) { 
			  imie=t1.getText();	
			  t.setText(imie);	   	
					
					try {
					    Class.forName("org.postgresql.Driver");
					    Connection db = DriverManager.getConnection(url, "postgres", "postgres");
					    Statement st = db.createStatement();
					    
					    	ResultSet rss= st.executeQuery("select * from "+ imie+";");
					    	for(i=0;i<l;i++){	
					    	rss.next();
					    		System.out.println("| "+rss.getInt(1)+"| "+rss.getInt(2)+"| "+rss.getInt(3));
					    		System.out.println("ruch nr: "+i);
					    		ruchy[i][0][0]=rss.getInt(2);
					    		ruchy[i][1][1]=rss.getInt(3);
					    		
					    }System.out.println("select "+imie);
					    rss.close(); 
					    st.close();
					    
					} catch (SQLException f) {
					    System.err.println("Wyjatek z zapytania SQL: " + f.getMessage());
					    f.printStackTrace(System.err);
					} catch (ClassNotFoundException g){
					    System.err.println("Wyjatek przy ladowaniu klas: " + g.getMessage());
					    g.printStackTrace(System.err);
					}
			  
	}
   }
}  
	  
	/*public static void main(String[] args) {
	    JFrame f = new Uzytkownik();
	    f.setSize(400,350);
	    f.setLocation(100,100);
	    f.setVisible(true);
	    
	  }*/
	 
