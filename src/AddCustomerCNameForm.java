import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerCNameForm extends JFrame{
    private final JButton btnAddCustomer;
    private final JButton btnCancel;
    private int i;
    private final JTextField txtCName;

    AddCustomerCNameForm(){
        setSize(400,200);
        setTitle("Add Customer Company Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Add Customer Company");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        i=UpdateCustomerForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddCustomer=new JButton("Add Customer Company");
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){

                String Ncname=txtCName.getText();
                CustomerMainForm.contactLIST.get(i).setName(Ncname);
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
        JLabel lblName=new JLabel("Company Name");
        lblName.setFont(new Font("",1,20));
        nameTextArea.add(lblName);
        labelPanel.add(nameTextArea);

        txtCName=new JTextField(10);
        txtCName.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtCName);
        labelPanel.add(nameTextPanel);

        add("Center",labelPanel);

    }
}
