import java.util.ArrayList;

public class test12345 {
    public static void main(String[] args) {
        String[] names = {"John", "", "Alice", "", "Bob", "Charlie", "", "David", "Eve"};
        int[] votes = {5, 0, 3, 0, 2, 1, 0, 4, 6};

        // Print the original arrays
        System.out.println("Original arrays:");
        printArrays(names, votes);

        // Remove empty slots
        removeEmptySlots(names, votes);

        // Print the modified arrays
        System.out.println("Arrays after removing empty slots:");
        printArrays(names, votes);
    }

    // Method to remove empty slots from the arrays
    private static void removeEmptySlots(String[] names, int[] votes) {
        ArrayList<String> nonEmptyNames = new ArrayList<>();
        ArrayList<Integer> nonEmptyVotes = new ArrayList<>();

        // Iterate through the names array
        for (int i = 0; i < names.length; i++) {
            if (!names[i].equals("")) {
                nonEmptyNames.add(names[i]);
                nonEmptyVotes.add(votes[i]);
            }
        }

        // Update the arrays
        for (int i = 0; i < nonEmptyNames.size(); i++) {
            names[i] = nonEmptyNames.get(i);
            votes[i] = nonEmptyVotes.get(i);
        }

        // Clear the remaining elements in the original array
        for (int i = nonEmptyNames.size(); i < names.length; i++) {
            names[i] = null;
            votes[i] = 0;  // Or any default value you want
        }
    }

    // Method to print both arrays
    private static void printArrays(String[] names, int[] votes) {
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + votes[i]);
        }
        System.out.println();
    }
}
