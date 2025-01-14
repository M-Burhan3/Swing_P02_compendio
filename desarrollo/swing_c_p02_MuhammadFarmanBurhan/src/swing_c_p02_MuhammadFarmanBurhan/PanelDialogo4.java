/**
 * PanelDialogo4.java
   16 nov 2024 14:33:41
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelDialogo4.
 *
 * @author Burhan
 */
public class PanelDialogo4 extends JPanel implements ActionListener {
	
	/** The boton registros guardados. */
	private JButton botonImprimir, botonNuevo, botonGuardar, botonRegistrosGuardados;
	
	/** The panel botones. */
	private JPanel panelBotones;
	
	/** The tabbed pane. */
	private JTabbedPane tabbedPane;
	
	/** The panel habitacion. */
	private JPanel panelCliente ,panelHabitacion;
	
	/** The area texto habitacion. */
	private JTextArea areaTextoCliente, areaTextoHabitacion;
	
	/** The p dialogo 2 copia. */
	private PanelDialogo2 pDialogo2Copia; 
	
	/** The p dialogo 3 copia. */
	private PanelDialogo3 pDialogo3Copia;
	
	/** The ventana. */
	private JFrame ventana;
	
	public PanelDialogo4(PanelDialogo2 pDialogo2, PanelDialogo3 pDialogo3) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(190, 255, 251));
		
		
		pDialogo2Copia = pDialogo2;
		pDialogo3Copia = pDialogo3;
		
		
		
		botonImprimir = new JButton("Imprimir");
		botonNuevo = new JButton("Nuevo");
		botonGuardar = new JButton("Guardar");
		
		botonImprimir.setBackground(new Color(41, 51, 255));
		botonNuevo.setBackground(Color.ORANGE);
		botonGuardar.setBackground(Color.GREEN);
		
		
		botonRegistrosGuardados = new JButton("Registros Guardados");
		botonRegistrosGuardados.setBackground(new Color(255, 0, 0));
		
		//-------------------------------------------
		
		panelCliente = new JPanel();
		panelCliente.setLayout(new BorderLayout());
		areaTextoCliente = new JTextArea();
		panelCliente.add(areaTextoCliente, BorderLayout.CENTER);
		
		
		panelHabitacion = new JPanel();
		panelHabitacion.setLayout(new BorderLayout());
		areaTextoHabitacion = new JTextArea();
		panelHabitacion.add(areaTextoHabitacion, BorderLayout.CENTER);
		
		//-------------------------------------------
		
		
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(300, 300));
		tabbedPane.addTab ("Datos del cliente: ", panelCliente);
		tabbedPane.addTab ("Datos de la Habitación: ", panelHabitacion);
		
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelBotones.setBackground(new Color(190, 255, 251));
		
		
		this.add(Box.createVerticalStrut(20));
		this.add(tabbedPane);
		panelBotones.add(botonRegistrosGuardados);
		botonRegistrosGuardados.setIcon(imagen("recursos/iconoLista.png", 20, 20));
		panelBotones.add(botonImprimir);
		botonImprimir.setIcon(imagen("recursos/iconoImprimir.jpg", 20, 20));
		panelBotones.add(botonNuevo);
		botonNuevo.setIcon(imagen("recursos/iconoNuevo.png ", 20, 20));
		panelBotones.add(botonGuardar);
		botonGuardar.setIcon(imagen("recursos/iconoGuardar.jpg", 20, 20));
		this.add(Box.createVerticalStrut(10));
		this.add(panelBotones);
		
		
		// Eventos
		botonImprimir.addActionListener(this);
		botonNuevo.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonRegistrosGuardados.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botonImprimir) {
			mostrarDatosCliente();
			mostrarDatosHabitacion();
		}
		
		if (e.getSource() == botonNuevo) {
			limpiarDatos();
		}
		
		if (e.getSource() == botonGuardar) {
			guardar();
		}
		
		if (e.getSource() == botonRegistrosGuardados) {
			JOptionPane.showMessageDialog(null, "ATENCIÓN: Esta opción está actualmente en versión beta.", "EN DESARROLLO", JOptionPane.INFORMATION_MESSAGE);
			VentanaUltimosRegistros ventanaUltimosRegistros = new VentanaUltimosRegistros(ventana);
		}
		
	}
	
	
	
	
	public void mostrarDatosCliente() {
		
		if (pDialogo2Copia.getCampoNombre().getText().toString().trim().length() < 1) {
			JOptionPane.showMessageDialog(null, "ERROR: Introduce un nombre.", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		} else if (pDialogo2Copia.getCampoApellidos().getText().toString().trim().length() < 1) {
			JOptionPane.showMessageDialog(null, "ERROR: Introduce los apellidos.", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		} else if (pDialogo2Copia.getCampoDni().getText().toString().trim().length() < 9) {
			JOptionPane.showMessageDialog(null, "ERROR: El DNI no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		} else if (pDialogo2Copia.getCampoTelefono().getText().toString().trim().length() < 9) {
			JOptionPane.showMessageDialog(null, "ERROR: El Número de Teléfono no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		} else {
			areaTextoCliente.setText(
					"\n" +
					"Nombre: " + pDialogo2Copia.getCampoNombre().getText().toString() + "\n" + 
					"Apellidos: " + pDialogo2Copia.getCampoApellidos().getText().toString() + "\n" + 
					"DNI: " + pDialogo2Copia.getCampoDni().getText().toString() + "\n" + 
					"Numéro de Teléfono: " + pDialogo2Copia.getCampoTelefono().getText().toString() + "\n" + 
					"Fecha de Registro: " + pDialogo2Copia.getCampoFActual().getText().toString() + "\n" + 
					"Fecha de Salida: " + pDialogo2Copia.getCampoFSalida().getText().toString() + "\n" + 
					"Número de Días de Estancia: " + pDialogo2Copia.getCampoDiasEstancia().getText().toString() + "\n"
					);
		}
	}
	
	
	public void guardar() {

		if (pDialogo2Copia.getCampoNombre().getText().toString().trim().length() < 1) {
			JOptionPane.showMessageDialog(null, "ERROR: Introduce un nombre.", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else if (pDialogo2Copia.getCampoApellidos().getText().toString().trim().length() < 1) {
			JOptionPane.showMessageDialog(null, "ERROR: Introduce los apellidos.", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else if (pDialogo2Copia.getCampoDni().getText().toString().trim().length() < 9) {
			JOptionPane.showMessageDialog(null, "ERROR: El DNI no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else if (pDialogo2Copia.getCampoTelefono().getText().toString().trim().length() < 9) {
			JOptionPane.showMessageDialog(null, "ERROR: El Número de Teléfono no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(null, "El Registro se ha Guardado Correctamente.", "REGISTRO GUARDADO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void mostrarDatosHabitacion() {
		
		String camaSupletoria = "";
		String nino = "";
		String edadNino = "";
		
		
		if (pDialogo3Copia.getCheck().isSelected() == false) {
			nino = "No";
			edadNino = "-";
			camaSupletoria = "No";
		} else {
			nino = "Si";
			edadNino = pDialogo3Copia.getEdad().getValue().toString();
			
			if ((int)pDialogo3Copia.getEdad().getValue() >= 0 && (int)pDialogo3Copia.getEdad().getValue() <= 3) {
				camaSupletoria = "Cuna";
			}
			
			if ((int)pDialogo3Copia.getEdad().getValue() >= 4 && (int)pDialogo3Copia.getEdad().getValue() <= 10) {
				camaSupletoria = "Pequeña";
			}
			
			if ((int)pDialogo3Copia.getEdad().getValue() >= 11 && (int)pDialogo3Copia.getEdad().getValue() <= 14) {
				camaSupletoria = "Grande";
			}
		}
		
		
		areaTextoHabitacion.setText(
				"\n" +
				"Tipo de Habitación: " + pDialogo3Copia.getListaHabitaciones().getSelectedItem().toString() + "\n" + 
				"Número de Habitación: " + pDialogo3Copia.getNumHabitaciones().getValue() + "\n" + 
				"¿Niños?: " + nino + "\n" + 
				"Edad niño: " + edadNino + "\n" + 
				"Cama Supletoria: " + camaSupletoria + "\n" + 
				"Importe Habitación: " + pDialogo3Copia.getPrecio().getText().toString() + "\n"
				);
	}
	
	
	private void limpiarDatos() {
		
		
		pDialogo2Copia.getCampoNombre().setText("");
		pDialogo2Copia.getCampoApellidos().setText("");
		pDialogo2Copia.getCampoDni().setText("");
		pDialogo2Copia.getCampoTelefono().setText("");
		pDialogo2Copia.getCampoFSalida().setText("" + LocalDate.now().plusDays(1));
		pDialogo2Copia.getCampoDiasEstancia().setText("1 DÍA(s)");
		
		pDialogo3Copia.getListaHabitaciones().setSelectedIndex(0); 
	    pDialogo3Copia.getNumHabitaciones().setValue(1); 
	    pDialogo3Copia.getCheck().setSelected(false); 
	    pDialogo3Copia.getEdad().setValue(0); 
	    pDialogo3Copia.getEdad().setEnabled(false);
	    pDialogo3Copia.getPrecio().setText("50€");
	    pDialogo3Copia.getAreaDeTexto().setText("--------------------");
	    pDialogo3Copia.getAreaDeTexto().setBackground(new Color(238, 238, 238));
	    
	    areaTextoCliente.setText("");
	    areaTextoHabitacion.setText("");
	    
	    pDialogo2Copia.getCampoNombre().requestFocus();
	}
	
	
	
	//-------------------------------------------------------------------------------------------------------
		public ImageIcon imagen(String ruta, int ancho, int alto) {
			Image imagen = new ImageIcon(getClass().getResource(ruta)).getImage();

			Image imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
			ImageIcon imagenIcon = new ImageIcon(imagenEscalada);
			
			return imagenIcon;
		}
	
}
