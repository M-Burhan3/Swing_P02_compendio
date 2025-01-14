/**
 * VentanaUltimosRegistros.java
   18 nov 2024 0:26:29
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaUltimosRegistros.
 *
 * @author Burhan
 */
public class VentanaUltimosRegistros extends JDialog {
	
	/** The modelo. */
	private DefaultTableModel modelo;
	
	/** The tabla. */
	private JTable tabla;
	
	public VentanaUltimosRegistros(JFrame parent) {
		
		super(parent, "Registros Guardados", true); 
		this.setSize(new Dimension(800, 400));
		setLocationRelativeTo(null);
		
		
		 String[] columnas = {"Cliente", "Nombre", "Apellidos", "DNI", "Teléfono", "Fecha Entrada", "Fecha Salida", "Días de estancia"};
	        
		 Object[][] datos = {
				    {1, "Ana", "García López", "12345678A", "600123456", "10/11/2024", "15/11/2024", 5},
				    {2, "Luis", "Martínez Pérez", "23456789B", "610234567", "11/11/2024", "14/11/2024", 3},
				    {3, "Marta", "Rodríguez Ruiz", "34567890C", "620345678", "09/11/2024", "12/11/2024", 3},
				    {4, "Pedro", "Sánchez Gómez", "45678901D", "630456789", "12/11/2024", "18/11/2024", 6},
				    {5, "Laura", "Fernández Díaz", "56789012E", "640567890", "10/11/2024", "13/11/2024", 3},
				    {6, "Carlos", "Hernández Ortega", "67890123F", "650678901", "14/11/2024", "17/11/2024", 3},
				    {7, "Sofía", "Jiménez Ramos", "78901234G", "660789012", "08/11/2024", "10/11/2024", 2},
				    {8, "Javier", "González Castro", "89012345H", "670890123", "15/11/2024", "20/11/2024", 5},
				    {9, "Elena", "Ruiz Morales", "90123456I", "680901234", "11/11/2024", "13/11/2024", 2},
				    {10, "Miguel", "Navarro Vega", "01234567J", "690012345", "09/11/2024", "14/11/2024", 5},
				    {11, "Isabel", "Ortiz Marín", "12345678K", "700123456", "13/11/2024", "15/11/2024", 2},
				    {12, "Raúl", "Ramos Torres", "23456789L", "710234567", "10/11/2024", "12/11/2024", 2}
				};

	        
	        modelo = new DefaultTableModel(datos, columnas);

	        tabla = new JTable(modelo);

	        JScrollPane scrollPane = new JScrollPane(tabla);

	        
	        this.add(scrollPane); 
	        
	        this.setVisible(true);
	}
	

}
