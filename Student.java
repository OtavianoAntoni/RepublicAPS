import java.util.List;
import java.util.ArrayList;

public class Student {
    //global attribute objects for object instance
    protected byte idSt = 0;
    protected String name;
    protected String email;
    protected float income;
    //array list containing new Students data
    List <Byte> idStudent = new ArrayList<>();
    List <String> nameList = new ArrayList<>();
    List <String> emailList = new ArrayList<>();
    List <Float> incomeList = new ArrayList<>();
    List <Float> taxStudent = new ArrayList<>();

    //method used from register new Student into the system
    public void registerPerson(String name, String email, float income) {
        idStudent.add(idSt);
        idSt += 1;

        this.name = name;
        nameList.add(name);

        this.email = email;
        emailList.add(email);

        this.income = income;
        incomeList.add(income);
    }

    public void deleteAccount(byte idStudent) {
        //idStudent will provide current array position to be deleted
        byte position = (byte) this.idStudent.indexOf(idStudent);

        nameList.remove(position);
        emailList.remove(position);
        incomeList.remove(position);
        taxStudent.remove(position);
        this.idStudent.remove(position);
    }

    public void emergencyDeposit(){
        taxStudent.add((float) (income * 0.05));
    }
}