/**
 * PanelDialogo2.java
   14 nov 2024 10:14:01
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelDialogo2.
 *
 * @author Burhan
 */
public class PanelDialogo2 extends JPanel implements FocusListener {
	
	/** The telefono. */
	private JLabel nombre, apellidos, dni, telefono;
	
	/** The campo telefono. */
	private JFormattedTextField campoNombre, campoApellidos, campoDni, campoTelefono;
	
	/** The mascara telefono. */
	private MaskFormatter mascaraDni, mascaraTelefono;
	
	/** The grid layout. */
	private JPanel gridLayout;
	
	/** The border layout. */
	private JPanel borderLayout;
	
	/** The dias estancia. */
	private JLabel fechaActual, fechaSalida, diasEstancia;
	
	/** The campo dias estancia. */
	private JFormattedTextField campoFActual, campoFSalida, campoDiasEstancia;
	
	/** The panel fechas. */
	private JPanel panelFechas;
	
	/** The formato. */
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/** The p dialogo 3. */
	private PanelDialogo3 pDialogo3;
	
	
	public PanelDialogo2(PanelDialogo3 pDialogo3) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(190, 255, 251));
		
		this.pDialogo3 = pDialogo3;
		
		gridLayout = new JPanel(new GridLayout(4, 2));
		borderLayout = new JPanel(new BorderLayout());
		
		nombre = new JLabel("Introduce el Nombre: ");
		nombre.setForeground(Color.RED);
		apellidos = new JLabel("Introduce los Apellidos: ");
		apellidos.setForeground(Color.RED);
		dni = new JLabel("Introduce el DNI: ");
		dni.setForeground(Color.RED);
		telefono = new JLabel("Introduce el Número de Teléfono: ");
		telefono.setForeground(Color.RED);
		
		
		try {
			mascaraDni = new MaskFormatter("########?");
			campoDni = new JFormattedTextField(mascaraDni);
			campoDni.setFocusLostBehavior(campoDni.COMMIT);
			
			mascaraTelefono = new MaskFormatter("#########");
			campoTelefono = new JFormattedTextField(mascaraTelefono);
			campoTelefono.setFocusLostBehavior(campoTelefono.COMMIT);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		campoNombre = new JFormattedTextField();
		campoNombre.setPreferredSize(new Dimension(200, 30));
		campoApellidos = new JFormattedTextField();
		campoApellidos.setPreferredSize(new Dimension(200, 30));
		campoDni.setToolTipText("Ejemplo: 12345678A");
		campoDni.setPreferredSize(new Dimension(200, 30));
		campoTelefono.setToolTipText("Ejemplo: 987654321");
		campoTelefono.setPreferredSize(new Dimension(200, 30));
		
		gridLayout.add(nombre);
		gridLayout.add(campoNombre);
		gridLayout.add(apellidos);
		gridLayout.add(campoApellidos);
		gridLayout.add(dni);
		gridLayout.add(campoDni);
		gridLayout.add(telefono);
		gridLayout.add(campoTelefono);
		
		
		
		
		panelFechas = new JPanel();
		
		fechaActual = new JLabel("Fecha Actual: ");
		fechaActual.setForeground(new Color(154, 29, 7));
		fechaSalida = new JLabel("Fecha de Salida: ");
		fechaSalida.setForeground(new Color(154, 29, 7));
		diasEstancia = new JLabel("Nº Días de Estancia: ");
		diasEstancia.setForeground(new Color(154, 29, 7));
		
		campoFActual = new JFormattedTextField();
		campoFActual.setPreferredSize(new Dimension(75, 20));
		campoFSalida = new JFormattedTextField();
		campoFSalida.setPreferredSize(new Dimension(75, 20));
		campoDiasEstancia = new JFormattedTextField();
		campoDiasEstancia.setPreferredSize(new Dimension(75, 20));
		
		mostrarDatosFechas();
		
		panelFechas.add(fechaActual);
		panelFechas.add(campoFActual);
		panelFechas.add(fechaSalida);
		panelFechas.add(campoFSalida);
		panelFechas.add(diasEstancia);
		panelFechas.add(campoDiasEstancia);
		
		borderLayout.add(panelFechas);
		
		
		gridLayout.setBorder(new EmptyBorder(20, 20, 30, 20));
		
		gridLayout.setBackground(new Color(190, 255, 251));
		borderLayout.setBackground(new Color(190, 255, 251));
		panelFechas.setBackground(new Color(190, 255, 251));
		this.add(gridLayout);
		this.add(borderLayout, BorderLayout.SOUTH);
		
		// Eventos
		campoFSalida.addFocusListener(this);
	}
	
	
	private void mostrarDatosFechas() {
		
		
		String cadena1 = LocalDate.now().format(formato);
		String cadena2 = LocalDate.now().plusDays(1).format(formato);
        
		campoFActual.setText(cadena1);
		campoFSalida.setText(cadena2);
		campoDiasEstancia.setText("1 DÍA(s)");
		
		campoFActual.setEditable(false);
		campoDiasEstancia.setEditable(false);
		
	}


	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void focusLost(FocusEvent e) {
		
		
		try {
			
			String textoFechaSalida = campoFSalida.getText().trim();
			String textoFechaActual = campoFActual.getText().trim();
			LocalDate fechaSalidaF = LocalDate.parse(textoFechaSalida, formato);
			LocalDate fechaActualF = LocalDate.parse(textoFechaActual, formato);
			
			if (fechaSalidaF.isBefore(fechaActualF)) {
				JOptionPane.showMessageDialog(null, "ERROR: La fecha de Salida no puede ser anterior a la fecha Actual.", "ERROR DE FECHA", JOptionPane.ERROR_MESSAGE);
				mostrarDatosFechas();
				pDialogo3.mostrarPrecioCalculado();
	        } else {
	            int dias = (int)ChronoUnit.DAYS.between(fechaActualF, fechaSalidaF);
	            campoDiasEstancia.setText(dias + " DÍA(s)");
	            
	            pDialogo3.mostrarPrecioCalculado();
	        }
			
		} catch (DateTimeParseException ex) {
			JOptionPane.showMessageDialog(null, "ERROR: La fecha de Salida no tiene un formato válido.", "ERROR DE FECHA", JOptionPane.ERROR_MESSAGE);
			mostrarDatosFechas();
			pDialogo3.mostrarPrecioCalculado();
		}
		 
		
	}


	
	// Getters
	
	/**
	 * Gets the campo nombre.
	 *
	 * @return the campo nombre
	 */
	public JFormattedTextField getCampoNombre() {
		return campoNombre;
	}

	/**
	 * Gets the campo apellidos.
	 *
	 * @return the campo apellidos
	 */
	public JFormattedTextField getCampoApellidos() {
		return campoApellidos;
	}

	/**
	 * Gets the campo dni.
	 *
	 * @return the campo dni
	 */
	public JFormattedTextField getCampoDni() {
		return campoDni;
	}

	/**
	 * Gets the campo telefono.
	 *
	 * @return the campo telefono
	 */
	public JFormattedTextField getCampoTelefono() {
		return campoTelefono;
	}

	/**
	 * Gets the campo F actual.
	 *
	 * @return the campo F actual
	 */
	public JFormattedTextField getCampoFActual() {
		return campoFActual;
	}

	/**
	 * Gets the campo F salida.
	 *
	 * @return the campo F salida
	 */
	public JFormattedTextField getCampoFSalida() {
		return campoFSalida;
	}
	
	/**
	 * Gets the campo dias estancia.
	 *
	 * @return the campo dias estancia
	 */
	public JFormattedTextField getCampoDiasEstancia() {
		return campoDiasEstancia;
	}


	
	
	

	/**
	 * Sets the panel dialogo 3.
	 *
	 * @param panelDialogo3 the new panel dialogo 3
	 */
	// Método para instanciar el pDialogo3 que necesito pasarle para poder acceder al método mostrarPrecioCalculado del PanelDialogo3
	public void setPanelDialogo3(PanelDialogo3 panelDialogo3) {
	    this.pDialogo3 = panelDialogo3;
	}


	
	
	

}
