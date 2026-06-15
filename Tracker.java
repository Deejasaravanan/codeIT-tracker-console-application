import java.util.ArrayList;


public class Tracker {
    // List to store all predefined questions
    private ArrayList<Question> questions;

    
    public Tracker() {
        questions = new ArrayList<>();
        initializeDefaultQuestions();
    }

   
    private void initializeDefaultQuestions() {
        questions.add(new Question(1, "Two Sum", "Array", "Easy"));
        questions.add(new Question(2, "Reverse a String", "Strings","Easy"));
        questions.add(new Question(3, "Valid Parentheses","Stack", "Easy"));
        questions.add(new Question(4, "Binary Search ","Searching", "Easy"));
        questions.add(new Question(5, " Maximum Subarray ", "Dynamic Programming", "Medium"));
        questions.add(new Question(6, "Linked List Cycle","Linked Lists", "Medium"));
        questions.add(new Question(7, "Merge Intervals","Arrays", "Medium"));
        questions.add(new Question(8, "Fibonacci Series ","Recursion", "Easy"));
        questions.add(new Question(9, "Merge k Sorted Lists","Sorting", "Hard"));
        questions.add(new Question(10, " Anagram Check ","Strings", "Medium"));
    }

    /**
     * Displays all coding questions in a neat tabular format.
     */
    public void viewAllQuestions() {
        System.out.println("\n=================================== ALL QUESTIONS ===================================");
        System.out.printf("%-5s | %-50s | %-12s | %-10s\n", "ID", "Question Title", "Difficulty", "Status");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Question q : questions) {
            System.out.printf("%-5d | %-50s | %-12s | %-10s\n", 
                    q.getId(), q.getTitle(), q.getDifficulty(), q.getStatusString());
        }
        System.out.println("================================================-------------------------------------\n");
    }

    /**
     * Finds a question by its unique ID and marks it as solved.
     * 
     * @param id The ID of the question to solve
     * @return true if question was found and updated, false otherwise
     */
    public boolean markQuestionSolved(int id) {
        for (Question q : questions) {
            if (q.getId() == id) {
                if (q.isSolved()) {
                    System.out.println("\n[!] Note: Question \"" + q.getTitle() + "\" was already marked as solved.");
                    return true;
                }
                q.markAsSolved();
                System.out.println("\n[+] Success: Question \"" + q.getTitle() + "\" marked as solved!");
                return true;
            }
        }
        return false; // Question with this ID was not found
    }

    /**
     * Displays only the questions that have been solved.
     */
    public void viewSolvedQuestions() {
        System.out.println("\n================================== SOLVED QUESTIONS ==================================");
        System.out.printf("%-5s | %-50s | %-12s | %-10s\n", "ID", "Question Title", "Difficulty", "Status");
        System.out.println("-------------------------------------------------------------------------------------");
        
        int count = 0;
        for (Question q : questions) {
            if (q.isSolved()) {
                System.out.printf("%-5d | %-50s | %-12s | %-10s\n", 
                        q.getId(), q.getTitle(), q.getDifficulty(), q.getStatusString());
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("                 No questions solved yet. Keep coding!               ");
        }
        System.out.println("================================================-------------------------------------\n");
    }

    /**
     * Computes statistics and displays the user's progress.
     */
    public void viewProgress() {
        int total = questions.size();
        int solved = 0;
        int easyCount = 0, easySolved = 0;
        int mediumCount = 0, mediumSolved = 0;
        int hardCount = 0, hardSolved = 0;

        for (Question q : questions) {
            boolean isQSolved = q.isSolved();
            if (isQSolved) {
                solved++;
            }

            switch (q.getDifficulty().toLowerCase()) {
                case "easy":
                    easyCount++;
                    if (isQSolved) easySolved++;
                    break;
                case "medium":
                    mediumCount++;
                    if (isQSolved) mediumSolved++;
                    break;
                case "hard":
                    hardCount++;
                    if (isQSolved) hardSolved++;
                    break;
            }
        }

        double percentage = ((double) solved / total) * 100;

        System.out.println("\n=============================== YOUR CODING PROGRESS ===============================");
        System.out.printf("Total Questions: %d | Solved: %d | Unsolved: %d\n", total, solved, (total - solved));
        System.out.printf("Overall Completion Rate: %.2f%%\n", percentage);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Breakdown by Difficulty:");
        System.out.printf("  - Easy:   %d/%d Solved\n", easySolved, easyCount);
        System.out.printf("  - Medium: %d/%d Solved\n", mediumSolved, mediumCount);
        System.out.printf("  - Hard:   %d/%d Solved\n", hardSolved, hardCount);
        
        // Dynamic motivational quote based on completion rate
        System.out.print("Status: ");
        if (percentage == 100) {
            System.out.println("Outstanding! You're ready to ace the interview!");
        } else if (percentage >= 70) {
            System.out.println("Great job! Almost there, keep pushing!");
        } else if (percentage >= 40) {
            System.out.println("Good progress! Keep practicing daily.");
        } else if (percentage > 0) {
            System.out.println("Nice start! Consistent effort leads to success.");
        } else {
            System.out.println("No questions solved yet. Let's solve your first question today!");
        }
        System.out.println("================================================-------------------------------------\n");
    }
}
