# RohlikAutomationProject

Automated TC for membership activation of the Rohlicek Club. 

- void dataClear() : will cleanup the data so the test can be executed repeatedly. Before the execution of the test method the data will be always switched to the membership = false.

- void membershipActivation : will set membership for Rohlicek Club = true for the user account.

Credentials for login and other data can be found in config file: configuration.properties, the data are being read by ConfigurationManager. 
