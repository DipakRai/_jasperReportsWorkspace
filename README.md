This is a I promised this to myself. This time once I found my way out of the problem of how to generate a sample Jasper report through Java Beans, I am going to blog it so that I don’t forget it next time and struggle again.

While how to go about the steps is enumerated below a more detailed screenshot tutorial can be found at https://stackoverflow.com/questions/40902602/jaspersoft-studio-how-to-use-collection-of-java-beans-in-data-adapter

The steps:

    Create a normal Java Bean class.
    Export + Save it as a jar file somewhere onto your machine.
    Include this jar file as a JavaBean in the DataSet of the sample MyReports project created in JasperSoft Studio
    Design a sample Jasper report in the eclipse based JasperSoft Studio.
    Have a quick preview in Jaspersoft Studio of how the report looks
    Create a dynamic web project maven based
    Copy the .jasper or .jrxml file into the resources folder of the maven project
