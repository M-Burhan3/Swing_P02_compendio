/**
 * PanelPrincipal.java
   13 nov 2024 9:58:19
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelPrincipal.
 *
 * @author Burhan
 */
public class PanelPrincipal extends JPanel implements ActionListener {
	
	/** The imagen icon. */
	private ImageIcon imagenIcon;
	
	/** The imagen escalada. */
	private Image imagen, imagenEscalada;
	
	/** The label imagen 2. */
	private JLabel label, labelImagen1 , labelImagen2;
	
	/** The boton baja. */
	private JButton botonAlta, botonBaja;
	
	/** The panel botones. */
	private JPanel panelBotones;
	
	/** The ventana. */
	private JFrame ventana;
	
	
	public PanelPrincipal() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(190, 255, 251));
		this.setBorder(new EmptyBorder(40, 20, 20, 20));
		
		
		
		labelImagen1 = new JLabel(imagen("recursos/logoHotel.jpg", 200, 150));
		labelImagen1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
		
		labelImagen2 = new JLabel(imagen("recursos/nombre.png", 220, 75));
		
		
		label = new JLabel("Elija una de las siguientes opciones:");
		
		botonAlta = new JButton("Alta Reservas");
		botonAlta.setBackground(Color.GREEN);
		botonAlta.setPreferredSize(new Dimension(150, 35));
		botonAlta.setIcon(imagen("recursos/iconoNuevo.png", 25, 25));
		
		
		botonBaja = new JButton("Baja Reservas");
		botonBaja.setBackground(Color.RED);
		botonBaja.setPreferredSize(new Dimension(150, 35));
		botonBaja.setIcon(imagen("recursos/iconoEliminar.png", 20, 20));
		
		
		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(190, 255, 251));
		panelBotones.add(botonAlta);
		panelBotones.add(Box.createHorizontalStrut(20));
		panelBotones.add(botonBaja);
		
		
		
		// Centrar y añadir
		labelImagen1.setAlignmentX(CENTER_ALIGNMENT);
		labelImagen2.setAlignmentX(CENTER_ALIGNMENT);
		label.setAlignmentX(CENTER_ALIGNMENT);
		panelBotones.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(labelImagen1);
		this.add(labelImagen2);
		this.add(Box.createVerticalStrut(20));
		this.add(label);
		this.add(Box.createVerticalStrut(10));
		this.add(panelBotones);
		
		
		// Eventos
		botonAlta.addActionListener(this);
		botonBaja.addActionListener(this);
	}
	
	
	
	
	//-------------------------------------------------------------------------------------------------------
	public ImageIcon imagen(String ruta, int ancho, int alto) {
		imagen = new ImageIcon(getClass().getResource(ruta)).getImage();

		imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		imagenIcon = new ImageIcon(imagenEscalada);
		
		return imagenIcon;
	}
	
	//-------------------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botonAlta) {
			VentanaDialogo ventanaDialogo = new VentanaDialogo(ventana);
		}
		
		if (e.getSource() == botonBaja) {
			JOptionPane.showMessageDialog(null, "La opción de eliminar reservas no está disponible todiavía, espere a la próxima actualización", "Opción No Disponible", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
