import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class DeleteCustomerForm extends JFrame{

    private JButton btnEnter;
    private JButton btnDelete;
    private JTable tblCustomerDetails;
    private JTextField txtSearch;
    private DefaultTableModel dtm;
    private int x;

    DeleteCustomerForm(){
        setSize(900,600);
        setTitle("View Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Search Customer Form");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);


        JLabel lblsearch =new JLabel("Search Contacts");
        lblsearch.setFont(new Font("",1,20));
        add("West",lblsearch);


        txtSearch=new JTextField(10);
        txtSearch.setFont(new Font("",1,20));
        add("Center",txtSearch);


        btnEnter=new JButton("Enter");
        btnEnter.setFont(new Font("",1,20));
        add("East",btnEnter);
        btnEnter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dtm.setRowCount(0);

                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++){
                    if(txtSearch.getText().equals(CustomerMainForm.contactLIST.get(i).getName()) || txtSearch.getText().equals(CustomerMainForm.contactLIST.get(i).getNo())) {
                        x=i;
                        Contact contact = CustomerMainForm.contactLIST.get(i);
                        Object[] rowData={contact.getId(), contact.getName(), contact.getNo(),contact.getCName(), contact.getSalary(), contact.getBirth()};
                        dtm.addRow(rowData);
                    }
                }
            }
        });

        //----------------------------------------------
        JPanel DownPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        String[] columnName={"Customer ID", "Name","Phone No","Company Name","Salary","Date of Birth"};
        dtm=new DefaultTableModel(columnName,1);
        tblCustomerDetails=new JTable(dtm);
        JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
        DownPanel.add(tablePane);

        btnDelete=new JButton("Delete");
        btnDelete.setFont(new Font("",1,20));
        DownPanel.add(btnDelete);
        btnDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dtm.setRowCount(0);

                    for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++) {
                        if (i==x) {
                            CustomerMainForm.contactLIST.remove(i);
                            dtm.removeRow(i);
                        }
                    }

                }
        });
        add("South",DownPanel);
    }
}
