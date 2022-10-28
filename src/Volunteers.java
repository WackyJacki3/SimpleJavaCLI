import java.util.*;

class Volunteers {
    // Initialize Fields
    private int volBadgeNum;
    private String vName;
    private String vRole;
    
    // Constructors
    Volunteers(){};

    Volunteers(int badge, String name, String role) {
        this.volBadgeNum = badge;
        this.vName = name;
        this.vRole = role;
    }

    // Getters and Setters
    public int getVolBadgeNum() {
        return this.volBadgeNum;
    }

    public void setVolBadgeNum(int volBadgeNum) {
        this.volBadgeNum = volBadgeNum;
    }

    public String getVName() {
        return this.vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVRole() {
        return this.vRole;
    }

    public void setVRole(String vRole) {
        this.vRole = vRole;
    }

    // toString for printing out values
    public String toString() {
        return volBadgeNum + " " + vName + " " + vRole;
    }

    // CLI Menu to interact with
    public void showMenu() {
        
        // Create ArrayList to store Volunteers, use List for updating
        List<Volunteers> v = new ArrayList<Volunteers>();
        // Use scanner to get user input
        char option = '\0';
        // use Seperate Scanner for Int and String
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        // Do while loop for User to interact with Menu
        do {
            System.out.println("=====================================");
            System.out.println("1. Add New Volunteer");
            System.out.println("2. Display All Volunteers");
            System.out.println("3. Search For a Volunteer");
            System.out.println("4. Delete a Volunteer");
            System.out.println("5. Update Volunteer Info");
            System.out.println("0. Exit");
            System.out.println("");

            // Ask user for option
            System.out.print("Choose an option: ");
            option = scanner.next().charAt(0);
            System.out.println("=====================================");
            // Declare variables outside of scope
            int volNumber = 0;
            String inputValue;
            String volName;
            String volRole;
            // Switch case for input
            switch(option) {
                case '1': 
                    // Ask user for volunteer info
                    boolean valid = true;
                    // Error handling using do while and try/catch/finally
                    do {
                        System.out.print("Enter Volunteer Badge Number: ");
                        try {
                            volNumber = scanner.nextInt();
                            valid = false;
                        } catch (Exception e) {
                            System.out.println("Error has occured... try again.");

                        } finally {
                            // need this line for carriage return(?), it'll infintely loop if not added
                            scanner.nextLine();
                        }
                    } while (valid);

                    System.out.print("Enter Volunteer Name: ");
                    volName = scanner1.nextLine();
                    System.out.print("Enter Volunteer Role: ");
                    volRole = scanner1.nextLine();

                    // Add volunteer to ArrayList
                    v.add(new Volunteers(volNumber, volName, volRole));
                break;
                case '2':
                    // Display volunteer info
                    // Use for each loop to display all volunteers
                    for (Volunteers volunteer : v) {
                        System.out.println("ID: " + volunteer.getVolBadgeNum() + "  Name: " + volunteer.getVName() + "  Role: " + volunteer.getVRole());
                    }
                break;
                case '3':
                    valid = false;
                    boolean found = false;
                    int vNumber = 0;
                    // Error handling if User doesn't input value;
                    do {
                        System.out.print("Enter Volunteer Badge Number to Search: ");
                        try {
                            vNumber = scanner.nextInt();
                            valid = false;
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("");

                        } finally {
                            // need this line for carriage return(?), it'll infintely loop if not added
                            scanner.nextLine();
                        }
                    } while (valid);

                    // Use for each loop again to search if volunteer badge
                    // number can be found. If found = print out info
                    for (Volunteers volunteer : v) {
                        if (volunteer.getVolBadgeNum() == vNumber) {
                            System.out.println(volunteer);
                            found = true;
                        }
                    }
                    // If not found, print out error message and go back to menu
                    if (!found) {
                        System.out.println("Record Not Found");
                    }
                break;
                case '4':
                    found = false;
                    valid = false;
                    vNumber = 0;
                    // Error handling if User doesn't input value;
                    do {
                        System.out.print("Enter Volunteer Badge Number to Delete: ");
                        try {
                            vNumber = scanner.nextInt();
                            valid = false;
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("");

                        } finally {
                            // need this line for carriage return(?), it'll infintely loop if not added
                            scanner.nextLine();
                        }
                    } while (valid);

                    // Use Iterator to use remove method
                    Iterator<Volunteers> i = v.iterator();
                    while(i.hasNext()) {
                        Volunteers e = i.next();
                        // If found, remove from arraylist 
                        if(e.getVolBadgeNum() == vNumber) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record is Deleted Successfullly!");
                    }
                break;
                case '5':
                    found = false;
                    valid = false;
                    vNumber = 0;
                    // Error handling if User doesn't input value;
                    do {
                        System.out.print("Enter Volunteer Badge Number to Update: ");
                        try {
                            vNumber = scanner.nextInt();
                            valid = false;
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("");

                        } finally {
                            // need this line for carriage return(?), it'll infintely loop if not added
                            scanner.nextLine();
                        }
                    } while (valid);
                
                    // Use ListIterator to use update method
                    ListIterator<Volunteers> li = v.listIterator();
                    while(li.hasNext()) {
                        Volunteers e = li.next();
                        // If found, remove from arraylist 
                        if(e.getVolBadgeNum() == vNumber) {
                            System.out.print("Enter new Name: ");
                            volName = scanner1.nextLine();

                            System.out.print("Enter new Role: ");
                            volRole = scanner1.nextLine();
                            li.set(new Volunteers(vNumber, volName, volRole));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record is Updated Successfullly!");
                    }
                break;
                default:
                    System.out.println("Invalid Option! Please choose from the menu!");
                break;
            }
        } while (option != '0');
            System.out.println("Goodbye!");
    }


}