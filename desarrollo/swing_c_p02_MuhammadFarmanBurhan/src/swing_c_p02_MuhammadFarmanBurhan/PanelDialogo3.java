/**
 * PanelDialogo3.java
   14 nov 2024 20:33:15
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelDialogo3.
 *
 * @author Burhan
 */
public class PanelDialogo3 extends JPanel implements ActionListener, ChangeListener {
	
	/** The label imagen. */
	private JLabel label1, label2, label3, labelFlecha, label4, label5, labelImagen;
	
	/** The lista habitaciones. */
	private JComboBox<String> listaHabitaciones;
	
	/** The edad. */
	private JSpinner numHabitaciones, edad;
	
	/** The modelo spinner 2. */
	private SpinnerNumberModel modeloSpinner1, modeloSpinner2;
	
	/** The check. */
	private JCheckBox check;
	
	/** The panel imagenes. */
	private JPanel panelHabitaciones, panelExtras, panelPrecio, panelImagenes;
	
	/** The area de texto. */
	private JTextArea areaDeTexto;
	
	/** The precio. */
	private JTextField precio;
	
	/** The boton der. */
	private JButton consultarPrecios, botonIzq, botonDer;
	
	/** The p dialogo 2. */
	private PanelDialogo2 pDialogo2;
	
	/** The fotos simple. */
	String[] fotosSimple = {"recursos/fotoSimple1.jpg", "recursos/fotoSimple2.jpg", "recursos/fotoSimple3.jpg", "recursos/fotoSimple4.jpg"};
	
	/** The fotos double. */
	String[] fotosDouble = {"recursos/fotoDouble1.jpg", "recursos/fotoDouble2.jpg", "recursos/fotoDouble3.jpg", "recursos/fotoDouble4.jpg"};
	
	/** The fotos suite. */
	String[] fotosSuite = {"recursos/fotoSuite1.jpg", "recursos/fotoSuite2.jpg", "recursos/fotoSuite3.jpg", "recursos/fotoSuite4.jpg"};
	
	/** The posicion botones. */
	int posicionBotones = 1;
	
	
	public PanelDialogo3(PanelDialogo2 pDialogo2) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(190, 255, 251));
		
		panelHabitaciones = new JPanel(new GridLayout(3, 2, 0, 10));
		panelHabitaciones.setBackground(new Color(190, 255, 251));
		
		
		label1 = new JLabel("Tipo de Habitación: ");
		label1.setForeground(new Color(162, 20, 220));
		label2 = new JLabel("Número de Habitación:  ");
		label2.setForeground(new Color(162, 20, 220));
		
		
		String[] opciones = {"Simple", "Double", "Suite"};
		listaHabitaciones = new JComboBox<String>(opciones);
		listaHabitaciones.setBackground(Color.WHITE);
		
		modeloSpinner1 = new SpinnerNumberModel(1, 1, 50, 1);
		numHabitaciones = new JSpinner(modeloSpinner1);
		
		check = new JCheckBox("¿Niños?");
		check.setForeground(new Color(162, 20, 220));
		check.setBackground(new Color(190, 255, 251));
		
		
		panelExtras = new JPanel();
		panelExtras.setBackground(new Color(190, 255, 251));
		
		modeloSpinner2 = new SpinnerNumberModel(0, 0, 14, 1);
		edad = new JSpinner(modeloSpinner2);
		edad.setEnabled(false);
		label3 = new JLabel("Edad: ");
		label3.setForeground(new Color(162, 20, 220));
		
		areaDeTexto = new JTextArea("--------------------");
		areaDeTexto.setPreferredSize(new Dimension(250, 20));
		areaDeTexto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
		areaDeTexto.setBackground(new Color(238, 238, 238));
		areaDeTexto.setEditable(false);
		
		labelFlecha = new JLabel("---->");
		labelFlecha.setForeground(new Color(162, 20, 220));
		
		
		this.pDialogo2 = pDialogo2;
		panelPrecio = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelPrecio.setBackground(new Color(190, 255, 251));
		
		label4 = new JLabel("Importe Habitación: ");
		label4.setForeground(new Color(162, 20, 220));
		precio = new JTextField();
		precio.setHorizontalAlignment(JTextField.RIGHT);
		precio.setPreferredSize(new Dimension(50, 30));
		
		
		mostrarPrecioCalculado();
		
		
		panelImagenes = new JPanel();
		panelImagenes.setBackground(new Color(190, 255, 251));
		botonIzq = new JButton("<");
		botonIzq.setEnabled(false);
		labelImagen = new JLabel(imagen("recursos/fotoSimple1.jpg", 450, 250));
		labelImagen.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
		botonDer = new JButton(">");
		
		
		
		
		this.add(Box.createVerticalStrut(20));
		panelHabitaciones.add(label1);
		panelHabitaciones.add(listaHabitaciones);
		panelHabitaciones.add(label2);
		panelHabitaciones.add(numHabitaciones);
		panelHabitaciones.add(check);
		this.add(panelHabitaciones);
		panelExtras.add(label3);
		panelExtras.add(edad);
		panelExtras.add(labelFlecha);
		//panelExtras.add(Box.createHorizontalStrut(50));
		panelExtras.add(areaDeTexto);
		this.add(panelExtras);
		this.add(Box.createVerticalStrut(25));
		panelPrecio.add(label4);
		panelPrecio.add(precio);
		//panelPrecio.add(consultarPrecios);
		this.add(panelPrecio);
		this.add(Box.createVerticalStrut(25));
		panelImagenes.add(botonIzq);
		panelImagenes.add(labelImagen);
		panelImagenes.add(botonDer);
		this.add(panelImagenes);
		
		
		// Eventos
		check.addActionListener(this);
		edad.addChangeListener(this);
		listaHabitaciones.addActionListener(this);
		botonIzq.addActionListener(this);
		botonDer.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == check) {
			if (check.isSelected()) {
				edad.setEnabled(true);
				areaDeTexto.setText("Edad[0-3] --> Cuna");
				areaDeTexto.setBackground(Color.WHITE);
			} else {
				edad.setValue(0);
				edad.setEnabled(false);
				areaDeTexto.setText("--------------------");
				areaDeTexto.setBackground(new Color(238, 238, 238));
			}
			
		}
		
		mostrarPrecioCalculado();
		
		
		
		if (e.getSource() == listaHabitaciones) {
			if (listaHabitaciones.getSelectedItem() == "Simple") {
				labelImagen.setIcon(imagen("recursos/fotoSimple1.jpg", 450, 250));
				posicionBotones = 1;
			}
			if (listaHabitaciones.getSelectedItem() == "Double") {
				labelImagen.setIcon(imagen("recursos/fotoDouble1.jpg", 450, 250));
				posicionBotones = 1;
			}
			if (listaHabitaciones.getSelectedItem() == "Suite") {
				labelImagen.setIcon(imagen("recursos/fotoSuite1.jpg", 450, 250));
				posicionBotones = 1;
			}
		}
		
		
		
		
		if (listaHabitaciones.getSelectedItem() == "Simple") {
			if (e.getSource() == botonDer) {
				posicionBotones++;
				labelImagen.setIcon(imagen("recursos/fotoSimple" + posicionBotones + ".jpg", 450, 250));
			}
			if (e.getSource() == botonIzq) {
				posicionBotones--;
				labelImagen.setIcon(imagen("recursos/fotoSimple" + posicionBotones + ".jpg", 450, 250));
			}
		}
		
		if (listaHabitaciones.getSelectedItem() == "Double") {
			if (e.getSource() == botonDer) {
				posicionBotones++;
				labelImagen.setIcon(imagen("recursos/fotoDouble" + posicionBotones + ".jpg", 450, 250));
			}
			if (e.getSource() == botonIzq) {
				posicionBotones--;
				labelImagen.setIcon(imagen("recursos/fotoDouble" + posicionBotones + ".jpg", 450, 250));
			}
		}
		
		if (listaHabitaciones.getSelectedItem() == "Suite") {
			if (e.getSource() == botonDer) {
				posicionBotones++;
				labelImagen.setIcon(imagen("recursos/fotoSuite" + posicionBotones + ".jpg", 450, 250));
			}
			if (e.getSource() == botonIzq) {
				posicionBotones--;
				labelImagen.setIcon(imagen("recursos/fotoSuite" + posicionBotones + ".jpg", 450, 250));
			}
		}
		
		
		
		if (posicionBotones == 1) {
			botonIzq.setEnabled(false);
			botonDer.setEnabled(true);
		}
		if (posicionBotones > 1 && posicionBotones < 4) {
			botonIzq.setEnabled(true);
			botonDer.setEnabled(true);
		}
		if (posicionBotones == 4) {
			botonIzq.setEnabled(true);
			botonDer.setEnabled(false);
		}
		
		
		
	}

	public void stateChanged(ChangeEvent e) {
		
		if ((int)edad.getValue() >= 0 && (int)edad.getValue() <= 3) {
			areaDeTexto.setText("Edad[0-3] --> Cuna");
		}
		
		if ((int)edad.getValue() >= 4 && (int)edad.getValue() <= 10) {
			areaDeTexto.setText("Edad[4-10] --> Cama Supletoria Pequeña");
		}
		
		if ((int)edad.getValue() >= 11 && (int)edad.getValue() <= 14) {
			areaDeTexto.setText("Edad[11-14] --> Cama Supletoria Normal");
		}
		
	}
	
	public void mostrarPrecioCalculado() {
		int precioHabitacion = 0, precioCSupletoria = 0, numDias = 0, precioTotal = 0;
		
		if (listaHabitaciones.getSelectedItem() == "Simple") {
			precioHabitacion = 50;
		}
		if (listaHabitaciones.getSelectedItem() == "Double") {
			precioHabitacion = 75;
		}
		if (listaHabitaciones.getSelectedItem() == "Suite") {
			precioHabitacion = 125;
		}
		
		if (check.isSelected()) {
			precioCSupletoria = 20;
		} else {
			precioCSupletoria = 0;
		}
		
		numDias = Integer.parseInt(pDialogo2.getCampoDiasEstancia().getText().substring(0, 2).trim());
		
		precioTotal = (precioHabitacion + precioCSupletoria) * numDias;
		
		
		precio.setText(precioTotal + "€");
	}
	
	
	
	
	
	
	
	
	
	// Getters
	
	/**
	 * Gets the lista habitaciones.
	 *
	 * @return the lista habitaciones
	 */
	public JComboBox<String> getListaHabitaciones() {
		return listaHabitaciones;
	}
	
	/**
	 * Gets the num habitaciones.
	 *
	 * @return the num habitaciones
	 */
	public JSpinner getNumHabitaciones() {
		return numHabitaciones;
	}
	
	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public JSpinner getEdad() {
		return edad;
	}
	
	/**
	 * Gets the check.
	 *
	 * @return the check
	 */
	public JCheckBox getCheck() {
		return check;
	}
	
	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public JTextField getPrecio() {
		return precio;
	}
	
	/**
	 * Gets the area de texto.
	 *
	 * @return the area de texto
	 */
	public JTextArea getAreaDeTexto() {
		return areaDeTexto;
	}
	
	
	
	

	// -------------------------------------------------------------------------------------------------------
	public ImageIcon imagen(String ruta, int ancho, int alto) {
		Image imagen = new ImageIcon(getClass().getResource(ruta)).getImage();

		Image imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		ImageIcon imagenIcon = new ImageIcon(imagenEscalada);

		return imagenIcon;
	}

}
