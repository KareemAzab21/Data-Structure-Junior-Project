import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener {
    JButton b1,b2,b3;

    HomePage() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        setTitle("Data Structure and Algorithms");

        ImageIcon i1 = new ImageIcon("HomePage.jpg");
        Image i2 = i1.getImage().getScaledInstance(1080, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 1080, 800);
        add(l11);


        JLabel l1 = new JLabel("Sorting Algorithms");
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        l1.setBounds(350, 25, 600, 40);
        l1.setForeground(Color.black);
        l11.add(l1);
        //////////////////////////////////////////////////////

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);

        //Menu items and options
        JMenuItem m11 = new JMenuItem("EXIT");
        m1.add(m11);




        /////////////////////////////////////////////////////////////



        ImageIcon generate = new ImageIcon("generate.png");
        b1 = new JButton("Generate");
        b1.setBounds(50,120,128,128);
        b1.setIcon(generate);
        b1.setHorizontalTextPosition(0);
        b1.setVerticalTextPosition(0);
        b1.setFont(new Font("Comic Sans",Font.BOLD,20));
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);

        b1.setBorder(BorderFactory.createEtchedBorder());
        b1.addActionListener(this);
        l11.add(b1);



        ImageIcon graph = new ImageIcon("graph.png");
        b2 = new JButton("Compare");
        b2.setBounds(50,300,128,128);
        b2.setIcon(graph);
        b2.setHorizontalTextPosition(0);
        b2.setVerticalTextPosition(0);
        b2.setFont(new Font("Comic Sans",Font.BOLD,20));
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);

        b2.setBorder(BorderFactory.createEtchedBorder());
        b2.addActionListener(this);
        l11.add(b2);


        ImageIcon notation= new ImageIcon("Notation.png");
        b3 = new JButton("Notation");
        b3.setBounds(50,550,128,128);
        b3.setIcon(notation);
        b3.setHorizontalTextPosition(0);
        b3.setVerticalTextPosition(0);
        b3.setFont(new Font("Comic Sans",Font.BOLD,20));
        b3.setForeground(Color.black);
        b3.setBackground(Color.white);

        b3.setBorder(BorderFactory.createEtchedBorder());
        b3.addActionListener(this);
        l11.add(b3);



        /////////////////////////////////////////////////////////////////////////
        setSize(1080, 800);
        setLocation(300,0);
        setVisible(true);


    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
            setVisible(false);
            new Graph().setVisible(true);


        }


    }


    public static void main(String[] args){


        new HomePage().setVisible(true);

    }

}
