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
        setSize(600,400);
        setTitle("Main Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,1));

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
        add(btnAddCustomer);

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
        add(btnUpdateCustomer);

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
        add(btnDeleteCustomer);

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
        add(btnSearchCustomer);

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
        add(btnListCustomers);

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
        add(btnViewCustomer);
    }
}