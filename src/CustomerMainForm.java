import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class CustomerMainForm extends JFrame {

    public static ArrayList<Contact> contactLIST = new ArrayList<>();
    public static ArrayList<Contact> tempLIST = new ArrayList<>();

    private JButton btnAddCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnDeleteCustomer;
    private JButton btnSearchCustomer;
    private JButton btnListCustomers;
    private JButton btnExit;

    private AddCustomerForm addCustomerForm;
    private UpdateCustomerForm updateCustomerForm;
    private DeleteCustomerForm deleteCustomerForm;
    private SearchCustomerForm searchCustomerForm;
    private ListCustomerForm listCustomerForm;

    CustomerMainForm() {
        setSize(800, 500);
        setTitle("Main Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel LestPanel = new JPanel(new GridLayout(1, 2));

        ImagePanel imgPanel = new ImagePanel("ifriend.jpeg"); // Use the custom panel
        imgPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        LestPanel.add(imgPanel);

        JPanel homePamel = new JPanel(new GridLayout(8, 1,6,6));
        homePamel.setBackground(new Color(133, 232, 210));

        JLabel titleLabel = new JLabel("Home Page");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(new Color(0, 102, 102)); // Dark teal color
        homePamel.add(titleLabel);

        btnAddCustomer = StyledButton("Add Customer");
        btnAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (addCustomerForm == null) {
                    dispose();
                    addCustomerForm = new AddCustomerForm();
                }
                addCustomerForm.setVisible(true);
            }
        });
        JPanel AddTextPanel = StyledPanel();
        AddTextPanel.add(btnAddCustomer);
        homePamel.add(AddTextPanel);

        btnUpdateCustomer = StyledButton("Update Customer");
        btnUpdateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (updateCustomerForm == null) {
                    dispose();
                    updateCustomerForm = new UpdateCustomerForm();
                }
                updateCustomerForm.setVisible(true);
            }
        });
        JPanel UppTextPanel = StyledPanel();
        UppTextPanel.add(btnUpdateCustomer);
        homePamel.add(UppTextPanel);

        btnDeleteCustomer = StyledButton("Delete Customer");
        btnDeleteCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (deleteCustomerForm == null) {
                    dispose();
                    deleteCustomerForm = new DeleteCustomerForm();
                }
                deleteCustomerForm.setVisible(true);
            }
        });
        JPanel DelTextPanel = StyledPanel();
        DelTextPanel.add(btnDeleteCustomer);
        homePamel.add(DelTextPanel);

        btnSearchCustomer = StyledButton("Search Customer");
        btnSearchCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (searchCustomerForm == null) {
                    dispose();
                    searchCustomerForm = new SearchCustomerForm();
                }
                searchCustomerForm.setVisible(true);
            }
        });
        JPanel SeaTextPanel = StyledPanel();
        SeaTextPanel.add(btnSearchCustomer);
        homePamel.add(SeaTextPanel);

        btnListCustomers = StyledButton("List Customer");
        btnListCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (listCustomerForm == null) {
                    dispose();
                    listCustomerForm = new ListCustomerForm();
                }
                listCustomerForm.setVisible(true);
            }
        });
        JPanel LisTextPanel = StyledPanel();
        LisTextPanel.add(btnListCustomers);
        homePamel.add(LisTextPanel);

        btnExit = StyledButton("Exit");
        btnExit.setFont(new Font("", 1, 15));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        JPanel ExitTextPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ExitTextPanel.setBackground(new Color(133, 232, 210));
        ExitTextPanel.add(btnExit);
        homePamel.add(ExitTextPanel);

        LestPanel.add("Center", homePamel);
        add(LestPanel);
    }

    private JButton StyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 30));
        button.setFont(new Font("", 1, 18));
        button.setBackground(new Color(0, 153, 153)); // Teal color
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private JPanel StyledPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(new Color(133, 232, 210));
        return panel;
    }
}

class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        this.image = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image such that it fits within the panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
