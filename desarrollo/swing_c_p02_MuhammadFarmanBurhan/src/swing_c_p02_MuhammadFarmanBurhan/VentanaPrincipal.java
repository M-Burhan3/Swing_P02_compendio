/**
 * Ventana.java
   13 nov 2024 9:28:36
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaPrincipal.
 *
 * @author Burhan
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
	
	/** The menu. */
	private JMenuBar menu;
	
	/** The ayuda. */
	private JMenu archivo, registro, ayuda;
	
	/** The acerca de. */
	private JMenuItem salir, altaReservas, bajaReservas, acercaDe;
	
	/** The panel principal. */
	private PanelPrincipal panelPrincipal;
	
	public VentanaPrincipal() {
		super("Gestión Hotel Blue Summer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 450));
		setLocationRelativeTo(null);
		
		
		iniciarMenu();
		
		panelPrincipal = new PanelPrincipal();
		this.add(panelPrincipal);
		
		
		this.setVisible(true);
	}
	
	
	private void iniciarMenu() {
		
		menu = new JMenuBar();
		
		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		ayuda = new JMenu("Ayuda");
		
		salir = new JMenuItem("Salir");
		altaReservas = new JMenuItem("Alta Reservas");
		bajaReservas = new JMenuItem("Baja Reservas");
		acercaDe = new JMenuItem("Acerca de ...");
		
		
		
		// Añadir
		menu.add(archivo);
		menu.add(registro);
		menu.add(ayuda);
		
		archivo.add(salir);
		registro.add(altaReservas);
		registro.add(bajaReservas);
		ayuda.add(acercaDe);
		
		// Atajos
		registro.setMnemonic(KeyEvent.VK_R);
		altaReservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.SHIFT_DOWN_MASK));
		bajaReservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.SHIFT_DOWN_MASK));
		
		
		// Icono
		Image icono = new ImageIcon(getClass().getResource("recursos/iconoVentana.png")).getImage();
		this.setIconImage(icono);
		
		
		this.setJMenuBar(menu);
		
		
		// Eventos
		salir.addActionListener(this);
		altaReservas.addActionListener(this);
		bajaReservas.addActionListener(this);
		acercaDe.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == salir) {
			System.exit(0);
		}
		
		if (e.getSource() == altaReservas) {
			VentanaDialogo ventanaDialogo = new VentanaDialogo(this);
		}

		if (e.getSource() == bajaReservas) {
			JOptionPane.showMessageDialog(null, "La opción de eliminar reservas no está disponible todiavía, espere a la próxima actualización", "Opción No Disponible", JOptionPane.INFORMATION_MESSAGE);
		}

		if (e.getSource() == acercaDe) {
			JOptionPane.showMessageDialog(null, "Empresa: BLUE SUMMER HOTEL \n Autor: Burhan Muhammad Farman \n Programa dedicado al manejo de registros del hotel. \n Version: 1.0 \n \n Más información en: www.bluesummerhotel.es", "Opción No Disponible", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	

}
