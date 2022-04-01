/*
Filename: HelloWorldClient.java
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.*;
import java.awt.event.*;

/*
Classname: HelloWorldClient
Comment: The RMI client.
*/

public class Client{ 

	static JFrame f;
 

    static JTextField l;
 

    String s0, s1, s2;

	static Double message = 0.0;

	static boolean sumAction = false;
	static String firstPart = "";
	static String secondPart = "";
	static String arithmeticOperator = "";

	static IF obj = null;

public static void main(String args[])
{
	try {

		f = new JFrame("calculator");
 
        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
 
 
        // create a textfield
        l = new JTextField(16);
 
        // set the textfield to non editable
        l.setEditable(false);
 
        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
 
        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
 
        // equals button
        beq1 = new JButton("=");
 
        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");
 
        // create . button
        be = new JButton(".");
 
        // create a panel
        JPanel p = new JPanel();
 
        
        bm.addActionListener(new multiplyButton());
        bd.addActionListener(new divideButton());
        bs.addActionListener(new subtractButton());
        ba.addActionListener(new additionButton());
        b9.addActionListener(new nineButton());
        b8.addActionListener(new eightButton());
        b7.addActionListener(new sevenButton());
        b6.addActionListener(new sixButton());
        b5.addActionListener(new fiveButton());
        b4.addActionListener(new fourButton());
        b3.addActionListener(new threeButton());
        b2.addActionListener(new twoButton());
        b1.addActionListener(new oneButton());
        b0.addActionListener(new zeroButton());
        be.addActionListener(new decimalButton());
        beq.addActionListener(new clearButton());
        beq1.addActionListener(new equalsButton());
 
        p.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);
 
 
        // add panel to frame
        f.add(p);
 
        f.setSize(200, 220);
        f.show();
	}
	catch (Exception e) {
		System.out.println("\n\n\n Client exception: \n\n\n"
				+ e.getMessage());
		e.printStackTrace();
	}
}

private static class multiplyButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(sumAction == false){
			l.setText(l.getText() + "x");
			sumAction = true;
			arithmeticOperator = "x";
		}
	}
}

private static class divideButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(sumAction == false){
			l.setText(l.getText() + "/");
			sumAction = true;
			arithmeticOperator = "/";
		}
	}
}

private static class subtractButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(sumAction == false){
			l.setText(l.getText() + "-");
			sumAction = true;
			arithmeticOperator = "-";
		}
	}
}

private static class additionButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(sumAction == false){
			l.setText(l.getText() + "+");
			sumAction = true;
			arithmeticOperator = "+";
		}
	}
}

private static class clearButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText("");
		sumAction = false;
		arithmeticOperator = "";
		firstPart = "";
		secondPart = "";
	}
}

private static class zeroButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "0");

		if(sumAction == false){ firstPart = firstPart + "0";} 
		else { secondPart = secondPart + "0"; }
	}
}

private static class oneButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "1");
		if(sumAction == false){ firstPart = firstPart + "1";} 
		else { secondPart = secondPart + "1"; }
	}
}

private static class twoButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "2");
		if(sumAction == false){ firstPart = firstPart + "2";} 
		else { secondPart = secondPart + "2"; }
	}
}

private static class threeButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "3");
		if(sumAction == false){ firstPart = firstPart + "3";} 
		else { secondPart = secondPart + "3"; }
	}
}

private static class fourButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "4");
		if(sumAction == false){ firstPart = firstPart + "4";} 
		else { secondPart = secondPart + "4"; }
	}
}

private static class fiveButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "5");
		if(sumAction == false){ firstPart = firstPart + "5";} 
		else { secondPart = secondPart + "5"; }
	}
}

private static class sixButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "6");
		if(sumAction == false){ firstPart = firstPart + "6";} 
		else { secondPart = secondPart + "6"; }
	}
}

private static class sevenButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "7");
		if(sumAction == false){ firstPart = firstPart + "7";} 
		else { secondPart = secondPart + "7"; }
	}
}

private static class eightButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "8");
		if(sumAction == false){ firstPart = firstPart + "8";} 
		else { secondPart = secondPart + "8"; }
	}
}

private static class nineButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "9");
		if(sumAction == false){ firstPart = firstPart + "9";} 
		else { secondPart = secondPart + "9"; }
	}
}

private static class decimalButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(l.getText().endsWith(".")){}
		else{
			l.setText(l.getText() + ".");
		}
	}
}

private static class equalsButton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		l.setText(l.getText() + "=");

		try{
			if(firstPart != "" && secondPart != "" && arithmeticOperator != ""){
				obj = (IF)Naming.lookup("//"
						+ "localhost:6060"
						+ "/Calculation");
				message = obj.calculation(Double.parseDouble(firstPart),Double.parseDouble(secondPart),arithmeticOperator);
				System.out.println("Message from the RMI-server was: \""
						+ message + "\"");
			}
		}
		catch (Exception r) {
			System.out.println("\n\n\n Client exception: \n\n\n"
					+ r.getMessage());
			r.printStackTrace();
		}
	}
}


}