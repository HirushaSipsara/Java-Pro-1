import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class DeleteCustomerForm extends JFrame {

    private JButton btnEnter;
    private JButton btnDelete;
    private JTextField txtSearch;
    private DefaultTableModel dtm;
    private int x = -1; // Default value indicating no contact is selected

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtNo;
    private JTextField txtCName;
    private JTextField txtSalary;
    private JTextField txtBirth;

    private JButton cns;
    private JButton Home;

    DeleteCustomerForm() {
        setSize(450, 500);
        setTitle("Delete Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel Top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Top.setBackground(Color.CYAN);
        JLabel heading = new JLabel("Delete Contacts");
        heading.setFont(new Font("", Font.BOLD, 35));
        Top.add(heading);

        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBackground(new Color(133, 232, 210));
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
        search.setBackground(new Color(13, 185, 125)); // Dark Green
        search.setForeground(Color.WHITE);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean found = false;
                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++) {
                    Contact contact = CustomerMainForm.contactLIST.get(i);
                    if (searchby.getText().equals(contact.getName()) || searchby.getText().equals(contact.getNo())) {
                        x = i;
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

        JPanel ButtonPanel = new JPanel(new BorderLayout());
        ButtonPanel.setBackground(new Color(133, 232, 210));
        JPanel btntoppanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btntoppanel.setBackground(new Color(133, 232, 210));
        JPanel btnbottompanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnbottompanel.setBackground(new Color(133, 232, 210));

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(255, 51, 51)); // Red
        btnDelete.setForeground(Color.WHITE);
        btntoppanel.add(btnDelete);

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (x != -1) {
                    CustomerMainForm.contactLIST.remove(x);
                    dtm.removeRow(x);
                    JOptionPane.showMessageDialog(null, "Contact deleted.");
                    x = -1;
                    dispose();
                    new DeleteCustomerForm().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No contact selected for deletion.");
                }
            }
        });
        ButtonPanel.add("East", btntoppanel);

        cns = new JButton("Cancel");
        cns.setBackground(new Color(255, 51, 51)); // Red
        cns.setForeground(Color.WHITE);
        cns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new DeleteCustomerForm().setVisible(true);
            }
        });
        btntoppanel.add(cns);

        ButtonPanel.add("North", btntoppanel);

        Home = new JButton("Go To HomePage");
        Home.setBackground(new Color(125, 19, 234)); // Blue
        Home.setForeground(Color.WHITE);
        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new CustomerMainForm().setVisible(true);
            }
        });
        btnbottompanel.add(Home);

        ButtonPanel.add("South", btnbottompanel);

        add("South", ButtonPanel);

        JPanel Displayl = new JPanel(new GridLayout(6, 2));
        Displayl.setBackground(new Color(133, 232, 210));

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("", 1, 20));
        JPanel lblidpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblidpanel.setBackground(new Color(133, 232, 210));
        lblidpanel.add(lblid);
        Displayl.add(lblidpanel);

        JPanel txtidpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtidpanel.setBackground(new Color(133, 232, 210));
        txtId = new JTextField(6);
        txtId.setFont(new Font("", Font.BOLD, 20));
        txtId.setEditable(false);
        txtidpanel.add(txtId);
        Displayl.add(txtidpanel);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("", 1, 20));
        JPanel lblnamepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblnamepanel.setBackground(new Color(133, 232, 210));
        lblnamepanel.add(lblname);
        Displayl.add(lblnamepanel);

        JPanel txtnamepanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtnamepanel.setBackground(new Color(133, 232, 210));
        txtName = new JTextField(10);
        txtName.setFont(new Font("", Font.BOLD, 20));
        txtName.setEditable(false);
        txtnamepanel.add(txtName);
        Displayl.add(txtnamepanel);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setFont(new Font("", 1, 20));
        JPanel lblphonepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblphonepanel.setBackground(new Color(133, 232, 210));
        lblphonepanel.add(lblphone);
        Displayl.add(lblphonepanel);

        JPanel txtNopanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtNopanel.setBackground(new Color(133, 232, 210));
        txtNo = new JTextField(10);
        txtNo.setFont(new Font("", Font.BOLD, 20));
        txtNo.setEditable(false);
        txtNopanel.add(txtNo);
        Displayl.add(txtNopanel);

        JLabel lblcompany = new JLabel("Company");
        lblcompany.setFont(new Font("", 1, 20));
        JPanel lblcompanypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblcompanypanel.setBackground(new Color(133, 232, 210));
        lblcompanypanel.add(lblcompany);
        Displayl.add(lblcompanypanel);

        JPanel txtCNamepanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtCNamepanel.setBackground(new Color(133, 232, 210));
        txtCName = new JTextField(10);
        txtCName.setFont(new Font("", Font.BOLD, 20));
        txtCName.setEditable(false);
        txtCNamepanel.add(txtCName);
        Displayl.add(txtCNamepanel);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setFont(new Font("", 1, 20));
        JPanel lblsalarypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblsalarypanel.setBackground(new Color(133, 232, 210));
        lblsalarypanel.add(lblsalary);
        Displayl.add(lblsalarypanel);

        JPanel txtSalarypanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSalarypanel.setBackground(new Color(133, 232, 210));
        txtSalary = new JTextField(10);
        txtSalary.setFont(new Font("", Font.BOLD, 20));
        txtSalary.setEditable(false);
        txtSalarypanel.add(txtSalary);
        Displayl.add(txtSalarypanel);

        JLabel lblbday = new JLabel("Birthday");
        lblbday.setFont(new Font("", 1, 20));
        JPanel lblbdaypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblbdaypanel.setBackground(new Color(133, 232, 210));
        lblbdaypanel.add(lblbday);
        Displayl.add(lblbdaypanel);

        JPanel txtBirthpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBirthpanel.setBackground(new Color(133, 232, 210));
        txtBirth = new JTextField(10);
        txtBirth.setFont(new Font("", Font.BOLD, 20));
        txtBirth.setEditable(false);
        txtBirthpanel.add(txtBirth);
        Displayl.add(txtBirthpanel);

        add("Center", Displayl);
    }
}
