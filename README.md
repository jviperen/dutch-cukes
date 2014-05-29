DutchCukes
==========

Dutch Gherkin Cucumber Project based on the jvm.cukes.parralel project


How to run tests (from root dir)
==========

1) mvn test (kicks off RunRegressionTest.java and @tag that is defined) 

2) mvn test -Dcucumber.options="--tags @tag" (kicks off RunRegressionTest.Java but overrides @tag)

3) mvn test -Dbrowser.type="chrome"
Overrides the browser default option of firefox



