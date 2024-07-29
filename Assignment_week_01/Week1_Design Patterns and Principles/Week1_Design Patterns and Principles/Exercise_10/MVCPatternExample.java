package Exercise_10;

public class MVCPatternExample {
    public static void main(String[] args) {
        // Create the model
        Student model = new Student("1", "John Doe", "A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(model, view);

        // Display the initial student details
        controller.updateView();

        // Update the student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Display the updated student details
        controller.updateView();
    }
}
