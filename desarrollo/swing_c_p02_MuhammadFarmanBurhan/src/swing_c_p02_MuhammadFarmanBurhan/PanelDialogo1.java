/**
 * PanelDialogo1.java
   14 nov 2024 9:50:27
   @author Burhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanBurhan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelDialogo1.
 *
 * @author Burhan
 */
public class PanelDialogo1 extends JPanel {
	
	/** The titulo. */
	private JLabel titulo;
	
	public PanelDialogo1() {
		
		this.setBackground(new Color(190, 255, 251));
		
		titulo = new JLabel("Blue Summer Hotel");
		titulo.setFont(new Font("Forte", Font.BOLD | Font.ITALIC, 50));
		titulo.setForeground(Color.GREEN);
		titulo.setPreferredSize(new Dimension(600, 100));
		titulo.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		titulo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		this.add(titulo);
	}
	

}
