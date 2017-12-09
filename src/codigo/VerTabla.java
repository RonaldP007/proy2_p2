package codigo;

import base_datos.Renta_Vehiculos;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VerTabla {

    public void visualizar_tabla(JTable tabla) {
        Renta_Vehiculos rv = new Renta_Vehiculos(); 
      //  Connection con = conn.conectar();
        ResultSet rs = rv.visualizar();
        //Image img = null;   
        tabla.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Placa");
        dt.addColumn("Transmision");
        dt.addColumn("Año");
        dt.addColumn("Precio");
        dt.addColumn("Foto");
       
        try {

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getObject(1);
                if(rs.getObject(2).equals(true)){
                    fila[1] = "Automatico";
                }
                else{
                    fila[1] = "Manual";
                }
                
                fila[2] = rs.getObject(3);
                fila[3] = rs.getObject(4);

                InputStream blob = rs.getBinaryStream(5);

                if (blob != null) {
                    try {
                        BufferedImage bi = ImageIO.read(blob);
                        ImageIcon carg_fot = new ImageIcon(bi);
                        Image img = carg_fot.getImage();
                        Image newimg = img.getScaledInstance(70, 90, 1);
                        ImageIcon newicon = new ImageIcon(newimg);
                        fila[4] = new JLabel(newicon);
                    } catch (Exception ex) {
                        fila[4] = "No Imagen";
                    }
                } else {
                    fila[4] = "No Imagen";
                }

                dt.addRow(fila);
            }

            tabla.setModel(dt);
            tabla.setRowHeight(100);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
