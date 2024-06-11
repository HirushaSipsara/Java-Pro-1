import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerNameForm extends JFrame{
    private final JButton btnAddCustomer;
    private final JButton btnCancel;
    private int i;
    private final JTextField txtName;

    AddCustomerNameForm(){
        setSize(400,200);
        setTitle("Add Customer Name Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Add Customer Name");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        i=UpdateCustomerForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddCustomer=new JButton("Add Name");
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String Nname=txtName.getText();
                CustomerMainForm.contactLIST.get(i).setName(Nname);
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
        JLabel lblName=new JLabel("Name");
        lblName.setFont(new Font("",1,20));
        nameTextArea.add(lblName);
        labelPanel.add(nameTextArea);

        txtName=new JTextField(10);
        txtName.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtName);
        labelPanel.add(nameTextPanel);

        add("Center",labelPanel);
    }
}
