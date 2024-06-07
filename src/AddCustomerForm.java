import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerForm extends JFrame{
    private final JButton btnAddCustomer;
    private final JButton btnCancel;

    private final JTextField txtId;
    private final JTextField txtName;
    private final JTextField txtNo;
    private final JTextField txtCName;
    private final JTextField txtSalary;
    private final JTextField txtBirth;


    AddCustomerForm(){
        setSize(400,300);
        setTitle("Add Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Add Customer Form");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddCustomer=new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("",1,20));
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String id=txtId.getText();
                String name=txtName.getText();
                String no=txtNo.getText();
                String cName=txtCName.getText();
                double salary=Double.parseDouble(txtSalary.getText());
                String birth=txtBirth.getText();
                Contact contact =new Contact(id,name,no,cName,salary,birth);
                CustomerMainForm.contactLIST.add(contact);
            }
        });

        buttonPanel.add(btnAddCustomer);

        btnCancel=new JButton("Cancel");
        btnCancel.setFont(new Font("",1,20));
        buttonPanel.add(btnCancel);

        add("South",buttonPanel);

        JPanel labelPanel=new JPanel(new GridLayout(6,1,3,3));
        JLabel lblId=new JLabel("Customer Id");
        lblId.setFont(new Font("",1,20));
        labelPanel.add(lblId);

        JLabel lblName=new JLabel("Name");
        lblName.setFont(new Font("",1,20));
        labelPanel.add(lblName);

        JLabel lblAddress=new JLabel("Phone No");
        lblAddress.setFont(new Font("",1,20));
        labelPanel.add(lblAddress);

        JLabel lblCName =new JLabel("Company Name");
        lblCName.setFont(new Font("",1,20));
        labelPanel.add(lblCName);

        JLabel lblSalary=new JLabel("Salary");
        lblSalary.setFont(new Font("",1,20));
        labelPanel.add(lblSalary);

        JLabel lblBirth=new JLabel("Date of Birth");
        lblBirth.setFont(new Font("",1,20));
        labelPanel.add(lblBirth);

        add("West",labelPanel);

        JPanel textPanel=new JPanel(new GridLayout(6,1,3,3));
        txtId=new JTextField(6);
        txtId.setFont(new Font("",1,20));
        JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(txtId);
        textPanel.add(idTextPanel);

        txtName=new JTextField(10);
        txtName.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtNo=new JTextField(15);
        txtNo.setFont(new Font("",1,20));
        JPanel noTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        noTextPanel.add(txtNo);
        textPanel.add(noTextPanel);

        txtCName=new JTextField(15);
        txtCName.setFont(new Font("",1,20));
        JPanel CNameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        CNameTextPanel.add(txtCName);
        textPanel.add(CNameTextPanel);

        txtSalary=new JTextField(6);
        txtSalary.setFont(new Font("",1,20));
        JPanel salaryTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirth=new JTextField(10);
        txtBirth.setFont(new Font("",1,20));
        JPanel birthTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthTextPanel.add(txtBirth);
        textPanel.add(birthTextPanel);

        add("East",textPanel);

    }
}
