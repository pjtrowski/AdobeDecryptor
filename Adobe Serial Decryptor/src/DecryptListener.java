import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DecryptListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String tem=input.getText();

	}
	public static String decrypt(String encryptedKey) {
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
