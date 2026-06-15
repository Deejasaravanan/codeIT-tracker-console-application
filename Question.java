
public class Question {
    // Private attributes (Encapsulation: protecting data from direct external access)
    private int id;
    private String title;
    private String concepts;
    private String difficulty; // Easy, Medium, or Hard
    private boolean isSolved;

    /**
     * Constructor to initialize a Question object with the given parameters.
     * 
     * @param id         Unique identifier for the question
     * @param title      Title of the coding question
     * @param concepts   Key concepts covered by the question (e.g., Arrays, DP)
     * @param difficulty Difficulty level of the question (Easy, Medium, Hard)
     */
    public Question(int id, String title, String concepts,String difficulty) {
        this.id = id;
        this.title = title;
        this.concepts =concepts;
        this.difficulty = difficulty;
        this.isSolved = false; // Initially unsolved
    }

    // --- Getter and Setter Methods ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getConcepts() {
        return concepts;
    }
    public void setConcepts(String concepts) {
        this.concepts = concepts;
    }
    

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isSolved() {
        return isSolved;
    }

    /**
     * Marks the question as solved.
     */
    public void markAsSolved() {
        this.isSolved = true;
    }

    /**
     * Helper method to return a user-friendly string representation of the solved status.
     * 
     * @return "Solved" if true, "Unsolved" if false
     */
    public String getStatusString() {
        return isSolved ? "Solved" : "Unsolved";
    }
}
