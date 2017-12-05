/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Extreme pc
 */
public class Cargar_Foto {

    public Object[] Cargar_foto(JLabel lblfoto) {
        lblfoto.setIcon(null);
        Object[] info_foto = null;
         FileInputStream fis;
         int longitudBytes;
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg");
        //Si deseas que se muestre primero los filtros usa la linea q esta abajo de esta.
        j.setFileFilter(filtro);
        // Agregamos el Filtro pero cuidado se mostrara despues de todos los archivos
        j.addChoosableFileFilter(filtro);
        // Colocamos titulo a nuestra ventana de Seleccion
        j.setDialogTitle("Abrir foto");
        //Si deseamos que muestre una carpeta predetermina usa la siguiente linea
        File ruta = new File("src/fotos");
        //Le implementamos a nuestro ventana de seleccion
        j.setCurrentDirectory(ruta);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
                    if (icono != null) {
                        lblfoto.setIcon(new ImageIcon(icono));
                        lblfoto.updateUI();
                        info_foto = new Object[]{
                            fis,
                            longitudBytes
                        };
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return info_foto;
    }
}
