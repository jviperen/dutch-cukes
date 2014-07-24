DutchCukes
==========

Dutch Gherkin Cucumber Project based on SharedDriver

Pleae use Cucumber as a collaboration tool and not just as a testing tool. Read following : https://cucumber.pro/blog/2014/03/03/the-worlds-most-misunderstood-collaboration-tool.html


How to run tests (from root dir)
==========

1) mvn test (Kicks off RunRegressionTest.java and @tag that is defined) 

2) mvn test -Dcucumber.options="--tags @tag" (Kicks off RunRegressionTest.Java but overrides @tag)

3) mvn test -Dbrowser.type="firefox" (Overrides the browser default option of chrome)

4) mvn test -Dbrowser.type="firefox" -Dcucumber.options="--tags @google" (Double override)



