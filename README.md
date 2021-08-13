# TestAug

This framework is still in progress, need more time to implement environment setup and other additional elements.

# what this have?

- Selenium - for web interaction
- junit5 - for assertion
- cucumber - as test runner 
- log4j - for logging
- sl4j - log binding dependencies

# How to execute?

this is a gradle project, in gradle.build task for cucumber has already been added.
task will take two inputs:
I) for the cucumber tags - this is for exclusive test case execution based on tag e.g: @web (triggered 
by gradle reserved keyword -P)
II) for environment capturing to setup stage or QA environment e.g: Dev (this is work in progress) (this will
be selected by java reserved keyword -D)

command that will be used to execute test cases define in feature files:

          gradle cucumber -Denv=dev -P tags=@web 

in above command we are instructing gradle to execute a task cucumber() and that task is getting input
for Env and tags

based on provided tags cucumber will only execute those test cases which are glued in the task cucubmer() 
that is further linked with step-definition and feature files

# Headless test execution

to execute test cases in headless mode just pass browserOption as true in WebSession constructor along with 
browser of choice (chrome or firefox)


# How test cases are developed?

in this some aspects of page object model has been used with flavor of BBD using cucumber.
under java/main we have PageLibrary that is basically the page object file for the
intended application main landing page

Page object (i.e. only search box in our case) and related methods/functions have been defined in same
under test/java we have composite class also known as parent class (StepDefinitions) currently this class
has only one child i.e. AllRecipeMainPage but if we had more pages their instance variable would have been called

along with child classes this will also call webdriver class from main/java to maintain webDriver session, logs.
we are using eventDriver therefore logs are embedded into it (see CustomWebDriverEventListener under src/java)

StepDefinition is using cucumber @before tags specific to type of test that was request, this is
for proper resource utilization, for example in case selenium is not required then we dont need to
initialize webdriver for that test case.

similarly @after is also specific to the tag that was requested to execute from gradle command

finally under test/java/resources we have feature files which are glued by cucumber task in build.gradle
this feature files are based on gherkins language and based on their tag and description they execute their
glued method defined in this associate step definition in this case StepDefinitions.class

# Report:

default cucumber reports are utilized here 

# Assertion:

Junit assertion were used to validate if system was able to find requested recipe


