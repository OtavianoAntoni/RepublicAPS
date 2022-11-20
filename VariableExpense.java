import java.util.List;
import java.util.ArrayList;

public class VariableExpense extends Expense{
    //attribute that allows certain expenses to be their cost shared among students
    private byte priority;
    List <Byte> priorityList = new ArrayList<>();

    public void registerExpense(String name, String description, float value, byte priority) {
        nameList.add(name);
        valueList.add(value);
        nameList.add(description);
        priorityList.add(priority);
    }
}
