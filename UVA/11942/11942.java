import java.util.Scanner;

public class Main {

    public static String IsOrdered(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if ((a < b && b > c) || (a > b && b < c)) return "Unordered"; 
        String status = "";
        int last = nums[0];
        boolean ordered = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < last) {
                ordered = false;
                break;
            }
            ordered = true;
            last = nums[i];
        }
        if (ordered) return "Ordered";
        last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last) {
                ordered = false;
                break;
            }
            last = nums[i];
            ordered = true;
        }
        if (ordered) return "Ordered";
        return "Unordered";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("Lumberjacks:");
        while (n > 0) {
            n--;
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = scan.nextInt();
            }
            System.out.println(IsOrdered(nums));
        }
    }
    
}
