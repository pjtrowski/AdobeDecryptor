
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class Decryptor {
	
	JTextField input;
	JButton decrypt;
	JLabel label3;
	
	public static void main(String[] args)
	{
		 new Decryptor().go();	
		
	}
	public void go() {
		
		
		JFrame frame=new JFrame("Adobe Serial Numer Decryptor");
		frame.setSize(410,200);
		
	
		JPanel panel=new JPanel();
		panel.setBackground(Color.BLACK);
		Font font=new Font("Times New Roman",Font.PLAIN,15);
		
		frame.add(panel);
		
		JLabel label1=new JLabel("Type in encrypted SN");
		label1.setFont(font);
		label1.setForeground(Color.WHITE);
		panel.add(label1);
		panel.setLayout(new FlowLayout());
		
		input=new JTextField(20);
		panel.add(input);
		
		decrypt=new JButton("Decrypt");
		panel.add(decrypt);
		decrypt.addActionListener(new DecryptListener());
		label3=new JLabel();
		Font resFont=new Font("Times New Roman",Font.BOLD,15);
		label3.setFont(resFont);
		label3.setForeground(Color.WHITE);
		panel.add(label3);
		label3.setVisible(false);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public class DecryptListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String temp=input.getText();
			label3.setText("This is your Adobe Serial: "+ decrypt(temp));
			label3.setVisible(true);

		}
		public String decrypt(String encryptedKey) {
		    String[] AdobeCipher = { "0000000001", "5038647192", "1456053789", "2604371895", "4753896210", "8145962073",
		            "0319728564", "7901235846", "7901235846", "0319728564", "8145962073", "4753896210", "2604371895",
		            "1426053789", "5038647192", "3267408951", "5038647192", "2604371895", "8145962073", "7901235846",
		            "3267408951", "1426053789", "4753896210", "0319728564" };

		    String sAdobeDecryptedKey = "";
		    for (int i = 0; i < 24; i++) {
		        if (i % 4 == 0 && i > 0)
		            sAdobeDecryptedKey += '-';
		        String ndx=encryptedKey.substring(i, i+1);
		        int tmp=Integer.parseInt(ndx);
		        sAdobeDecryptedKey += AdobeCipher[i].substring(tmp, tmp+1);
		    }
		    return sAdobeDecryptedKey;
		}

	}

}
