import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SplashScreen extends JWindow {

    static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    private static SplashScreen execute;
    private static int count;
    private static Timer timer1;
    JLabel statusLoading = new JLabel();

    public SplashScreen() {

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder()
        );
        //panel.setBackground(new Color(255, 255, 255));
        //Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setBounds(0, 0, 600, 337);
        panel.setLayout(null);
        container.add(panel);

        JLabel label = new JLabel();

        //Set Logo here of your choice 
      ///  label.setIcon(new javax.swing.ImageIcon(getClass().getResource("src\\images\\0to3am.png")));
        //label.setFont(new Font("Verdana", Font.BOLD, 14));102
Icon ic=new ImageIcon("src\\images\\front1.png");
label.setIcon(ic);
        label.setBounds(0, 0, 600, 337);
        statusLoading.setBounds(250,290,110,40);

        panel.add(label);

        label.add(statusLoading);
         int r=220;
         int g=20;
         int b=60;
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(r,g,b));
        progressBar.setMaximum(100);
        progressBar.setBounds(0, 322, 600, 15);
        container.add(progressBar);
        loadProgressBar();
        setSize(600, 337);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);
                progressBar.setString(count + "%");
                System.out.println(count);
                if (count < 25) {
                    statusLoading.setText("Initializing....");
                } else if (count < 50) {

                    statusLoading.setText("Loading Modules....");
                } else if (count < 75) {

                    statusLoading.setText("Fetching Data....");
                } else {

                    statusLoading.setText("Starting....");
                }
                if (count == 100) {

                    createFrame();

                    execute.setVisible(false);

                    timer1.stop();
                }

            }

            private void createFrame() throws HeadlessException {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //call here your main class intead of this
                new main().setVisible(true);

            }
        };
        timer1 = new Timer(100, al);
        timer1.start();
    }

    public static void main(String[] args) {
        execute = new SplashScreen();
    }
};
