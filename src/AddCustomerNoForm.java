import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerNoForm extends JFrame{
    private final JButton btnAddCustomer;
    private final JButton btnCancel;
    private int i;
    private final JTextField txtNo;

    AddCustomerNoForm(){
        setSize(400,300);
        setTitle("Add Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Add Customer Form");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        i=UpdateCustomerForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddCustomer=new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("",1,20));
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String Nno=txtNo.getText();
                CustomerMainForm.contactLIST.get(i).setNo(Nno);
            }
        });

        buttonPanel.add(btnAddCustomer);

        btnCancel=new JButton("Cancel");
        btnCancel.setFont(new Font("",1,20));
        buttonPanel.add(btnCancel);

        add("South",buttonPanel);

        JPanel labelPanel=new JPanel(new GridLayout(1,1,3,3));

        JLabel lblName=new JLabel("Name");
        lblName.setFont(new Font("",1,20));
        labelPanel.add(lblName);


        add("West",labelPanel);

        JPanel textPanel=new JPanel(new GridLayout(6,1,3,3));


        txtNo=new JTextField(10);
        txtNo.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtNo);
        textPanel.add(nameTextPanel);



        add("East",textPanel);

    }
}
