import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private static final String[] functions = {"DEL","AC","X","/","+","-","ANS","="};
    public static JPanel display = new JPanel();
    public static JTextArea ans = new JTextArea();
    public static JTextArea sum = new JTextArea();
    public static float  ANS;
    public static String last = "";

    public Calculator(){}

    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case ("AC"):    sum.setText("");
                            ans.setText("");
                            break;
            case ("DEL"):   int len = sum.getText().length();
                            if (len>=3 && sum.getText().substring(len-3,len).equals("ANS"))
                                sum.setText(sum.getText().substring(0,len-3));
                            else if (len>=5 && sum.getText().substring(len-5,len).equals("x10^x"))
                                sum.setText(sum.getText().substring(0,len-5));
                            else if (len>0)
                                sum.setText(sum.getText().substring(0,len-1));
                            break;
            default:        sum.append(e.getActionCommand());

        }


    }
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.setSize(400,750);
        c.setLayout(new FlowLayout());

        display.setLayout(new BorderLayout(0,0));
        display.setPreferredSize(new Dimension(380,150));

        ans.setPreferredSize(new Dimension(390,50));
        ans.setFont(new Font(Font.MONOSPACED,Font.BOLD, 24));
        sum.setPreferredSize(new Dimension(390,100));
        sum.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        display.add(sum, BorderLayout.NORTH);
        display.add(ans, BorderLayout.SOUTH);
        display.setVisible(true);

        JPanel nums = new JPanel();
        nums.setLayout(new GridLayout(4,3));
        for (int i=3; i>0; i--){
            for (int j=0; j<3; j++){
                JButton button = new JButton("" + (i*3 + j - 2));
                button.addActionListener(c);
                nums.add(button);

            }

        }
        JButton naught = new JButton("0");
        naught.addActionListener(c);
        nums.add(naught);
        JButton comma = new JButton(",");
        comma.addActionListener(c);
        nums.add(comma);
        JButton order = new JButton("x10^x");
        order.addActionListener(c);
        nums.add(order);

        JPanel funcs = new JPanel();
        funcs.setLayout(new GridLayout(4,2));
        for (int i=0; i<4; i++){
            for (int j=0; j<2; j++){
                JButton button = new JButton(functions[j+(2*i)]);
                button.addActionListener(c);
                funcs.add(button);

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
