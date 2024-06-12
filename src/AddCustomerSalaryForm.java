import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerSalaryForm extends JFrame{
    private final JButton btnAddCustomer;
    private final JButton btnCancel;
    private int i;
    private final JTextField txtSalary;

    AddCustomerSalaryForm(){
        setSize(400,200);
        setTitle("Add Customer Salary Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel Top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Top.setBackground(Color.CYAN);
        JLabel titleLabel=new JLabel("Add Customer Salary");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);
        Top.add(titleLabel);
        add("North",Top);

        i=UpdateCustomerForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(133, 232, 210));
        btnAddCustomer=new JButton("Add Customer Salary");
        btnAddCustomer.setBackground(new Color(125, 19, 234));
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                double Nsalary=Double.parseDouble(txtSalary.getText());
                CustomerMainForm.contactLIST.get(i).setSalary(Nsalary);
                dispose();
            }
        });

        buttonPanel.add(btnAddCustomer);

        btnCancel=new JButton("Cancel");
        btnCancel.setBackground(new Color(255, 51, 51));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        buttonPanel.add(btnCancel);

        add("South",buttonPanel);

        JPanel labelPanel=new JPanel(new GridLayout(1,2,3,3));
        labelPanel.setBackground(new Color(133, 232, 210));

        JPanel nameTextArea =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextArea.setBackground(new Color(133, 232, 210));
        JLabel lblSalary=new JLabel("Salary");
        lblSalary.setFont(new Font("",1,20));
        nameTextArea.add(lblSalary);
        labelPanel.add(nameTextArea);

        txtSalary=new JTextField(10);
        txtSalary.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.setBackground(new Color(133, 232, 210));
        nameTextPanel.add(txtSalary);
        labelPanel.add(nameTextPanel);

        add("Center",labelPanel);

    }
}
