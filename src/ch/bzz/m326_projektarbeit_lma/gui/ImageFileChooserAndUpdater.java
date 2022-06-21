package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.employees.Person;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.net.MalformedURLException;

/**
 * This class can be used to change the Image of a Person by selecting the image file with the generated JFileChooser.
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.21
 * @version 1.0
 */
public class ImageFileChooserAndUpdater {

    private final String[] acceptedFileExtensions = new String[] { ".jpg", ".jpeg", ".png"};

    /**
     * constructor
     *
     * @param person of which the image/photo is changed
     * @param mainFrame the parent for the JFileChooser
     */
    public ImageFileChooserAndUpdater(Person person, MainFrame mainFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                for (String extension : acceptedFileExtensions) {
                    if (f.getName().toLowerCase().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "Images of types: .jpg .jpeg .png";
            }
        });
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = fileChooser.showOpenDialog(mainFrame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                person.setPhoto(new ImageIcon(fileChooser.getSelectedFile().toURI().toURL()).getImage());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}