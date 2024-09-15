# ProgressTelerik

*******Run the script throw Maven*********
You can Run the script throw the command line by the below command

First  Run the script By the below script 
    mvn clean test -Dbrowser=Chrome

Second  then If you want to open the Allure Report Run the below command
    allure serve allure-results


*******Run the script throw TestNG*********
Note
To Generate the allure report after Run the script 
We need to prepare the prerequisites

First we need to check if the allure report is a setup by run 
    the (allure --version) in the CMD to check the allure has been setup or not setup 
    if there is a version number display then the allure report is setup well  
Second add the username in the script
      C:/Users/Motasem Fouad/scoop/shims/allure.cmd  
      Replace the (Motasem Fouad) with your username in the C
      C:/Users/{UserName}/scoop/shims/allure.cmd 
      the above command exist in the generateReport() in the Testbase  

Instruction
There is a package called a ( Base ) this package has a Bage page and TestBage
The BagePage has a fucnctions used in the methods in the class 
The TestBase has   
