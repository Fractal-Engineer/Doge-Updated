import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class doge {

    static void runCommand() {
    try {
            String command = "cmd /c type Doge.txt";
            
            Process process = Runtime.getRuntime().exec(command);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}

static void runBuffDogeASCII() {
    try {
            String command = "cmd /c type Buff-Doge.txt";

            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}

static void runTwinkieDogeASCII() {
    try {
        String command = "cmd /c type Twinkie_Doge.txt";
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

static void playDogeCraft() {
    try {
        String command = "cmd /c python Dogecraft.py";
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    static JLabel currentImageLabel = null;
    static Random random = new Random();

    static String[] dogeImage = {
        "R__1.png",
        "SeekPng.com_snake-png-transparent_4927521.png",
        "XSimBK.png",
        "OIP__1.png",
        "OIP__2.png",
        "Oh_Wow_So_Doge_The_Meme_Of_Day_Trigger_Plug.png",
    };

    static void dogeImage(JFrame frame) {
        if (currentImageLabel != null) {
            frame.remove(currentImageLabel);
            frame.repaint();
        }

        int index = random.nextInt(dogeImage.length);
        String imagePath = dogeImage[index];
        ImageIcon imageIcon = new ImageIcon(imagePath);

        currentImageLabel = new JLabel(imageIcon);
        currentImageLabel.setBounds(700, 1, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        frame.add(currentImageLabel);
        frame.revalidate();
        frame.repaint();
    }

    static String[] dogeTalk = {
        "Such GUI, very cool, wow!",
        "Such code, very readable wow",
        "much best doge",
        "Such buttons, very awesome!"
    };

    static void dogeTalk() {
        int index = random.nextInt(dogeTalk.length);
        System.out.println(dogeTalk[index]);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Doge");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton button = new JButton("Doge");
        button.setBounds(150, 170, 300, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon = new ImageIcon("PngItem_2028426.png");
                if (currentImageLabel != null) {
                    frame.remove(currentImageLabel);
                }
                currentImageLabel = new JLabel(imageIcon);
                currentImageLabel.setBounds(450, 100, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                frame.add(currentImageLabel);
                frame.revalidate();
                frame.repaint();
            }
        });

        JButton button1 = new JButton("Doge Talk");
        button1.setBounds(150, 240, 300, 50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dogeTalk();
            }
        });

        JButton button2 = new JButton("Doge Image");
        button2.setBounds(150, 310, 300, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dogeImage(frame);
            }
        });

        JButton button3 =  new JButton("ASCII DOGE");
        button3.setBounds(150, 380, 300, 50);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
runCommand();
            }
        });

       JButton button4 =  new JButton("ASCII BUFF DOGE");
        button4.setBounds(150, 450, 300, 50);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
runBuffDogeASCII();
            }
        }); 

        JButton button5 = new JButton("ASCII TWINKIE DOGE");
        button5.setBounds(150, 520, 300, 50);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runTwinkieDogeASCII();
            }
        });

        JButton button6 = new JButton("Play DogeCraft");
        button6.setBounds(150, 590, 300, 50);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playDogeCraft();
            }
        });

        frame.add(button6);
        frame.add(button2);
        frame.add(button);
        frame.add(button1);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.setVisible(true);
    }
}