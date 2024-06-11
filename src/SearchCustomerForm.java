import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchCustomerForm extends JFrame {
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtNo;
    private JTextField txtCName;
    private JTextField txtSalary;
    private JTextField txtBirth;

    private JButton cns;
    private JButton Home;

    SearchCustomerForm() {
        setSize(450,500);
        setTitle("View Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel Top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Top.setBackground(Color.CYAN);
        JLabel heading = new JLabel("Search Contacts");
        heading.setFont(new Font("", Font.BOLD, 35));
        Top.add(heading);

        JPanel searchPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField searchby = new JTextField("", 15);
        searchby.setFont(new Font("", 0, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 0); // No margin
        searchPanel.add(searchby, gbc);

        JButton search = new JButton("Search");
        search.setFont(new Font("", 1, 20));
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean found = false;
                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++) {
                    Contact contact = CustomerMainForm.contactLIST.get(i);
                    if (searchby.getText().equals(contact.getName()) || searchby.getText().equals(contact.getNo())) {
                        txtId.setText(contact.getId());
                        txtName.setText(contact.getName());
                        txtNo.setText(contact.getNo());
                        txtCName.setText(contact.getCName());
                        txtSalary.setText(String.valueOf(contact.getSalary()));
                        txtBirth.setText(contact.getBirth());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 0); // Add a small right margin to reduce the gap

        searchPanel.add(search, gbc);

        JPanel TopPanel = new JPanel(new BorderLayout());
        TopPanel.add("North", Top);
        TopPanel.add("South", searchPanel);

        add("North", TopPanel);

        JPanel Displayl = new JPanel(new GridLayout(6, 2));

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("", 1, 20));
        JPanel lblidpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblidpanel.add(lblid);
        Displayl.add(lblidpanel);

        JPanel txtidpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtId = new JTextField(6);
        txtId.setFont(new Font("", Font.BOLD, 20));
        txtidpanel.add(txtId);
        Displayl.add(txtidpanel);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("", 1, 20));
        JPanel lblnamepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblnamepanel.add(lblname);
        Displayl.add(lblnamepanel);

        JPanel txtnamepanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtName = new JTextField(10);
        txtName.setFont(new Font("", Font.BOLD, 20));
        txtnamepanel.add(txtName);
        Displayl.add(txtnamepanel);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setFont(new Font("", 1, 20));
        JPanel lblphonepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblphonepanel.add(lblphone);
        Displayl.add(lblphonepanel);

        JPanel txtNopanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtNo = new JTextField(10);
        txtNo.setFont(new Font("", Font.BOLD, 20));
        txtNopanel.add(txtNo);
        Displayl.add(txtNopanel);

        JLabel lblcompany = new JLabel("Company");
        lblcompany.setFont(new Font("", 1, 20));
        JPanel lblcompanypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblcompanypanel.add(lblcompany);
        Displayl.add(lblcompanypanel);

        JPanel txtCNamepanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtCName = new JTextField(10);
        txtCName.setFont(new Font("", Font.BOLD, 20));
        txtCNamepanel.add(txtCName);
        Displayl.add(txtCNamepanel);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setFont(new Font("", 1, 20));
        JPanel lblsalarypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblsalarypanel.add(lblsalary);
        Displayl.add(lblsalarypanel);

        JPanel txtSalarypanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSalary = new JTextField(10);
        txtSalary.setFont(new Font("", Font.BOLD, 20));
        txtSalarypanel.add(txtSalary);
        Displayl.add(txtSalarypanel);

        JLabel lblbday = new JLabel("Birthday");
        lblbday.setFont(new Font("", 1, 20));
        JPanel lblbdaypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblbdaypanel.add(lblbday);
        Displayl.add(lblbdaypanel);

        JPanel txtBirthpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBirth = new JTextField(10);
        txtBirth.setFont(new Font("", Font.BOLD, 20));
        txtBirthpanel.add(txtBirth);
        Displayl.add(txtBirthpanel);

        add("Center", Displayl);
        JPanel ButtonPanel =new JPanel(new BorderLayout());
        JPanel btntoppanel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel btnbottompanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));


        cns=new JButton("Cancel");
        cns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new SearchCustomerForm().setVisible(true);
            }
        });
        btntoppanel.add(cns);

        ButtonPanel.add("North",btntoppanel);

        Home=new JButton("Go To HomePage");
        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new CustomerMainForm().setVisible(true);
            }
        });
        btnbottompanel.add(Home);

        ButtonPanel.add("South",btnbottompanel);

        add("South",ButtonPanel);
    }

}
