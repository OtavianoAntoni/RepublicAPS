import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class VariableExpense extends Expense{
    //attribute that allows certain expenses to be their cost shared among students
    //private byte priority;
    List <Byte> priorityList = new ArrayList<>();

    public void registerExpense(String name, String description, float value, byte priority) throws IOException {
        nameList.add(name);
        valueList.add(value);
        nameList.add(description);
        priorityList.add(priority);
        idExp += 1;
        FileMang fg = new FileMang();
        fg.vexpensesAdd(name, description, value, priority);
    }

    public float totalExpensesV() {
        float total = 0;
        for (int r = 0; r <= valueList.size(); r++) {
            total += valueList.get(r);
        }
        return total;
    }

    public float totalExpensesVPrior() {
        float total = 0;
        for (int r = 0; r < valueList.size(); r++) {
            if (priorityList.get(r) == 5 || priorityList.get(r) == 4) {
                total += valueList.get(r);
            } else {
                continue;
            }
            total += valueList.get(r);
        }
        return total;
    }
}