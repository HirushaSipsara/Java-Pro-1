import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerNoForm extends JFrame{
    private final JButton btnAddCustomer;
    private final JButton btnCancel;
    private int i;
    private final JTextField txtNo;

    AddCustomerNoForm(){
        setSize(400,200);
        setTitle("Add Customer Phone No Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Add Customer Phone No");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        i=UpdateCustomerForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddCustomer=new JButton("Add Phone No");
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String Nno=txtNo.getText();
                CustomerMainForm.contactLIST.get(i).setNo(Nno);
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
        JLabel lblNo=new JLabel("Phone No");
        lblNo.setFont(new Font("",1,20));
        nameTextArea.add(lblNo);
        labelPanel.add(nameTextArea);

        txtNo=new JTextField(10);
        txtNo.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtNo);
        labelPanel.add(nameTextPanel);

        add("Center",labelPanel);

    }
}
