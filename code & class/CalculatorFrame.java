import java.awt.Frame;
import java.awt.Button;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

class CalculatorFrame extends Frame implements ActionListener, WindowListener {

    // declaring instances;
    Label l1, l2, l3, input; // l2 for developer name;
    Button add, equalto, substract, devide, multiply, clearButton, crossButton, nine, eight, seven, six, five, four,
            three, two, one, zero, dot, square;
    Font f;
    int y = 4, w = 73, h = 50, flag = 0, fl = 0;; // y for height of control ,
    // can control many controls at a time to adjust height up aur down
    // h for inner height and width for same size controls;

    Double resultInt = 0.0, inputOne = 0.0, inputTwo = 0.0;
    String resultString = "0", operator = "", prevvalue = "";

    public CalculatorFrame() {
        setLayout(null);
        setSize(342, 425);
        setVisible(true);

        // heading lable adjiustment
        setBackground(new Color(245, 191, 110));
        l1 = new Label("Calculator");
        l1.setBounds(25, 30, 190, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        add(l1);

        // result field adjustment
        input = new Label("0");
        input.setFont(new Font("Arial", Font.BOLD, 35));
        input.setBounds(25, 63, 300, 65);
        input.setBackground(new Color(243, 245, 243));
        add(input);

        // adding buttons etc.
        f = new Font("Arial", Font.BOLD, 30);
        crossButton = new Button("C");
        crossButton.setFont(f);
        crossButton.setBounds(25, 133 + y, w, h);
        add(crossButton);

        clearButton = new Button("<-");
        clearButton.setFont(f);
        clearButton.setBounds(100, 133 + y, w, h);
        add(clearButton);

        devide = new Button("/");
        devide.setFont(f);
        devide.setBounds(175, 133 + y, w, h);
        add(devide);

        multiply = new Button("X");
        multiply.setFont(f);
        multiply.setBounds(250, 133 + y, w, h);
        add(multiply);

        substract = new Button("-");
        substract.setFont(f);
        substract.setBounds(250, 187 + y, w, h);
        add(substract);

        add = new Button("+");
        add.setFont(f);
        add.setBounds(250, 240 + y, w, h + 52);
        add(add);

        equalto = new Button("=");
        equalto.setFont(f);
        equalto.setBounds(250, 346 + y, w, h);
        add(equalto);

        nine = new Button("9");
        nine.setFont(f);
        nine.setBounds(25, 187 + y, w, h);
        add(nine);

        eight = new Button("8");
        eight.setFont(f);
        eight.setBounds(100, 187 + y, w, h);
        add(eight);

        seven = new Button("7");
        seven.setFont(f);
        seven.setBounds(175, 187 + y, w, h);
        add(seven);

        six = new Button("6");
        six.setFont(f);
        six.setBounds(25, 240 + y, w, h);
        add(six);

        five = new Button("5");
        five.setFont(f);
        five.setBounds(100, 240 + y, w, h);
        add(five);

        four = new Button("4");
        four.setFont(f);
        four.setBounds(175, 240 + y, w, h);
        add(four);

        three = new Button("3");
        three.setFont(f);
        three.setBounds(25, 293 + y, w, h);
        add(three);

        two = new Button("2");
        two.setFont(f);
        two.setBounds(100, 293 + y, w, h);
        add(two);

        one = new Button("1");
        one.setFont(f);
        one.setBounds(175, 293 + y, w, h);
        add(one);

        zero = new Button("0");
        zero.setFont(f);
        zero.setBounds(25, 346 + y, w, h);
        add(zero);

        dot = new Button(".");
        dot.setFont(f);
        dot.setBounds(100, 346 + y, w, h);
        add(dot);

        square = new Button("x^n");
        square.setFont(f);
        square.setBounds(175, 346 + y, w, h);
        add(square);

        l2 = new Label("made by Anshul");
        l2.setBounds(25, 398 + y, w + 20, 15);
        add(l2);

        // registring buttons

        add.addActionListener(this);
        equalto.addActionListener(this);
        substract.addActionListener(this);
        devide.addActionListener(this);
        multiply.addActionListener(this);
        clearButton.addActionListener(this);
        crossButton.addActionListener(this);
        nine.addActionListener(this);
        eight.addActionListener(this);
        seven.addActionListener(this);
        six.addActionListener(this);
        five.addActionListener(this);
        four.addActionListener(this);
        three.addActionListener(this);
        two.addActionListener(this);
        one.addActionListener(this);
        zero.addActionListener(this);
        square.addActionListener(this);
        dot.addActionListener(this);
        addWindowListener(this);
    }

    public void windowClosed(WindowEvent we) {

    }

    public void windowActivated(WindowEvent we) {

    }

    public void windowClosing(WindowEvent we) {
        dispose();
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent arg0) {
    }

    public void actionPerformed(ActionEvent ae) {

        Calculator calculator = new Calculator();
        String s = ae.getActionCommand();
        char receivedAction = s.charAt(0);
        if (receivedAction == 'C') {
            input.setText("0");
            inputOne = 0.0;
            inputTwo = 0.0;
            return;
        }
        if (receivedAction == '<') { // clear button
            String temp = input.getText();

            if (temp.length() == 1) {
                input.setText("0");
                inputOne = 0.0;
                inputTwo = 0.0;

            } else
                input.setText(temp.substring(0, temp.length() - 1));
            return;
        }
        if (receivedAction == '=') {
            inputTwo = Double.parseDouble(input.getText());

            System.out.println(inputTwo);
            calculator.performOperation();
            return;
        }
        if (receivedAction == '.') {
            if (!input.getText().contains(".")) { // if for a input two times ' . ' is pressed
                input.setText(input.getText() + '.');
            }
            return;
        }
        if (calculator.isOperator(receivedAction)) {
            if(operator.equals("")){
            inputOne = Double.parseDouble(input.getText());
            System.out.println(inputOne);
            }
            operator = "" + receivedAction;
            System.out.println(operator);
            input.setText("0");
            return;
        }
        if (Character.isDigit(receivedAction)) {
            if (input.getText().length() > 7) {
                return;
            }
            calculator.processInput(receivedAction);
            return;
        }

    }

    class Calculator {
        void performOperation() {
            double value = 0.0;
            if (operator.equals("+")) {
                value = inputOne + inputTwo;

            }
            if (operator.equals("-")) {
                value = inputOne - inputTwo;
            }
            if (operator.equals("X")) {
                value = inputOne * inputTwo;

            }
            if (operator.equals("/")) {
                value = inputOne / inputTwo;
                input.setText(Double.toString(((double) Math.round((inputOne / inputTwo) * 10000d) / 10000d)));
            }
            if (operator.equals("x")) {// for power
                value = 1.0;
                for (int table = 1; table <= inputTwo; table++) {
                    value *= inputOne;
                }

            }
            DecimalFormat formatter;

            if (value - (int) value > 0.0)
                formatter = new DecimalFormat("0.0000");
            else
                formatter = new DecimalFormat("0");

            input.setText(formatter.format(value));
            inputOne = 0.0;
            inputTwo = 0.0;
            operator = "";
            return;

        }

        boolean isOperator(char receivedAction) { // for power
            // if (!operator.equals("")) {// if for a input two times operator is pressed
            //     return false;
            // }
            if (receivedAction == '+' || receivedAction == '-' || receivedAction == '/' || receivedAction == 'X'
                    || receivedAction == 'x') {
                return true;
            }
            return false;
        }

        void processInput(char receivedAction) {
            if (input.getText().equals("0")) {
                input.setText("" + receivedAction);
            } else
                input.setText(input.getText() + receivedAction);

        }
    }

    public static void main(String[] args) {
        CalculatorFrame s = new CalculatorFrame();
        s.setResizable(false);
    }
}
