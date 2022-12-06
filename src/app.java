

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class app implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	private JTextField cuadro;
	private String texto = "";
	private double dou1;
	private double dou2;
	private double resultado;
	private boolean operando = false;
	private boolean error = false;
	private int contPunt;  //CUENTA EL NUMERO DE COMAS PARA QUE NO SE INTRODUZCAN MÁS DE UNA
	private String operacion;
	private JButton bInicio, bBorrar, bPorc, bDiv, bMult, bSum, bRest, bIgual, bPunt, bPot;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;


	public app() {
		Frame();
		Panel();
		Botones();

	}


	private void Frame() {
		frame = new JFrame();
		frame.setTitle("Calculadora Mario");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setBounds(600, 200, 406, 512);
		frame.setFocusable(true); //Para que se implemente bien el Actionlistener y KeyListener
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//REDONDEAR BORDES
		/*Shape forma = new RoundRectangle2D.Double(0, 0, frame.getBounds().width, frame.getBounds().height, 30, 30);
		frame.setShape(forma);
		 */
	}

	private void Panel() {
		panel = new JPanel();
		panel.setBounds(0, 0, 392, 475);
		panel.setBackground(Color.DARK_GRAY);
		//panel.setBackground(new Color(255, 128, 0));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		frame.getContentPane().add(panel);


	}

	private void Botones() {

		cuadro = new JTextField("0");
		cuadro.setFont(new Font("Courier New", Font.BOLD, 30));
		cuadro.setHorizontalAlignment(SwingConstants.RIGHT);
		cuadro.setBounds(26, 36, 341, 70);
		cuadro.setColumns(10);
		cuadro.setEditable(false);
		cuadro.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(cuadro);

		bInicio = new JButton("C");
		bInicio.setForeground(Color.WHITE);
		bInicio.setBackground(new Color(194, 18, 49));
		bInicio.setBounds(26, 138, 79, 55);
		bInicio.setFont(new Font("Courier New", Font.BOLD, 30));
		bInicio.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bInicio.addActionListener(this);
		panel.add(bInicio);

		bBorrar = new JButton("<-");
		bBorrar.setBackground(new Color(106, 90, 205));
		bBorrar.setBounds(113, 138, 79, 55);
		bBorrar.setFont(new Font("Courier New", Font.BOLD, 30));
		bBorrar.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bBorrar.addActionListener(this);
		panel.add(bBorrar);

		bIgual = new JButton("=");
		bIgual.setBackground(new Color(106, 90, 205));
		bIgual.setBounds(287, 398, 79, 55);
		bIgual.setFont(new Font("Courier New", Font.BOLD, 30));
		bIgual.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bIgual.addActionListener(this);
		panel.add(bIgual);

		bPunt = new JButton(".");
		bPunt.setBackground(new Color(106, 90, 205));
		bPunt.setBounds(200, 398, 79, 55);
		bPunt.setFont(new Font("Courier New", Font.BOLD, 30));
		bPunt.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bPunt.addActionListener(this);
		panel.add(bPunt);

		bPot = new JButton("X²");
		bPot.setBackground(new Color(106, 90, 205));
		bPot.setBounds(26, 398, 79, 55);
		bPot.setFont(new Font("Courier New", Font.BOLD, 30));
		bPot.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bPot.addActionListener(this);
		panel.add(bPot);

		bPorc = new JButton("%");
		bPorc.setBackground(new Color(106, 90, 205));
		bPorc.setBounds(200, 138, 79, 55);
		bPorc.setFont(new Font("Courier New", Font.BOLD, 30));
		bPorc.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bPorc.addActionListener(this);
		panel.add(bPorc);

		bDiv = new JButton("/");
		bDiv.setBackground(new Color(106, 90, 205));
		bDiv.setBounds(287, 138, 79, 55);
		bDiv.setFont(new Font("Courier New", Font.BOLD, 30));
		bDiv.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bDiv.addActionListener(this);
		panel.add(bDiv);

		bMult = new JButton("X");
		bMult.setBackground(new Color(106, 90, 205));
		bMult.setBounds(287, 203, 79, 55);
		bMult.setFont(new Font("Courier New", Font.BOLD, 30));
		bMult.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bMult.addActionListener(this);
		panel.add(bMult);

		bSum = new JButton("+");
		bSum.setBackground(new Color(106, 90, 205));
		bSum.setBounds(287, 333, 79, 55);
		bSum.setFont(new Font("Courier New", Font.BOLD, 30));
		bSum.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bSum.addActionListener(this);
		panel.add(bSum);

		bRest = new JButton("-");
		bRest.setBackground(new Color(106, 90, 205));
		bRest.setBounds(287, 268, 79, 55);
		bRest.setFont(new Font("Courier New", Font.BOLD, 30));
		bRest.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		bRest.addActionListener(this);
		panel.add(bRest);

		b0 = new JButton("0");
		b0.setBackground(new Color(255, 255, 255));
		b0.setBounds(113, 398, 79, 55);
		b0.setFont(new Font("Courier New", Font.BOLD, 30));
		b0.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b0.addActionListener(this);
		panel.add(b0);

		b1 = new JButton("1");
		b1.setBackground(new Color(255, 255, 255));
		b1.setBounds(26, 333, 79, 55);
		b1.setFont(new Font("Courier New", Font.BOLD, 30));
		b1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b1.addActionListener(this);
		panel.add(b1);

		b2 = new JButton("2");
		b2.setBackground(new Color(255, 255, 255));
		b2.setBounds(113, 333, 79, 55);
		b2.setFont(new Font("Courier New", Font.BOLD, 30));
		b2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b2.addActionListener(this);
		panel.add(b2);

		b3 = new JButton("3");
		b3.setBackground(new Color(255, 255, 255));
		b3.setBounds(200, 333, 79, 55);
		b3.setFont(new Font("Courier New", Font.BOLD, 30));
		b3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b3.addActionListener(this);
		panel.add(b3);

		b4 = new JButton("4");
		b4.setBackground(new Color(255, 255, 255));
		b4.setBounds(26, 268, 79, 55);
		b4.setFont(new Font("Courier New", Font.BOLD, 30));
		b4.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b4.addActionListener(this);
		panel.add(b4);

		b5 = new JButton("5");
		b5.setBackground(new Color(255, 255, 255));
		b5.setBounds(113, 268, 79, 55);
		b5.setFont(new Font("Courier New", Font.BOLD, 30));
		b5.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b5.addActionListener(this);
		panel.add(b5);

		b6 = new JButton("6");
		b6.setBackground(new Color(255, 255, 255));
		b6.setBounds(200, 268, 79, 55);
		b6.setFont(new Font("Courier New", Font.BOLD, 30));
		b6.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b6.addActionListener(this);
		panel.add(b6);

		b7 = new JButton("7");
		b7.setBackground(new Color(255, 255, 255));
		b7.setBounds(26, 203, 79, 55);
		b7.setFont(new Font("Courier New", Font.BOLD, 30));
		b7.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b7.addActionListener(this);
		panel.add(b7);

		b8 = new JButton("8");
		b8.setBackground(new Color(255, 255, 255));
		b8.setBounds(113, 203, 79, 55);
		b8.setFont(new Font("Courier New", Font.BOLD, 30));
		b8.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b8.addActionListener(this);
		panel.add(b8);

		b9 = new JButton("9");
		b9.setBackground(new Color(255, 255, 255));
		b9.setBounds(200, 203, 79, 55);
		b9.setFont(new Font("Courier New", Font.BOLD, 30));
		b9.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		b9.addActionListener(this);
		panel.add(b9);

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==bInicio) {
			contPunt=0;
			error=false;
			texto="";
			cuadro.setText("0");
			operando=false; // reiniciamos cada vez que pongamos a 0 la calculadora

		}

		if(error==false) {
			//-----------------------NUMEROS-------------------
			if(e.getSource()==b0) {
				if(!cuadro.getText().equalsIgnoreCase("0")) {
					texto+="0";
					cuadro.setText(texto);

				}
				else {
					texto="";
					cuadro.setText("0");

				}

			}
			if(e.getSource()==b1) {
				texto+="1";
				cuadro.setText(texto);

			}
			if(e.getSource()==b2) {
				texto+="2";
				cuadro.setText(texto);

			}
			if(e.getSource()==b3) {
				texto+="3";
				cuadro.setText(texto);

			}
			if(e.getSource()==b4) {
				texto+="4";
				cuadro.setText(texto);

			}
			if(e.getSource()==b5) {
				texto+="5";
				cuadro.setText(texto);

			}
			if(e.getSource()==b6) {
				texto+="6";
				cuadro.setText(texto);

			}
			if(e.getSource()==b7) {
				texto+="7";
				cuadro.setText(texto);

			}
			if(e.getSource()==b8) {
				texto+="8";
				cuadro.setText(texto);

			}
			if(e.getSource()==b9) {
				texto+="9";
				cuadro.setText(texto);

			}
			if(e.getSource()==bPunt) {
				if(cuadro.getText().equalsIgnoreCase("0")) {
					texto+="0.";

				}
				else {
					texto+=".";

				}
				cuadro.setText(texto);
				contPunt++; //INCREMENTAMOS EL CONTADOR DE PUNTOS PARA QUE NO HAYA MÁS DE UNO

			}

			//-----------------------FUNCIONALIDADES-------------------



			if(e.getSource()==bBorrar && (cuadro.getText().length()>1) ) {
				cuadro.setText(cuadro.getText().substring(0, cuadro.getText().length()-1));

			}
			else if (e.getSource()==bBorrar && (cuadro.getText().length()==1)) { 

				texto="";
				cuadro.setText("0");
			}



			if(e.getSource()==bRest && texto.equalsIgnoreCase("")) {//PARA PODER METER NUMEROS NEGATIVOS
				texto+="-";
			}

			if(e.getSource()==bIgual && operando==true) {
				resultado();
				texto = Double.toString(resultado);
				cuadro.setText(texto);
				resultado=0; //REINICIAMOS EL RESULTADO

			}

			//-----------------------OPERACIONES-------------------

			if(e.getSource()==bPot) {
				cuadrado();
			}
			if(e.getSource()==bSum) {
				contPunt=0;
				sumar();
			}
			if(e.getSource()==bMult) {
				contPunt=0;
				multiplicar();
			}
			if(e.getSource()==bRest && !cuadro.getText().equalsIgnoreCase("0")) {
				contPunt=0;
				restar();
			}
			if(e.getSource()==bDiv) {
				contPunt=0;
				dividir();
			}
			if(e.getSource()==bPorc) {
				contPunt=0;
				porcentaje();
			}

		}

		else {
			cuadro.setText("ERROR");
		}

		errores();  //COMPRUEBA LOS ERRORES

	}


	//-------------FUNCIONES DE OPERACION-------------//

	public void cuadrado() {
		dou1=Double.parseDouble(texto);
		resultado = dou1*dou1;
		cuadro.setText(Double.toString(resultado));

	}

	public void sumar() { 		//SE COGE EL TEXTO QUE HAY EN EL CUADRO, SE PONE EL BOOLEANO EN TRUE PARA OPERAR. SE DEFINE LA OPERACIÓN A REALIZAR
		texto=cuadro.getText(); //SE INTRODUCE EL TEXTO EN VARIABLE DOUBLE PARA OPERAR CON ELLO Y SE REINICIA EL CUADRO A 0 PARA INTRODUCIR EL SIGUIENTE OPERADOR.
		operando=true;
		operacion = "sumar";
		dou1=Double.parseDouble(texto);
		texto="";
		cuadro.setText("0");
	}

	public void restar() {
		texto=cuadro.getText();
		operando=true;
		operacion = "restar";
		dou1=Double.parseDouble(texto);
		texto="";
		cuadro.setText("0");
	}

	public void multiplicar() {
		texto=cuadro.getText();
		operando=true;
		operacion = "multiplicar";
		dou1=Double.parseDouble(texto);
		texto="";
		cuadro.setText("0");
	}

	public void dividir() {
		texto=cuadro.getText();
		operando=true;
		operacion = "dividir";
		dou1=Double.parseDouble(texto);
		texto="";
		cuadro.setText("0");
	}

	public void porcentaje() {
		texto=cuadro.getText();
		operando=true;
		operacion = "porcentaje";
		dou1=Double.parseDouble(texto);
		texto="";
		cuadro.setText("0");
	}

	//------------FUNCION RESULTADO-----------//

	public void resultado() {

		if(operacion.equalsIgnoreCase("sumar")&& operando==true) {  //SE COGE EL TEXTO COMO SEGUNDO OPERADOR, SE REALIZA LA OPERACION Y SE INTRODUCE COMO RESULTADO.
			dou2= Double.parseDouble(texto);
			resultado = dou1+dou2;
		}

		if(operacion.equalsIgnoreCase("multiplicar")&& operando==true) {
			dou2= Double.parseDouble(texto);
			resultado = dou1*dou2;

		}
		if(operacion.equalsIgnoreCase("restar")&& operando==true) {
			dou2= Double.parseDouble(texto);
			resultado = dou1-dou2;

		}
		if(operacion.equalsIgnoreCase("dividir")&& operando==true) {
			dou2= Double.parseDouble(texto);
			resultado = dou1/dou2;

		}
		if(operacion.equalsIgnoreCase("porcentaje")&& operando==true) {
			dou2= Double.parseDouble(texto);
			resultado = (dou1*dou2)/100;

		}


	}

	public void errores() { //FUNCIONES QUE NO TENGAN QUE VER CON BOTONES NI OPERACIONES

		if(cuadro.getText().length()>=18) { //PARA CUANDO SE PASE DE LONGITUD
			error=true;
			texto="0";
		}

		if(contPunt > 1) { //PARA QUE NO PERMITA INTRODUCIR MAS DE UN PUNTO
			error=true;
		}
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}

