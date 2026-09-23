import java.util.Scanner;

public class PalindromeCheck {

    // function that checks if a string is a palindrome using iterative two-pointer method
    static boolean isPalindrome(String str) {
        int left = 0;                     // pointer starting from the beginning
        int right = str.length() - 1;     // pointer starting from the end

        // keep squeezing towards the middle until pointers meet or cross
        while (left < right) {
            // converting both characters to lowercase so comparison ignores case
            char leftChar = Character.toLowerCase(str.charAt(left));
            char rightChar = Character.toLowerCase(str.charAt(right));

            // if characters don't match, string can't be a palindrome
            if (leftChar != rightChar) {
                return false;
            }

            // move pointers closer to the middle
            left++;
            right--;
        }

        // if we made it through the whole loop without mismatches, it's a palindrome
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***********************************************");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine(); // nextLine() so we can accept strings with spaces too

        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
        System.out.println("***********************************************");

        scanner.close();
    }
}
