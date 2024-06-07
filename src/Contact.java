class Contact {
    private String id;
    private String name;
    private String no;
    private String cName;
    private double salary;
    private String birth;

    Contact(String id, String name, String no,String cName, double salary, String birth){
        this.id=id;
        this.name=name;
        this.no=no;
        this.cName=cName;
        this.salary=salary;
        this.birth=birth;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getNo(){
        return no;
    }
    public String getCName(){
        return cName;
    }
    public double getSalary(){
        return salary;
    }
    public String getBirth(){
        return birth;
    }

    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setNo(String no){
        this.no=no;
    }
    public void setCname(String cName){
        this.cName=cName;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setBirth(String birth){
        this.birth=birth;
    }
}
