import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchCustomerForm extends JFrame {
    private JButton btnEnter;
    private JTextField txtSearch;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtNo;
    private JTextField txtCName;
    private JTextField txtSalary;
    private JTextField txtBirth;

    SearchCustomerForm() {
        setSize(600,400);
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

        JPanel barPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSearch = new JTextField(15);
        txtSearch.setFont(new Font("", Font.BOLD, 20));
        barPanel.add(txtSearch);
        searchPanel.add(barPanel);

        upperPanel.add(searchPanel);
        add("North", upperPanel);

        btnEnter = new JButton("Enter");
        btnEnter.setFont(new Font("", Font.BOLD, 20));
        add("South", btnEnter);

        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++) {
                    Contact contact = CustomerMainForm.contactLIST.get(i);
                    if (txtSearch.getText().equals(contact.getName()) || txtSearch.getText().equals(contact.getNo())) {
                        txtId.setText(contact.getId());
                        txtName.setText(contact.getName());
                        txtNo.setText(contact.getNo());
                        txtCName.setText(contact.getCName());
                        txtSalary.setText(String.valueOf(contact.getSalary()));
                        txtBirth.setText(contact.getBirth());
                    }
                }
            }
        });

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

        JPanel textPanel=new JPanel(new GridLayout(5,1,3,3));
        textPanel.setBackground(new Color(66,144,253,255));
        txtName=new JTextField(10);
        txtName.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.setBackground(new Color(66,144,253,255));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtNo=new JTextField(15);
        txtNo.setFont(new Font("",1,20));
        JPanel noTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        noTextPanel.setBackground(new Color(66,144,253,255));
        noTextPanel.add(txtNo);
        textPanel.add(noTextPanel);

        txtCName=new JTextField(15);
        txtCName.setFont(new Font("",1,20));
        JPanel CNameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        CNameTextPanel.setBackground(new Color(66,144,253,255));
        CNameTextPanel.add(txtCName);
        textPanel.add(CNameTextPanel);

        txtSalary=new JTextField(6);
        txtSalary.setFont(new Font("",1,20));
        JPanel salaryTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.setBackground(new Color(66,144,253,255));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirth=new JTextField(10);
        txtBirth.setFont(new Font("",1,20));
        JPanel birthTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthTextPanel.setBackground(new Color(66,144,253,255));
        birthTextPanel.add(txtBirth);
        textPanel.add(birthTextPanel);

        add("Center", textPanel);
    }
}
