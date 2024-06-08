import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Comparator;
class ListCustomerForm extends JFrame{
    private JButton sortName;
    private JButton sortSalary;
    private JButton sortBirthday;

    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;

    ListCustomerForm(){
        setSize(600,400);
        setTitle("View Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Sort Contact Form");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        JPanel MiddlePanel=new JPanel(new GridLayout(3,1));
        sortName=new JButton("Sort Name");
        sortName.setFont(new Font("",1,20));
        MiddlePanel.add(sortName);
        sortName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Collections.sort(CustomerMainForm.contactLIST, new Comparator<Contact>() {
                    @Override
                    public int compare(Contact c1, Contact c2) {
                        return c1.getName().compareTo(c2.getName());
                    }
                });
                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++){
                    Contact contact =CustomerMainForm.contactLIST.get(i);
                    Object[] rowData={contact.getId(), contact.getName(), contact.getNo(),contact.getCName(), contact.getSalary(), contact.getBirth()};
                    dtm.addRow(rowData);
                }
            }
        });


        sortSalary=new JButton("Sort Salary");
        sortSalary.setFont(new Font("",1,20));
        MiddlePanel.add(sortSalary);
        sortSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Collections.sort(CustomerMainForm.contactLIST, new Comparator<Contact>() {
                    @Override
                    public int compare(Contact c1, Contact c2) {
                        return Double.compare(c1.getSalary(), c2.getSalary());
                    }
                });
                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++){
                    Contact contact =CustomerMainForm.contactLIST.get(i);
                    Object[] rowData={contact.getId(), contact.getName(), contact.getNo(),contact.getCName(), contact.getSalary(), contact.getBirth()};
                    dtm.addRow(rowData);
                }
            }
        });


        sortBirthday=new JButton("Sort Birthday");
        sortBirthday.setFont(new Font("",1,20));
        MiddlePanel.add(sortBirthday);
        sortBirthday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Collections.sort(CustomerMainForm.contactLIST, new Comparator<Contact>() {
                    @Override
                    public int compare(Contact c1, Contact c2) {
                        return c1.getBirth().compareTo(c2.getBirth());
                    }
                });
                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++){
                    Contact contact =CustomerMainForm.contactLIST.get(i);
                    Object[] rowData={contact.getId(), contact.getName(), contact.getNo(),contact.getCName(), contact.getSalary(), contact.getBirth()};
                    dtm.addRow(rowData);
                }
            }
        });


        add("South",MiddlePanel);

        //----------------------------------------------
        String[] columnName={"Customer ID", "Name","Phone No","Company Name","Salary","Date of Birth"};
        dtm=new DefaultTableModel(columnName,0);
        tblCustomerDetails=new JTable(dtm);
        JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
        add("Center",tablePane);
    }
}
