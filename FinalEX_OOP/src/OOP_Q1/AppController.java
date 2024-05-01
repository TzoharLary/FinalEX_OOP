package OOP_Q1;

public class AppController {
    private InputHandler inputHandler;
    private CaseHandler caseHandler;
    private Client client;

    public AppController() {
        this.inputHandler = new InputHandler();
        this.caseHandler = new CaseHandler(inputHandler, client);
    }

    public void start() {
        boolean continueLoop = true;
        inputHandler.Clientcreate();
        Client c1 = new Client(inputHandler.getNameInput(), inputHandler.getbalanceInput());
        // while the user want to search ask hem
        while (continueLoop){
            inputHandler.displayOptions();
            int choice = inputHandler.getIntInput();

            switch (choice) {
                case 1:
                    caseHandler.handlePriceCase(c1);
                    break;
                case 2:
                    caseHandler.handleAirlineCase(c1);
                    break;
                case 3:
                    caseHandler.handleDurationCase(c1);
                    break;
                case 4:
                    caseHandler.handleDepartureTimeCase(c1);
                    break;
                default:
                    inputHandler.displayErrorMessage();
                    continue;
//                    break;
            }
//            // Ask if user wants to see the booked he already booked
//            System.out.println("Do you want to see all the flights you are following? ? (yes/no)");
//            String answer1 = inputHandler.getyesnoInput();
//            if (answer1.equalsIgnoreCase("yes")) {
//                c1.displayObservedFlights();
//            }
//            else {
//
//            }


            if (!CaseHandler.shouldContinueSearch()) {
                continueLoop = displayAnotherSearch(continueLoop);
            }
        }

        inputHandler.close();
    }
    public boolean displayAnotherSearch(boolean continueLoop ){
        // Ask if user wants to continue or exit
        System.out.println("Do you want to perform another search? (yes/no)");
        String answer = inputHandler.getyesnoInput();
        if (answer.equalsIgnoreCase("no")){
            continueLoop = false;
            return continueLoop;
        }
        return continueLoop;
    }
}
