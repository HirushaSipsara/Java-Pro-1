import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class CustomerMainForm extends JFrame{

    public static ArrayList<Contact> contactLIST =new ArrayList<>();

    private JButton btnAddCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnDeleteCustomer;
    private JButton btnSearchCustomer;
    private JButton btnListCustomers;
    private JButton btnViewCustomer;
    private JButton btnExit;

    private AddCustomerForm addCustomerForm;
    private UpdateCustomerForm updateCustomerForm;
    private DeleteCustomerForm deleteCustomerForm;
    private SearchCustomerForm searchCustomerForm;
    private ListCustomerForm listCustomerForm;
    private ViewCustomerForm viewCustomerForm;

    CustomerMainForm(){
        setSize(800,500);
        setTitle("Main Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel LestPanel=new JPanel(new GridLayout(1,2));

        ImagePanel imgPanel = new ImagePanel("friend.jpg"); // Use the custom panel
        imgPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        LestPanel.add(imgPanel);


        JPanel homePamel=new JPanel(new GridLayout(8,1));
        homePamel.setBackground(new Color(133, 232, 210));

        JLabel titleLabel=new JLabel("Home Page");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        homePamel.add(titleLabel);

        btnAddCustomer=new JButton("Add Customer");
        btnAddCustomer.setPreferredSize(new Dimension(200, 30));
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addCustomerForm==null){
                    addCustomerForm=new AddCustomerForm();
                }
                addCustomerForm.setVisible(true);
            }
        });
        JPanel AddTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        AddTextPanel.setBackground(new Color( 133, 232, 210));
        AddTextPanel.add(btnAddCustomer);
        homePamel.add(AddTextPanel);

        btnUpdateCustomer=new JButton("Update Customer");
        btnUpdateCustomer.setPreferredSize(new Dimension(200, 30));
        btnUpdateCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(updateCustomerForm==null){
                    updateCustomerForm=new UpdateCustomerForm();
                }
                updateCustomerForm.setVisible(true);
            }
        });
        JPanel UppTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        UppTextPanel.setBackground(new Color( 133, 232, 210));
        UppTextPanel.add(btnUpdateCustomer);
        homePamel.add(UppTextPanel);

        btnDeleteCustomer=new JButton("Delete Customer");
        btnDeleteCustomer.setPreferredSize(new Dimension(200, 30));;
        btnDeleteCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(deleteCustomerForm==null){
                    deleteCustomerForm=new DeleteCustomerForm();
                }
                deleteCustomerForm.setVisible(true);
            }
        });
        JPanel DelTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        DelTextPanel.setBackground(new Color( 133, 232, 210));
        DelTextPanel.add(btnDeleteCustomer);
        homePamel.add(DelTextPanel);

        btnSearchCustomer=new JButton("Search Customer");
        btnSearchCustomer.setPreferredSize(new Dimension(200, 30));
        btnSearchCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(searchCustomerForm==null){
                    searchCustomerForm=new SearchCustomerForm();
                }
                searchCustomerForm.setVisible(true);
            }
        });
        JPanel SeaTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        SeaTextPanel.setBackground(new Color( 133, 232, 210));
        SeaTextPanel.add(btnSearchCustomer);
        homePamel.add(SeaTextPanel);

        btnListCustomers=new JButton("List Customer");
        btnListCustomers.setPreferredSize(new Dimension(200, 30));
        btnListCustomers.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(listCustomerForm==null){
                    listCustomerForm=new ListCustomerForm();
                }
                listCustomerForm.setVisible(true);
            }
        });
        JPanel LisTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        LisTextPanel.setBackground(new Color( 133, 232, 210));
        LisTextPanel.add(btnListCustomers);
        homePamel.add(LisTextPanel);

        btnViewCustomer=new JButton("View Customer Form");
        btnViewCustomer.setPreferredSize(new Dimension(200, 30));
        btnViewCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(viewCustomerForm==null){
                    viewCustomerForm=new ViewCustomerForm();
                }
                viewCustomerForm.setVisible(true);
            }
        });
        JPanel VieTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        VieTextPanel.setBackground(new Color( 133, 232, 210));
        VieTextPanel.add(btnViewCustomer);
        homePamel.add(VieTextPanel);

        btnExit=new JButton("Exit");
        btnExit.setFont(new Font("",1,15));
        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(viewCustomerForm==null){
                    viewCustomerForm=new ViewCustomerForm();
                }
                dispose();
            }
        });
        JPanel ExitTextPanel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ExitTextPanel.setBackground(new Color( 133, 232, 210));
        ExitTextPanel.add(btnExit);
        homePamel.add(ExitTextPanel);

        LestPanel.add("Center",homePamel);
        add(LestPanel);
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