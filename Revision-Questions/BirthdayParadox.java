import java.util.HashMap;

/*Question
 * The birthday paradox says that the probability that two people in a room 
 * will have the same birthday is more than half provided n, the number of people in the room is more than 23.
 * This property is not really a paradox, but many people find it surprising. Design a Java peogram that can
 * test this paradox by a series of experiments on randomly generated birthdays, which test this paradox for 
 * n = 5, 10, 15, ..., 100
 */

 /*Algorithm/Pseudocode
  MAIN STEPS
  1. Generate random birthdays and save them in a array
  2. Randomly pick the birthdays from the array n times
  3. Record the number of times the same date was picked
  4. Calcultate the probability
  Step 1: Initialize dictionary  birthDays, input n, foundTotal
  Step 2: While n > 0 repeat Step 3, 4, 5
        otherwise go to Step 6
  Step 3: Randomly generate a date before today
  Step 4: If date is already in birthDays then increase count by 1.
  Step 5: Add the date to birthDays dictionary, reduce n by 1
  Step 6: for each date in birthDays,
        if date count > 1 then  increase foundTotal by 1
  Step 7: return foundTotal divided by n

  */

public class BirthdayParadox{

    public float testParadox(int n) {
        int numOfSame = 0;
        int numOfRepeats = n;

        while (n > 0) {
            if(checkBirthdays(24)) numOfSame ++;
            n--;
        }
        if (numOfSame == 0) return -1.0F;

        return (float) numOfSame/numOfRepeats;

    }

    private boolean checkBirthdays(int n) {
        HashMap<String, Integer> birthDays = new HashMap<>();
        while (n>0) {
            String date = generateRandomDate();
            if (birthDays.containsKey(date)) birthDays.put(date, birthDays.get(date)+1);
            else birthDays.put(date, 1);
            n--;
        }
        for (String day : birthDays.keySet()) {
            if(birthDays.get(day) > 1) return true;
        }
        System.out.println(birthDays);
        return false;
    }

    private int generateRandomNum(int length) {
        int res = (int) (Math.random() * length);
        return res + 1;
    }

    private String generateRandomDate() {
        String date = "";
        int first =  generateRandomNum(2);
        if (first == 1) {
            
            date += 1;
            date += generateRandomNum(10) -1;
            date += generateRandomNum(10)-1;
            date += generateRandomNum(10)-1;
        } else {
            date += 20;
            date += generateRandomNum(3) - 1;
            date += generateRandomNum(2) - 1;

        }
        date +="/" + generateRandomNum(12);
        date +="/" + generateRandomNum(30);

        return date;

    }

    public static void main(String[] args) {
        BirthdayParadox test = new BirthdayParadox();
        System.out.println(test.testParadox(30));
    }


}