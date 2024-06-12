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
    private JButton btnHome;

    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;

    ListCustomerForm(){
        setSize(600,400);
        setTitle("View Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tempArrays();

        JPanel Top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Top.setBackground(Color.CYAN);
        JLabel titleLabel=new JLabel("Sort Contact Form");
        titleLabel.setBackground(Color.CYAN);
        titleLabel.setForeground(new Color(0, 102, 102));
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        Top.add(titleLabel);
        add("North", Top);

        JPanel buttonPanel =new JPanel(new BorderLayout());
        JPanel btntoppanel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btntoppanel.setBackground(new Color(133, 232, 210));
        JPanel btnbottompanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnbottompanel.setBackground(new Color(133, 232, 210));

        sortName=new JButton("Sort Name");
        sortName.setBackground(new Color(125, 19, 234));
        sortName.setForeground(Color.WHITE);
        btntoppanel.add(sortName);
        sortName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Contact[] contacttemp=new Contact[CustomerMainForm.contactLIST.size()];
                for(int i=0;i<contacttemp.length;i++){
                    contacttemp[i]=CustomerMainForm.contactLIST.get(i);
                }
                for (int i = 0; i < contacttemp.length-1; i++) {
                    for (int j = 0; j < contacttemp.length - i -1; j++) {
                        if (contacttemp[j].getName().charAt(0) > contacttemp[j + 1].getName().charAt(0)) {
                            Contact temp2 = contacttemp[j];
                            contacttemp[j]= contacttemp[j + 1];
                            contacttemp[j + 1] = temp2;
                        }
                    }
                }
                TableData(contacttemp);
            }
        });


        sortSalary=new JButton("Sort Salary");
        sortSalary.setBackground(new Color(125, 19, 234));
        sortSalary.setForeground(Color.WHITE);
        btntoppanel.add(sortSalary);
        sortSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Contact[] contacttemp=new Contact[CustomerMainForm.contactLIST.size()];
                for(int i=0;i<contacttemp.length;i++){
                    contacttemp[i]=CustomerMainForm.contactLIST.get(i);
                }
                for (int i = 0; i < contacttemp.length-1; i++) {
                    for (int j = 0; j < contacttemp.length - i -1; j++) {
                        if (contacttemp[j].getSalary() > contacttemp[j + 1].getSalary()) {
                            Contact temp2 = contacttemp[j];
                            contacttemp[j]= contacttemp[j + 1];
                            contacttemp[j + 1] = temp2;
                        }
                    }
                }
                TableData(contacttemp);
            }
        });


        sortBirthday=new JButton("Sort Birthday");
        sortBirthday.setBackground(new Color(125, 19, 234));
        sortBirthday.setForeground(Color.WHITE);
        btntoppanel.add(sortBirthday);
        sortBirthday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Contact[] contacttemp=new Contact[CustomerMainForm.contactLIST.size()];
                for(int i=0;i<contacttemp.length;i++){
                    contacttemp[i]=CustomerMainForm.contactLIST.get(i);
                }
                for (int i = 0; i < contacttemp.length - 1; i++) {
                    for (int j = 0; j < contacttemp.length - i - 1; j++) {
                        int year_1=Integer.parseInt(CustomerMainForm.contactLIST.get(i).getBirth().substring(0,4));
                        int month_1=Integer.parseInt(CustomerMainForm.contactLIST.get(i).getBirth().substring(5,7));
                        int day_1=Integer.parseInt(CustomerMainForm.contactLIST.get(i).getBirth().substring(8));

                        int year_2=Integer.parseInt(CustomerMainForm.contactLIST.get(i+1).getBirth().substring(0,4));
                        int month_2=Integer.parseInt(CustomerMainForm.contactLIST.get(i+1).getBirth().substring(5,7));
                        int day_2=Integer.parseInt(CustomerMainForm.contactLIST.get(i+1).getBirth().substring(8));
                        if (year_1>year_2) {
                            Contact temp = contacttemp[j];
                            contacttemp[j]= contacttemp[j+1];
                            contacttemp[j+1] = temp;

                        }else if(year_1==year_2){
                            if(month_1>month_2){
                                Contact temp = contacttemp[j];
                                contacttemp[j]= contacttemp[j+1];
                                contacttemp[j+1] = temp;

                            }else if(month_1==month_2){
                                if(day_1>day_2){
                                    Contact temp = contacttemp[j];
                                    contacttemp[j]= contacttemp[j+1];
                                    contacttemp[j+1] = temp;

                                }
                            }
                        }
                    }
                }
                TableData(contacttemp);
            }
        });
        buttonPanel.add("North",btntoppanel);

        btnHome=new JButton("Go To HomePage");
        btnHome.setBackground(new Color(125, 19, 234));
        btnHome.setForeground(Color.WHITE);
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new CustomerMainForm().setVisible(true);
            }
        });
        btnbottompanel.add(btnHome);
        buttonPanel.add("South",btnbottompanel);
        add("South",buttonPanel);

        //----------------------------------------------
        String[] columnName={"Customer ID", "Name","Phone No","Company Name","Salary","Date of Birth"};
        dtm=new DefaultTableModel(columnName,0);
        tblCustomerDetails=new JTable(dtm);
        JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
        add("Center",tablePane);
    }

    public static void tempArrays(){
        CustomerMainForm.tempLIST.addAll(CustomerMainForm.contactLIST);
    }

    private void TableData(Contact[] contacttemp) {
        dtm.setRowCount(0);
        for (Contact contact : contacttemp) {
            Object[] rowData = {contact.getId(), contact.getName(), contact.getNo(), contact.getCName(), contact.getSalary(), contact.getBirth()};
            dtm.addRow(rowData);
        }
    }
}
