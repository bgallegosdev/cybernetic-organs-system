# cybernetic-organs-system
Student Name: Benjamin Gallegos
A futuristic company specializing in creating bio-compatible cybernetic organs for human augmentation and replacement. This project will require a deep understanding of object-oriented programming, data structures, and algorithms to simulate the complex interactions between biological and mechanical components.

Assignment 1c (09/03/2024): This system provides information on patients needing a cybernetic organs and the inventory the system can provide for the patients. The Inventory is matched against the CyberneticOrgan compatibility and the patients information is also logged in the system.
The classes we added are the CyberneticOrgan class, Patient class, and the OrganInventory class. 
The CyberneticOrgan class provides information on the Cybernetic Organ details such as model, id, the function, and its compatibility to the patient. The method getDetails() provides a "Getter" to the class on the information listed earlier. The method isCompatible() provides the information if an organ is compatible.
The Patient class holds information on the operating patient such as name, age, medical history, and installed organs. The method addOrgan() adds an organ to the installed organ field of a patient. The getPatientInfo() method provides the field information for the Patient.
The OrganInventory class holds information on the available organs and how they match against model numbers in the CyberneticOrgan class model field. Methods getOrgan() and addOrgan() adjust the contents of the inventory to match updated inventory.
Added new branch to repository of 'assignment-1c'