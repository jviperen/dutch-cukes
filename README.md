DutchCukes
==========

Dutch Gherkin Cucumber Project based on the jvm.cukes.parralel project


How to run tests (from root dir)
==========

1) mvn test (Kicks off RunRegressionTest.java and @tag that is defined) 

2) mvn test -Dcucumber.options="--tags @tag" (Kicks off RunRegressionTest.Java but overrides @tag)

3) mvn test -Dbrowser.type="firefox" (Overrides the browser default option of chrome)

4) mvn test -Dbrowser.type="firefox" -Dcucumber.options="--tags @google" (Double override)



