import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;


public class PlanszaS extends JFrame {
  JButton tab[][] = new JButton[4][4] ;
  int [][][] wolne;
  int [][][] ruchy;
  JPanel plansza = new JPanel();
  JPanel sterowanie = new JPanel();
  JTextField t = new JTextField(10);
  JTextField t1 = new JTextField(20);
  JButton help= new JButton("help");
  JButton lista = new JButton("lista");
  JButton cofnij= new JButton("Cofnij ruch");
  JButton save = new JButton("zapis/odczyt");
 
  int p1=1;
  int l=0;
  //int x=0,y=0;
  
  public PlanszaS() {
    int i,j,k;
    
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(1,2));
    cp.add(plansza); cp.add(sterowanie);
    sterowanie.setLayout(new GridLayout(4,1));
    sterowanie.add(t);
    sterowanie.add(t1);
    sterowanie.add(help);
    sterowanie.add(lista);
    sterowanie.add(cofnij);
    sterowanie.add(save);
    
    lista.addActionListener( new C());
    cofnij.addActionListener( new D());
    save.addActionListener( new Save());
    help.addActionListener(new help());
    plansza.setLayout(new GridLayout(4,4));
    for (i=0;i<4;i++)
       for (j=0;j<4;j++){
	 tab[i][j]=new JButton("");
	 k=1;
	 wolne=new int[i][j][k]; 
	 ruchy=new int[100][i][j];
         plansza.add(tab[i][j]);
         (tab[i][j]).addActionListener(new B(i,j,k));
    }
     setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  class B implements ActionListener {
    int i,j,k,m,n,ile,o;
    B(int i,int j,int k){this.i=i;this.j=j;this.k=k;}  
    ImageIcon queen = new ImageIcon("queen.jpg"); 
//    ImageIcon pusty = new ImageIcon("pusty.jpg"); 
    public void actionPerformed(ActionEvent e) {    	
    
      if(k==1) {
    	  tab[i][j].setIcon(queen); 
    	  
    	  ruchy[l][0][0]=i;
    	  ruchy[l][1][1]=j;
    	  
    	  k=0;}
      		else {    	 
      			tab[i][j].setIcon(null);
      			k=1; 
      			o=i;
          	 // for (o=0;o<4;o++){
              	//  if(k==1){
              	  //ile=ile+k;}    	  
              //  }
      		}        
      t.setText(i+","+j);
      t1.setText(i+" "+j+" "+k+" "+"ruch nr "+l+" "+m+" "+n+"ile = "+ile);
   
    	 System.out.println("ruch nr: "+l);
        	System.out.println("1 "+ruchy[l][0][0]);
        	System.out.println("2 "+ruchy[l][1][1]);
        	l+=1;
    }    
  }
  
  class C implements ActionListener{
	  int i;	  
	  public void actionPerformed(ActionEvent e) { 
		for(i=0;i<l;i++){
			 System.out.println("ruch nr: "+i);
	        	System.out.println("1 "+ruchy[i][0][0]);
	        	System.out.println("2 "+ruchy[i][1][1]);
		}
	  }
  }
  
  class D implements ActionListener{
	  int i,j;	 
	public void actionPerformed(ActionEvent e) { 
		
		if(l>0){
			l=l-1;
			i=ruchy[l][0][0];
			j=ruchy[l][1][1];
			System.out.println("Cofam ruch nr: "+l);
//			ImageIcon pusty = new ImageIcon("pusty.jpg"); 
			tab[i][j].setIcon(null);
			//ruchy[l][0][0]=0;
			//ruchy[l][1][1]=0;
		}
	}
 }
  
  class Save implements ActionListener{ 
	public void actionPerformed(ActionEvent e) { 
		JFrame f = new Uzytkownik();
	    f.setSize(400,350);
	    f.setLocation(100,100);
	    f.setVisible(true);
	    
	}
  }
  
  class help implements ActionListener{ 
		public void actionPerformed(ActionEvent e) { 
			new Pomoc();
		    
		}
	  }
	  
  
 public static void main(String[] args) {
    JFrame f = new PlanszaS();
    f.setSize(400,350);
    f.setLocation(100,100);
    f.setVisible(true);
    
  }
} 

