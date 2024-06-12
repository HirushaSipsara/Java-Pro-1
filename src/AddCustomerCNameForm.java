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

        JPanel Top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Top.setBackground(Color.CYAN);
        JLabel titleLabel=new JLabel("Add Customer Company");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);
        Top.add(titleLabel);
        add("North",Top);

        i=UpdateCustomerForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(133, 232, 210));
        btnAddCustomer=new JButton("Add Customer Company");
        btnAddCustomer.setBackground(new Color(125, 19, 234));
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){

                String Ncname=txtCName.getText();
                CustomerMainForm.contactLIST.get(i).setCname(Ncname);
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
        JLabel lblName=new JLabel("Company Name");
        lblName.setFont(new Font("",1,20));
        nameTextArea.add(lblName);
        labelPanel.add(nameTextArea);

        txtCName=new JTextField(10);
        txtCName.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.setBackground(new Color(133, 232, 210));
        nameTextPanel.add(txtCName);
        labelPanel.add(nameTextPanel);

        add("Center",labelPanel);

    }
}
