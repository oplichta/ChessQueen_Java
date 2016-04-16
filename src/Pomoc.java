import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pomoc extends JFrame{
JTextArea tekst = new JTextArea("Wyobraźmy sobie, że przedstawiona na rysunku pokratkowana figura to akwen z siedmioma wyspami (czarne pola z cyframi). Na każdej wyspie jest latarnia morska, oświetlająca tylko wszystkie pola w rzędzie i kolumnie, na przecięciu których się znajduje. Na dwunastu polach akwenu zakotwiczonych jest dwanaście statków, a każdy statek oświetlony jest przez co najmniej jedną latarnię. Liczba na danej wyspie wskazuje, ile statków oświetla znajdująca się na niej latarnia. Należy oznaczyć pola akwenu, na których znajdują się statki.",35,35);
Pomoc(){
setSize(400,400);
setTitle("Pomoc do Latarnii morskich");
JPanel panel = new JPanel();
JButton zamknij = new JButton("Zamknij");
panel.add(zamknij);
zamknij.addActionListener(new PomocZamknij());
panel.add(tekst);
tekst.setLineWrap(true);
tekst.setWrapStyleWord(true);
add(panel);
setLocation(300,300);
setVisible(true);

}




class PomocZamknij implements ActionListener{
public void actionPerformed(ActionEvent e){
setVisible(false);
}
}
}