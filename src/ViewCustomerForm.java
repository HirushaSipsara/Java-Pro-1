import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class ViewCustomerForm extends JFrame{
    private JButton btnReload;
    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;
    private Object[] rowData=new Object[6];

    ViewCustomerForm(){
        setSize(600,400);
        setTitle("View Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("View Customer Form");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnReload=new JButton("Reload");
        btnReload.setFont(new Font("",1,20));
        buttonPanel.add(btnReload);
        btnReload.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dtm.setRowCount(0);

                for (int i = 0; i < CustomerMainForm.contactLIST.size(); i++){
                    Contact contact =CustomerMainForm.contactLIST.get(i);
                    rowData= new Object[]{contact.getId(), contact.getName(), contact.getNo(), contact.getCName(), contact.getSalary(), contact.getBirth()};
                    dtm.addRow(rowData);
                }
            }
        });
        add("South",buttonPanel);

        //----------------------------------------------
        String[] columnName={"Customer ID", "Name","Phone No","Company Name","Salary","Date of Birth"};
        dtm=new DefaultTableModel(columnName,10);
        tblCustomerDetails=new JTable(dtm);
        JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
        add("Center",tablePane);
    }
}
