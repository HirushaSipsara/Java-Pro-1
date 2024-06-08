import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
class AddCustomerForm extends JFrame{
    private final JButton btnAddCustomer;
    private final JButton btnCancel;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtNo;
    private JTextField txtCName;
    private JTextField txtSalary;
    private JTextField txtBirth;
    private String ID;

    private SuccessNotify successNotify;

    AddCustomerForm(){
        setSize(600,400);
        setTitle("Add Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel hederPamel=new JPanel(new GridLayout(2,1,3,3));
        hederPamel.setBackground(new Color(118,181,197));
        JLabel titleLabel=new JLabel("Add Customer Form");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        hederPamel.add(titleLabel);

        ID=contactidgenarate();

        JPanel conIdPanal= new JPanel(new FlowLayout(FlowLayout.LEFT));
        conIdPanal.setBackground(new Color(66,144,253,255));
        JLabel lblId=new JLabel("Contact ID - " + ID);
        lblId.setFont(new Font("",1,20));
        conIdPanal.add(lblId);
        hederPamel.add(conIdPanal);

        add("North",hederPamel);

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(66,144,253,255));
        btnAddCustomer=new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("",1,20));
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String id=ID;
                String name=txtName.getText();
                String no=txtNo.getText();
                String cName=txtCName.getText();
                double salary=Double.parseDouble(txtSalary.getText());
                String birth=txtBirth.getText();
                if(no.length()!= 10 || no.charAt(0)!='0') {
                    ErrorNo.ENo();
                }else if(salary<0){
                    ErrorSalary.ESalary();
                }else if(!(checkBirthday(birth))) {
                    ErrorBirth.EBirth();
                }else{
                    Contact contact = new Contact(id, name, no, cName, salary, birth);
                    CustomerMainForm.contactLIST.add(contact);
                    dispose();
                    SuccessNotify.Saved();
                    new AddCustomerForm().setVisible(true);
                }
            }
        });

        buttonPanel.add(btnAddCustomer);

        btnCancel=new JButton("Cancel");
        btnCancel.setFont(new Font("",1,20));
        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
            }
        });
        buttonPanel.add(btnCancel);

        add("South",buttonPanel);


        JPanel labelPanel=new JPanel(new GridLayout(5,1,3,3));
        labelPanel.setBackground(new Color(66,144,253,255));
        JLabel lblName=new JLabel("Name");
        lblName.setFont(new Font("",1,20));
        labelPanel.add(lblName);

        JLabel lblAddress=new JLabel("Phone No");
        lblAddress.setFont(new Font("",1,20));
        labelPanel.add(lblAddress);

        JLabel lblCName =new JLabel("Company Name");
        lblCName.setFont(new Font("",1,20));
        labelPanel.add(lblCName);

        JLabel lblSalary=new JLabel("Salary");
        lblSalary.setFont(new Font("",1,20));
        labelPanel.add(lblSalary);

        JLabel lblBirth=new JLabel("Date of Birth");
        lblBirth.setFont(new Font("",1,20));
        labelPanel.add(lblBirth);

        add("West",labelPanel);

        JPanel textPanel=new JPanel(new GridLayout(5,1,3,3));
        textPanel.setBackground(new Color(66,144,253,255));
        txtName=new JTextField(10);
        txtName.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.setBackground(new Color(66,144,253,255));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtNo=new JTextField(15);
        txtNo.setFont(new Font("",1,20));
        JPanel noTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        noTextPanel.setBackground(new Color(66,144,253,255));
        noTextPanel.add(txtNo);
        textPanel.add(noTextPanel);

        txtCName=new JTextField(15);
        txtCName.setFont(new Font("",1,20));
        JPanel CNameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        CNameTextPanel.setBackground(new Color(66,144,253,255));
        CNameTextPanel.add(txtCName);
        textPanel.add(CNameTextPanel);

        txtSalary=new JTextField(6);
        txtSalary.setFont(new Font("",1,20));
        JPanel salaryTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.setBackground(new Color(66,144,253,255));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirth=new JTextField(10);
        txtBirth.setFont(new Font("",1,20));
        JPanel birthTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthTextPanel.setBackground(new Color(66,144,253,255));
        birthTextPanel.add(txtBirth);
        textPanel.add(birthTextPanel);

        add(textPanel);

    }

    public static String contactidgenarate(){
        String str="";
        int x=CustomerMainForm.contactLIST.size()+1;
        if(CustomerMainForm.contactLIST.size()-1<9){
            str="B000"+x;
        }else if(CustomerMainForm.contactLIST.size()-1<99){
            str="B00"+x;
        }else if(CustomerMainForm.contactLIST.size()-1<999){
            str="B0"+x;
        }else if(CustomerMainForm.contactLIST.size()-1<9999){
            str="B"+x;
        }
        return str;
    }

    public static boolean checkBirthday(String DOB){
        LocalDate currentdate = LocalDate.now();
        int currentMonthValue = currentdate.getMonthValue();
        int currentYear=currentdate.getYear();
        int year=Integer.parseInt(DOB.substring(0,4));
        int month=Integer.parseInt(DOB.substring(5,7));
        int day=Integer.parseInt(DOB.substring(9));
        if(DOB.length()==10){
            if(year<currentYear){
                if(month>=1 && month<=12){
                    if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                        if(0<day && day<=31){
                            return true;
                        }else{
                            return false;
                        }
                    }else if(month==4 || month==6 || month==9 || month==11){
                        if(0<day && day<=30){
                            return true;
                        }else{
                            return false;
                        }
                    }else if(month==02){
                        boolean bool=true;
                        if(year%400==0){
                            bool=true;
                        }else if(year%4==0){
                            if(year%100==0){
                                bool=false;
                            }else{
                                bool=true;
                            }
                        }else{
                            bool=false;
                        }
                        if(bool){
                            if(0<day && day<=29){
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            if(0<day && day<=28){
                                return true;
                            }else{
                                return false;
                            }
                        }
                    }
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}


