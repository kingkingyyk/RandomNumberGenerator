package RandomNumberGenerator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class UI extends JFrame {
	private static final long serialVersionUID = -8119256365777167259L;
	private JPanel contentPane;
	private JTextField textFieldK;
	private JTextField textFieldm;
	private JTextField textFielda;
	private JTextField textFieldx0;
	private JTextField textFieldN;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("Random Number Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("m :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblA = new JLabel("a :");
		lblA.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblK = new JLabel("k :");
		lblK.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblX = new JLabel("x0 :");
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNumbers = new JLabel("Numbers :");
		lblNumbers.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldK = new JTextField();
		textFieldK.setColumns(10);
		
		textFieldm = new JTextField();
		textFieldm.setColumns(10);
		
		textFielda = new JTextField();
		textFielda.setColumns(10);
		
		textFieldx0 = new JTextField();
		textFieldx0.setColumns(10);
		
		textFieldN = new JTextField();
		textFieldN.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sk=textFieldK.getText();
				int k=0;
				if (sk==null || sk.isEmpty() || !RandomNumberGenerator.isStrNumber(sk)) {
					JOptionPane.showMessageDialog(null,"Invalid k value","",JOptionPane.OK_OPTION);
					return;
				}
				k=Integer.parseInt(sk);
				//=======
				String sm=textFieldm.getText();
				if (sk==null || sk.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Input m values","",JOptionPane.OK_OPTION);
					return;
				} else if (sm.split(";").length!=k) {
					JOptionPane.showMessageDialog(null,"m's number count must be same with k","",JOptionPane.OK_OPTION);
					return;
				}
				BigInteger [] m=new BigInteger[k];
				for (int i=0;i<sm.split(";").length;i++) m[i]=new BigInteger(sm.split(";")[i]);
				//=======	
				String sa=textFielda.getText();
				if (sk==null || sk.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Input a values","",JOptionPane.OK_OPTION);
					return;
				} else if (sa.split(";").length!=k) {
					JOptionPane.showMessageDialog(null,"a's number count must be same with k","",JOptionPane.OK_OPTION);
					return;
				}
				BigInteger [] a=new BigInteger[k];
				for (int i=0;i<sa.split(";").length;i++) a[i]=new BigInteger(sa.split(";")[i]);
				//=======
				String sx0=textFieldx0.getText();
				if (sk==null || sk.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Input x0 values","",JOptionPane.OK_OPTION);
					return;
				} else if (sx0.split(";").length!=k) {
					JOptionPane.showMessageDialog(null,"x0's number count must be same with k","",JOptionPane.OK_OPTION);
					return;
				}
				BigInteger [] x0=new BigInteger[k];
				for (int i=0;i<sx0.split(";").length;i++) x0[i]=new BigInteger(sx0.split(";")[i]);
				//=======
				String sn=textFieldN.getText();
				int n=0;
				if (sn==null || sn.isEmpty() || !RandomNumberGenerator.isStrNumber(sn)) {
					JOptionPane.showMessageDialog(null,"Invalid k value","",JOptionPane.OK_OPTION);
					return;
				}
				n=Integer.parseInt(sn);
				BigDecimal [] v=RandomNumberGenerator.randomNumbers(k,m,a,x0,n);
				
				while (table.getRowCount()>0) ((DefaultTableModel)table.getModel()).removeRow(0);
				
				for (int i=0;i<v.length;i++) ((DefaultTableModel)table.getModel()).addRow(new String [] {String.valueOf(i),v[i].toString()});
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("m,a,x0 has delimiter ;");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNumbers, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblA, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFielda, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldx0, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addComponent(textFieldN, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnGenerate, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblK))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFielda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblA))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblX)
								.addComponent(textFieldx0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNumbers)
								.addComponent(textFieldN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGenerate)
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1))))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"j", "Rj"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(1).setPreferredWidth(247);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
