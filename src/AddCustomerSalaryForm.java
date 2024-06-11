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

        JLabel titleLabel=new JLabel("Add Customer Salary");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        i=UpdateCustomerForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddCustomer=new JButton("Add Customer Salary");
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                double Nsalary=Double.parseDouble(txtSalary.getText());
                CustomerMainForm.contactLIST.get(i).setSalary(Nsalary);
            }
        });

        buttonPanel.add(btnAddCustomer);

        btnCancel=new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        buttonPanel.add(btnCancel);

        add("South",buttonPanel);

        JPanel labelPanel=new JPanel(new GridLayout(1,2,3,3));

        JPanel nameTextArea =new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSalary=new JLabel("Salary");
        lblSalary.setFont(new Font("",1,20));
        nameTextArea.add(lblSalary);
        labelPanel.add(nameTextArea);

        txtSalary=new JTextField(10);
        txtSalary.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtSalary);
        labelPanel.add(nameTextPanel);

        add("Center",labelPanel);

    }
}
