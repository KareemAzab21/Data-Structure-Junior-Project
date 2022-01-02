
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Graph extends JFrame implements ActionListener {

    JComboBox s1, s2;
    JButton b1;

    Graph() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        setTitle("Data Structure and Algorithms");

        ImageIcon i1 = new ImageIcon("Page2.jpg");
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

        String[] n = {"Insertion Sort", "Merge Sort", "Selection Sort", "Heap Sort", "Counting Sort", "Radix Sort", "Quick Sort"};
        s1 = new JComboBox(n);
        s2 = new JComboBox(n);
        s1.addActionListener(this);
        s2.addActionListener(this);
        s1.setBounds(50, 230, 125, 30);
        s2.setBounds(900, 230, 125, 30);
        l11.add(s1);
        l11.add(s2);

        JLabel ls1 = new JLabel("Choose Sorting Algorithms 1");
        ls1.setFont(new Font("Raleway", Font.BOLD, 20));
        ls1.setBounds(25, 180, 600, 40);
        ls1.setForeground(Color.BLACK);
        l11.add(ls1);
        JLabel ls2 = new JLabel("Choose Sorting Algorithms 2");
        ls2.setFont(new Font("Raleway", Font.BOLD, 20));
        ls2.setBounds(790, 180, 600, 40);
        ls2.setForeground(Color.BLACK);
        l11.add(ls2);


        ImageIcon draw = new ImageIcon("draw.jpg");
        b1 = new JButton("Draw Graph");
        b1.setBounds(450, 400, 216, 210);
        b1.setIcon(draw);
        b1.setHorizontalTextPosition(0);
        b1.setVerticalTextPosition(0);
        b1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);

        b1.setBorder(BorderFactory.createEtchedBorder());
        b1.addActionListener(this);
        l11.add(b1);


        setSize(1080, 800);
        setLocation(0, 0);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == s1) {
            if (s1.getSelectedItem().equals("Insertion Sort")) {
                s2.removeItemAt(0);
            }
            if (s1.getSelectedItem().equals("Merge Sort")) {
                s2.removeItemAt(1);

            }
            if (s1.getSelectedItem().equals("Selection Sort")) {
                s2.removeItemAt(2);

            }
            if (s1.getSelectedItem().equals("Heap Sort")) {
                s2.removeItemAt(3);

            }
            if (s1.getSelectedItem().equals("Counting Sort")) {
                s2.removeItemAt(4);

            }
            if (s1.getSelectedItem().equals("Radix Sort")) {
                s2.removeItemAt(5);
            }
            if (s1.getSelectedItem().equals("Quick Sort")) {
                s2.removeItemAt(6);

            }


        }

        if (e.getSource() == b1) {
            new HomePage().setVisible(true);
            if (s1.getSelectedIndex() == 0) {
                if (s2.getSelectedIndex() == 0) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.insertion_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.merge_sort(array2,0,j-1),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
                if (s2.getSelectedIndex() == 1) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.insertion_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.selection_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
                if (s2.getSelectedIndex() == 2) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.insertion_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.heap_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }


                if (s2.getSelectedIndex() == 3) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.insertion_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.count_Sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));




                }
                if (s2.getSelectedIndex() == 4) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.insertion_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.radixsort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));



                }
                if (s2.getSelectedIndex() == 5) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.insertion_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.quick_Sort(array2,0,j-1),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }

            }
            if (s1.getSelectedIndex() == 1) {
                if (s2.getSelectedIndex() == 0) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.merge_sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.insertion_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 1) {

                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.merge_sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.selection_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));
                }
                if (s2.getSelectedIndex() == 2) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.merge_sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.heap_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 3) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.merge_sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.count_Sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 4) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.merge_sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.radixsort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 5) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.merge_sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.quick_Sort(array2,0,j-1),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }

            }
            if (s1.getSelectedIndex() == 2) {
                if (s2.getSelectedIndex() == 0) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.selection_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.insertion_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 1) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.selection_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.merge_sort(array2,0,j-1),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 2) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.selection_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.heap_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 3) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.selection_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.count_Sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 4) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.selection_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.radixsort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 5) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.selection_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.quick_Sort(array2,0,j-1),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }

            }
            if (s1.getSelectedIndex() == 3) {
                if (s2.getSelectedIndex() == 0) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.heap_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.insertion_sort(array2,j),series2,String.valueOf(j));

                    }



                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 1) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.heap_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.merge_sort(array2,0,j-1),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
                if (s2.getSelectedIndex() == 2) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.heap_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.selection_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
                if (s2.getSelectedIndex() == 3) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.heap_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.count_Sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
                if (s2.getSelectedIndex() == 4) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.heap_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.radixsort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
                if (s2.getSelectedIndex() == 5) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.heap_sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.quick_Sort(array2,0,j-1),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
            }
            if (s1.getSelectedIndex() == 4) {
                if (s2.getSelectedIndex() == 0) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.count_Sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.insertion_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));


                }
                if (s2.getSelectedIndex() == 1) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.count_Sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.merge_sort(array2,0,j-1),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 2) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.count_Sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.selection_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 3) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.count_Sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.heap_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 4) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.count_Sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.radixsort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 5) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.count_Sort(array1,j),series1,String.valueOf(j));
                        dataset.addValue(a2.quick_Sort(array2,0,j-1),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }

            }
            if (s1.getSelectedIndex() == 5) {
                if (s2.getSelectedIndex() == 0) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.radixsort(array2,j),series1,String.valueOf(j));
                        dataset.addValue(a2.insertion_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 1) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.radixsort(array2,j),series1,String.valueOf(j));
                        dataset.addValue(a2.merge_sort(array2,0,j-1),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 2) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.radixsort(array2,j),series1,String.valueOf(j));
                        dataset.addValue(a2.selection_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 3) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.radixsort(array2,j),series1,String.valueOf(j));
                        dataset.addValue(a2.heap_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 4) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.radixsort(array2,j),series1,String.valueOf(j));
                        dataset.addValue(a2.count_Sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 5) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.radixsort(array2,j),series1,String.valueOf(j));
                        dataset.addValue(a2.quick_Sort(array2,0,j-1),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }

            }
            if (s1.getSelectedIndex() == 6) {
                if (s2.getSelectedIndex() == 0) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.quick_Sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.insertion_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 1) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.quick_Sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.merge_sort(array2,0,j-1),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 2) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.quick_Sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.selection_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 3) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.quick_Sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.heap_sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 4) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.quick_Sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.count_Sort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }
                if (s2.getSelectedIndex() == 5) {
                    String series1 = "Sorting 1";
                    String series2 = "Sorting 2";
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    for(int j = 10; j<1000;j+=50){
                        Randnumbers r = new Randnumbers();
                        try {
                            r.GenerateNums(j);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        int[] array1 = new int[j];
                        int[] array2 = new int[j];
                        try {
                            FileReader fr = new FileReader("Data.txt");
                            for (int i = 0; i < j; i++) {
                                array1[i] = fr.read();
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i = 0; i < array1.length; i++) {
                            array2[i] = array1[i];

                        }
                        Algo a1 = new Algo(array1, array1.length);
                        Algo a2 = new Algo(array2, array2.length);
                        dataset.addValue(a1.quick_Sort(array1,0,j-1),series1,String.valueOf(j));
                        dataset.addValue(a2.radixsort(array2,j),series2,String.valueOf(j));

                    }
                    JFreeChart chart = ChartFactory.createLineChart(
                            "Sorting Algorithms", // Chart title
                            "N", // X-Axis Label
                            "F(n)", // Y-Axis Label
                            dataset

                    );
                    pack();

                    ChartPanel chartPanel = new ChartPanel( chart );
                    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
                    setContentPane( chartPanel );
                    setMinimumSize(new java.awt.Dimension( 900 , 650 ));

                }

            }
        }

        }




    public static void main(String[] args) {


        new Graph().setVisible(true);

    }
}

