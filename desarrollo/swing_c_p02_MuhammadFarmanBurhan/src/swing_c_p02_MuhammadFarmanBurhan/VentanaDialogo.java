/**
 * VentanaDialogo.java
   13 nov 2024 20:29:16
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaDialogo.
 *
 * @author Burhan
 */
public class VentanaDialogo extends JDialog {
	
	/** The p dialogo 1. */
	private PanelDialogo1 pDialogo1;
	
	/** The p dialogo 2. */
	private PanelDialogo2 pDialogo2;
	
	/** The p dialogo 3. */
	private PanelDialogo3 pDialogo3;
	
	/** The p dialogo 4. */
	private PanelDialogo4 pDialogo4;
	
	/** The contenedor. */
	private JPanel contenedor;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	public VentanaDialogo(JFrame parent) {
		
		super(parent, "Alta Reservas", true); 
		this.setSize(new Dimension(700, 650));
		setLocationRelativeTo(null);
		
		
		// Icono
		Image icono = new ImageIcon(getClass().getResource("recursos/iconoVentana.png")).getImage();
		this.setIconImage(icono);
		
		
		contenedor = new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
		
		
		pDialogo1 = new PanelDialogo1();
		this.add(pDialogo1, BorderLayout.NORTH);
		
		pDialogo2 = new PanelDialogo2(null);
		pDialogo2.setBorder(new TitledBorder(new LineBorder(Color.RED, 3), "Datos del Cliente", TitledBorder.LEFT, TitledBorder.TOP));
		contenedor.add(pDialogo2);
		
		pDialogo3 = new PanelDialogo3(pDialogo2);
		pDialogo3.setBorder(new TitledBorder(new LineBorder(new Color(162, 20, 220), 3), "Datos de la Habitación", TitledBorder.LEFT, TitledBorder.TOP));
		contenedor.add(pDialogo3);
		
		
		// He creado un metodo en PanelDialogo2 que inicializa el pDialogo3 que le paso aqui
		// Hago esto porque si le paso antes el pDialogo3 en "pDialogo2 = new PanelDialogo2(null);" como pDialogo3 aun no está instanciado da error
		// por eso le paso primero null al constructor de pDialogo2 y luego con este método lo instancio
		pDialogo2.setPanelDialogo3(pDialogo3);
		
		
		pDialogo4 = new PanelDialogo4(pDialogo2, pDialogo3);
		pDialogo4.setBorder(new TitledBorder(new LineBorder(Color.ORANGE, 3), "Guardar e Imprimir", TitledBorder.LEFT, TitledBorder.TOP));
		contenedor.add(pDialogo4);
		
		
		
		
		this.add(contenedor);
		
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
	    getContentPane().add(scrollPane);
	    scrollPane.setViewportView(contenedor);
		
		
		this.setVisible(true);
	}

	
	
	
	public PanelDialogo2 getpDialogo2() {
		return pDialogo2;
	}

	public PanelDialogo3 getpDialogo3() {
		return pDialogo3;
	}
	
	
	
	

}
