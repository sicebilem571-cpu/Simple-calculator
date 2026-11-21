import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame /*implements WindowListener*/ {
    private static final String[] functions = {"DEL","AC","X","/","+","-","ANS","="};
    public Calculator(){

    }
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.setSize(400,750);
        c.setLayout(new FlowLayout());

        JPanel display = new JPanel();
        display.setLayout(new BorderLayout(0,0));
        display.setPreferredSize(new Dimension(380,150));
        JTextArea ans = new JTextArea("Draining");
        JTextArea sum = new JTextArea("work");
        ans.setPreferredSize(new Dimension(390,50));
        sum.setPreferredSize(new Dimension(390,100));
        display.add(sum, BorderLayout.SOUTH);
        display.add(ans, BorderLayout.NORTH);
        display.setVisible(true);

        JPanel nums = new JPanel();
        nums.setLayout(new GridLayout(4,3));
        for (int i=3; i>0; i--){
            for (int j=0; j<3; j++){
                nums.add(new JButton("" + (i*3 + j)));

            }

        }
        nums.add(new JButton("0"));
        nums.add(new JButton(","));
        nums.add(new JButton("x10^x"));

        JPanel funcs = new JPanel();
        funcs.setLayout(new GridLayout(4,2));
        for (int i=0; i<4; i++){
            for (int j=0; j<2; j++){
                funcs.add(new JButton(functions[j+(2*i)]));

            }

        }

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        buttons.setPreferredSize(new Dimension(380,550));
        buttons.add(nums, BorderLayout.WEST);
        buttons.add(funcs, BorderLayout.EAST);

        c.add(display);
        c.add(buttons);
        c.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        c.setVisible(true);

    }
}
