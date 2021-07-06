import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
/**
 *
 * @author Holger Edud Angulo Castillo
 * @version 1.0.0.1
 */
public class Parkland extends JFrame{
 
 //atributos
 private JPanel CP, cp1;
 private JMenuBar menuBar;
 private JMenu menuOpciones;
 private JMenuItem itemAyuda,itemSalir,itemLimpiar,itemVersion;
 private JLabel titulo,nombre,quemadura,peso,copy;
 private JTextField nom,quem,pes;
 private JButton btn;
 public JTextArea area;
 public Color Black,White,Grey;
 private String nombreX;
 private final int const20;
 private final int const40;
 private final int const4;
 private int resultado;
 public Image myIcon;
 private String texto;
 /**  */
 public Parkland(){
 setUndecorated(true);
 setResizable(false);
 setBounds(0,0,370,400);
 setLocationRelativeTo(null);
 setVisible(true);
 Black=new Color(0,0,0);
 White=new Color(255,255,255);
 Grey=new Color(125,125,125);
 nombreX="X";
 const20=20;
 const40=40;
 const4=4;
 myIcon=Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/fuego.png"));
 setIconImage(myIcon);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 texto="\nPara que la formula de Parkland se haga efectiva el peso\n"
       +"del paciente debe ser mayor a 40 kg y el grado de\n"
       +"quemadura debe ser mayor a 20% de lo contrario el\n"
       +"calculo no funcionara\n\n"
       +"La formula PARKLAND es una formula utilizada para\n"
       +"estimar la cantidad de fluido de reposicion requerida\n"
       +"para las 24 horas en un paciente que presenta\n"
       +"quemaduras a fin de garantizar que permanezca\n"
       +"hemodinamicamente estable.\n\n"
       +"Dudas y comentarios: holgereduardo777@gmail.com\n"
       +"\u00a9 todos los derechos reservados.\n";
        
 /**/
 initComponent();
 }
 
 //metodo para iniciar los componentes
 private void initComponent(){
    
 menuBar=new JMenuBar();setJMenuBar(menuBar);menuBar.setBackground(Black);
 menuOpciones=new JMenu();menuOpciones.setText("OPCIONES");menuOpciones.setForeground(White);
 menuBar.add(menuOpciones);
 itemAyuda=new JMenuItem("Ayuda ?");menuOpciones.add(itemAyuda);
 itemLimpiar=new JMenuItem("Limpiar");menuOpciones.add(itemLimpiar);
 itemVersion=new JMenuItem("Version");menuOpciones.add(itemVersion);
 itemSalir=new JMenuItem("Salir");menuOpciones.add(itemSalir);

 //Agregar eventos a los Menus Items
 itemAyuda.addActionListener(miEvento);itemSalir.addActionListener(miEvento);
 itemVersion.addActionListener(miEvento); itemLimpiar.addActionListener(miEvento);
 
 CP=new JPanel();CP.setLayout(null);CP.setBackground(Black); getContentPane ().add(CP);
 cp1=new JPanel();cp1.setBackground(Black);cp1.setSize(370,50);
 CP.add(cp1);
 titulo=new JLabel("PARKLAND");cp1.add(titulo);
 titulo.setFont(new Font("arial",1,30));
 titulo.setForeground(White);

 //labels y textFields
 nombre=new JLabel("nombre del paciente:");nombre.setBounds(10,70,120,20);
 nombre.setForeground(White);
 CP.add(nombre);
 nom=new JTextField();nom.setBounds(10,90,120,30);CP.add(nom);
 quemadura=new JLabel("% de quemadura");quemadura.setBounds(10,130,120,30);
 quemadura.setForeground(White);CP.add(quemadura);
 quem=new JTextField();quem.setBounds(10,160,120,30);CP.add(quem);
 peso=new JLabel("peso del paciente(kg)");peso.setBounds(10,200,140,30);
 peso.setForeground(White);CP.add (peso);
 pes=new JTextField();pes.setBounds(10,230,120,30);CP.add(pes);
 //JTextArea
 area=new JTextArea();area.setBounds(140,80,200,220);area.setEditable(false);CP.add(area);
 //boton
 btn=new JButton("Calcular");btn.setBounds(10,270,120,30);CP.add(btn);
 btn.addActionListener(miEvento);
 
 //copy right
 copy=new JLabel("\u00a9 Todos los derechos Reservados");copy.setBounds(90,320,200,30);
/* copy.setOpaque(true);copy.setBackground(White);*/
 copy.setForeground(Grey);CP.add(copy);
 
 }
 //eventos
 ActionListener miEvento = new ActionListener(){
 @Override
 public void actionPerformed(ActionEvent e){ 
 String nombreP=nom.getText();String quemaduraP=quem.getText();
 String pesoP=pes.getText();
 if(e.getSource()==itemAyuda){ JOptionPane.showMessageDialog(CP, texto,"IMPORTANTE",-1);}
 if(e.getSource()==itemSalir){ System.exit(0);}
 if(e.getSource()==itemVersion){ JOptionPane.showMessageDialog(CP,"Version del Programa:\n"
 +"1.0.0.1\n04-jul-2021","VERSION DEL PROGRAMA",-1);}
 if (e.getSource()==itemLimpiar) { nom.setText("");quem.setText("");pes.setText("");area.setText("");}
 if (e.getSource()==btn) {
     if(nombreP.equals("")==true){ nombreP=nombreX;}
     if(quemaduraP.equals("")==true || pesoP.equals("")==true){JOptionPane.showMessageDialog(CP, "Debes llenar los dos campos mas inportantes\n"
     +"% de quemadura y peso (kg) del paciente.","Faltan Datos Por Llenar",2);}else{
         //variables para las formulas aritmetica
         int q=Integer.parseInt(quemaduraP);int p=Integer.parseInt(pesoP);
         int res1=q * p; int res2=res1/const4;resultado=res2;
         if(q < const20 || p < const40){ JOptionPane.showMessageDialog(CP, "Para que la Formula de Parklan pueda funcionar\n"
         +"el peso del paciente debe ser mayor a 40 kg.\ny la quemadura del paciente debe ser\nmayor a 20%","Verifica los datos",2);}else{ area.setText("\n  Pasiente: "+nombreP.toUpperCase()+
         "\n  % de quemadura: "+quemaduraP+" %\n  Suministrar al paciente "+resultado+" ml de\n  solucion salina\n  durante las 24/h");}


     }

     
 }

 }

 };
 
 //metodo main
 public static void main(String args[]){
 Parkland parkland=new Parkland();
 parkland.setTitle("FORMULA DE PARKLAND");
 }
 

}