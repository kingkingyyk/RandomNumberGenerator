package RandomNumberGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import javax.swing.UIManager;

public class RandomNumberGenerator {

	public static MathContext mc=new MathContext(20);
	
	public static BigDecimal [] randomNumbers (int k, BigInteger [] m, BigInteger [] a, BigInteger [] x0, int n) {
		BigInteger maxM=BigInteger.ONE;
		for (BigInteger bi : m) if (bi.compareTo(maxM)>0) maxM=bi;
		
		BigInteger [][] values=new BigInteger[n+1][k];
		for (int i=0;i<k;i++) values[0][i]=x0[i];
		
		BigInteger [] combinedValues=new BigInteger[n+1];
		combinedValues[0]=BigInteger.ZERO;
		
		for (int i=1;i<=n;i++) {
			for (int i2=0;i2<k;i2++) values[i][i2]=a[i2].multiply(values[i-1][i2]).mod(m[i2]);

			combinedValues[i]=BigInteger.ZERO;
			for (int i2=0;i2<k;i2++) combinedValues[i]=combinedValues[i].add(new BigInteger(String.valueOf((i2%2)*-1)).multiply(values[i][i2]));

			combinedValues[i]=combinedValues[i].mod(maxM);
		}
		
		BigDecimal [] returnValues=new BigDecimal[n+1];
		returnValues[0]=new BigDecimal(maxM.subtract(BigInteger.ONE)).divide(new BigDecimal(maxM),mc);
		for (int i=1;i<=n;i++) returnValues[i]=new BigDecimal(combinedValues[i]).divide(new BigDecimal(maxM),mc);

		return returnValues;
	}
	
	public static boolean isStrNumber(String s) {
		for (char c : s.toCharArray())
			if (!Character.isDigit(c)) return false;
		return true;
	}
	
	public static void main (String [] args) {
		/*
		 * k=2
		 * m=2147483563;2147483399
		 * a=40014;40692
		 * x0=123;567
		 * n=100
		}*/
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		UI ui=new UI();
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}
	
}
