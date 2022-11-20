import java.util.List;
import java.util.ArrayList;
public class FixedExpense extends Expense {
    private String payday;
    List <String> paydayList = new ArrayList<>();
    
    public void registerExpense(String name, String description, float value, String payday) {
        nameList.add(name);
        valueList.add(value);
        descriptionList.add(description);
        paydayList.add(payday);
    }
}