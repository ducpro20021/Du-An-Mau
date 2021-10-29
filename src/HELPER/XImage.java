/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */
public class XImage {
    
    public static Image getAppIcon(){
        URL url=XImage.class.getResource("\\ImageIcon\\Add.png");
        return new ImageIcon(url).getImage();
    }
    
    public static  ImageIcon read(String fileName){
        File path=new File("logos",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    public static void save(File src){
        File dst=new File("logos",src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        try {
            Path from=Paths.get(src.getAbsolutePath());
            Path to=Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
