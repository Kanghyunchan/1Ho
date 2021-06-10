import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame implements ActionListener {
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btn0;

	Button btnPlus;
	Button btnMinus;
	Button btnDiv;
	Button btnMul;
	Button btnResult;
	Button btnClear;

	TextField output;

	Panel btnPanel;

	String key;
	int firstNum;
	int step;

	void init() {
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");
		btn6 = new Button("6");
		btn7 = new Button("7");
		btn8 = new Button("8");
		btn9 = new Button("9");
		btn0 = new Button("0");

		btnPlus = new Button("+");
		btnMinus = new Button("-");
		btnDiv = new Button("/");
		btnMul = new Button("X");
		btnResult = new Button("=");
		btnClear = new Button("C");

		output = new TextField("0");

		btnPanel = new Panel();
	}

	public Calculator() {
		init();
		setTitle("����� �غ���");
		setSize(500, 500);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				dispose();
			}
		});

		setLayout(new BorderLayout());
		btnPanel.setLayout(new GridLayout(4, 4));

		btnPanel.add(btn7);
		btnPanel.add(btn8);
		btnPanel.add(btn9);
		btnPanel.add(btnPlus);
		btnPanel.add(btn4);
		btnPanel.add(btn5);
		btnPanel.add(btn6);
		btnPanel.add(btnMinus);
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		btnPanel.add(btnMul);
		btnPanel.add(btnClear);
		btnPanel.add(btn0);
		btnPanel.add(btnDiv);
		btnPanel.add(btnResult);

		add(output, BorderLayout.NORTH);
		add(btnPanel, BorderLayout.CENTER);

		EventBtn();
	}

	void EventBtn() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn0.addActionListener(this);

		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		btnResult.addActionListener(this);
		btnClear.addActionListener(this);

		output.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			if (output.getText().equals("0")) {
				output.setText("1");
			} else {
				output.setText(output.getText() + 1);
			}
		}
		if (e.getSource() == btn2) {
			if (output.getText().equals("0")) {
				output.setText("2");
			} else {
				output.setText(output.getText() + 2);
			}
		}
		if (e.getSource() == btn3) {
			if (output.getText().equals("0")) {
				output.setText("3");
			} else {
				output.setText(output.getText() + 3);
			}
		}
		if (e.getSource() == btn4) {
			if (output.getText().equals("0")) {
				output.setText("4");
			} else {
				output.setText(output.getText() + 4);
			}
		}
		if (e.getSource() == btn5) {
			if (output.getText().equals("0")) {
				output.setText("5");
			} else {
				output.setText(output.getText() + 5);
			}
		}
		if (e.getSource() == btn6) {
			if (output.getText().equals("0")) {
				output.setText("6");
			} else {
				output.setText(output.getText() + 6);
			}
		}
		if (e.getSource() == btn7) {
			if (output.getText().equals("0")) {
				output.setText("7");
			} else {
				output.setText(output.getText() + 7);
			}
		}
		if (e.getSource() == btn8) {
			if (output.getText().equals("0")) {
				output.setText("8");
			} else {
				output.setText(output.getText() + 8);
			}
		}
		if (e.getSource() == btn9) {
			if (output.getText().equals("0")) {
				output.setText("9");
			} else {
				output.setText(output.getText() + 9);
			}
		}
		if (e.getSource() == btn0) {
			if (output.getText().equals("0")) {
				output.setText("0");
			} else {
				output.setText(output.getText() + 0);
			}
		}
		if (e.getSource() == btnClear) {
			output.setText("0");
			firstNum = 0;
			step = 0;
		}
		if (e.getSource() == btnPlus) {
			key = "Plus";
			Operations();
		}
		if (e.getSource() == btnMinus) {
			key = "Minus";
			Operations();
		}
		if (e.getSource() == btnDiv) {
			key = "Div";
			Operations();
		}
		if (e.getSource() == btnMul) {
			key = "Mul";
			Operations();
		}
		if (e.getSource() == btnResult) {
			key = "Result";
			Operations();
		}
	}

	void Operations() {
		switch (key) {
		case "Plus":
			firstNum = Integer.parseInt(output.getText());
			output.setText("0");
			step = 1;
			break;

		case "Minus":
			firstNum = Integer.parseInt(output.getText());
			output.setText("0");
			step = 2;
			break;

		case "Mul":
			firstNum = Integer.parseInt(output.getText());
			output.setText("0");
			step = 3;
			break;

		case "Div":
			firstNum = Integer.parseInt(output.getText());
			output.setText("0");
			step = 4;
			break;

		case "Result":
			if (firstNum >= 1) {
				Result(step);
			}
			break;
		}
	}

	void Result(int key) {
		switch (key) {
		case 1:
			output.setText(String.valueOf(firstNum + Integer.parseInt(output.getText())));
			break;
		case 2:
			output.setText(String.valueOf(firstNum - Integer.parseInt(output.getText())));
			break;
		case 3:
			output.setText(String.valueOf(firstNum * Integer.parseInt(output.getText())));
			break;
		case 4:
			output.setText(String.valueOf(firstNum / Integer.parseInt(output.getText())));
			break;
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
