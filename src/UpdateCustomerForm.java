import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class UpdateCustomerForm extends JFrame{
    private JButton btnEnter;
    private JTextField txtSearch;
    private DefaultTableModel dtm;
    public static int index;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtNo;
    private JTextField txtCName;
    private JTextField txtSalary;
    private JTextField txtBirth;

    private JButton btnUpdateName;
    private JButton btnUpdateNo;
    private JButton btnCName;
    private JButton btnSalary;

    private AddCustomerNameForm addCustomerNameForm;
    private AddCustomerNoForm addCustomerNoForm;
    private AddCustomerCNameForm addCustomerCNameForm;
    private AddCustomerSalaryForm addCustomerSalaryForm;

    UpdateCustomerForm() {
        setSize(600, 400);
        setTitle("View Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel upperPanel = new JPanel(new GridLayout(2, 1, 3, 3));
        JLabel titleLabel = new JLabel("Search Customer Form");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        upperPanel.add(titleLabel);

        JPanel searchPanel = new JPanel(new GridLayout(1, 2, 3, 3));
        JLabel lblsearch = new JLabel("Search");
        lblsearch.setFont(new Font("", Font.BOLD, 20));
        searchPanel.add(lblsearch);

        JPanel barPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSearch = new JTextField(15);
        txtSearch.setFont(new Font("", Font.BOLD, 20));
        barPanel.add(txtSearch);
        searchPanel.add(barPanel);

        upperPanel.add(searchPanel);
        add("North", upperPanel);

        JPanel downPanel = new JPanel(new GridLayout(2, 3, 3, 3));
        btnEnter = new JButton("Enter");
        btnEnter.setFont(new Font("", Font.BOLD, 20));
        downPanel.add(btnEnter);

        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean found = false; // Flag to check if contact is found
                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++) {
                    Contact contact = CustomerMainForm.contactLIST.get(i);
                    if (txtSearch.getText().equals(contact.getName()) || txtSearch.getText().equals(contact.getNo())) {
                        index=i;
                        txtId.setText(contact.getId());
                        txtName.setText(contact.getName());
                        txtNo.setText(contact.getNo());
                        txtCName.setText(contact.getCName());
                        txtSalary.setText(String.valueOf(contact.getSalary()));
                        txtBirth.setText(contact.getBirth());
                        found = true; // Contact found
                        break; // Exit loop once contact is found
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Contact not found.");
                }
            }
        });
        btnUpdateName=new JButton("Update Name");
        btnUpdateName.setFont(new Font("",1,20));
        btnUpdateName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addCustomerNameForm==null){
                    addCustomerNameForm=new AddCustomerNameForm();
                }
                addCustomerNameForm.setVisible(true);
            }
        });
        downPanel.add(btnUpdateName);

        btnUpdateNo=new JButton("Update Pno");
        btnUpdateNo.setFont(new Font("",1,20));
        btnUpdateNo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addCustomerNoForm==null){
                    addCustomerNoForm=new AddCustomerNoForm();
                }
                addCustomerNoForm.setVisible(true);
            }
        });
        downPanel.add(btnUpdateNo);

        btnCName=new JButton("Update Company");
        btnCName.setFont(new Font("",1,20));
        btnCName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addCustomerCNameForm==null){
                    addCustomerCNameForm=new AddCustomerCNameForm();
                }
                addCustomerCNameForm.setVisible(true);
            }
        });
        downPanel.add(btnCName);

        btnSalary=new JButton("Update Salary");
        btnSalary.setFont(new Font("",1,20));
        btnSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addCustomerSalaryForm==null){
                    addCustomerSalaryForm=new AddCustomerSalaryForm();
                }
                addCustomerSalaryForm.setVisible(true);
            }
        });
        downPanel.add(btnSalary);

        add("South", downPanel);

        JPanel labelPanel = new JPanel(new GridLayout(6, 1, 3, 3));
        labelPanel.setBackground(new Color(66, 144, 253, 255));

        JLabel lblId = new JLabel("Contact ID - ");
        lblId.setFont(new Font("", Font.BOLD, 20));
        labelPanel.add(lblId);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("", Font.BOLD, 20));
        labelPanel.add(lblName);

        JLabel lblAddress = new JLabel("Phone No");
        lblAddress.setFont(new Font("", Font.BOLD, 20));
        labelPanel.add(lblAddress);

        JLabel lblCName = new JLabel("Company Name");
        lblCName.setFont(new Font("", Font.BOLD, 20));
        labelPanel.add(lblCName);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("", Font.BOLD, 20));
        labelPanel.add(lblSalary);

        JLabel lblBirth = new JLabel("Date of Birth");
        lblBirth.setFont(new Font("", Font.BOLD, 20));
        labelPanel.add(lblBirth);

        add("West", labelPanel);

        JPanel textPanel = new JPanel(new GridLayout(6, 1, 3, 3));
        textPanel.setBackground(new Color(66, 144, 253, 255));

        txtId = new JTextField();
        txtId.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtId);

        txtName = new JTextField();
        txtName.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtName);

        txtNo = new JTextField();
        txtNo.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtNo);

        txtCName = new JTextField();
        txtCName.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtCName);

        txtSalary = new JTextField();
        txtSalary.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtSalary);

        txtBirth = new JTextField();
        txtBirth.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtBirth);

        add("Center", textPanel);
    }
}
