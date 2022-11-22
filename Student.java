import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
    //global attribute objects for object instance
    protected byte idSt = 0;
    protected String name;
    protected String email;
    protected float income;

    //array list containing new Students data
    //List <Byte> idStudent = new ArrayList<>();
    List <String> nameList = new ArrayList<>();
    List <String> emailList = new ArrayList<>();
    List <Float> incomeList = new ArrayList<>();
    List <Float> taxStudent = new ArrayList<>();

    //method used from register new Student into the system
    public void registerPerson(String name, String email, float income) throws IOException {
        //idStudent.add(idSt);
        nameList.add(name);
        emailList.add(email);
        incomeList.add(income);
        emergencyDeposit(income);
        idSt += 1;
        FileMang fg = new FileMang();
        fg.studentsAdd(name, email, income);
    }

    public void deleteAccount(String name) {
        //idStudent will provide current array position to be deleted
        byte position = (byte) this.nameList.indexOf(name);

        nameList.remove(position);
        emailList.remove(position);
        incomeList.remove(position);
        taxStudent.remove(position);
        //this.idStudent.remove(position);
    }

    public void emergencyDeposit(float income){
        taxStudent.add((float) (income * 0.05));
    }

    public float totalDeposit() {
        float total = 0;
        for (int r = 0; r < taxStudent.size(); r++) {
            total += taxStudent.get(r);
        }
        return total;
    }
}