import javax.swing.*;

public class Example
{
    public static void main(String[] args)
    {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showOpenDialog(null);

        System.out.println(f.getCurrentDirectory());
        System.out.println(f.getSelectedFile());
    }
}