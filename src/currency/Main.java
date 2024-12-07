package currency;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_inputvalue;
	private static double result;
	private static JComboBox<String> curen;
	private static double firslt;
	private JTextField textField_Thb;
	private JLabel Baht;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try

				{

					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public Main() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(86, 10, 377, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Curency convert System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 355, 47);
		panel.add(lblNewLabel);
		String[] Currency =
		{ "USD", "EUR", "JPY", "GBP", "CNY", "AUD", "CAD", "CHF", "HKD", "SGD", "SEK", "KRW", "NOK", "NZD", "INR",
				"TWD", "ZAR", "BRL", "ILS", "IDR", "AED", "PHP", "MYR", "COP", "RUB", "LAK", "MMK", "TRY", "VND"};

		curen = new JComboBox(Currency);
		curen.setBackground(Color.LIGHT_GRAY);
		curen.setFont(new Font("Tahoma", Font.BOLD, 14));
		curen.setBounds(319, 87, 120, 34);
		contentPane.add(curen);

		textField_inputvalue = new JTextField();
		textField_inputvalue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_inputvalue.setBounds(92, 87, 185, 34);
		contentPane.add(textField_inputvalue);
		textField_inputvalue.setColumns(10);
		
		textField_Thb = new JTextField();
		textField_Thb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Thb.setColumns(10);
		textField_Thb.setBounds(92, 152, 185, 34);
		contentPane.add(textField_Thb);
		

		if (curen.getSelectedItem() != null)
			refreshData();

		curen.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				refreshData();

			}
		});

		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				
				if (textField_inputvalue.getText().isEmpty() && textField_Thb.getText().isEmpty())
				{

					JOptionPane.showMessageDialog(null, "Please input value");
					return;
				}
				try
				{
					
				if (!textField_inputvalue.getText().isEmpty()&&textField_Thb.getText().isEmpty())
				{
					textField_Thb.setText("");					
					double last = Double.parseDouble(textField_inputvalue.getText());
					result = firslt*last;

					String s = String.valueOf(String.format("%.2f", result));
					textField_Thb.setText(s);
			

				} else if (!textField_Thb.getText().isEmpty()&&textField_inputvalue.getText().isEmpty())
				{
		
					double last = Double.parseDouble(textField_Thb.getText());
					result = last / firslt;
					String s = String.valueOf(String.format("%.2f", result));

					textField_inputvalue.setText(s);
					
				}
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid number format. Please enter a valid number.");
				}
			

			}
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnNewButton.setBounds(223, 221, 128, 40);
		contentPane.add(btnNewButton);
		
		Baht = new JLabel("บาท");
		Baht.setBackground(Color.DARK_GRAY);
		Baht.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Baht.setBounds(319, 152, 94, 34);
		contentPane.add(Baht);
		refreshData();


	}

	public static double getToRate(String text)
	{

		double rate = 0.0;
		// compare with thb 22 ก.ย. 13:55 UTC ·

		switch (text)
		{
		case "USD":
			rate = 32.93;
			break;
		case "EUR":
			rate = 32.93;
			break;
		case "JPY":
			rate = 0.23;
			break;
		case "GBP":
			rate = 43.87;
			break;
		case "CNY":
			rate = 4.67;
			break;
		case "AUD":
			rate = 22.49;
			break;
		case "CAD":
			rate = 24.24;
			break;
		case "CHF":
			rate = 38.84;
			break;
		case "HKD":
			rate = 4.23;
			break;
		case "SGD":
			rate = 25.50;
			break;
		case "SEK":
			rate = 3.24;
			break;
		case "KRW":
			rate = 0.025;
			break;
		case "NOK":
			rate = 3.14;
			break;
		case "NZD":
			rate = 20.60;
			break;
		case "INR":
			rate = 0.40;
			break;
		case "TWD":
			rate = 1.03;
			break;
		case "ZAR":
			rate = 1.89;
			break;
		case "BRL":
			rate = 5.97;
			break;
		case "ILS":
			rate = 8.71;
			break;
		case "IDR":
			rate = 0.0022;
			break;
		case "AED":
			rate = 8.96;
			break;
		case "PHP":
			rate = 0.59;
			break;
		case "MYR":
			rate = 7.78;
			break;
		case "COP":
			rate = 0.0079;
			break;
		case "RUB":
			rate = 0.36;
			break;
		case "LAK":
			rate = 0.0015;
			break;
		case "MMK":
			rate = 0.01567;
			break;
		case "TRY":
			rate = 0.97;
			break;
		case "VND":
			rate = 0.0013;
			break;

		}

		return rate;

	}

	public void refreshData()
	{

		String cur = curen.getSelectedItem().toString();
		firslt = getToRate(cur);
		
		textField_inputvalue.setText("");
		textField_Thb.setText("");
	

	}
}
