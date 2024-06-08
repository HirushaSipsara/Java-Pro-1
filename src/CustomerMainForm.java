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
        setSize(600,600);
        setTitle("Main Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel LestPanel=new JPanel(new GridLayout(1,2));
        JPanel imgPamel=new JPanel(new GridLayout(7,1,10, 10));
        imgPamel.setBackground(new Color(66,144,253,255));

        JLabel NtitleLabel=new JLabel("Home Page");
        NtitleLabel.setFont(new Font("",1,35));
        NtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        NtitleLabel.setForeground(new Color(248, 205, 248));
        imgPamel.add(NtitleLabel);

        JLabel backimg;
        backimg = new JLabel(new ImageIcon("./imsges/friend.jpg"));
        backimg.setLayout(new GridBagLayout());
        imgPamel.add(backimg, BorderLayout.WEST);

        LestPanel.add(imgPamel);

        JPanel homePamel=new JPanel(new GridLayout(8,1));
        homePamel.setBackground(new Color( 118,103,112));


        JLabel titleLabel=new JLabel("Home Page");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        homePamel.add(titleLabel);

        btnAddCustomer=new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("",1,20));
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addCustomerForm==null){
                    addCustomerForm=new AddCustomerForm();
                }
                addCustomerForm.setVisible(true);
            }
        });
        JPanel AddTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        AddTextPanel.setBackground(new Color( 118,103,112));
        AddTextPanel.add(btnAddCustomer);
        homePamel.add(AddTextPanel);

        btnUpdateCustomer=new JButton("Update Customer");
        btnUpdateCustomer.setFont(new Font("",1,20));
        btnUpdateCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(updateCustomerForm==null){
                    updateCustomerForm=new UpdateCustomerForm();
                }
                updateCustomerForm.setVisible(true);
            }
        });
        JPanel UppTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        UppTextPanel.setBackground(new Color( 118,103,112));
        UppTextPanel.add(btnUpdateCustomer);
        homePamel.add(UppTextPanel);

        btnDeleteCustomer=new JButton("Delete Customer");
        btnDeleteCustomer.setFont(new Font("",1,20));
        btnDeleteCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(deleteCustomerForm==null){
                    deleteCustomerForm=new DeleteCustomerForm();
                }
                deleteCustomerForm.setVisible(true);
            }
        });
        JPanel DelTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        DelTextPanel.setBackground(new Color( 118,103,112));
        DelTextPanel.add(btnDeleteCustomer);
        homePamel.add(DelTextPanel);

        btnSearchCustomer=new JButton("Search Customer");
        btnSearchCustomer.setFont(new Font("",1,20));
        btnSearchCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(searchCustomerForm==null){
                    searchCustomerForm=new SearchCustomerForm();
                }
                searchCustomerForm.setVisible(true);
            }
        });
        JPanel SeaTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        SeaTextPanel.setBackground(new Color( 118,103,112));
        SeaTextPanel.add(btnSearchCustomer);
        homePamel.add(SeaTextPanel);

        btnListCustomers=new JButton("List Customer");
        btnListCustomers.setFont(new Font("",1,20));
        btnListCustomers.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(listCustomerForm==null){
                    listCustomerForm=new ListCustomerForm();
                }
                listCustomerForm.setVisible(true);
            }
        });
        JPanel LisTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        LisTextPanel.setBackground(new Color( 118,103,112));
        LisTextPanel.add(btnListCustomers);
        homePamel.add(LisTextPanel);

        btnViewCustomer=new JButton("View Customer Form");
        btnViewCustomer.setFont(new Font("",1,20));
        btnViewCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(viewCustomerForm==null){
                    viewCustomerForm=new ViewCustomerForm();
                }
                viewCustomerForm.setVisible(true);
            }
        });
        JPanel VieTextPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        VieTextPanel.setBackground(new Color( 118,103,112));
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
        ExitTextPanel.setBackground(new Color( 118,103,112));
        ExitTextPanel.add(btnExit);
        homePamel.add(ExitTextPanel);

        LestPanel.add("Center",homePamel);
        add(LestPanel);
    }
}